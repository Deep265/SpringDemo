<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Add Emp</h2><br>
<form action="addEmp" method="post">
ID         : <input type="text" name="eid"><br>
Name       : <input type="text" name="ename"><br>
Technology : <input type="text" name="technology"><br><br>
<input type="submit" value="Submit"><br>
</form>

<h2>Fetch Emp</h2><br>
<form action="getEmp" method="GET">
ID : <input type="text" name="eid"><br><br>
<input type="submit" value="Submit"><br>
</form>
</body>
</html>