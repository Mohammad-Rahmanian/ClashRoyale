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
 * The type Login controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label loginLabel;

    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Login.
     *
     * @param event the event
     */
    @FXML
    void login(ActionEvent event) {
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        if (userName.equals("")) {
            loginLabel.setText("Please enter a valid username");
        } else if (password.equals("")) {
            loginLabel.setText("Please enter a password");
        } else {
            File[] files = new File("./").listFiles();
            boolean availableUser = false;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(userName + ".bin")) {
                        try (FileInputStream fileInputStream = new FileInputStream(userName + ".bin");
                             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                            PlayerProfile playerProfile = (PlayerProfile) objectInputStream.readObject();
                            if (playerProfile.getUserName().equals(userName) && playerProfile.getPassword().equals(password)) {
                                availableUser = true;
                                //switch to menu
                                //Pause media
                                mediaPlayer.pause();
                                //
                                Stage stage = (Stage) loginLabel.getScene().getWindow();
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
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }

            if (!availableUser) {
                loginLabel.setText("Your password or username is incorrect");
            }
        }
    }

    /**
     * Show sign up stage.
     *
     * @param event the event
     */
    @FXML
    void showSignUpStage(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //
        Stage stage = (Stage) loginLabel.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/signUp.fxml"));
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

