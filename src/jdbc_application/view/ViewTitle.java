package jdbc_application.view;

import jdbc_application.content.AbstractContent;
import jdbc_application.content.TitleContent;
import jdbc_application.jdbc.dto.Title;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListTitle;
import jdbc_application.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService ts;
	
	public ViewTitle(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		
		pList = new ListTitle(ts);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return (AbstractContent<Title>) pContent;
	}
	
	protected void createService() {
		ts = new TitleService();
	}

}
