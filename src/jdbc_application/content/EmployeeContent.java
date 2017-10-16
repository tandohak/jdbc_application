package jdbc_application.content;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import jdbc_application.common.ComboBoxComponent;
import jdbc_application.common.SpinnerComponent;
import jdbc_application.common.TextFiledComponent;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;
import jdbc_application.service.EmployeeService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmployeeContent extends JPanel implements ActionListener {

	private TextFiledComponent pEmpNo;
	private TextFiledComponent pEmpName;
	private ComboBoxComponent<Title> pTitle;
	private ComboBoxComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboBoxComponent<Department> pDno;
	private EmployeeService service;

	public EmployeeContent(EmployeeService service) {
		this.service = service;
		setLayout(new GridLayout(0, 1, 0, 0));

		pEmpNo = new TextFiledComponent("사원번호");
		add(pEmpNo);

		pEmpName = new TextFiledComponent("사원명");
		add(pEmpName);
		
		pDno = new ComboBoxComponent<Department>("부서번호");
		pDno.getComboBox().addActionListener(this);
		add(pDno);
		

		pManager = new ComboBoxComponent<Employee>("직속상사");
		add(pManager);

		pSalary = new SpinnerComponent("급여");
		add(pSalary);
		
		pTitle = new ComboBoxComponent<Title>("직책");
		add(pTitle);
		

		addItemDno();
		addItemManager();
		addItemTitle();

	}

	private void addItemDno() {
		List<Department> lists = service.selectDepartmentListAll();
		Vector<Department> item = new Vector<>(lists);
		
		pDno.setComboBoxModel(item);

	}

	private void addItemManager() {
		List<Employee> lists = service.selectEmployeeByDno(pDno.getSelectedItem());
		Vector<Employee> item = new Vector<>(lists);
		
		pManager.setComboBoxModel(item);
	}

	private void addItemTitle() {
		List<Title> lists = service.selectTitleByAll();

		Vector<Title> item = new Vector<>(lists);

		pTitle.setComboBoxModel(item);

	}

	public Employee getContent() {
		int empno = Integer.parseInt(pEmpNo.getTextValue());
		String empname = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
		int salary = pSalary.getSpinerValue();
		Department dno = pDno.getSelectedItem();

		return new Employee(empno, empname, title, manager, salary, dno);
	}

	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pSalary.isEmptyCheck();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pDno.getComboBox()) {
		
			addItemManager();
		}
	}
	
}
