package Model.Cards.Buildings;

import Model.Cards.Troops.BabyDragon;
import Model.Cards.Troops.Troop;
import Model.GameModel;
import Model.Mechanism;
import Model.Towers.Tower;
import View.GameView;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Inferno tower.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class InfernoTower extends Building {
    private String damage;
    private transient Mechanism m = null;
    private transient ImageView imageView = null;
    private long start = 0;
    private long end = 0;

    /**
     * Instantiates a new Inferno tower.
     */
    public InfernoTower() {
        super(5, 800, 0.4, Target.AIRGROUND, 6, 40, "InfernoTower");
        damage = "20-400";
        createImage();
    }

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public String getDamage() {
        return damage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                this.setHp(880);
                damage = "22-440";
                this.setLevel(2);
                break;
            case 2:
                this.setHp(968);
                damage = "24-484";
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1064);
                damage = "26-532";
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1168);
                damage = "29-584";
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/infernoTower.jpg"));
        this.setImage(image);
        //Map image
        this.setMapImage(new Image(getClass().getResourceAsStream("/photos/infernoTowerMap.png")));
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        if (!(isDied())) {
            String[] split = damage.split("-");
            int damage1 = Integer.parseInt(split[0]);
            //Shoot to enemy Mechanisms
            ArrayList<Mechanism> mechanisms = null;
            if (gameModel.isRobotMechanism(this))
                mechanisms = gameModel.getPlayerMechanism();
            if (gameModel.isPlayerMechanism(this))
                mechanisms = gameModel.getRobotMechanisms();
            if (mechanisms != null) {
                for (Mechanism mechanism : mechanisms) {
                    if ((this.getRange() * 20 >= this.getLocation().distance(mechanism.getLocation())) && (!(mechanism instanceof BabyDragon))) {
                        m = mechanism;
                        break;
                    }
                }
            }
            double x = 0;
            double y = 0;
            if (m != null) {
                //Action on enemy
                if (m instanceof Troop) {
                    Troop troop = (Troop) m;
                    troop.updateHp(damage1);
                }
                if (m instanceof Building) {
                    Building building = (Building) m;
                    building.updateHp(damage1);
                }
                if (m instanceof Tower) {
                    Tower tower = (Tower) m;
                    tower.updateHp(damage1);
                }
                //Shoot
                Line line = new Line();
                if (x != 0 && y != 0) {
                    //Shoot to target
                    line.setStartX(this.getLocation().getX());
                    line.setStartY(this.getLocation().getY());
                    line.setEndX(x);
                    line.setEndY(y);
                    line.setStroke(Color.RED);
                    line.setStrokeWidth(3.0);
                    //Transition
                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.3);
                    fadeTransition.setCycleCount(Timeline.INDEFINITE);
                    fadeTransition.setAutoReverse(true);
                    fadeTransition.play();
                    //Add to Scene
                    gameView.getChildren().add(line);
                }
                //Check end attack
                if (m instanceof Troop) {
                    Troop troop = (Troop) m;
                    if (troop.getHp() <= 0) {
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
                        if (gameModel.isRobotMechanism(building))
                            gameModel.removeRobotMechanism(building);
                        if (gameModel.isPlayerMechanism(building))
                            gameModel.removePlayerMechanism(building);
                        m = null;
                    }
                }
            }
            //Graphic
            if (imageView == null) {
                imageView = new ImageView(this.getMapImage());
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
                imageView.setX(getLocation().getX());
                imageView.setY(getLocation().getY());
                gameView.getChildren().add(imageView);
                start = System.currentTimeMillis();
                end = (long) (start + getLifeTime() * 1000);
            }
            if (System.currentTimeMillis() >= end) {
                gameView.getChildren().remove(imageView);
                imageView = null;
                if (gameModel.isPlayerMechanism(this))
                    gameModel.removePlayerMechanism(this);
                if (gameModel.isRobotMechanism(this))
                    gameModel.removeRobotMechanism(this);
                setDied(true);
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

    }
}
