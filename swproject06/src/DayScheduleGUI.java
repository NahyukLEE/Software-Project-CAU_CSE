/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 6�� 20��
 * ���� 		: Day Schedule�� GUI�� �����ϴ� Class
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
	
	// data ���Ϸκ��� ������ �а�, �̸� Schedule ��ü�� ������
	private String DBfile= "schedule-file.data";
	private ScheduleList list = new ScheduleList(DBfile);
	
	// Class ��ü���� ����� Panel�� Data Field ����
	private JPanel panel2 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	// Class ��ü���� ����� JButton�� Data Field ����
	private JButton cancel;
	private JButton add_;
	private JButton save;
	
	// Class ��ü���� ����� ��¥ ���� int ������ Data Field ����
	private int year, month, day;
	
	// Constructor
	public DayScheduleGUI(int year, int month, int day){
		
		// DayScheduleGUI JFrame
		super("Day Schedule - " + year + "-" + month + "-" + day);
		setPreferredSize(new Dimension(600,260));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ��� �г�(panel1) ����
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
		
		// ���� Panel�� ���� ���� Panel(panel2) ����
		panel2.setPreferredSize(new Dimension(600,30));
		panel2.setLayout(new GridLayout(0,1,2,2));
		
		// Panel�� ������ �� �ִ� ArrayList�� ����
		ArrayList panelObject = new ArrayList();
		
		// Constructor�� ���� �Է¹��� ��¥ ������ �ٸ� �޼ҵ忡 �����ϱ� ���� ����
		this.year = year;
		this.month = month;
		this.day = day;
		
		// ��ȿ Panel�� ������ ī��Ʈ �ϱ� ���� ���� ����
		int count = 0;
		
		// ������ ��¥�� �´� ���� ��ü ���͸�
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
			
			// ArrayList �� Schedule ��ü�� �ڷḦ �Է�, ���� ���� ��ü�� ���� ������ panelObject�� ����
			Schedule meeting = list.getSchedule(i);
			panelObject.add(addPanel(meeting.GetName(), meeting.GetStartTime(), meeting.GetEndTime(), meeting.GetNote()));
			panel2.add((Component) panelObject.get(count));
			count++;
		}
		// panelObject �ʱ�ȭ
		panelObject.clear();
		
		/** �ϴ� �� ���� ��ư�� Grouping�ϴ� Panel */
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(600,30));
		panel3.setLayout(new GridLayout(1,3));
		
		// Cancel JButton ����
		panel3.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);
		
		// Add JButton ����
		panel3.add(add_ = new JButton("Add"));
		add_.addActionListener(this);
		
		// Save JButton ����
		panel3.add(save = new JButton("Save"));
		save.addActionListener(this);
		
		// ��ü �г��� Grouping�ϴ� Panel
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);
		
		//Frame�� Panel ǥ�� �� Pack
		this.add(panel4);
		this.pack();
		this.setVisible(true);
	}
	
	// actionPerformed �޼ҵ� �� Save ��ư Ŭ�� �� DB ���� ���⸦ ���� JTextField �ּҰ� ArrayList ����
	private ArrayList textFields = new ArrayList();
	
	// TextField Panel�� ���� ī��Ʈ�� ���� ���� ����
	private int panelCount = 0;
	
	// �� JTextField���� �����ϴ� Panel ���� �޼ҵ�
	private JPanel addPanel() {
		
		// �ϳ��� ������ 4�� JTextField�� �����ϴ� �г� ����
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(600,200));
		textPanel.setLayout(new GridLayout(0,4));
		
		// ���� ���� JTextField
		JTextField tf1 = new JTextField();
		textPanel.add(tf1);
		textFields.add(tf1); // Save ��ư Ŭ�� �� �ڷ� ������ ���� ���ο� ArrayList�� JTextField�� �ּ� ����
		
		// ���� ���� �ð� JTextField
		LocalDateTime startTime = LocalDateTime.of(this.year, this.month, this.day, 0,0,0); 
		String stringStartTime = startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		JTextField tf2 = new JTextField(stringStartTime);
		textPanel.add(tf2);
		textFields.add(tf2);
		
		// ���� ���� �ð� JTextField
		LocalDateTime endTime = LocalDateTime.of(this.year, this.month, this.day, 0,0,0); 
		String stringEndTime = endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		JTextField tf3 = new JTextField(stringEndTime);
		textPanel.add(tf3);
		textFields.add(tf3);
		
		// ���� �޸� JTextField
		JTextField tf4 = new JTextField();
		textPanel.add(tf4);
		textFields.add(tf4);
		
		// TextField Panel�� ���� ī��Ʈ �� Panel ����
		panelCount++;
		return textPanel;
	}
	
	// �޼ҵ� �����ε�
	// DB�� �̹� ����Ǿ� �ִ� JTextField�� ���� Panel ���� �޼ҵ�
	private JPanel addPanel(String a, String b, String c, String d) {
		
		// �ϳ��� ������ 4�� JTextField�� �����ϴ� �г� ����
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(600,200));
		textPanel.setLayout(new GridLayout(0,4));
		
		// ���� ���� JTextField
		JTextField tf1 = new JTextField(a);
		textPanel.add(tf1);
		textFields.add(tf1);
		
		// ���� ���� �ð� JTextField
		JTextField tf2 = new JTextField(b);
		textPanel.add(tf2);
		textFields.add(tf2);
		
		// ���� ���� �ð� JTextField
		JTextField tf3 = new JTextField(c);
		textPanel.add(tf3);
		textFields.add(tf3);
		
		// ���� �޸� JTextField
		JTextField tf4 = new JTextField(d);
		textPanel.add(tf4);
		textFields.add(tf4);
		
		// TextField Panel�� ���� ī��Ʈ �� Panel ����
		panelCount++;
		return textPanel;
	}
	
	// Panel�� �а� JTextField�� ���� �Է¹��� ������ ���� ��ü�� �����ϴ� �޼ҵ� 
	private Schedule readPanel(JTextField a, JTextField b, JTextField c, JTextField d) {
		
		// Schedule ��ü ����
		Schedule newSchedule = new Schedule();
		
		// JTextField���� �Է¹��� ���� ���� ��ü Data Field�� ����
		newSchedule.SetName(a.getText());
		newSchedule.SetStartTime(b.getText());
		newSchedule.SetEndTime(c.getText());
		newSchedule.SetNote(d.getText());
		
		// �ϼ��� ���� ��ü ����
		return newSchedule;
	}
	
	// Action�� �����ϴ� �޼ҵ�
	public void actionPerformed(ActionEvent buttons) {
		
		// Cancel ��ư Ŭ�� ��
		if(buttons.getSource() == this.cancel) {
			// â�� �������� ��
			this.dispose();
		}
		
		// Add ��ư Ŭ�� ��
		else if(buttons.getSource() == this.add_) {
			// �� JTextField ����
			panel2.add(addPanel());
			
			// Panel ���� ������Ʈ
			panel2.revalidate();
			panel2.repaint();
		}
		
		// Save ��ư Ŭ�� ��
		else if(buttons.getSource() == this.save) {
			
			// ���� Schedule ��ü �迭�� ������ ���� ArrayList ����
			ArrayList newList = new ArrayList();
			
			// ������ ������ ���� ���� ��ü�� �����ϵ��� ��
			for (int i=0; i < newList.size(); i++) {
				Schedule s = new Schedule();
				s = (Schedule) newList.get(i);
				if (s.GetName() == "") {
						newList.remove(i);
				}
			}
			
			// �ش� DaySchedule GUI�� �ٸ� ��¥�� newList�� ��ü �߰�
			for(int i=0; i < list.numSchedules() ; i++) {
				if (this.year != (list.getSchedule(i).GetDate().getYear()) || 
						this.month != (list.getSchedule(i).GetDate().getMonthValue()) ||
						this.day != (list.getSchedule(i).GetDate().getDayOfMonth())) {
					newList.add(list.getSchedule(i));
				}
				else continue;
			}
			
			// �ش� ��¥�� ��ü���� newList�� �߰�
			for(int i=0; i < 4*panelCount; i=i+4) {
				newList.add(readPanel((JTextField)textFields.get(i),(JTextField)textFields.get(i+1),(JTextField)textFields.get(i+2),(JTextField)textFields.get(i+3)));
			}
			
			// ���� �б�
			File file = new File(this.DBfile);
			
			try {
				// ������ ������ ��� �� �ֵ��� ��
				FileWriter writer = new FileWriter(this.DBfile, false);
				
				for (int i=0; i < newList.size(); i++) {
					// ���� ��ü ������ ���� ���⸦ ���� Schedule ��ü�� ����
					Schedule s = new Schedule();
					s = (Schedule) newList.get(i);
					
					// Schedule ��ü�� ���� ������ ������ Writing ����
					if (s.GetName()=="") continue;
					
					// ���� ������ �����Ѵٸ� data ���Ͽ� ���� ��ü�� ���� ������ ������
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
	
