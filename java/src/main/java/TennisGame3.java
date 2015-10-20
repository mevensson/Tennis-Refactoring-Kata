
public class TennisGame3 implements TennisGame {
	private int p2;
	private int p1;
	private String p1N;
	private String p2N;

	public TennisGame3(String p1N, String p2N) {
		this.p1N = p1N;
		this.p2N = p2N;
	}

	public String getScore() {
		if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
			String[] scoreToString = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
			String s = scoreToString[p1];
			return (p1 == p2) ? s + "-All" : s + "-" + scoreToString[p2];
		} else {
			if (p1 == p2)
				return "Deuce";
			String leader = p1 > p2 ? p1N : p2N;
			return Math.abs(p1 - p2) == 1 ? "Advantage " + leader : "Win for " + leader;
		}
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1")
			this.p1 += 1;
		else
			this.p2 += 1;
	}
}
