package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application_teacher.dto.Employee;

@SuppressWarnings("serial")
public class ListEmployee extends AbstractList {
	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 100, 100, 100, 100, 50);
		setCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setCellAlign(SwingConstants.RIGHT, 4);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "사원번호", "사원명", "직책", "관리자", "급여", "부서명" };
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas = { { 1003, "가나다", "사장", "이사장", 1500000, "기획" }, { 1004, "가나도", "부사장", "사장", 1500000, "기획" } };
		return datas;
	}

	@Override
	public Object getSelectedItem() {
		return null;
	}
}
