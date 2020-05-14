/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 4�� 10��
 * ���� 		: C���� �ۼ��� circle.c �ڵ带 java ����� Ư¡�� �°� ���Ӱ� �ڵ� ~ TestCircle Class
 */

// TestCircle Ŭ����
public class TestCircle {

	// main �޼ҵ�
	public static void main(String[] args) {
		
		// c1 �������� ���� �� ��ü ����
		Circle c1 = new Circle();
		
		// c2, c3 �������� ���� �� ��ü ����
		Circle c2 = new Circle(2.0f, 0.0f, 0.0f);
		Circle c3 = new Circle(1.0f, 1.0f, 1.0f);
		
		// equal() �޼ҵ忡 ��������(c2, c3)�� ���ڷ� ����
		if (c1.equal(c2, c3))
			System.out.println("two circles are equal. \n");
		else
			System.out.println("two circles are different. \n");
		
		// compare() �޼ҵ忡 ��������(c2, c3)�� ���ڷ� ����
		if (c1.compare(c2, c3) < 0.0)
			System.out.println("the first is larger than the second. \n");
		else if (c1.compare(c2, c3) > 0.0)
			System.out.println("the first is smaller than the second. \n");
		else
			System.out.println("two are the same in area. \n");

		c3.print();			// Circle Ŭ������ ����� print() �޼ҵ�
		c3.resize(2.0f);	// Circle Ŭ������ ����� resize() �޼ҵ忡 float�� ���ڷ� ����
		c3.print();			// ������ c3.print(); �� ���� radius�� ���� (2.0f)�谡 ��
		
	}
}
