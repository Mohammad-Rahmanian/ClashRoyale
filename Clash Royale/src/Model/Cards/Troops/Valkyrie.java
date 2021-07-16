package Model.Cards.Troops;

public class Valkyrie extends Troop {

    public Valkyrie() {
        super(880,120,1.5,Speed.MEDIUM,
                Target.GROUND,"Melee",true,1,4);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(968);
                this.setDamage(132);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(1064);
                this.setDamage(145);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1170);
                this.setDamage(159);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1284);
                this.setDamage(175);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
