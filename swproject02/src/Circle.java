/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 4월 10일
 * 설명 		: C언어로 작성된 circle.c 코드를 java 언어의 특징에 맞게 새롭게 코딩 ~ Circle Class
 */

// Circle 클래스
public class Circle {
	
	// 클래스 변수 
	float radius;
	float center_x;
	float center_y;
	final float PI = (float) Math.PI;
	
	// Circle 객체 생성 시 호출 될 Constructor 선언
	Circle(){
		
	}
	
	// Circle 객체 생성 시 호출 될 Constructor 선언, 입력받은 세 인자가 객체의 Data가 됨
	Circle(float newRadius, float newCenter_x, float newCenter_y){
		radius = newRadius;
		center_x = newCenter_x;
		center_y = newCenter_y;
	}
	
	// print() 메소드
	public void print() {
		//System.out.println("radius = " + radius + ", x of center = " + center_x + ", y of center = " + center_y + "\n");
		System.out.printf("radius = %f, x of center = %f, y of center = %f\n", radius, center_x, center_y);
	}
	
	// area() 메소드
	public float area() {
		return (float) (PI * Math.pow(radius, 2));		// float형 형 변환, Math 클래스 내 PI와 pow() 이용
	}
	
	// resize() 메소드
	public void resize(float ratio) {
		radius *= ratio;
	}
	
	// compare() 메소드, 객체의 참조변수를 인자로 받음
	public float compare(Circle c1, Circle c2) {
		// 개별 객체에 대한 접근
		return c1.area() - c2.area();
	}
	
	// equal() 메소드, 객체의 참조변수를 인자로 받음
	public boolean equal(Circle c1, Circle c2) {
		// 개별 객체에 대한 접근
		if ( (c1.radius == c2.radius) && (c1.center_x == c2.center_x) && (c1.center_y == c2.center_y) )
			return true;	//boolean 자료형 리턴
		else
			return false;	//boolean 자료형 리턴
	}
	
}
