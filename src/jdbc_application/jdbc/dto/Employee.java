package jdbc_application.jdbc.dto;

public class Employee {
	private int empno;
	private String empname;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dno;
		
	public Employee(int empno) {
		this.empno = empno;
	}
	
	public Employee(int empno, String empname) {
		this.empno = empno;
		this.empname = empname;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}

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
		return String.format("%s(%s)", empname, empno);
	}
	
	public Object[] toArray(){
		return new Object[]{empno,empname,title,manager,salary,dno};
	}
}
