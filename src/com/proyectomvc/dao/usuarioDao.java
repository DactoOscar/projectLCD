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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class usuarioDao {

    public static List<usuarioModel> getUsuario() {
        List<usuarioModel> listUsuario = new ArrayList();
        // TODO code application logic here

        try {
            pgConnect connectPG = new pgConnect();
            try (Connection conex = connectPG.settingConnect(); java.sql.Statement st = conex.createStatement()) {

                String sql = "SELECT iduser, nombre, telefono, identificacion, contraseña FROM usuario";
                try (ResultSet result = st.executeQuery(sql)) {
                    while (result.next()) {
                        String iduser = result.getString("iduser");
                        String nombre = result.getString("nombre");
                        int telefono = result.getInt("telefono");
                        int identificacion = result.getInt("identificacion");
                        String password = result.getString("contraseña");
                        usuarioModel user = new usuarioModel(iduser, nombre, telefono, identificacion, password);
                        listUsuario.add(user);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
            usuarioModel user = new usuarioModel("No se recibio ningún dato ","Error no se pudo hacer la consulta SQL", 0, 0,"Error no se pudo hacer la consulta SQL");
            listUsuario.add(user);
        }

        return listUsuario;
    }
    public static String[][] getUsuariosToTable(){
             List<usuarioModel> listaUsuarios = getUsuario();
             String ArrayTable[][]= new String [listaUsuarios.size()][5];
             for(int i=0; i< listaUsuarios.size();i++ ){
                 
                ArrayTable[i][0]=String.valueOf(listaUsuarios.get(i).getIduser());
                ArrayTable[i][1]=listaUsuarios.get(i).getNombre();                
                ArrayTable[i][2]=String.valueOf(listaUsuarios.get(i).getTelefono());
                ArrayTable[i][3]=String.valueOf(listaUsuarios.get(i).getIdentificacion());
                ArrayTable[i][4]=(listaUsuarios.get(i).getPassword());
              }
             return ArrayTable;
      
        }


    

    public static usuarioModel getUsuariobYId(String id) {
      
        try {
            pgConnect connectPG = new pgConnect();
            try (Connection conex = connectPG.settingConnect(); java.sql.Statement st = conex.createStatement()) {

                String sql = "SELECT iduser, nombre, telefono, identificacion, contraseña FROM usuario where iduser='"+id+"'";
                try (ResultSet result = st.executeQuery(sql)) {
                    while (result.next()) {
                        String iduser = result.getString("iduser");
                        String nombre = result.getString("nombre");
                        int telefono = result.getInt("telefono");
                        int identificacion = result.getInt("identificacion");
                        String password = result.getString("contraseña");
                        usuarioModel user = new usuarioModel(iduser, nombre, telefono, identificacion, password);
                        return user;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
            usuarioModel user = new usuarioModel("No se recibio ningún dato ","Error no se pudo hacer la consulta SQL", 0, 0,"Error no se pudo hacer la consulta SQL");
            return user;
        }

        return null;
    }
    public static void setUsuario(usuarioModel usuario) {
        // TODO code application logic here

        try {
            pgConnect connectPG = new pgConnect();
            try (Connection conex = connectPG.settingConnect(); java.sql.Statement st = conex.createStatement()) {

                String sql = "INSERT INTO public.usuario(iduser, nombre, telefono, identificacion,contraseña) VALUES ('" + usuario.getIduser()+ "', '" + usuario.getNombre()+ "', " + usuario.getTelefono() + ", " + usuario.getIdentificacion()+ ", '" + usuario.getPassword()+ "')";
                System.out.println(sql);
                ResultSet result = st.executeQuery(sql);
                result.close();
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }

    }
}
