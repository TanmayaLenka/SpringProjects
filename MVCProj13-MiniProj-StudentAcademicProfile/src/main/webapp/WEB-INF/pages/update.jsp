<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<h1 style="color:red;text-align:center">Student Details</h1>
	<form:form method="POST" commandName="stCmd" onsubmit="return Validate(this)">
	<center><table border="1">
		<tr>
		<td>Student ID</td>
		<td><form:input path="sid" disabled="true"/></td>
		</tr>
		<tr>
		<td>Student Name</td>
		<td><form:input path="sname" id="sname"/>
		<br><span style="color:red" id="errsname"><form:errors path="sname"/></span>
		</td>
		</tr>
		<tr>
		<td>Branch </td>
		<td><form:input path="branch" id="branch"/>
		<br><span style="color:red" id="errbranch"><form:errors path="branch"/></span>
		</td>
		</tr>
		<tr>
		<td>Semester </td>
		<td><form:input path="semester" id="semester"/>
		<br><span style="color:red" id="errsemester"><form:errors path="semester"/></span>
		</td>
		</tr>
		<tr>
		<td>Backlogs </td>
		<td><form:input path="backlogs" id="backlogs"/>
		<br><span style="color:red" id="errbacklogs"><form:errors path="backlogs"/></span>
		</td>
		</tr>
		<tr>
		<td><input type="submit" value="Update"/></td>
		<td><input type="reset" value="Reset"/></td>
		</tr>
	</table><br>
	<a href="student_profile.htm"><img src="images/home.jpg" height="30" width="30"/></a>
	</center>
	<input type="hidden" name="flag" value="no"/>
	</form:form>
</body>
</html>