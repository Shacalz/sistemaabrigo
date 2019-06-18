/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Fellipe Luann
 */
public class appMain extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    public static Stage palco;
    private static AnchorPane page;
    private static Scene cena;
    private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();
    
    @Override
    public void start(Stage stage) throws IOException {
        palco = stage;
        page = FXMLLoader.load(getClass().getResource("/view/app.fxml"));
        cena = new Scene(page);

        stage.setScene(cena);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        palco.getIcons().addAll(new Image(appMain.class.getResourceAsStream("/view/imgs/imagemInicioLogo.png")));
        stage.setTitle("Pata Amiga");
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2); 
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
