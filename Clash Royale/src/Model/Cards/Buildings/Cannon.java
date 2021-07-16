package Model.Cards.Buildings;

public class Cannon extends Building {
    private int damage;

    public Cannon() {
        super(6,380,0.8,Target.GROUND,5.5,30);
        damage = 60;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(418);
                damage = 66;
                this.setLevel(2);
                break;
            case 2:
                this.setHp(459);
                damage = 72;
                this.setLevel(3);
                break;
            case 3:
                this.setHp(505);
                damage = 79;
                this.setLevel(4);
                break;
            case 4:
                this.setHp(554);
                damage = 87;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
