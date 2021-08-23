package Model;

import Model.Cards.Card;
import Model.Towers.Tower;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Game model.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class GameModel {
    private long startTime;
    private long gameTime;
    private ArrayList<Card> playerCards;
    private ArrayList<Card> robotCards;
    private int playerCardTurn;
    private int robotCardTurn;
    private Card playerSelectedCard;
    private int playerElixirAmount;
    private int robotElixirAmount;
    private ArrayList<Mechanism> playerMechanism;
    private ArrayList<Mechanism> robotMechanisms;
    private ArrayList<Tower> playerTowers;
    private ArrayList<Tower> robotTowers;
    private Card robotSelectedCard;


    /**
     * Instantiates a new Game model.
     *
     * @param playerProfile the player profile
     */
    public GameModel(PlayerProfile playerProfile) {
        startTime = System.currentTimeMillis();
        gameTime = 3 * 60;
        playerCards = playerProfile.getCards();
        playerCardTurn = 4;
        robotCardTurn = 4;
        playerElixirAmount = 4;
        robotElixirAmount = 4;
        playerMechanism = new ArrayList<>();
        playerTowers = new ArrayList<>();
        robotTowers = new ArrayList<>();
        robotCards = getRandomCards();

        robotMechanisms = new ArrayList<>();

    }

    /**
     * Get random cards array list.
     *
     * @return the array list
     */
    public ArrayList<Card> getRandomCards() {
        ArrayList<Card> randomCards = new ArrayList<>();
        ArrayList<Card> allCards = new ManageCards().getCards();
        int i = 0;
        while (i < 8) {
            Card card = allCards.get(new Random().nextInt(12));
            if (!randomCards.contains(card)) {
                randomCards.add(card);
                i++;
            }
        }
        return randomCards;
    }


    /**
     * Gets start time.
     *
     * @return the start time
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Get player next card card.
     *
     * @return the card
     */
    public Card getPlayerNextCard() {
        playerCardTurn = (playerCardTurn + 1) % 8;
        return playerCards.get(playerCardTurn);
    }

    /**
     * Get robot next card card.
     *
     * @return the card
     */
    public Card getRobotNextCard() {
        robotCardTurn = (robotCardTurn + 1) % 8;
        return robotCards.get(robotCardTurn);
    }

    /**
     * Gets player cards.
     *
     * @return the player cards
     */
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /**
     * Sets player selected card.
     *
     * @param playerSelectedCard the player selected card
     */
    public void setPlayerSelectedCard(Card playerSelectedCard) {
        this.playerSelectedCard = playerSelectedCard;
    }

    /**
     * Gets player selected card.
     *
     * @return the player selected card
     */
    public Card getPlayerSelectedCard() {
        return playerSelectedCard;
    }

    /**
     * Gets robot selected card.
     *
     * @return the robot selected card
     */
    public Card getRobotSelectedCard() {
        return robotSelectedCard;
    }

    /**
     * Sets robot selected card.
     *
     * @param robotSelectedCard the robot selected card
     */
    public void setRobotSelectedCard(Card robotSelectedCard) {
        this.robotSelectedCard = robotSelectedCard;
    }

    /**
     * Gets player elixir amount.
     *
     * @return the player elixir amount
     */
    public int getPlayerElixirAmount() {
        return playerElixirAmount;
    }

    /**
     * Sets player elixir amount.
     *
     * @param playerElixirAmount the player elixir amount
     */
    public void setPlayerElixirAmount(int playerElixirAmount) {
        this.playerElixirAmount = playerElixirAmount;
    }

    /**
     * Gets player mechanism.
     *
     * @return the player mechanism
     */
    public ArrayList<Mechanism> getPlayerMechanism() {
        return playerMechanism;
    }

    /**
     * Gets robot mechanisms.
     *
     * @return the robot mechanisms
     */
    public ArrayList<Mechanism> getRobotMechanisms() {
        return robotMechanisms;
    }

    /**
     * Gets game time.
     *
     * @return the game time
     */
    public long getGameTime() {
        return gameTime;
    }

    /**
     * Get player towers array list.
     *
     * @return the array list
     */
    public ArrayList<Tower> getPlayerTowers() {
        return playerTowers;
    }

    /**
     * Gets robot towers.
     *
     * @return the robot towers
     */
    public ArrayList<Tower> getRobotTowers() {
        return robotTowers;
    }


    /**
     * Is player mechanism boolean.
     *
     * @param mechanism the mechanism
     * @return the boolean
     */
    public boolean isPlayerMechanism(Mechanism mechanism) {
        boolean find = false;
        for (Mechanism mechanism1 : playerMechanism) {
            if (mechanism1.equals(mechanism)) {
                find = true;
                break;
            }
        }
        return find;
    }

    /**
     * Is robot mechanism boolean.
     *
     * @param mechanism the mechanism
     * @return the boolean
     */
    public boolean isRobotMechanism(Mechanism mechanism) {
        boolean find = false;
        for (Mechanism mechanism1 : robotMechanisms) {
            if (mechanism1.equals(mechanism)) {
                find = true;
                break;
            }
        }
        return find;
    }

    /**
     * Remove player mechanism.
     *
     * @param mechanism the mechanism
     */
    public void removePlayerMechanism(Mechanism mechanism) {
        playerMechanism.remove(mechanism);
    }

    /**
     * Remove robot mechanism.
     *
     * @param mechanism the mechanism
     */
    public void removeRobotMechanism(Mechanism mechanism) {
        robotMechanisms.remove(mechanism);
    }

    /**
     * Gets robot cards.
     *
     * @return the robot cards
     */
    public ArrayList<Card> getRobotCards() {
        return robotCards;
    }

    /**
     * Gets robot elixir amount.
     *
     * @return the robot elixir amount
     */
    public int getRobotElixirAmount() {
        return robotElixirAmount;
    }

    /**
     * Sets robot elixir amount.
     *
     * @param robotElixirAmount the robot elixir amount
     */
    public void setRobotElixirAmount(int robotElixirAmount) {
        this.robotElixirAmount = robotElixirAmount;
    }
}
