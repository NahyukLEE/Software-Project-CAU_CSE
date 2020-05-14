/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 5월 9일
 * 설명 		: 약속 등의 일정을 관리하는 프로그램 작성(CUI) ~ TestScheduleList Class
 */

public class TestScheduleList {
	
	// main 메소드
	public static void main(String[] args) {

		ScheduleList list = new ScheduleList("schedule-file.data");
		
		for(int i=0; i < list.numSchedules() ; i++) {
			list.getSchedule(i).print();
		}
		
		list.DBupdate();
		
	}
}
