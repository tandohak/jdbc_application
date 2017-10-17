package jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import jdbc_application.common.TextFiledComponent;
import jdbc_application.jdbc.dto.Title;

public class TitleContent extends AbstractContent<Title> {
	
	private TextFiledComponent pTitleNo;
	private TextFiledComponent pTitleName;
	
	public TitleContent() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pTitleNo = new TextFiledComponent("번호");
		add(pTitleNo);
		
		pTitleName = new TextFiledComponent("직책명");
		add(pTitleName);
	}
	
	@Override
	public Title getContent(){
		int titleNo =Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		
		return new Title(titleNo, titleName);
	}
	
	@Override
	public void setContent(Title title){
		pTitleNo.setTextValue(title.getTitleNo()+"");
		pTitleName.setTextValue(title.getTitleName());
	}
	
	@Override
	public void isEmptyCheck() throws Exception{
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}
	
	@Override
	public void clear(){
		pTitleNo.setTextValue("");
		pTitleName.setTextValue("");
	}

	@Override
	public void changeContent(Object content) {
		setContent((Title)content);
		pTitleNo.getTextField().setEnabled(false);
	}

	@Override
	public void setEnabled(boolean isOk) {
		if(!isOk){
			pTitleNo.getTextField().setEnabled(false);
			pTitleName.getTextField().setEnabled(false);	
			return;
		}
		pTitleNo.getTextField().setEnabled(true);
		pTitleName.getTextField().setEnabled(true);		
	}

}
