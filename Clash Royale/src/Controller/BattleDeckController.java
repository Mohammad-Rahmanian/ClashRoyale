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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * The type Battle deck controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
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
    private HashMap<Card, ImageView> cardsAndImages = new HashMap<Card, ImageView>();
    private int currImage = 1;
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
    public void BackToMainMenu(ActionEvent event) {
        //Pause media
        mediaPlayer.pause();
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

    /**
     * Add archer.
     *
     * @param event the event
     */
    @FXML
    public void addArcher(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Archer").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Archer"));
                playerProfile.addCard(playerProfile.findCard("Archer"));
            }
        }
    }

    /**
     * Add arrow.
     *
     * @param event the event
     */
    @FXML
    public void addArrow(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Arrow").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Arrow"));
                playerProfile.addCard(playerProfile.findCard("Arrow"));
            }
        }
    }

    /**
     * Add baby dragon.
     *
     * @param event the event
     */
    @FXML
    public void addBabyDragon(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("BabyDragon").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("BabyDragon"));
                playerProfile.addCard(playerProfile.findCard("BabyDragon"));
            }
        }
    }

    /**
     * Add barbarian.
     *
     * @param event the event
     */
    @FXML
    public void addBarbarian(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Barbarian").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Barbarian"));
                playerProfile.addCard(playerProfile.findCard("Barbarian"));
            }
        }
    }

    /**
     * Add cannon.
     *
     * @param event the event
     */
    @FXML
    public void addCannon(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Cannon").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Cannon"));
                playerProfile.addCard(playerProfile.findCard("Cannon"));
            }
        }
    }

    /**
     * Add fire ball.
     *
     * @param event the event
     */
    @FXML
    public void addFireBall(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("FireBall").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("FireBall"));
                playerProfile.addCard(playerProfile.findCard("FireBall"));
            }
        }
    }

    /**
     * Add giant.
     *
     * @param event the event
     */
    @FXML
    public void addGiant(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Giant").getImage()))) {
            if ((cardsAndImages.size() < 8)) {
                setImage(playerProfile.findCard("Giant"));
                playerProfile.addCard(playerProfile.findCard("Giant"));
            }
        }
    }

    /**
     * Add inferno tower.
     *
     * @param event the event
     */
    @FXML
    public void addInfernoTower(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("InfernoTower").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("InfernoTower"));
                playerProfile.addCard(playerProfile.findCard("InfernoTower"));
            }
        }
    }

    /**
     * Add pekka.
     *
     * @param event the event
     */
    @FXML
    public void addPekka(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("MiniPekka").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("MiniPekka"));
                playerProfile.addCard(playerProfile.findCard("MiniPekka"));
            }
        }
    }

    /**
     * Add rage.
     *
     * @param event the event
     */
    @FXML
    public void addRage(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Rage").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Rage"));
                playerProfile.addCard(playerProfile.findCard("Rage"));
            }
        }
    }

    /**
     * Add valkyrie.
     *
     * @param event the event
     */
    @FXML
    public void addValkyrie(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Valkyrie").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Valkyrie"));
                playerProfile.addCard(playerProfile.findCard("Valkyrie"));
            }
        }
    }

    /**
     * Add wizard.
     *
     * @param event the event
     */
    @FXML
    public void addWizard(ActionEvent event) {
        if (!(checkExist(playerProfile.findCard("Wizard").getImage()))) {
            if (cardsAndImages.size() < 8) {
                setImage(playerProfile.findCard("Wizard"));
                playerProfile.addCard(playerProfile.findCard("Wizard"));
            }
        }
    }

    /**
     * Remove archer.
     *
     * @param event the event
     */
    @FXML
    public void removeArcher(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Archer").getImage())) {
            Card card = playerProfile.findCard("Archer");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove arrow.
     *
     * @param event the event
     */
    @FXML
    public void removeArrow(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Arrow").getImage())) {
            Card card = playerProfile.findCard("Arrow");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove baby dragon.
     *
     * @param event the event
     */
    @FXML
    public void removeBabyDragon(ActionEvent event) {
        if (checkExist(playerProfile.findCard("BabyDragon").getImage())) {
            Card card = playerProfile.findCard("BabyDragon");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove barbarian.
     *
     * @param event the event
     */
    @FXML
    public void removeBarbarian(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Barbarian").getImage())) {
            Card card = playerProfile.findCard("Barbarian");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove cannon.
     *
     * @param event the event
     */
    @FXML
    public void removeCannon(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Cannon").getImage())) {
            Card card = playerProfile.findCard("Cannon");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove fire ball.
     *
     * @param event the event
     */
    @FXML
    public void removeFireBall(ActionEvent event) {
        if (checkExist(playerProfile.findCard("FireBall").getImage())) {
            Card card = playerProfile.findCard("FireBall");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove giant.
     *
     * @param event the event
     */
    @FXML
    public void removeGiant(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Giant").getImage())) {
            Card card = playerProfile.findCard("Giant");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove inferno tower.
     *
     * @param event the event
     */
    @FXML
    public void removeInfernoTower(ActionEvent event) {
        if (checkExist(playerProfile.findCard("InfernoTower").getImage())) {
            Card card = playerProfile.findCard("InfernoTower");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove pekka.
     *
     * @param event the event
     */
    @FXML
    public void removePekka(ActionEvent event) {
        if (checkExist(playerProfile.findCard("MiniPekka").getImage())) {
            Card card = playerProfile.findCard("MiniPekka");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove rage.
     *
     * @param event the event
     */
    @FXML
    public void removeRage(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Rage").getImage())) {
            Card card = playerProfile.findCard("Rage");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove valkyrie.
     *
     * @param event the event
     */
    @FXML
    public void removeValkyrie(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Valkyrie").getImage())) {
            Card card = playerProfile.findCard("Valkyrie");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Remove wizard.
     *
     * @param event the event
     */
    @FXML
    public void removeWizard(ActionEvent event) {
        if (checkExist(playerProfile.findCard("Wizard").getImage())) {
            Card card = playerProfile.findCard("Wizard");
            updateCurrImage(card.getImage());
            cardsAndImages.remove(card);
            playerProfile.removeCard(card);
        }
    }

    /**
     * Check exist boolean.
     *
     * @param image the image
     * @return the boolean
     */
    public boolean checkExist(Image image) {
        boolean find = false;
        if (image1.getImage() != null)
            if (image1.getImage().equals(image))
                find = true;
        if (image2.getImage() != null)
            if (image2.getImage().equals(image))
                find = true;
        if (image3.getImage() != null)
            if (image3.getImage().equals(image))
                find = true;
        if (image4.getImage() != null)
            if (image4.getImage().equals(image))
                find = true;
        if (image5.getImage() != null)
            if (image5.getImage().equals(image))
                find = true;
        if (image6.getImage() != null)
            if (image6.getImage().equals(image))
                find = true;
        if (image7.getImage() != null)
            if (image7.getImage().equals(image))
                find = true;
        if (image8.getImage() != null)
            if (image8.getImage().equals(image))
                find = true;
        return find;
    }

    /**
     * Sets image.
     *
     * @param card the card
     */
    public void setImage(Card card) {
        Image image = card.getImage();
        String level = String.valueOf(card.getLevel());

        switch (currImage) {
            case 1:
                if (image1.getImage() == null) {
                    image1.setImage(image);
                    label1.setText(level);
                    cardsAndImages.put(card, image1);
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
                if (image3.getImage() == null) {
                    image3.setImage(image);
                    label3.setText(level);
                    cardsAndImages.put(card, image3);
                    break;
                }
            case 4:
                if (image4.getImage() == null) {
                    image4.setImage(image);
                    label4.setText(level);
                    cardsAndImages.put(card, image4);
                    break;
                }
            case 5:
                if (image5.getImage() == null) {
                    image5.setImage(image);
                    label5.setText(level);
                    cardsAndImages.put(card, image5);
                    break;
                }
            case 6:
                if (image6.getImage() == null) {
                    image6.setImage(image);
                    label6.setText(level);
                    cardsAndImages.put(card, image6);
                    break;
                }
            case 7:
                if (image7.getImage() == null) {
                    image7.setImage(image);
                    label7.setText(level);
                    cardsAndImages.put(card, image7);
                    break;
                }
            case 8:
                if (image8.getImage() == null) {
                    image8.setImage(image);
                    label8.setText(level);
                    cardsAndImages.put(card, image8);
                    break;
                }
        }
        currImage++;
    }

    /**
     * Init.
     */
    public void init() {
        //Music
        media = new Media(new File("src/music/battleDeck.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //
        ArrayList<Card> cards = playerProfile.getCards();
        for (Card card : cards) {
            if (card instanceof Barbarian) {
                setImage(playerProfile.findCard("Barbarian"));
            } else if (card instanceof Archer) {
                setImage(playerProfile.findCard("Archer"));
            } else if (card instanceof Giant) {
                setImage(playerProfile.findCard("Giant"));
            } else if (card instanceof Wizard) {
                setImage(playerProfile.findCard("Wizard"));
            } else if (card instanceof BabyDragon) {
                setImage(playerProfile.findCard("BabyDragon"));
            } else if (card instanceof Valkyrie) {
                setImage(playerProfile.findCard("Valkyrie"));
            } else if (card instanceof MiniPekka) {
                setImage(playerProfile.findCard("MiniPekka"));
            } else if (card instanceof Rage) {
                setImage(playerProfile.findCard("Rage"));
            } else if (card instanceof Arrow) {
                setImage(playerProfile.findCard("Arrow"));
            } else if (card instanceof FireBall) {
                setImage(playerProfile.findCard("FireBall"));
            } else if (card instanceof InfernoTower) {
                setImage(playerProfile.findCard("InfernoTower"));
            } else if (card instanceof Cannon) {
                setImage(playerProfile.findCard("Cannon"));
            }
        }
    }

    /**
     * Update curr image.
     *
     * @param image the image
     */
    public void updateCurrImage(Image image) {
        if (image.equals(image1.getImage())) {
            image1.setImage(null);
            label1.setText("empty");
            currImage = 1;
        }
        if (image.equals(image2.getImage())) {
            image2.setImage(null);
            label2.setText("empty");
            currImage = 2;
        }
        if (image.equals(image3.getImage())) {
            image3.setImage(null);
            label3.setText("empty");
            currImage = 3;
        }
        if (image.equals(image4.getImage())) {
            image4.setImage(null);
            label4.setText("empty");
            currImage = 4;
        }
        if (image.equals(image5.getImage())) {
            image5.setImage(null);
            label5.setText("empty");
            currImage = 5;
        }
        if (image.equals(image6.getImage())) {
            image6.setImage(null);
            label6.setText("empty");
            currImage = 6;
        }
        if (image.equals(image7.getImage())) {
            image7.setImage(null);
            label7.setText("empty");
            currImage = 7;
        }
        if (image.equals(image8.getImage())) {
            image8.setImage(null);
            label8.setText("empty");
            currImage = 8;
        }
    }
}
