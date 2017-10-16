package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.TitleContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListTitle;
import jdbc_application.service.EmployeeService;
import jdbc_application.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService ts;
	
	public ViewTitle(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		
		ListTitle pList = new ListTitle(ts);
		pList.loadData();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}
	
	protected void createService() {
		ts = new TitleService();
	}
}
