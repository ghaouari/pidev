package Services;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javafx.beans.binding.SetExpression;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mail {

    private static final String Session = null;
    Entites.email email = new Entites.email();

    public void sendingEmail(Entites.email email) {
        String ToEmail = email.getToEmail();
        String FromEmail = "chiheb.menjli@esprit.tn";
        String FromEmailPassword = "E11655439";
        String Subjects = email.getSubjects();
        String msg = email.getMsg();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        final SetExpression session = Session.getDefaultInstance(properties, new javax.email.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
            message.setSubject(Subjects);
            message.setText(msg);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
