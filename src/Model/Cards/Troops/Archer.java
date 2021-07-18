package Model.Cards.Troops;

import javafx.scene.image.Image;

public class Archer extends Troop {

    public Archer() {
        super(125,33,1.2,Speed.MEDIUM,
                Target.AIRGROUND,"5",false,2,3,"Archer");
        createImage();
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(127);
                this.setDamage(44);
                this.setLevel(2);
                break;
            case 2:
                this.setHp(151);
                this.setDamage(48);
                this.setLevel(3);
                break;
            case 3:
                this.setHp(166);
                this.setDamage(53);
                this.setLevel(4);
                break;
            case 4:
                this.setHp(182);
                this.setDamage(58);
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image =  new Image(getClass().getResourceAsStream("/photos/archer.jpg"));
        this.setImage(image);
    }
}
