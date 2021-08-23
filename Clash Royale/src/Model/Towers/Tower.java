package Model.Towers;

import Model.Mechanism;

/**
 * The type Tower.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Tower extends Mechanism {
    private int hp;
    private int damage;
    private double hitSpeed;
    private double range;
    private boolean alive;
    private int level;

    /**
     * Instantiates a new Tower.
     *
     * @param hp       the hp
     * @param damage   the damage
     * @param hitSpeed the hit speed
     * @param range    the range
     */
    public Tower(int hp, int damage, double hitSpeed, double range) {
        this.hp = hp;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.range = range;
        this.alive = true;
        this.level = 1;
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
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Sets alive.
     *
     * @param alive the alive
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
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
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
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
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
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
     * Gets range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return alive;
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
     * Upgrade.
     */
    public abstract void upgrade();

    /**
     * Update hp.
     *
     * @param enemyDamage the enemy damage
     */
    public void updateHp(int enemyDamage) {
        hp -= enemyDamage;
    }
}
