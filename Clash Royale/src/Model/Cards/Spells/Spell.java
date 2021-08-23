package Model.Cards.Spells;

import Model.Cards.Card;

/**
 * The type Spell.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Spell extends Card {
    private String ability;
    private double radius;
    private boolean died = false;

    /**
     * Instantiates a new Spell.
     *
     * @param cost    the cost
     * @param ability the ability
     * @param radius  the radius
     * @param name    the name
     */
    public Spell(int cost, String ability, double radius, String name) {
        super(cost, name);
        this.ability = ability;
        this.radius = radius;
    }

    /**
     * Gets ability.
     *
     * @return the ability
     */
    public String getAbility() {
        return ability;
    }

    /**
     * Is died boolean.
     *
     * @return the boolean
     */
    public boolean isDied() {
        return died;
    }

    /**
     * Sets died.
     *
     * @param died the died
     */
    public void setDied(boolean died) {
        this.died = died;
    }

    /**
     * Sets ability.
     *
     * @param ability the ability
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public abstract void upgrade();

    @Override
    public abstract void createImage();
}
