package com.jonathan.pruebapracticasunsetswh.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.pruebapracticasunsetswh.R;
import com.jonathan.pruebapracticasunsetswh.modelo.Zonas;

import java.util.List;

public class ZonasAdaptador extends RecyclerView.Adapter<ZonasAdaptador.ZonasViewHolder>{

    List<Zonas> zonasList;
    Context context;
    IAdapterRecylcer click;

    public ZonasAdaptador( Context context, List<Zonas> zonasList, IAdapterRecylcer click  ) {
        this.zonasList = zonasList;
        this.context = context;
        this.click = click;
    }

    @NonNull
    @Override
    public ZonasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ZonasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.zona_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ZonasViewHolder holder, final int position) {
        holder.setData(zonasList.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.clickItem(zonasList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return zonasList.size();
    }

    public static class ZonasViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre;
        TextView txtDesc;
        Zonas item;
        View layout;

        public ZonasViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView;
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }

        public void setData(Zonas item) {
            this.item = item;
            /*Aquí usamos las propiedades del modelo de datos*/
            txtNombre.setText(item.getName());
            txtDesc.setText(item.getDesc());
        }

    }

    public void swap(List<Zonas> newList){
        zonasList.clear();
        zonasList.addAll(newList);
        notifyDataSetChanged();
    }

    public interface IAdapterRecylcer{
        void clickItem(Zonas item);
    }
}
