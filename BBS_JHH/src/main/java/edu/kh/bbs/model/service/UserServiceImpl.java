package edu.kh.bbs.model.service;

import static edu.kh.bbs.common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.bbs.model.dao.UserDAO;
import edu.kh.bbs.model.dao.UserDAOImpl;
import edu.kh.bbs.model.dto.BBSUser;

public class UserServiceImpl implements UserSerivce{
	private UserDAO dao = new UserDAOImpl();
	
	@Override
	public BBSUser loginUser(String userId, String userPw) throws SQLException {
		Connection conn = getConnetion();
		
		BBSUser user = dao.loginUser(conn, userId, userPw);
		
		close(conn);
		
		return user;
	}
	
	@Override
	public int signupUser(BBSUser user) throws SQLException {
		Connection conn = getConnetion();
		
		int result = dao.signupUser(conn, user);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		return result;
	}
	
	@Override
	public BBSUser findUserId(String userName, String phoneNumber) throws SQLException {
		Connection conn = getConnetion();
		
		BBSUser user = dao.findUserId(conn, userName, phoneNumber);
		
		close(conn);
		
		return user;
	}
	
	@Override
	public BBSUser findUserPw(String userId) throws SQLException {
		Connection conn = getConnetion();
		
		BBSUser user = dao.findUserPw(conn, userId);
		
		close(conn);
		
		return user;
	}
	
	@Override
	public int updateUser(BBSUser user) throws SQLException {
		Connection conn = getConnetion();
		int result = dao.updateUser(conn, user);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	
	}	
	
	@Override
	public int deleteUser(BBSUser loginUser) throws SQLException {
		Connection conn = getConnetion();
		int result = dao.deleteUser(conn, loginUser);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}
}
