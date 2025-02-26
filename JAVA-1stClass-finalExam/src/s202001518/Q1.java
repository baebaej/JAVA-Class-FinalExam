package s202001518;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Q1 extends JFrame {
	private MyPanel panel = new MyPanel();
	 JButton btn1, btn2;
	public Q1(){
		setTitle("도형 회전");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setContentPane(panel);
		  
		  Container c = getContentPane();
		  c.setLayout(new FlowLayout());
		  btn1 = new JButton("시계방향");
		  btn1.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   panel.startAngle-=10;

				   panel.c = Color.BLUE;
				   panel.repaintComponent(getGraphics());
			   }
		});
		  c.add(btn1);
		  btn2 = new JButton("시계반대방향");
		  btn2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   panel.startAngle+=10;
				   panel.c = Color.RED;
				   panel.repaintComponent(getGraphics());
			   }
		});
		  c.add(btn2);
		 
		  
		  setSize(350, 350);
		  setVisible(true); 
		  

	}
	class MyPanel extends JPanel{
		int startAngle = 90;
		int arcAngle = 270;
		Color c = Color.BLACK;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(c);
			int x = getSize().width/2 -40;
			int y = getSize().height/2 -40;
			g.fillArc(x, y, 80, 80, startAngle, arcAngle);
			
		}
		
		public void repaintComponent(Graphics g) {
			//System.out.println("startangle:"+startAngle+"arcAngle:"+arcAngle);
			g.setColor(c);
			int x = getSize().width/2 -40;
			int y = getSize().height/2 -40;
			g.fillArc(x, y, 80, 80, startAngle, arcAngle);
			
			getParent().repaint();
		}
		
	}
	

	public static void main(String[] args) {
		new Q1();
	}
}



