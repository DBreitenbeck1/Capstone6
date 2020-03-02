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

	<div class="container">
		<h2>${ user.name }</h2>






		<table class="table">
		<h4>Your Tasks</h4>
			<tr>
				<th>
					<form action="/tasklist/sortDes">
						<button type="submit" name="id" value="${ user.id }">Description</button>
					</form>
				</th>
				<th>
					<form action="/tasklist/sortDate">
						<button type="submit" name="id" value="${ user.id }">Due
							Date</button>
					</form>
				</th>
				<th>
					<form action="/tasklist/sortComp">
						<button type="submit" name="id" value="${ user.id }">Status</button>
					</form>
				</th>
				<th></th>
				<th></th>

			</tr>
			<c:forEach var="task" items="${user.tasks }">
				<tr
					class=<c:if test="${!task.complete}"><c:out value="incomp" /></c:if>
					<c:if test="${task.complete}"> <c:out value="comp" /></c:if>>
					<td>${task.description }</td>
					<td>${task.duedate }</td>
					<td><c:if test="${!task.complete}"> Incomplete</c:if> <c:if
							test="${task.complete}"> Complete</c:if></td>

					<td><form action="/tasklist/complete" name="comp">
							<button type="submit" name="comp" value="${task.id }">
								Update Status</button>
						</form></td>
					<td><form action="/tasklist/confirm" name="delete">
							<button type="submit" name="del" value="${task.id }">
								Delete</button>
						</form> <!--  <td><form action="/tasklist/complete" id ="complete">
				<input type ="checkbox" value="${task.id }" name ="comp"></form></td>-->
				</tr>
			</c:forEach>
		</table>



		<form action="/tasklist/addTask">
			<button type="submit" name="id" value="${ user.id }">Add
				Task</button>
		</form>

	</div>

	<%@ include file="partials/footer.jsp"%>

</body>
</html>