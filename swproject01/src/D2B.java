/**
* ���� �� ���� : ����Ʈ����������Ʈ 03 �й� / ��â�� ������
* �ۼ��� : �̳���_20194538 (nahyuk0113@cau.ac.kr)
* �Ҽ� : �߾Ӵ��б� ����Ʈ�����к� 2 �г�
* �ڵ� �ۼ��� : 2020 �� 3 �� 25 ��
* ���� : int Ÿ���� 10 ���� ������ �Է� �޾� 2 ���� ǥ��� ��ȯ��Ű�� ���α׷�
*/

public class D2B {
	
    // main �޼ҵ�
    public static void main(String args[]) {
		
        // ���α׷� ���� Ȯ�� �׽�Ʈ
        System.out.println("Decimal 0 -> " + d2b(0));
        System.out.println("Decimal 1 -> " + d2b(1));
        System.out.println("Decimal 7 -> " + d2b(7));
        System.out.println("Decimal 16 -> " + d2b(16));
        System.out.println("Decimal 255 -> " + d2b(255));
        }
		
    // Decimal to Binary ��� �޼ҵ�
    static String d2b(int n) {
		
        int i, k; // for �� ���ۿ� �ʿ��� ���� ����
        int result[] = new int[20]; // 2 ���� ��ȯ ����� �������� ������ �迭 ����
		
        String s=""; // d2b �޼ҵ忡�� ��ȯ�� ����� String ������ ����
		
        // 10 ������ 0 �� �ƴ� ���
        if (n != 0) {
			
            // 10 ���� n �� 2 �� ���� �������� result �迭��, ���� n �� ����
            for (i=0; n>0; i++) {
                result[i] = n % 2;
                n = n / 2;
            }
            // result �迭 ��Ҹ� �������� ���ڿ� s �� ����
            for (k=i-1; k>=0; k--) {
                s = s + result[k] + " ";
            }
        }
		
        // 10 ������ 0 �� ���
        else
            s = "0";
		
        // d2b �޼ҵ� ����(2 ���� ���� ���)
        return s;
    }
}