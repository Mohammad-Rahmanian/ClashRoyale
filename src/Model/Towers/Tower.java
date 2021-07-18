package Model.Towers;

import Model.Mechanism;

public abstract class Tower extends Mechanism {
    private int hp;
    private int damage;
    private double hitSpeed;
    private double range;
    private boolean alive;
    private int level;

    public Tower(int hp, int damage, double hitSpeed, double range) {
        this.hp = hp;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.range = range;
        this.alive = true;
        this.level = 1;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public double getRange() {
        return range;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLevel() {
        return level;
    }

    public abstract void upgrade();
}
