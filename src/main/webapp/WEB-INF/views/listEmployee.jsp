<%@page import="java.util.List"%>
<%@page import="com.prowings.entity.Employee"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
</head>
<body>

	<h1>List of Employees</h1>
	<table border="1"> 
	<thead>
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>address</th>
				
			<tr>
    </thead>
    <tbody>
			<%
			List<Employee> list = (List) request.getAttribute("employees");
			%>

			<%
			for (Employee u : list) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>