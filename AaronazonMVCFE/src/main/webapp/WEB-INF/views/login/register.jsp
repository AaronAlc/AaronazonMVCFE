<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<html>
<body>
	<t:headerfooter>
		<form:form id="registrationForm" modelAttribute="userView"
			action="registeruser" method="post">
			<table>
				<tr>
					<td><form:label path="userName">Username: </form:label></td>
					<td><form:input path="userName" name="userName" id="userName" required="required"></form:input>
					</td>
				</tr>
				<tr>
					<td><form:label path="password">Password: </form:label></td>
					<td><form:password path="password" name="password"
							id="password" required="required"></form:password></td>
				</tr>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:input path="firstName" name="firstName"
							id="firstName"></form:input>
				</tr>
				<tr>
					<td><form:label path="lastName">First Name:</form:label></td>
					<td><form:input path="lastName" name="lastName" id="lastName"></form:input>
				</tr>
				<tr>
					<td><form:label path="phone">Phone: </form:label></td>
					<td><form:input path="phone" name="phone" id="phone"></form:input>
				</tr>
				<tr>
					<td><form:label path="email">Email: </form:label></td>
					<td><form:input path="email" name="email" id="email"></form:input>
				</tr>
				<tr>
					<td></td>
					<td align="left"><form:button id="register" name="register">Login</form:button>
					</td>
				</tr>
			</table>
		</form:form>
	</t:headerfooter>
</body>
</html>