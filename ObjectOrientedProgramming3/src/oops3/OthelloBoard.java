package oops3;

import java.util.Scanner;

public class OthelloBoard {

	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public OthelloBoard() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		System.out.println();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean move(int symbol, int x, int y) {

		int currPlayerSymbol = symbol;
		int otherPlayerSymbol;
		if (currPlayerSymbol == 1) {
			otherPlayerSymbol = 2;
		} else {
			otherPlayerSymbol = 1;
		}
		// These arrays together represent the eight direction where othello can find a
		// combination
		int[] xDir = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] yDir = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];

			while (((x + xStep) >= 0 && (x + xStep < 8)) && ((y + yStep) >= 0 && (y + yStep) < 8)) {
					if (board[x + xStep][y + yStep] == 0) { //No changes here
						break;
					} else if (board[x + xStep][y + yStep] == currPlayerSymbol){
						break;
					} else {
						while (board[x + xStep][y + yStep] == otherPlayerSymbol) {
							coOrd c = moveLogic(i, x, y);
							x = c.x;
							y = c.y;
							board[x][y] = currPlayerSymbol;
						}
					}
			}
		}

		return true;
	}

	private coOrd moveLogic(int iteration, int x, int y) {
		switch (iteration) {
		case 0:
			x--;
			break;
		case 1:
			x--;
			y++;
			break;
		case 2:
			y++;
			break;
		case 3:
			x++;
			y++;
			break;
		case 4:
			x++;
			break;
		case 5:
			x++;
			y--;
			break;
		case 6:
			y--;
			break;
		case 7:
			x--;
			y--;
			break;
		default:
			break;
		}
		coOrd c = new coOrd();
		c.x = x;
		c.y = y;
		return c;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		OthelloBoard b = new OthelloBoard();
		int n = s.nextInt();
		boolean p1Turn = true;
		while (n > 0) {
			int x = s.nextInt();
			int y = s.nextInt();
			boolean ans = false;
			if (p1Turn) {
				ans = b.move(player1Symbol, x, y);
			} else {
				ans = b.move(player2Symbol, x, y);
			}
			if (ans) {
				b.print();
				p1Turn = !p1Turn;
				n--;
			} else {
				System.out.println(ans);
			}
		}
	}
}

class coOrd {
	int x;
	int y;
}