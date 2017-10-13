package jdbc_application;

import java.awt.EventQueue;

import jdbc_application.view.AbstractView;
import jdbc_application.view.ViewDepartment;
import jdbc_application.view.ViewEmployee;
import jdbc_application.view.ViewTitle;

public class TestView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AbstractView frame = new ViewTitle("직책 관리");
					AbstractView frame2 = new ViewDepartment("부서 관리");
					AbstractView frame3 = new ViewEmployee("직원 관리");
					
					frame.setVisible(true);
					frame2.setVisible(true);
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
