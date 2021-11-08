<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="main">
		<div class="navbar">
			<div class="icon">
				<h2 class="logo"><a href="homepage.jsp">FlyAway</a></h2>
			</div>
			<div class="menu">
				<ul>
					<li><a href="homepage.jsp">HOME</a></li>
					<li><a href="#">ABOUT</a></li>
					<li><a href="#">CONTACT</a></li>
					<li><a href="admin.jsp">ADMIN</a></li>
				</ul>
			</div>
		</div>
	</div>

	<%@ include file = "login.jsp" %>



</body>
</html>