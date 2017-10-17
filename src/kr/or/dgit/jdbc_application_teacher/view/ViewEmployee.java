package kr.or.dgit.jdbc_application_teacher.view;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.EmployeeContent;
import kr.or.dgit.jdbc_application_teacher.dto.Employee;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListEmployee;
import kr.or.dgit.jdbc_application_teacher.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService es;
	
	public ViewEmployee(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(es);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		es = new EmployeeService();
	}

}
