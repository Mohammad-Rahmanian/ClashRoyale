package Model.Cards;

import Model.Mechanism;

public abstract class Card extends Mechanism {
    private int level;
    private int cost;

    public Card(int cost) {
        level = 1;
        this.cost = cost;
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

    public abstract void upgrade();
}
