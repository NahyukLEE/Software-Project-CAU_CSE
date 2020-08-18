/**
 * 강의 및 교수 : 소프트웨어프로젝트 03분반 / 박창윤 교수님
 * 작성자 		: 이나혁_20194538 (nahyuk0113@cau.ac.kr)
 * 소속 		: 중앙대학교 소프트웨어학부 2학년
 * 코드 작성일 	: 2020년 6월 20일
 * 설명 		: Day Schedule의 GUI를 구현하는 Class
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DayScheduleGUI extends JFrame implements ActionListener {
	
	// data 파일로부터 정보를 읽고, 이를 Schedule 객체로 저장함
	private String DBfile= "schedule-file.data";
	private ScheduleList list = new ScheduleList(DBfile);
	
	// Class 전체에서 사용할 Panel의 Data Field 선언
	private JPanel panel2 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	// Class 전체에서 사용할 JButton의 Data Field 선언
	private JButton cancel;
	private JButton add_;
	private JButton save;
	
	// Class 전체에서 사용할 날짜 관련 int 변수의 Data Field 선언
	private int year, month, day;
	
	// Constructor
	public DayScheduleGUI(int year, int month, int day){
		
		// DayScheduleGUI JFrame
		super("Day Schedule - " + year + "-" + month + "-" + day);
		setPreferredSize(new Dimension(600,260));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 상단 패널(panel1) 선언
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
		
		// 일정 Panel을 담을 상위 Panel(panel2) 선언
		panel2.setPreferredSize(new Dimension(600,30));
		panel2.setLayout(new GridLayout(0,1,2,2));
		
		// Panel을 관리할 수 있는 ArrayList의 선언
		ArrayList panelObject = new ArrayList();
		
		// Constructor를 통해 입력받은 날짜 정보를 다른 메소드에 전달하기 위한 대입
		this.year = year;
		this.month = month;
		this.day = day;
		
		// 유효 Panel의 개수를 카운트 하기 위한 변수 선언
		int count = 0;
		
		// 지정한 날짜에 맞는 일정 객체 필터링
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
			
			// ArrayList 내 Schedule 객체에 자료를 입력, 기존 일정 객체에 대한 정보를 panelObject에 저장
			Schedule meeting = list.getSchedule(i);
			panelObject.add(addPanel(meeting.GetName(), meeting.GetStartTime(), meeting.GetEndTime(), meeting.GetNote()));
			panel2.add((Component) panelObject.get(count));
			count++;
		}
		// panelObject 초기화
		panelObject.clear();
		
		/** 하단 세 개의 버튼을 Grouping하는 Panel */
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(600,30));
		panel3.setLayout(new GridLayout(1,3));
		
		// Cancel JButton 생성
		panel3.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);
		
		// Add JButton 생성
		panel3.add(add_ = new JButton("Add"));
		add_.addActionListener(this);
		
		// Save JButton 생성
		panel3.add(save = new JButton("Save"));
		save.addActionListener(this);
		
		// 전체 패널을 Grouping하는 Panel
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);
		
		//Frame에 Panel 표시 및 Pack
		this.add(panel4);
		this.pack();
		this.setVisible(true);
	}
	
	// actionPerformed 메소드 내 Save 버튼 클릭 시 DB 파일 쓰기를 위한 JTextField 주소값 ArrayList 생성
	private ArrayList textFields = new ArrayList();
	
	// TextField Panel의 개수 카운트를 위한 변수 선언
	private int panelCount = 0;
	
	// 빈 JTextField들을 포함하는 Panel 생성 메소드
	private JPanel addPanel() {
		
		// 하나의 일정의 4개 JTextField를 포함하는 패널 생성
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(600,200));
		textPanel.setLayout(new GridLayout(0,4));
		
		// 일정 제목 JTextField
		JTextField tf1 = new JTextField();
		textPanel.add(tf1);
		textFields.add(tf1); // Save 버튼 클릭 시 자료 저장을 위해 새로운 ArrayList에 JTextField의 주소 복사
		
		// 일정 시작 시간 JTextField
		LocalDateTime startTime = LocalDateTime.of(this.year, this.month, this.day, 0,0,0); 
		String stringStartTime = startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		JTextField tf2 = new JTextField(stringStartTime);
		textPanel.add(tf2);
		textFields.add(tf2);
		
		// 일정 종료 시간 JTextField
		LocalDateTime endTime = LocalDateTime.of(this.year, this.month, this.day, 0,0,0); 
		String stringEndTime = endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		JTextField tf3 = new JTextField(stringEndTime);
		textPanel.add(tf3);
		textFields.add(tf3);
		
		// 일정 메모 JTextField
		JTextField tf4 = new JTextField();
		textPanel.add(tf4);
		textFields.add(tf4);
		
		// TextField Panel의 개수 카운트 후 Panel 리턴
		panelCount++;
		return textPanel;
	}
	
	// 메소드 오버로딩
	// DB에 이미 저장되어 있는 JTextField를 위한 Panel 생성 메소드
	private JPanel addPanel(String a, String b, String c, String d) {
		
		// 하나의 일정의 4개 JTextField를 포함하는 패널 생성
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(600,200));
		textPanel.setLayout(new GridLayout(0,4));
		
		// 일정 제목 JTextField
		JTextField tf1 = new JTextField(a);
		textPanel.add(tf1);
		textFields.add(tf1);
		
		// 일정 시작 시간 JTextField
		JTextField tf2 = new JTextField(b);
		textPanel.add(tf2);
		textFields.add(tf2);
		
		// 일정 종료 시간 JTextField
		JTextField tf3 = new JTextField(c);
		textPanel.add(tf3);
		textFields.add(tf3);
		
		// 일정 메모 JTextField
		JTextField tf4 = new JTextField(d);
		textPanel.add(tf4);
		textFields.add(tf4);
		
		// TextField Panel의 개수 카운트 후 Panel 리턴
		panelCount++;
		return textPanel;
	}
	
	// Panel을 읽고 JTextField를 통해 입력받은 정보를 일정 객체에 저장하는 메소드 
	private Schedule readPanel(JTextField a, JTextField b, JTextField c, JTextField d) {
		
		// Schedule 객체 생성
		Schedule newSchedule = new Schedule();
		
		// JTextField에서 입력받은 값을 일정 객체 Data Field에 저장
		newSchedule.SetName(a.getText());
		newSchedule.SetStartTime(b.getText());
		newSchedule.SetEndTime(c.getText());
		newSchedule.SetNote(d.getText());
		
		// 완성된 일정 객체 리턴
		return newSchedule;
	}
	
	// Action을 관리하는 메소드
	public void actionPerformed(ActionEvent buttons) {
		
		// Cancel 버튼 클릭 시
		if(buttons.getSource() == this.cancel) {
			// 창이 닫히도록 함
			this.dispose();
		}
		
		// Add 버튼 클릭 시
		else if(buttons.getSource() == this.add_) {
			// 빈 JTextField 생성
			panel2.add(addPanel());
			
			// Panel 동적 업데이트
			panel2.revalidate();
			panel2.repaint();
		}
		
		// Save 버튼 클릭 시
		else if(buttons.getSource() == this.save) {
			
			// 기존 Schedule 객체 배열의 수정을 위한 ArrayList 선언
			ArrayList newList = new ArrayList();
			
			// 일정의 제목이 없는 일정 객체는 삭제하도록 함
			for (int i=0; i < newList.size(); i++) {
				Schedule s = new Schedule();
				s = (Schedule) newList.get(i);
				if (s.GetName() == "") {
						newList.remove(i);
				}
			}
			
			// 해당 DaySchedule GUI와 다른 날짜는 newList에 객체 추가
			for(int i=0; i < list.numSchedules() ; i++) {
				if (this.year != (list.getSchedule(i).GetDate().getYear()) || 
						this.month != (list.getSchedule(i).GetDate().getMonthValue()) ||
						this.day != (list.getSchedule(i).GetDate().getDayOfMonth())) {
					newList.add(list.getSchedule(i));
				}
				else continue;
			}
			
			// 해당 날짜의 객체들을 newList에 추가
			for(int i=0; i < 4*panelCount; i=i+4) {
				newList.add(readPanel((JTextField)textFields.get(i),(JTextField)textFields.get(i+1),(JTextField)textFields.get(i+2),(JTextField)textFields.get(i+3)));
			}
			
			// 파일 읽기
			File file = new File(this.DBfile);
			
			try {
				// 파일의 내용은 덮어쓸 수 있도록 함
				FileWriter writer = new FileWriter(this.DBfile, false);
				
				for (int i=0; i < newList.size(); i++) {
					// 일정 객체 정보의 파일 쓰기를 위한 Schedule 객체의 선언
					Schedule s = new Schedule();
					s = (Schedule) newList.get(i);
					
					// Schedule 객체에 일정 제목이 없으면 Writing 생략
					if (s.GetName()=="") continue;
					
					// 일정 제목이 존재한다면 data 파일에 일정 객체에 대한 정보를 저장함
					writer.write(s.GetName() + "//" + s.GetStartTime() + "//" + s.GetEndTime() + "//" + s.GetNote() + "\n");
					writer.flush();
				}
				writer.close();
			} catch(Exception e) {
				return;
			}
			this.dispose();
		}
	}
}
	
