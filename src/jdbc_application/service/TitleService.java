package jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_application.dao.SqlDao;
import jdbc_application.dao.TitleDao;
import jdbc_application.jdbc.dto.Title;

public class TitleService {
	private SqlDao<Title> titleDao;

	public TitleService() {
		titleDao = TitleDao.getInstance();
	}
	
	public void insertTitle(Title title){
		try {
			titleDao.insertItem(title);
			showMessage("추가완료");	
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void updateTitle(Title title){
		try {
			titleDao.insertItem(title);
			showMessage("삭제 완료");	
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Title> selectTitleByAll(){
		
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null,msg);		
	}
}
