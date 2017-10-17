package kr.or.dgit.jdbc_application_teacher.view;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.EmployeeContent;
import kr.or.dgit.jdbc_application_teacher.dto.Employee;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListEmployee;
import kr.or.dgit.jdbc_application_teacher.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService service;
	private ListEmployee pList;
	
	public ViewEmployee(String title) {
		super(title);
		setBounds(100, 100, 450, 500);
	}

	@Override
	protected AbstractList createList() {
		pList = new ListEmployee(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(service);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		service = new EmployeeService();
	}

	@Override
	protected void insertContent(Object content) {
		service.insertEmployee((Employee)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteEmployee((Employee)content);
	}

	@Override
	protected Object messageBox() {
		return service.selectEmployeeByNo(new Employee(Integer.valueOf(JOptionPane.showInputDialog("찾으실 사원번호를 입력하세요"))));
	}

	@Override
	protected void updateContent(Object content) {
		service.updateEmployee((Employee)content);
	}

}
