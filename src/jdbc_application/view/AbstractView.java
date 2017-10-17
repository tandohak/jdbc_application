package jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_application.list.AbstractList;
import jdbc_application.list.ListDepartment;
import jdbc_application.content.AbstractContent;
import jdbc_application.content.DepartmentContent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancle;
	protected AbstractContent<?> pContent;
	protected AbstractList pList;
	
	public AbstractView(String title) {
		setTitle(title);
		
		createService();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("추가");
		pBtn.add(btnOk);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(this);
		pBtn.add(btnCancle);
		
		pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}

	protected void createService() {}

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancle) {
			btnCancleActionPerformed(e);
		}
	}
	protected  void btnCancleActionPerformed(ActionEvent e){
		pContent.clear();		
	};
}
