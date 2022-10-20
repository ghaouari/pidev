package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Entites.client;
import Entites.prestataire;
import Services.ServicesClient;
import Services.ServicesPrestataire;
import Utils.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class Controller_admin implements Initializable {

    @FXML
    private TableView<client> ClientTable;

    @FXML
    private TableColumn<client, Integer> idc;

    @FXML
    private TableColumn<client, String> loginc;
    @FXML
    private TableColumn<client, String> villec;

    @FXML
    private TableColumn<client, String> nomc;

    @FXML
    private TableColumn<client, String> prenomc;

    @FXML
    private TableColumn<client, String> telc;

    @FXML
    private TableView<prestataire> UserTable;
    @FXML
    private TableColumn<prestataire, Integer> id;

    @FXML
    private TableColumn<prestataire, String> exp;

    @FXML
    private TableColumn<prestataire, String> login;

    @FXML
    private TableColumn<prestataire, String> ville;

    @FXML
    private TableColumn<prestataire, String> nom;

    @FXML
    private TableColumn<prestataire, String> nom_sv;

    @FXML
    private TableColumn<prestataire, String> prenom;

    @FXML
    private TableColumn<prestataire, String> tel;

    @FXML
    private TableColumn<prestataire, String> type_sv;

    @FXML
    private TextField exp_user;

    @FXML
    private TextField id_client;

    @FXML
    private TextField id_user;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatus1;

    @FXML
    private TextField login_client;

    @FXML
    private TextField login_user;

    @FXML
    private TextField nom_client;

    @FXML
    private TextField nom_serv_user;

    @FXML
    private TextField nom_user;

    @FXML
    private TextField password1_client;

    @FXML
    private TextField password1_user;

    @FXML
    private TextField password_client;

    @FXML
    private TextField password_user;

    @FXML
    private TextField prenom_client;

    @FXML
    private TextField prenom_user;

    @FXML
    private TextField ville_client;

    @FXML
    private TextField ville_user;

    @FXML
    private TextField tel_client;

    @FXML
    private TextField tel_user;

    @FXML
    private TextField type_serv_user;

    @FXML
    private Button update_client;

    @FXML
    private Button update_user;

    @FXML
    private Button delete_client;

    @FXML
    private Button delete_user;

    @FXML
    private Button search_client;

    @FXML
    private Button search_user;

    @FXML
    private Button insert_client;

    @FXML
    private Button insert_user;

    Connection connection = (Connection) ConnectionDB.openConnection();
    prestataire prestataire = new prestataire();
    client client = new client();
    ObservableList<prestataire> prestataireList = FXCollections.observableArrayList();
    ObservableList<client> clientList = FXCollections.observableArrayList();
    String query, sql;
    ServicesClient Sclient;
    ServicesPrestataire Sprest;
    ResultSet resultSet;
    Statement stmt;

    @FXML
    void delete_client(ActionEvent event) {
        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {
            String sql;
            sql = "delete from client where mail ='" + login_client.getText() + "'";
            int result = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Record deleted sucessfully");
            login_client.setText(null);
            id_client.setText(null);
            nom_client.setText(null);
            prenom_client.setText(null);
            ville_client.setText(null);
            tel_client.setText(null);
            password_client.setText(null);
            password1_client.setText(null);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to delete record " + e.getMessage());
        }

    }

    @FXML
    void delete_user(ActionEvent event) {

        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {
            String sql;
            sql = "delete from prestataire where mail ='" + login_user.getText() + "'";
            int result = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Record deleted sucessfully");
            login_user.setText(null);
            id_user.setText(null);
            nom_user.setText(null);
            prenom_user.setText(null);
            ville_user.setText(null);
            tel_user.setText(null);
            exp_user.setText(null);
            nom_serv_user.setText(null);
            type_serv_user.setText(null);
            password_user.setText(null);
            password1_user.setText(null);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to delete record " + e.getMessage());
        }

    }

    @FXML
    void insert_client(ActionEvent event) {
        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {

            String sql;
            sql = "select * from client where mail ='" + login_client.getText() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (!(rs.next())) {

                try {
                    String sql1;
                    sql1 = "insert into client(`nom`, `prenom`, `ville`, `tel`, `mail`, `password`) values ("
                            + "'" + nom_client.getText() + "',"
                            + "'" + prenom_client.getText() + "',"
                            + "'" + ville_client.getText() + "',"

                            + "'" + tel_client.getText() + "',"
                            + "'" + login_client.getText() + "',"

                            + "'" + password_client.getText()
                            + "')";

                    int result = stmt.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(null, "Client saved sucessfully ");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Unable to insert record " + e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "client deja ");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to insert record " + e.getMessage());
        }

    }

    @FXML
    void insert_user(ActionEvent event) {
        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {
            String sql;
            sql = "select * from prestataire where mail ='" + login_user.getText() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (!(rs.next())) {
                try {

                    String sql1;
                    sql1 = "insert into prestataire(`nom`, `prenom`, `ville`, `tel`, `mail`, `password`, `experience`, `nomService`, `typeService`) values ("
                            + "'" + nom_user.getText() + "',"
                            + "'" + prenom_user.getText() + "',"
                            + "'" + ville_user.getText() + "',"
                            + "'" + tel_user.getText() + "',"
                            + "'" + login_user.getText() + "',"
                            + "'" + password_user.getText() + "',"
                            + "'" + exp_user.getText() + "',"
                            + "'" + nom_serv_user.getText() + "',"
                            + "'" + type_serv_user.getText()
                            + "')";

                    int result = stmt.executeUpdate(sql1);

                    JOptionPane.showMessageDialog(null, "user saved sucessfully 1 ");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Unable to insert 1 user " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "user deja ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "unable to retrieve user " + e.getMessage());
        }

    }

    @FXML
    void update_client(ActionEvent event) {

        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        System.out.println("okkkkkk");
        try {

            sql = "UPDATE client set mail='" + login_client.getText() + "',"
                    + "nom='" + nom_client.getText() + "',"
                    + "prenom='" + prenom_client.getText() + "',"
                    + "ville='" + ville_client.getText() + "',"
                    + "tel='" + tel_client.getText() + "',"

                    + "password='" + password_client.getText() + "'"

                    + " WHERE mail='" + login_client.getText() + "'";

            int result = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Record updated sucessfully");
        } catch (SQLException f) {
            JOptionPane.showMessageDialog(null, "Unable to update record " + f.getMessage());
        }

    }

    @FXML
    void update_user(ActionEvent event) {
        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {

            sql = "UPDATE prestataire set mail='" + login_user.getText() + "',"
                    + "nom='" + nom_user.getText() + "',"
                    + "prenom='" + prenom_user.getText() + "',"
                    + "ville='" + ville_user.getText() + "',"
                    + "tel='" + tel_user.getText() + "',"
                    + "experience='" + exp_user.getText() + "',"
                    + "nomService='" + nom_serv_user.getText() + "',"
                    + "typeService='" + type_serv_user.getText() + "',"
                    + "password='" + password_client.getText() + "'"

                    + " WHERE mail='" + login_user.getText() + "'";

            int result = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Record updated sucessfully");
        } catch (SQLException f) {
            JOptionPane.showMessageDialog(null, "Unable to update record " + f.getMessage());
        }

    }

    @FXML
    void search_client(ActionEvent event) {

        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {
            String sql;
            sql = "select * from client where id_client='"
                    + id_client.getText() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                login_client.setText(rs.getString("mail"));
                id_client.setText(rs.getString("id_client"));
                nom_client.setText(rs.getString("nom"));
                prenom_client.setText(rs.getString("prenom"));
                ville_client.setText(rs.getString("ville"));
                tel_client.setText(rs.getString("tel"));
                password_client.setText(rs.getString("password"));
                password1_client.setText(rs.getString("password"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve record " + e.getMessage());
        }
    }

    @FXML
    void search_user(ActionEvent event) {

        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }

        try {

            sql = "select *  from prestataire where id_Prestataire='" + id_user.getText() + "'";
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                login_user.setText(resultSet.getString("mail"));
                id_user.setText(resultSet.getString("id_Prestataire"));
                nom_user.setText(resultSet.getString("nom"));
                prenom_user.setText(resultSet.getString("prenom"));
                ville_user.setText(resultSet.getString("ville"));
                tel_user.setText(resultSet.getString("tel"));
                exp_user.setText(resultSet.getString("experience"));
                nom_serv_user.setText(resultSet.getString("nomService"));
                type_serv_user.setText(resultSet.getString("typeService"));
                password_user.setText(resultSet.getString("password"));
                password1_user.setText(resultSet.getString("password"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve record " + e.getMessage());
        }

    }

    @FXML
    void refreshTable_c() {
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
                ClientTable.setItems(clientList);

            }

        } catch (SQLException ex) {
            // Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null,
            // ex);
            JOptionPane.showMessageDialog(null, " list  " + ex.getMessage());

        }

    }

    private void loadDate_c() {

        refreshTable_c();

        idc.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        loginc.setCellValueFactory(new PropertyValueFactory<>("mail"));
        nomc.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomc.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        villec.setCellValueFactory(new PropertyValueFactory<>("ville"));
        telc.setCellValueFactory(new PropertyValueFactory<>("tel"));

        ClientTable.setItems(clientList);

    }

    @FXML
    void refreshTable() {
        try {
            prestataireList.clear();

            query = "SELECT * FROM `prestataire`";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                prestataireList.add(new prestataire(

                        resultSet.getInt("id_Prestataire"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("ville"),
                        resultSet.getString("tel"),
                        resultSet.getString("mail"),
                        resultSet.getString("password"),
                        resultSet.getString("experience"),
                        resultSet.getString("nomService"),
                        resultSet.getString("typeService")));
                UserTable.setItems(prestataireList);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " list  " + ex.getMessage());

        }
    }

    private void loadDate_p() {

        refreshTable();

        id.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        login.setCellValueFactory(new PropertyValueFactory<>("mail"));
        exp.setCellValueFactory(new PropertyValueFactory<>("experience"));
        nom_sv.setCellValueFactory(new PropertyValueFactory<>("nomService"));
        type_sv.setCellValueFactory(new PropertyValueFactory<>("typeService"));

        UserTable.setItems(prestataireList);

    }

    @FXML
    void Tableclicked_client(MouseEvent event) {

        client client = ClientTable.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM `client` where id_client = '" + client.getId_client() + "'";

        try {
            Statement stmt = (Statement) connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {

                login_client.setText(resultSet.getString("mail"));

                id_client.setText(resultSet.getString("id_client"));
                nom_client.setText(resultSet.getString("nom"));
                prenom_client.setText(resultSet.getString("prenom"));
                ville_client.setText(resultSet.getString("ville"));
                tel_client.setText(resultSet.getString("tel"));
                password_client.setText(resultSet.getString("password"));
                password1_client.setText(resultSet.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Tableclicked_user(MouseEvent event) {
        prestataire prestataire = UserTable.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM `prestataire` where id_Prestataire = '" + prestataire.getId_Prestataire() + "'";

        try {
            Statement stmt = (Statement) connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {

                login_user.setText(resultSet.getString("mail"));
                id_user.setText(resultSet.getString("id_Prestataire"));
                nom_user.setText(resultSet.getString("nom"));
                prenom_user.setText(resultSet.getString("prenom"));
                ville_user.setText(resultSet.getString("ville"));
                tel_user.setText(resultSet.getString("tel"));
                exp_user.setText(resultSet.getString("experience"));
                nom_serv_user.setText(resultSet.getString("nomService"));
                type_serv_user.setText(resultSet.getString("typeService"));
                password_user.setText(resultSet.getString("password"));
                password1_user.setText(resultSet.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadDate_c();
        loadDate_p();
    }

}
