
public class TestParaStack {

	public static void main(String[] args) {
		
		ParaStack<Integer> stack = new ParaStack<Integer>();
		System.out.println("Stack의 크기 : " + stack.size);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println("Stack의 크기 : " + stack.size);
		
	}

}
