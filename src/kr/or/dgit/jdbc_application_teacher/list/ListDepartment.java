package kr.or.dgit.jdbc_application_teacher.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application_teacher.dto.Department;
import kr.or.dgit.jdbc_application_teacher.service.DepartmentService;

@SuppressWarnings("serial")
public class ListDepartment extends AbstractList {
	private DepartmentService service;
	
	public ListDepartment(DepartmentService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 150, 50);
		setAlign(SwingConstants.CENTER, 0,1, 2);//
	}

	@Override
	protected Object[][] getData() {
		List<Department> lists = service.selectDepartmentByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size(); i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}
	
	@Override
	protected String[] getColumnNames() {
		return new String[]{"부서번호", "부서명", "위치"};
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int deptNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectDepartmentByNo(new Department(deptNo));
	}

}
