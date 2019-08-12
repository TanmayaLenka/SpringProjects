<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 style="color:red;text-align:center">Student Profile Details</h1><br><br>

<c:choose>
	<c:when test="${!empty studentList}">
	<center><table border="1">
	<tr>
	<th>SLNo</th><th>SID</th><th>SNAME</th><th>BRANCH</th><th>SEMESTER</th><th>BACKLOGS</th><th>OPERATION</th>
	</tr>
	<c:forEach var="dto" items="${studentList}">
	<tr>
		<td>${dto.slno}</td>
		<td>${dto.sid}</td>
		<td>${dto.sname}</td>
		<td>${dto.branch}</td>
		<td>${dto.semester}</td>
		<td>${dto.backlogs}</td>
		<td>
			<a href="update.htm?sid=${dto.sid }"><img src="images/update.png" height="30" width="30"/></a>&nbsp;&nbsp;&nbsp;
			<a href="delete.htm?sid=${dto.sid }" onclick="return confirm('Do you want to remove ! ${dto.sname}')"><img src="images/delete.png" height="30" width="30"/></a>
		</td>
	</tr>
		</c:forEach>
		<tr>
		<td align="center" colspan="7">Register new student &nbsp;&nbsp; <a href="insert.htm"><img src="images/insert.jpg" height="30" width="30"/></a></td>
	</tr>
		
	</table></center>
	<h1 style="color:red;text-align:center">${msg}</h1>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center">Record not found</h1>
	</c:otherwise>
</c:choose>