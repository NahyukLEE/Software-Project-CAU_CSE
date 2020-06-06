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
	
// data ���Ϸκ��� ������ �а�, �̸� Schedule ��ü�� ������
	ScheduleList list = new ScheduleList("schedule-file.data");
		
	DayScheduleGUI(int year, int month, int day){
		
		/** DayScheduleGUI JFrame */
		super("Day Schedule - " + year + "-" + month + "-" + day);
		setPreferredSize(new Dimension(600,260));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** ��� �г�(panel1) ���� */
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
		
		
		/** �ؽ�Ʈ �ʵ带 ��� �г�(panel2) ���� */
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(600,200));
		panel2.setLayout(new GridLayout(0,4));
		
		
		/** ������ ��¥�� �´� ���� ��ü�� ��� */
		for(int i=0; i < list.numSchedules() ; i++) {
			
			// GUI ��ü�� year�� Schedule ��ü�� ���� ���� �������� ���� ��� for�� continue 
			if (year != (list.getSchedule(i).GetDate().getYear())) {
				continue;
			}
			
			// GUI ��ü�� month�� Schedule ��ü�� �� ���� �������� ���� ��� for�� continue 
			if (month != (list.getSchedule(i).GetDate().getMonthValue())) {
				continue;	
			}
			
			// GUI ��ü�� day�� Schedule ��ü�� �� ���� �������� ���� ��� for�� continue 
			if (day != (list.getSchedule(i).GetDate().getDayOfMonth())) {
				continue;	
			}
			
			
			/** 3���� if���� ���� GUI ��ü�� Schedule ��ü�� ��¥�� �������� Ȯ�εǸ� Panel�� ���� add */
			Schedule meeting = list.getSchedule(i);
			
			// ���� Name�� TextField �߰�
			JTextField tf1 = new JTextField(meeting.GetName());
			panel2.add(tf1);
			
			// ���� Start Time�� TextField �߰�
			JTextField tf2 = new JTextField(meeting.GetStartTime());
			panel2.add(tf2);
			
			// ���� End Time�� TextField �߰�
			JTextField tf3 = new JTextField(meeting.GetEndTime());
			panel2.add(tf3);
			
			// ���� Note�� TextField �߰�
			JTextField tf4 = new JTextField(meeting.GetNote());
			panel2.add(tf4);
			
		}
		
		
		/** �ϴ� �� ���� ��ư�� Grouping�ϴ� Panel */
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(600,30));
		panel3.setLayout(new GridLayout(1,3));
		
		// Cancel JButton
		JButton cancel = new JButton("Cancel");
		panel3.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel�� Ŭ���Ǿ����ϴ�.");
			}
		});
		
		// Add JButton
		JButton add_ = new JButton("Add");
		panel3.add(add_);
		add_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add�� Ŭ���Ǿ����ϴ�.");
			}
		});
		
		// Save JButton
		JButton save = new JButton("Save");
		panel3.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save�� Ŭ���Ǿ����ϴ�.");
			}
		});
		
		
		/** ��ü �г��� Grouping�ϴ� Panel */
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);
		
		
		/** Frame�� Panel ǥ�� �� Pack */
		this.add(panel4);
		this.pack();
		this.setVisible(true);
	}
	
}
	
