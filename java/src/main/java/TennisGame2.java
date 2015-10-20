
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
		if (isTie())
			return getTieScore();
		if (isAdvantage())
			return getAdvantageScore();
		if (isWin())
			return getWinScore();
		return getNormalScore();
	}

	private boolean isTie() {
		return P1point == P2point;
	}

	private String getTieScore() {
		if (P1point < 3)
			return scoreToString(P1point) + "-All";
		return "Deuce";
	}

	private boolean isAdvantage() {
		return P1point >=3 && P2point >= 3 && Math.abs(P1point - P2point) == 1;
	}

	private String getAdvantageScore() {
		if (P1point > P2point)
			return "Advantage player1";
		return "Advantage player2";
	}

	private boolean isWin() {
		return (P1point >= 4 || P2point >= 4) && Math.abs(P1point - P2point) >= 2;
	}

	private String getWinScore() {
		if (P1point > P2point)
			return "Win for player1";
		return "Win for player2";
	}

	private String getNormalScore() {
		return scoreToString(P1point) + "-" + scoreToString(P2point);
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