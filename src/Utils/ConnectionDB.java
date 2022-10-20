/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectionDB {

    private static Connection con;
    private static String url = "jdbc:mysql://localhost/rapidservice1";

    private ConnectionDB() {

    }

    public static Connection openConnection() {
        if (con == null) {
            try {
                con = (Connection) DriverManager.getConnection(url, "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    public static void closeConnection() {
        if (con != null)
            con = null;
    }
}
