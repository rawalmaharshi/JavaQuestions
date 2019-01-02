package oops3;

import java.util.Scanner;

public class Othello {

	private int board[][];
	final static int playerOneSymbol = 1;
	final static int playerTwoSymbol = 2;

	public Othello() {
		board = new int[8][8];
		board[3][3] = playerOneSymbol;
		board[3][4] = playerTwoSymbol;
		board[4][3] = playerTwoSymbol;
		board[4][4] = playerOneSymbol;
	}

	public void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean move (int symbol, int x, int y) {
		//if the cell is occupied
		if (board[x][y] != 0) {
			return false;
		}
		
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
		
		int flag = 0;
		
		for (int i = 0; i < xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];
			
			//check if (x+xStep, y+yStep) are within the board
			if ((x+xStep) >= 0 && (x+xStep) <=7 && (y+yStep) >=0 && (y+yStep) <=7) {
				
				//if there is nothing on the present square
				if (board[(x+xStep)][(y+yStep)] == 0) {
					continue;
				} else if (board[(x+xStep)][y+yStep] == currPlayerSymbol) {
					//if the present square belongs to the same player
					continue;
				} else {					
					//when the present square belongs to the other player
					boolean patternPresent = searchPattern ((x+xStep), (y+yStep), currPlayerSymbol, otherPlayerSymbol, xStep, yStep);
					
					if (!patternPresent) {
						continue;
					} else {
						//initialize the coordinates mentioned by the user 
						board[x][y] = currPlayerSymbol;
						flag = 1;
//						if ((x+xStep) <= 0 && (y+yStep) >=7 && (x+xStep) >=7 && (y+yStep) <=0) {
////							System.out.println("ere");
//							break;
//						}	
						
						int tempX = x;
						int tempY = y;
						while (board[tempX+xStep][tempY+yStep] == otherPlayerSymbol) {
//							System.out.println("here");
//							System.out.println(tempX + " , " + tempY);
							board[(tempX+xStep)][(tempY+yStep)] = currPlayerSymbol;
							tempX += xStep;
							tempY += yStep;
						}
					}
				}
			} 
		}
		if (flag == 0) {
			return false;
		} else {
			return true;
		}	
	}

	private boolean searchPattern(int x, int y, int currPlayerSymbol, int otherPlayerSymbol, int xStep, int yStep) {
		
		while (x >=0 && x <= 7 && y >=0 && y <=7) {
			if (board[x][y] == 0) { 
					return false;
			} else if (board[x][y] == otherPlayerSymbol){
				x += xStep;
				y += yStep;
			} else if (board[x][y] == currPlayerSymbol) {
				return true;
			} 
		} 
		return false;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Othello b = new Othello();
		int n = s.nextInt();
		boolean p1Turn = true;
		while (n > 0) {
			int x = s.nextInt();
			int y = s.nextInt();
			boolean ans = false;
			if (p1Turn) {
				ans = b.move(playerOneSymbol, x, y);
			} else {
				ans = b.move(playerTwoSymbol, x, y);
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
