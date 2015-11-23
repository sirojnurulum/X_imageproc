/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Siroj Nur Ulum
 */
public class HistogramController implements Initializable {

    @FXML
    ImageView ivHistogramOri;
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
        new Thread(() -> {
            main.setIvImage(ivHistogramOri, main.imOri);
        }).start();
    }

}
