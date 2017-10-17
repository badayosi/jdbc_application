package kr.or.dgit.jdbc_application_teacher.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application_teacher.dto.Department;
import kr.or.dgit.jdbc_application_teacher.dto.Employee;
import kr.or.dgit.jdbc_application_teacher.dto.Title;
import kr.or.dgit.jdbc_application_teacher.service.EmployeeService;

@SuppressWarnings("serial")
public class ListEmployee extends AbstractList {
	private EmployeeService service;

	public ListEmployee(EmployeeService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 100, 100, 150, 150, 100);
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);//
		setAlign(SwingConstants.RIGHT, 4);
	}

	@Override
	protected Object[][] getData() {
		List<Employee> lists = service.selectEmployeeByAll();

		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			Employee emp = lists.get(i);
			datas[i] = emp.toArray();
			datas[i][2] = getTitle(emp.getTitle());
			datas[i][3] = getManager(emp.getManager());
			datas[i][4] = String.format("%,d", datas[i][4]);
			datas[i][5] = getDno(emp.getDno());
		}
		return datas;
	}

	private String getDno(Department dno) {
		return service.selectDepartmentByNo(dno).getDeptName();
	}

	private String getManager(Employee manager) {
		Employee emp = (Employee) service.selectEmployeeByNo(manager);
		if (emp == null) {
			return String.format("%s", "");
		}
		return String.format("%s(%d)", emp.getEmpName(), emp.getEmpNo());
	}

	private String getTitle(Title title) {
		return service.selectTitleByNo(title).getTitleName();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "사원번호", "사원명", "직책", "관리자", "급여", "부서" };
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectEmployeeByNo(new Employee(empNo));
	}

}
