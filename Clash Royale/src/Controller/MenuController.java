package Controller;

import Model.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * The type Menu controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class MenuController {
    @FXML
    private Button profileButton;
    private PlayerProfile playerProfile;
    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Sets player profile.
     *
     * @param playerProfile the player profile
     */
    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    /**
     * Init.
     */
    public void init() {
        playerProfile.loadImages();
        //Music
        media = new Media(new File("src/music/menu.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    /**
     * Training camp.
     *
     * @param event the event
     */
    @FXML
    void TrainingCamp(ActionEvent event) {
        if (playerProfile.getCards().size() == 8) {
            //Pause media
            mediaPlayer.pause();
            //
            Stage stage = (Stage) profileButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/game.fxml"));
            try {
                Parent root = loader.load();

                GameController gameController = loader.getController();
                gameController.setPlayerProfile(playerProfile);
                gameController.init();
                stage.setScene(new Scene(root));
                stage.setTitle("Clash Royale");
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Battle deck.
     *
     * @param event the event
     */
    @FXML
    void battleDeck(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //
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

    /**
     * Battle history.
     *
     * @param event the event
     */
    @FXML
    void battleHistory(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //
        Stage stage = (Stage) profileButton.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/battleHistory.fxml"));
            Parent root = loader.load();
            BattleHistoryController battleHistoryController = loader.getController();
            battleHistoryController.setPlayerProfile(playerProfile);
            battleHistoryController.init();
            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Profile.
     *
     * @param event the event
     */
    @FXML
    void profile(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //
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
