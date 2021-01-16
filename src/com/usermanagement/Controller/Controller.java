package com.usermanagement.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.User_Model.User;
import com.usermanagement.dao.UserDAO;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDAO ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        this.userDAO = new UserDAO();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.print(action);
		switch(action) {
		case "/new":
			showViewForm( request,  response);
			break;
		case "/insert":
			insertUser( request,  response);
			break;
		case "/delete":
			deleteUser( request,  response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			updateUser( request,  response);
			break;
		default :
			//handle list
			listUser( request,  response);
			break;
		}
		
	}

	

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<User> listuser = userDAO.getAllUsers();
		request.setAttribute("listUser", listuser);
		RequestDispatcher rq = request.getRequestDispatcher("user-list.jsp");
		rq.forward(request, response);
	}
	
	private void showViewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rq = request.getRequestDispatcher("user-form.jsp");
		rq.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String lastname= request.getParameter("lastname");
		String firstname= request.getParameter("firstname");
		String email= request.getParameter("email");
		String country= request.getParameter("country");
		User user = new User(userId,lastname,firstname,email,country);
		userDAO.insertUser(user);
		
		response.sendRedirect("list");
		
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String lastname= request.getParameter("lastname");
		String firstname= request.getParameter("firstname");
		String email= request.getParameter("email");
		String country= request.getParameter("country");
		User user = new User(userId,lastname,firstname,email,country);
		userDAO.updateUser(user);
		
		response.sendRedirect("list");
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		
		userDAO.deleteUser(userId);
		
		response.sendRedirect("list");
		
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		User user = userDAO.findUserByID(userId);
		RequestDispatcher dispatcher  = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
		//response.sendRedirect("list");
		
	}
}
