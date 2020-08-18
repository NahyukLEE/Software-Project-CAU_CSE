/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 6월 20일
 * 설명 		: Schedule Planner의 GUI를 구현하는 Class
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SchedulePlannerGUI extends JFrame implements ActionListener {
	
	// Class 전체에서 사용할 JPanel의 Data Field 선언
	private JPanel panel1 = new JPanel(); // 상단 패널
	private JPanel panel2 = new JPanel(); // 일~금 요일 출력
	private JPanel panel3; // 날짜 버튼 부분
	private JPanel panel4 = new JPanel();
	
	// Class 전체에서 사용할 JButton의 Data Field 선언
	private JButton left;
	private JButton right;
	
	// 기본 Default 화면은 2020년 5월을 가르키도록 함
	private int year = 2020;
	private int month = 5;
	
	// 연도와 월 data가 포함되어있는 LocalDate 자료형 선언
	private LocalDate defalutDate = LocalDate.of(year, month, 1);
	
	private String center = Integer.toString(year) + "-" + Integer.toString(month);
	private JLabel yearAndMonth = new JLabel(center);
	
	// 각각의 DayScheduleGUI 객체를 배열로 관리할 수 있도록 함
	private DayScheduleGUI[] DayScheduleGUIObject = new DayScheduleGUI[1];
	
 	// Constructor
	public SchedulePlannerGUI() {
		
		// SchedulePlannerGUI JFrame
		super("Schedule Planner");
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 상단 패널(panel1) 선언
		panel1.setPreferredSize(new Dimension(400,30));
		panel1.setLayout(new BorderLayout(5,5)); // BorderLayout
	    
		// 현재 연도와 달 표시 JLabel
		yearAndMonth.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(yearAndMonth, BorderLayout.CENTER);
		
		// 이전 달 이동 JButton
		panel1.add(left = new JButton("<"), BorderLayout.WEST);
		left.addActionListener(this);
		
		// 다음 달 이동 JButton
		panel1.add(right = new JButton(">"), BorderLayout.EAST);
		right.addActionListener(this);
		
		// 요일 정보가 들어가는 패널(panel2) 선언
		panel2.setPreferredSize(new Dimension(400,30));
		panel2.setLayout(new GridLayout(1,7)); // 1행 7열 Grid Layout
		
		// 일요일 JLabel
		JLabel sun = new JLabel("SUN");
		sun.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(sun);
		
		// 월요일 JLabel
		JLabel mon = new JLabel("MON");
		mon.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(mon);
		
		// 화요일 JLabel
		JLabel tue = new JLabel("TUE");
		tue.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(tue);
		
		// 수요일 JLabel
		JLabel wed = new JLabel("WED");
		wed.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(wed);
		
		// 목요일 JLabel
		JLabel thr = new JLabel("THR");
		thr.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(thr);
		
		// 금요일 JLabel
		JLabel fri = new JLabel("FRI");
		fri.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(fri);
		
		// 토요일 JLabel
		JLabel sat = new JLabel("SAT");
		sat.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(sat);
		
		// drawCalendar 메소드를 통해 달력 자동 계산 및 Panel Add
		drawCalendar(this.year, this.month);
		
		// 앞 세 개의 패널이 요소가 되는 패널(panel4) 선언
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);

		// Frame에 Panel 표시 및 Pack
		this.add(panel4);
		this.pack();
		this.setVisible(true);
		}
	
	// 월별 날짜수 및 시작 요일을 계산하고 이에 대한 Panel을 생성하는 메소드
	private void drawCalendar(int y,int  m) {
		
		// 파라미터를 통해 계산할 연도와 월 정보를 받음
		y = this.year;
		m = this.month;
		
		// 파라미터를 통해 받은 값을 defaultDate로 설정
		this.defalutDate = LocalDate.of(y,m,1);
		
		// 날짜(Day)가 들어가는 Panel 선언
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(400,200));
		panel3.setLayout(new GridLayout(0,7,2,2)); // 7열의 Grid, 행은 자동으로 설정
		
		/** -----날짜 부분 앞의 공백 추가----- */
	    // 해당 달의 첫 날이 일요일일 경우
	    if (defalutDate.getDayOfWeek().getValue() == 7) {
			;
	    }
	    // 해당 달의 첫 날이 월요일~토요일일 경우
	    else {
	    	for (int i=0; i<defalutDate.getDayOfWeek().getValue(); i++) {
	    		panel3.add(new JLabel(""));
	    	}
	    }
		
		// 해당 달의 날짜수를 받아 Grid에 숫자 JButton 추가
		for (int i = 1; i <= defalutDate.lengthOfMonth(); i++) {
			JButton days = new JButton(Integer.toString(i));
			panel3.add(days);
			LocalDate dayDate = LocalDate.of(this.year, this.month, i);
			
			// 날짜 버튼을 눌렀을 때의 Action 추가
			days.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// DayScheduleGUI는 하나의 객체만 생성되도록 관리한다. (중복 창 뜨는 것을 방지)
					if (DayScheduleGUIObject[0]!=null) {
						DayScheduleGUIObject[0].dispose();
						DayScheduleGUIObject[0]=null;
					}
					DayScheduleGUIObject[0] = new DayScheduleGUI(dayDate.getYear(),dayDate.getMonthValue(),dayDate.getDayOfMonth());
				}
			});
		}
		
		// 나머지 Grid를 공백으로 채우줌 (Column 오류 방지)
		int count = 7-((defalutDate.getDayOfWeek().getValue()+defalutDate.lengthOfMonth())%7);
		if (count != 7) {
			for (int i=0; i < count; i++) {
	    		panel3.add(new JLabel(""));
	    	}
		}
	}
	
	// Action을 관리하는 메소드
	public void actionPerformed(ActionEvent buttons) {
		
		// "<" 버튼 클릭 시
		if(buttons.getSource() == this.left) {
			// 1월이라면 연도--, 12월세팅
			if (month==1) {
				year--;
				month=12;
			}
			else month--; // 아니라면 월--
			yearAndMonth.setText(Integer.toString(year) + "-" + Integer.toString(month));
			
			panel4.remove(panel3);
			drawCalendar(this.month, this.year);
			panel4.add(panel3, BorderLayout.SOUTH);
		}
		
		// ">" 버튼 클릭 시
		else if(buttons.getSource() == this.right) {
			// 12월이라면 연도++, 1월 세팅
			if (this.month==12) {
				this.year++;
				this.month=1;
			}
			
			else this.month++; // 아니라면 월++
			yearAndMonth.setText(Integer.toString(this.year) + "-" + Integer.toString(this.month));
			
			panel4.remove(panel3);
			drawCalendar(this.month, this.year);
			panel4.add(panel3, BorderLayout.SOUTH);
		}
	}
}
	

