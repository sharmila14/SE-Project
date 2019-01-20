<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h4><strong>Degree Plan Information</strong></h4>
	<p>${dpi}</p>
	<h4><strong>Interest Areas</strong></h4>
	<div class="col-sm-6">
	<h4><strong>Computer Science</strong></h4>
	<c:forEach items="${interestareas}" begin="0" end="7" var="interestarea" varStatus="theCount">
		<a href="#" class = "interestArea" id="${theCount.count}">${interestarea.interestArea}</a></br>
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h4><strong>Computer Engineering</strong></h4>
	<c:forEach items="${interestareas}" begin="8" end="12" var="interestarea" varStatus="theCount">
	<a href="#" class = "interestAreaa" id="${theCount.index}">${interestarea.interestArea}</a></br>
	</c:forEach>
	</div>
<div>
<script>
	$('.interestArea').click(function(){
		var id = $(this).attr('id');
		var currValue = document.getElementById(id).text;
		$.post('getInterestCourses', {major : "computerScience", interest: currValue}, 
	    function(result){
	         $('#toChange').html(result);
		});
	});
	$('.interestAreaa').click(function(){
		var id = $(this).attr('id');
		var rId = parseInt(id) + 1;
		var currValue = document.getElementById(id).text;
		$.post('getInterestCourses', {major : "CE", interest: currValue}, 
	    function(result){
	         $('#toChange').html(result);
		});
	});
</script>