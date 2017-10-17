package jdbc_application.view;

import jdbc_application.content.AbstractContent;
import jdbc_application.content.EmployeeContent;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;
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
		pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(es);
		return (AbstractContent<Employee>) pContent;
	}
	@Override
	protected void createService() {
		es = new EmployeeService();
	}

	@Override
	protected void InsertContentAction(Object content) {
		es.insertEmployee((Employee)content);		
	}

	@Override
	protected void deleteContent(Object item) {
		es.deleteContent((Employee)item);
	}

	@Override
	protected void updateContent(Object item) {
		es.updateEmployee((Employee)item);
	}

}
