
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
		if (p1 == p2) {
			if (p1 < 3)
				return scoreToString[p1] + "-All";
			return "Deuce";
		}
		if (p1 >= 4 || p2 >= 4 || p1 + p2 == 6) {
			String leader = p1 > p2 ? p1N : p2N;
			return Math.abs(p1 - p2) == 1 ? "Advantage " + leader : "Win for " + leader;
		}
		return scoreToString[p1] + "-" + scoreToString[p2];
	}
	
	public void wonPoint(String playerName) {
		if (playerName == "player1")
			this.p1 += 1;
		else
			this.p2 += 1;
	}
}
