package edu.kh.bbs.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bbs.model.dto.BBS;

public interface BbsDAO {
	int postBoard(Connection conn, BBS bbs) throws SQLException;

	List<BBS> selectAll(Connection conn) throws SQLException;

	int getboardNo(Connection conn) throws SQLException;

	int deleteBbs(Connection conn, String boardNo) throws SQLException;

	int deleteBbs(Connection conn, BBS bbs) throws SQLException;
}
