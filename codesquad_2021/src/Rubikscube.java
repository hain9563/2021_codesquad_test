// 면 하나가 회전 = 자기 자신도 돌아감(rotate_self) + 주변의 면도 같이 돌아감(각 면마다 다르게? 해야할 듯)
import java.util.Scanner;

import java.util.Arrays;

public class Rubikscube {
		static char[][] cube;
		static final char BLACK = 'B';
		static final char RED = 'R';
		static final char WHITE = 'W';
		static final char ORANGE = 'O';
		static final char GREEN = 'G';
		static final char YELLOW = 'Y';
		static final char EMPTY  = '\u0000';
		static String command[];
		static int num = 0;					 // 조작 횟수를 카운트하기 위한 숫자
		
		/*
				 		char[][] cube = { {EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
	     						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
		 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
		 						{WHITE, WHITE, WHITE, ORANGE, ORANGE, ORANGE, GREEN, GREEN, GREEN, YELLOW, YELLOW, YELLOW}, 
		 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
		 						{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}}; 
		 */
		
		
	 	public static char[][] init(){ 
		 		char[][] cube = { {EMPTY, EMPTY, EMPTY, 'l', 'k', 'j', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
							{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
							{EMPTY, EMPTY, EMPTY, BLACK, BLACK, BLACK, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
							{'i', WHITE, WHITE, '1', '2', '3', GREEN, GREEN, 'a', YELLOW, YELLOW, YELLOW}, 
							{'h', WHITE, WHITE, '4', '5', '6', GREEN, GREEN, 'b', YELLOW, YELLOW, YELLOW}, 
							{'g', WHITE, WHITE, '7', '8', '9', GREEN, GREEN, 'c', YELLOW, YELLOW, YELLOW}, 
							{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
							{EMPTY, EMPTY, EMPTY, RED, RED, RED, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}, 
							{EMPTY, EMPTY, EMPTY, 'f', 'e', 'd', EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}}; 
		 		// BLACK = U, ORANGE = F, RED = D
		 		// WHITE = L, GREEN = R, YELLOW = B
		 		
		 		/*   U
		 		 * L F R B
		 		     D      */
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
			
		// array에 요소를 추가하는 메소드
		// input : String key ->  넣고 싶은 요소
		//		   index	  ->  요소를 넣을 배열의 인덱스
		private static void insert(String key, int index) {
	        String [] result = new String[command.length + 1];
	 
	        System.arraycopy(command, 0, result, 0, index);
	        result[index] = key;
	        System.arraycopy(command, index, result, index + 1, command.length - index);
	        command = result;
	    }
	
		/* 압축된 문자열을 풀어주는 함수 ex) U2R = UUR, U'3R3 = U'U'U'RRR
		 * 사용자 입력이 저장되어 있는 String command[]의 각 요소에 접근하여 숫자가 있는 경우
		 * 위의 예처럼 압축을 풀어서 추가되어야 할 요소를 array에 insert() 메소드로 추가한다.
		 *  */
		
		public static void numberToString () {
			int numToRepeat = 0;	//반복해야할 숫자 ex) U2R 일 경우 2
			int idx = 0;			//반복해야할 숫자가 담긴 command[]의 인덱스
			String repeat = null;
			
			for(int i =0;i<command.length;i++) {
				int ascii = (int)command[i].charAt(0);	//command[]의 각 요소에 접근하여 숫자인지 판별
				if(ascii >= 48 && ascii <=57) {	//만약 숫자라면 그 숫자만큼 반복하여 command[]에 추가해줌
					 numToRepeat = Integer.parseInt(command[i]);
					 repeat = command[i-1];
					 idx = i;
					 command[idx] = repeat;	//idx번째 요소는 현재 숫자이므로 이전 idx -1로 바꿔준다.
					 
					 for(int j=0; j<numToRepeat-2; j++) {
						 insert(repeat, idx+1);	//추가할 string을 command[]에 insert	 
					 }
				}
			}
		}
		
		//cube[][] 에서 어떤 면을 돌릴 때 주변 면들의 요소를 가져와서 시계방향으로 rotate 해주는 함수
		static char[] rightRotate(char[] arr, int index) {
			StringBuilder str =new StringBuilder("");
			str.append(arr);
			String Rotated_str = str.substring(str.length()-index) + str.substring(0, str.length()-index);
			char Rotated_arr [] = Rotated_str.toCharArray();
			return Rotated_arr;
		}
		
		//cube[][] 에서 어떤 면을 돌릴 때 주변 면들의 요소를 가져와서 반시계방향 rotate 해주는 함수
		static char[] leftRotate(char[] arr, int index) {
			char[] Rotated_arr = rightRotate(arr, index);
			Rotated_arr = rightRotate(Rotated_arr, index);
			Rotated_arr = rightRotate(Rotated_arr, index);
			return Rotated_arr;
		}
		
		//앞면(F)을 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_F(){
			char temp[] = new char[3];
			for(int i=0;i<3;i++)
				temp[i] = cube[i+3][2];
			for(int i=0;i<3;i++)
				cube[3+i][2] = cube[6][3+i];
			for(int i=0;i<3;i++)
				cube[6][5-i] = cube[3+i][6];
			for(int i=0;i<3;i++)
				cube[3+i][6] = cube[2][3+i];
			for(int i=0;i<3;i++)
				cube[2][5-i] = temp[i];
		}
		
		//오른쪽면(R)을 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_R() {
			char temp[] = new char[12];
			for(int i=0;i<9;i++)
				temp[i] = cube[8-i][5];
			for(int i=0;i<3;i++)
				temp[9+i] = cube[3+i][9];
			
			temp = rightRotate(temp, 3);
			for(int i=0;i<9;i++)
				cube[8-i][5] = temp[i];
			for(int i=0;i<3;i++)
				cube[3+i][9] = temp[9+i];
		}
		
		//왼쪽(L)을 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_L() {
			char temp[] = new char[12];
			for(int i=0;i<9;i++)
				temp[i] = cube[8-i][3];
			for(int i=0;i<3;i++)
				temp[9+i] = cube[3+i][11];
			
			temp = leftRotate(temp, 3);
			for(int i=0;i<9;i++)
				cube[8-i][3] = temp[i];
			for(int i=0;i<3;i++)
				cube[3+i][11] = temp[9+i];
		}
		
		//윗면(U)을 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_U() {
			char temp[] = new char[12];
			for(int i=0;i<12;i++) 
				temp [i] = cube[3][i];
			temp = leftRotate(temp, 3);
			for(int i=0;i<12;i++)
				cube[3][i] = temp[i];
				
		}
		
		//아랫면(D)를 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_D() {
			char temp[] = new char[12];
			for(int i=0;i<12;i++) 
				temp [i] = cube[5][i];
			temp = rightRotate(temp, 3);
			for(int i=0;i<12;i++)
				cube[5][i] = temp[i];
		}
		
