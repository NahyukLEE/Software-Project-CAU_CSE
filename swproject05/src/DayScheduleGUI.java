import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DayScheduleGUI extends JFrame {
	
// data 파일로부터 정보를 읽고, 이를 Schedule 객체로 저장함
	ScheduleList list = new ScheduleList("schedule-file.data");
		
	DayScheduleGUI(int year, int month, int day){
		
		/** DayScheduleGUI JFrame */
		super("Day Schedule - " + year + "-" + month + "-" + day);
		setPreferredSize(new Dimension(600,260));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** 상단 패널(panel1) 선언 */
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(600,30));
		panel1.setLayout(new GridLayout(1,4));
		
		// Title JLabel
		JLabel title = new JLabel("Title");
		title.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(title);
		
		// Start Time JLabel
		JLabel startTime = new JLabel("Start Time");
		startTime.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(startTime);
		
		// End Time JLabel
		JLabel endTime = new JLabel("End Time");
		endTime.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(endTime);
		
		// Memo JLabel
		JLabel memo = new JLabel("Memo");
		memo.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(memo);
		
		
		/** 텍스트 필드를 담는 패널(panel2) 선언 */
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(600,200));
		panel2.setLayout(new GridLayout(0,4));
		
		
		/** 지정한 날짜에 맞는 일정 객체만 출력 */
		for(int i=0; i < list.numSchedules() ; i++) {
			
			// GUI 객체의 year과 Schedule 객체의 연도 값이 동일하지 않을 경우 for문 continue 
			if (year != (list.getSchedule(i).GetDate().getYear())) {
				continue;
			}
			
			// GUI 객체의 month과 Schedule 객체의 달 값이 동일하지 않을 경우 for문 continue 
			if (month != (list.getSchedule(i).GetDate().getMonthValue())) {
				continue;	
			}
			
			// GUI 객체의 day과 Schedule 객체의 일 값이 동일하지 않을 경우 for문 continue 
			if (day != (list.getSchedule(i).GetDate().getDayOfMonth())) {
				continue;	
			}
			
			
			/** 3개의 if문을 거쳐 GUI 객체와 Schedule 객체의 날짜가 동일함이 확인되면 Panel에 값을 add */
			Schedule meeting = list.getSchedule(i);
			
			// 일정 Name의 TextField 추가
			JTextField tf1 = new JTextField(meeting.GetName());
			panel2.add(tf1);
			
			// 일정 Start Time의 TextField 추가
			JTextField tf2 = new JTextField(meeting.GetStartTime());
			panel2.add(tf2);
			
			// 일정 End Time의 TextField 추가
			JTextField tf3 = new JTextField(meeting.GetEndTime());
			panel2.add(tf3);
			
			// 일정 Note의 TextField 추가
			JTextField tf4 = new JTextField(meeting.GetNote());
			panel2.add(tf4);
			
		}
		
		
		/** 하단 세 개의 버튼을 Grouping하는 Panel */
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(600,30));
		panel3.setLayout(new GridLayout(1,3));
		
		// Cancel JButton
		JButton cancel = new JButton("Cancel");
		panel3.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel이 클릭되었습니다.");
			}
		});
		
		// Add JButton
		JButton add_ = new JButton("Add");
		panel3.add(add_);
		add_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add이 클릭되었습니다.");
			}
		});
		
		// Save JButton
		JButton save = new JButton("Save");
		panel3.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save이 클릭되었습니다.");
			}
		});
		
		
		/** 전체 패널을 Grouping하는 Panel */
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
	
