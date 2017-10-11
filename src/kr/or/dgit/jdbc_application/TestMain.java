package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		//testDBCon();
		
		Department dept = new Department(4, "마케팅", 10);
		
		testInsert(dept);
		testListAll();
		System.out.println("----------");
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testSearch(dept);
		System.out.println("----------");
		testDelete(dept);
		testListAll();		
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testSearch(Department dept) {
		try {
			Department searchDept = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(searchDept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department dept : lists)
				System.out.println(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제 되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s\n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "부서 삭제에 실패하였습니다.");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서번호가 추가 되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s\n", e.getErrorCode(), e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "부서번호가 중복 되었습니다.");
			}
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		jdbcUtil.close(connection);
	}
}
