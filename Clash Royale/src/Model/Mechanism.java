package Model;

import View.GameView;
import javafx.geometry.Point2D;

import java.util.Objects;

/**
 * The type Mechanism.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Mechanism {
    private Point2D location;

    /**
     * The enum Direction.
     */
    public enum Direction {
        /**
         * Up direction.
         */
        UP,
        /**
         * Left direction.
         */
        Left,
        /**
         * Right direction.
         */
        Right;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Point2D location) {
        this.location = location;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Point2D getLocation() {
        return location;
    }

    /**
     * Act.
     *
     * @param gameModel the game model
     * @param gameView  the game view
     */
    public abstract void act(GameModel gameModel, GameView gameView);

    /**
     * Start.
     *
     * @param gameModel the game model
     * @param gameView  the game view
     */
    public abstract void start(GameModel gameModel, GameView gameView);

    /**
     * Move.
     *
     * @param gameView  the game view
     * @param direction the direction
     * @param gameModel the game model
     */
    public abstract void move(GameView gameView, Direction direction, GameModel gameModel);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanism)) return false;
        Mechanism mechanism = (Mechanism) o;
        return Objects.equals(getLocation(), mechanism.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }
}
