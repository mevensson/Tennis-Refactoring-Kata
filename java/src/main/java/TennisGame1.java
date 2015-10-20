public class TennisGame1 implements TennisGame {

	private int m_score1 = 0;
	private int m_score2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			m_score1 += 1;
		} else {
			m_score2 += 1;
		}
	}

	public String getScore() {
		if (isTied())
			return getTiedScore();
		if (isAdvantageOrWin())
			return getAdvantageOrWinScore();
		return getOtherScore();
	}

	private boolean isTied() {
		return m_score1 == m_score2;
	}

	private String getTiedScore() {
		if (m_score1 > 2)
			return "Deuce";
		return scoreToString(m_score1) + "-All";
	}

	private boolean isAdvantageOrWin() {
		return m_score1 >= 4 || m_score2 >= 4;
	}

	private String getAdvantageOrWinScore() {
		int minusResult = m_score1 - m_score2;
		if (minusResult == 1)
			return "Advantage player1";
		if (minusResult == -1)
			return "Advantage player2";
		if (minusResult >= 2)
			return "Win for player1";
		return "Win for player2";
	}

	private String getOtherScore() {
		return scoreToString(m_score1) + "-" + scoreToString(m_score2);
	}
	
	private String scoreToString(int score) {
		assert(score <= 3);
		if (score == 0) {
			return "Love";
		} else if (score == 1) {
			return "Fifteen";
		} else if (score == 2) {
			return "Thirty";
		} else {
			return "Forty";
		}
	}
}
