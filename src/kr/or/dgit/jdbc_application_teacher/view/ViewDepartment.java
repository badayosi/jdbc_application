package kr.or.dgit.jdbc_application_teacher.view;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.DepartmentContent;
import kr.or.dgit.jdbc_application_teacher.dto.Department;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListDepartment;
import kr.or.dgit.jdbc_application_teacher.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	
	public ViewDepartment(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteDepartment((Department)content);
	}

	@Override
	protected Object messageBox() {
		return service.selectDepartmentByNo(new Department(Integer.valueOf(JOptionPane.showInputDialog("찾으실 부서번호를 입력하세요"))));
	}

	@Override
	protected void updateContent(Object content) {
		service.updateDepartment((Department)content);
	}

}
