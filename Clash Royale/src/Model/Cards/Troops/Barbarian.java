package Model.Cards.Troops;

import Model.Cards.Buildings.Building;
import Model.GameModel;
import Model.Mechanism;
import Model.Towers.Tower;
import View.GameView;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Barbarian.
 *  @author Mohammad Rahmanian - Mahmood Saneian.
 *  @version 1.0
 */
public class Barbarian extends Troop {
    private transient ImageView imageView;
    private transient Mechanism m = null;

    /**
     * Instantiates a new Barbarian.
     */
    public Barbarian() {
        super(300, 75, 1.5, Speed.MEDIUM,
                Target.GROUND, "Melee", false, 4, 5, "Barbarian");
        createImage();
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                this.setHp(330);
                this.setDamage(82);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(363);
                this.setDamage(90);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(438);
                this.setDamage(99);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(480);
                this.setDamage(109);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/Barbarian.jpg"));
        this.setImage(image);
        //Move & Attack Images
        this.setFirstAttack(new Image(getClass().getResourceAsStream("/photos/BarbarMove/player/barbarianAttack1.png")));
        this.setSecondAttack(new Image(getClass().getResourceAsStream("/photos/BarbarMove/player/barbarianAttack2.png")));
        this.setFirstMove(new Image(getClass().getResourceAsStream("/photos/BarbarMove/player/barbarianMove1.png")));
        this.setSecondMove(new Image(getClass().getResourceAsStream("/photos/BarbarMove/player/barbarianMove2.png")));
        this.setRobAttack1(new Image(getClass().getResourceAsStream("/photos/BarbarMove/robot/barbarianAttack1.png")));
        this.setRobAttack2(new Image(getClass().getResourceAsStream("/photos/BarbarMove/robot/barbarianAttack2.png")));
        this.setRobMove1(new Image(getClass().getResourceAsStream("/photos/BarbarMove/robot/barbarianMove1.png")));
        this.setRobMove2(new Image(getClass().getResourceAsStream("/photos/BarbarMove/robot/barbarianMove2.png")));
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        if (!(isDied())){
            if (m == null) {
                //Shoot to enemy mechanisms
                ArrayList<Mechanism> mechanisms = null;
                if (gameModel.isRobotMechanism(this))
                    mechanisms = gameModel.getPlayerMechanism();
                if (gameModel.isPlayerMechanism(this))
                    mechanisms = gameModel.getRobotMechanisms();
                if (mechanisms != null){
                    for (Mechanism mechanism : mechanisms) {
                        if ((this.getLocation().distance(mechanism.getLocation()) < 40.0) && (!(mechanism instanceof BabyDragon))) {
                            m = mechanism;
                            break;
                        }
                    }
                }
            }
            if (m != null) {
                //Action on enemy
                if (m instanceof Troop) {
                    Troop troop = (Troop) m;
                    troop.updateHp(this.getDamage());
                }
                if (m instanceof Tower) {
                    Tower tower = (Tower) m;
                    tower.updateHp(this.getDamage());
                }
                if (m instanceof Building) {
                    Building building = (Building) m;
                    building.updateHp(this.getDamage());
                }
                //Check end attack
                if (m instanceof Troop) {
                    Troop troop = (Troop) m;
                    if (troop.getHp() <= 0) {
                        setAct(false);
                        if (gameModel.isRobotMechanism(troop))
                            gameModel.removeRobotMechanism(troop);
                        if (gameModel.isPlayerMechanism(troop))
                            gameModel.removePlayerMechanism(troop);
                        m = null;
                    }
                }
                if (m instanceof Tower) {
                    Tower tower = (Tower) m;
                    if (tower.getHp() <= 0) {
                        setAct(false);
                        tower.setAlive(false);
                        if (gameModel.isRobotMechanism(tower))
                            gameModel.removeRobotMechanism(tower);
                        if (gameModel.isPlayerMechanism(tower))
                            gameModel.removePlayerMechanism(tower);
                        m = null;
                    }
                }
                if (m instanceof Building) {
                    Building building = (Building) m;
                    if (building.getHp() <= 0) {
                        setAct(false);
                        if (gameModel.isRobotMechanism(building))
                            gameModel.removeRobotMechanism(building);
                        if (gameModel.isPlayerMechanism(building))
                            gameModel.removePlayerMechanism(building);
                        m = null;
                    }
                }
            }
            //Check died
            if (this.getHp() <= 0){
                if (imageView != null){
                    if (imageView.getImage() != null){
                        gameView.getChildren().remove(imageView);
                        imageView = null;
                        if (gameModel.isRobotMechanism(this))
                            gameModel.removeRobotMechanism(this);
                        if (gameModel.isPlayerMechanism(this))
                            gameModel.removePlayerMechanism(this);
                        setDied(true);
                    }
                }
            }
            //Graphic attack
            if (gameModel.isPlayerMechanism(this)) {
                if (m != null) {
                    setAct(true);
                    if (imageView != null){
                        if (imageView.getImage().equals(getFirstMove()) || imageView.getImage().equals(getSecondMove())) {
                            gameView.getChildren().remove(imageView);
                            imageView = new ImageView();
                            imageView.setImage(getFirstAttack());
                            imageView.setX(this.getLocation().getX());
                            imageView.setY(this.getLocation().getY());
                            imageView.setFitWidth(60);
                            imageView.setFitHeight(60);
                            gameView.getChildren().add(imageView);
                        } else {
                            //Attack
                            if (imageView.getImage().equals(getFirstAttack())) {
                                gameView.getChildren().remove(imageView);
                                imageView = new ImageView(this.getSecondAttack());
                                imageView.setX(this.getLocation().getX());
                                imageView.setY(this.getLocation().getY());
                                imageView.setFitWidth(60);
                                imageView.setFitHeight(60);
                                gameView.getChildren().add(imageView);
                            } else if (imageView.getImage().equals(getSecondAttack())) {
                                gameView.getChildren().remove(imageView);
                                imageView = new ImageView(this.getFirstAttack());
                                imageView.setX(this.getLocation().getX());
                                imageView.setY(this.getLocation().getY());
                                imageView.setFitWidth(60);
                                imageView.setFitHeight(60);
                                gameView.getChildren().add(imageView);
                            }
                        }
                    }
                }
            } else if (gameModel.isRobotMechanism(this)) {
                if (m != null) {
                    setAct(true);
                    if (imageView != null){
                        if (imageView.getImage().equals(getRobMove1()) || imageView.getImage().equals(getRobMove2())) {
                            gameView.getChildren().remove(imageView);
                            imageView = new ImageView();
                            imageView.setImage(getRobAttack1());
                            imageView.setX(this.getLocation().getX());
                            imageView.setY(this.getLocation().getY());
                            imageView.setFitWidth(60);
                            imageView.setFitHeight(60);
                            gameView.getChildren().add(imageView);
                        } else {
                            //Attack
                            if (imageView.getImage().equals(getRobAttack1())) {
                                gameView.getChildren().remove(imageView);
                                imageView = new ImageView(this.getRobAttack2());
                                imageView.setX(this.getLocation().getX());
                                imageView.setY(this.getLocation().getY());
                                imageView.setFitWidth(60);
                                imageView.setFitHeight(60);
                                gameView.getChildren().add(imageView);
                            } else if (imageView.getImage().equals(getRobAttack2())) {
                                gameView.getChildren().remove(imageView);
                                imageView = new ImageView(this.getRobAttack1());
                                imageView.setX(this.getLocation().getX());
                                imageView.setY(this.getLocation().getY());
                                imageView.setFitWidth(60);
                                imageView.setFitHeight(60);
                                gameView.getChildren().add(imageView);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void start(GameModel gameModel, GameView gameView) {
        final double FRAMES_PER_SECOND = 1.0 / getHitSpeed();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        act(gameModel, gameView);
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long) (1000.0 / FRAMES_PER_SECOND);
        timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    @Override
    public void move(GameView gameView, Direction direction, GameModel gameModel) {
        if (gameModel.isPlayerMechanism(this)) {
            if (!(isAct())) {
                if (imageView == null) {
                    imageView = new ImageView();
                    imageView.setImage(this.getFirstMove());
                    imageView.setFitWidth(60);
                    imageView.setFitHeight(60);
                    gameView.getChildren().add(imageView);
                } else {
                    gameView.getChildren().remove(imageView);
                    if (imageView.getImage().equals(getRobAttack1()) || imageView.getImage().equals(getRobAttack2())){
                        imageView = new ImageView();
                        imageView.setImage(this.getRobMove1());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    }
                    //Move
                    if (imageView.getImage().equals(this.getFirstMove())) {
                        gameView.getChildren().remove(imageView);
                        imageView = new ImageView(this.getSecondMove());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    } else if (imageView.getImage().equals(this.getSecondMove())) {
                        gameView.getChildren().remove(imageView);
                        imageView = new ImageView(this.getFirstMove());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    }
                }
                //Update Location
                if (direction == Direction.UP) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX(), this.getLocation().getY() - 10));
                }
                if (direction == Direction.Left) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX() - 10, this.getLocation().getY()));
                }
                if (direction == Direction.Right) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX() + 10, this.getLocation().getY()));
                }
            }
        } else if (gameModel.isRobotMechanism(this)) {
            if (!(isAct())) {
                if (imageView == null) {
                    gameView.getChildren().remove(imageView);
                    imageView = new ImageView();
                    imageView.setImage(this.getRobMove1());
                    imageView.setFitWidth(60);
                    imageView.setFitHeight(60);
                    gameView.getChildren().add(imageView);
                } else {
                    gameView.getChildren().remove(imageView);
                    if (imageView.getImage().equals(getRobAttack1()) || imageView.getImage().equals(getRobAttack2())){
                        imageView = new ImageView();
                        imageView.setImage(this.getRobMove1());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    }
                    //Move
                    if (imageView.getImage().equals(this.getRobMove1())) {
                        gameView.getChildren().remove(imageView);
                        imageView = new ImageView(this.getRobMove2());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    } else if (imageView.getImage().equals(this.getRobMove2())) {
                        gameView.getChildren().remove(imageView);
                        imageView = new ImageView(this.getRobMove1());
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        gameView.getChildren().add(imageView);
                    }
                }
                //Update Location
                if (direction == Direction.UP) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX(), this.getLocation().getY() + 10));
                }
                if (direction == Direction.Left) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX() - 10, this.getLocation().getY()));
                }
                if (direction == Direction.Right) {
                    imageView.setX(this.getLocation().getX());
                    imageView.setY(this.getLocation().getY());
                    this.setLocation(new Point2D(this.getLocation().getX() + 10, this.getLocation().getY()));
                }
            }
        }
    }
}
