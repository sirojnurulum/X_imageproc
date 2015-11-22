/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.viewcontrol.FirstController;
import app.viewcontrol.RootLayoutController;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Siroj Nur Ulum
 */
public class Main extends Application {

    protected Stage primaryStage;
    protected BorderPane rootLayout;
    protected BufferedImage imOri, imGray, imBw, imBolong, imTulang;

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
    protected Scene scene;
    protected AnchorPane ap;

    // <editor-fold defaultstate="collapsed" desc="layout controller">
    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/RootLayout.fxml"));
        rootLayout = loader.load();
        RootLayoutController controller = loader.getController();
        scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        setCenter();
    }

    public void setCenter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/First.fxml"));
        ap = loader.load();
        rootLayout.setCenter(ap);
        FirstController controller = loader.getController();
    }
    //</editor-fold>
}
