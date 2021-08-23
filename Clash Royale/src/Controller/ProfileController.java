package Controller;

import Model.Cards.Buildings.Cannon;
import Model.Cards.Buildings.InfernoTower;
import Model.Cards.Card;
import Model.Cards.Spells.Arrow;
import Model.Cards.Spells.FireBall;
import Model.Cards.Spells.Rage;
import Model.Cards.Troops.*;
import Model.PlayerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Profile controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class ProfileController {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label cupsLabel;

    @FXML
    private Label leagueLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

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
     * Back to main menu.
     *
     * @param event the event
     */
    @FXML
    void BackToMainMenu(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
        //switch to menu
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
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

    /**
     * Init.
     */
    public void init() {
        //set characteristics
        usernameLabel.setText(playerProfile.getUserName());
        cupsLabel.setText(String.valueOf(playerProfile.getCups()));
        leagueLabel.setText(String.valueOf(playerProfile.getCurrentLeague()));
        levelLabel.setText(String.valueOf(playerProfile.getLevel()));
        //set images
        ArrayList<Card> cards = playerProfile.getCards();
        int i = 1;
        for (Card card : cards) {
            Image image = null;
            String level = String.valueOf(card.getLevel());
            ;
            if (card instanceof Barbarian) {
                image = playerProfile.findCard("Barbarian").getImage();
            } else if (card instanceof Archer) {
                image = playerProfile.findCard("Archer").getImage();
            } else if (card instanceof Giant) {
                image = playerProfile.findCard("Giant").getImage();
            } else if (card instanceof Wizard) {
                image = playerProfile.findCard("Wizard").getImage();
            } else if (card instanceof BabyDragon) {
                image = playerProfile.findCard("BabyDragon").getImage();
            } else if (card instanceof Valkyrie) {
                image = playerProfile.findCard("Valkyrie").getImage();
            } else if (card instanceof MiniPekka) {
                image = playerProfile.findCard("MiniPekka").getImage();
            } else if (card instanceof Rage) {
                image = playerProfile.findCard("Rage").getImage();
            } else if (card instanceof Arrow) {
                image = playerProfile.findCard("Arrow").getImage();
            } else if (card instanceof FireBall) {
                image = playerProfile.findCard("FireBall").getImage();
            } else if (card instanceof InfernoTower) {
                image = playerProfile.findCard("InfernoTower").getImage();
            } else if (card instanceof Cannon) {
                image = playerProfile.findCard("Cannon").getImage();
            }
            setImage(i, image, level);
            i++;
        }
        image1.setFitHeight(155);
        image1.setFitWidth(104);
        image2.setFitHeight(155);
        image2.setFitWidth(104);
        image3.setFitHeight(155);
        image3.setFitWidth(104);
        image4.setFitHeight(155);
        image4.setFitWidth(104);
        image5.setFitHeight(155);
        image5.setFitWidth(104);
        image6.setFitHeight(155);
        image6.setFitWidth(104);
        image7.setFitHeight(155);
        image7.setFitWidth(104);
        image8.setFitHeight(155);
        image8.setFitWidth(104);

        //Music
        media = new Media(new File("src/music/Profile.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private void setImage(int index, Image image, String level) {
        if (index == 1) {
            image1.setImage(image);
            label1.setText(level);
        } else if (index == 2) {
            image2.setImage(image);
            label2.setText(level);
        } else if (index == 3) {
            image3.setImage(image);
            label3.setText(level);
        } else if (index == 4) {
            image4.setImage(image);
            label4.setText(level);
        } else if (index == 5) {
            image5.setImage(image);
            label5.setText(level);
        } else if (index == 6) {
            image6.setImage(image);
            label6.setText(level);
        } else if (index == 7) {
            image7.setImage(image);
            label7.setText(level);
        } else if (index == 8) {
            image8.setImage(image);
            label8.setText(level);
        }
    }
}

