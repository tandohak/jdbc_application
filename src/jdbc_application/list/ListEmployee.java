package jdbc_application.list;

import java.util.List;


import javax.swing.SwingConstants;

import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;
import jdbc_application.service.EmployeeService;

public class ListEmployee extends AbstractList {
	private EmployeeService service;
	
	
	public ListEmployee(EmployeeService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,150,100,100,150,100);
		setAlign(SwingConstants.CENTER, 0,1,2,3,5);
		setAlign(SwingConstants.RIGHT, 4);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"사원번호","사원명","직급","관리자","급여","부서번호"};
	}

	@Override
	protected Object[][] getData() {
		List<Employee> lists = service.selectEmployeeByAll();
		Object[][] data = new Object[lists.size()][];
				
		for(int i=0; i<lists.size(); i++){
			Employee emp = lists.get(i);
			data[i] = emp.toArray();
			data[i][2] = getTitle(emp.getTitle());
			data[i][3] = getManager(emp.getManager());
			data[i][4] = String.format("%,d",data[i][4]);
			data[i][5] = getDno(emp.getDno());
		}
				
		return data;
	}

	private Object getDno(Department dno) {
		return service.selectDepartmentByNo(dno).getDeptName();
	}

	private Object getManager(Employee manager) {
		Employee emp = (Employee) service.selectEmployeeByNo(manager);
		
		if(emp == null){
			return String.format("%S", "");
		}
		
		return String.format("%s(%d)",emp.getEmpname(),emp.getEmpno());
	}

	private Object getTitle(Title title) {
		return service.selectTitleByNo(title).getTitleName();
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectEmployeeByNo(new Employee(empNo));
	}

}
