2021_codesquad_test
===================
1. step-1  
-------------------
* RotateWord.java에서 구현하였다.
* leftRotate와 rightRotate 메서드가 String 형태로 받은 input의 단어 밀어내기 기능을 수행한다.  
* input의 정수가 음수인지 확인하는 isNegative 함수를 두어 양수라면 rightRotate, 음수라면 그 절댓값만큼 leftRotate 하도록 하였다. 
* 정수가 음수든 양수든 그 절댓값이 단어의 길이보다 긴 경우 (정수 % 단어의 길이) 만큼 rotate 하도록 하였다.
  
  
2. step-2
-------------------
* Cube.java에서 구현하였다.
* R,R',L,L'의 경우 2차원 배열의 특정 column을 가져와야 하는데 이 기능을 getColumn 메소드에서 구현했다.
* cube[][]의 특정 column 혹은 row를 가져와서 rightRotate 혹은 leftRotate 메소드로 단어 밀어내기 기능을 구현했다.
* step-2 입력의 경우 UU'B가 들어온 경우 regex를 이용하여 command[] 배열에 ["U","U'","B"] 와 같이 들어가도록 하였다.

3. step-3
--------------------
* Rubikscube.java에서 구현하였다.
* 입력 :  기존의 step-2의 입력에서 R2와 같은 알파벳 + 숫자 입력이 있어 이를 처리 하기 위한 numberToString 메소드로 압축된 문자열을 풀어주도록 했다. 사용자 입력이 저장되어 있는 String command[]의 각 요소에 접근하여 숫자가 있는 경우 압축을 풀어서 추가되어야 할 요소를 array에 insert() 메소드로 추가한다.
* 아이디어1 : 면 하나가 회전 = 자기자신도 돌아감(selfRotate) + 주변의 면도 같이 돌아감
* 위의 생각을 가지고 selfRotate 메소드를 먼저 구현 - 면을 복사한 후에 시계방향으로 돈 결과를 cube에 반영해준다.
* 아이디어2 : 오른쪽 회전 3번 = 왼쪽 회전 1번
* 위의 생각을 가지고 leftRotate 함수는 step-2에서 쓰였던 rightRotate 함수를 재사용하여 3번 해주었다.
* 또한 모든 면 마다 rotate_U(), rotate_D()... 와 같은 식으로 시계방향 회전만을 구현한 후 반시계 방향 회전은 시계방향 회전 함수를 3번 하여 구현되도록 하였다.
  
  
<추가 기능 구현 여부>
* 프로그램 종료 시 경과 시간 출력 (o)
* 큐브의 무작위 섞기 기능 (o)
* 모든 면을 맞추면 축하 메시지와 함께 프로그램을 자동 종료 (x)
