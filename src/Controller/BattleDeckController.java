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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BattleDeckController {

    @FXML
    private ImageView image1;

    @FXML
    private Label label1;

    @FXML
    private ImageView image2;

    @FXML
    private Label label2;

    @FXML
    private ImageView image3;

    @FXML
    private Label label3;

    @FXML
    private ImageView image4;

    @FXML
    private Label label4;

    @FXML
    private ImageView image5;

    @FXML
    private Label label5;

    @FXML
    private ImageView image6;

    @FXML
    private Label label6;

    @FXML
    private ImageView image7;

    @FXML
    private Label label7;

    @FXML
    private ImageView image8;

    @FXML
    private Label label8;

    private PlayerProfile playerProfile;
    private HashMap<Card, ImageView> cardsAndImages = new HashMap<Card,ImageView>();
    private int currImage = 1;

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    @FXML
    public void BackToMainMenu(ActionEvent event) {
        //switch to menu
        Stage stage = (Stage) label1.getScene().getWindow();
        try {
            Path path = Paths.get("./" + playerProfile.getUserName() + ".bin");
            Files.delete(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(playerProfile.getUserName() + ".bin");
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(playerProfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    @FXML
    public void addArcher(ActionEvent event) {
        if (!(checkExist("Archer"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Archer"));
                playerProfile.addCard(playerProfile.findCard("Archer"));
            }
        }
    }

    @FXML
    public void addArrow(ActionEvent event) {
        if (!(checkExist("Arrow"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Arrow"));
                playerProfile.addCard(playerProfile.findCard("Arrow"));
            }
        }
    }

    @FXML
    public void addBabyDragon(ActionEvent event) {
        if (!(checkExist("BabyDragon"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("BabyDragon"));
                playerProfile.addCard(playerProfile.findCard("BabyDragon"));
            }
        }
    }

    @FXML
    public void addBarbarian(ActionEvent event) {
        if (!(checkExist("Barbarian"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Barbarian"));
                playerProfile.addCard(playerProfile.findCard("Barbarian"));
            }
        }
    }

    @FXML
    public void addCannon(ActionEvent event) {
        if (!(checkExist("Cannon"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Cannon"));
                playerProfile.addCard(playerProfile.findCard("Cannon"));
            }
        }
    }

    @FXML
    public void addFireBall(ActionEvent event) {
        if (!(checkExist("FireBall"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("FireBall"));
                playerProfile.addCard(playerProfile.findCard("FireBall"));
            }
        }
    }

    @FXML
    public void addGiant(ActionEvent event) {
        if (!(checkExist("Giant"))){
            if ((cardsAndImages.size() < 8)){
                setImage(playerProfile.findCard("Giant"));
                playerProfile.addCard(playerProfile.findCard("Giant"));
            }
        }
    }

    @FXML
    public void addInfernoTower(ActionEvent event) {
        if (!(checkExist("InfernoTower"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("InfernoTower"));
                playerProfile.addCard(playerProfile.findCard("InfernoTower"));
            }
        }
    }

    @FXML
    public void addPekka(ActionEvent event) {
        if (!(checkExist("MiniPekka"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("MiniPekka"));
                playerProfile.addCard(playerProfile.findCard("MiniPekka"));
            }
        }
    }

    @FXML
    public void addRage(ActionEvent event) {
        if (!(checkExist("Rage"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Rage"));
                playerProfile.addCard(playerProfile.findCard("Rage"));
            }
        }
    }

    @FXML
    public void addValkyrie(ActionEvent event) {
        if (!(checkExist("Valkyrie"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Valkyrie"));
                playerProfile.addCard(playerProfile.findCard("Valkyrie"));
            }
        }
    }

    @FXML
    public void addWizard(ActionEvent event) {
        if (!(checkExist("Wizard"))){
            if (cardsAndImages.size() < 8){
                setImage(playerProfile.findCard("Wizard"));
                playerProfile.addCard(playerProfile.findCard("Wizard"));
            }
        }
    }

    @FXML
    public void removeArcher(ActionEvent event) {
        if (checkExist("Archer")){
            Card card = playerProfile.findCard("Archer");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeArrow(ActionEvent event) {
        if (checkExist("Arrow")){
            Card card = playerProfile.findCard("Arrow");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeBabyDragon(ActionEvent event) {
        if (checkExist("BabyDragon")){
            Card card = playerProfile.findCard("BabyDragon");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeBarbarian(ActionEvent event) {
        if (checkExist("Barbarian")){
            Card card = playerProfile.findCard("Barbarian");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeCannon(ActionEvent event) {
        if (checkExist("Cannon")){
            Card card = playerProfile.findCard("Cannon");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeFireBall(ActionEvent event) {
        if (checkExist("FireBall")){
            Card card = playerProfile.findCard("FireBall");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeGiant(ActionEvent event) {
        if (checkExist("Giant")){
            Card card = playerProfile.findCard("Giant");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeInfernoTower(ActionEvent event) {
        if (checkExist("InfernoTower")){
            Card card = playerProfile.findCard("InfernoTower");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removePekka(ActionEvent event) {
        if (checkExist("MiniPekka")){
            Card card = playerProfile.findCard("MiniPekka");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeRage(ActionEvent event) {
        if (checkExist("Rage")){
            Card card = playerProfile.findCard("Rage");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeValkyrie(ActionEvent event) {
        if (checkExist("Valkyrie")){
            Card card = playerProfile.findCard("Valkyrie");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    @FXML
    public void removeWizard(ActionEvent event) {
        if (checkExist("Wizard")){
            Card card = playerProfile.findCard("Wizard");
            updateCurrImage(cardsAndImages.get(card));
            cardsAndImages.get(card).setImage(null);
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    public boolean checkExist(String name){
        boolean find = false;
        Set<Card> cards = cardsAndImages.keySet();
        for (Card card : cards){
            if (card.getName().equals(name)){
                find = true;
                break;
            }
        }

        return find;
    }

    public void setImage(Card card){
        Image image  = card.getImage();
        String level = String.valueOf(card.getLevel());

        switch (currImage){
            case 1:
                if (image1.getImage() == null){
                    image1.setImage(image);
                    label1.setText(level);
                    cardsAndImages.put(card,image1);
                    break;
                }
            case 2:
                if (image2.getImage() == null) {
                    image2.setImage(image);
                    label2.setText(level);
                    cardsAndImages.put(card, image2);
                    break;
                }
            case 3:
                if (image3.getImage() == null){
                    image3.setImage(image);
                    label3.setText(level);
                    cardsAndImages.put(card,image3);
                    break;
                }
            case 4:
                if (image4.getImage() == null){
                    image4.setImage(image);
                    label4.setText(level);
                    cardsAndImages.put(card,image4);
                    break;
                }
            case 5:
                if (image5.getImage() == null){
                    image5.setImage(image);
                    label5.setText(level);
                    cardsAndImages.put(card,image5);
                    break;
                }
            case 6:
                if (image6.getImage() == null){
                    image6.setImage(image);
                    label6.setText(level);
                    cardsAndImages.put(card,image6);
                    break;
                }
            case 7:
                if (image7.getImage() == null){
                    image7.setImage(image);
                    label7.setText(level);
                    cardsAndImages.put(card,image7);
                    break;
                }
            case 8:
                if (image8.getImage() == null){
                    image8.setImage(image);
                    label8.setText(level);
                    cardsAndImages.put(card,image8);
                    break;
                }
        }
        currImage++;
    }

    public void init() {
        ArrayList<Card> cards = playerProfile.getCards();
        for (Card card : cards){
            if (card instanceof Barbarian){
                setImage(playerProfile.findCard("Barbarian"));
            }else if (card instanceof Archer){
                setImage(playerProfile.findCard("Archer"));
            }else if (card instanceof Giant){
                setImage(playerProfile.findCard("Giant"));
            }else if (card instanceof Wizard){
                setImage(playerProfile.findCard("Wizard"));
            }else if (card instanceof BabyDragon){
                setImage(playerProfile.findCard("BabyDragon"));
            }else if (card instanceof Valkyrie){
                setImage(playerProfile.findCard("Valkyrie"));
            }else if (card instanceof MiniPekka){
                setImage(playerProfile.findCard("MiniPekka"));
            }else if (card instanceof Rage){
                setImage(playerProfile.findCard("Rage"));
            }else if (card instanceof Arrow){
                setImage(playerProfile.findCard("Arrow"));
            }else if (card instanceof FireBall){
                setImage(playerProfile.findCard("FireBall"));
            }else if (card instanceof InfernoTower){
                setImage(playerProfile.findCard("InfernoTower"));
            }else if (card instanceof Cannon){
                setImage(playerProfile.findCard("Cannon"));
            }
        }
    }

    public void updateCurrImage(ImageView imageView){
        if (imageView.equals(image1)){
            currImage = 1;
        }else if (imageView.equals(image2)){
            currImage = 2;
        }else if (imageView.equals(image3)){
            currImage = 3;
        }else if (imageView.equals(image4)){
            currImage = 4;
        }else if (imageView.equals(image5)){
            currImage = 5;
        }else if (imageView.equals(image6)){
            currImage = 6;
        }else if (imageView.equals(image7)){
            currImage = 7;
        }else if (imageView.equals(image8)){
            currImage = 8;
        }
    }
}
