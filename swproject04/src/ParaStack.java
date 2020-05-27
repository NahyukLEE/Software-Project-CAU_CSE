/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 26��
 * ���� 		: Parameterized Stack with unlimited capacity
 */

public class ParaStack<T> extends ParaStackLimited<T> {
	
	Object[] stackArrayCopy;
	
	public ParaStack() {
		super(); // ����� ǥ��
	}
	
	// Push Method
	public void push(T item) {
		// ������ ���� ���� �ʾҴٸ� PUSH
		if (top+1 != size) {
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
		}
		// ������ ���� á�ٸ� FULL, Array�� ũ�⸦ 2��� ������Ŵ
		else {
			System.out.println("FULL. Array�� ũ�⸦ 2��� ������ŵ�ϴ�.");
			
			// 2�� ũ���� �迭�� ����
			size = stackArray.length*2;
			stackArrayCopy = (T[]) new Object[size];

			// ���� ������ �迭�� ���� �迭 ������ ����
			for(int i=0; i<stackArray.length; i++) {
				stackArrayCopy[i] = stackArray[i];
			}
			
			// ���� ������ �����Ͽ� ���� �迭 �ڵ� ����
			stackArray = stackArrayCopy;
			
			// �ٽ� PUSH�� ����
			stackArray[++top] = item;
			System.out.println(stackArray[top] + " PUSH");
			
		}
	}
	
}

