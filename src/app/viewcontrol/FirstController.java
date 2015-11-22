/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.viewcontrol;

import app.Main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Siroj Nur Ulum
 */
public class FirstController extends Main implements Initializable {
// <editor-fold defaultstate="collapsed" desc="class var">

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
//</editor-fold>

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

    // <editor-fold defaultstate="collapsed" desc="rengse - ke deui ngomena">
    private void setIvImage(ImageView iv, BufferedImage image) {
        if (image.getWidth() > iv.getFitWidth() | image.getHeight() > iv.getFitHeight()) {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
        } else {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
            iv.setFitHeight(image.getHeight());
            iv.setFitWidth(image.getWidth());
        }
    }

    //</editor-fold>
    @FXML
    public void chooseFileAction() throws IOException {
        List<String> ext = new ArrayList<>();
        ext.add("*.JPG");
        ext.add("*.jpg");
        ext.add("*.PNG");
        ext.add("*.png");
        ext.add("*.BMP");
        ext.add("*.bmp");
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG, PNG, BMP Files", ext));
        File file = chooser.showOpenDialog(primaryStage);
        if (file == null) {
            showAlert("INFO", "Warning !!!", "No File Selected", Alert.AlertType.INFORMATION);
        } else {
            imOri = ImageIO.read(file);
            setIvImage(ivOri, imOri);
            imGray = new BufferedImage(imOri.getWidth(), imOri.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            imGray.getGraphics().drawImage(imOri, 0, 0, null);
            setIvImage(ivBw, imGray);
            System.out.println("-->" + imGray.getRaster().getPixels(0, 0, imGray.getWidth(), imGray.getHeight(), (int[]) null).length);
            System.out.println("-->" + imGray.getWidth() * imGray.getHeight());
        }
    }

}
