package jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application.dao.DepartmentDao;
import jdbc_application.dao.EmployeeDao;
import jdbc_application.dao.SqlDao;
import jdbc_application.dao.TitleDao;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;

public class EmployeeService {
	private SqlDao<Employee> empDao;
	private SqlDao<Department> deptDao;
	private SqlDao<Title> titleDao;

	public EmployeeService() {
		empDao = EmployeeDao.getInstance();
		deptDao = DepartmentDao.getInstance();
		titleDao = TitleDao.getInstance();
	}

	public void insertEmployee(Employee emp) {
		try {
			empDao.insertItem(emp);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee emp) {
		try {
			empDao.updateItem(emp);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public Employee selectEmployeeByNo(Employee emp) {
		try {
			return empDao.selectItemByNo(emp);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectEmployeeByAll() {
		try {
			return empDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public List<Department> selectDepartmentListAll() {
		try {
			return deptDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public Department selectDepartmentByNo(Department dept){
		try {
			return deptDao.selectItemByNo(dept);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Title> selectTitleByAll() {

		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
