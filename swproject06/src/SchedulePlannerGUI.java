/**
 * ���� �� ���� : ����Ʈ����������Ʈ 03�й� / ��â�� ������
 * �ۼ��� 		: �̳���_20194538 (nahyuk0113@cau.ac.kr)
 * �Ҽ� 		: �߾Ӵ��б� ����Ʈ�����к� 2�г�
 * �ڵ� �ۼ��� 	: 2020�� 6�� 20��
 * ���� 		: Schedule Planner�� GUI�� �����ϴ� Class
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
	
	// Class ��ü���� ����� JPanel�� Data Field ����
	private JPanel panel1 = new JPanel(); // ��� �г�
	private JPanel panel2 = new JPanel(); // ��~�� ���� ���
	private JPanel panel3; // ��¥ ��ư �κ�
	private JPanel panel4 = new JPanel();
	
	// Class ��ü���� ����� JButton�� Data Field ����
	private JButton left;
	private JButton right;
	
	// �⺻ Default ȭ���� 2020�� 5���� ����Ű���� ��
	private int year = 2020;
	private int month = 5;
	
	// ������ �� data�� ���ԵǾ��ִ� LocalDate �ڷ��� ����
	private LocalDate defalutDate = LocalDate.of(year, month, 1);
	
	private String center = Integer.toString(year) + "-" + Integer.toString(month);
	private JLabel yearAndMonth = new JLabel(center);
	
	// ������ DayScheduleGUI ��ü�� �迭�� ������ �� �ֵ��� ��
	private DayScheduleGUI[] DayScheduleGUIObject = new DayScheduleGUI[1];
	
 	// Constructor
	public SchedulePlannerGUI() {
		
		// SchedulePlannerGUI JFrame
		super("Schedule Planner");
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ��� �г�(panel1) ����
		panel1.setPreferredSize(new Dimension(400,30));
		panel1.setLayout(new BorderLayout(5,5)); // BorderLayout
	    
		// ���� ������ �� ǥ�� JLabel
		yearAndMonth.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(yearAndMonth, BorderLayout.CENTER);
		
		// ���� �� �̵� JButton
		panel1.add(left = new JButton("<"), BorderLayout.WEST);
		left.addActionListener(this);
		
		// ���� �� �̵� JButton
		panel1.add(right = new JButton(">"), BorderLayout.EAST);
		right.addActionListener(this);
		
		// ���� ������ ���� �г�(panel2) ����
		panel2.setPreferredSize(new Dimension(400,30));
		panel2.setLayout(new GridLayout(1,7)); // 1�� 7�� Grid Layout
		
		// �Ͽ��� JLabel
		JLabel sun = new JLabel("SUN");
		sun.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(sun);
		
		// ������ JLabel
		JLabel mon = new JLabel("MON");
		mon.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(mon);
		
		// ȭ���� JLabel
		JLabel tue = new JLabel("TUE");
		tue.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(tue);
		
		// ������ JLabel
		JLabel wed = new JLabel("WED");
		wed.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(wed);
		
		// ����� JLabel
		JLabel thr = new JLabel("THR");
		thr.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(thr);
		
		// �ݿ��� JLabel
		JLabel fri = new JLabel("FRI");
		fri.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(fri);
		
		// ����� JLabel
		JLabel sat = new JLabel("SAT");
		sat.setHorizontalAlignment(JLabel.CENTER);
		panel2.add(sat);
		
		// drawCalendar �޼ҵ带 ���� �޷� �ڵ� ��� �� Panel Add
		drawCalendar(this.year, this.month);
		
		// �� �� ���� �г��� ��Ұ� �Ǵ� �г�(panel4) ����
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		panel4.add(panel3, BorderLayout.SOUTH);

		// Frame�� Panel ǥ�� �� Pack
		this.add(panel4);
		this.pack();
		this.setVisible(true);
		}
	
	// ���� ��¥�� �� ���� ������ ����ϰ� �̿� ���� Panel�� �����ϴ� �޼ҵ�
	private void drawCalendar(int y,int  m) {
		
		// �Ķ���͸� ���� ����� ������ �� ������ ����
		y = this.year;
		m = this.month;
		
		// �Ķ���͸� ���� ���� ���� defaultDate�� ����
		this.defalutDate = LocalDate.of(y,m,1);
		
		// ��¥(Day)�� ���� Panel ����
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(400,200));
		panel3.setLayout(new GridLayout(0,7,2,2)); // 7���� Grid, ���� �ڵ����� ����
		
		/** -----��¥ �κ� ���� ���� �߰�----- */
	    // �ش� ���� ù ���� �Ͽ����� ���
	    if (defalutDate.getDayOfWeek().getValue() == 7) {
			;
	    }
	    // �ش� ���� ù ���� ������~������� ���
	    else {
	    	for (int i=0; i<defalutDate.getDayOfWeek().getValue(); i++) {
	    		panel3.add(new JLabel(""));
	    	}
	    }
		
		// �ش� ���� ��¥���� �޾� Grid�� ���� JButton �߰�
		for (int i = 1; i <= defalutDate.lengthOfMonth(); i++) {
			JButton days = new JButton(Integer.toString(i));
			panel3.add(days);
			LocalDate dayDate = LocalDate.of(this.year, this.month, i);
			
			// ��¥ ��ư�� ������ ���� Action �߰�
			days.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// DayScheduleGUI�� �ϳ��� ��ü�� �����ǵ��� �����Ѵ�. (�ߺ� â �ߴ� ���� ����)
					if (DayScheduleGUIObject[0]!=null) {
						DayScheduleGUIObject[0].dispose();
						DayScheduleGUIObject[0]=null;
					}
					DayScheduleGUIObject[0] = new DayScheduleGUI(dayDate.getYear(),dayDate.getMonthValue(),dayDate.getDayOfMonth());
				}
			});
		}
		
		// ������ Grid�� �������� ä���� (Column ���� ����)
		int count = 7-((defalutDate.getDayOfWeek().getValue()+defalutDate.lengthOfMonth())%7);
		if (count != 7) {
			for (int i=0; i < count; i++) {
	    		panel3.add(new JLabel(""));
	    	}
		}
	}
	
	// Action�� �����ϴ� �޼ҵ�
	public void actionPerformed(ActionEvent buttons) {
		
		// "<" ��ư Ŭ�� ��
		if(buttons.getSource() == this.left) {
			// 1���̶�� ����--, 12������
			if (month==1) {
				year--;
				month=12;
			}
			else month--; // �ƴ϶�� ��--
			yearAndMonth.setText(Integer.toString(year) + "-" + Integer.toString(month));
			
			panel4.remove(panel3);
			drawCalendar(this.month, this.year);
			panel4.add(panel3, BorderLayout.SOUTH);
		}
		
		// ">" ��ư Ŭ�� ��
		else if(buttons.getSource() == this.right) {
			// 12���̶�� ����++, 1�� ����
			if (this.month==12) {
				this.year++;
				this.month=1;
			}
			
			else this.month++; // �ƴ϶�� ��++
			yearAndMonth.setText(Integer.toString(this.year) + "-" + Integer.toString(this.month));
			
			panel4.remove(panel3);
			drawCalendar(this.month, this.year);
			panel4.add(panel3, BorderLayout.SOUTH);
		}
	}
}
	

