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
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


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

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    @FXML
    void BackToMainMenu(ActionEvent event) {
        //switch to menu
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Menu.fxml"));
            Parent root = loader.load();
            MenuController menuController = loader.getController();
            menuController.setPlayerProfile(playerProfile);
            stage.setScene(new Scene(root));
            stage.setTitle("Clash Royale");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void init() {
        //set characteristics
        usernameLabel.setText(playerProfile.getUserName());
        cupsLabel.setText(String.valueOf(playerProfile.getCups()));
        leagueLabel.setText(String.valueOf(playerProfile.getCurrentLeague()));
        levelLabel.setText(String.valueOf(playerProfile.getLevel()));
        //set images
        ArrayList<Card> cards = playerProfile.getCards();
        int i = 1;
        for (Card card : cards){
            Image image = null;
            String level =  String.valueOf(card.getLevel());;
            if (card instanceof Barbarian){
                image = new Image("@../Photos/Barbarian.jpg");
            }else if (card instanceof Archer){
                image = new Image("@../Photos/archer.jpg");
            }else if (card instanceof Giant){
                image = new Image("@../Photos/giant.jpg");
            }else if (card instanceof Wizard){
                image = new Image("@../Photos/wizard.jpg");
            }else if (card instanceof BabyDragon){
                image = new Image("@../Photos/babyDragon.jpg");
            }else if (card instanceof Valkyrie){
                image = new Image("@../Photos/valkyrie.jpg");
            }else if (card instanceof MiniPekka){
                image = new Image("@../Photos/pekka.jpg");
            }else if (card instanceof Rage){
                image = new Image("@../Photos/rage.jpg");
            }else if (card instanceof Arrow){
                image = new Image("@../Photos/arrow.jpg");
            }else if (card instanceof FireBall){
                image = new Image("@../Photos/fireBall.jpg");
            }else if (card instanceof InfernoTower){
                image = new Image("@../Photos/infernoTower.jpg");
            }else if (card instanceof Cannon){
                image = new Image("@../Photos/cannon.jpg");
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
    }

    private void setImage(int index, Image image, String level){
        if (index == 1){
            image1.setImage(image);
            label1.setText(level);
        }else if (index == 2){
            image2.setImage(image);
            label2.setText(level);
        }else if (index == 3){
            image3.setImage(image);
            label3.setText(level);
        }else if (index == 4){
            image4.setImage(image);
            label4.setText(level);
        }else if (index == 5){
            image5.setImage(image);
            label5.setText(level);
        }else if (index == 6){
            image6.setImage(image);
            label6.setText(level);
        }else if (index == 7){
            image7.setImage(image);
            label7.setText(level);
        }else if (index == 8){
            image8.setImage(image);
            label8.setText(level);
        }
    }
}

