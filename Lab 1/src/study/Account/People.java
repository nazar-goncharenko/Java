package study.Account;

public abstract class People {

	protected String name;

	public People(String name) {
		super();
		this.name = name;
	}
	
	public String PrintName()
	{
		return (name);
	}

}
