<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<link rel="stylesheet" href="styleSignup.css">
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

	<div class="signupBox">
		<h1>Create account</h1>
		<form method="post" action="signup">
			<input type="text" name="uName" placeholder="Username">
			<h5><font color =red>${error}</font></h5>
			<input type="email" name="email" placeholder="Email">
			<input type="password" name="password" placeholder="Set Password">
			<button type="submit">Continue</button>
		</form>
		<h4><font color =white>Already a customer?</font><a href="homepage.jsp"><font color = #FF6133>Sign-In.</font></a></h4>
		
	</div>


</body>
</html>