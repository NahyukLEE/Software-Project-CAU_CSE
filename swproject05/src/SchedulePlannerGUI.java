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

	// ������Ʈ5���� 2020�� 5���� ȭ���� �����ֱ� ���� ��� ����
	int year = 2020;
	int month = 5;
	
	SchedulePlannerGUI() {
		
		/** SchedulePlannerGUI JFrame */
		super("Schedule Planner");
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������ �� data�� ���ԵǾ��ִ� LocalDate �ڷ��� ����
		LocalDate defalutDate = LocalDate.of(year, month, 1); // ������Ʈ6���� �������� ����
		// ������Ʈ5������ 2020�� 5���� ȭ���� ����Ѵ�.
		
		
		/** ��� �г�(panel1) ���� */
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(400,30));
		panel1.setLayout(new BorderLayout(5,5)); // BorderLayout
	    
		// ���� �� �̵� JButton
		JButton left = new JButton("<");
		panel1.add(left, BorderLayout.WEST);
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("<�� Ŭ���Ǿ����ϴ�.");
				// ���� �޷� �̵��ϴ� ���� ������Ʈ6���� �۾�
			}
		});
		
		// ���� �� �̵� JButton
		JButton right = new JButton(">");
		panel1.add(right, BorderLayout.EAST);
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">�� Ŭ���Ǿ����ϴ�.");
				// ���� �޷� �̵��ϴ� ���� ������Ʈ6���� �۾�
			}
		});
		
		// ���� ������ �� ǥ�� JLabel
		String center = Integer.toString(year) + "-" + Integer.toString(month);
		JLabel yearAndMonth = new JLabel(center);
		yearAndMonth.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(yearAndMonth, BorderLayout.CENTER);


		/** ���� ������ ���� �г�(panel2) ���� */
		JPanel panel2 = new JPanel();
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
		
		
		/** ��¥(Day)�� ���� �г�(panel3) ���� */
		JPanel panel3 = new JPanel();
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
		
	    
		/** -----�ش� ���� ��¥���� �޾� Grid�� ���� JButton �߰�----- */
		for (int i = 1; i <= defalutDate.lengthOfMonth(); i++) {
			JButton days = new JButton(Integer.toString(i));
			panel3.add(days);
			days.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Day Schedule�� �����մϴ�.");
					// ������Ʈ6���� ���� ��¥�� DayScheduleGUI ��ü�� ���� GUI�� ������ ����
				}
			});
		}
		
		
		/** �� �� ���� �г��� ��Ұ� �Ǵ� �г�(panel4) ���� */
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

