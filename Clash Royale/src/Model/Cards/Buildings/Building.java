package Model.Cards.Buildings;

import Model.Cards.Card;
import javafx.scene.image.Image;

/**
 * The type Building.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Building extends Card {
    private int hp;
    private double hitSpeed;
    private Target target;
    private double range;
    private int lifeTime;
    private transient Image mapImage;
    private boolean died = false;

    /**
     * Instantiates a new Building.
     *
     * @param cost     the cost
     * @param hp       the hp
     * @param hitSpeed the hit speed
     * @param target   the target
     * @param range    the range
     * @param lifeTime the life time
     * @param name     the name
     */
    public Building(int cost, int hp, double hitSpeed,
                    Target target, double range, int lifeTime, String name) {
        super(cost, name);
        this.hp = hp;
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
    }

    /**
     * Sets hp.
     *
     * @param hp the hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Sets map image.
     *
     * @param mapImage the map image
     */
    public void setMapImage(Image mapImage) {
        this.mapImage = mapImage;
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
     * Gets hp.
     *
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets hit speed.
     *
     * @return the hit speed
     */
    public double getHitSpeed() {
        return hitSpeed;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public Target getTarget() {
        return target;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Gets life time.
     *
     * @return the life time
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * Gets map image.
     *
     * @return the map image
     */
    public Image getMapImage() {
        return mapImage;
    }

    /**
     * The enum Target.
     */
    public enum Target {
        /**
         * Air target.
         */
        AIR,
        /**
         * Ground target.
         */
        GROUND,
        /**
         * Airground target.
         */
        AIRGROUND;
    }

    @Override
    public abstract void upgrade();

    @Override
    public abstract void createImage();

    /**
     * Update hp.
     *
     * @param enemyDamage the enemy damage
     */
    public void updateHp(int enemyDamage) {
        hp -= enemyDamage;
    }
}
