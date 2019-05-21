package com.davinci.nombre;

import java.util.ArrayList;

public class Utils {

    //TODO Ejmplo Objecto para lista de carga
    // Tener en cuenta la implementacion que acá falta en el ejemplo
    static  ArrayList<Contactos<Integer>> generarContactos(){
        ArrayList<Contactos<Integer>> contactos = new ArrayList<>();
        contactos.add((new Contactos<>(1, R.drawable.avatar_carlos, "Carlos",
                "pepsadsadfsdafsfdsafsdfsdfsd", 1994,38124388)));
        contactos.add((new Contactos<>(2, R.drawable.avatar_clara, "Clara",
                "pepsadsadfsdafsfdsafsdfsdfsd", 1998,40157715)));
        contactos.add(new Contactos<>(3, R.drawable.avatar_jorge, "Jorge",
                "sandufsjsdfuhdsfiudsfdsfsdf" , 2001, 50147258));
        contactos.add((new Contactos<>(4,R.drawable.avatar_luis, "Alberto",
                "dsadsdafdfsdfsdafhksdbfksda", 1847, 3535354)));
        contactos.add((new Contactos<>(5,R.drawable.avatar_maricel, "Maricel",
                "dsadsdafdfsdfsdafhksdbfksda", 1985, 3535354)));
        contactos.add((new Contactos<>(6,R.drawable.avatar_patricio, "Patricio",
                "dsadsdafdfsdfsdafhksdbfksda", 1850, 3535354)));
        contactos.add((new Contactos<>(7,R.drawable.avatar_paula, "Paula",
                "dsadsdafdfsdfsdafhksdbfksda", 1993, 3535354)));
        contactos.add((new Contactos<>(8,R.drawable.avatar_roberto, "Roberto",
                "dsadsdafdfsdfsdafhksdbfksda", 1997, 3535354)));
        contactos.add((new Contactos<>(9,R.drawable.avatar_soledad, "Soledad",
                "dsadsdafdfsdfsdafhksdbfksda", 2019, 3535354)));



        return  contactos;
    }

//    static  ArrayList<Contactos<Integer>> generarContactosFiltrado(Contactos contactos){
//        ArrayList<Contactos<Integer>> filtro = new ArrayList<>();
//        for(Contactos<Integer> item : generarContactos()){
//            if (!contactos.getId().equals((item.getId()))) {
//                filtro.add(item);
//            }
//        }
//        return filtro;
//    }




    //TODO Saber si es tablet o no.
    //public static boolean isTablet(Context context) {
    //    return context.getResources().getBoolean(R.bool.tablet);
    //}

    //TODO Saber si el dispositivo esta en landscape o no.
    //public static boolean isLandscape(Context context) {
    //    return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    //}

    }

