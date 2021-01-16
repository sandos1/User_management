package com.usermanagement.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.User_Model.User;
import com.usermanagement.dao.UserDAO;



@WebServlet("/listUser")
public class SelectAll extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	UserDAO dao = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		List<User> userlist = dao.getAllUsers();
		request.setAttribute("user", userlist);
		RequestDispatcher rq = request.getRequestDispatcher("/UserList.jsp");
		rq.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
