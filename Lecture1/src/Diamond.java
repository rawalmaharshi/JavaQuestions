
public class Diamond {
	
	public static void main(String[] args) {
		int numOfRows = 7;
		int numOfSpaces = 0;
		
		for (int i = 1; i <= numOfRows; i++) {
			int j = 0;
			if ( i <= (numOfRows + 1)/2) {
				j = i;
			} else {
				j = numOfRows - i + 1;
			}
			numOfSpaces = 4 - j;
			while (numOfSpaces > 0) {
				System.out.print(" ");
				numOfSpaces--;
			}
			while (j > 0) {
				System.out.print("* ");
				j--;
			}
			System.out.println();
		}
		
	}

}
