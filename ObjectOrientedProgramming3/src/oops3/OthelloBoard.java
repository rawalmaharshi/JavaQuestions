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
	
	public boolean move (int symbol, int x, int y) {
		if(x<0||x>=8||y<0||y>=8) {
			return false;
		}
 
      int xDir[]={-1,-1,0,1,1,1,0,-1};
      int yDir[]={0,1,1,1,0,-1,-1,-1};
      int i=0;
      while(i<xDir.length)
      {
 
       int xStep=xDir[i],yStep=yDir[i];
       int xnew=x+xStep,ynew=y+yStep;
       if(xnew>=0&&xnew<8&&ynew>=0&&ynew<8) {
      if(board[xnew][ynew]!=symbol&&board[xnew][ynew]!=0)
          {
            int t=xnew;
               for(int j=t;j<8;j++)
               {
                 xnew+=xStep;ynew+=yStep;
              if(xnew>=0&&xnew<8&&ynew>=0&&ynew<8){
              if(board[xnew][ynew]==0)
            	  i++;
                 if(board[xnew][ynew]==symbol)
                   {
                  if(xStep>0){
                    for(int k=xnew;k>x+xStep;k--)
                     {
 
                       board[k-xStep][ynew-yStep]=symbol;
 
 
                     }}
                  else if(xStep<0){
                    for(int k=x;k>xnew;k--)
                     {
 
                       board[k][ynew-yStep]=symbol;
 
 
                     }}
                   else if(yStep>0)
                   {
                     for(int f=ynew;f>y+yStep;f--)
                     {
                      board[xnew-xStep][f-yStep]=symbol;
 
                     }
                   }
                   else if(yStep<0)
                   {
                     for(int f=y;f>ynew;f--)
                     {
                      board[xnew-xStep][f]=symbol;
 
                     }
                   }
                     board[x][y]=symbol;
                  //System.out.print(board[x][y]);
                    return true;
                   }
               }
               else
            	   return false;}
           }
        else
           i++; }
       else
    	   return false;
 
      }
       return false;
 
 
	}

	public boolean move1(int symbol, int x, int y) {

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
		int moveCount = 0;

		for (int i = 0; i < xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];

			while (((x + xStep) >= 0 && (x + xStep < 8)) && ((y + yStep) >= 0 && (y + yStep) < 8)) {
					if (board[x + xStep][y + yStep] == 0) { //No changes here
						break;
					} else if (board[x + xStep][y + yStep] == currPlayerSymbol){
						break;
					} else {
						int tryX = x+xStep;
						int tryY = y+yStep;
						
						
						
						
						while (board[x + xStep][y + yStep] == otherPlayerSymbol) {
							board[x][y] = currPlayerSymbol;
							coOrd c = moveLogic(i, x, y);
							x = c.x;
							y = c.y;
//							board[x][y] = currPlayerSymbol;
							moveCount++;
						}
					}
			}
		}
		
		if (moveCount > 0)
			return true;
		else 
			return false;
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