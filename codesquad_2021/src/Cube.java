import java.util.Scanner;
import java.lang.*;

public class Cube {

	//2차원 배열 출력 함수
	static void printCube(char[][] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	//특정 column 얻기
	static char[] getColumn(char[][] array, int index){
	    char[] column = new char[array[0].length]; // Here I assume a rectangular 2D array! 
	    for(int i=0; i<column.length; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}
	
	//왼쪽 회전
	static char[] leftRotate(char[] arr, int index) {
		StringBuilder str =new StringBuilder("");
		str.append(arr);
		String Rotated_str = str.substring(index) + str.substring(0,index);
		char Rotated_arr [] = Rotated_str.toCharArray();
		return Rotated_arr;
	}
	
	//오른쪽 회전
	static char[] rightRotate(char[] arr, int index) {
		StringBuilder str =new StringBuilder("");
		str.append(arr);
		String Rotated_str = str.substring(str.length()-index) + str.substring(0, str.length()-index);
		char Rotated_arr [] = Rotated_str.toCharArray();
		return Rotated_arr;
	}
	
	
	public static void main(String[] args) {
		char array[][] = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
		printCube(array);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Cube > ");
		String input = scan.next().toUpperCase();	//모든 입력값을 대문자로 바꾼다.
		String command[];
		command = input.split("(?!')");	//UU'B 가 입력인 경우 U,U',B로 split 해줌
		
		for(int i=0; i<command.length; i++) {
			switch(command[i]) {
			case "U":	//가장 윗줄 왼쪽 한 칸 밀기
				System.out.println("rotate U");
				char U_rotate[] = leftRotate(array[0], 1);
				array[0][0] = U_rotate[0];
				array[0][1] = U_rotate[1];
				array[0][2] = U_rotate[2];
				printCube(array);
				break;
			case "U\'":	//가장 윗줄 오른쪽 한 칸 밀기
				System.out.println("rotate U\'");
				char UU_rotate[] = rightRotate(array[0], 1);
				array[0][0] = UU_rotate[0];
				array[0][1] = UU_rotate[1];
				array[0][2] = UU_rotate[2];
				printCube(array);
				break;
			case "R":	//가장 오른쪽 줄 위로 한 칸 밀기 = 왼쪽 한 칸
				System.out.println("rotate R");
				char R_rotate[] = leftRotate(getColumn(array,2),1);
				array[0][2] = R_rotate[0];
				array[1][2] = R_rotate[1];
				array[2][2] = R_rotate[2];
				printCube(array);
				break;
			case "R\'":	//가장 오른쪽 줄 아래로 한 칸 밀기 = 오른쪽 한 칸
				System.out.println("rotate R\'");
				char RR_rotate [] = rightRotate(getColumn(array,2),1);
				array[0][2] = RR_rotate[0];
				array[1][2] = RR_rotate[1];
				array[2][2] = RR_rotate[2];
				printCube(array);
				break;
			case "L":	//가장 왼쪽 줄 아래로 한 칸 밀기 = 오른쪽 한 칸
				System.out.println("rotate L");
				char L_rotate [] = rightRotate(getColumn(array,0),1);
				array[0][0] = L_rotate[0];
				array[1][0] = L_rotate[1];
				array[2][0] = L_rotate[2];
				printCube(array);
				break;
			case "L\'":	//가장 왼족 줄 위로 한 칸 밀기 = 왼쪽 한 칸 
				System.out.println("rotate U\'");
				char LL_rotate [] = leftRotate(getColumn(array,0),1);
				array[0][0] = LL_rotate[0];
				array[1][0] = LL_rotate[1];
				array[2][0] = LL_rotate[2];
				printCube(array);
				break;
			case "B":	//가장 아랫줄 오른쪽 한 칸 밀기
				System.out.println("rotate R");
				char B_rotate [] = rightRotate(array[2],1);
				array[2][0] = B_rotate[0];
				array[2][1] = B_rotate[1];
				array[3][1] = B_rotate[2];
				printCube(array);
				break;
			case "B\'":	//가장 아랫줄 왼쪽 한 칸 밀기
				System.out.println("rotate R\'");
				char BB_rotate [] = leftRotate(array[2],1);
				array[2][0] = BB_rotate[0];
				array[2][1] = BB_rotate[1];
				array[3][1] = BB_rotate[2];
				printCube(array);
				break;
			case "Q":
				System.out.println("Bye~");
				printCube(array);
				break;
			default:
				System.out.println("입력이 올바르지 않습니다.");
				System.out.println("U,U',R,R',L,L',B,B'으로 나열된 문자를 입력해주세요.(소문자 가능)");
				break;
			}
		}
		
	}

}
