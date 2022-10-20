package Services;

import Entites.prestataire;
import com.mysql.jdbc.Connection;
import Utils.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicesPrestataire {
    Connection connection = (Connection) ConnectionDB.openConnection();
    prestataire prestataire = new prestataire();
    ObservableList<prestataire> prestataireList = FXCollections.observableArrayList();

    public void affich_table(prestataire p) {

    }

}
