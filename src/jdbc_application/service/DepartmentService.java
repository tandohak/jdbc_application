package jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application.dao.DepartmentDao;
import jdbc_application.dao.SqlDao;
import jdbc_application.jdbc.dto.Department;

public class DepartmentService {
	private SqlDao<Department> deptDao;

	public DepartmentService() {
		deptDao = DepartmentDao.getInstance();
	}
	
	public void insertDepartment(Department dept){
		try {
			deptDao.insertItem(dept);
			showMessage("추가완료");			
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void deleteDepartment(Department dept){
		try {
			deptDao.deleteItem(dept);
			showMessage("삭제 완료");		
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
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
	
	public List<Department> selectDepartmentListAll(){
		try {
			return deptDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null,msg);		
	}
}
