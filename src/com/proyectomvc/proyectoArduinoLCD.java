package com.proyectomvc;

import com.proyectoArduinoLCD.viw.JInterface;
import com.proyectomvc.dao.mensajeDao;
import com.proyectomvc.dao.usuarioDao;
import com.proyectomvc.model.mensajeModel;
import com.proyectomvc.model.usuarioModel;
import java.util.List;

/**
 *
 * @author oscar
 */
public class proyectoArduinoLCD {

    public static void main(String[] args) {

         JInterface fin1 = new JInterface();
       fin1.setVisible(true);
        
        
        
       // usuarioModel usuario = new usuarioModel(4, "Lusito", 103, 555, "abcABD123");
//        mensajeModel msj = new mensajeModel(12, "HOY NO HAY CLASES", "Agosto", 20);
//       // usuarioDao.setUsuario(usuario);
//        mensajeDao.setMensaje(msj);
//
//        List<usuarioModel> lusuario = usuarioDao.getUsuario();
//        for (int i = 0; i < lusuario.size(); i++) {
//            System.out.println("-------");
//            System.out.println("ID: " + lusuario.get(i).getIduser());
//
//            System.out.println("Nombre: " + lusuario.get(i).getNombre());
//            System.out.println("Telefono: " + lusuario.get(i).getTelefono());
//            System.out.println("ID: " + lusuario.get(i).getIdentificacion());
//            System.out.println("Contraseña: " + lusuario.get(i).getPassword());
//
//        }
    }

}
