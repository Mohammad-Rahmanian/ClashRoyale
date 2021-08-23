package Controller;


import Model.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Sign up controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label signUpLabel;

    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Sign up.
     *
     * @param event the event
     */
    @FXML
    void signUP(ActionEvent event) {
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        if (userName.equals("")) {
            signUpLabel.setText("Please enter a valid username");
        } else if (password.equals("")) {
            signUpLabel.setText("Please enter a password");
        } else {
            File[] files = new File("./").listFiles();
            boolean duplicateUser = false;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(userName + ".bin")) {
                        signUpLabel.setText("Username is duplicate");
                        duplicateUser = true;
                        break;
                    }
                }
            }
            if (!duplicateUser) {
                PlayerProfile playerProfile = new PlayerProfile(userName, password);
                try (FileOutputStream fileOutputStream = new FileOutputStream(userName + ".bin");
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    objectOutputStream.writeObject(playerProfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //switch to menu
                //Pause media
                mediaPlayer.pause();
                //
                Stage stage = (Stage) signUpLabel.getScene().getWindow();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Menu.fxml"));
                    Parent root = loader.load();
                    MenuController menuController = loader.getController();
                    menuController.setPlayerProfile(playerProfile);
                    menuController.init();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Clash Royale");
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Show login stage.
     *
     * @param event the event
     */
    @FXML
    void showLoginStage(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //
        Stage stage = (Stage) signUpLabel.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        media = new Media(new File("src/music/menu.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}

