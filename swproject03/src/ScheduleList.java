/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 5�� 9��
 * ���� 		: ��� ���� ������ �����ϴ� ���α׷� �ۼ�(CUI) ~ ScheduleList Class
 */

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScheduleList {
	
	// Data Field
	private int num = 0; // ��ü ���� ���� ī��Ʈ��
	private Schedule[] schedules = new Schedule[100]; // ������ ��ü�� ��� Array ���� (ũ�� 100)
	
	// Constructor�� ���ڷ� ���� �̸��� �ָ� �ش� ���Ͽ� ����� �������� ���� ����� ����
	public ScheduleList(String fileName) {

		File file = new File(fileName);	// ���� �б�
		this.DBfile = fileName;
		
		try {
			Scanner input = new Scanner(file);
			this.Parsing(input);

		} catch(Exception e) {
			System.out.println("UnKnown File");
			return;
		}
	}
	
	// ������ �ʵ带 �и��ϰ� ��ü�� �����ϴ� �Ľ� �޼ҵ�
	private void Parsing(Scanner input) {
		
		while(input.hasNext()) {
			String line = input.nextLine();	// ���� �� �б�
			
			if (line.isEmpty() || line.charAt(0) == ';') // ����, �Ǵ� ó���� ;�� �����ϸ� comment ó��
				continue;

			String[] arr = line.split("//"); // "//"�� �����ڷ� �Ͽ� 4���� ��ҷ� ������ �迭 ����
			
			for (int i = 0; i<arr.length; i++) // 4���� ��� �յ��� ���� ����
				arr[i] = arr[i].trim();
			
			if (this.CheckScheduleTitle(arr)) // ������ �̸� ������ �Է� üũ
				continue;
			
			if (this.CheckDateFormat(arr)) // �ð� ���� ������ �Է� üũ
				continue;
			
			if (this.CheckTimeConflict(arr)) // �ð� ���� ������ �Է� üũ
				continue;
	
			// ���� ��ü ����
			schedules[num] = new Schedule();
			schedules[num].SetName(arr[0]);
			schedules[num].SetStartTime(arr[1]);
			schedules[num].SetEndTime(arr[2]);
			if (arr.length == 4)
				schedules[num].SetNote(arr[3]);
			
			num++; // ������ ���� ī��Ʈ
			
		}
		
		input.close();
	}
	
	// ������ �̸� ������ �Է� üũ �޼ҵ�
	private boolean CheckScheduleTitle(String[] arr) {
		if (arr[0].length()==0) {
			String CheckLine = ""; // ������ �Է� ���� ��¿� ���ڿ� ����
			
			// ��� ���
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("No Schedule Title  ; Skip the input line : " + CheckLine);
			
			return true; // ���� ���� �� true ����
		}
		
		else return false; // ���� ���� �� false ����
	}

	// �ð� ���� ������ �Է� üũ �޼ҵ�
	private boolean CheckDateFormat(String[] arr) {
		if (arr[1].charAt(4) != '-' || arr[1].charAt(7) != '-' || arr[1].charAt(10) != ' ' || arr[1].charAt(13) != ':' ) {
			String CheckLine = arr[0]; // ������ �Է� ���� ��¿� ���ڿ� ����
			
			// ��� ���
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("Wrong Date Format ; Skip the input line : " + CheckLine);
			
			return true; // ���� ���� �� true ����
		}

		else return false; // ���� ���� �� false ����
	}
	
	// �ð� ���� ������ �Է� üũ
	private boolean CheckTimeConflict(String[] arr) {
		if (LocalDateTime.parse(arr[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).isAfter(LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))) {
			String CheckLine = arr[0]; // ������ �Է� ���� ��¿� ���ڿ� ����
			
			// ��� ���
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("Start Time is later than End Time ; Skip the input line : " + CheckLine);
			
			return true; // ���� ���� �� true ����
		}
		else return false; // ���� ���� �� false ����
	}

	// ����Ʈ�� �ִ� ��ü ���� ���ڸ� �˷��ִ� �޼ҵ�
	public int numSchedules() {
			return num;
	}
	
	// ����Ʈ�� i��° ���� ������ �˷��ִ� �޼ҵ�
	public Schedule getSchedule(int i) {
			return this.schedules[i];
	}
	
	// Data Field
	private String DBfile; // DB ������ �̸��� ���ڿ��� ����
	
	// ���� ����� ���Ͽ� �����ϴ� �޼ҵ�
	public void DBupdate() {
		
		ScheduleList s1 = new ScheduleList(this.DBfile); // Constructor ȣ��
		
		File OldFile = new File(this.DBfile); // ���� DB �ε�
		
		// Backup ���� ���� �� ���� ����
		try {
			Scanner input = new Scanner(OldFile);
			
			// Backup DB�� ����ؼ� �����ϵ��� ��
			FileWriter writer = new FileWriter("schedule-file-backup.data", true);
			
			while(input.hasNext()) {
				String line = input.nextLine();
				writer.write(line + "\n");
				writer.flush();
			}
			
			input.close();
			writer.close();
			
		} catch(Exception e) {
			return;
		}	
		
		// ���� ������ DB Update
		try {
			// DB�� Update�� ����⸦ �ϵ��� ��
			FileWriter writer = new FileWriter(this.DBfile, false);
			
			for (int i=0; i < s1.numSchedules() ; i++) {
				writer.write(s1.getSchedule(i).GetName() + "//" +
						s1.getSchedule(i).GetStartTime() + "//" +
						s1.getSchedule(i).GetEndTime() + "//" +
						s1.getSchedule(i).GetNote() + "\n");
				writer.flush();
			}
			writer.close();
		} catch(Exception e) {
			return;
		}
		

		
	}
	
	// (�߰� ���� ����) ���ϴ� ������ ��ü ����
	public void DeleteSchedule(int number) {
		// delete schedules[number]
	}
}
