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
<div class ="container">
<h2>Login</h2>
<p>${message }</p>

<form method="post" action="/tasklist/logcheck">
<label>Enter Name:</label>
<input type="text" name = "name">
<label>Enter Password:</label>
<input type="password" name ="password">
<button type="submit">Submit</button>
 </form>
</div>

<section class="container">
<h3>New User?</h3>
<p><a href="/tasklist/addUser">Set Up a New Account</a></p>
</section>


</body>
</html>