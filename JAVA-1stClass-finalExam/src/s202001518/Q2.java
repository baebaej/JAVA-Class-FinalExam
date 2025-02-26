package s202001518;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Q2 extends JFrame {
	JTextField f1, f2;
	 JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100,0);
	 JSlider slider2 = new JSlider(JSlider.HORIZONTAL, 0, 100,0);
	 JTextField sum, avg;
	 JButton btn1, btn2, btn3;
	public Q2() {
		  setTitle("성적 계산");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  Container c = getContentPane();
		  c.setLayout(new FlowLayout());
		  
		  c.add(new JLabel("수학"));
		  f1 = new JTextField(5);
		  f1.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   slider1.setValue(Integer.valueOf(f1.getText()));
			   }
		});
		  c.add(f1);
		  slider1.setPaintLabels(true);
		  slider1.setPaintTicks(true);
		  slider1.setPaintTrack(true);
		  slider1.setMajorTickSpacing(50);
		  slider1.setMinorTickSpacing(10);
		  slider1.addChangeListener(new MyChangeListener1());
		  c.add(slider1);
		  

		  c.add(new JLabel("과학"));
		  f2 = new JTextField(5);
		  f2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   slider2.setValue(Integer.valueOf(f2.getText()));
			   }
		});
		  c.add(f2);
		  slider2.setPaintLabels(true);
		  slider2.setPaintTicks(true);
		  slider2.setPaintTrack(true);
		  slider2.setMajorTickSpacing(50);
		  slider2.setMinorTickSpacing(10);
		  slider2.addChangeListener(new MyChangeListener2());
		  c.add(slider2);
		  
		  c.add(new JLabel("합계:"));
		  sum = new JTextField(10);
		  sum.setEditable(false);
		  c.add(sum);
		  
		  c.add(new JLabel("평균:"));
		  avg = new JTextField(10);
		  avg.setEditable(false);
		  c.add(avg);
		  
		  
		  btn1 = new JButton("계산");
		  btn1.addActionListener(new MyActionListener1());
		  btn2 = new JButton("초기화");
		  btn2.addActionListener(new MyActionListener2());
		  btn3 = new JButton("종료");
		  btn3.addActionListener(new MyActionListener3());
		  
		  c.add(btn1);
		  c.add(btn2);
		  c.add(btn3);
		  
		  
		  
		  setSize(330,220);
		  setVisible(true);
	}
	public static void main(String[] args) {
		new Q2();

	}
	
	//슬라이더 관련 액션리스너
	class MyChangeListener1 implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			int n = slider1.getValue();
			f1.setText(String.valueOf(n));
		}
	}
	class MyChangeListener2 implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			int n = slider2.getValue();
			f2.setText(String.valueOf(n));
		}
	}
	
	//버튼관련 액션리스너
	 class MyActionListener1 implements ActionListener { 
		 public void actionPerformed(ActionEvent e) {
			 if(f1.getText().length()==0 || f2.getText().length()==0) {
				 System.out.println("값을 입력하세요!!");
				 return;
			 }
			 int total = Integer.valueOf(f1.getText()) + Integer.valueOf(f2.getText());
			 sum.setText(String.valueOf(total));
			 double average = (double)total/2;
			 String result = String.format("%.2f", average);
			 avg.setText(result);
		 }
	}
	 class MyActionListener2 implements ActionListener { 
		 public void actionPerformed(ActionEvent e) {
			 slider1.setValue(0);
			 slider2.setValue(0);
			 f1.setText("");
			 f2.setText("");

			 sum.setText("");
			 avg.setText("");
		 }
	}
	 class MyActionListener3 implements ActionListener { 
		 public void actionPerformed(ActionEvent e) {
			 setVisible(false);
		 }
	}

}
