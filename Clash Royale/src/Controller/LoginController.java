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

public class LoginController {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;


    @FXML
    private Label loginLabel;

    @FXML
    void login(ActionEvent event) {

        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        if (userName.equals("")) {
            loginLabel.setText("Please enter a valid username");
        } else if (password.equals("")) {
            loginLabel.setText("Please enter a password");
        } else {
            try (FileInputStream fileInputStream = new FileInputStream("Profiles.bin");
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                while (true) {
                    PlayerProfile playerProfile = (PlayerProfile) objectInputStream.readObject();
                    if (playerProfile == null) {
                        loginLabel.setText("Your password or username is incorrect");
                        break;
                    } else if (playerProfile.getUserName().equals(userName) && playerProfile.getPassword().equals(password)) {
                        //.........................
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(System.err);
            }

        }
    }

    @FXML
    void showSignUpStage(ActionEvent event) {
        Stage stage = (Stage) loginLabel.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/signUp.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

