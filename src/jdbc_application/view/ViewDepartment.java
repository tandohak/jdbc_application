package jdbc_application.view;

import jdbc_application.content.AbstractContent;
import jdbc_application.content.DepartmentContent;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Title;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListDepartment;
import jdbc_application.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService ds;

	
	public ViewDepartment(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		pList = new ListDepartment(ds);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}
	
	@Override
	protected void createService() {
		ds = new DepartmentService();
	}

	@Override
	protected void InsertContentAction(Object content) {
		ds.insertDepartment((Department)content);
		
	}

	@Override
	protected void deleteContent(Object item) {
		ds.deleteContent((Department)item);
		
	}

	@Override
	protected void updateContent(Object item) {
		ds.updateDepartment((Department)item);
	}

	


}
