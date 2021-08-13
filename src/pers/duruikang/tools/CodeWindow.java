package pers.duruikang.tools;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CodeWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1869492270618653938L;
	private JTextField textField;
	private JTextField textField_1;
	public CodeWindow(String name) {
		super(name);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 59, 121, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTxt = new JLabel("txt文件地址");
		lblTxt.setBounds(97, 62, 99, 21);
		getContentPane().add(lblTxt);
		
		JLabel label = new JLabel("输出图片地址");
		label.setBounds(88, 104, 114, 21);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 101, 121, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("运行加密！");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("".equals(textField.getText())||"".equals(textField_1.getText())||textField.getText()==null||textField_1.getText()==null) {
					JOptionPane.showMessageDialog(null, "路径不对", null,JOptionPane.ERROR_MESSAGE);
				}
				try {
					new TXTtoJPG().Do(textField.getText(), textField_1.getText());
					JOptionPane.showMessageDialog(null, "成功！！", null,JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
			}
		});
		button.setBounds(152, 140, 123, 29);
		getContentPane().add(button);
		this.setVisible(true);
		this.setSize(432,255);
		this.setLocation(700,300);
	}
}
