package jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import jdbc_application.common.TextFiledComponent;
import jdbc_application.content.DepartmentContent;
import jdbc_application.content.EmployeeContent;
import jdbc_application.content.TitleContent;
import jdbc_application.dao.DepartmentDao;
import jdbc_application.dao.EmployeeDao;
import jdbc_application.dao.TitleDao;
import jdbc_application.jdbc.DBCon;
import jdbc_application.jdbc.JdbcUtil;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Employee;
import jdbc_application.jdbc.dto.Title;

public class TestMain {

	public static void main(String[] args) {
//		testDBCon();
		
//		testDepartment();
		
//		testTitleDao();
		
//		testEmployeeDao();
		
//		testTextFieldComponent();
		
//		testDepartentContent();
		
//		testEmpContent();
		
		testTitleContent();
		
	}
	
	private static void testTitleContent() {
		TitleContent tfc = new TitleContent();
		JButton btn = new JButton("테스트");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					tfc.isEmptyCheck();
					Title title = tfc.getContent();
					JOptionPane.showMessageDialog(null, title);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		
		testContent(tfc, btn);
	}

	private static void testEmpContent() {
		EmployeeContent tfc = new EmployeeContent();
		JButton btn = new JButton("테스트");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					tfc.isEmptyCheck();
					Employee emp = tfc.getContent();
					JOptionPane.showMessageDialog(null, emp);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		
		testContent(tfc, btn);
	}

	private static void testDepartentContent() {
		DepartmentContent tfc = new DepartmentContent();
		tfc.setContent(new Department(1, "개발", 10));
		
		JButton btn = new JButton("테스트");

		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					tfc.isEmptyCheck();
					Department dept = tfc.getContent();
					JOptionPane.showMessageDialog(null, dept);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc, btn);
	}

	private static void testTextFieldComponent() {
		TextFiledComponent tfc = new TextFiledComponent("테스트");
		JButton btn = new JButton("테스트");
		tfc.setTextValue("재진");	
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getTextValue());
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc, btn);
	}

	private static void testContent(JPanel panel, JButton btn) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 200, 150);
		jf.add(panel);
		jf.add(btn,BorderLayout.SOUTH);	
		jf.setVisible(true);
	}

	private static void testEmployeeDao() {
		Employee item = new Employee(4444, "아이유", new Title(5), new Employee(4377), 1500000, new Department(5));
		
		employeeInsert(item);
		employeeSelectByNo(item);
		
		item.setManager(new Employee(3426));
		item.setSalary(2500000);
		
		employeeUpdate(item);
		employeeSelectByNo(item);
		
		employeeDelete(item);
		employeeSelectAll();
		
	}

	private static void employeeUpdate(Employee item) {
		try {
			EmployeeDao.getInstance().updateItem(item);
			JOptionPane.showMessageDialog(null, "사원이 수정되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "수정 실패");
			}
			e.printStackTrace();
		}
	}

	private static void employeeSelectByNo(Employee item) {
		try {
			System.out.println(EmployeeDao.getInstance().selectItemByNo(item));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void employeeSelectAll() {
		try {
			List<Employee> lists = EmployeeDao.getInstance().selectItemByAll();
			for(Employee emp : lists){
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void employeeDelete(Employee item) {
		try {
			EmployeeDao.getInstance().deleteItem(item);
			JOptionPane.showMessageDialog(null, "사원이 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}

	private static void employeeInsert(Employee item) {
		try {
			EmployeeDao.getInstance().insertItem(item);
			JOptionPane.showMessageDialog(null, "사원이 추가되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "사원번호 중복");
			}
			e.printStackTrace();
		}
	}

	private static void testTitleDao() {
		Title item = new Title(6, "팀장");
		
		
		titleInsert(item);
		titleSelectByNo(item);
		
		item.setTitleName("주임");
		
		titleUpdate(item);
		titleSelectByNo(item);
		
		titleDelete(item);		
		titleSelecByAll();
	}

	private static void titleUpdate(Title item) {
		try {
			TitleDao.getInstance().updateItem(item);
			JOptionPane.showMessageDialog(null, "수정 완료 되었습니다.");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}

	private static void titleSelectByNo(Title item) {
		try {
			Title title = TitleDao.getInstance().selectItemByNo(item);
			if(title == null){
				JOptionPane.showMessageDialog(null, "없는 직책 번호 입니다.");
				return;
			}
			System.out.println(title);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	private static void titleSelecByAll() {
		try {
			List<Title> lists = TitleDao.getInstance().selectItemByAll();
			for(Title t : lists){
				System.out.println(t);
			}
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}

	private static void titleDelete(Title item) {
		try {
			TitleDao.getInstance().deleteItem(item);
			JOptionPane.showMessageDialog(null, "직책 삭제");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			JOptionPane.showMessageDialog(null, "직책번호가 중복");
			e.printStackTrace();
		}
	}

	private static void titleInsert(Title item) {
		
		try {
			TitleDao.getInstance().insertItem(item);
			JOptionPane.showMessageDialog(null, "직책을 추가하였습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "직책번호가 중복");
			}
			e.printStackTrace();
		}
	}

	private static void testDepartment() {
		Department dept = new Department(4,"마케팅",10);
		
		testInsert(dept);

		testListAll(dept);
		dept.setDeptName("마케팅2");
		
		testUpdate(dept);
		testDeptNo(dept);	
		
		testDelte(dept);		
		testListAll(dept);
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 수정되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}

	private static void testDeptNo(Department dept) {
		try {
			Department test = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(test);
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}

	private static void testListAll(Department dept) {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department d : lists){
				System.out.println(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelte(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
			e.printStackTrace();
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
			}
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();		
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);		
		
		
		JdbcUtil.close(connection);
	}

}
