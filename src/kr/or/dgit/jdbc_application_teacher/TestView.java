package kr.or.dgit.jdbc_application_teacher;

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
					AbstractView frame1 = new ViewTitle("직책관리");
					frame1.setVisible(true);
					AbstractView frame2 = new ViewEmployee("사원관리");
					frame2.setVisible(true);
					AbstractView frame3 = new ViewDepartment("부서관리");
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
