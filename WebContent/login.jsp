<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-In</title>
<link rel="stylesheet" href="styleLogin.css">
</head>
<body>

	<div class="loginBox">
		<h1>Sign-In</h1>
		<form method="post" action="login">
		<h5><font color =red>${error}</font></h5>
			<input type="text" name="uName" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<button type="submit">Continue</button>
		</form>
		<h4><font color =white>New to FlyAway?</font><a href="signup.jsp"><font color = #FF6133>Create account.</font></a></h4>
	</div>
		


</body>
</html>