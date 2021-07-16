package Model.Cards.Troops;

public class Barbarian extends Troop {

    public Barbarian() {
        super(300,75,1.5,Speed.MEDIUM,
                Target.GROUND,"Melee",false,4,5);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(330);
                this.setDamage(82);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(363);
                this.setDamage(90);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(438);
                this.setDamage(99);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(480);
                this.setDamage(109);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
