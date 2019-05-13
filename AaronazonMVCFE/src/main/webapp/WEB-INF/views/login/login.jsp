<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<html>
	<body>
		<t:headerfooter>

			<form:form id="loginForm" modelAttribute="userView" action="validateLogin" method="post">
			<table>
				<tr>
					<td>
						<form:label path="userName">Username: </form:label>
					</td>
					<td>
						<form:input path="userName" name="userName" id="userName"></form:input>
					</td>
				</tr>
				<tr>
					<td><form:label path="password">Password: </form:label></td>
					<td><form:password path="password" name="password" id="password"></form:password></td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<form:button id="login" name="login">Login</form:button>
					</td>
				</tr>
				
			</table>

			</form:form>
			<p>
				<a href="/AaronazonMVCFE/register">Not a Member? Register here.</a>
			</p>
			<h2>${message}</h2>

		</t:headerfooter>
	</body>
</html>