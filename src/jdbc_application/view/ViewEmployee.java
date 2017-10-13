package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.EmployeeContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListEmployee;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {

	public ViewEmployee(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent();
		return pContent;
	}

}
