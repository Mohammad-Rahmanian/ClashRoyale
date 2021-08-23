package Model;

import Model.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Player profile.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class PlayerProfile implements Serializable {
    private String userName;
    private String password;
    private ArrayList<Card> cards;
    private int level;
    private int score;
    private int cups;
    private League currentLeague;
    private ArrayList<Card> allCards;
    private ArrayList<Battle> battles;

    /**
     * Instantiates a new Player profile.
     *
     * @param userName the user name
     * @param password the password
     */
    public PlayerProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        cards = new ArrayList<Card>();
        allCards = new ManageCards().getCards();
        level = 1;
        score = 0;
        cups = 0;
        currentLeague = League.BRONZE;
        battles = new ArrayList<>();
    }

    /**
     * The enum League.
     */
    public enum League {
        /**
         * Bronze league.
         */
        BRONZE,
        /**
         * Silver league.
         */
        SILVER,
        /**
         * Gold league.
         */
        GOLD;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets cups.
     *
     * @return the cups
     */
    public int getCups() {
        return cups;
    }

    /**
     * Gets current league.
     *
     * @return the current league
     */
    public League getCurrentLeague() {
        return currentLeague;
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove card.
     *
     * @param card the card
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Checklevel.
     */
    public void checklevel() {
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

    /**
     * Update score.
     *
     * @param score the score
     */
    public void updateScore(int score) {
        this.score += score;
    }

    /**
     * Update cups.
     *
     * @param cups the cups
     */
    public void updateCups(int cups) {
        this.cups += cups;
    }

    /**
     * Find card card.
     *
     * @param name the name
     * @return the card
     */
    public Card findCard(String name) {
        Card card = null;
        for (Card card1 : allCards) {
            if (card1.getName().equals(name)) {
                card = card1;
                break;
            }
        }
        return card;
    }

    /**
     * Load images.
     */
    public void loadImages() {
        for (Card card : cards) {
            card.createImage();
        }
        for (Card card : allCards) {
            card.createImage();
        }
    }

    /**
     * Gets battles.
     *
     * @return the battles
     */
    public ArrayList<Battle> getBattles() {
        return battles;
    }
}
