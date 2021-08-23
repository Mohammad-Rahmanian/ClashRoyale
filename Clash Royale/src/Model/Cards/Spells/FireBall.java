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
 * The type Fire ball.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class FireBall extends Spell {
    private int areaDamage;
    private transient Circle circle = null;
    private long start = 0;
    private long end = 0;


    /**
     * Instantiates a new Fire ball.
     */
    public FireBall() {
        super(4, "Incinerates a small area, dealing high\n" +
                "damage. Reduced damage to Crown\n" +
                "Towers.", 2.5, "FireBall");
        areaDamage = 325;
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
                areaDamage = 357;
                this.setLevel(2);
                break;
            case 2:
                areaDamage = 393;
                this.setLevel(3);
                break;
            case 3:
                areaDamage = 432;
                this.setLevel(4);
                break;
            case 4:
                areaDamage = 474;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/fireBall.jpg"));
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
                if (this.getLocation().distance(mechanism.getLocation()) < getRadius() * 20) {
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
            //Create Orange circle
            if (circle == null) {
                //Create orange circle
                circle = new Circle();
                circle.setCenterX(this.getLocation().getX());
                circle.setCenterY(this.getLocation().getY());
                circle.setRadius(this.getRadius() * 20);
                circle.setOpacity(0.3);
                circle.setFill(Color.ORANGE);
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
