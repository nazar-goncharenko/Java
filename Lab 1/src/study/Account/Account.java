package study.Account;

public class Account extends Player {

	private String password;
	private int score = 0;

	
	public Account(String name, char chip, String password, int score) {
		super(name, chip);
		this.password = password;
		this.score = score;
	}
	
	public Account(String name, char chip, String password) {
		super(name,chip);
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public int getScore() {
		return this.score;
	}

	public void addScore() {
		this.score++;
	}
}
