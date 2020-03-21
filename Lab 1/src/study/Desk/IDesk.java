package study.Desk;

public interface IDesk {

	public boolean hit(int x, int y, char marker);

	public boolean ckechWin(int x, int y, char marker);

	public void printDesk();

	public boolean deskIsPlayeble();
}
