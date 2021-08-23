package Model;

import java.io.Serializable;

/**
 * The type Battle.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class Battle implements Serializable {
    private String firstPlayerUserName;
    private String secondPlayerUserName;
    private int firstPlayerScore;
    private int secondPlayerScore;
    private String winnerUserName;

    /**
     * Instantiates a new Battle.
     *
     * @param firstPlayerUserName  the first player user name
     * @param secondPlayerUserName the second player user name
     * @param firstPlayerScore     the first player score
     * @param secondPlayerScore    the second player score
     * @param winnerUserName       the winner user name
     */
    public Battle(String firstPlayerUserName, String secondPlayerUserName, int firstPlayerScore, int secondPlayerScore, String winnerUserName) {
        this.firstPlayerUserName = firstPlayerUserName;
        this.secondPlayerUserName = secondPlayerUserName;
        this.firstPlayerScore = firstPlayerScore;
        this.secondPlayerScore = secondPlayerScore;
        this.winnerUserName = winnerUserName;
    }

    /**
     * Gets first player user name.
     *
     * @return the first player user name
     */
    public String getFirstPlayerUserName() {
        return firstPlayerUserName;
    }

    /**
     * Gets second player user name.
     *
     * @return the second player user name
     */
    public String getSecondPlayerUserName() {
        return secondPlayerUserName;
    }

    /**
     * Gets first player score.
     *
     * @return the first player score
     */
    public int getFirstPlayerScore() {
        return firstPlayerScore;
    }

    /**
     * Gets second player score.
     *
     * @return the second player score
     */
    public int getSecondPlayerScore() {
        return secondPlayerScore;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "firstPlayerUserName='" + firstPlayerUserName + '\'' +
                ", secondPlayerUserName='" + secondPlayerUserName + '\'' +
                ", firstPlayerScore=" + firstPlayerScore +
                ", secondPlayerScore=" + secondPlayerScore +
                ", winnerUserName='" + winnerUserName + '\'' +
                '}';
    }
}
