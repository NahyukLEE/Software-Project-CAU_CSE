/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 9일
 * 설명 		: 약속 등의 일정을 관리하는 프로그램 작성(CUI) ~ Schedule Class
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

	// Name Getter 메소드
	public String GetName() {
		return this.name;
	}
	
	// StartTime Getter(String) 메소드
	public String GetStartTime() {
		return this.LocalDateTimeToString(this.StartTime);
	}
	
	// EndTime Getter(String) 메소드
	public String GetEndTime() {
		return this.LocalDateTimeToString(this.EndTime);
	}
	
	// Note Getter 메소드
	public String GetNote() {
		return this.note;
	}
	
	// Name Setter 메소드
	public void SetName(String name) {
		this.name = name;
	}
	
	// StartTime Setter 메소드
	public void SetStartTime(String StartTime) {
		this.StartTime = this.StringToLocalDateTime(StartTime);
	}
	
	// EndTime Setter 메소드
	public void SetEndTime(String EndTime) {
		this.EndTime = this.StringToLocalDateTime(EndTime);
	}
	
	// Note Setter 메소드
	public void SetNote(String note) {
		this.note = note;
	}
	
	// String을 LocalDateTime으로 바꿔주는 메소드
	private LocalDateTime StringToLocalDateTime(String time) {
		LocalDateTime localdatetime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return localdatetime;
	}
	
	// LocalDateTime을 String으로 바꿔주는 메소드
	private String LocalDateTimeToString(LocalDateTime time) {
		String stringtime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return stringtime;
	}

	// 하나의 일정에 대한 정보를 콘솔로 출력하여 주는 메소드
	public void print() {
		System.out.println(this.name + "//" +
				LocalDateTimeToString(this.StartTime) + "//" +
				LocalDateTimeToString(this.EndTime) + "//" +
				this.note);
	}
	
	// StartTime을 LocalDateTime형으로 반환
	public LocalDateTime GetDate() {
		// TODO Auto-generated method stub
		return StartTime;
	}
	
}