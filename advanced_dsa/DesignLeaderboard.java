package advanced_dsa;
import java.util.*;

class Leaderboard {
    TreeMap<Integer, Integer> score2Count;
    Map<Integer, Integer> player2Score;
    public Leaderboard() {
        score2Count = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        player2Score = new HashMap<Integer, Integer>();
    }
    
    public void addScore(int playerId, int score) {
        int preScore = player2Score.getOrDefault(playerId, 0);
        int newScore = preScore + score;
        player2Score.put(playerId, newScore);
        if (preScore > 0 && score2Count.containsKey(preScore)) {
            score2Count.put(preScore, score2Count.get(preScore) - 1);
        }
        score2Count.put(newScore, score2Count.getOrDefault(newScore, 0) + 1);
    }
    
    public int top(int K) {
        int cnt = 0;
        int sum = 0;
        for (int score: score2Count.keySet()) {
            int freq = score2Count.get(score);
            int len = freq;

            while (len > 0) {
                sum += score;
                cnt++;
                if (cnt == K) {
                    return sum;
                }
                len--;
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int score = player2Score.get(playerId);
        player2Score.remove(playerId);
        score2Count.put(score, score2Count.get(score) - 1);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */