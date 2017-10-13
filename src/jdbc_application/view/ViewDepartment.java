package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.DepartmentContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListDepartment;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {

	public ViewDepartment(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

}
