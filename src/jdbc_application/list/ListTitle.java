package jdbc_application.list;

import javax.swing.SwingConstants;

import jdbc_application.jdbc.dto.Title;

public class ListTitle extends AbstractList {

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
		Object[][] data = {{1,"사장"},{2,"부장"}};
		return data;
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex =table.getSelectedRow();
		int titleNo = (int)table.getValueAt(seletedIndex, 0);
		String titleName =(String)table.getValueAt(seletedIndex, 1);
		
		return new Title(titleNo, titleName);
	}

}
