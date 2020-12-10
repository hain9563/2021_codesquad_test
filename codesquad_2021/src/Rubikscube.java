// 면 하나가 회전 = 자기 자신도 돌아감(rotate_self) + 주변의 면도 같이 돌아감(각 면마다 다르게? 해야할 듯)

public class Rubikscube {
		static char[][] cube;
		static final char BLACK = 'B';
		static final char RED = 'R';
		static final char WHITE = 'W';
		static final char ORANGE = 'O';
		static final char GREEN = 'G';
		static final char YELLOW = 'Y';
		static final char EMPTY  = '\u0000';
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			cube = init();
			printCube(cube);
//			selfRotate(3,6,9,12);
//			System.out.println("\n");
//			printCube(cube);
			
			
			
		}
		
		
		
	 	public static char[][] init(){ 
		 		char[][] cube = { {EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	     						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, '1', '2', '3'}, 
		 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, '4', '5', '6'}, 
		 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, '7', '8', '9'}, 
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
		
		//돌릴 면 하나 자기 자신만 돌리기 : 면을 복사한 후에 시계방향으로 돈 결과를 cube에 다시 반영해줌
		public static void selfRotate(int start_row, int end_row, int start_column, int end_column) {
			char [][] copy_cube = new char[3][3];
			for(int i=start_row;i<end_row;i++) {
				for(int j=start_column;j<end_column;j++) {
					copy_cube[i-start_row][j-start_column] = cube[i][j];
				}
			}
			
			for(int i=0; i<copy_cube[0].length; i++){
		        for(int j=copy_cube.length-1; j>=0; j--){
		            cube[start_row+i][end_column-j-1] = copy_cube[j][i];
		        }
		    }
			
			
			
		}
	


}
