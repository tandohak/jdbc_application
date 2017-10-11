package jdbc_application.jdbc.dto;

public class Employee {
	private int empno;
	private String empname;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dno;
		
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String empname, Title title, Employee manager, int salary, Department dno) {
		this.empno = empno;
		this.empname = empname;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dno = dno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s]", empno, empname,
				title.getTitleName(), manager.getEmpname(), salary, dno.getDeptName());
	}
	
}
