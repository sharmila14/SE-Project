<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminspecialistheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toChange">
<div class="container" id="receivedDegreePlans">
	<div align = "center">
		<font color="green">${success}</font>
	</div>
	<div align = "center">
		<font color="red">${error}</font>
	</div>
	<table class="table table-striped" id="receivedDegreePlansTable">
		<h4 align="center">Received Degree Plans</h4>
		<thead>
			<tr>
				<th>Student Name</th>
				<th>Student ID</th>
				<th>Email</th>
				<th>Status</th>
				<th>View Degree Plan</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${degreePlans}" var="degreePlan" varStatus="theCount">
				<tr>
					<td>${degreePlan.name}</td>
					<td>${degreePlan.studentId}</td>
					<td>${degreePlan.email}</td>
					<td>${degreePlan.degreePlanStatus}</td>
					<td><input type="button" class="btn btn-primary viewDP" value = "View Degree Plan" id="${theCount.count}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<script>
$('.viewDP').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("receivedDegreePlansTable").rows[id].innerHTML;
	var receivedName = requestRow.split(">",4);
	var sName = receivedName[1].split("<",1);
	var studentId = receivedName[3].split("<",1);
	$.post('receivedDegreePlan', { sN: sName, sId : studentId}, 
    function(result){
         $('#toChange').html(result);
	});
});
</script>
<%@ include file="../common/footer.jspf"%>