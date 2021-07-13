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
            try (FileOutputStream fileOutputStream = new FileOutputStream("Profiles.bin", true);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                 FileInputStream fileInputStream = new FileInputStream("Profiles.bin");
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                while (true) {
                    try {
                        if (objectInputStream.available() != 0) {
                            System.out.println("aaa");
                            PlayerProfile playerProfile = (PlayerProfile) objectInputStream.readObject();
                            if (playerProfile.getUserName().equals(userName)) {
                                signUpLabel.setText("Username is duplicate");
                                break;
                            }
                        } else {
                            PlayerProfile playerProfile = new PlayerProfile(userName, password);
                            System.out.println("pppp");
                            objectOutputStream.writeObject(playerProfile);
                            //..............
                            break;
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}

