/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.proc.ImageBuff;
import app.viewcontrol.BureminController;
import app.viewcontrol.ChainCodeController;
import app.viewcontrol.EmbossController;
import app.viewcontrol.EqHistogramController;
import app.viewcontrol.FirstController;
import app.viewcontrol.GaussianBlurController;
import app.viewcontrol.HistogramController;
import app.viewcontrol.Homogen8Controller;
import app.viewcontrol.KodeBelokController;
import app.viewcontrol.RootLayoutController;
import app.viewcontrol.SobelController;
import app.viewcontrol.TulangController;
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
    public BufferedImage imOri, imGray, imBw, imBolong, imTulang, imBurem;

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

    // <editor-fold defaultstate="collapsed" desc="image generator">
    public void setIvImage(ImageView iv, BufferedImage image) {
        if (image.getWidth() > iv.getFitWidth() | image.getHeight() > iv.getFitHeight()) {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
        } else {
            iv.setImage(SwingFXUtils.toFXImage(image, null));
            iv.setFitHeight(image.getHeight());
            iv.setFitWidth(image.getWidth());
        }
    }

    public void setBufferedImage(File file) throws IOException {
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

    public void mHistogram() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Histogram.fxml"));
        AnchorPane ap = loader.load();
        HistogramController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mEqHistogram() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/EqHistogram.fxml"));
        AnchorPane ap = loader.load();
        EqHistogramController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mChainCode() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/ChainCode.fxml"));
        AnchorPane ap = loader.load();
        ChainCodeController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mKodeBelok() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/KodeBelok.fxml"));
        AnchorPane ap = loader.load();
        KodeBelokController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mBuremin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Buremin.fxml"));
        AnchorPane ap = loader.load();
        BureminController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mTulang() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Tulang.fxml"));
        AnchorPane ap = loader.load();
        TulangController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mGaussianBlur() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/GaussianBlur.fxml"));
        AnchorPane ap = loader.load();
        GaussianBlurController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mHomogen8() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Homogen8.fxml"));
        AnchorPane ap = loader.load();
        Homogen8Controller controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mSobel() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Sobel.fxml"));
        AnchorPane ap = loader.load();
        SobelController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }

    public void mEmboss() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("viewcontrol/Emboss.fxml"));
        AnchorPane ap = loader.load();
        EmbossController controller = loader.getController();
        controller.setMain(this);
        rootLayout.setCenter(ap);
    }
    //</editor-fold>
}
