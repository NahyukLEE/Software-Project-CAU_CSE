/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 26��
 * ���� 		: Generic Stack with limited capacity
 */

public class GenericStackLimited {

	int top; // �ڷᱸ�� ������ ���� top ����
	int size = 10; // �뷮�� ����� ����, �ִ� ������ 10
	Object[] stackArray; // ���� Array ���, ��� Type�� ���� ���� �� �ֵ��� Object �迭 ����
	
	// Constructor
	public GenericStackLimited() {
		this.top = -1;
		stackArray = new Object[this.size];
	}
	
	// Push Method
	public void push(Object item) {
		// ������ ���� ���� �ʾҴٸ� PUSH
		if (top+1 != size) {
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
		}
		// ������ ���� á�ٸ� FULL
		else {
			System.out.println("FULL");
		}
	}
	
	// Pop Method
	public Object pop() {
		// ������ ����ִٸ� EMPTY�� �� ������ �ٽ� ����
		if (this.isEmpty()) {
			System.out.println("EMPTY");
			return stackArray;
		}
		// ������ ������� �ʴٸ� top�� �ش�Ǵ� �����Ͱ� ������ ���� ����
		else {
			System.out.println(stackArray[top]+" POP");
			return stackArray[top--];
		}
	}
	
	// isEmpty Method
	public boolean isEmpty() {
		// top�� ���� -1�̶�� �� ������ �ǹ���
		return (top == -1);
	}
}