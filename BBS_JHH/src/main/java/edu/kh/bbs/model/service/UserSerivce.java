package edu.kh.bbs.model.service;

import java.sql.SQLException;


import edu.kh.bbs.model.dto.BBSUser;

public interface UserSerivce {


	int signupUser(BBSUser user) throws SQLException;

	BBSUser loginUser(String userId, String userPw) throws SQLException;

	BBSUser findUserId(String userName, String phoneNumber) throws SQLException;

	BBSUser findUserPw(String userId) throws SQLException;

	int updateUser(BBSUser user) throws SQLException;

	int deleteUser(BBSUser loginUser) throws SQLException;

}
