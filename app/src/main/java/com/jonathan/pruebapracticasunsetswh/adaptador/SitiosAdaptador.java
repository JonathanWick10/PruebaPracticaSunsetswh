package com.jonathan.pruebapracticasunsetswh.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.pruebapracticasunsetswh.R;
import com.jonathan.pruebapracticasunsetswh.modelo.Sitios;

import java.util.List;

public class SitiosAdaptador extends RecyclerView.Adapter<SitiosAdaptador.SitiosViewHolder> {

    //variables
    List<Sitios> sitiosList;
    Context context;
    IAdapterRecylcerSitios click;
    IAdapterRecylcerSitiosVer ver;

    public SitiosAdaptador(Context context,List<Sitios> sitiosList, IAdapterRecylcerSitios click, IAdapterRecylcerSitiosVer ver) {
        this.sitiosList = sitiosList;
        this.context = context;
        this.click = click;
        this.ver = ver;
    }

    @NonNull
    @Override
    public SitiosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SitiosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sitio_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SitiosViewHolder holder, final int position) {

        holder.setData(sitiosList.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.clickItem(sitiosList.get(position));
            }
        });
        holder.imgVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.clickItem(sitiosList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sitiosList.size();
    }

    public static class SitiosViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombreSitio;
        TextView txtDescSitio;
        ImageView imgVer;
        Sitios item;
        View layout;

        public SitiosViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            txtNombreSitio = itemView.findViewById(R.id.txtNombreSitio);
            txtDescSitio = itemView.findViewById(R.id.txtDescSitio);
            imgVer = itemView.findViewById(R.id.imgVer);
        }

        public void setData(Sitios item) {
            this.item = item;
            /*Aquí usamos las propiedades del modelo de datos*/
            txtNombreSitio.setText(item.getName());
            txtDescSitio.setText(item.getDescription());
        }
    }

    public interface IAdapterRecylcerSitios{
        void clickItem(Sitios item);
    }

    public interface IAdapterRecylcerSitiosVer{
        void clickItem(Sitios item);
    }
}
