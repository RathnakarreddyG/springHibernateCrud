<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.lang.*,java.util.*,java.net.*,java.util.*,java.text.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<title>List Of Employees</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Pronix Employee data</h2>
		</div>

		<div id="container">
			<div id="content">

				<input type="Button" value="Add Employee"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />

				<!-- -Adding search button -->
				<form:form action="search" method="GET">
                Search Employee: <input type="text" name="theSearchName" class="form-control my-0 py-1 lime-border" placeholder=" First name or last name"/>

					<input type="submit" value="Search" class="add-button" />
				</form:form>

				<table>
					<tr>
						<th>Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>Designation</th>
						<th>Phone</th>
						<th>Action</th>
					</tr>
					<c:forEach var="tempEmployees" items="${Employees}">
						<!-- Creating update link and binding -->
						<c:url var="updatelink" value="/employee/showFormForUpdate">
							<c:param name="EmployeeId" value="${tempEmployees.id}" />
						</c:url>
						<!-- Create delete link -->
						<c:url var="RemoveLink" value="/employee/delete">
							<c:param name="EmployeeId" value="${tempEmployees.id}" />
						</c:url>
						<tr>
							<td>${tempEmployees.id}</td>
							<td>${tempEmployees.first_name}</td>
							<td>${tempEmployees.last_name}</td>
							<td>${tempEmployees.email}</td>
							<td>${tempEmployees.designation}</td>
							<td>${tempEmployees.phone}</td>
							<td><a href="${updatelink}">Update</a> | <a
								href="${RemoveLink}"
								onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">Delete</a></td>
						</tr>
					</c:forEach>
				</table>

			</div>

		</div>


	</div>

</body>


</html>

