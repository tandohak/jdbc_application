package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.EmployeeContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListEmployee;
import jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService es;
	public ViewEmployee(String title){
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent(es);
		return pContent;
	}
	@Override
	protected void createService() {
		es = new EmployeeService();
	}

}
