package Model.Cards.Spells;

import Model.Cards.Card;

public abstract class Spell extends Card {
    private String ability;
    private double radius;

    public Spell(int cost, String ability, double radius) {
        super(cost);
        this.ability = ability;
        this.radius = radius;
    }

    public String getAbility() {
        return ability;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public abstract void upgrade();
}
