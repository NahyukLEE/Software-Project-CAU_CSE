/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 9일
 * 설명 		: 약속 등의 일정을 관리하는 프로그램 작성(CUI) ~ ScheduleList Class
 */

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScheduleList {
	
	// Data Field
	private int num = 0; // 전체 일정 숫자 카운트용
	private Schedule[] schedules = new Schedule[100]; // 스케줄 객체를 담는 Array 생성 (크기 100)
	
	// Constructor의 인자로 파일 이름을 주면 해당 파일에 기술된 내용으로 일정 목록을 만듦
	public ScheduleList(String fileName) {

		File file = new File(fileName);	// 파일 읽기
		this.DBfile = fileName;
		
		try {
			Scanner input = new Scanner(file);
			this.Parsing(input);

		} catch(Exception e) {
			System.out.println("UnKnown File");
			return;
		}
	}
	
	// 정해진 필드를 분리하고 객체를 생성하는 파싱 메소드
	private void Parsing(Scanner input) {
		
		while(input.hasNext()) {
			String line = input.nextLine();	// 다음 행 읽기
			
			if (line.isEmpty() || line.charAt(0) == ';') // 빈줄, 또는 처음을 ;로 시작하면 comment 처리
				continue;

			String[] arr = line.split("//"); // "//"을 구분자로 하여 4개의 요소로 구성된 배열 생성
			
			for (int i = 0; i<arr.length; i++) // 4개의 요소 앞뒤의 공백 제거
				arr[i] = arr[i].trim();
			
			if (this.CheckScheduleTitle(arr)) // 스케줄 이름 비정상 입력 체크
				continue;
			
			if (this.CheckDateFormat(arr)) // 시간 포맷 비정상 입력 체크
				continue;
			
			if (this.CheckTimeConflict(arr)) // 시간 순서 비정상 입력 체크
				continue;
	
			// 일정 객체 생성
			schedules[num] = new Schedule();
			schedules[num].SetName(arr[0]);
			schedules[num].SetStartTime(arr[1]);
			schedules[num].SetEndTime(arr[2]);
			if (arr.length == 4)
				schedules[num].SetNote(arr[3]);
			
			num++; // 스케줄 개수 카운트
			
		}
		
		input.close();
	}
	
	// 스케줄 이름 비정상 입력 체크 메소드
	private boolean CheckScheduleTitle(String[] arr) {
		if (arr[0].length()==0) {
			String CheckLine = ""; // 비정상 입력 문장 출력용 문자열 선언
			
			// 경고문 출력
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("No Schedule Title  ; Skip the input line : " + CheckLine);
			
			return true; // 오류 존재 시 true 리턴
		}
		
		else return false; // 오류 없을 시 false 리턴
	}

	// 시간 포맷 비정상 입력 체크 메소드
	private boolean CheckDateFormat(String[] arr) {
		if (arr[1].charAt(4) != '-' || arr[1].charAt(7) != '-' || arr[1].charAt(10) != ' ' || arr[1].charAt(13) != ':' ) {
			String CheckLine = arr[0]; // 비정상 입력 문장 출력용 문자열 선언
			
			// 경고문 출력
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("Wrong Date Format ; Skip the input line : " + CheckLine);
			
			return true; // 오류 존재 시 true 리턴
		}

		else return false; // 오류 없을 시 false 리턴
	}
	
	// 시간 순서 비정상 입력 체크
	private boolean CheckTimeConflict(String[] arr) {
		if (LocalDateTime.parse(arr[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).isAfter(LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))) {
			String CheckLine = arr[0]; // 비정상 입력 문장 출력용 문자열 선언
			
			// 경고문 출력
			for (int i = 1; i<arr.length; i++) {
				CheckLine += "//";
				CheckLine += arr[i];
			}
			System.out.println("Start Time is later than End Time ; Skip the input line : " + CheckLine);
			
			return true; // 오류 존재 시 true 리턴
		}
		else return false; // 오류 없을 시 false 리턴
	}

	// 리스트에 있는 전체 일정 숫자를 알려주는 메소드
	public int numSchedules() {
			return num;
	}
	
	// 리스트의 i번째 일정 정보를 알려주는 메소드
	public Schedule getSchedule(int i) {
			return this.schedules[i];
	}
	
	// Data Field
	private String DBfile; // DB 파일의 이름을 문자열로 저장
	
	// 일정 목록을 파일에 저장하는 메소드
	public void DBupdate() {
		
		ScheduleList s1 = new ScheduleList(this.DBfile); // Constructor 호출
		
		File OldFile = new File(this.DBfile); // 기존 DB 로드
		
		// Backup 파일 생성 후 원본 복사
		try {
			Scanner input = new Scanner(OldFile);
			
			// Backup DB는 계속해서 누적하도록 함
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
		
		// 원본 파일의 DB Update
		try {
			// DB의 Update는 덮어쓰기를 하도록 함
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
	
	// (추가 구현 예정) 원하는 스케쥴 객체 제거
	public void DeleteSchedule(int number) {
		// delete schedules[number]
	}
}
