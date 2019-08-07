package com.jonathan.pruebapracticasunsetswh.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonathan.pruebapracticasunsetswh.R;
import com.jonathan.pruebapracticasunsetswh.adaptador.ZonasAdaptador;
import com.jonathan.pruebapracticasunsetswh.interfaces.IZonas;
import com.jonathan.pruebapracticasunsetswh.modelo.ElementoZonas;
import com.jonathan.pruebapracticasunsetswh.modelo.Sitios;
import com.jonathan.pruebapracticasunsetswh.modelo.Zonas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZonasRecycler extends AppCompatActivity {

    //variables
    RecyclerView recyclerView;
    List<Zonas> zonasList;
    ZonasAdaptador zonasAdaptador;
    ZonasAdaptador.IAdapterRecylcer click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenciar();
        eventoClickRecycler();
        inflarRecycler();
        cargarJson();
    }

    private void eventoClickRecycler() {
        click = new ZonasAdaptador.IAdapterRecylcer() {
            @Override
            public void clickItem(Zonas item) {
                Intent intent = new Intent(ZonasRecycler.this, SitiosRecycler.class);
                long idst = item.getIdStation();
                String idzon = String.valueOf(idst);
                intent.putExtra("idZona", idzon);
                startActivity(intent);
            }
        };
    }

    private void cargarJson() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.encicla.gov.co")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        IZonas restIZOnas = retrofit.create(IZonas.class);
        Call<ElementoZonas> call = restIZOnas.getZonas();
       call.enqueue(new Callback<ElementoZonas>() {
           @Override
           public void onResponse(Call<ElementoZonas> call, Response<ElementoZonas> response) {
               ElementoZonas elementoZonas = response.body();
               long contador = Zonas.count(Zonas.class,null, null);
               if(contador == 0) {
                   if (elementoZonas != null) {
                       for (ElementoZonas.stations x : elementoZonas.stations) {

                           Zonas zonasAdd = new Zonas();
                           zonasAdd.setIdStation(x.idStation);
                           zonasAdd.setName(x.name);
                           zonasAdd.setDesc(x.desc);
                           zonasAdd.save();

                           for (ElementoZonas.stations.items z : x.items) {

                               Sitios ubicacionesAdd = new Sitios();
                               ubicacionesAdd.setIdSitio(z.idSitio);
                               ubicacionesAdd.setOrderSitio(z.orderSitio);
                               ubicacionesAdd.setName(z.name);
                               ubicacionesAdd.setAddress(z.address);
                               ubicacionesAdd.setDescription(z.description);
                               ubicacionesAdd.setLat(z.lat);
                               ubicacionesAdd.setLon(z.lon);
                               ubicacionesAdd.setType(z.type);
                               ubicacionesAdd.setCapacity(z.capacity);
                               ubicacionesAdd.setBikes(z.bikes);
                               ubicacionesAdd.setPlaces(z.places);
                               ubicacionesAdd.setPicture(z.picture);
                               ubicacionesAdd.setBikesState(z.bikesState);
                               ubicacionesAdd.setPlacesState(z.placesState);
                               ubicacionesAdd.setClosed(z.closed);
                               ubicacionesAdd.setCdo(z.cdo);
                               int idEstacion = (int) x.idStation;
                               ubicacionesAdd.setIdZona(idEstacion);
                               ubicacionesAdd.save();
                           }
                           zonasAdaptador.notifyDataSetChanged();
                           Toast.makeText(ZonasRecycler.this, "DATOS GUARDADOS", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(ZonasRecycler.this, "NO OBTUVO LOS DATOS", Toast.LENGTH_SHORT).show();
                   }
               }
           }

           @Override
           public void onFailure(Call<ElementoZonas> call, Throwable t) {

           }
       });

    }


    private void inflarRecycler() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        zonasList  = Zonas.listAll(Zonas.class);
        zonasAdaptador = new ZonasAdaptador(ZonasRecycler.this, zonasList,click);
        recyclerView.setAdapter(zonasAdaptador);
    }

    private void referenciar() {
        recyclerView = findViewById(R.id.recyclerListar);
    }
}
