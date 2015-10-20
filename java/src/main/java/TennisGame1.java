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
		String score = "";
		int tempScore = 0;
		if (isTied()) {
			score = getTiedScore();
		} else if (isAdvantageOrWin()) {
			score = getAdvantageOrWinScore();
		} else {
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
		}
		return score;
	}

	private boolean isTied() {
		return m_score1 == m_score2;
	}

	private String getTiedScore() {
		String score;
		if (m_score1 == 0) {
			score = "Love-All";
		} else if (m_score1 == 1) {
			score = "Fifteen-All";
		} else if (m_score1 == 2) {
			score = "Thirty-All";
		} else {
			score = "Deuce";
		}
		return score;
	}

	private boolean isAdvantageOrWin() {
		return m_score1 >= 4 || m_score2 >= 4;
	}

	private String getAdvantageOrWinScore() {
		String score;
		int minusResult = m_score1 - m_score2;
		if (minusResult == 1) {
			score = "Advantage player1";
		} else if (minusResult == -1) {
			score = "Advantage player2";
		} else if (minusResult >= 2) {
			score = "Win for player1";
		} else {
			score = "Win for player2";
		}
		return score;
	}
}
