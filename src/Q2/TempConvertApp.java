package Q2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TempConvertApp extends JFrame {
	JTextField input_tf = new JTextField(20);
	JTextField output_tf = new JTextField(20);
	JTextArea res_ta = new JTextArea(7,20);
	
	int mode = 1;  //기본값: 섭씨->화씨
	public TempConvertApp() {
		setTitle("온도 변환");
		createMenu();	//메뉴바 생성
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("입력"));
		input_tf.addActionListener(new MyActionListener1());
		c.add(input_tf);
		
		c.add(new JLabel("출력"));
		output_tf.setEditable(false);
		c.add(output_tf);
		
		c.add(new JLabel("결과"));
		c.add(new JScrollPane(res_ta));
		
		JButton btn1 = new JButton("변환");
		btn1.addActionListener(new MyActionListener1());
		JButton btn2 = new JButton("초기화");
		btn2.addActionListener(new MyActionListener2());

		c.add(btn1);
		c.add(btn2);
		
		
		
		setSize(300,300);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("온도");
		
		var item1 = new JMenuItem("섭씨->화씨");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 1;
			}
		});
		screenMenu.add(item1);
		var item2 = new JMenuItem("화씨->섭씨");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 2;
			}
		});
		screenMenu.add(item2);
		screenMenu.addSeparator();	//분리선 삽입
		var item3 = new JMenuItem("종료");
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		screenMenu.add(item3);
		
		mb.add(screenMenu);
		
		setJMenuBar(mb);

	}
	
	class MyActionListener1 implements ActionListener{	//변환 버튼 액션리스너
		public void actionPerformed(ActionEvent e) {
			int inputValue = Integer.valueOf(input_tf.getText());
			double res=0.0;
			if(mode == 1) { //섭씨->화씨 모드인 경우
				res = (double)inputValue * (double)(9.0/5.0) + 32.0;
			}
			else if(mode ==2) { //화씨->섭씨 모드인 경우
				res = (double)(inputValue-32.0)*(double)(5.0/9.0);
			}
			String result = String.format("%.2f", res);
			output_tf.setText(result);
			if(mode == 1)
				res_ta.setText(res_ta.getText() +"섭씨 "+input_tf.getText()+"도 -> 화씨 "+ result +"도"+ "\n");
			else if(mode ==2)
				res_ta.setText(res_ta.getText() +"화씨 "+input_tf.getText()+"도 -> 섭씨 "+ result +"도"+ "\n");

			
		}
	}
	
	class MyActionListener2 implements ActionListener{	//초기화 버튼 액션리스너
		public void actionPerformed(ActionEvent e) {
			input_tf.setText("");
			output_tf.setText("");
			res_ta.setText("");
		}
	}

	public static void main(String[] args) {
		new TempConvertApp();

	}

}
