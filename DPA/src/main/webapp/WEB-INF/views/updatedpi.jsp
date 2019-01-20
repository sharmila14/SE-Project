<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminspecialistheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h4 align="center"><strong>Update Degree Plan Information</strong></h4>
	<div align = "center">
		<font color="green">${success}</font>
	</div>
	<div align="center"><font color="red">${error}</font></div>
	<form name="updateDPIInfo"  action="/dpa/updateDPInfo" class="form-horizontal" onsubmit="" method="POST">
	<div class="col-sm-10">
		<textarea name="dPIInfo" class="form-control field" id="dpi" cols="40" rows="5">${dpi}</textarea>
	</div>
	<div class="col-sm-2">
		<input type="submit" value="Update" class="btn btn-primary" />
	</div>
	</form>
	<form name="updateDPICC"  action="/dpa/updateCoreCourses" class="form-horizontal" onsubmit="" method="POST">
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Computer Science Core Courses</strong></h4>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group A</i></u></strong></h5>
	<c:forEach items="${groupACourses}" var="groupACourse" varStatus="theCount">
	<input type="text" class="form-control field groupA" id="${theCount.count}"
						name="coreA${theCount.count}" value="${groupACourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group B</i></u></strong></h5>
	<c:forEach items="${groupBCourses}" var="groupBCourse" varStatus="theCount">
	<input type="text" class="form-control field groupB" id="${theCount.count}"
						name="coreB${theCount.count}" value="${groupBCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group C</i></u></strong></h5>
	<c:forEach items="${groupCCourses}" var="groupCCourse" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="coreC${theCount.count}" value="${groupCCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group D</i></u></strong></h5>
	<c:forEach items="${groupDCourses}" var="groupDCourse" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="coreD${theCount.count}" value="${groupDCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Computer Engineering Core Courses</strong></h4>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group A</i></u></strong></h5>
	<c:forEach items="${groupACoursesCE}" var="groupACourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="csCoreA${theCount.count}" value="${groupACourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group B</i></u></strong></h5>
	<c:forEach items="${groupBCoursesCE}" var="groupBCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="csCoreB${theCount.count}" value="${groupBCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group C</i></u></strong></h5>
	<c:forEach items="${groupCCoursesCE}" var="groupCCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="csCoreC${theCount.count}" value="${groupCCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group D</i></u></strong></h5>
	<c:forEach items="${groupDCoursesCE}" var="groupDCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="${theCount.count}"
						name="csCoreD${theCount.count}" value="${groupDCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-offset-5 col-sm-2">
	<h5><strong><u><i></i></u></strong></h5>
		<input type="submit" value="Update" class="btn btn-primary" />
	</div>
	</form>
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Optional Courses</strong></h4></div>
	<c:forEach items="${optionalCourseLists}" var="optionalCourseList" varStatus="theCount">
	<div class="col-sm-10">
	<input type="text" class="form-control field" id="op${theCount.count}"
					name="'optionalCourse' + theCount.index" value="${optionalCourseList}">
	</div>
	<div class="col-sm-2">
	<input type="submit" value="Delete" class="btn btn-primary toDeleteOp" id="${theCount.index}"/></div>
	</c:forEach>
	<div>
		<div class="col-sm-12">
	<h4 align="center"><strong></strong></h4></div>
	<div class="col-sm-10">
	<input type="text" class="form-control field" id="addOp"
					name="newOpCourse" placeholder="Please enter the course number and name" style="visibility:hidden">
	</div>
	<div class="col-sm-2">
	<input type="submit" value="Add" class="btn btn-primary" onclick= "addOptionalCourse()" id="add" style="visibility:hidden"/>
	</div>
	</div>
	<div col-sm-offset-5 class="col-sm-4">
	<h5><strong><u><i></i></u></strong></h5>
		<input type="submit" value="Add a Optional Course" id = "addOpCourse" onclick="addOpCourse()" class="btn btn-primary" />
	</div>
</div><br>

<div class="footer">
	<div class="container-fluid footer1"><h5 style = "text-align:center;">&#169; 2018 SHAN CSCE UNT</h5></div>
	<div class="container-fluid footer2"><h5 style = "text-align:center;">Contact Us: +1 xxx-xxx-xxxx</h5></div>
</div>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	function addOpCourse(){
		document.getElementById("add").style.visibility="visible";
		document.getElementById("addOp").style.visibility="visible";
	}
	function addOptionalCourse(){
	var courseName = document.getElementById("addOp").value;
	$.post('addOpCourse', {cName : courseName},
	    function(result){
	         $('#toChangeWhole').html(result);
		});
	}
	$('.toDeleteOp').click(function(){
		var id = $(this).attr('id');
		var newId = parseInt(id) + 1;
		var iid = "op" + newId;
		var opCourse = document.getElementById(iid).value;
		$.post('deleteOpCourse', {cName : opCourse},
	    function(result){
	         $('#toChangeWhole').html(result);
		});
	});
</script>
</body>
</html>