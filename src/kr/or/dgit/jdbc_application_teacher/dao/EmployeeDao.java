package kr.or.dgit.jdbc_application_teacher.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application_teacher.dto.Department;
import kr.or.dgit.jdbc_application_teacher.dto.Employee;
import kr.or.dgit.jdbc_application_teacher.dto.Title;
import kr.or.dgit.jdbc_application_teacher.jdbc.DBCon;

public class EmployeeDao implements SqlDao<Employee> {
	private static final EmployeeDao instance = new EmployeeDao();

	public static EmployeeDao getInstance() {
		return instance;
	}

	private EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertItem(Employee item) throws SQLException {
		String sql = "INSERT INTO employee(empno, empname, title, manager, salary, dno) VALUES(?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.setString(2, item.getEmpName());
			pstmt.setInt(3, item.getTitle().getTitleNo());
			pstmt.setInt(4, item.getManager().getEmpNo());
			pstmt.setInt(5, item.getSalary());
			pstmt.setInt(6, item.getDno().getDeptNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteItem(Employee item) throws SQLException {
		String sql = "delete from employee where empno = ?";
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateItem(Employee item) throws SQLException {
		String sql = "update employee set empname=?, title=?, manager=?, salary=?, dno=? where empno=?";
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getEmpName());
			pstmt.setInt(2, item.getTitle().getTitleNo());
			pstmt.setInt(3, item.getManager().getEmpNo());
			pstmt.setInt(4, item.getSalary());
			pstmt.setInt(5, item.getDno().getDeptNo());
			pstmt.setInt(6, item.getEmpNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Employee selectItemByNo(Employee item) throws SQLException {
		String sql = "select empno, empname, title, manager, salary, dno from employee where empno = ?";
		Employee employee = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setInt(1, item.getEmpNo());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					employee = getEmployee(rs);
				}
			}
		}
		return employee;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		Title title = new Title(rs.getInt("title"));
		Employee manager = new Employee(rs.getInt("manager"));
		int salary = rs.getInt("salary");
		Department dno = new Department(rs.getInt("dno"));
		return new Employee(empNo, empName, title, manager, salary, dno);
		
	}

	@Override
	public List<Employee> selectItemByAll() throws SQLException {
		String sql = "select empno, empname, title, manager, salary, dno from employee";
		List<Employee> lists = new ArrayList<>();
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getEmployee(rs));
				
			}
		}
		return lists;
	}

}
