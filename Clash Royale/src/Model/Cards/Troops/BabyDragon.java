package Model.Cards.Troops;

public class BabyDragon extends Troop {

    public BabyDragon() {
        super(800,100,1.8,Speed.FAST,
                Target.AIRGROUND,"3",true,1,4);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(880);
                this.setDamage(110);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(968);
                this.setDamage(121);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1064);
                this.setDamage(133);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1168);
                this.setDamage(146);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
