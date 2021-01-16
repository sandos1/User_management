<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.usermanagement.Controller.SelectAll,com.usermanagement.User_Model.User"%>
<html>
<head>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		
			<div class="card">
			<div class="card-body">
			<form action="insert" method="get">

			<fieldset class="form-group">
					<label>User Id</label> <input type="text" class="form-control" name="userId">
			</fieldset>
				<fieldset class="form-group">
					<label>User last Name</label> <input type="text" class="form-control"
						name="lastname" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>User first name</label> <input type="text"  class="form-control" name="firstname">
				</fieldset>
				
				<fieldset class="form-group">
					<label>User Email</label> <input type="text" class="form-control" name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text" class="form-control" name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
