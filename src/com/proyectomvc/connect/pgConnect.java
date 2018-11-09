
package com.proyectomvc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author estudiante
 */

public class pgConnect {

    public pgConnect(){}

    public Connection settingConnect() throws ClassNotFoundException, SQLException {
        String cadena = "jdbc:postgresql://localhost:5432/arduinoLCD";
        String user = "postgres";
        String pass = "desa4361";
        Class.forName("org.postgresql.Driver");
        Connection conex = DriverManager.getConnection(cadena, user, pass);
        return conex;
    }

}
