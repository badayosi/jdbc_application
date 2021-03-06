package kr.or.dgit.jdbc_application_teacher;

import java.awt.EventQueue;

import kr.or.dgit.jdbc_application_teacher.view.AbstractView;
import kr.or.dgit.jdbc_application_teacher.view.ViewDepartment;
import kr.or.dgit.jdbc_application_teacher.view.ViewEmployee;
import kr.or.dgit.jdbc_application_teacher.view.ViewTitle;

public class TestView {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractView frame1 = new ViewTitle("직책관리");
					frame1.setVisible(true);
					
					AbstractView frame2 = new ViewDepartment("부서관리");
					frame2.setVisible(true);
					
					AbstractView frame3 = new ViewEmployee("사원관리");
					frame3.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
