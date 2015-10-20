
public class TennisGame2 implements TennisGame {
	public int P1point = 0;
	public int P2point = 0;

	public String P1res = "";
	public String P2res = "";
	private String player1Name;
	private String player2Name;

	public TennisGame2(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public String getScore() {
		if (isTie()) {
			return getTieScore();
		}

		if (P1point < 4 && P2point < 4) {
			P1res = scoreToString(P1point);
			P2res = scoreToString(P2point);
			return P1res + "-" + P2res;
		}

		if ((P1point >= 4 || P2point >= 4) && Math.abs(P1point - P2point) >= 2) {
			if (P1point > P2point)
				return "Win for player1";
			return "Win for player2";
		}

		if (P1point >=3 && P2point >= 3 && Math.abs(P1point - P2point) == 1) {
			if (P1point > P2point)
				return "Advantage player1";
			return "Advantage player2";
		}

		return "";
	}

	private boolean isTie() {
		return P1point == P2point;
	}

	private String getTieScore() {
		if (P1point < 3) {
			return scoreToString(P1point) + "-All";
		}
		return "Deuce";
	}

	private String scoreToString(int score) {
		assert(score <= 4);
		if (score == 0)
			return "Love";
		if (score == 1)
			return "Fifteen";
		if (score == 2)
			return "Thirty";
		return "Forty";
	}
	
	public void SetP1Score(int number) {

		for (int i = 0; i < number; i++) {
			P1Score();
		}

	}

	public void SetP2Score(int number) {

		for (int i = 0; i < number; i++) {
			P2Score();
		}

	}

	public void P1Score() {
		P1point++;
	}

	public void P2Score() {
		P2point++;
	}

	public void wonPoint(String player) {
		if (player == "player1")
			P1Score();
		else
			P2Score();
	}
}