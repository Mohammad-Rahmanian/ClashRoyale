package Model.Cards.Troops;

import javafx.scene.image.Image;

public class Wizard extends Troop {

    public Wizard() {
        super(340,130,1.7,Speed.MEDIUM,
                Target.AIRGROUND,"5",true,1,5,"Wizard");
        createImage();
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(374);
                this.setDamage(143);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(411);
                this.setDamage(157);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(452);
                this.setDamage(172);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(496);
                this.setDamage(189);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image =  new Image(getClass().getResourceAsStream("/photos/wizard.jpg"));
        this.setImage(image);
    }
}
