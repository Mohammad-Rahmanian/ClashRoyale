package Model.Towers;

import Model.Cards.Buildings.Building;
import Model.Cards.Troops.Troop;
import Model.GameModel;
import Model.Mechanism;
import View.GameView;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Princess tower.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class PrincessTower extends Tower {
    private transient Mechanism m = null;

    /**
     * Instantiates a new Princess tower.
     */
    public PrincessTower() {
        super(1400, 50, 0.8, 7.5);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                this.setHp(1512);
                this.setDamage(54);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(1624);
                this.setDamage(58);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1750);
                this.setDamage(62);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1890);
                this.setDamage(69);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void act(GameModel gameModel, GameView gameView) {
        //Shoot to enemy mechanisms
        ArrayList<Mechanism> mechanisms = null;
        if (gameModel.isRobotMechanism(this))
            mechanisms = gameModel.getPlayerMechanism();
        if (gameModel.isPlayerMechanism(this))
            mechanisms = gameModel.getRobotMechanisms();
        for (Mechanism mechanism : mechanisms) {
            if (this.getRange() > this.getLocation().distance(mechanism.getLocation())) {
                m = mechanism;
                break;
            }
        }
        //Next section
        if (m != null) {
            //Action on enemy
            if (m instanceof Troop) {
                Troop troop = (Troop) m;
                troop.updateHp(this.getDamage());
            }
            if (m instanceof Building) {
                Building building = (Building) m;
                building.updateHp(this.getDamage());
            }
            //Check end action
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
