package edu.kh.bbs.model.service;

import java.sql.SQLException;
import java.util.Map;

import edu.kh.bbs.model.dto.BBS;

public interface BbsService {

	int postBoard(BBS bbs) throws SQLException;

	Map<String, Object> selectAll() throws SQLException;

	int deleteBbs(String boardNo) throws SQLException;

	int updateBoard(BBS bbs) throws SQLException;


}
