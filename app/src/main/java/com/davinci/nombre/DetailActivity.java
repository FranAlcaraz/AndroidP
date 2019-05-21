package com.davinci.nombre;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Objects;

//TODO Declarar Activity en el Manifest
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Contactos contactos = (Contactos) (getIntent().getExtras()).getSerializable("CONTACTOS");


        ImageView imagen =findViewById(R.id.imagen);
        Glide.with(this).load(contactos.getImagenUrl()).into(imagen);

        TextView nombre = findViewById(R.id.nombre);
        nombre.setText(contactos.getNombre());


        TextView ano = findViewById(R.id.ano);
        ano.setText(String.valueOf(contactos.getAno()));

        TextView texto = findViewById(R.id.texto);
        texto.setText(contactos.getTexto());

        //TODO Usar un ScrollView o NestedScrollView para mostrar los elementos.

        //TODO Puntos adicionales por el uso de un Intent Implicito.
        // no afecta a la nota el no hacerlo.

        //TODO Muchos puntos adicionales si lograr incorporar un RecyclerView
        // dentro de un NestedScrollView. No es necesario, es solo si tienen
        // el tiempo, las ganas y el conocimiento. No afecta a la nota el no
        // hacerlo.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
