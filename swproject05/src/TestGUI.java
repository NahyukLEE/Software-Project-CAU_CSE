public class TestGUI {

	public static void main(String[] args) {

		// Main 달력 화면의 GUI
		new SchedulePlannerGUI();

	    // 일별 일정 화면의 GUI
		new DayScheduleGUI(2020,3,25);
		
		// SchedulePlannerGUI의 날짜 JButton을 클릭하면 그 특정 날짜의 DayScheduleGUI 객체를 만들도록 프로젝트6 설계 예정
		
	}

}
