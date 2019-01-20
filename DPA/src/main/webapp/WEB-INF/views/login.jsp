<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/header.jspf"%>

										<!-- login page -->
<div class="container" id="toChange">

		<form name="loginForm" action="/dpa/login" class="form-horizontal" method="POST" >
			<div align = "center">
				<font color="green">${succ}</font>
			</div>
			<div class="form-group">
				<h3 style="text-align:center;">
					<strong>Login</strong>
				</h3>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="userName">UserName
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="userName"
						name="userName" placeholder="Enter UserName" required onblur="validateUserName()">
				 		<span id="errorUserNameContent" style="color:red"></span>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="password">Password</label>
				<div class="col-sm-4">
					<input type="Password" class="form-control field" id="password"
						name="password" placeholder="Enter password" onblur="validatePassword()" required>
						<span id="errorPasswordContent" style="color:red"></span>
				</div>
			</div>
			
			<div class="form-group">
			<label class="control-label col-sm-4" style="font-size:18px" for="role">role</label>
				<div class="col-sm-4">
					<select class="form-control field" id ="role" name="role">
					  <option value="admin">Admin</option>
					  <option value="student">Student</option>
					  <option value="professor">Professor</option>
					  <option value="chair">Chair</option>
					  <option value="associateChair">Associate Chair</option>
					  <option value="adminspecialist">Admin Specialist</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<input type="submit" value="login" class="btn btn-default" />
				</div>
			</div>
			
			<div align = "center">
				<a href="register">NewUser? Register</a>
			</div>
			<div align = "center">
				<a href="#">Forgot Password</a>
			</div>
			<div align = "center">
				<font color="red">${errorMsg}</font>
			</div>
		</form>

</div>

<script>
	var	var1=false;
	var var2=false;
	function validate(){
 		return (var1 && var2 )
	}
	function validateUserName(){
		var usename =document.forms["loginForm"]["userName"].value;	
	 		if ((!(/[A-Za-z0-9_]+/).test(JSON.stringify(usename)))&&(usename!="") ) {
				document.getElementById("errorUserNameContent").innerHTML = "Username should not contain special characters";
	 			document.forms["loginForm"]["userName"].value="";
	 			var1= false;
	 		}
	 		else{
				document.getElementById("errorUserNameContent").innerHTML = "";
	 			var1= true;	    	
	 		} 
		}
	 
	function validatePassword() {
		var pwd = document.forms["loginForm"]["password"].value;
        var patternpass=/[A-Za-z0-9]+/;
		if((! patternpass.test(JSON.stringify(pwd)))&&(pwd!="")){
			document.getElementById("errorPasswordContent").innerHTML = "Password should not contain special characters";
		 	document.forms["loginForm"]["Password"].value="";
		  	var2= false;
		  }else{
			document.getElementById("errorPasswordContent").innerHTML = "";
		 	var2= true;
		 }
   	}
	
</script>

<%@ include file="../common/footer.jspf"%>