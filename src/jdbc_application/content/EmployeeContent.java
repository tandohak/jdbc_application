package jdbc_application.content;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import jdbc_application.common.ComboBoxComponent;
import jdbc_application.common.SpinnerComponent;
import jdbc_application.common.TextFiledComponent;
import jdbc_application.dao.DepartmentDao;
import jdbc_application.dao.EmployeeDao;
import jdbc_application.dao.TitleDao;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;

@SuppressWarnings("serial")
public class EmployeeContent extends JPanel {

	private TextFiledComponent pEmpNo;
	private TextFiledComponent pEmpName;
	private ComboBoxComponent<Title> pTitle;
	private ComboBoxComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboBoxComponent<Department> pDno;

	public EmployeeContent() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pEmpNo = new TextFiledComponent("사원번호");
		add(pEmpNo);
		
		pEmpName = new TextFiledComponent("사원명");
		add(pEmpName);
		
		
		pTitle = new ComboBoxComponent<Title>("직책");
		add(pTitle);
		
		pManager = new ComboBoxComponent<Employee>("직속상사");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		add(pSalary);
		
		pDno = new ComboBoxComponent<Department>("부서번호");
		add(pDno);
		
		addItemDno();
		addItemManager();
		addItemTitle();				
		
		
	}
	
	private void addItemDno() {
		try {					
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			Vector<Department> item = new Vector<>();
			for(Department t : lists){
				item.add(t);
			}
			pDno.setComboBoxModel(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addItemManager() {
		try {					
			List<Employee> lists = EmployeeDao.getInstance().selectItemByAll();
			Vector<Employee> item = new Vector<>();
			for(Employee t : lists){
				item.add(t);
			}
			pManager.setComboBoxModel(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addItemTitle() {
		try {					
			List<Title> lists = TitleDao.getInstance().selectItemByAll();
			Vector<Title> item = new Vector<>();
			for(Title t : lists){
				item.add(t);
			}
			pTitle.setComboBoxModel(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee getContent(){
		int empno = Integer.parseInt(pEmpNo.getTextValue());
		String empname = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
		int salary = pSalary.getSpinerValue();
		Department dno =pDno.getSelectedItem();
		
		return 	new Employee(empno, empname, title, manager, salary, dno);
	}

	public void isEmptyCheck() throws Exception {
			pEmpNo.isEmptyCheck();
			pEmpName.isEmptyCheck();
			pSalary.isEmptyCheck();		
	}

	
	
}
