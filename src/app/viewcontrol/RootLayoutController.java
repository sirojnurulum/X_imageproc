/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Main;
import app.proc.ImageBuff;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Siroj Nur Ulum
 */
public class RootLayoutController implements Initializable {

    @FXML
    Menu menuHistogram;
    @FXML
    Menu menuText;
    @FXML
    Menu menuKonvolusi;
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("First.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void histogram() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Histogram.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void eqHistogram() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("EqHistogram.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void chainCode() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ChainCode.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void kodeBelok() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("KodeBelok.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void tulang() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Tulang.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void buremin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Buremin.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void gaussianBlur() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("GaussianBlur.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void homogen8() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Homogen8.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void sobel() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Sobel.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }

    @FXML
    public void emboss() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Emboss.fxml"));
        AnchorPane ap = loader.load();
        Main.rootLayout.setCenter(ap);
    }
    //</editor-fold>
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
        File file = chooser.showOpenDialog(Main.primaryStage);
        if (file == null) {
            Main.showAlert("INFO", "Warning !!!", "No File Selected", Alert.AlertType.INFORMATION);
        } else {
            try {
                setBufferedImage(file);
            } catch (IOException ex) {
                Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
            setImage();
        }
    }

    public void setBufferedImage(File file) throws IOException {
        Main.imOri = ImageIO.read(file);
        Main.imBw = new BufferedImage(Main.imOri.getColorModel(), Main.imOri.getRaster(), Main.imOri.isAlphaPremultiplied(), null);
        Main.imBolong = new BufferedImage(Main.imOri.getColorModel(), Main.imOri.getRaster(), Main.imOri.isAlphaPremultiplied(), null);
        Main.imTulang = new BufferedImage(Main.imOri.getColorModel(), Main.imOri.getRaster(), Main.imOri.isAlphaPremultiplied(), null);
        new Thread(() -> {
            Main.imGray = ImageBuff.convertToGray(Main.imOri);
        }).start();
        new Thread(() -> {
            Main.imBurem = ImageBuff.buremin(Main.imOri);
        }).start();
    }

    private void setImage() {
        Main.setIvImage(ivOri, Main.imOri);
        Main.setIvImage(ivGray, Main.imGray);
        Main.setIvImage(ivBw, Main.imBw);
        Main.setIvImage(ivBurem, Main.imBurem);
    }
}
