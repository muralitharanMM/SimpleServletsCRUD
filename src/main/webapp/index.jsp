<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,java.util.List,pOJOs.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing</title>
</head>
<body>

<form autocomplete="off" action="${pageContext.request.contextPath}/user" method="post">
<table>
<tr><td>UserName :</td><td><input type="text" name="username"></td></tr>
<tr><td>Password :</td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="Add User"></td><td><input type="Reset" value="Reset"></td></tr>
</table>
</form>




</table>
</body>
</html>