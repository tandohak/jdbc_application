package jdbc_application.list;

import javax.swing.SwingConstants;

import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;

public class ListEmployee extends AbstractList {

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
		Object[][] data = {
				{1,"이성래","사장",2,4000000,"1"},
				{1,"이성래","사장",2,4000000,"1"},
				{1,"이성래","사장",2,4000000,"1"}				
		};
		return data;
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex =table.getSelectedRow();
		int empNo = (int)table.getValueAt(seletedIndex, 0);
		String empName =(String)table.getValueAt(seletedIndex, 1);
		Title title = new Title((int)table.getValueAt(seletedIndex, 2));
		Employee manager = new Employee((int)table.getValueAt(seletedIndex, 3));
		int salary = (int)table.getValueAt(seletedIndex, 4);
		Department dno = new Department((int)table.getValueAt(seletedIndex, 5));
		
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}
