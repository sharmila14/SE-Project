<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h4 id="headingText" align="center"><strong>Interest in ${interest}</strong></h4>
	<h4 id="headingText" align="center"><strong><i>Advising Sheet</i></strong></h4>
	<h5 align="center"><strong>Computer Science master’s students are required to take one course
	from each of the four groups listed below.</strong></h3>
	<div class="col-sm-6">
	<h5 id="headingText"><strong><i><u>Group "A"</u></i></strong></h5>
		<ol>
		<c:forEach items="${groupACourses}" var="groupACourse" varStatus="theCount">
		  <li>${groupACourse.courseName}</li>
		</c:forEach>
		</ol>
	</div>
	<div class="col-sm-6">
	<h5 id="headingText"><strong><i><u>Group "B"</u></i></strong></h5>
		<ol>
		<c:forEach items="${groupBCourses}" var="groupBCourse" varStatus="theCount">
		  <li>${groupBCourse.courseName}</li>
		</c:forEach>
		</ol>
	</div>
	<div class="col-sm-6">
	<h5 id="headingText"><strong><i><u>Group "C"</u></i></strong></h5>
		<ol>
		<c:forEach items="${groupCCourses}" var="groupCCourse" varStatus="theCount">
		  <li>${groupCCourse.courseName}</li>
		</c:forEach>
		</ol>
	</div>
	<div class="col-sm-6">
	<h5 id="headingText"><strong><i><u>Group "D"</u></i></strong></h5>
		<ol>
		<c:forEach items="${groupDCourses}" var="groupDCourse" varStatus="theCount">
		  <li>${groupDCourse.courseName}</li>
		</c:forEach>
		</ol>
	</div>
	<div>
	<h4 id="headingText" color="green"><strong><i><u>Suggested Courses:</u></i></strong></h4>
		<ol>
		<c:forEach items="${optionalCourseLists}" var="optionalCourseList" varStatus="theCount">
		  <li class="col-sm-8">${optionalCourseList}</li><div class = "col-sm-4">3 sch</div>
		</c:forEach>
		</ol>
	</div>
</div>