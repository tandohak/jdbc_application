package jdbc_application.jdbc.dto;

public class Title {
	@Override
	public String toString() {
		return String.format("%s, %s", titleNo, titleName);
	}

	private int titleNo;
	private String titleName;
	
	public Title() {
		// TODO Auto-generated constructor stub
	}

	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}	
}
