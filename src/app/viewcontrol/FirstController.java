/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Pola_23515034;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Siroj Nur Ulum
 */
public class FirstController implements Initializable {

    private Pola_23515034 mainApp;

    public void setMainApp(Pola_23515034 mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    ImageView ivOri;
    @FXML
    ImageView ivGray;
    @FXML
    ImageView ivBw;
    @FXML
    ImageView ivBurem;
    @FXML
    Button btnChooseFile;

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

    @FXML
    public void chooseFileAction() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG"), new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG"));
        File file = chooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file == null) {
            mainApp.showAlert("--", "--", "No File Selected", Alert.AlertType.INFORMATION);
        } else {

        }
    }

}
