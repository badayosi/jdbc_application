package jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application_teacher.content.DepartmentContent;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	
	public ViewDepartment(String title) {
		super(title);
	}

	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

}
