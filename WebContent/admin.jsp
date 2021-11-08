<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="styleAdmin.css">
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
				</ul>
			</div>
		</div>
	</div>

	<div class="adminBox">
		<h1>Admin</h1>
		<form method="post" action="adminLogin">
		<h5><font color =red>${error}</font></h5>
			<input type="text" name="uName" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<button type="submit">Continue</button>
		</form>
	</div>


</body>
</html>