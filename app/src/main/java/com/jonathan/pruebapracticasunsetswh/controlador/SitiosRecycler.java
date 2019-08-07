package com.jonathan.pruebapracticasunsetswh.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.jonathan.pruebapracticasunsetswh.R;
import com.jonathan.pruebapracticasunsetswh.adaptador.SitiosAdaptador;
import com.jonathan.pruebapracticasunsetswh.modelo.Sitios;

import java.util.List;

public class SitiosRecycler extends AppCompatActivity {

    //variables
    RecyclerView recyclerView;
    List<Sitios> sitiosList;
    SitiosAdaptador sitiosAdaptador;
    SitiosAdaptador.IAdapterRecylcerSitios click;
    SitiosAdaptador.IAdapterRecylcerSitiosVer ver;
    String idJona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_recycler);

        //Recibe los parametros que se enviaron de la anterior actividad
        Bundle idUsuario = getIntent().getExtras();
        idJona = idUsuario.getString("idZona");


        referenciar();
        eventoClickRecycler();
        eventoVerRecycler();
        inflarRecycler();
    }

    private void inflarRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        sitiosList  = Sitios.findWithQuery(Sitios.class, "Select * from SITIOS where ID_ZONA = ?", idJona);
        sitiosAdaptador = new SitiosAdaptador(SitiosRecycler.this, sitiosList,click, ver);
        recyclerView.setAdapter(sitiosAdaptador);
    }

    private void eventoVerRecycler() {
        ver = new SitiosAdaptador.IAdapterRecylcerSitiosVer() {
            @Override
            public void clickItem(Sitios item) {
                Toast.makeText(SitiosRecycler.this, "+"+item.getName(), Toast.LENGTH_SHORT).show();

            }
        };
    }

    private void eventoClickRecycler() {

        click = new SitiosAdaptador.IAdapterRecylcerSitios() {
            @Override
            public void clickItem(Sitios item) {
                Toast.makeText(SitiosRecycler.this, "+"+item.getLat(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void referenciar() {
        recyclerView = findViewById(R.id.recyclerListarSitios);
    }
}
