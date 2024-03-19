package edu.kh.bbs.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.dto.BBSUser;

public interface UserDAO {

	BBSUser loginUser(Connection conn, String userId, String userPw) throws SQLException;

	int signupUser(Connection conn, BBSUser user) throws SQLException;

	BBSUser findUserId(Connection conn, String userName, String phoneNumber) throws SQLException;

	BBSUser findUserPw(Connection conn, String userId) throws SQLException;

	int updateUser(Connection conn, BBSUser user) throws SQLException;

	int deleteUser(Connection conn, BBSUser loginUser) throws SQLException;


}
