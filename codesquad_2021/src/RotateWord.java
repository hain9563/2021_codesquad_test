import java.util.Scanner;

public class RotateWord {
	
	//왼쪽 회전
	static String leftRotate(String str, int index) {
		String Rotated_str = str.substring(index) + str.substring(0,index);
		return Rotated_str;
	}
	
	//오른쪽 회전 1번 = 왼쪽 회전 세번!!!
	static String rightRotate(String str, int index) {	
		return leftRotate(str, str.length()- index);
	}
	
	static boolean isNegative(int index){
		boolean dir;
		if(index < 0) dir = false;
		else dir = true;
		return dir;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String answer = null;
		while(true) {
			String word = input.next();
			int index = input.nextInt();
			char direction = input.next().charAt(0);
			
			//direction 변수 예외처리
			if(!(direction == 'r' || direction == 'R' || direction == 'l' || direction == 'L')) {
				System.out.println("3번째 인자는 L(l) 혹은 R(r) 중에 하나 여야 합니다. 다시 입력해주세요\n");
				continue;
			}
			
			//index 변수 예외처리
			if(!(index >= -100 && index < 100)) {
				System.out.println("2번째 인자는 -100 이상 100 미만의 정수이여야 합니다. 다시입력해주세요\n");
				continue;
			}
			
			//정수가 음수인 경우
			if (!isNegative(index)) {
				if (direction == 'R' || direction == 'r') direction = 'L';
				else if (direction == 'L' || direction == 'l') direction = 'R';
				index = index * (-1);
			}
			
			// index 정수의 절댓값이 단어의 길이보다 긴 경우 remainder를 이용 
			int remainder = index % word.length();
			
			if (direction == 'R' || direction == 'r') {
				answer = rightRotate(word, remainder);
			}
			else if (direction == 'L' || direction == 'l') {
				answer = leftRotate(word, remainder);
			}
			
			System.out.println(answer + '\n');
		}
		
		
		
		}
	
	
}