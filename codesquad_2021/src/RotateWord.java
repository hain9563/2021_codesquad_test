import java.util.Scanner;

public class RotateWord {
	
	static String leftRotate(String str, int index) {
		String Rotated_str = str.substring(2) + str.substring(0,index);
		return Rotated_str;
	}
	
	static String rightRotate(String str, int index) {
		String Rotated_str = str.substring(str.length()-index) + str.substring(0, str.length()-index);
		return Rotated_str;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String word = input.next();
		int index = input.nextInt();
		char direction = input.next().charAt(0);
		
		input.close();
	
		
		}
	
	
}