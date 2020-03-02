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
<h3>New User</h3>

	<%@ include file="partials/header.jsp"%>


<section class="container">
<p>${message }</p>
<form action ="/tasklist/addUser" method="post"> 
<p><label> UserName:
</label>
<input type="text" required name="name">
</p>

<p><label> Password:
</label>
<input type="password" required name="password">
</p>

<p><label> Confirm Password:
</label>
<input type="password" required name="passwordconf">
</p>
<!--  -->
<button type="submit">Submit New User</button>

 </form>
</section>

</body>
</html>