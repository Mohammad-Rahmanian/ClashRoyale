package Model.Cards.Spells;

import Model.Cards.Buildings.Cannon;
import Model.Cards.Troops.Troop;
import Model.GameModel;
import Model.Mechanism;
import Model.Towers.Tower;
import View.GameView;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Rage.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class Rage extends Spell {
    private double duration;
    private long start = 0;
    private long end = 0;
    private transient Circle circle = null;

    /**
     * Instantiates a new Rage.
     */
    public Rage() {
        super(3, "+40% Damage Boost" + "\n" + "+40% Speed Boost" + "\n" + "+40% Hit Speed Boost",
                5.0, "Rage");
        duration = 6.0;
        createImage();
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                duration = 6.5;
                this.setLevel(2);
                break;
            case 2:
                duration = 7.0;
                this.setLevel(3);
                break;
            case 3:
                duration = 7.5;
                this.setLevel(4);
                break;
            case 4:
                duration = 8.0;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/rage.jpg"));
        this.setImage(image);
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        if (!(isDied())) {
            //Action on mechanisms
            ArrayList<Mechanism> mechanisms = null;
            if (gameModel.isRobotMechanism(this))
                mechanisms = gameModel.getRobotMechanisms();
            if (gameModel.isPlayerMechanism(this))
                mechanisms = gameModel.getPlayerMechanism();
            if (mechanisms != null) {
                for (Mechanism mechanism : mechanisms) {
                    if (this.getLocation().distance(mechanism.getLocation()) < getRadius() * 20) {
                        if (mechanism instanceof Tower) {
                            Tower tower = (Tower) mechanism;
                            tower.setDamage(tower.getDamage() + (40 / 100 * tower.getDamage()));
                            tower.setHitSpeed(tower.getHitSpeed() + (40 / 100 * tower.getHitSpeed()));
                        }
                        if (mechanism instanceof Cannon) {
                            Cannon cannon = (Cannon) mechanism;
                            cannon.setDamage(cannon.getDamage() + (40 / 100 * cannon.getDamage()));
                            cannon.setHitSpeed(cannon.getHitSpeed() + (40 / 100) * cannon.getHitSpeed());
                        }
                        if (mechanism instanceof Troop) {
                            Troop troop = (Troop) mechanism;
                            troop.setDamage(troop.getDamage() + (40 / 100 + troop.getDamage()));
                            troop.setHitSpeed(troop.getHitSpeed() + (40 / 100) + troop.getHitSpeed());
                            if (troop.getSpeed() == Troop.Speed.SLOW) {
                                troop.setSpeed(Troop.Speed.SLOW);
                            } else if (troop.getSpeed() == Troop.Speed.MEDIUM) {
                                troop.setSpeed(Troop.Speed.FAST);
                            }
                        }
                    }
                }
            }
            //Create purple circle
            if (circle == null) {
                circle = new Circle();
                circle.setCenterX(this.getLocation().getX());
                circle.setCenterY(this.getLocation().getY());
                circle.setRadius(this.getRadius() * 10);
                circle.setOpacity(0.1);
                circle.setFill(Color.PURPLE);
                //Transition
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), circle);
                fadeTransition.setFromValue(0.5);
                fadeTransition.setToValue(0.1);
                fadeTransition.setCycleCount(Timeline.INDEFINITE);
                fadeTransition.setAutoReverse(true);
                fadeTransition.play();
                //Add to pane
                gameView.getChildren().add(circle);

                start = System.currentTimeMillis();
                end = (long) (start + duration * 1000);
            }
            if (System.currentTimeMillis() >= end) {
                gameView.getChildren().remove(circle);
                circle = null;
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
        final double FRAMES_PER_SECOND = 1.0 / duration;
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
