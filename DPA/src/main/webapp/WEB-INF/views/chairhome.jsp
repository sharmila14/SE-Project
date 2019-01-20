<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<%@ include file="../common/chairheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toChange">
<div class="container" id="myStudents">
	<div align = "center">
		<font color="green">${success}</font>
	</div>
	<div align = "center">
		<font color="red">${error}</font>
	</div>
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
	<table class="table table-striped" id="dpReceivedFromAS">
		<h4 align="center">Degree Plans Received from AdminSpecialist</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Student ID</th>
				<th>View Degree Plan</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${receivedDegreePlansLevel3}" var="receivedDegreePlanLevel3" varStatus="theCount">
				<tr>
					<td>${receivedDegreePlanLevel3.name}</td>
					<td>${receivedDegreePlanLevel3.studentId}</td>
					<td><input type="button" class="btn btn-primary receiveDPL3" value = "View Degree Plan" id="${theCount.count}"/></td>
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
$('.receiveDPL3').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("dpReceivedFromAS").rows[id].innerHTML;
	var receivedName = requestRow.split(">",4);
	var sName = receivedName[1].split("<",1);
	var studentId = receivedName[3].split("<",1);
	$.post('receivedDegreePlanAS2', { sN: sName, sId : studentId}, 
    function(result){
         $('#toChange').html(result);
	});
});
</script>
<%@ include file="../common/footer.jspf"%>