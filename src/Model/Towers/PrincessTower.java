package Model.Towers;

public class PrincessTower extends Tower {

    public PrincessTower() {
        super(1400,50,0.8,7.5);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()) {
            case 1:
                this.setHp(1512);
                this.setDamage(54);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(1624);
                this.setDamage(58);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1750);
                this.setDamage(62);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1890);
                this.setDamage(69);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
