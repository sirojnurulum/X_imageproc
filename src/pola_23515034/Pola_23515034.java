/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pola_23515034;

import app.RootLayoutController;
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
public class Pola_23515034 extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pengenalan Pola 2351503");
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
    private RootLayoutController controller;
    private Scene scene;
    private AnchorPane ap;

    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Pola_23515034.class.getResource("../app/RootLayout.fxml"));
        rootLayout = loader.load();
        controller = loader.getController();
        controller.setMainApp(this);
        scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    public void showPerencanaanRuangLingkupProyek() throws IOException {
//      FXMLLoader loader = new FXMLLoader();
//      loader.setLocation(Main.class.getResource("fxml/ProjectScopePlanning.fxml"));
//      AnchorPane ap = (AnchorPane) loader.load();
//      rootLayout.setCenter(ap);
//      ProjectScopePlanningController controller = loader.getController();
//      controller.setMainApp(this);
//   }

}
