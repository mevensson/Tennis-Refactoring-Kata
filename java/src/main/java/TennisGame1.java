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
		if (m_score1 == 0)
			return "Love-All";
		if (m_score1 == 1)
			return "Fifteen-All";
		if (m_score1 == 2)
			return "Thirty-All";
		return "Deuce";
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
		String score = "";
		int tempScore = 0;
		for (int i = 1; i < 3; i++) {
			if (i == 1) {
				tempScore = m_score1;
			} else {
				score += "-";
				tempScore = m_score2;
			}
			if (tempScore == 0) {
				score += "Love";
			} else if (tempScore == 1) {
				score += "Fifteen";
			} else if (tempScore == 2) {
				score += "Thirty";
			} else if (tempScore == 3) {
				score += "Forty";
			}
		}
		return score;
	}
}
