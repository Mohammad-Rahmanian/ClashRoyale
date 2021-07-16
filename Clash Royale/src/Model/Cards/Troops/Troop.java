package Model.Cards.Troops;

import Model.Cards.Card;

public abstract class Troop extends Card {
    private int hp;
    private int damage;
    private double hitSpeed;
    private Speed speed;
    private Target target;
    private String range;
    private boolean isAreaSplash;
    private int count;
    private int cost;

    public enum Speed{
        SLOW, MEDIUM, FAST;
    }

    public enum Target{
        AIR, GROUND, AIRGROUND,BUILDINGS;
    }

    public Troop(int hp, int damage, double hitSpeed,
                 Speed speed, Target target, String range,
                 boolean isAreaSplash, int count, int cost) {
        super(cost);
        this.hp = hp;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.speed = speed;
        this.target = target;
        this.range = range;
        this.isAreaSplash = isAreaSplash;
        this.count = count;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public double getHitSpeed() {
        return hitSpeed;
    }

    public Speed getSpeed() {
        return speed;
    }

    public Target getTarget() {
        return target;
    }

    public String getRange() {
        return range;
    }

    public boolean isAreaSplash() {
        return isAreaSplash;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public abstract void upgrade();
}
