package edu.kh.bbs.model.service;

import static edu.kh.bbs.common.JDBCTemplate.close;

import static edu.kh.bbs.common.JDBCTemplate.getConnetion;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.bbs.model.dao.BbsDAO;
import edu.kh.bbs.model.dao.BbsDAOImpl;
import edu.kh.bbs.model.dao.UserDAO;
import edu.kh.bbs.model.dao.UserDAOImpl;
import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.dto.BBSUser;


public class BbsServiceImpl implements BbsService{
	private BbsDAO dao = new BbsDAOImpl();
	@Override
	public int postBoard(BBS bbs) throws SQLException {
		Connection conn = getConnetion();
		
		int result = dao.postBoard(conn, bbs);
		
		close(conn);
		
		return result;
	}
	
	@Override
	public Map<String, Object> selectAll() throws SQLException {
		Connection conn = getConnetion();
		
		List<BBS> BBSList = dao.selectAll(conn);
		
		int boardNo = dao.getboardNo(conn);
		
		close(conn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("BBSList", BBSList);
		map.put("boardNo", boardNo);
		
		return map;
		
	}
	@Override
	public int deleteBbs(String boardNo) throws SQLException {
		Connection conn = getConnetion();
		
		int result = dao.deleteBbs(conn, boardNo);
		
		close(conn);
		
		return result;
	}
	
	@Override
	public int updateBoard(BBS bbs) throws SQLException {
		Connection conn = getConnetion();
		
		int result = dao.deleteBbs(conn, bbs);
		
		close(conn);
		
		return result;
	}
}
