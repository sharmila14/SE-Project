<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$('.deleteRequest').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("sentRequestTable").rows[id].innerHTML;
	var requestedRow = requestRow.split(">",14);
	var pEmail = requestedRow[9].split("<",1);
	var sName = requestedRow[11].split("<",1);
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
	            window.location.href="/dpa/studenthome";
	        },
	        error: function (result) {
	        	window.location.href="/dpa/studenthome";
	        }
	    });
	 });
</script>
<div class="container">
	<table class="table table-striped" id="sentRequestTable">
		<h4 align="center">Sent Requests</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sentRequests}" var="sentRequest" varStatus="theCount">
				<tr>
					<td class="name">${sentRequest.professorName}</td>
					<td class="name">${sentRequest.requestStatus}</td>
					<td><a type="button" class="btn btn-warning deleteRequest" id="${theCount.count}">Delete Request</a></td>
					<td class="name" style="visibility:hidden;">${sentRequest.professorEmail}</td>
					<td class="name" style="visibility:hidden;">${sentRequest.userName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
