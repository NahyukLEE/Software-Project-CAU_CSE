/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 9��
 * ���� 		: ��� ���� ������ �����ϴ� ���α׷� �ۼ�(CUI) ~ Schedule Class
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {

	// Data Field
	private String name = "None";
	private LocalDateTime StartTime = LocalDateTime.now();
	private LocalDateTime EndTime = LocalDateTime.now();
	private String note = "None";
	
	// Constructor
	public Schedule() {
		
	}

	// Name Getter �޼ҵ�
	public String GetName() {
		return this.name;
	}
	
	// StartTime Getter(String) �޼ҵ�
	public String GetStartTime() {
		return this.LocalDateTimeToString(this.StartTime);
	}
	
	// EndTime Getter(String) �޼ҵ�
	public String GetEndTime() {
		return this.LocalDateTimeToString(this.EndTime);
	}
	
	// Note Getter �޼ҵ�
	public String GetNote() {
		return this.note;
	}
	
	// Name Setter �޼ҵ�
	public void SetName(String name) {
		this.name = name;
	}
	
	// StartTime Setter �޼ҵ�
	public void SetStartTime(String StartTime) {
		this.StartTime = this.StringToLocalDateTime(StartTime);
	}
	
	// EndTime Setter �޼ҵ�
	public void SetEndTime(String EndTime) {
		this.EndTime = this.StringToLocalDateTime(EndTime);
	}
	
	// Note Setter �޼ҵ�
	public void SetNote(String note) {
		this.note = note;
	}
	
	// String�� LocalDateTime���� �ٲ��ִ� �޼ҵ�
	private LocalDateTime StringToLocalDateTime(String time) {
		LocalDateTime localdatetime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return localdatetime;
	}
	
	// LocalDateTime�� String���� �ٲ��ִ� �޼ҵ�
	private String LocalDateTimeToString(LocalDateTime time) {
		String stringtime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return stringtime;
	}

	// �ϳ��� ������ ���� ������ �ַܼ� ����Ͽ� �ִ� �޼ҵ�
	public void print() {
		System.out.println(this.name + "//" +
				LocalDateTimeToString(this.StartTime) + "//" +
				LocalDateTimeToString(this.EndTime) + "//" +
				this.note);
	}
	
	// StartTime�� LocalDateTime������ ��ȯ
	public LocalDateTime GetDate() {
		// TODO Auto-generated method stub
		return StartTime;
	}
	
}