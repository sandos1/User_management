package com.usermanagement.Controller;

import com.usermanagement.User_Model.User;
import com.usermanagement.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO user = new UserDAO();
		user.getAllUsers();
		
		User uers = user.findUserByID(1);
		System.out.println("user find"+uers);
		
		User u = new User(2,"silue","Methan","methan@gmail.com","USA");
		
		
		boolean b = user.updateUser(u);
		System.out.println("update sucess"+b);
		
		//user.deleteUser(3);
	}

}
