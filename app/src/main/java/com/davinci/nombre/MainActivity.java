package com.davinci.nombre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Comparator;

//TODO NO SE ACEPTA UN CODIGO QUE NO COMPILE.
// Si el código crashea, esto va a afectar la nota
// Probar, probar, probar antes de finalizar.


//TODO El Modelo (Class) custom debe tener POR LO MENOS:
// Nombre, Año, Categoria, Poster y Descripcion (algún detalle largo).
// Se debe agregar uno mas a elección como mínimo.
// Las 3 primeras variables seran utilizadas para el Sort (usar el que mas gusten)
// Cuantas mas variables se agreguen y sumen a la app/visual, mas puntos
// puede sumar a la nota final.
public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter adapter;
    private ArrayList<Contactos<Integer>> contacto;

    private int orden = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacto = Utils.generarContactos();
        int grilla = 1;
        //TODO Cargar items en el array list con un Modelo (Class)
        // custom para mostrar en el RecyclerView.
        // Una vez llenada la lista (minimo 9 elementos) realizar un
        // sort de cualquier tipo: Sort A-Z, Sort 0-9, etc
        // Puede ser por el nombre, id, categoria, genero, año u otro
        // valor/variable que agreguen a su modelo.

        //TODO IMPORTANTE! El Modelo (Class) custom debe implementar
        // Serializable.


        // Verificar si el dispositivo esta en modo Horizontal == LANDSCAPE
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            grilla = 3;
        }

        // Verificar si el dispositivo es Tablet: res/values/bools.xml
        if (getResources().getBoolean(R.bool.tablet)) {
            grilla += 1;
        }
        RecyclerView recycler = findViewById(R.id.recyclerItems);


        //TODO Usar el otro constructor si se desea para incorporar la lista.
            adapter = new RecyclerAdapter<>(contacto);
            recycler.setAdapter(adapter);

        //TODO Usar una grilla (el otro Layout Manager) en vez de una lista.
        // Para pantalla vertical usar 2 elementos y para horizontal 3.
        // De ser tabelt, incrementar una unidad en ambos casos.
        recycler.setLayoutManager(new GridLayoutManager(this, grilla));

        //TODO Implementar un Intent Explicito que lleve a una pantalla detalle.
        // Tener en cuenta que el Object debe ser modificado por el verdadero
        // Modelo (Class) custom a utilizar.
        adapter.setItemClickListener(new RecyclerViewHolder.OnItemClickListener() {
            public void click(Contactos contacto) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("CONTACTOS", contacto);
                startActivity(intent);
            }
        });
        final FloatingActionButton fab = findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (orden) {
                    case 0: {
                        // Envia la lista nueva al adapter para que muestre los valores
                        // por año.
                        fab.setImageDrawable(getDrawable(R.drawable.sort_alphabetical));
                        ordenarAno();
                        orden = 1;
                        break;
                    }
                    case 1: {
                        // Envia la lista nueva al adapter para que muestre los valores
                        // por nombre.
                        fab.setImageDrawable(getDrawable(R.drawable.sort_variant));
                        ordenarNombre();
                        orden = 2;
                        break;
                    }
                    case 2: {
                        // Envio la lista original como fue cargada "a mano" para resetear
                        // su estado.
                        fab.setImageDrawable(getDrawable(R.drawable.sort_numeric));
                        adapter.setContactos(contacto);
                        orden = 0;
                        break;
                    }
                }
            }
        });
    }

    // Ordenar por año/lanzamiento. Tener en cuenta de usar Integer para
    // poder ordenar de manera sencilla.
    private void ordenarAno() {
        ArrayList<Contactos<Integer>> year = new ArrayList<>(contacto);
        Collections.sort(year, new Comparator<Contactos>() {
            @Override
            public int compare(Contactos contactos, Contactos t1) {
                return contactos.getAno().compareTo(t1.getAno());
            }
        });
        adapter.setContactos(year);
    }

    // Ordenar por nombre.
    private void ordenarNombre() {
        ArrayList<Contactos<Integer>> nombre = new ArrayList<>(contacto);
        Collections.sort(nombre, new Comparator<Contactos>() {
            @Override
            public int compare(Contactos contactos, Contactos t1) {
                return contactos.getNombre().compareToIgnoreCase(t1.getNombre());
            }
        });
        adapter.setContactos(nombre);
    }
}
