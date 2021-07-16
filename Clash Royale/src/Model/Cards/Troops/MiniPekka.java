package Model.Cards.Troops;

public class MiniPekka extends Troop {

    public MiniPekka() {
        super(600,325,1.8,Speed.FAST,
                Target.GROUND,"Melee",false,1,4);
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(660);
                this.setDamage(357);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(726);
                this.setDamage(393);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(798);
                this.setDamage(432);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(876);
                this.setDamage(474);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
