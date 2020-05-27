/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 26일
 * 설명 		: Parameterized Stack using ArrayList
 */

import java.util.ArrayList;

public class ParaStackAL<T> {
	
	// int top;
	// ArrayList의 경우 size() 메소드를 제공해주어 별도의 top 변수가 필요하지 않음. top 변수를 사용한 구현은 주석으로 처리함.
	
	int size = 5;
	ArrayList<T> stackAL;
	
	// Constructor
	public ParaStackAL() {
		// this.top = -1;	
		stackAL = new ArrayList<T>(this.size);
	}
	
	// Push Method
	public void push(T item) {

		// Java의 ArrayList 동적 배열로, 요소 삽입으로 배열 크기 초과 시 초기 지정값 만큼 자동으로 크기가 커짐
		// 따라서 별도의 크기 증가 코드를 작성하지 않아도 된다고 판단함.

		stackAL.add(stackAL.size(), item); 
		// stackAL.add(++top, item); 과 같음
		
		System.out.println(item + " PUSH"); 
		// System.out.println(stackAL.get(top) + " PUSH"); 과 같음
	}
	
	// Pop Method
	public ArrayList<T> pop() {
		if (this.isEmpty()) {
			System.out.println("EMPTY");
		}
		else {
			System.out.println(stackAL.get(stackAL.size()-1) + " POP"); 
			// System.out.println(stackAL.get(stackAL.get(top) + " POP")); 과 같음
			
			stackAL.remove(stackAL.size()-1); 
			// stackAL.remove(top); 과 같음
		}
		return stackAL;
	}
	
	// isEmpty Method
	public boolean isEmpty() {
		return (stackAL.size() == 0 ); 
		// return (top == -1); 과 같음
	}
	
}
