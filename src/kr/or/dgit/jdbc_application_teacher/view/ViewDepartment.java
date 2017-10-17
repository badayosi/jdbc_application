package kr.or.dgit.jdbc_application_teacher.view;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.DepartmentContent;
import kr.or.dgit.jdbc_application_teacher.dto.Department;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListDepartment;
import kr.or.dgit.jdbc_application_teacher.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	private DepartmentContent pContent;
	
	public ViewDepartment(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}
}
