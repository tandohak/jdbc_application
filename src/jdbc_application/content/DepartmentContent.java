package jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import jdbc_application.common.TextFiledComponent;
import jdbc_application.jdbc.dto.Department;

public class DepartmentContent extends JPanel {

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

	public Department getContent(){
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		
		return new Department(deptNo, deptName, floor);
	}
	
	public void setContent(Department department){
		pDeptNo.setTextValue(department.getDeptNo() + "");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor() + "");	
	}
	
	public void isEmptyCheck() throws Exception{
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}
}
