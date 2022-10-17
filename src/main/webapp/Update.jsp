<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
</head>
<body>
<form align= "center" action ="Update">
	<div>
	<h2>Update data</h2>
	</div>
	
	<div>
	<label>Employee Name</label><br>
	<input type="text" name="name" required></input><br>
	</div>
	
	<div>
	<label>Employee Email</label><br>
	<input type="Email" name="email" required></input><br>
	</div>
	
	<div>
	<label>Employee Location</label><br>
	<input type="text" name="Location" required></input><br>
	</div>
	
	<div>
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/><br>
	</div>
	
	<div>
	<button type="submit">Update</button>
	</div>
	
	</form>
</body>
</html>