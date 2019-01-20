<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
		<form name="degreePlanForm"  action="/dpa/degreeplanform" class="form-horizontal" onsubmit="return validate()" method="POST">
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
						name="name" placeholder="Enter Name" required>
				</div>
				<label class="control-label col-sm-2" for="Student_Id">Student ID (EMP ID)
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="Student_Id"
						name="studentId" placeholder="Enter ID" required>
				</div>
			</div>
			
			                                <!-- localaddress -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Student_Addr">Local Address
				</label>
				<div class="col-sm-10">
					<input type="text" class="form-control field" id="Student_Addr"
						name="localAddress" placeholder="Enter Address" required>
				</div>
			</div>
			
			
			                                   <!-- email -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Student_Mail">UNT Email ID
				</label>
				<div class="col-sm-10">
					<input type="email" class="form-control field" id="Student_Mail"
						name="email" placeholder="Email ID" required>
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
						name="major" value="${major}" required>
				</div>
			</div>
			
			                               <!-- Interest Area -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="minor">Minor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="minor"
						name="minor" placeholder="Please enter minor" required>
				</div>
				<label class="control-label col-sm-2" for="Specialization">Interest Area
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="Specialization"
						name="interestArea" placeholder="Enter specialization" required>
				</div>
			</div>
			                                 <!-- Major Professor -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="majorProf">Major Professor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="majorProf"
						name="majorProfessor" placeholder="Enter Major Professor Name" value = "${majorProfessor}" required>
				</div>
				<label class="control-label col-sm-2" for="co_major_prof">Co-Major Professor</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="coMajorProf"
						name="coMajorProfessor" placeholder="Enter Co-Major Professor Name" required>
				</div>
			</div>
			 <!-- gre  -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="gre_score">Most Recent GRE Scores: 
				</label>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_verbal"
						name="gre.verbal" placeholder="Verbal"  min="130" max="170" required>
				</div>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_quant"
						name="gre.quantitative" placeholder="Quantitative"  min="130" max="170" required>
				</div>
				<div class="col-sm-2">
					<input type="number" class="form-control field" id="gre_analytical"
						name="gre.analytical" placeholder="Analytical"  min="2" max="6" required>
				</div>
				<label class="control-label col-sm-1" for="gre_date">Date Taken:  
				</label>
				<div class="col-sm-3">
					<input type="date" class="form-control field" id="gre_date"
						name="gre.dateTaken" placeholder="Date taken"  required>
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
					<select class="form-control" id ="sublist_a" name="courseA.course">
    						<option value="select" selected>select</option>
							 <c:forEach items="${groupACourses}" var="groupACourse">
						          <option value="${groupACourse.courseName}">${groupACourse.courseName}</option>
						    </c:forEach>
					</select>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<select class="form-control field" id ="semes" name="courseA.semesterTaken">
					  <option value="Select">Select</option>
					  <option value="Fall">Fall</option>
					  <option value="spring">Spring</option>
					   <option value="summer">Summer</option>
					</select>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseA.cHrs" placeholder="C. Hrs" required>
				</div>
				<label class="control-label col-sm-1" for="grade_ae">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_a"
						name="courseA.grade" placeholder="grade"   required>
				</div>
				
			</div>
			
												<!--course B  -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_B">Core Course B</label>
				<div class="col-sm-3">
					<select class="form-control field" id ="sublist_b" name="courseB.course">
    						<option value="select" selected>select</option>
							 <c:forEach items="${groupBCourses}" var="groupBCourse">
						          <option value="${groupBCourse.courseName}">${groupBCourse.courseName}</option>
						    </c:forEach>
					</select>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<select class="form-control field" id ="semes" name="courseB.semesterTaken">
					  <option value="Select">Select</option>
					  <option value="Fall">Fall</option>
					  <option value="spring">Spring</option>
					   <option value="summer">Summer</option>
					</select>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseB.cHrs" placeholder="C. Hrs" required>
				</div>
				<label class="control-label col-sm-1" for="grade_b">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_b"
						name="courseB.grade" placeholder="grade"   >
				</div>
			</div>
			
											<!--course c  -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_c">Core Course C</label>
				<div class="col-sm-3">
					<select class="form-control field" id ="sublist_c" name="courseC.course">
    						<option value="select" selected>select</option>
							 <c:forEach items="${groupCCourses}" var="groupCCourse">
						          <option value="${groupCCourse.courseName}">${groupCCourse.courseName}</option>
						    </c:forEach>
					</select>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<select class="form-control field" id ="semes" name="courseC.semesterTaken">
					  <option value="Select">Select</option>
					  <option value="Fall">Fall</option>
					  <option value="spring">Spring</option>
					   <option value="summer">Summer</option>
					</select>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseC.cHrs" placeholder="C. Hrs" required>
				</div>
				<label class="control-label col-sm-1" for="grade_c">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_c"
						name="courseC.grade" placeholder="grade"   >
				</div>
			</div>
			
			
												<!--course D  -->
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_D">Core Course D</label>
				<div class="col-sm-3">
					<select class="form-control field" id ="sublist_d" name="courseD.course">
    						<option value="select" selected>select</option>
							 <c:forEach items="${groupDCourses}" var="groupDCourse">
						          <option value="${groupDCourse.courseName}">${groupDCourse.courseName}</option>
						    </c:forEach>
					</select>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<select class="form-control field" id ="semes" name="courseD.semesterTaken">
					  <option value="Select">Select</option>
					  <option value="Fall">Fall</option>
					  <option value="spring">Spring</option>
					   <option value="summer">Summer</option>
					</select>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="courseD.cHrs" placeholder="C. Hrs" required>
				</div>
				<label class="control-label col-sm-1" for="grade_d">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_d"
						name="courseD.grade" placeholder="grade"   >
				</div>
			</div>
		
			                              <!-- optional courses -->
			<div class="form-group">
				<h4 align = "center">
				<strong>Please select Optional Courses</strong>
				</h4>
		   </div>
			<c:forEach items="${optionalCourses}" var="optionalCourse">
			<div class="form-group">
			<label class="control-label col-sm-2" for="sub_B">Optional Course ${optionalCourse}</label>
				<div class="col-sm-3">
					<select class="form-control field" id ="optionalCourse" name="opCourse${optionalCourse}.course">
    						<option value="select" selected>select</option>
							 <c:forEach items="${optionalCourseLists}" var="optionalCourseList">
						          <option value="${optionalCourseList}">${optionalCourseList}</option>
						    </c:forEach>
					</select>
				</div>
				<label class="control-label col-sm-1" for="semes">semester taken</label>
				<div class="col-sm-2">
					<select class="form-control field" id ="semes" name="opCourse${optionalCourse}.semesterTaken">
					  <option value="Select">Select</option>
					  <option value="Fall">Fall</option>
					  <option value="spring">Spring</option>
					   <option value="summer">Summer</option>
					</select>
				</div>
				<label class="control-label col-sm-1" for="cHrs">C. Hrs
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="cHrs"
						name="opCourse${optionalCourse}.cHrs" placeholder="C. Hrs" required>
				</div>
				<label class="control-label col-sm-1" for="grade_d">Grade
				</label>
				<div class="col-sm-1">
					<input type="text" class="form-control field" id="grade_d"
						name="opCourse${optionalCourse}.grade" placeholder="grade"   >
				</div>
			</div>
			</c:forEach>
			                                     
										<!-- this column is not displayed-->
			<div class="form-group">
				<label class="control-label col-sm-2" for="sem_hrs">Total Semester Hours
				</label>
				<div class="col-sm-10">
					<input type="number" class="form-control field" id="sem_hrs"
						name="totalCreditHours" placeholder="Enter total semester hours"  min="32" max="36" required>
				</div>
			</div>			

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<input type="submit" value="Save" name = "act" class="btn btn-primary btn-block" />
				</div>
				<div class="col-sm-offset-2 col-sm-2">
					<input type="submit" value="submit" name = "act" class="btn btn-primary btn-block" />
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