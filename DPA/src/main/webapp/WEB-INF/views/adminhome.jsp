<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminheader.jspf"%>

<div class="container-fluid" id="toChange">
	<div class="col-sm-4 applyBox">
		<h4 align="center">Manage Users</h4><br/>
		<select class="form-control field openSelectBox" id ="manageUsers" name="manageUsers" onchange="callController();">
		  <option value="Select">Select</option>
		  <option value="ManageChair">Manage Chair</option>
		  <option value="ManageAssociateChair">Manage Associate Chair</option>
		  <option value="ManageStudents/Professors">Manage Students/Professors</option>
		  <option value="ManageAdminSpecialist">Manage Admin Specialist</option>
		</select>
	</div>
	<form action="/dpa/approveUsers" class="form-horizontal" method="GET">
	<div class="col-sm-offset-1 col-sm-4">
		<input type="submit" value="Verify and Approve Students/Professors" class="btn btn-block btn-primary" />
	</div>
	</form>
	<br/><br/><br/><br/><br/><br/><br/>
	<div class="col-sm-4">
		<input type="submit" value="DELETE" id = "unhide2" name = "delete" class="btn  btn-block btn-warning" style="display: none;" />
	</div><br/><br/>
	<div class="col-sm-4">
		<input type="submit" value="UPDATE" id = "unhide3" name = "update" class="btn btn-block btn-info" style="display: none;" />
	</div><br/><br/>
	<form action="/dpa/adduser" class="form-horizontal" method="GET">
	<div class="col-sm-4">
		<input type="submit" value="ADD" id = "unhide1" name = "add" class="btn btn-block btn-success" style="display: none;"/>
	</div>
	</form>
</div>

<script>
function callController(){
	var selectBox = document.getElementById("manageUsers");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if(selectedValue == "ManageChair" || selectedValue == "ManageAssociateChair" || selectedValue == "ManageAdminSpecialist"){
    	var selectedValue = selectedValue.replace('Manage','');
    	document.getElementById("unhide1").style.display='block';
    	document.getElementById("unhide1").value = "ADD " + selectedValue;
    	document.getElementById("unhide2").style.display='block';
    	document.getElementById("unhide2").value = "DELETE " + selectedValue;
    	document.getElementById("unhide3").style.display='block';
    	document.getElementById("unhide3").value = "UPDATE " + selectedValue;
    }else{
        var selectedValue = selectedValue.replace('Manage','');
    	document.getElementById("unhide1").style.display='none';
    	document.getElementById("unhide2").style.display='block';
    	document.getElementById("unhide2").value = "DELETE " + selectedValue;
    	document.getElementById("unhide3").style.display='block';
    	document.getElementById("unhide3").value = "UPDATE " + selectedValue;
    }
}
	window.onload = function () {
        document.getElementById("manageUsers").click();
    };
</script>

<%@ include file="../common/footer.jspf"%>