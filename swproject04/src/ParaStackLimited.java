/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 26일
 * 설명 		: Parameterized Generic Stack with limited capacity
 */

public class ParaStackLimited<T> {
	
	int top; // 자료구조 구현을 위한 top 변수
	int size = 5; // 용량은 상수로 한정, 최대 사이즈 10
	Object[] stackArray; // 순수 Array 사용
	
	// Constructor
	public ParaStackLimited() {
		this.top = -1;
		
		// Object 배열의 Type Casting
		stackArray = (T[]) new Object[this.size];
	}
	
	// Push Method
	public void push(T item) {
		// 스택이 가득 차지 않았다면 PUSH
		if (top+1 != size) {
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
		}
		// 스택이 가득 찼다면 FULL
		else {
			System.out.println("FULL");
		}
	}
	
	// Pop Method
	public Object pop() {
		// 스택이 비어있다면 EMPTY로 빈 스택을 다시 리턴
		if (this.isEmpty()) {
			System.out.println("EMPTY");
			return stackArray;
		}
		// 스택이 비어있지 않다면 top에 해당되는 데이터가 삭제된 스택 리턴
		else {
			System.out.println(stackArray[top]+" POP");
			return stackArray[top--];
		}
	}
	
	// isEmpty Method
	public boolean isEmpty() {
		// top의 값이 -1이라면 빈 스택을 의미함
		return (top == -1);
	}
	
}