		//뒷면(R)을 돌릴 때 주변 면들의 변화를 적용하는 함수
		public static void rotate_B() {
			char temp[] = new char[12];
			for(int i=0;i<3;i++) {
				temp[i] = cube[3+i][8];
				temp[i+3] = cube[8][5-i];
				temp[i+6] = cube[5-i][0];
				temp[i+9] = cube[0][5-i];
			}
			
			temp = leftRotate(temp,3);
			for(int i=0;i<3;i++) {
				cube[3+i][8] = temp[i];
				cube[8][5-i] = temp[i+3];
				cube[3+i][0] = temp[i+6];
				cube[0][3+i] = temp[i+9];
			}
			
		}

		public static void main(String[] args) {		
			long startTime = System.currentTimeMillis();
			long endTime = 0;
			int flag = 0;
			cube = init();
			printCube(cube);
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				System.out.println("Cube(press Q + enter to quit) > ");
				String input = scan.next().toUpperCase();	//모든 입력값을 대문자로 바꾼다.

				command = input.split("(?!')");	//UU'B 가 입력인 경우 U,U',B로 split 해줌
				numberToString();
				System.out.println("\n");
				num = command.length + num;		//조작 횟수 카운트
				
				for(int i=0; i<command.length; i++) {
	
					switch(command[i]) {
					case "F":
						System.out.println("F");
						selfRotate(3,6,3,6);
						rotate_F();
						printCube(cube);
						break;
					case "F\'":
						System.out.println("F\'");
						selfRotate(3,6,3,6); selfRotate(3,6,3,6); selfRotate(3,6,3,6);
						rotate_F(); rotate_F(); rotate_F();
						printCube(cube);
						break;
					case "D":
						System.out.println("D");
						selfRotate(6,9,3,6);
						rotate_D();
						printCube(cube);
						break;
					case "D\'":
						System.out.println("D\'");
						selfRotate(6,9,3,6); selfRotate(6,9,3,6); selfRotate(6,9,3,6);
						rotate_D(); rotate_D(); rotate_D();
						printCube(cube);
						break;
					case "U":
						System.out.println("U");
						selfRotate(0,3,3,6);
						rotate_U();
						printCube(cube);
						break;
					case "U\'":	
						System.out.println("U\'");
						selfRotate(0,3,3,6); selfRotate(0,3,3,6); selfRotate(0,3,3,6);
						rotate_U(); rotate_U(); rotate_U();
						printCube(cube);
						break;
					case "R":
						System.out.println("R");
						selfRotate(3,6,6,9);
						rotate_R();
						printCube(cube);
						break;
					case "R\'":
						System.out.println("R\'");
						selfRotate(3,6,6,9); selfRotate(3,6,6,9); selfRotate(3,6,6,9);
						rotate_R(); rotate_R(); rotate_R();
						printCube(cube);
						break;
					case "L":
						System.out.println("L");
						selfRotate(3,6,0,3);
						rotate_L();
						printCube(cube);
						break;
					case "L\'":
						System.out.println("L\'");
						selfRotate(3,6,0,3); selfRotate(3,6,0,3); selfRotate(3,6,0,3); 
						rotate_L(); rotate_L(); rotate_L();
						printCube(cube);
						break;
					case "B":
						System.out.println("B");
						selfRotate(3,6,9,12);
						rotate_B();
						printCube(cube);
						break;
					case "B\'":
						System.out.println("B\'");
						selfRotate(3,6,9,12); selfRotate(3,6,9,12); selfRotate(3,6,9,12);
						rotate_B(); rotate_B(); rotate_B();
						printCube(cube);
						break;
					case "Q":
						System.out.println("Bye~");
						System.out.println("조작 횟수 : "+ (num-1));
						flag = -1;
						break;
					default:
						System.out.println(input+" ----> 입력이 올바르지 않습니다.");
						System.out.println("U,U',R,R',L,L',B,B',D,D',F,F'으로 나열된 문자를 입력해주세요.(소문자 가능)");
					}
					
					System.out.println("\n");
				}
				if(flag == -1) {
					break;
				}
				endTime = System.currentTimeMillis();
			}
			System.out.println("경과시간 : " + (endTime - startTime)/1000.0f +"초");
		}
}