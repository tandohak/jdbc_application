package jdbc_application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_application.view.AbstractView;
import jdbc_application.view.ViewDepartment;
import jdbc_application.view.ViewEmployee;
import jdbc_application.view.ViewTitle;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDepartment;
	private JButton btnEmployee;
	private AbstractView empFr;
	private AbstractView deptFr;
	private AbstractView titleFr;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ErpApplication() {
		setTitle("회사 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
		
		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
	}
	protected void btnTitleActionPerformed(ActionEvent e) {
		if(titleFr == null){
			titleFr = new ViewTitle("직책 관리");
		}
		
		titleFr.setVisible(true);
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		if(deptFr == null){
			deptFr = new ViewDepartment("부서 관리");
		}
		
		deptFr.setVisible(true);
	}
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		if(empFr == null){
			empFr = new ViewEmployee("직원 관리");
		}
		
		empFr.setVisible(true);
	}
}
