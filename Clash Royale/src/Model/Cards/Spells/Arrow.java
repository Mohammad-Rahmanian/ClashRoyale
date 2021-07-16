package Model.Cards.Spells;

public class Arrow extends Spell {
    private int areaDamage;

    public Arrow() {
        super(3,"Arrows pepper a large area, damaging\n" +
                "everyone hit. Reduced damage to\n" +
                "Crown Towers.",4.0);
        areaDamage = 144;
    }

    public int getAreaDamage() {
        return areaDamage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                areaDamage = 156;
                this.setLevel(2);
                break;
            case 2:
                areaDamage = 174;
                this.setLevel(3);
                break;
            case 3:
                areaDamage = 189;
                this.setLevel(4);
                break;
            case 4:
                areaDamage = 210;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
