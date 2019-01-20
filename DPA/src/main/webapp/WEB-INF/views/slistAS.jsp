<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminspecialistheader.jspf"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" id="myStudents">
	<table class="table table-striped" id="requestTable">
		<h4 align="center">Student List</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student" varStatus="theCount">
				<tr>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td><input type="button" class="btn btn-primary sendMessage" value = "Send Message" id="${theCount.count}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../common/footer.jspf"%>