package Model.Towers;

public class KingTower extends Tower {
    private boolean canShoot;

    public KingTower() {
        super(2400,50,1.0,7.0);
        canShoot = false;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(2568);
                this.setDamage(53);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(2736);
                this.setDamage(57);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(2904);
                this.setDamage(60);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(3096);
                this.setDamage(64);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
