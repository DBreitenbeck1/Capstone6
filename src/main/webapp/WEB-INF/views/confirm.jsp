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

	<label> Are you sure you want to delete this task? </label>

	<table class="table">
		<tr>
			<th>Description</th>
			<th>Due Date</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>${task.description }</td>
				<td>${task.duedate }</td>
				<td><c:if test= "${!task.complete}" > Incomplete</c:if>
					<c:if test= "${task.complete}" > Complete</c:if></td>
		</tr>
	</table>

<form action="/tasklist/delete">
<button type="submit" name = "del" value="${task.id }">
					Yes, Delete</button>
</form>

<form action="/tasklist/${task.user.id}">
<button type="submit">
					No, Cancel</button></form>
</section>
</body>
</html>