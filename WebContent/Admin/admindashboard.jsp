<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="styleDashboard.css">
</head>
<body>

	
	<div class="main">
		<div class="navbar">
			<div class="icon">
				<h2 class="logo"><a href="userdashboard.jsp">FlyAway</a></h2>
			</div>
			<div class="menu">
				<ul>
					<li><a href="#">TICKETS</a></li>
					<li><a href="#">ABOUT</a></li>
					<li><a href="#">CONTACT</a></li>
					<li><a href="logout">SIGNOUT</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="adminBox">
		<h1>Add Ticket</h1>
		<form method="post" action="addTicket">
			<input type="text" name="From" placeholder="From">
			<input type="text" name="Destination" placeholder="Destination">
			<input type="date" name="Date" placeholder="Depart">
			<input type="text" name="Price" placeholder="Price">
			<button type="submit">Continue</button>
		</form>
	</div>


</body>
</html>