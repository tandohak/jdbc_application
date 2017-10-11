package jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_application.jdbc.DBCon;
import jdbc_application.jdbc.dto.Title;

public class TitleDao implements SqlDao<Title> {
	private static final TitleDao Instance = new TitleDao();
		
	
	private TitleDao() {}

	public static TitleDao getInstance() {
		return Instance;
	}
		
	
	@Override
	public void insertItem(Title item) throws SQLException {
		String sql = "insert into title values (? , ?)";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt  = con.prepareStatement(sql)){
			pstmt.setInt(1, item.getTitleNo());
			pstmt.setString(2, item.getTitleName());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void deleteItem(Title item) throws SQLException {
		String sql = "delete from title where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt  = con.prepareStatement(sql)){
			pstmt.setInt(1, item.getTitleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateItem(Title item) throws SQLException {
		String sql = "update title set titlename = ? where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt  = con.prepareStatement(sql)){
			pstmt.setString(1, item.getTitleName());
			pstmt.setInt(2, item.getTitleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Title selectItemByNo(Title item) throws SQLException {
		String sql = "select titleno, titlename from title where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();
		Title title = null;
		
		try(PreparedStatement pstmt  = con.prepareStatement(sql)){
				pstmt.setInt(1, item.getTitleNo());
				
				try(ResultSet rs =  pstmt.executeQuery()){
					if(rs.next()){
						title = getTitle(rs);	
					}
				}						
				
			}
		
		return title;
	}

	@Override
	public List<Title> selectItemByAll() throws SQLException {
		List<Title> lists = new ArrayList<>();
		String sql = "select * from title";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt  = con.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();){
			
			while(rs.next()){
				lists.add(getTitle(rs));				
			}
			
		}
		
		return lists;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int titleNo = rs.getInt(1);
		String titleName = rs.getString(2);
		return new Title(titleNo, titleName);
	}

	

}
