<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Enrollment</title>
</head>
<body>
	<center>
		<h1>Course Enrollment</h1>
		<form:form action="enrollStudent.htm" modelAttribute="student">
			<table>
				<tr>
					<td>Student Name</td>
					<td><form:input path="studentName" /></td>
				</tr>
				<tr>
					<td>Course Name</td>
					<td><form:select path="courseCode">
							<form:options  items="${courseList}"/>
						</form:select></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobutton path="gender" value="male" />Male&nbsp;<form:radiobutton
							path="gender" value="female" />Female</td>
				</tr>
				<tr>
					<td>Course Type</td>
					<td><form:checkbox path="courseType" value="elearning" />e-learning&nbsp;<form:checkbox
							path="courseType" value="classroom" />classroom</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Enroll" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><font color="red">${Message}</font></td>
				</tr>
				<tr>
					<td colspan="2"><a href="home.htm">Home</a></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>