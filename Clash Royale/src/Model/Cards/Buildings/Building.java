package Model.Cards.Buildings;

import Model.Cards.Card;

public abstract class Building extends Card {
    private int hp;
    private double hitSpeed;
    private Target target;
    private double range;
    private int lifeTime;

    public Building(int cost, int hp,double hitSpeed,
                    Target target, double range, int lifeTime) {
        super(cost);
        this.hp = hp;
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public double getHitSpeed() {
        return hitSpeed;
    }

    public Target getTarget() {
        return target;
    }

    public double getRange() {
        return range;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public enum Target{
        AIR, GROUND, AIRGROUND;
    }

    @Override
    public abstract void upgrade();
}
