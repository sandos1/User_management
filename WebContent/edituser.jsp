<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.usermanagement.Controller.SelectAll,com.usermanagement.User_Model.User"%>
<%@ page import="com.usermanagement.dao.UserDAO" %>
    
    
    
 <%
  String userid =request.getParameter("userId");
  UserDAO dao = new UserDAO();
  
  User user = dao.findUserByID(Integer.parseInt(userid));
 
 if(user !=null){
	 

	 HttpSession s=request.getSession();
	 session.setAttribute("singleuser", user);
	 response.sendRedirect("Userform.jsp");
	 //response.sendRedirect("UserList.jsp?msg=successfully edit");
 }else{
	 response.sendRedirect("UserList.jsp?msg=unsucessfull edit,try again");
 }
 %>
