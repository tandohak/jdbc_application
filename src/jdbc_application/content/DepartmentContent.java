package jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import jdbc_application.common.TextFiledComponent;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Title;

public class DepartmentContent extends AbstractContent<Department> {

	private TextFiledComponent pDeptNo;
	private TextFiledComponent pDeptName;
	private TextFiledComponent pFloor;

	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pDeptNo = new TextFiledComponent("부서 번호");
		add(pDeptNo);
		
		pDeptName = new TextFiledComponent("부서명");
		add(pDeptName);
		
		pFloor = new TextFiledComponent("위치");
		add(pFloor);
		
	}
	
	@Override
	public Department getContent(){
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		
		return new Department(deptNo, deptName, floor);
	}
	
	@Override
	public void setContent(Department department){
		pDeptNo.setTextValue(department.getDeptNo() + "");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor() + "");	
	}
	
	@Override
	public void isEmptyCheck() throws Exception{
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}

	@Override
	public void clear() {
		pDeptNo.setTextValue("");
		pDeptName.setTextValue("");
		pFloor.setTextValue("");	
		
	}

	@Override
	public void changeContent(Object content) {
		setContent((Department)content);
		pDeptNo.getTextField().setEnabled(false);
	}

	@Override
	public void setEnabled(boolean isOk) {
		if(!isOk){
			pDeptNo.getTextField().setEnabled(false);
			pDeptName.getTextField().setEnabled(false);
			pFloor.getTextField().setEnabled(false);
			return;
		}
		pDeptNo.getTextField().setEnabled(true);
		pDeptName.getTextField().setEnabled(true);
		pFloor.getTextField().setEnabled(true);
		
	}
}
