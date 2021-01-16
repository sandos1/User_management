<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.usermanagement.Controller.SelectAll,com.usermanagement.User_Model.User"%>
<%@ page import="com.usermanagement.dao.UserDAO" %>
    

<% 
	User userlist = (User) session.getAttribute("singleuser");
%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="#"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		
			<div class="card">
				
			<div class="card-body">
		
			
			<form action="updateuser.jsp" method="get">
			

			<fieldset class="form-group">
					<label>User Id</label> <input type="text" class="form-control" name="userId" value="<%=userlist.getUserId()%>" readonly>
			</fieldset>
				<fieldset class="form-group">
					<label>User last Name</label> <input type="text" class="form-control"
						name="lastname" required="required" value="<%=userlist.getLastname()%>">
				</fieldset>
				<fieldset class="form-group">
					<label>User first name</label> <input type="text"  class="form-control" name="firstname" value="<%=userlist.getFirstname()%>">
				</fieldset>
				
				<fieldset class="form-group">
					<label>User Email</label> <input type="text" class="form-control" name="email" value="<%=userlist.getEmail()%>">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text" class="form-control" name="country" value="<%=userlist.getCountry()%>">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>