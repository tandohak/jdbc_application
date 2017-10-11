package jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application.dao.DepartmentDao;
import jdbc_application.dao.TitleDao;
import jdbc_application.jdbc.DBCon;
import jdbc_application.jdbc.JdbcUtil;
import jdbc_application.jdbc.dto.Department;
import jdbc_application.jdbc.dto.Title;

public class TestMain {

	public static void main(String[] args) {
//		testDBCon();
		
//		testDepartment();
		
//		testTitleDao();
		
		testEmployeeDao();
	}

	private static void testEmployeeDao() {
		
		
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
