package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JLabel clockLavel;
	
	public DigitalClockApp(String title) {
		super(title);
		
		clockLavel=new JLabel("2023년 04월 24일 15시 44분 22초", JLabel.CENTER);
		clockLavel.setFont(new Font("굴림체", Font.BOLD, 30));
		clockLavel.setForeground(Color.DARK_GRAY);
		
		getContentPane().add(clockLavel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,600,200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}
	
}
