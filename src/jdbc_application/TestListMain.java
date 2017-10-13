package jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import jdbc_application.list.AbstractList;
import jdbc_application.list.ListDepartment;
import jdbc_application.list.ListEmployee;
import jdbc_application.list.ListTitle;

public class TestListMain {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		AbstractList ld = new ListEmployee();
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = ld.getSelectedItem();
				JOptionPane.showMessageDialog(null, obj);
			}
		});
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 200, 150);
		jf.add(ld);
		jf.add(btn,BorderLayout.SOUTH);	
		jf.setVisible(true);
	}
}
