package Model.Cards.Spells;

import Model.Cards.Buildings.Building;
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
 * The type Arrow.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class Arrow extends Spell {
    private int areaDamage;
    private long start = 0;
    private long end = 0;
    private transient Circle circle = null;

    /**
     * Instantiates a new Arrow.
     */
    public Arrow() {
        super(3, "Arrows pepper a large area, damaging\n" +
                "everyone hit. Reduced damage to\n" +
                "Crown Towers.", 4.0, "Arrow");
        areaDamage = 144;
        createImage();
    }

    /**
     * Gets area damage.
     *
     * @return the area damage
     */
    public int getAreaDamage() {
        return areaDamage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                areaDamage = 156;
                this.setLevel(2);
                break;
            case 2:
                areaDamage = 174;
                this.setLevel(3);
                break;
            case 3:
                areaDamage = 189;
                this.setLevel(4);
                break;
            case 4:
                areaDamage = 210;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/arrow.jpg"));
        this.setImage(image);
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        if (!(isDied())) {
            //Action on mechanisms
            //Shoot to enemy mechanisms
            ArrayList<Mechanism> mechanisms = null;
            if (gameModel.isRobotMechanism(this))
                mechanisms = gameModel.getPlayerMechanism();
            if (gameModel.isPlayerMechanism(this))
                mechanisms = gameModel.getRobotMechanisms();
            for (Mechanism mechanism : mechanisms) {
                if (this.getLocation().distance(mechanism.getLocation()) < getRadius() * 20.0) {
                    if (mechanism instanceof Troop) {
                        Troop troop = (Troop) mechanism;
                        troop.updateHp(getAreaDamage());
                    }
                    if (mechanism instanceof Building) {
                        Building building = (Building) mechanism;
                        building.updateHp(getAreaDamage());
                    }
                    if (mechanism instanceof Tower) {
                        Tower tower = (Tower) mechanism;
                        tower.updateHp(getAreaDamage());
                    }
                }
            }
            //Create Red circle
            if (circle == null) {
                circle = new Circle();
                circle.setCenterX(this.getLocation().getX());
                circle.setCenterY(this.getLocation().getY());
                circle.setRadius(this.getRadius() * 10);
                circle.setOpacity(0.3);
                circle.setFill(Color.RED);
                //Transition
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), circle);
                fadeTransition.setFromValue(0.8);
                fadeTransition.setToValue(0.3);
                fadeTransition.setCycleCount(Timeline.INDEFINITE);
                fadeTransition.setAutoReverse(true);
                fadeTransition.play();
                //Add to scene
                gameView.getChildren().add(circle);

                start = System.currentTimeMillis();
                end = start + 10 * 1000;
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
        final double FRAMES_PER_SECOND = 1.0;
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
