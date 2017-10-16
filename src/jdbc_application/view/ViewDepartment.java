package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.DepartmentContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListDepartment;
import jdbc_application.service.DepartmentService;
import jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService ds;
	public ViewDepartment(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment(ds);
		pList.loadData();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}
	
	@Override
	protected void createService() {
		ds = new DepartmentService();
	}


}
