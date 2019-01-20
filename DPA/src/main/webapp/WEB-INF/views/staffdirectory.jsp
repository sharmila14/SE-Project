<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$('.sendRequest').click(function(){
	var id = $(this).attr('id');
	var professorRow = document.getElementById("professorTable").rows[id].innerHTML;
	var profArray = professorRow.split(">",4);
	var professorName = profArray[1].split("<",1);
	var professorEmail = profArray[3].split("<",1);
	$.ajax({
        type: "GET",
        url: "sendrequest",
        success: function (result) {
            $("#toPlaceAdvisorForm").html(result);
            document.getElementById("professorName").value = professorName;
            document.getElementById("professorEmail").value = professorEmail;
        },
        error: function (result) {
            // do something.
        }
    });
	});
</script>
<div class="container" id="toPlaceAdvisorForm">
	<table class="table table-striped" id="professorTable">
		<h4 align="center">CSCE Staff Directory</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${professors}" var="professor" varStatus="theCount">
				<tr>
					<td class="name">${professor.name}</td>
					<td id="email" class="email">${professor.email}</td>
					<td><input type="button" class="btn btn-primary sendRequest" value = "Send Request" id="${theCount.count}" /> 
						<a type="button" class="btn btn-warning" id="deleteRequest" style="visibility:hidden;">Delete Request</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

