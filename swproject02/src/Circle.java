/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 4�� 10��
 * ���� 		: C���� �ۼ��� circle.c �ڵ带 java ����� Ư¡�� �°� ���Ӱ� �ڵ� ~ Circle Class
 */

// Circle Ŭ����
public class Circle {
	
	// Ŭ���� ���� 
	float radius;
	float center_x;
	float center_y;
	final float PI = (float) Math.PI;
	
	// Circle ��ü ���� �� ȣ�� �� Constructor ����
	Circle(){
		
	}
	
	// Circle ��ü ���� �� ȣ�� �� Constructor ����, �Է¹��� �� ���ڰ� ��ü�� Data�� ��
	Circle(float newRadius, float newCenter_x, float newCenter_y){
		radius = newRadius;
		center_x = newCenter_x;
		center_y = newCenter_y;
	}
	
	// print() �޼ҵ�
	public void print() {
		//System.out.println("radius = " + radius + ", x of center = " + center_x + ", y of center = " + center_y + "\n");
		System.out.printf("radius = %f, x of center = %f, y of center = %f\n", radius, center_x, center_y);
	}
	
	// area() �޼ҵ�
	public float area() {
		return (float) (PI * Math.pow(radius, 2));		// float�� �� ��ȯ, Math Ŭ���� �� PI�� pow() �̿�
	}
	
	// resize() �޼ҵ�
	public void resize(float ratio) {
		radius *= ratio;
	}
	
	// compare() �޼ҵ�, ��ü�� ���������� ���ڷ� ����
	public float compare(Circle c1, Circle c2) {
		// ���� ��ü�� ���� ����
		return c1.area() - c2.area();
	}
	
	// equal() �޼ҵ�, ��ü�� ���������� ���ڷ� ����
	public boolean equal(Circle c1, Circle c2) {
		// ���� ��ü�� ���� ����
		if ( (c1.radius == c2.radius) && (c1.center_x == c2.center_x) && (c1.center_y == c2.center_y) )
			return true;	//boolean �ڷ��� ����
		else
			return false;	//boolean �ڷ��� ����
	}
	
}
