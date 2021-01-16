<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.usermanagement.Controller.SelectAll,com.usermanagement.User_Model.User"%>
<%@ page import="com.usermanagement.dao.UserDAO" %>


<%
  
  UserDAO dao = new UserDAO();
	String id = request.getParameter("userId");
	String lastname = request.getParameter("lastname");
	String firstname = request.getParameter("firstname");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	User user = new User(Integer.parseInt(id),lastname,firstname,email,country);
 	dao.insertUser(user);
 
 	 response.sendRedirect("listUser");
 	
 %>