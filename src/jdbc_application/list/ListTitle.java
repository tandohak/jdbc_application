package jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import jdbc_application.jdbc.dto.Title;
import jdbc_application.service.TitleService;

public class ListTitle extends AbstractList {
	private TitleService service;
	
	public ListTitle(TitleService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 150);
		setAlign(SwingConstants.CENTER, 0, 1);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"직책 번호","직책 명"};
	}

	@Override
	protected Object[][] getData() {
		List<Title> lists = service.selectTitleByAll();
		Object[][] data = new Object[lists.size()][];
		
		for(int i=0; i<lists.size(); i++){
			data[i] = lists.get(i).toArray();
		}
		
		return data;
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex =table.getSelectedRow();
		int titleNo = (int)table.getValueAt(seletedIndex, 0);
		String titleName =(String)table.getValueAt(seletedIndex, 1);
		
		return new Title(titleNo, titleName);
	}

	@Override
	public Title getSearchItem(int itemNo) {
		return service.selectTitleByNo(new Title(itemNo));
	}

}
