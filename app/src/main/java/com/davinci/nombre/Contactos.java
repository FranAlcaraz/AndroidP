package com.davinci.nombre;

import java.io.Serializable;

public class Contactos<T> implements Serializable {

    private Integer id;
    private T imagenUrl;
    private String nombre;
    private String texto;
    private Integer ano;
    private Integer identificacion;

    public Contactos(Integer id, T imagenUrl, String nombre, String texto, Integer ano, Integer identificacion) {
        this.id = id;
        this.imagenUrl = imagenUrl;
        this.nombre = nombre;
        this.texto = texto;
        this.ano = ano;
        this.identificacion = identificacion;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(T imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }
}
