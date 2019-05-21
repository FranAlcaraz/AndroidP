package com.davinci.nombre;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<Contactos<T>> contactos;


    //TODO Recordar cambiar por el Modelo (Class) custom correcto.

    private RecyclerViewHolder.OnItemClickListener itemClickListener;

    public RecyclerAdapter(){

    }
    //TODO Constructor adicional de ser necesario
    public RecyclerAdapter(ArrayList<Contactos<T>> contactos) {
        this.contactos = contactos;

    }

    //TODO Metodo auxiliar de ser necesario
    public void setContactos(ArrayList<Contactos<T>> contactos) {
        this.contactos = contactos;
        notifyDataSetChanged();
    }

    public void setItemClickListener(RecyclerViewHolder.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder RecyclerViewHolder, int position) {
        //TODO Pasar el valor correcto del ArrayList en vez de solo la posicion.
        RecyclerViewHolder.cargarElemento(contactos.get(position), itemClickListener);

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }





}
