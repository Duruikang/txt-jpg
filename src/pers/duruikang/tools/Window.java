package pers.duruikang.tools;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4297354475616642737L;

	public Window(String name) {
		super(name);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("加密");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CodeWindow("加密程序");
			}
		});
		btnNewButton.setBounds(78, 85, 123, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("解密");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DecodeWindow("解密程序");
			}
		});
		btnNewButton_1.setBounds(224, 85, 123, 29);
		getContentPane().add(btnNewButton_1);
		this.setVisible(true);
		this.setSize(440, 286);
		this.setLocation(700,300);
	}
}
