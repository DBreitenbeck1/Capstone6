<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel ="stylesheet" href ="/MyStyle.css"/>
</head>
<body>
<%@ include file="partials/header.jsp" %>

<section class="jumbotron"> 
<table class="table">
  <tr>
    <th>Id</th>
    <th>Name</th>
  </tr>
  <c:forEach items="${users }" var="user">
  <tr>
    <td>${user.id }</td>
    <td><a href="/tasklist/${user.id}">${user.name }</a></td>
   
  </tr>
  </c:forEach>
</table>
</section>


</body>
</html>