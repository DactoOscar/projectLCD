package com.proyectomvc.model;

/**
 *
 */
public class usuarioModel  {

    //datos basicos de un login
    private String iduser;
    private String nombre;
    private int telefono;
    private int identificacion;
    protected String password;

    public usuarioModel(String iduser, String nombre, int telefono, int identificacion, String password) {
        this.iduser = iduser;
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.password = password;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


  
   

   

}
