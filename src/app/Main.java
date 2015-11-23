/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.viewcontrol.FirstController;
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

    public Stage primaryStage;
    public BorderPane rootLayout;
    public Scene scene;
    public BufferedImage imOri, imGray, imBw, imBolong, imTulang;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pengenalan Pola 23515034");
        initRootLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.initOwner(primaryStage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    // <editor-fold defaultstate="collapsed" desc="layout controller">
    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/RootLayout.fxml"));
        rootLayout = loader.load();
        RootLayoutController controller = loader.getController();
        controller.setMain(this);
        scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        setCenter();
    }

    public void setCenter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/First.fxml"));
        AnchorPane ap = loader.load();
        FirstController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void setIvImage(ImageView iv, BufferedImage image) {
        if (image.getWidth() > iv.getFitWidth() | image.getHeight() > iv.getFitHeight()) {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
        } else {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
            iv.setFitHeight(image.getHeight());
            iv.setFitWidth(image.getWidth());
        }
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="image generator">
    public void setBufferedImage(File file) throws IOException {
        imOri = ImageIO.read(file);
    }
    //</editor-fold>

}
