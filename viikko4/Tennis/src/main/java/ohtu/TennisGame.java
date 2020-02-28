package ohtu;

import java.util.HashMap;

public class TennisGame {

    int p1_score = 0;
    int p2_score = 0;
    String score = "";
    String player1Name;
    String player2Name;
    HashMap<Integer,String> map;

    public TennisGame(final String player1Name, final String player2Name, final String score) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.score = score;
        
        this.map = new HashMap<>();
        initHashMap();
    }

    public void wonPoint(final String playerName) {
        if (playerName == "player1")
            p1_score += 1;
        else
            p2_score += 1;
    }

    public String getScore() {
        if (p1_score == p2_score) {
            return ifEven();
        } else if (p1_score >= 4 || p2_score >= 4) {
            return advantage();
        } else {
            return map.get(p1_score) + "-" + map.get(p2_score);
        }
    }

    public String ifEven() {
        if (p1_score <= 3) {
            return map.get(p1_score) + "-All";
        }
        return "Deuce";
    }

    public String advantage() {
        final int minusResult = p1_score - p2_score;
        if (minusResult == 1) {
            return "Advantage player1";
        }    
        else if (minusResult == -1) {
            return "Advantage player2";
        }
        else if (minusResult >= 2) {
            return "Win for player1";
        }
        else {
            return "Win for player2";
        }
    }

    public void initHashMap() {
        map.put(0, "Love");
        map.put(1, "Fifteen");
        map.put(2, "Thirty");
        map.put(3, "Forty");
    }
}
