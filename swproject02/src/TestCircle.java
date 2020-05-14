/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 4월 10일
 * 설명 		: C언어로 작성된 circle.c 코드를 java 언어의 특징에 맞게 새롭게 코딩 ~ TestCircle Class
 */

// TestCircle 클래스
public class TestCircle {

	// main 메소드
	public static void main(String[] args) {
		
		// c1 참조변수 선언 및 객체 생성
		Circle c1 = new Circle();
		
		// c2, c3 참조변수 선언 및 객체 생성
		Circle c2 = new Circle(2.0f, 0.0f, 0.0f);
		Circle c3 = new Circle(1.0f, 1.0f, 1.0f);
		
		// equal() 메소드에 참조변수(c2, c3)를 인자로 넣음
		if (c1.equal(c2, c3))
			System.out.println("two circles are equal. \n");
		else
			System.out.println("two circles are different. \n");
		
		// compare() 메소드에 참조변수(c2, c3)를 인자로 넣음
		if (c1.compare(c2, c3) < 0.0)
			System.out.println("the first is larger than the second. \n");
		else if (c1.compare(c2, c3) > 0.0)
			System.out.println("the first is smaller than the second. \n");
		else
			System.out.println("two are the same in area. \n");

		c3.print();			// Circle 클래스에 선언된 print() 메소드
		c3.resize(2.0f);	// Circle 클래스에 선언된 resize() 메소드에 float를 인자로 넣음
		c3.print();			// 이전의 c3.print(); 와 비교해 radius의 값이 (2.0f)배가 됨
		
	}
}
