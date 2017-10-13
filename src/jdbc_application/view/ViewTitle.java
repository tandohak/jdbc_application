package jdbc_application.view;

import javax.swing.JPanel;

import jdbc_application.content.TitleContent;
import jdbc_application.list.AbstractList;
import jdbc_application.list.ListTitle;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {

	public ViewTitle(String title){
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}
