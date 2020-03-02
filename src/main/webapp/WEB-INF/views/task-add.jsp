<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/MyStyle.css" />
</head>
<body>

<%@ include file="partials/header.jsp"%>

<section class="container">
	<h3>Add a Task</h3>


	
		<form method="post" action="/tasklist/addTask">
			<p>
				<label> Description: </label> <input type="text" required
					name="description">
			</p>

			<p>
				<label> Due Date: </label> <input type="text"
					pattern="\d{1,2}/\d{1,2}/\d{4}" required name="duedate"
					value="mm/dd/yyyy">
			</p>


			<div>
			
				<label>User</label> <select name="user">

					<option value="${user.id }">${user.name }</option>

				</select>

			</div>



			<button type="submit" name="id" value =${user.id }>Add Task</button>

		</form>
</body>
</html>