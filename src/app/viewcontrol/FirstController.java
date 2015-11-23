/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    File file;

    @FXML
    public void chooseFileAction() {
        List<String> ext = new ArrayList<>();
        ext.add("*.JPG");
        ext.add("*.jpg");
        ext.add("*.PNG");
        ext.add("*.png");
        ext.add("*.BMP");
        ext.add("*.bmp");
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG, PNG, BMP Files", ext));
        file = chooser.showOpenDialog(main.primaryStage);
        if (file == null) {
            main.showAlert("INFO", "Warning !!!", "No File Selected", Alert.AlertType.INFORMATION);
        } else {
            try {
                main.setBufferedImage(file);
            } catch (IOException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }
            setImage();
        }
    }

    private void setImage() {
        main.setIvImage(ivOri, main.imOri);
        main.setIvImage(ivGray, main.imGray);
        main.setIvImage(ivBw, main.imBw);
        main.setIvImage(ivBurem, main.imBurem);
    }
}
