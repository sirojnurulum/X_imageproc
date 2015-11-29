/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.proc.ImageBuff;
import app.viewcontrol.RootLayoutController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Siroj Nur Ulum
 */
public class Main extends Application {

    public static Stage primaryStage;
    public static BorderPane rootLayout;
    public static Scene scene;
    public static BufferedImage imOri, imGray, imBw, imBolong, imTulang, imBurem;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Pengenalan Pola 23515034");
        initRootLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.initOwner(primaryStage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    // <editor-fold defaultstate="collapsed" desc="image generator">
    public static void setIvImage(ImageView iv, BufferedImage image) {
        if (image.getWidth() > iv.getFitWidth() | image.getHeight() > iv.getFitHeight()) {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
        } else {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
            iv.setFitHeight(image.getHeight());
            iv.setFitWidth(image.getWidth());
        }
    }

    public static void setBufferedImage(File file) throws IOException {
        imOri = ImageIO.read(file);
        imGray = new BufferedImage(imOri.getColorModel(), imOri.getRaster(), imOri.isAlphaPremultiplied(), null);
        imBw = new BufferedImage(imOri.getColorModel(), imOri.getRaster(), imOri.isAlphaPremultiplied(), null);
        imBolong = new BufferedImage(imOri.getColorModel(), imOri.getRaster(), imOri.isAlphaPremultiplied(), null);
        imTulang = new BufferedImage(imOri.getColorModel(), imOri.getRaster(), imOri.isAlphaPremultiplied(), null);
        imBurem = new BufferedImage(imOri.getColorModel(), imOri.getRaster(), imOri.isAlphaPremultiplied(), null);
        new Thread(() -> {
            imGray = ImageBuff.convertToGray(imGray);
        }).start();
        new Thread(() -> {
            imBurem = ImageBuff.buremin(imBurem);
        }).start();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="layout controller">
    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/RootLayout.fxml"));
        rootLayout = loader.load();
        RootLayoutController controller = loader.getController();
        scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        controller.setMain(this);
        setCenter();
    }

    public void setCenter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/First.fxml"));
        AnchorPane ap = loader.load();
        rootLayout.setCenter(ap);
    }

    //</editor-fold>
}
