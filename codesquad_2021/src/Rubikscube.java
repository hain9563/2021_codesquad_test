
public class Rubikscube {
		static final char BLACK = 'B';
		static final char RED = 'R';
		static final char WHITE = 'W';
		static final char ORANGE = 'O';
		static final char GREEN = 'G';
		static final char YELLOW = 'Y';
		static final char EMPTY  = '\u0000';
 	public static char[][] init(){ 
	 		char[][] cube = { {EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
     						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
	 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
	 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
	 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}}; 
	 		return cube; 
	 	} 

	
	//전개도 출력 함수
	static void printCube(char[][] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] cube = init();
		printCube(cube);
	}

}
