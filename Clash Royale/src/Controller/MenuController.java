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

        @FXML
        void TrainingCamp(ActionEvent event) {

        }

        @FXML
        void battleDeck(ActionEvent event) {

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
                }catch (IOException e){
                        e.printStackTrace();
                }
        }
}
