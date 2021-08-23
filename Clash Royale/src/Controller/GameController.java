package Controller;

import Model.Battle;
import Model.Cards.Card;
import Model.Cards.Spells.Spell;
import Model.GameModel;
import Model.Mechanism;
import Model.PlayerProfile;
import Model.Towers.KingTower;
import Model.Towers.PrincessTower;
import Model.Towers.Tower;
import View.GameView;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import javafx.geometry.Point2D;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * The type Game controller.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class GameController {
    final private static double FRAMES_PER_SECOND = 3.0;
    private static final int CELL_WIDTH = 20;
    @FXML
    private ImageView nextCardImageView;

    @FXML
    private ImageView firstCardImageView;

    @FXML
    private ImageView secondCardImageView;

    @FXML
    private ImageView thirdCardImageView;

    @FXML
    private ImageView fourthCardImageView;

    @FXML
    private Label elixirLabel;

    @FXML
    private ProgressBar elixirProgressBar;

    @FXML
    private Label opponentUserNameLabel;

    @FXML
    private Label timeLabel;
    @FXML
    private GameView gameView;
    private GameModel gameModel;
    private Timer timer;
    private PlayerProfile playerProfile;
    private ArrayList<Card> robotHandCard;
    private ArrayList<ImageView> towersImageViews;
    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Init.
     */
    public void init() {
        opponentUserNameLabel.setText("Robot");
        //Music
        media = new Media(new File("src/music/game.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //
        gameModel = new GameModel(playerProfile);
        robotHandCard = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            robotHandCard.add(gameModel.getRobotCards().get(i));
        }
        ImageView[][] imageViews = gameView.getImageViews();
        for (int row = 0; row < 32; row++) {
            for (int column = 0; column < 18; column++) {
                if (imageViews[row][column] != null) {
                    imageViews[row][column].setOnMouseClicked(this::playerDropCard);
                }

            }
        }
        firstCardImageView.setImage(gameModel.getPlayerCards().get(0).getImage());
        firstCardImageView.setUserData(gameModel.getPlayerCards().get(0));
        secondCardImageView.setImage(gameModel.getPlayerCards().get(1).getImage());
        secondCardImageView.setUserData(gameModel.getPlayerCards().get(1));
        thirdCardImageView.setImage(gameModel.getPlayerCards().get(2).getImage());
        thirdCardImageView.setUserData(gameModel.getPlayerCards().get(2));
        fourthCardImageView.setImage(gameModel.getPlayerCards().get(3).getImage());
        fourthCardImageView.setUserData(gameModel.getPlayerCards().get(3));
        nextCardImageView.setImage(gameModel.getPlayerCards().get(4).getImage());
        nextCardImageView.setUserData(gameModel.getPlayerCards().get(4));
        towersImageViews = new ArrayList<>();
        KingTower kingTowerRed = new KingTower();
        kingTowerRed.setLocation(new Point2D(9 * 20, 3 * 20));
        gameModel.getRobotMechanisms().add(kingTowerRed);
        gameModel.getRobotTowers().add(kingTowerRed);

        Image image = new Image(getClass().getResourceAsStream("../Photos/kingTowerRed.jpg"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(7 * CELL_WIDTH);
        imageView.setY(CELL_WIDTH);
        imageView.setFitWidth(4 * CELL_WIDTH);
        imageView.setFitHeight(4 * CELL_WIDTH);
        imageView.setUserData(kingTowerRed);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);


        PrincessTower princessTowerRedLeft = new PrincessTower();
        princessTowerRedLeft.setLocation(new Point2D(3.5f * 20, 6.5f * 20));
        gameModel.getRobotMechanisms().add(princessTowerRedLeft);
        gameModel.getRobotTowers().add(princessTowerRedLeft);

        image = new Image(getClass().getResourceAsStream("../Photos/archerTowerRed.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(2 * CELL_WIDTH);
        imageView.setY(5 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        imageView.setUserData(princessTowerRedLeft);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);


        PrincessTower princessTowerRedRight = new PrincessTower();
        princessTowerRedRight.setLocation(new Point2D(14.5f * 20, 6.5f * 20));
        gameModel.getRobotMechanisms().add(princessTowerRedRight);
        gameModel.getRobotTowers().add(princessTowerRedRight);


        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(13 * CELL_WIDTH);
        imageView.setY(5 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        imageView.setUserData(princessTowerRedRight);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);


        KingTower kingTowerBlue = new KingTower();
        kingTowerBlue.setLocation(new Point2D(9 * 20, 29 * 20));
        gameModel.getPlayerMechanism().add(kingTowerBlue);
        gameModel.getPlayerTowers().add(kingTowerBlue);

        image = new Image(getClass().getResourceAsStream("../Photos/kingTowerBlue.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(7 * CELL_WIDTH);
        imageView.setY(27 * CELL_WIDTH);
        imageView.setFitWidth(4 * CELL_WIDTH);
        imageView.setFitHeight(4 * CELL_WIDTH);
        imageView.setUserData(kingTowerBlue);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);


        PrincessTower princessTowerBlueLeft = new PrincessTower();
        princessTowerBlueLeft.setLocation(new Point2D(3.5f * 20, 25.5f * 20));
        gameModel.getPlayerMechanism().add(princessTowerBlueLeft);
        gameModel.getPlayerTowers().add(princessTowerBlueLeft);

        image = new Image(getClass().getResourceAsStream("../Photos/archerTowerBlue.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(2 * CELL_WIDTH);
        imageView.setY(24 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        imageView.setUserData(princessTowerBlueLeft);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);


        PrincessTower princessTowerBlueRight = new PrincessTower();
        princessTowerBlueRight.setLocation(new Point2D(14.5f * 20, 25.5f * 20));
        gameModel.getPlayerMechanism().add(princessTowerBlueRight);
        gameModel.getPlayerTowers().add(princessTowerBlueRight);


        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(13 * CELL_WIDTH);
        imageView.setY(24 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        imageView.setUserData(princessTowerBlueRight);
        towersImageViews.add(imageView);
        gameView.getChildren().add(imageView);

        startTimer();
    }

    /**
     * Robot random pick and drop card.
     */
    public void robotRandomPickAndDropCard() {
        if (gameModel.getRobotSelectedCard() == null) {
            gameModel.setRobotSelectedCard(robotHandCard.get(new Random().nextInt(4)));

        }
        if (gameModel.getRobotSelectedCard().getCost() <= gameModel.getRobotElixirAmount()) {
            Point2D dropLocation;
            do {
                int row = new Random().nextInt(14) + 8;
                int column = new Random().nextInt(17) + 1;
                dropLocation = new Point2D(column * 20, row * 20);
            } while (!checkCorrectDrop(dropLocation, gameModel.getRobotSelectedCard()));

            gameModel.setRobotElixirAmount(gameModel.getRobotElixirAmount() - gameModel.getRobotSelectedCard().getCost());
            gameModel.getRobotMechanisms().add(gameModel.getRobotSelectedCard());
            gameModel.getRobotSelectedCard().setLocation(dropLocation);
            gameModel.getRobotSelectedCard().start(gameModel, gameView);
            robotNextCard();
        }

    }

    /**
     * Robot next card.
     */
    public void robotNextCard() {
        robotHandCard.remove(gameModel.getRobotSelectedCard());
        robotHandCard.add(gameModel.getRobotNextCard());
        gameModel.setRobotSelectedCard(null);
    }


    /**
     * Player next card.
     */
    public void playerNextCard() {
        if (firstCardImageView.getUserData() == gameModel.getPlayerSelectedCard()) {
            firstCardImageView.setImage(nextCardImageView.getImage());
            firstCardImageView.setUserData(nextCardImageView.getUserData());
            gameModel.setPlayerSelectedCard(null);
        } else if (secondCardImageView.getUserData() == gameModel.getPlayerSelectedCard()) {
            secondCardImageView.setImage(nextCardImageView.getImage());
            secondCardImageView.setUserData(nextCardImageView.getUserData());
            gameModel.setPlayerSelectedCard(null);
        } else if (thirdCardImageView.getUserData() == gameModel.getPlayerSelectedCard()) {
            thirdCardImageView.setImage(nextCardImageView.getImage());
            thirdCardImageView.setUserData(nextCardImageView.getUserData());
            gameModel.setPlayerSelectedCard(null);
        } else if (fourthCardImageView.getUserData() == gameModel.getPlayerSelectedCard()) {
            fourthCardImageView.setImage(nextCardImageView.getImage());
            fourthCardImageView.setUserData(nextCardImageView.getUserData());
            gameModel.setPlayerSelectedCard(null);
        }
        Card playerNextCard = gameModel.getPlayerNextCard();
        while (playerNextCard == firstCardImageView.getUserData() || playerNextCard == secondCardImageView.getUserData()
                || playerNextCard == thirdCardImageView.getUserData() || playerNextCard == fourthCardImageView.getUserData()) {
            playerNextCard = gameModel.getPlayerNextCard();
        }
        nextCardImageView.setImage(playerNextCard.getImage());
        nextCardImageView.setUserData(playerNextCard);
    }

    /**
     * Player pick card.
     *
     * @param event the event
     */
    @FXML
    void playerPickCard(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        Card card = (Card) imageView.getUserData();
        gameModel.setPlayerSelectedCard(card);
    }

    /**
     * Player drop card.
     *
     * @param mouseEvent the mouse event
     */
    public void playerDropCard(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (gameModel.getPlayerSelectedCard() != null) {
            if (gameModel.getPlayerElixirAmount() >= gameModel.getPlayerSelectedCard().getCost()) {
                Point2D cardLocation = new Point2D(imageView.getX(), imageView.getY());
                if (checkCorrectDrop(cardLocation, gameModel.getPlayerSelectedCard())) {
                    gameModel.setPlayerElixirAmount(gameModel.getPlayerElixirAmount() - gameModel.getPlayerSelectedCard().getCost());
                    gameModel.getPlayerMechanism().add(gameModel.getPlayerSelectedCard());
                    gameModel.getPlayerSelectedCard().setLocation(cardLocation);
                    gameModel.getPlayerSelectedCard().start(gameModel, gameView);
                    playerNextCard();
                }
            }
        }

    }

    /**
     * Check correct drop boolean.
     *
     * @param dropLocation the drop location
     * @param card         the card
     * @return the boolean
     */
    public boolean checkCorrectDrop(Point2D dropLocation, Card card) {
        if (card instanceof Spell) {
            return true;
        } else {
            if ((gameModel.getRobotCards().contains(card) && dropLocation.getY() <= 15 * 20) ||
                    (gameModel.getPlayerCards().contains(card) && dropLocation.getY() >= 17 * 20)) {
                return true;
            } else {
                if (gameModel.getPlayerCards().contains(card)) {
                    ArrayList<Tower> robotTowers = gameModel.getRobotTowers();
                    for (Tower tower : robotTowers) {
                        if (tower.getHp() == 0) {
                            if (tower.getLocation().getX() < 6 * 20) {
                                if (dropLocation.getY() > 11 * 20 && dropLocation.getX() < 8 * 20) {
                                    return true;
                                }
                            } else if (tower.getLocation().getX() > 6 * 20) {
                                if (dropLocation.getY() > 11 * 20 && dropLocation.getX() > 8 * 20) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                } else if (gameModel.getRobotCards().contains(card)) {
                    ArrayList<Tower> playerTowers = gameModel.getPlayerTowers();
                    for (Tower tower : playerTowers) {
                        if (tower.getHp() == 0) {
                            if (tower.getLocation().getX() < 6 * 20) {
                                if (dropLocation.getY() < 21 * 20 && dropLocation.getX() < 8 * 20) {
                                    return true;
                                }
                            } else if (tower.getLocation().getX() > 6 * 20) {
                                if (dropLocation.getY() < 21 * 20 && dropLocation.getX() > 8 * 20) {
                                    return true;
                                }
                            }

                        }
                    }
                    return false;
                }
                return false;
            }
        }

    }

    /**
     * Check end of the game boolean.
     *
     * @return the boolean
     */
    public boolean checkEndOfTheGame() {
        if (System.currentTimeMillis() - gameModel.getStartTime() >= 3 * 60 * 1000) {
            return true;
        }
        ArrayList<Tower> enemyTowers = gameModel.getRobotTowers();
        ArrayList<Tower> playerTowers = gameModel.getPlayerTowers();
        for (Tower tower : enemyTowers) {
            if (!tower.isAlive()) {
                if (tower instanceof KingTower) {
                    return true;
                }
            }
        }
        for (Tower tower : playerTowers) {
            if (!tower.isAlive()) {
                if (tower instanceof KingTower) {
                    return true;
                }
            }
        }
        return false;
    }

    private void startTimer() {
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateMove();
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long) (1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);


        final double FRAMES_PER_SECOND2 = 0.5;
        Timer timer2 = new Timer();
        TimerTask timerTask2 = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateElixir();
                    }
                });
            }
        };
        long frameTimeInMilliseconds2 = (long) (1000.0 / FRAMES_PER_SECOND2);
        timer2.schedule(timerTask2, 0, frameTimeInMilliseconds2);


        final double FRAMES_PER_SECOND3 = 1;
        Timer timer3 = new Timer();
        TimerTask timerTask3 = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateTime();
                    }
                });
            }
        };
        long frameTimeInMilliseconds3 = (long) (1000.0 / FRAMES_PER_SECOND3);
        timer3.schedule(timerTask3, 0, frameTimeInMilliseconds3);


    }

    /**
     * Update move.
     */
    public void updateMove() {
        ArrayList<Mechanism> playerMechanisms = gameModel.getPlayerMechanism();
        for (Mechanism mechanism : playerMechanisms) {
            mechanism.move(gameView, getDirection(mechanism), gameModel);
        }
        robotRandomPickAndDropCard();
        ArrayList<Mechanism> robotMechanisms = gameModel.getRobotMechanisms();
        for (Mechanism mechanism : robotMechanisms) {
            mechanism.move(gameView, getDirection(mechanism), gameModel);
        }
        checkBreakTowers();
        if (checkEndOfTheGame()) {
            gameEnd();
        }
    }

    /**
     * Game end.
     */
    public void gameEnd() {
        timer.cancel();
        ArrayList<Tower> robotTowers = gameModel.getRobotTowers();
        ArrayList<Tower> playerTowers = gameModel.getPlayerTowers();
        int playerTowersHp = 0;
        int playerTowersNumber = 0;
        int robotTowersHp = 0;
        int robotTowersNumber = 0;
        for (Tower tower : robotTowers) {
            if (tower.getHp() > 0) {
                robotTowersNumber++;
                robotTowersHp += tower.getHp();
            }
        }
        for (Tower tower : playerTowers) {
            if (tower.getHp() > 0) {
                playerTowersNumber++;
                playerTowersHp += tower.getHp();
            }
        }
        if (robotTowersNumber == playerTowersNumber) {
            if (robotTowersHp > playerTowersHp) {
                playerProfile.getBattles().add(new Battle(playerProfile.getUserName(), "Robot"
                        , 3 - robotTowersNumber, 3 - playerTowersNumber, "Robot"));
                playerProfile.updateScore(70);
            } else {
                playerProfile.getBattles().add(new Battle(playerProfile.getUserName(), "Robot"
                        , 3 - robotTowersNumber, 3 - playerTowersNumber, playerProfile.getUserName()));
                playerProfile.updateScore(200);
            }
        } else {
            if (robotTowersNumber > playerTowersNumber) {
                playerProfile.getBattles().add(new Battle(playerProfile.getUserName(), "Robot"
                        , 3 - robotTowersNumber, 3 - playerTowersNumber, "Robot"));
                playerProfile.updateScore(70);
            } else {
                playerProfile.getBattles().add(new Battle(playerProfile.getUserName(), "Robot"
                        , 3 - robotTowersNumber, 3 - playerTowersNumber, playerProfile.getUserName()));
                playerProfile.updateScore(200);
            }
        }
        playerProfile.checklevel();

        try {
            Path path = Paths.get("./" + playerProfile.getUserName() + ".bin");
            Files.delete(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(playerProfile.getUserName() + ".bin");
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(playerProfile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.pause();
        //switch to menu
        Stage stage = (Stage) elixirLabel.getScene().getWindow();


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
     * Update time.
     */
    public void updateTime() {
        long time = System.currentTimeMillis() - gameModel.getStartTime();
        int timeLeft = (int) (gameModel.getGameTime() - time / 1000);
        if (timeLeft % 60 < 10) {
            timeLabel.setText(timeLeft / 60 + ":" + "0" + timeLeft % 60);
        } else {
            timeLabel.setText(timeLeft / 60 + ":" + timeLeft % 60);
        }

    }

    /**
     * Update elixir.
     */
    public void updateElixir() {
        long time = System.currentTimeMillis() - gameModel.getStartTime();
        if (gameModel.getPlayerElixirAmount() != 10) {
            if (time / 1000 < 60) {
                gameModel.setPlayerElixirAmount(gameModel.getPlayerElixirAmount() + 2);
            } else {
                gameModel.setPlayerElixirAmount(gameModel.getPlayerElixirAmount() + 1);
            }
        }
        if (gameModel.getRobotElixirAmount() != 10) {
            if (time / 1000 < 60) {
                gameModel.setRobotElixirAmount(gameModel.getRobotElixirAmount() + 2);
            } else {
                gameModel.setRobotElixirAmount(gameModel.getRobotElixirAmount() + 1);
            }
        }
        elixirLabel.setText(gameModel.getPlayerElixirAmount() + "");
        elixirProgressBar.setProgress((double) gameModel.getPlayerElixirAmount() / 10);

    }

    /**
     * Gets direction.
     *
     * @param mechanism the mechanism
     * @return the direction
     */
    public Mechanism.Direction getDirection(Mechanism mechanism) {
        if (mechanism instanceof Card) {
            Card card = (Card) mechanism;
            if (card.getLocation().getY() >= 16 * 20 && gameModel.isPlayerMechanism(card)) {
                if ((!(card.getLocation().getX() >= 3 * 20 && card.getLocation().getX() <= 4 * 20)) &&
                        (!(card.getLocation().getX() >= 14 * 20 && card.getLocation().getX() <= 15 * 20))) {
                    if (card.getLocation().getX() < 3 * 20) {
                        return Mechanism.Direction.Right;
                    } else if (card.getLocation().getX() > 4 * 20 && card.getLocation().getX() <= 8 * 20) {
                        return Mechanism.Direction.Left;
                    } else if (card.getLocation().getX() > 8 * 20 && card.getLocation().getX() < 14 * 20) {
                        return Mechanism.Direction.Right;
                    } else if (card.getLocation().getX() > 15 * 20) {
                        return Mechanism.Direction.Left;
                    }
                }
            } else if (card.getLocation().getY() < 5 * 20 && gameModel.isPlayerMechanism(card)) {
                if (card.getLocation().getX() > 10 * 20) {
                    return Mechanism.Direction.Left;
                } else if (card.getLocation().getX() < 8 * 20) {
                    return Mechanism.Direction.Right;
                }
            } else if (card.getLocation().getY() <= 16 * 20 && gameModel.isRobotMechanism(card)) {
                if ((!(card.getLocation().getX() >= 3 * 20 && card.getLocation().getX() <= 4 * 20)) &&
                        (!(card.getLocation().getX() >= 14 * 20 && card.getLocation().getX() <= 15 * 20))) {
                    if (card.getLocation().getX() < 3 * 20) {
                        return Mechanism.Direction.Right;
                    } else if (card.getLocation().getX() > 4 * 20 && card.getLocation().getX() <= 8 * 20) {
                        return Mechanism.Direction.Left;
                    } else if (card.getLocation().getX() > 8 * 20 && card.getLocation().getX() < 14 * 20) {
                        return Mechanism.Direction.Right;
                    } else if (card.getLocation().getX() > 15 * 20) {
                        return Mechanism.Direction.Left;
                    }
                }
            } else if (card.getLocation().getY() > 25 * 20 && gameModel.isRobotMechanism(card)) {
                if (card.getLocation().getX() > 10 * 20) {
                    return Mechanism.Direction.Left;
                } else if (card.getLocation().getX() < 8 * 20) {
                    return Mechanism.Direction.Right;
                }
            }
        } else {
            return null;
        }
        return Mechanism.Direction.UP;
    }

    /**
     * Sets player profile.
     *
     * @param playerProfile the player profile
     */
    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    /**
     * Check break towers.
     */
    public void checkBreakTowers() {
        ImageView deleteImageView = null;
        for (ImageView towerImageView : towersImageViews) {
            Tower tower = (Tower) towerImageView.getUserData();
            if (tower.getHp() <= 0) {
                ImageView newImageView = new ImageView();
                newImageView.setImage(new Image(getClass().getResourceAsStream("../Photos/grass.png")));
                newImageView.setX(towerImageView.getX());
                newImageView.setY(towerImageView.getY());
                newImageView.setFitHeight(towerImageView.getFitHeight());
                newImageView.setFitWidth(towerImageView.getFitWidth());
                gameView.getChildren().remove(towerImageView);
                gameView.getChildren().add(newImageView);
                deleteImageView = towerImageView;
            }
        }
        if (deleteImageView != null) {
            towersImageViews.remove(deleteImageView);
        }
    }

}

