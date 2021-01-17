<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.usermanagement.Controller.SelectAll,com.usermanagement.User_Model.User"%>
<%@ page import="com.usermanagement.dao.UserDAO" %>


<title>User Management Application</title>
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
				<a href="#" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			
			
			<hr>
			<div class="container text-left">

				<a href="userformInsert.jsp" class="btn btn-success">Add New User</a>
				
			</div>
			
			<br>

		<table class="table table-bordered" border="1" >
		<thead>
			<tr>
				<th>UserID</th>
				<th>User last name</th>
				<th>User first name</th>
				<th>Email</th>
				<th>Country</th>
				
			</tr>
		</thead>
		<tbody>
		<%
			List<User> userlist =(List<User>) request.getAttribute("user");
		
			for(int i=0;i<userlist.size();i++){
				User user = userlist.get(i);
		%>
			<tr>
				<td><%=user.getUserId() %></td>
				<td><%=user.getLastname() %></td>
				<td><%=user.getFirstname() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getCountry() %></td>
				<td><a href="edituser.jsp?userId=<%=user.getUserId() %>">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="deleteuser.jsp?userId=<%=user.getUserId() %>">Delete</a></td>
			</tr>
			
		<%} %>

		</tbody>

	</table>
	</div>
	</div>
</body>
</html>