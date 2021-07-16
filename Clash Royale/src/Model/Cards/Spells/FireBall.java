package Model.Cards.Spells;

public class FireBall extends Spell {
    private int areaDamage;

    public FireBall() {
        super(4,"Incinerates a small area, dealing high\n" +
                "damage. Reduced damage to Crown\n" +
                "Towers.",2.5);
        areaDamage = 325;
    }

    public int getAreaDamage() {
        return areaDamage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                areaDamage = 357;
                this.setLevel(2);
                break;
            case 2:
                areaDamage = 393;
                this.setLevel(3);
                break;
            case 3:
                areaDamage = 432;
                this.setLevel(4);
                break;
            case 4:
                areaDamage = 474;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
