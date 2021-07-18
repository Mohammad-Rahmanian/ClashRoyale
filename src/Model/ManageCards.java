package Model;

import Model.Cards.Buildings.Cannon;
import Model.Cards.Buildings.InfernoTower;
import Model.Cards.Card;
import Model.Cards.Spells.Arrow;
import Model.Cards.Spells.FireBall;
import Model.Cards.Spells.Rage;
import Model.Cards.Troops.*;

import java.util.ArrayList;

public class ManageCards {
    private ArrayList<Card> cards;

    public ManageCards() {
        cards = new ArrayList<Card>();
        createCards();
    }

    private void createCards(){
        Barbarian barbarian = new Barbarian();
        Archer archer = new Archer();
        BabyDragon babyDragon = new BabyDragon();
        Wizard wizard = new Wizard();
        Valkyrie valkyrie = new Valkyrie();
        Giant giant = new Giant();
        MiniPekka miniPekka = new MiniPekka();
        Rage rage = new Rage();
        FireBall fireBall = new FireBall();
        Arrow arrow = new Arrow();
        InfernoTower infernoTower = new InfernoTower();
        Cannon cannon = new Cannon();

        cards.add(barbarian);
        cards.add(archer);
        cards.add(babyDragon);
        cards.add(wizard);
        cards.add(valkyrie);
        cards.add(giant);
        cards.add(miniPekka);
        cards.add(rage);
        cards.add(fireBall);
        cards.add(arrow);
        cards.add(infernoTower);
        cards.add(cannon);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
