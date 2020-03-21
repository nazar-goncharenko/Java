package study.Account;

public class Player extends People implements Iplayer {
	private char chip;

	public Player(String name, char chip) 
	{
		super(name);
		this.chip = chip;
	}

	public char getChip() 
	{
		return this.chip;
	}

	public String getName() 
	{
		return super.name;
	}
	
	public String PrintName()
	{
		return (new String(super.name + " with the chip " + chip));
	}
}
