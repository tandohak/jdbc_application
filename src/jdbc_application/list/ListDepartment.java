package jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.service.DepartmentService;

@SuppressWarnings("serial")
public class ListDepartment extends AbstractList {
	private DepartmentService service;	
	
	public ListDepartment(DepartmentService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 150, 50);
		setAlign(SwingConstants.CENTER, 0, 2);
		setAlign(SwingConstants.RIGHT, 1);
	}

	
	@Override
	protected String[] getColumnNames() {
		return new String[]{"부서번호","부서명","위치"};
	}
	
	@Override
	protected Object[][] getData() {
		List<Department> lists = service.selectDepartmentListAll();
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0; i<lists.size(); i++){
			datas[i] = lists.get(i).toArray();
		}
		
		return datas;		
	}


	@Override
	public Object getSelectedItem() {
		int seletedIndex =table.getSelectedRow();
		int deptNo = (int)table.getValueAt(seletedIndex, 0);
		String deptName =(String)table.getValueAt(seletedIndex, 1);
		int floor = (int)table.getValueAt(seletedIndex, 2);
		
		return new Department(deptNo, deptName, floor);
	}
	
	@Override
	public Department getSearchItem(int itemNo) {
		return service.selectDepartmentByNo(new Department(itemNo));
	}
}
