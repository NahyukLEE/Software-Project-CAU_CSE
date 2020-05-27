/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 26일
 * 설명 		: Parameterized Stack with unlimited capacity
 */

public class ParaStack<T> extends ParaStackLimited<T> {
	
	Object[] stackArrayCopy;
	
	public ParaStack() {
		super(); // 명시적 표현
	}
	
	// Push Method
	public void push(T item) {
		// 스택이 가득 차지 않았다면 PUSH
		if (top+1 != size) {
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
		}
		// 스택이 가득 찼다면 FULL, Array의 크기를 2배로 증가시킴
		else {
			System.out.println("FULL. Array의 크기를 2배로 증가시킵니다.");
			
			// 2배 크기의 배열을 생성
			size = stackArray.length*2;
			stackArrayCopy = (T[]) new Object[size];

			// 새로 생성된 배열에 기존 배열 데이터 복사
			for(int i=0; i<stackArray.length; i++) {
				stackArrayCopy[i] = stackArray[i];
			}
			
			// 참조 변수를 수정하여 기존 배열 자동 삭제
			stackArray = stackArrayCopy;
			
			// 다시 PUSH를 진행
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
			
		}
	}
	
}

