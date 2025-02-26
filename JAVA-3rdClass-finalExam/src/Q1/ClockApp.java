package Q1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread{
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	public void run() { //run 메소드를 스레드 코드라고 부름. 여기서 스레드 실행이 시작된다.
		while(true) {
			var d = new Date();
			var h = Integer.toString(d.getHours());
			var m = Integer.toString(d.getMinutes());
			var s = d.getSeconds();
			String result = String.format("%02d", s);
			timerLabel.setText(h+":"+m+":"+result);
		}
	}
}

public class ClockApp extends JFrame {
	public ClockApp() {
		setTitle("시계");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setForeground(Color.MAGENTA);
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel); //스레드 객체 생성
		
		setSize(400,170);
		setVisible(true);
		
		th.start();  //스레드 시작
		
		
	}

	public static void main(String[] args) {
		new ClockApp();

	}

}
