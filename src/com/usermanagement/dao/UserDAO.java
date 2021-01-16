package com.usermanagement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.usermanagement.JDBC_connectionPool.C3PO_Connection_pool;
import com.usermanagement.User_Model.User;


public class UserDAO {


	
	//private Connection connection =C3PO_Connection_pool.getDataSource().getConnection();
			
			
			

	//select all users
	
	public List<User> getAllUsers() {
		
		List<User> allUser = new ArrayList<>();
		String query = "{ call getAllUsers }";
		try(Connection connection = C3PO_Connection_pool.getDataSource().getConnection();
				 CallableStatement callablestatement = connection.prepareCall(query)){
		
			 
			ResultSet rs= callablestatement.executeQuery();
			while( rs.next()) {
				int userId= rs.getInt("userId");
				String lastname= rs.getString("lastname");
				String firstname= rs.getString("firstname");
				String email=  rs.getString("email");
				String country=  rs.getString("country");
				
				
				User user = new User(userId,lastname,firstname,email,country);
				allUser.add(user);
			}
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return allUser;
		
	}

	
	//find User by ID
	
	public User findUserByID(int id) {
		String query = "{ call findUserById(?) }";
		User user=null;
		try(Connection connection = C3PO_Connection_pool.getDataSource().getConnection();
				 CallableStatement callablestatement = connection.prepareCall(query)){
		
			callablestatement.setInt(1,id);
			
			
			ResultSet rs= callablestatement.executeQuery();
			while(rs.next()) {
				
				String lastname= rs.getString("lastname");
				String firstname= rs.getString("firstname");
				String email=  rs.getString("email");
				String country= ((ResultSet) rs).getString("country");
				int userId=  rs.getInt("userId");
				
				 user = new User(userId,lastname,firstname,email,country);
			}
			
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return user;
	}

	//Insert User
	public void insertUser(User user) {
		String query = "{ call insertUser(?,?,?,?,?) }";
		try(Connection connection = C3PO_Connection_pool.getDataSource().getConnection();
				 CallableStatement callablestatement = connection.prepareCall(query)){
		
			callablestatement.setInt(1, user.getUserId());
			callablestatement.setString(2, user.getLastname());
			callablestatement.setString(3, user.getFirstname());
			callablestatement.setString(4, user.getEmail());
			callablestatement.setString(5, user.getCountry());
			
			 // Run insertUser() store procedure
			callablestatement.executeUpdate();
			
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	//Update user
		public boolean updateUser(User user) {
			boolean rowupdate = false;
			String query = "{ call updateUser(?,?,?,?,?) }";
			try(Connection connection = C3PO_Connection_pool.getDataSource().getConnection();
					 CallableStatement callablestatement = connection.prepareCall(query)){
				callablestatement.setInt(1, user.getUserId());
				callablestatement.setString(2, user.getLastname());
				callablestatement.setString(3, user.getFirstname());
				callablestatement.setString(4, user.getEmail());
				callablestatement.setString(5, user.getCountry());
				
				 // Run insertUser() store procedure
				rowupdate= callablestatement.executeUpdate()>0;
				
			}catch(Exception e) {
			e.printStackTrace();
			}
			return rowupdate;
		}
	//delete user
	
		public void deleteUser(int id) {
			String query = "{ call deleteUser(?) }";
			try(Connection connection = C3PO_Connection_pool.getDataSource().getConnection();
					 CallableStatement callablestatement = connection.prepareCall(query)){
			
				callablestatement.setInt(1, id);
				
				
				 // Run insertUser() store procedure
				callablestatement.executeUpdate();
				
			}catch(Exception e) {
			e.printStackTrace();
			}
		}


		
		
	
	
}
