<form name ="studentAdvisoryRequestForm" action="/dpa/sendrequest" class="form-horizontal" onSubmit="return validate()" method="POST">
	<div class="form-group">
		<h4 style="text-align:center;">
			<strong>Advisor Request Form</strong>
		</h4>
	</div>
			
	<div class="form-group">
	<label class="control-label col-sm-4" for="userName">Name
	</label>
		<div class="col-sm-4">
			<input type="text" class="form-control field" id="userName"
			name="userName" placeholder="Enter Name" onblur="validateName()" required>
			<span id="errorNameSize" style="color:red"></span>
			<span id="errorNameContent" style="color:red"></span>
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-4" for="professorName">Professor Name
	</label>
		<div class="col-sm-4">
			<input type="text" class="form-control field" id="professorName"
			name="professorName" placeholder="Enter ProfessorName" onblur="validateName()" required>
			<span id="errorNameSize" style="color:red"></span>
			<span id="errorNameContent" style="color:red"></span>
		</div>
	</div>
	<input type="text" class="form-control field" id="professorEmail"
	name="professorEmail" placeholder="Enter professorEmail" onblur="validateName()" style="display:none" required>
	<div class="form-group">
	<label class="control-label col-sm-4" for="department">Department
	</label>
		<div class="col-sm-4">
			<select class="form-control field" id ="department" name="department">
			  <option value="Select">Select</option>
			  <option value="CS">Computer Science</option>
			  <option value="CE">Computer Engineering</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="admissionSemester">Term/Year
		</label>
		<div class="col-sm-2">
			<select class="form-control field" id ="admissionSemester" name="admissionSemester">
			  <option value="Select">Select</option>
			  <option value="fall">Fall</option>
			  <option value="spring">Spring</option>
			  <option value="summer">Summer</option>
			 </select>
		</div>
		<div class="col-sm-2">
		<input type="number" class="form-control field"   id="admissionYear" name="admissionYear" placeholder="year" onblur="validateYear()" required/>
		<span id="errorYearContent" style="color:red"></span>
		</div>
	</div>
    <div class="form-group">
	<label class="control-label col-sm-4" for="message">Message
	</label>
		<div class="col-sm-4">
			<textarea name="message" class="form-control field" id="message" placeholder="Enter message to professor" cols="40" rows="5" onblur="validateMessage()"  required></textarea>
			<span id="errorMessageContent" style="color:red"></span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-4">
			<input type="submit" value="submit" class="btn btn-default" />
		</div>
	</div>
</form>
<script>
var	var1=false;
var var2=false;
var var3=false;
function validate(){
	 return (var1 && var2 && var3 )
}
function validateName() {
	var studentName=document.forms["studentAdvisoryRequestForm"]["userName"].value;
	if(studentName.length > 20 || studentName.length <5 ){  
	    document.getElementById("errorNameSize").innerHTML = "Name should be 5 to 20 characters length ";
  		document.forms["studentAdvisoryRequestForm"]["studentName"].value="";
  	     var1= false;
		}else{
 		document.getElementById("errorNameSize").innerHTML = "";
		if (!(/[A-Za-z]+/).test(JSON.stringify(studentName))) {
		 document.getElementById("errorNameContent").innerHTML = "Please use Alphabet";
		  document.forms["studentAdvisoryRequestForm"]["studentName"].value="";
		  var1= false;
		    }
		else{
			 document.getElementById("errorNameSize").innerHTML = "";
		     document.getElementById("errorNameContent").innerHTML = "";
			var1= true;	    	
		    } 
}
	
}
function validateYear() {
	var studentYear = document.forms["studentAdvisoryRequestForm"]["admissionYear"].value;
if((Number(studentYear) < 2000) || (Number(studentYear) > 2999)){
	var2=false;
	  document.forms["studentAdvisoryRequestForm"]["year"].value="";
	 document.getElementById("errorYearContent").innerHTML = "Enter valid year";
}else{
	 document.getElementById("errorYearContent").innerHTML = "";
	var2=true;
}
	
}
function validateMessage() {
	
	var studentMessage =document.forms["studentAdvisoryRequestForm"]["message"].value;
	
	if (!(/[A-Za-z0-9_.,/]+/).test(JSON.stringify(studentMessage))) {
		 document.getElementById("errorMessageContent").innerHTML = "Please use valid characters.The valid charaters are alphabets,numbers, _ . , /";
		  document.forms["studentAdvisoryRequestForm"]["studentName"].value="";
		  var3= false;
		    }else{
			 document.getElementById("errorMessageContent").innerHTML = "";
		    var3= true;
		    }
}
</script>

