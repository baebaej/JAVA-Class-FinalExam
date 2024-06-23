package Q1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImgSizeApp extends JFrame {
	private MyPanel panel = new MyPanel();
	int initValue = 50;
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, initValue);
	double initWidth, initHeight;
	public ImgSizeApp(){
		setTitle("그림 확대 축소");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		slider.addChangeListener(new MyChangeListener());
		
		c.add(slider);
		
		setSize(300,500);
		setVisible(true);
		
		
	}
	
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			int size = slider.getValue();
			if(size%10 == 0)
				panel.repaintComponent(getGraphics(), size);
		}
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/img.jpg");
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			initWidth=getWidth()*(initValue/100.0)-10;
			initHeight=getHeight()*(initValue/100.0)-100;
			g.drawImage(img, 10, 100, (int)initWidth, (int)initHeight, this);
		}
		
		public void repaintComponent(Graphics g, int size) {
			super.paintComponent(g);
			size=size*2;			
			g.drawImage(img, 10, 100, (int)(initWidth*(size/100.0)), (int)(initHeight*(size/100.0)), this);
		}
		
	}

	public static void main(String[] args) {
		new ImgSizeApp();
	}

}
