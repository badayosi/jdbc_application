package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.jdbc_application_teacher.dto.Department;

@SuppressWarnings("serial")
public class ListDepartment extends AbstractList {
	@Override
	protected void setAlignWidth() {
		setCellWidth(100,150,50);
		setCellAlign(SwingConstants.CENTER, 0, 2);
		setCellAlign(SwingConstants.RIGHT, 1);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"부서번호", "부서명", "위치"};
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas = { { 1, "개발", 10 }, { 2, "인사", 20 }, { 3, "마케팅", 30 } };
		return datas;
	}

	@Override
	public Object getSelectedItem() {
		int selectedIndex = table.getSelectedRow();
		int deptNo = (int) table.getValueAt(selectedIndex, 0);
		String deptName = (String) table.getValueAt(selectedIndex, 1);
		int floor = (int) table.getValueAt(selectedIndex, 2);
		return new Department(deptNo, deptName, floor);
	}
}
