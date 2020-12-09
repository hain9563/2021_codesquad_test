import java.util.Scanner;


public class Cube {

	//2차원 배열 출력 함수
	public static void printCube(char[][] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) {
		char array[][] = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
		printCube(array);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Cube > ");
		String input = scan.next();
		String command[];
		command = input.split("(?!')");
		
		for(int i=0; i<command.length; i++) {
			//TODO 각 command에 맞는 함수 작성
			switch(command[i]) {
			case "U":
				System.out.println("rotate U");
				break;
			case "U\'":
				System.out.println("rotate U\'");
				break;
			case "R":
				System.out.println("rotate R");
				break;
			case "R\'":
				System.out.println("rotate R\'");
				break;
			case "L":
				System.out.println("rotate L");
				break;
			case "L\'":
				System.out.println("rotate U\'");
				break;
			case "B":
				System.out.println("rotate R");
				break;
			case "B\'":
				System.out.println("rotate R\'");
				break;
			case "Q":
				System.out.println("Bye~");
				break;
			}
		}
		
	}

}
