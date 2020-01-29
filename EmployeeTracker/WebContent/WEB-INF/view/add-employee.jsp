<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<title>Saving Employee</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Pronix Employee Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Employee</h3>
		<form:form  action="saveEmployee" modelAttribute="adEmployee" method="POST">
		<form:hidden path="Id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input type="text" path="first_name" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input type="text" path="last_name" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input type="text" path="email" /></td>
					</tr>
					<tr>
						<td><label>Designation:</label></td>
						<td><form:input type="text" path="Designation" /></td>
					</tr>
					<tr>
						<td><label>Phone:</label></td>
						<td><form:input type="text" path="Phone" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
						
					</tr>
				</tbody>	
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath }/employee/list">Click Here To Show Employee List</a>
		</p>
	</div>
</body>



</html>