package Model.Cards;

import Model.Mechanism;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Card.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Card extends Mechanism implements Serializable {
    private int level;
    private int cost;
    private String name;
    private transient Image image;

    /**
     * Instantiates a new Card.
     *
     * @param cost the cost
     * @param name the name
     */
    public Card(int cost, String name) {
        level = 1;
        this.cost = cost;
        this.name = name;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        if (!super.equals(o)) return false;
        Card card = (Card) o;
        return getLevel() == card.getLevel() && getCost() == card.getCost() && Objects.equals(getName(), card.getName()) && Objects.equals(getImage(), card.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLevel(), getCost(), getName(), getImage());
    }

    /**
     * Upgrade.
     */
    public abstract void upgrade();

    /**
     * Create image.
     */
    public abstract void createImage();
}
