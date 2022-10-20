package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Entites.client;
import Utils.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicesClient {
    Connection connection = (Connection) ConnectionDB.openConnection();
    client client = new client();
    ObservableList<client> clientList = FXCollections.observableArrayList();
    String query;

    public void refreshTable(client c) {
        try {
            clientList.clear();

            query = "SELECT * FROM `client`";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                clientList.add(new client(

                        resultSet.getInt("id_client"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("ville"),
                        resultSet.getString("tel"),
                        resultSet.getString("mail"),
                        resultSet.getString("password")));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " list  " + ex.getMessage());

        }

    }

}
