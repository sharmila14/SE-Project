<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" id="dPView">
	<form name="viewDegreePlan"  action="/dpa/submitToAS" class="form-horizontal" onsubmit="" method="POST">
		<input type="text" name = "sName" id= "sName" value = "${degreePlan.name}" style="visibility:hidden" required>
		<input type="text" name = "studentId" id= "sId" value = "${degreePlan.studentId}" style="visibility:hidden" required>
		<div align = "center">
			<font color="green">${success}</font>
		</div>
		<div align = "center">
			<font color="red">${error}</font>
		</div>
		<div class="form-group">
			<h4 style="text-align:center;">
			<strong>Master's Degree Plan</strong><br>
			<strong>Department of Computer Science And Engineering </strong>		
			</h4>
		</div>
		<table class="table table-striped" id="receivedDPTable">
		<tbody>
				<tr>
					<td colspan="2">Name: ${degreePlan.name}</td>
					<td colspan="2">Student ID: ${degreePlan.studentId}</td>
				</tr>
				<tr>
					<td colspan="4">Local Address: ${degreePlan.localAddress}</td>
				</tr>
				<tr>
					<td colspan="4">E Mail Address: ${degreePlan.email}</td>
				</tr>
				<tr>
					<td colspan="2">Degree To Be Earned: ${degreePlan.degree}</td>
					<td colspan="2">Major: ${degreePlan.major}</td>
				</tr>
				<tr>
					<td colspan="2">Minor: ${degreePlan.minor}</td>
					<td colspan="2">Interest Area: ${degreePlan.interestArea}</td>
				</tr>
				<tr>
					<td colspan="2">Major Professor (Must be a CSE faculty): ${degreePlan.majorProfessor}</td>
					<td colspan="2">Co-Major Professor: ${degreePlan.coMajorProfessor}</td>
				</tr>
				<tr>
					<td>Most recent GRE scores: Verbal: ${gre.verbal}</td>
					<td>Quantitative: ${gre.quantitative}</td>
					<td>Analytical: ${gre.analytical}</td>
					<td>Date Taken: ${gre.dateTaken}</td>
				</tr>
		</tbody>
	</table>		
	<div class="form-group">
		<h4 style="text-align:center;">
		<strong>Core Courses (Must make an A or B)</strong><br>
		</h4>
	</div>	
	<table class="table table-striped" id="viewCoreCourses">
	<thead>
		<tr>
			<th>Course Prefix, Number and Title</th>
			<th>Semester Taken</th>
			<th>C. Hrs</th>
			<th>Grade</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${courses}" begin="0" end="3" var="course">
			<tr>
				<td class = "col-sm-6">${course.course}</td>
				<td>${course.semesterTaken}</td>
				<td>${course.cHrs}</td>
				<td>${course.grade}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<div class="form-group">
		<h4 style="text-align:center;">
		<strong>Supporting Courses</strong><br>
		</h4>
	</div>	
	<table class="table table-striped" id="viewOptionalCourses">
		<thead>
			<tr>
				<th>Course Prefix, Number and Title</th>
				<th>Semester Taken</th>
				<th>C. Hrs</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courses}" begin="4" end="11" var="course">
				<tr>
					<td class = "col-sm-6">${course.course}</td>
					<td>${course.semesterTaken}</td>
					<td>${course.cHrs}</td>
					<td>${course.grade}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table class="table table-striped" id="r1DPTable">
		<tbody>
			<tr>
				<td colspan="2">Admission to candidacy is recommended: </td>
				<td colspan="2">Total Semester Hours Requires: ${degreePlan.totalCreditHours}</td>
			</tr>
		</tbody>
	</table>
	<table class="table table-striped" id="r2DPTable">
		<tbody>
			<tr>
				<td colspan="4">Advisor or Major Professor: ${degreePlan.professorSignature}</td>
			</tr>
		</tbody>
	</table>
	<div class="form-group">
	<label class = "col-sm-1" for="sign" id="signLabel" style="visibility:hidden">Signature</label>
		<div class = "col-sm-11">
			<input type="text" class="form-control field" id="sign"
				name="sign" placeholder="Please type Full Name" style="visibility:hidden" required>
		</div>
	</div>
	<div class="col-sm-4">
		<input type="submit" value="Approve" class="btn btn-primary btn-block" id="acceptDP" style="visibility:hidden" />
	</div>
	</form>
	<div class="form-group">
		<div>
			<input type="submit" value="Accept DegreePlan" class="btn btn-default" id="acceptDegreePlan" onclick="signDP()"/>
			<input type="submit" value="Reject DegreePlan" class="btn btn-default" id="rejectDegreePlan" onclick="rejectDP()"/>
		</div>
	</div>
</div>
</div>

<div class="footer">
	<div class="container-fluid footer1"><h5 style = "text-align:center;">&#169; 2018 SHAN CSCE UNT</h5></div>
	<div class="container-fluid footer2"><h5 style = "text-align:center;">Contact Us: +1 xxx-xxx-xxxx</h5></div>
</div>
<script>
function signDP(){
	document.getElementById("sign").style.visibility = "visible";
	document.getElementById("signLabel").style.visibility = "visible";
	document.getElementById("acceptDegreePlan").style.visibility = "hidden";
	document.getElementById("rejectDegreePlan").style.visibility = "hidden";
	document.getElementById("acceptDP").style.visibility = "visible";
}
function rejectDP(){
	var sName = document.getElementById("sName").value;
	$.post('rejectDP', {studentName : sName},
	    function(result){
	         $('#toChange').html(result);
		});
}
</script>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>