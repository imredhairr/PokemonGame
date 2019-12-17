/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.PokemonController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Nguyen Hung Hau
 */
public class PokemonMain extends Application {

   PokemonController pokemon = new PokemonController();

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
//        ScrollPane scrollPane = new ScrollPane();
//        VBox content = new VBox();
//        content.setMinSize(1000, 1000);
//        scrollPane.setContent(content);
//
//        pokemon.makeRadioButton(content);

        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/image1.jpg")));
        //pokemon.setSelectedEvent();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));

//        root.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                xOffset = event.getSceneX();
//                yOffset = event.getSceneY();
//            }
//        });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                stage.setX(event.getScreenX() - xOffset);
//                stage.setY(event.getScreenY() - yOffset);
//            }
//        });
//        content.getChildren().add(root);
//        Button button = pokemon.createStartButton(content, root);
//        content.getChildren().add(button);

        //content.setBackground(pokemon.createBackground());
//        scrollPane.setPrefViewportWidth(500);
//        scrollPane.setPrefViewportHeight(500);
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}
