/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class PokemonController implements Initializable {

    private static long TURN_BACK_TIME = 3;
    private static final int NUM_COLUMN = 5;
    private static final int NUM_ROW = 4; //MS
    private static final String ICON_DEFAULT = "/img/ball.jpg"; //MS
    private static final String AUDIO_PATH = "/Users/vohuynhthienhuong/Documents/audio.mp3";
    private List<String> listImage;
    private int numScore = 0;
    private Button firstButton = null;
    private int numberButtonClicking = 0;
    MediaPlayer mediaPlayer;
    
    @FXML
    private Label Time_label;

    @FXML
    private Label lblScore;

    private int minutes;
    private int seconds;
    private int milli;

    private String milli_string;
    private String second_string;
    private String minute_string;
    private Timeline timeline = null;
    private Timeline timer = null;
    private boolean running;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private ToggleGroup group;

    private ImageView createImageView(String src) {
        Image playI = new Image(getClass().getResourceAsStream(src));
        ImageView imageView = new ImageView(playI);
        imageView.setFitHeight(67);
        imageView.setFitWidth(69);
        String id = src.substring(5, src.indexOf("."));
        imageView.setId(id);
        return imageView;
    }

    private void createListImage() {
        listImage = new ArrayList<>();
        for (int i = 1; i <= NUM_COLUMN * NUM_ROW / 2; i++) {
            listImage.add("/img/image" + i + ".jpg");
            listImage.add("/img/image" + i + ".jpg");
        }
    }

    private String getRandomImage() {
        Random r = new Random();
        int random = r.nextInt(listImage.size());
        return listImage.get(random);
    }
    
    @FXML
    private void handle_abort(MouseEvent event) {
        Platform.exit();

    }

    private void handleTime() {
        if (running == false) {
            try {
                minutes = 2;
                if (minutes != 0 && minutes > 0) {
                    seconds = 59;
                    minutes--;
                    timer = new Timeline(new KeyFrame(Duration.millis(10), e -> run()));
                    timer.setCycleCount(Timeline.INDEFINITE);
                    timer.play();
                    running = true;
                }
            } catch (Exception e) {
            }
        }

    }

    @FXML
    private void exitGame(ActionEvent event) {
        Platform.exit();
    }

    public void run() {
        if (seconds == 0 && minutes != 0) {
            seconds = 59;
            minutes--;
        }
        if (milli == 0 && seconds != 0) {
            milli = 100;
            seconds--;
        }

        milli--;

        if (milli < 10) {
            milli_string = "0" + milli;
        } else {
            milli_string = "" + milli;
        }

        if (seconds < 10) {
            second_string = "0" + seconds;
        } else {
            second_string = "" + seconds;
        }

        if (minutes < 10) {
            minute_string = "0" + minutes;
        } else {
            minute_string = "" + minutes;
        }

        Time_label.setText("" + minute_string + ":" + second_string + ":" + milli_string);

        if (minutes == 0 && seconds == 0 && milli == 0) {
            timer.stop();
            Time_label.setText("00:00:00");
            running = false;
            mediaPlayer.stop();
            alertMessage("Time ended, you lose!");
        }
    }

    @FXML
    private void startGame(ActionEvent event) {
        numScore = 0;
        firstButton = null;
        createListImage();
        for (int r = 0; r < NUM_ROW; r++) {
            for (int c = 0; c < NUM_COLUMN; c++) {
                Button button = new Button("", createImageView(ICON_DEFAULT));
                String srcRandom = getRandomImage();
                listImage.remove(srcRandom);
                button.setId(srcRandom.substring(5, srcRandom.indexOf(".")).replace("image",
                        "button"));
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        handleEventClickButton(e);
                    }
                });

                gridPane.add(button, c, r);
            }
        }
        handleTime();
        playAudio();
    }

    void handleEventClickButton(ActionEvent event) {
        if (numberButtonClicking >= 2) {
            return;
        }
        numberButtonClicking++;
        timeline = new Timeline(new KeyFrame(Duration.seconds(TURN_BACK_TIME),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Button button = (Button) event.getSource();
                        if (firstButton == null) {
                            firstButton = button;
                        } else {
                            String src1 = "/img/" + firstButton.getId().replace(
                                    "button", "image") + ".jpg";
                            firstButton.setGraphic(createImageView(src1));
                            String src2 = "/img/" + button.getId().replace(
                                    "button", "image") + ".jpg";
                            button.setGraphic(createImageView(src2));
                            if (checkValidPairImage(firstButton,
                                    button)) {
                                numScore++;
                                firstButton = null;
                                numberButtonClicking = 0;
                                if (numScore == NUM_COLUMN * NUM_ROW / 2) {
                                    alertMessage("You win");
                                    if(timer != null) {
                                        timer.stop();
                                        running = false;
                                    }
                                    calculateScore();
                                    mediaPlayer.stop();
                                }
                            } else {
                                turnBackDefault(button);
                            }

                        }
                    }
                }));
        timeline.setCycleCount(1);
        timeline.play();
    }


    void turnBackDefault(Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(TURN_BACK_TIME),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        firstButton.setGraphic(
                                createImageView(ICON_DEFAULT));
                        button.setGraphic(createImageView(
                                ICON_DEFAULT));
                        firstButton = null;
                        numberButtonClicking = 0;
                    }
                }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    void alertMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.show();

    }

    void playAudio() {
        // TODO Auto-generated method stub
        //Initialising path of the media file, replace this with your file path
//        String path = getClass().getResource("/Users/vohuynhthienhuong/Downloads/audio.mp3").getPath();
//        System.out.println(path);

        //Instantiating Media class
        Media media = new Media(new File(AUDIO_PATH).toURI().toString());

        //Instantiating MediaPlayer class
        mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.play();
    }

    public void setSelectedEvent() {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                                Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {
                    RadioButton chk = (RadioButton) group.getSelectedToggle();
                    switch (chk.getText()) {
                        case "level1":
                            TURN_BACK_TIME = 3;
                            break;
                        case "level2":
                            TURN_BACK_TIME = 2;
                            break;
                        default:
                        case "level3":
                            TURN_BACK_TIME = 1;
                            break;
                    }
                }
            }
        });
    }

    private boolean checkValidPairImage(Button firstButton, Button secondButton) {
        ImageView imageView1 = (ImageView) firstButton.getGraphic();
        ImageView imageView2 = (ImageView) secondButton.getGraphic();
        return imageView1.getId().equals(imageView2.getId());
    }

    private void calculateScore() {
        int currentScore = Integer.parseInt(lblScore.getText());
        int score = minutes * 60 + seconds;
        lblScore.setText(String.valueOf(currentScore + score));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSelectedEvent();
    }
}
