<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<%@ include file="../common/professorheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toChange">
<div class="container" id="myStudents">
	<table class="table table-striped" id="myStudentsTable">
		<h4 align="center">My Students</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Degree Plan</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myStudents}" var="myStudent" varStatus="theCount">
				<tr>
					<td>${myStudent.userName}</td>
					<td>${myStudent.department}</td>
					<td><input type="button" class="btn btn-primary dpStatus" value = "${myStudent.degreePlanStatus}" id="${theCount.count}" disabled/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<script>
$('.dpStatus').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("myStudentsTable").rows[id].innerHTML;
	var receivedName = requestRow.split(">",20);
	var sName = receivedName[1].split("<",1);
	window.location.href="/dpa/viewdegreeplan?uName=" + sName ;
});
$(document).ready(function(){
	var id = $('.dpStatus').length;;
	var i;
	for (i = 1; i <= id; i++) { 
		if(($("#" + i).val()) == "View Degree Plan"){
			$("#" + i).prop('disabled', false);
		}
	}
});
</script>
<%@ include file="../common/footer.jspf"%>