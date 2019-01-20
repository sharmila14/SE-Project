<script>
	$('.acceptRequest').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("requestTable").rows[id].innerHTML;
	var receivedName = requestRow.split(">",20);
	var sName = receivedName[1].split("<",1);
	var sMajor = receivedName[3].split("<",1);
	var pName = receivedName[17].split("<",1);
	var pEmail = receivedName[19].split("<",1);
		var majorProfessor = {
		  "userName" :sName,
		  "professorName" :pName,
		  "professorEmail" :pEmail,
		  "studentMajor" :sMajor
	   	};
		$.ajax({
	        type: "POST",
	        url: "acceptrequest",
	        contentType : 'application/json; charset=utf-8',
      		dataType : 'json',
	        data: JSON.stringify(majorProfessor),
	        success: function (result) {
            	window.location.href="/dpa/professorhome";
	        },
	        error: function (result) {
	           window.location.href="/dpa/professorhome";
	        }
	    });
	});
	$('.rejectRequest').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("requestTable").rows[id].innerHTML;
	var requestedRow = requestRow.split(">",20);
	var sName = requestedRow[1].split("<",1);
	var pEmail = requestedRow[19].split("<",1);
	var reqData = {
		"professorEmail" : pEmail,
		"studentName" : sName
	};
	$.ajax({
	        type: "POST",
	        url: "deleterequest",
	        contentType : 'application/json; charset=utf-8',
      		dataType : 'json',
	        data: JSON.stringify(reqData),
	        success: function (result) {
		        var Backlen = history.length;
	            history.go(-Backlen);
	            window.location.href="/dpa/professorhome";
	        },
	        error: function (result) {
	            window.location.href="/dpa/professorhome";
	        }
	    });
	 });
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" id="receivedRequests">
	<table class="table table-striped" id="requestTable">
		<h4 align="center">Received Requests</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Admission Semester</th>
				<th>Admission Year</th>
				<th>Message</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${receivedRequests}" var="receivedRequest" varStatus="theCount">
				<tr>
					<td>${receivedRequest.userName}</td>
					<td>${receivedRequest.department}</td>
					<td class="col-sm-2">${receivedRequest.admissionSemester}</td>
					<td class="col-sm-2">${receivedRequest.admissionYear}</td>
					<td>${receivedRequest.message}</td>
					<td><input type="button" class="btn btn-primary acceptRequest" value = "Accept Request" id="${theCount.count}"/></td>
					<td><input type="button" class="btn btn-warning rejectRequest" value = "Reject Request" id="${theCount.count}"/></td>
					<td style="visibility:hidden;">${receivedRequest.professorName}</td>
					<td style="visibility:hidden;">${receivedRequest.professorEmail}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
