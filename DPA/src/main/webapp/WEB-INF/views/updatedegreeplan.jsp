<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
		<form name="degreePlanForm"  action="/dpa/updatedegreeplan" class="form-horizontal" onsubmit="return validate()" method="POST">
			<div align = "center">
				<font color="green">${success}</font>
			</div>
			<div align="center"><font color="red">${error}</font></div>
			<div class="form-group">
				<h4 style="text-align:center;">
				<strong>Master's Degree Plan</strong><br>
				<strong>Department of Computer Science And Engineering </strong>		
				</h4>
			</div>
			
			                                    <!-- name -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Name">Name
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="name"
						name="name"  value = "${degreePlan.name}" required>
				</div>
				<label class="control-label col-sm-2" for="Student_Id">Student ID (EMP ID)
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="Student_Id"
						name="studentId"  value="${degreePlan.studentId}" required>
				</div>
			</div>
			
			                                <!-- localaddress -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Student_Addr">Local Address
				</label>
				<div class="col-sm-10">
					<input type="text" class="form-control field" id="Student_Addr"
						name="localAddress" value="${degreePlan.localAddress}" required>
				</div>
			</div>
			
			
			                                   <!-- email -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Student_Mail">UNT Email ID
				</label>
				<div class="col-sm-10">
					<input type="email" class="form-control field" id="Student_Mail"
						name="email" value="${degreePlan.email}" required>
				</div>
			</div>
			
			                              <!-- degree to be earned -->
			                                     <!-- major -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="degreeToBeEarned">Degree To Be Earned</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="degree"
						name="degree" value="M.S" required>
				</div>
				<label class="control-label col-sm-1" for="major">Major</label>
				<div class="col-sm-5">
					<input type="text" class="form-control field" id="major"
						name="major" value="${degreePlan.major}" required>
				</div>
			</div>
			
			                               <!-- Interest Area -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="minor">Minor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="minor"
						name="minor" value="${degreePlan.minor}" required>
				</div>
				<label class="control-label col-sm-2" for="Specialization">Interest Area
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="Specialization"
						name="interestArea" value="${degreePlan.interestArea}" required>
				</div>
			</div>
			                                 <!-- Major Professor -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="majorProf">Major Professor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="majorProf"
						name="majorProfessor" value="${degreePlan.majorProfessor}" required>
				</div>
				<label class="control-label col-sm-2" for="co_major_prof">Co-Major Professor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="coMajorProf"
						name="coMajorProfessor" value="${degreePlan.coMajorProfessor}" required>
				</div>
			</div>
			 <!-- gre  -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="gre_score">Most Recent GRE Scores: 
				</label>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_verbal"
						name="gre.verbal" value="${gre.verbal}"  min="130" max="170" required>
				</div>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_quant"
						name="gre.quantitative" value="${gre.quantitative}"  min="130" max="170" required>
				</div>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_analytical"
						name="gre.analytical" value="${gre.analytical}"  min="2" max="6" required>
				</div>
				<label class="control-label col-sm-1" for="gre_date">Date Taken:  
				</label>
				<div class="col-sm-3">
					<input type="text" class="form-control field" id="gre_date"
						name="gre.dateTaken" value="${gre.dateTaken}"  required>
				</div>
			</div>
			
			                                     <!--course A  -->
			<div class="form-group">
				<h4 align = "center">
				<strong>Please select Core Courses</strong>
				</h4>
		   </div>
			
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_A">Core Course A</label>
				<div class="col-sm-3">
				<c:forEach items="${courses}" begin="0" end="0" var="course">
					<input type="text" class="form-control" id ="sublist_a" name="courseA.course" value="${course.course}"/>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<input type="text" class="form-control field" id ="semes" name="courseA.semesterTaken" value="${course.semesterTaken}"/>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseA.cHrs" value="${course.cHrs}" required>
				</div>
				<label class="control-label col-sm-1" for="grade_ae">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_a"
						name="courseA.grade" value="${course.grade}"   required>
				</div>
				</c:forEach>
			</div>
			
											<!-- core course B -->
		<div class="form-group">
			<label class="control-label col-sm-2" for="sub_B">Core Course B</label>
				<div class="col-sm-3">
				<c:forEach items="${courses}" begin="1" end="1" var="course">
					<input type="text" class="form-control" id ="sublist_b" name="courseB.course" value="${course.course}"/>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<input type="text" class="form-control field" id ="semes" name="courseB.semesterTaken" value="${course.semesterTaken}"/>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseB.cHrs" value="${course.cHrs}" required>
				</div>
				<label class="control-label col-sm-1" for="grade_ae">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_a"
						name="courseB.grade" value="${course.grade}"   required>
				</div>
				</c:forEach>
			</div
			
											<!-- core course C -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_C">Core Course C</label>
				<div class="col-sm-3">
				<c:forEach items="${courses}" begin="2" end="2" var="course">
					<input type="text" class="form-control" id ="sublist_c" name="courseC.course" value="${course.course}"/>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<input type="text" class="form-control field" id ="semes" name="courseC.semesterTaken" value="${course.semesterTaken}"/>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseC.cHrs" value="${course.cHrs}" required>
				</div>
				<label class="control-label col-sm-1" for="grade_ae">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_a"
						name="courseC.grade" value="${course.grade}"   required>
				</div>
				</c:forEach>
			</div>
											<!-- Core course D -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_D">Core Course D</label>
				<div class="col-sm-3">
				<c:forEach items="${courses}" begin="3" end="3" var="course">
					<input type="text" class="form-control" id ="sublist_d" name="courseD.course" value="${course.course}"/>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<input type="text" class="form-control field" id ="semes" name="courseD.semesterTaken" value="${course.semesterTaken}"/>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseD.cHrs" value="${course.cHrs}" required>
				</div>
				<label class="control-label col-sm-1" for="grade_ae">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_a"
						name="courseD.grade" value="${course.grade}"   required>
				</div>
				</c:forEach>
			</div>
			                              <!-- optional courses -->
			<div class="form-group">
				<h4 align = "center">
				<strong>Please select Optional Courses</strong>
				</h4>
		   </div>
			<c:forEach items="${courses}" begin="4" end="11" var="course" varStatus="theCount">
				<div class="form-group">
				<label class="control-label col-sm-2">Optional Course ${theCount.count}</label>
					<div class="col-sm-3">
						<input type="" class="form-control field" id ="optionalCourse" name="opCourse${theCount.count}.course" value="${course.course}"/>
					</div>
					<label class="control-label col-sm-1" for="semes">semester taken</label>
					<div class="col-sm-2">
						<input type="text" class="form-control field" id ="semes" name="opCourse${theCount.count}.semesterTaken" value="${course.semesterTaken}"/>
					</div>
					<label class="control-label col-sm-1" for="cHrs">C. Hrs
					</label>
					<div class="col-sm-1">
						<input type="text" class="form-control field" id="cHrs"
							name="opCourse${theCount.count}.cHrs" value="${course.cHrs}" required>
					</div>
					<label class="control-label col-sm-1" for="grade_d">Grade
					</label>
					<div class="col-sm-1">
						<input type="text" class="form-control field" id="grade_d"
							name="opCourse${theCount.count}.grade" value="${course.grade}"   >
					</div>
				</div>
			</c:forEach>
			                                     
										<!-- this column is not displayed-->
			<div class="form-group">
				<label class="control-label col-sm-2" for="sem_hrs">Total Semester Hours
				</label>
				<div class="col-sm-10">
					<input type="number" class="form-control field" id="sem_hrs"
						name="totalCreditHours" value="${degreePlan.totalCreditHours}"  min="32" max="36" required>
				</div>
			</div>			

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<input type="submit" value="Save" name = "act" class="btn btn-primary btn-block" />
				</div>
				<div class="col-sm-offset-2 col-sm-2">
					<input type="submit" value="Update and Resubmit" name = "act" class="btn btn-primary btn-block" />
				</div>
			</div>
		</form>
</div>

<div class="footer">
	<div class="container-fluid footer1"><h5 style = "text-align:center;">&#169; 2018 SHAN CSCE UNT</h5></div>
	<div class="container-fluid footer2"><h5 style = "text-align:center;">Contact Us: +1 xxx-xxx-xxxx</h5></div>
</div>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>