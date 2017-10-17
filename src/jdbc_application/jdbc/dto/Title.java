package jdbc_application.jdbc.dto;

public class Title {
	@Override
	public String toString() {
		return String.format("%s, %s", titleNo, titleName);
	}

	public Title(int titleNo) {
		this.titleNo = titleNo;
	}

	private int titleNo;
	private String titleName;
	
	public Title() {
	}

	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + titleNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (titleNo != other.titleNo)
			return false;
		return true;
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

	public Object[] toArray() {
		return new Object[]{titleNo,titleName};
	}	
}
