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
import javafx.fxml.Initializable;

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

    }

    // <editor-fold defaultstate="collapsed" desc="menu">
    @FXML
    public void mainPage() throws IOException {
        main.setCenter();
    }

    @FXML
    public void histogram() throws IOException {
        main.mHistogram();
    }

    @FXML
    public void eqHistogram() throws IOException {
        main.mEqHistogram();
    }

    @FXML
    public void chainCode() throws IOException {
        main.mChainCode();
    }

    @FXML
    public void kodeBelok() throws IOException {
        main.mKodeBelok();
    }

    @FXML
    public void tulang() throws IOException {
        main.mTulang();
    }

    @FXML
    public void buremin() throws IOException {
        main.mBuremin();
    }

    @FXML
    public void gaussianBlur() throws IOException {
        main.mGaussianBlur();
    }

    @FXML
    public void homogen8() throws IOException {
        main.mHomogen8();
    }

    @FXML
    public void sobel() throws IOException {
        main.mSobel();
    }

    @FXML
    public void emboss() throws IOException {
        main.mEmboss();
    }
    //</editor-fold>
}
