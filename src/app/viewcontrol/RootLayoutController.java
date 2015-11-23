/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Siroj Nur Ulum
 */
public class RootLayoutController implements Initializable {

    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    // <editor-fold defaultstate="collapsed" desc="menu">
    @FXML
    public void mainPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RootLayoutController.class.getResource("First.fxml"));
        AnchorPane ap = loader.load();
        main.rootLayout.setCenter(ap);
        FirstController controller = loader.getController();
        controller.setMain(main);
    }

    @FXML
    public void histogram() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RootLayoutController.class.getResource("Histogram.fxml"));
        AnchorPane ap = loader.load();
        HistogramController controller = loader.getController();
        controller.setMain(main);
        main.rootLayout.setCenter(ap);
    }

    @FXML
    public void eqHistogram() {

    }

    //</editor-fold>
}
