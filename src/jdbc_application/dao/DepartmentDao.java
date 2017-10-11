package jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application.jdbc.DBCon;
import jdbc_application.jdbc.dto.Department;

public class DepartmentDao implements SqlDao<Department> {
	private static final DepartmentDao Instance = new DepartmentDao();

	public static DepartmentDao getInstance() {
		return Instance;
	}

	private DepartmentDao() {
	}

	@Override
	public void insertItem(Department item) throws SQLException {
		String sql = "INSERT INTO department VALUES(?, ?, ?)";
		Connection con = DBCon.getInstance().getConnection();

		// 개선된 try catch 문
		// 사용하는 이유는 이 구문이 끝나면 자동으로 close 되게때문에 사용한다.
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, item.getDeptNo());
			pstmt.setString(2, item.getDeptName());
			pstmt.setInt(3, item.getFloor());
			pstmt.executeUpdate();
		}
		// sql 예외처리는 throws로 던져서 사용하는 클래스에서 예외처리 하도록 한다.

	}

	@Override
	public void deleteItem(Department item) throws SQLException {
		String sql = "delete from department where deptno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, item.getDeptNo());
			pstmt.executeUpdate();
		} /*
			 * catch (SQLException e) { System.err.printf("%s - %s%n",
			 * e.getErrorCode(), e.getMessage()); e.printStackTrace(); }
			 */
	}

	@Override
	public void updateItem(Department item) throws SQLException {
		String sql = "update department set deptname =? , floor =? where deptno = ?";
		Connection con = DBCon.getInstance().getConnection();
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, item.getDeptName());
			pstmt.setInt(2, item.getFloor());
			pstmt.setInt(3, item.getDeptNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Department selectItemByNo(Department item) throws SQLException {
		
		String sql = "select deptno, deptname, floor from department where deptno = ?";
		Department dept = null;
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setInt(1,item.getDeptNo());
			
			try(ResultSet rs = pstmt.executeQuery();){
				if (rs.next()) {
					dept = getDepartment(rs);
				}
			}			
			
		}
		return dept;
	}

	@Override
	public List<Department> selectItemByAll() throws SQLException {
		List<Department> lists = new ArrayList<>();
		String sql = "select deptno, deptname, floor from department";

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getDepartment(rs));
			}
		}

		return lists;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt(1);
		String deptName = rs.getString(2);
		int floor = rs.getInt(3);
		return new Department(deptNo, deptName, floor);
	}

}
