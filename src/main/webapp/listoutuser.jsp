<%@ page import="java.util.ArrayList,java.util.List,pOJOs.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing</title>
<script>
        function geek() {
            var doc;
            var result = confirm("Shall I remove user !");
            if (result == true) {
                doc = "OK was pressed.";
                return true;
            } else {
                doc = "Cancel was pressed.";
                return false;
            }
            document.getElementById("g").innerHTML = doc;
        }
    </script>
</head>
<body>
<a href='index.jsp'>Add New Employee</a>
</hr>
<h1> List Of Users !</h1>
<table border="1">
<tr><th>UserName</th><th>Password</th><th>Option</th><th>Option</th></tr>
<%
if(request.getAttribute("userList")!=null){
List<User> lou = (ArrayList<User>)request.getAttribute("userList");
for(User u : lou){
String user = u.getUsername();
String pass = u.getPassword();
String deleteurl = "deleteuser?name="+user;
String geturl = "user?opt=get&name="+user;
%>
	<tr>
	<td><%= u.getUsername() %></td>
	<td><%= u.getPassword() %></td>
	<td><a href="<%= deleteurl %>" onclick="return geek()">remove</a></td>
	<td><a href="<%= geturl %>">edit</a></td>
	</tr>
<%}}else{%>
	<tr><td colspan="4">empty</td></tr>
<%
}	
%>
</table>
</body>
</html>