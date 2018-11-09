package com.proyectomvc.model;

import java.sql.Date;

/**
 *
 */
public class mensajeModel {

    private usuarioModel iduser;
    private String mensaje;
    private String fecha;
    private int duracion;

    public mensajeModel(usuarioModel iduser, String mensaje, String fecha, int duracion) {
        this.iduser = iduser;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public usuarioModel getIduser() {
        return iduser;
    }

    public void setIduser(usuarioModel iduser) {
        this.iduser = iduser;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
