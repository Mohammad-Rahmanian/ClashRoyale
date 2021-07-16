package Model.Cards.Spells;

public class Rage extends Spell {
    private double duration;

    public Rage() {
        super(3,"+40% Damage Boost"+"\n"+"+40% Speed Boost"+"\n"+"+40% Hit Speed Boost",5.0);
        duration = 6.0;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                duration = 6.5;
                this.setLevel(2);
                break;
            case 2:
                duration = 7.0;
                this.setLevel(3);
                break;
            case 3:
                duration = 7.5;
                this.setLevel(4);
                break;
            case 4:
                duration = 8.0;
                this.setLevel(5);
                break;
            default:
                break;
        }
    }
}
