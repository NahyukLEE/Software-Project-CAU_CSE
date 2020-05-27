/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 26��
 * ���� 		: Parameterized Stack using ArrayList
 */

import java.util.ArrayList;

public class ParaStackAL<T> {
	
	// int top;
	// ArrayList�� ��� size() �޼ҵ带 �������־� ������ top ������ �ʿ����� ����. top ������ ����� ������ �ּ����� ó����.
	
	int size = 5;
	ArrayList<T> stackAL;
	
	// Constructor
	public ParaStackAL() {
		// this.top = -1;	
		stackAL = new ArrayList<T>(this.size);
	}
	
	// Push Method
	public void push(T item) {

		// Java�� ArrayList ���� �迭��, ��� �������� �迭 ũ�� �ʰ� �� �ʱ� ������ ��ŭ �ڵ����� ũ�Ⱑ Ŀ��
		// ���� ������ ũ�� ���� �ڵ带 �ۼ����� �ʾƵ� �ȴٰ� �Ǵ���.

		stackAL.add(stackAL.size(), item); 
		// stackAL.add(++top, item); �� ����
		
		System.out.println(item + " PUSH"); 
		// System.out.println(stackAL.get(top) + " PUSH"); �� ����
	}
	
	// Pop Method
	public ArrayList<T> pop() {
		if (this.isEmpty()) {
			System.out.println("EMPTY");
		}
		else {
			System.out.println(stackAL.get(stackAL.size()-1) + " POP"); 
			// System.out.println(stackAL.get(stackAL.get(top) + " POP")); �� ����
			
			stackAL.remove(stackAL.size()-1); 
			// stackAL.remove(top); �� ����
		}
		return stackAL;
	}
	
	// isEmpty Method
	public boolean isEmpty() {
		return (stackAL.size() == 0 ); 
		// return (top == -1); �� ����
	}
	
}
