package Model;

import Model.Cards.Card;
import Model.Towers.Tower;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerProfile implements Serializable {
    private String userName;
    private String password;
    private ArrayList<Card> cards;
    private int level;
    private int score;
    private int cups;
    private League currentLeague;
    private int elixir;

    public PlayerProfile(String userName,String password){
        this.userName = userName;
        this.password = password;
        cards = new ArrayList<>();
        level = 1;
        score = 0;
        cups = 0;
        currentLeague = League.BRONZE;
        elixir = 0;
    }

    public enum League{
        BRONZE, SILVER, GOLD;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getCups() {
        return cups;
    }

    public League getCurrentLeague() {
        return currentLeague;
    }

    public int getElixir() {
        return elixir;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public void CheckLevel(){
        if (score >= 300 && score < 500)
            this.level = 1;
        if (score >= 500 && score < 900)
            this.level = 2;
        if (score >= 900 & score < 1700)
            this.level = 3;
        if (score >= 1700 && score < 2500)
            this.level = 4;
        if (score >= 2500)
            this.level = 5;
    }

    public void updateScore(int score){
        this.score += score;
    }

    public void updateCups(int cups){
        this.cups += cups;
    }

    public void updateElixir(int elixir){
        this.elixir += elixir;
    }
}
