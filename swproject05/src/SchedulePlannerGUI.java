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

public class SchedulePlannerGUI extends JFrame {

	// 프로젝트5에서 2020년 5월의 화면을 보여주기 위한 상수 선언
	int year = 2020;
	int month = 5;
	
	SchedulePlannerGUI() {
		
		/** SchedulePlannerGUI JFrame */
		super("Schedule Planner");
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 연도와 월 data가 포함되어있는 LocalDate 자료형 선언
		LocalDate defalutDate = LocalDate.of(year, month, 1); // 프로젝트6에서 동적으로 수정
		// 프로젝트5에서는 2020년 5월의 화면을 출력한다.
		
		
		/** 상단 패널(panel1) 선언 */
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(400,30));
		panel1.setLayout(new BorderLayout(5,5)); // BorderLayout
	    
		// 이전 달 이동 JButton
		JButton left = new JButton("<");
		panel1.add(left, BorderLayout.WEST);
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("<이 클릭되었습니다.");
				// 이전 달로 이동하는 동작 프로젝트6에서 작업
			}
		});
		
		// 다음 달 이동 JButton
		JButton right = new JButton(">");
		panel1.add(right, BorderLayout.EAST);
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">이 클릭되었습니다.");
				// 다음 달로 이동하는 동작 프로젝트6에서 작업
			}
		});
		
		// 현재 연도와 달 표시 JLabel
		String center = Integer.toString(year) + "-" + Integer.toString(month);
		JLabel yearAndMonth = new JLabel(center);
		yearAndMonth.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(yearAndMonth, BorderLayout.CENTER);


		/** 요일 정보가 들어가는 패널(panel2) 선언 */
		JPanel panel2 = new JPanel();
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
		
		
		/** 날짜(Day)가 들어가는 패널(panel3) 선언 */
		JPanel panel3 = new JPanel();
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
		
	    
		/** -----해당 달의 날짜수를 받아 Grid에 숫자 JButton 추가----- */
		for (int i = 1; i <= defalutDate.lengthOfMonth(); i++) {
			JButton days = new JButton(Integer.toString(i));
			panel3.add(days);
			days.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Day Schedule을 오픈합니다.");
					// 프로젝트6에서 각각 날짜별 DayScheduleGUI 객체를 통해 GUI를 구현할 예정
				}
			});
		}
		
		
		/** 앞 세 개의 패널이 요소가 되는 패널(panel4) 선언 */
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);

		
		/** Frame에 Panel 표시 및 Pack */
		this.add(panel4);
		this.pack();
		this.setVisible(true);
		}
	
}

