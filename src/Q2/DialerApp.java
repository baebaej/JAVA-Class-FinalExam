package Q2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialerApp extends JFrame {
    JTextField tf = new JTextField(20);

    public DialerApp() {
        setTitle("전화 걸기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메인 컨테이너에 BorderLayout 설정
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // JTextField를 NORTH에 추가
        tf.setEditable(false);
        c.add(tf, BorderLayout.NORTH);

        // 버튼들을 위한 패널 생성 및 GridLayout 설정
        var buttonPanel = new Container();
        buttonPanel.setLayout(new GridLayout(5, 3, 0, 0));
       

     // 버튼 생성 및 추가
        var b1 = new JButton("1");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "1");
            }
        });
        buttonPanel.add(b1);

        var b2 = new JButton("2");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "2");
            }
        });
        buttonPanel.add(b2);

        var b3 = new JButton("3");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "3");
            }
        });
        buttonPanel.add(b3);

        var b4 = new JButton("4");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "4");
            }
        });
        buttonPanel.add(b4);

        var b5 = new JButton("5");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "5");
            }
        });
        buttonPanel.add(b5);

        var b6 = new JButton("6");
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "6");
            }
        });
        buttonPanel.add(b6);

        var b7 = new JButton("7");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "7");
            }
        });
        buttonPanel.add(b7);

        var b8 = new JButton("8");
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "8");
            }
        });
        buttonPanel.add(b8);

        var b9 = new JButton("9");
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "9");
            }
        });
        buttonPanel.add(b9);

        var b10 = new JButton("*");
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "*");
            }
        });
        buttonPanel.add(b10);

        var b11 = new JButton("0");
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "0");
            }
        });
        buttonPanel.add(b11);

        var b12 = new JButton("#");
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + "#");
            }
        });
        buttonPanel.add(b12);

        var b13 = new JButton("종료");
        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 종료 버튼 클릭 시 종료 코드 작성
                setVisible(false);
            }
        });
        buttonPanel.add(b13);

        var b14 = new JButton("통화");
        b14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 통화 버튼 클릭 시 통화 코드 작성
            	var inputStr = tf.getText();
            	if(inputStr.indexOf("*")>=0 || inputStr.indexOf("#")>=0)
            		JOptionPane.showMessageDialog(null, "숫자만 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
            	else {
            		var resStr = "";
            		for(int i=0;i<inputStr.length();i++) {
            			if(inputStr.length() == 10) {
                			if(i == 3 || i == 6) {
                				resStr=resStr+"-";

                			}
            			}else if(inputStr.length() == 11){
                			if(i == 3 || i == 7) {
                				resStr=resStr+"-";

                			}
            			}
            				resStr=resStr+inputStr.charAt(i);
            		}
            		JOptionPane.showMessageDialog(null, resStr, "통화 중", JOptionPane.INFORMATION_MESSAGE);
            	}
            }
        });
        buttonPanel.add(b14);

        var b15 = new JButton("지우기");
        b15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
            }
        });
        buttonPanel.add(b15);


        // 버튼 패널을 CENTER에 추가
        c.add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DialerApp();
    }
}
