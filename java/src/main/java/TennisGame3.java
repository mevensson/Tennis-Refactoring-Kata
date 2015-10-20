
public class TennisGame3 implements TennisGame {
	private static String[] scoreToString = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
	private int p2;
	private int p1;
	private String p1N;
	private String p2N;

	public TennisGame3(String p1N, String p2N) {
		this.p1N = p1N;
		this.p2N = p2N;
	}

	public String getScore() {
		if (isWin())
			return "Win for " + getLeader();
		if (isAdvantage())
			return "Advantage " + getLeader();
		if (isDeuce())
			return "Deuce";
		if (p1 == p2)
		    return scoreToString[p1] + "-All";
		return scoreToString[p1] + "-" + scoreToString[p2];
	}

	private boolean isWin() {
		return (p1 >= 4 || p2 >= 4) && Math.abs(p1 - p2) >= 2;
	}

	private boolean isAdvantage() {
		return (p1 >= 4 || p2 >= 4) && Math.abs(p1 - p2) == 1;
	}

	private boolean isDeuce() {
		return p1 == p2 && p1 >= 3;
	}

	private String getLeader() {
		return p1 > p2 ? p1N : p2N;
	}
	
	public void wonPoint(String playerName) {
		if (playerName == "player1")
			this.p1 += 1;
		else
			this.p2 += 1;
	}
}
