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
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class EmployeeContent extends AbstractContent<Employee> implements ActionListener {

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
		pSalary.getSpinner().setModel(new SpinnerNumberModel(new Integer(1500000), new Integer(1500000), null, new Integer(100000)));
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
		Employee boss = new Employee(4377,"이성래");
		
		if(!item.equals(boss)){
			item.add(boss);
		}
		
		pManager.setComboBoxModel(item);
	}


	private void addItemTitle() {
		List<Title> lists = service.selectTitleByAll();

		Vector<Title> item = new Vector<>(lists);

		pTitle.setComboBoxModel(item);

	}
	
	@Override
	public Employee getContent() {
		int empno = Integer.parseInt(pEmpNo.getTextValue());
		String empname = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
		int salary = pSalary.getSpinerValue();
		Department dno = pDno.getSelectedItem();

		return new Employee(empno, empname, title, manager, salary, dno);
	}
	@Override
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pDno.getComboBox()) {
			addItemManager();
		}
	}

	@Override
	public void setContent(Employee content) {
		pEmpNo.setTextValue(content.getEmpno()+"");
		pEmpName.setTextValue(content.getEmpname());
		pDno.setSelectedItem(content.getDno());
		pManager.setSelectedItem(content.getManager());
		pSalary.setSpinValue(content.getSalary());
		pTitle.setSelectedItem(content.getTitle());
		
	}

	@Override
	public void clear() {
		pEmpNo.setTextValue("");
		pEmpName.setTextValue("");
		pDno.setSelectedIndex(0);
		pManager.setSelectedIndex(0);
		pSalary.setSpinValue(1500000);
		pTitle.setSelectedIndex(0);		
	}


	@Override
	public void setEnabled(boolean isOk) {
		if(!isOk){
			pEmpNo.getTextField().setEnabled(false);
			pEmpName.getTextField().setEnabled(false);
			pDno.getComboBox().setEnabled(false);
			pManager.getComboBox().setEnabled(false);
			pSalary.getSpinner().setEnabled(false);
			pTitle.getComboBox().setEnabled(false);
			
			return;
		}
		
		pEmpNo.getTextField().setEnabled(true);
		pEmpName.getTextField().setEnabled(true);
		pDno.getComboBox().setEnabled(true);
		pManager.getComboBox().setEnabled(true);
		pSalary.getSpinner().setEnabled(true);
		pTitle.getComboBox().setEnabled(true);		
	}
	
	@Override
	public void changeContent(Object content) {
		setContent((Employee)content);
		pEmpNo.getTextField().setEnabled(false);
	}
	
}
