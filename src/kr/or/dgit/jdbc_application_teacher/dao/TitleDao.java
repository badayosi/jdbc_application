package kr.or.dgit.jdbc_application_teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application_teacher.dto.Title;
import kr.or.dgit.jdbc_application_teacher.jdbc.DBCon;

public class TitleDao implements SqlDao<Title> {
	private static final TitleDao instance = new TitleDao();

	public static TitleDao getInstance() {
		return instance;
	}

	private TitleDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertItem(Title item) throws SQLException {
		String sql = "INSERT INTO title VALUES(?, ?)";
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitleNo());
			pstmt.setString(2, item.getTitleName());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteItem(Title item) throws SQLException {
		String sql = "delete from title where titleno=?";
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateItem(Title item) throws SQLException {
		String sql = "update title set titlename=? where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getTitleName());
			pstmt.setInt(2, item.getTitleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Title selectItemByNo(Title item) throws SQLException {
		String sql = "select titleno, titlename from title where titleno = ?";
		Title title = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitleNo());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					title = getTitle(rs);
				}
			}
		}
		return title;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int titleNo = rs.getInt("titleno");
		String titleName = rs.getString("titlename");
		return new Title(titleNo, titleName);
	}

	@Override
	public List<Title> selectItemByAll() throws SQLException {
		String sql = "select titleno, titlename from title";
		List<Title> titles = new ArrayList<>();

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				titles.add(getTitle(rs));
			}
		}
		return titles;
	}

}
