package com.davinci.nombre;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

 class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnItemClickListener itemClickListener;

    private ImageView imagen;
    private TextView nombre;

    private Contactos contactos;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        imagen = itemView.findViewById(R.id.imagen);
        nombre = itemView.findViewById(R.id.nombre);
        itemView.setOnClickListener(this);
    }

    void cargarElemento(Contactos contactos, OnItemClickListener itemClickListener){
        this.contactos = contactos;
        this.itemClickListener = itemClickListener;

        Glide.with(itemView.getContext())
                .load(contactos.getImagenUrl())
                .into(imagen);
        nombre.setText(contactos.getNombre());
    }

    @Override
    public void onClick(View view) {
        if(itemClickListener != null){
            itemClickListener.click(contactos);
        }
    }

    interface OnItemClickListener{
        void click(Contactos contactos);
    }
}
