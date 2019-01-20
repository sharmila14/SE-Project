<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" id="staff">
	<table class="table table-striped" id="requestTable">
		<h4 align="center">Student List</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${staffLists}" var="staffList" varStatus="theCount">
				<tr>
					<td>${staffList.name}</td>
					<td>${staffList.email}</td>
					<td>${staffList.role}</td>
					<td><input type="button" class="btn btn-primary sendMessage" value = "Send Message" id="${theCount.count}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
