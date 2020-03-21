package study.Desk;

public class Desk implements IDesk {

	private int[][] desk = new int[3][3];
	private int counter = 9;

	public Desk() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				desk[i][j] = 0;
			}
		}
	}

	private boolean check(int x, int y) {
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3)
			return desk[x - 1][y - 1] == 0 ? true : false;
		else
			return false;
	}

	public boolean hit(int x, int y, char marker) {
		if (check(x, y) == true) {
			desk[x - 1][y - 1] = (int) marker;
			counter--;
			return true;
		} else {
			return false;
		}
	}

	public boolean ckechWin(int x, int y, char markerP) {
		int marker = (int) markerP;
		int coll = x - 1;
		int row = y - 1;
		int tmp = 0;
		for (int i = 0; i < 3; i++) {
			if (desk[coll][i] == marker)
				tmp++;
			else
				break;
		}
		if (tmp == 3)
			return true;
		tmp = 0;
		for (int i = 0; i < 3; i++) {
			if (desk[i][row] == marker)
				tmp++;
			else
				break;
		}
		if (tmp == 3)
			return true;

		if (((desk[0][0] == desk[1][1]) && (desk[1][1] == desk[2][2]) && (desk[1][1] != 0))
				|| ((desk[0][2] == desk[1][1]) && (desk[1][1] == desk[2][0]) && (desk[1][1] != 0)))
			return true;
		else
			return false;
	}

	public void printDesk() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (desk[j][2 - i] != 0)
					System.out.print((char) desk[j][2 - i] + " ");
				else
					System.out.print("." + " ");
			}
			System.out.print("\n");
		}
	}

	public boolean deskIsPlayeble() {
		if (counter > 0)
			return true;
		else
			return false;
	}

}
