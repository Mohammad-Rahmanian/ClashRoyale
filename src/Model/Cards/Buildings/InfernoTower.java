package Model.Cards.Buildings;

import javafx.scene.image.Image;

public class InfernoTower extends Building {
    private String damage;

    public InfernoTower() {
        super(5,800,0.4,Target.AIRGROUND,6,40,"InfernoTower");
        damage = "20-400";
        createImage();
    }

    public String getDamage() {
        return damage;
    }

    @Override
    public void upgrade() {
        switch (this.getLevel()){
            case 1:
                this.setHp(880);
                damage = "22-440";
                this.setLevel(2);
                break;
            case 2:
                this.setHp(968);
                damage = "24-484";
                this.setLevel(3);
                break;
            case 3:
                this.setHp(1064);
                damage = "26-532";
                this.setLevel(4);
                break;
            case 4:
                this.setHp(1168);
                damage = "29-584";
                this.setLevel(5);
                break;
            default:
                break;
        }
    }

    @Override
    public void createImage() {
        Image image = new Image(getClass().getResourceAsStream("/photos/infernoTower.jpg"));
        this.setImage(image);
    }
}
