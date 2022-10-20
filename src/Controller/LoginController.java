package Controller;

import java.io.IOException;
import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import com.oracle.webservices.internal.api.message.MessageContext;

import Entites.Admin;
import Entites.email;
import Services.ControlLogin;
import Services.mail;
import Utils.ConnectionDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button connecte;

    @FXML
    private TextField login;

    @FXML
    private Hyperlink mail_oublie;

    @FXML
    private TextField password;

    @FXML
    private Label loginmessage;

    @FXML
    private Label passwordmessage;

    Admin admin = new Admin();
    ControlLogin pc = new ControlLogin();
    email mail = new email();
    mail email = new mail();

    @FXML
    void Login(ActionEvent event) throws IOException {

        admin.setMail(login.getText());
        admin.setPassword(password.getText());
        // Contrôle de saisie username
        if ((login.getText().length() == 0)) {

            login.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(login).play();

        } else
            login.setStyle(null);
        // Contrôle de saisie Password

        if ((password.getText().length() == 0)) {

            password.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(password).play();

        } else
            password.setStyle(null);

        if (pc.isLogin(admin)) {
            System.out.println("login valide");

            root = FXMLLoader.load(getClass().getResource("Resource/Views/admin.fxml"));

            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else
            loginmessage.setText("Invalid Login .Please try again.");
    }

    @FXML
    void goToMail_oublie(ActionEvent event) {

        passwordmessage.setText("Send to email");
        mail.setToEmail(login.getText());

        if (pc.recherche_login(admin) != null) {

            email.sendingEmail(mail);

            mail.setSubjects("demande de mot de passe ");
            mail.setMsg("votre password  : " + pc.recherche_login(admin));

        }

    }

}
