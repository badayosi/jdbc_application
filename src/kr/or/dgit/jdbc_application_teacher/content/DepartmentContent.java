package kr.or.dgit.jdbc_application_teacher.content;

import java.awt.GridLayout;

import kr.or.dgit.jdbc_application_teacher.common.TextFieldComponent;
import kr.or.dgit.jdbc_application_teacher.dto.Department;

@SuppressWarnings("serial")
public class DepartmentContent extends AbstractContent<Department> {

	private TextFieldComponent pDeptNo;
	private TextFieldComponent pDeptName;
	private TextFieldComponent pFloor;

	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pDeptNo = new TextFieldComponent("부서 번호");
		add(pDeptNo);
		
		pDeptName = new TextFieldComponent("부서 명");
		add(pDeptName);
		
		pFloor = new TextFieldComponent("위치");
		add(pFloor);
	}

	@Override
	public Department getContent(){
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		return new Department(deptNo, deptName, floor);
	}
	
	@Override
	public void setContent(Department department){
		pDeptNo.setTextValue(department.getDeptNo()+"");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor()+"");
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}

	@Override
	public void clear() {
		pDeptNo.setTextValue("");
		pDeptName.setTextValue("");
		pFloor.setTextValue("");
		pDeptNo.setEnable(true);
		pDeptName.setEnable(true);
		pFloor.setEnable(true);
	}

	@Override
	public void changeContent(Object content, String order) {
		if(order.equals("수정")){
			setContent((Department)content);
			pDeptNo.setEnable(false);
		}
		if(order.equals("검색")){
			setContent((Department)content);
			pDeptNo.setEnable(false);
			pDeptName.setEnable(false);
			pFloor.setEnable(false);
		}
	}
}










