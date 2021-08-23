package Model.Cards.Troops;

import Model.Cards.Card;
import javafx.scene.image.Image;

/**
 * The type Troop.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public abstract class Troop extends Card {
    private int hp;
    private int damage;
    private double hitSpeed;
    private Speed speed;
    private Target target;
    private String range;
    private boolean isAreaSplash;
    private int count;
    private boolean isAct;
    private boolean died;
    private transient Image firstMove;
    private transient Image secondMove;
    private transient Image firstAttack;
    private transient Image secondAttack;
    private transient Image robMove1;
    private transient Image robMove2;
    private transient Image robAttack1;
    private transient Image robAttack2;

    /**
     * The enum Speed.
     */
    public enum Speed {
        /**
         * Slow speed.
         */
        SLOW,
        /**
         * Medium speed.
         */
        MEDIUM,
        /**
         * Fast speed.
         */
        FAST;
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
        AIRGROUND,
        /**
         * Buildings target.
         */
        BUILDINGS;
    }


    /**
     * Instantiates a new Troop.
     *
     * @param hp           the hp
     * @param damage       the damage
     * @param hitSpeed     the hit speed
     * @param speed        the speed
     * @param target       the target
     * @param range        the range
     * @param isAreaSplash the is area splash
     * @param count        the count
     * @param cost         the cost
     * @param name         the name
     */
    public Troop(int hp, int damage, double hitSpeed,
                 Speed speed, Target target, String range,
                 boolean isAreaSplash, int count, int cost, String name) {
        super(cost, name);
        this.hp = hp;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.speed = speed;
        this.target = target;
        this.range = range;
        this.isAreaSplash = isAreaSplash;
        this.count = count;
        this.died = false;
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
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Speed speed) {
        this.speed = speed;
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
     * Sets area splash.
     *
     * @param areaSplash the area splash
     */
    public void setAreaSplash(boolean areaSplash) {
        isAreaSplash = areaSplash;
    }

    /**
     * Sets act.
     *
     * @param act the act
     */
    public void setAct(boolean act) {
        isAct = act;
    }

    /**
     * Sets first move.
     *
     * @param firstMove the first move
     */
    public void setFirstMove(Image firstMove) {
        this.firstMove = firstMove;
    }

    /**
     * Sets second move.
     *
     * @param secondMove the second move
     */
    public void setSecondMove(Image secondMove) {
        this.secondMove = secondMove;
    }

    /**
     * Sets first attack.
     *
     * @param firstAttack the first attack
     */
    public void setFirstAttack(Image firstAttack) {
        this.firstAttack = firstAttack;
    }

    /**
     * Sets second attack.
     *
     * @param secondAttack the second attack
     */
    public void setSecondAttack(Image secondAttack) {
        this.secondAttack = secondAttack;
    }

    /**
     * Sets rob move 1.
     *
     * @param robMove1 the rob move 1
     */
    public void setRobMove1(Image robMove1) {
        this.robMove1 = robMove1;
    }

    /**
     * Sets rob move 2.
     *
     * @param robMove2 the rob move 2
     */
    public void setRobMove2(Image robMove2) {
        this.robMove2 = robMove2;
    }

    /**
     * Sets rob attack 1.
     *
     * @param robAttack1 the rob attack 1
     */
    public void setRobAttack1(Image robAttack1) {
        this.robAttack1 = robAttack1;
    }

    /**
     * Sets rob attack 2.
     *
     * @param robAttack2 the rob attack 2
     */
    public void setRobAttack2(Image robAttack2) {
        this.robAttack2 = robAttack2;
    }

    /**
     * Is act boolean.
     *
     * @return the boolean
     */
    public boolean isAct() {
        return isAct;
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
     * Is died boolean.
     *
     * @return the boolean
     */
    public boolean isDied() {
        return died;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Speed getSpeed() {
        return speed;
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
    public String getRange() {
        return range;
    }

    /**
     * Gets first move.
     *
     * @return the first move
     */
    public Image getFirstMove() {
        return firstMove;
    }

    /**
     * Gets second move.
     *
     * @return the second move
     */
    public Image getSecondMove() {
        return secondMove;
    }

    /**
     * Gets first attack.
     *
     * @return the first attack
     */
    public Image getFirstAttack() {
        return firstAttack;
    }

    /**
     * Gets second attack.
     *
     * @return the second attack
     */
    public Image getSecondAttack() {
        return secondAttack;
    }

    /**
     * Gets rob move 1.
     *
     * @return the rob move 1
     */
    public Image getRobMove1() {
        return robMove1;
    }

    /**
     * Gets rob move 2.
     *
     * @return the rob move 2
     */
    public Image getRobMove2() {
        return robMove2;
    }

    /**
     * Gets rob attack 1.
     *
     * @return the rob attack 1
     */
    public Image getRobAttack1() {
        return robAttack1;
    }

    /**
     * Gets rob attack 2.
     *
     * @return the rob attack 2
     */
    public Image getRobAttack2() {
        return robAttack2;
    }

    /**
     * Is area splash boolean.
     *
     * @return the boolean
     */
    public boolean isAreaSplash() {
        return isAreaSplash;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
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
