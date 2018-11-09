/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectomvc.dao;

import com.proyectomvc.connect.pgConnect;
import com.proyectomvc.model.mensajeModel;
import com.proyectomvc.model.usuarioModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class mensajeDao {

    public static List<mensajeModel> getMensaje() {
        List<mensajeModel> listMensaje = new ArrayList();
        // TODO code application logic here

        try {
            pgConnect connectPG = new pgConnect();
            try (Connection conex = connectPG.settingConnect(); java.sql.Statement st = conex.createStatement()) {

                String sql = "SELECT iduser,mensaje, fecha, duracion	FROM mensaje;";
                try (ResultSet result = st.executeQuery(sql)) {
                    while (result.next()) {
                        usuarioModel iduser = usuarioDao.getUsuariobYId(result.getString("iduser"));
                        String mensaje = result.getString("mensaje");
                        String fecha = result.getString("fecha");
                        int duracion = result.getInt("duracion");                      

                        mensajeModel persona = new mensajeModel(iduser, mensaje, fecha,duracion);
                        listMensaje.add(persona);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
            mensajeModel mensajes = new mensajeModel(null,"Error no se pudo hacer la consulta SQL", null, 0);
            listMensaje.add(mensajes);
        }

        return listMensaje;
    }
       
    public static void setMensaje(mensajeModel mensaje) {
        // TODO code application logic here

        try {
            pgConnect connectPG = new pgConnect();
            try (Connection conex = connectPG.settingConnect(); java.sql.Statement st = conex.createStatement()) {

                String sql = "INSERT INTO public.mensaje(iduser, mensaje, fecha, duracion) VALUES ("+mensaje.getIduser()+",'" + mensaje.getMensaje()+ "', '" + mensaje.getFecha()+ "', " + mensaje.getDuracion()+ ")";
                System.out.println(sql);
                ResultSet result = st.executeQuery(sql);
                result.close();
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }

    }
}
