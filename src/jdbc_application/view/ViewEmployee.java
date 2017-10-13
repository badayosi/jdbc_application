package jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application_teacher.content.EmployeeContent;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	
	public ViewEmployee(String title) {
		super(title);
	}

	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent();
		return pContent;
	}

}
