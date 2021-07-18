package Model.Cards;

import Model.Mechanism;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Card extends Mechanism implements Serializable {
    private int level;
    private int cost;
    private String name;
    private transient Image image;

    public Card(int cost, String name) {
        level = 1;
        this.cost = cost;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getCost() {
        return cost;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public abstract void upgrade();

    public abstract void createImage();
}
