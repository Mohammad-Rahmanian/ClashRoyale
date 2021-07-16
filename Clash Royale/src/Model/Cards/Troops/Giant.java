package Model.Cards.Troops;

public class Giant extends Troop {

    public Giant() {
        super(2000,126,1.5,Speed.SLOW,
                Target.BUILDINGS,"Melee",false,1,5);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(2200);
                this.setDamage(138);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(2420);
                this.setDamage(152);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(2660);
                this.setDamage(167);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(2920);
                this.setDamage(183);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
