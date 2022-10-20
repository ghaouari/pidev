/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entites.Admin;

import Utils.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ControlLogin {

    static Statement st;
    static String type;

    public static boolean isLogin(Admin A) {

        try {

            st = ConnectionDB.openConnection().createStatement();
            System.out.println("connecte a base de donne :    " + st);
            String check = "select * from admin where mail ='" + A.getMail() + "' and password = '" + A.getPassword()
                    + "'";
            ResultSet result = st.executeQuery(check);
            while (result.next()) {
                type = result.getString(1);
                return true;
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            System.out.println("hi" + ex.getMessage());
        }

        return false;
    }

    public String recherche_login(Admin A) {

        try {

            st = ConnectionDB.openConnection().createStatement();

            String check = "select * from admin where mail ='" + A.getMail() + "'";
            ResultSet result = st.executeQuery(check);
            while (result.next()) {

                String password = result.getString("password");
                return password;
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            System.out.println("hi" + ex.getMessage());
        }

        return null;
    }

}
