/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 9��
 * ���� 		: ��� ���� ������ �����ϴ� ���α׷� �ۼ�(CUI) ~ TestScheduleList Class
 */

public class TestScheduleList {
	
	// main �޼ҵ�
	public static void main(String[] args) {

		ScheduleList list = new ScheduleList("schedule-file.data");
		
		for(int i=0; i < list.numSchedules() ; i++) {
			list.getSchedule(i).print();
		}
		
		list.DBupdate();
		
	}
}
