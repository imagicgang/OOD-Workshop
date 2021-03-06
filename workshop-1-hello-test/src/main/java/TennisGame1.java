import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name))
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        String[] scores = new String[] { "Love", "Fifteen", "Thirty", "Forty"};
        if (m_score1 == m_score2 && m_score1 <= 2)
        {
            return scores[m_score1] + "-All";
        }
        else if (m_score1 == m_score2 && m_score1 > 2) {
            return "Deuce";
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1 - m_score2;
            if (Math.abs(minusResult) == 1 )  score.append("Advantage "); else score.append("Win for ");
            if (minusResult > 0) score.append(this.player1Name); else score.append(this.player2Name);
            return score.toString();
        }
        return scores[m_score1] + "-" + scores[m_score2];
    }
}