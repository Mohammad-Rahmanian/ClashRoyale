package Model.Cards.Buildings;

import Model.Cards.Troops.BabyDragon;
import Model.Cards.Troops.Troop;
import Model.GameModel;
import Model.Mechanism;
import Model.Towers.Tower;
import View.GameView;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Cannon.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class Cannon extends Building {
    private int damage;
    private transient Mechanism m = null;
    private transient ImageView imageView = null;
    private long start = 0;
    private long end = 0;

    /**
     * Instantiates a new Cannon.
     */
    public Cannon() {
        super(6, 380, 0.8, Target.GROUND, 5.5, 30, "Cannon");
        damage = 60;
        createImage();
    }

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                this.setHp(418);
                damage = 66;
                this.setLevel(2);
                break;
            case 2:
                this.setHp(459);
                damage = 72;
                this.setLevel(3);
                break;
            case 3:
                this.setHp(505);
                damage = 79;
                this.setLevel(4);
                break;
            case 4:
                this.setHp(554);
                damage = 87;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/cannon.jpg"));
        this.setImage(image);
        //Map image
        this.setMapImage(new Image(getClass().getResourceAsStream("/photos/cannonMap.jpg")));
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        if (!(isDied())) {
            if (m == null) {
                //Shoot to enemy mechanisms
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
                //
                double x = 0;
                double y = 0;
                if (m != null) {
                    //Action on enemy
                    if (m instanceof Troop) {
                        Troop troop = (Troop) m;
                        troop.updateHp(this.getDamage());
                        x = troop.getLocation().getX();
                        y = troop.getLocation().getY();
                    }
                    if (m instanceof Tower) {
                        Tower tower = (Tower) m;
                        tower.updateHp(this.getDamage());
                        x = tower.getLocation().getX();
                        y = tower.getLocation().getY();
                    }
                    if (m instanceof Building) {
                        Building building = (Building) m;
                        building.updateHp(this.getDamage());
                        x = building.getLocation().getX();
                        y = building.getLocation().getY();
                    }
                    //Shoot
                    Circle circle = new Circle();
                    if (x != 0 && y != 0) {
                        //Create Shoot
                        circle.setCenterX(this.getLocation().getX());
                        circle.setCenterY(this.getLocation().getY());
                        circle.setRadius(10);
                        circle.setOpacity(1.0);
                        circle.setFill(Color.ORANGE);
                        //path
                        Line path = new Line();
                        path.setStartX(this.getLocation().getX());
                        path.setStartY(this.getLocation().getY());
                        path.setEndX(x);
                        path.setEndY(y);
                        path.setStrokeWidth(3.0);
                        //Transition
                        PathTransition transition = new PathTransition(Duration.seconds(2), path, circle);
                        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        transition.play();
                        //Add to Scene
                        gameView.getChildren().add(circle);
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
