package Controller;

import Model.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button profileButton;

    private PlayerProfile playerProfile;

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public void init() {
        playerProfile.loadImages();
    }

    @FXML
    void TrainingCamp(ActionEvent event) {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/game.fxml"));
        try {
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void battleDeck(ActionEvent event) {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/battledeck.fxml"));
            Parent root = loader.load();

            BattleDeckController battleDeckController = loader.getController();
            battleDeckController.setPlayerProfile(playerProfile);
            battleDeckController.init();

            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void battleHistory(ActionEvent event) {

    }

    @FXML
    void profile(ActionEvent event) {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/profile.fxml"));
            Parent root = loader.load();
            ProfileController profileController = loader.getController();
            profileController.setPlayerProfile(playerProfile);
            profileController.init();
            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
