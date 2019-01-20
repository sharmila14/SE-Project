<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<div class="container" id="needApprovalList">
	<div align = "center">
		<font color="green">${success}</font>
	</div>
	<table class="table table-striped" id="toBeApprovedList">
		<h4 align="center">To Be Approved List</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${toBeApprovedUsers}" var="toBeApprovedUser" varStatus="theCount">
				<tr>
					<td class="name">${toBeApprovedUser.name}</td>
					<td id="email" class="email">${toBeApprovedUser.email}</td>
					<td id="role" class="role">${toBeApprovedUser.role}</td>
					<td><input type="button" class="btn btn-primary approveUser" value = "Approve User" id="${theCount.count}"/></td>
					<td><input type="button" class="btn btn-warning rejectUser" value = "Reject User" id="${theCount.count}"/></td>
					<td style="visibility:hidden;">${toBeApprovedUser.userName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
$('.approveUser').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("toBeApprovedList").rows[id].innerHTML;
	var receivedName = requestRow.split(">",20);
	var sName = receivedName[1].split("<",1);
	var sEmail = receivedName[3].split("<",1);
	var sRole = receivedName[5].split("<",1);
	var uName = receivedName[13].split("<",1);
	   	$.post('approveUser', { userName: uName}, 
	    function(result){
	         $('#whole').html(result);
		});
	});
	$('.rejectUser').click(function(){
	var id = $(this).attr('id');
	var requestRow = document.getElementById("toBeApprovedList").rows[id].innerHTML;
	var receivedName = requestRow.split(">",20);
	var sName = receivedName[1].split("<",1);
	var sEmail = receivedName[3].split("<",1);
	var sRole = receivedName[5].split("<",1);
	var uName = receivedName[13].split("<",1);
	   	$.post('rejectUser', { userName: uName}, 
	    function(result){
	         $('#whole').html(result);
		});
	});
</script>
<%@ include file="../common/footer.jspf"%>