package edu.kh.bbs.model.dao;

import static edu.kh.bbs.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.bbs.model.dto.BBSUser;

public class UserDAOImpl implements UserDAO{

	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public UserDAOImpl() {
		try {
			prop = new Properties();
		    String path = UserDAOImpl.class.getResource("/edu/kh/bbs/sql/sql.xml").getPath(); 
		    
		    prop.loadFromXML(new FileInputStream(path));

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public BBSUser loginUser(Connection conn, String userId, String userPw) throws SQLException {
		BBSUser user = null;
		try {
			String sql = prop.getProperty("loiginUser");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				user = new BBSUser();
				user.setUserId(rs.getString("USER_ID"));
				user.setUserPw(rs.getString("USER_PW"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			}
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
	
	@Override
	public int signupUser(Connection conn, BBSUser user) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("signupUser");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPhoneNumber());
			
			result = pstmt.executeUpdate();

		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	@Override
	public BBSUser findUserId(Connection conn, String userName, String phoneNumber) throws SQLException {
		BBSUser user = null;
		try {
			String sql = prop.getProperty("findUserId");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phoneNumber);
			
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String userId = rs.getString("USER_ID");

	            user = new BBSUser();
	            user.setUserId(userId);
	        }
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
	
	@Override
	public BBSUser findUserPw(Connection conn, String userId) throws SQLException {
		BBSUser user = null;
		try {
			String sql = prop.getProperty("findUserPw");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String userPw = rs.getString("USER_PW");

	            user = new BBSUser();
	            user.setUserPw(userPw);
	        }
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
	
	@Override
	public int updateUser(Connection conn, BBSUser user) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateUser");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4,  user.getUserId());
			
			result = pstmt.executeUpdate();	
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	@Override
	public int deleteUser(Connection conn, BBSUser loginUser) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteUser");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}
