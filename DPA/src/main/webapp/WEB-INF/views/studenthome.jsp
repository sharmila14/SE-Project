<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toChange">
	<div class="container" id="myAdvisor">
		<table class="table table-striped" id="requestTable">
			<h4 align="center">My Advisor</h4>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${myAdvisors}" var="myAdvisor" varStatus="theCount">
					<tr>
						<td id="profName">${myAdvisor.professorName}</td>
						<td>${myAdvisor.professorEmail}</td>
						<td><input type="button" class="btn btn-primary sendMessage" value = "Send Message" id="${theCount.count}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container form-group"><h4>My Degree Plan</h4></div>
	<div class="container form-group">
		<input type="submit" value="Start New Degree Plan" style = "background-color:#e6ffb3" class="btn btn-default col-sm-4" onclick="selectForm();" />
		<form action="/dpa/degreeplan" method = "POST">
			<div class="col-sm-4 degreePlan" id="degreePlan" style="visibility:hidden;">
			<select class="form-control field selectPlan" id ="selectDegreePlan"  name="selectPlan" style = "background-color:#e6ffb3" onchange="this.form.submit()">
			  <option value="Select">Select</option>
			  <option value="computerScience">Computer Science</option>
			  <option value="computerEngineering">Computer Engineering</option>
			</select>
			</div>
			<c:forEach items="${myAdvisors}" var="myAdvisor" varStatus="theCount">
				<input type="text" class="form-control field" name="majProfessor" value="${myAdvisor.professorName}" style="visibility:hidden;">
			</c:forEach>
		</form>
		<form action="/dpa/viewDPStatus" method = "POST">
		<input type="submit" value="Degree Plan Status" style = "background-color:#e6ffb3" class="btn btn-default col-sm-4"/>
		<p class = "col-sm-offset-1 col-sm-2" id="degreePStatus">${degreePlanStatus}</p>
		<p class = "col-sm-4" id="viewComments">${rejectComments} 
		<input type="text" class="form-control field" name="majorProfessor" value="${myAdvisor.professorName}" style="visibility:hidden;">
		</form>
		<form id="updateDP" action="/dpa/updateDegreePlan" method="POST"><a href="#" onclick="document.getElementById('updateDP').submit();">${resubmitDP}</a>
		</form>
		</form>
	</div>
	<div class="col-sm-offset-5 col-sm-4">
		<form id="downloadDP" action="/dpa/viewApprovedDP" method="POST"><a href="#" onclick="document.getElementById('downloadDP').submit();">${downloadDP}</a>
			</form>
	</div>
</div>

<script>
	function selectForm(){
		$("#degreePlan").css("visibility", "visible");
	}
	function viewdpStatus(){
		$("#degreePStatus").css("visibility", "visible");
	}
</script>

<%@ include file="../common/footer.jspf"%>