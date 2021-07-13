package Controller;


import Model.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class SignUpController {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label signUpLabel;

    @FXML
    void showLoginStage(ActionEvent event) {
        Stage stage = (Stage) signUpLabel.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            for (File file : files) {
                if (file.getName().equals(userName + ".bin")) {
                    signUpLabel.setText("Username is duplicate");
                    duplicateUser = true;
                    break;
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
            }
        }
    }
}

