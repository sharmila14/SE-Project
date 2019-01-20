<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/header.jspf"%>
<div class="container register">
		<form name="registerForm"  action="/dpa/register" class="form-horizontal" onsubmit="return validate()" method="POST">
			<div align="center"><font color="red">${error}</font></div>
			<div class="form-group">
				<h4 style="text-align:center;">
					<strong>Register</strong>
				</h4>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="Name">Name
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="name"
						name="name" placeholder="Enter Name" onblur="validateName()" required>
						<span id="errorNameSize" style="color:red"></span>
						<span id="errorNameContent" style="color:red"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="Email">Email
				</label>
				<div class="col-sm-4">
					<input type="email" class="form-control field" id="Email"
						name="email" placeholder="Enter Email" required>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-4" for="Role">Role</label>
				<div class="col-sm-4">
					<select class="form-control field" id ="Role" name="role">
					  <option value="Select">Select</option>
					  <option value="student">student</option>
					  <option value="professor">professor</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="UserName">UserName
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="UserName"
						name="userName" placeholder="Enter UserName" onblur="validateUserName()" required>
						<span id="errorUserNameSize" style="color:red"></span>
						<span id="errorUserNameContent" style="color:red"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="Password">Password</label>
				<div class="col-sm-4">
					<input type="Password" class="form-control field" id="pwd"
						name="password" placeholder="Enter password" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="retypePassword">RetypePassword</label>
				<div class="col-sm-4">
					<input type="Password" class="form-control field" id="repwd"
						name="retypePassword" placeholder="Re-Enter password" onblur="validatePassword()"  required>
						<span id="errorPasswordContent" style="color:red"></span>
						<span id="errorPasswordMismatch" style="color:red"></span>
				</div>
			</div>
			<p id = "errMessage" align = "center" style="color:red;"></P>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<input type="submit" value="register" class="btn btn-default"/>
				</div>
			</div>
		</form>
</div>

<script>
var	var1=false;
var var2=false;
var var3=false;
	function validate() {
	    var password = document.forms["registerForm"]["password"].value;
	    var rePassword = document.forms["registerForm"]["retypePassword"].value;
	    if (password == rePassword) {
	        var var4 =  true;
	    }else{
	    	document.getElementById("errMessage").innerHTML = "Password do not match";
	    	var var4 =  false;
	    }
	    return var1 && var2 && var3 && var4;
	}
	
	function validateUserName(){
		var usename =document.forms["registerForm"]["userName"].value;
		if((usename.length > 20 || usename.length <5) &&(usename!="") ){  
			document.getElementById("errorUserNameSize").innerHTML = "UserName should be 5 to 20 characters length ";
			document.forms["registerForm"]["userName"].value="";
			var1= false;
	 	}else{
			document.getElementById("errorUserNameSize").innerHTML = "";
	 		if (!(/[A-Za-z0-9_]+/).test(JSON.stringify(usename))) {
				document.getElementById("errorUserNameContent").innerHTML = "Please use Alphabets or digits or _";
	 			document.forms["registerForm"]["userName"].value="";
	 			var1= false;
	 		}else{
	 			document.getElementById("errorUserNameSize").innerHTML = "";
				document.getElementById("errorUserNameContent").innerHTML = "";
	 			var1= true;	    	
	 		} 
		}
	 }
	function validateName(){
		var name = document.forms["registerForm"]["name"].value;
		if((name.length > 25 || name.length <5)&&(name!="") ){  
			document.getElementById("errorNameSize").innerHTML = "Name should be 5 to 20 characters length ";
			var2= false;
 		}else{
			document.getElementById("errorNameSize").innerHTML = "";
 			if (!(/[A-Za-z]+/).test(JSON.stringify(name))) {
				document.getElementById("errorNameContent").innerHTML = "Please use alphabets";
 			 	document.forms["registerForm"]["name"].value="";
 			  	var2= false;
 			}else{
 				document.getElementById("errorNameSize").innerHTML = "";
 				document.getElementById("errorNameContent").innerHTML = "";
 				var2= true;	    	
 			    } 
		}
	}
	
	function validatePassword() {
		var pwd = document.forms["registerForm"]["password"].value;
		var rePwd = document.forms["registerForm"]["retypePassword"].value;
		var patternpass=/[A-Za-z0-9]+/;
		if(((pwd.length>15 && pwd.length<5)||(! patternpass.test(JSON.stringify(pwd))))&&(pwd!="")){
			document.getElementById("errorPasswordContent").innerHTML = "Password length should be between 5 to 15 characters. It should not contain special characters";
			document.forms["registerForm"]["password"].value="";
		   	document.forms["registerForm"]["retypePassword"].value="";
		  	var3= false;
		}else{
			document.getElementById("errorPasswordContent").innerHTML = "";
		   	if (pwd == rePwd) {
				document.getElementById("errorPasswordContent").innerHTML = "";
				document.getElementById("errorPasswordMismatch").innerHTML = "";
		    	var3= true;
		 	}else{
		 		document.getElementById("errorPasswordContent").innerHTML = "";
		 	 	document.forms["registerForm"]["password"].value="";
		 	   	document.forms["registerForm"]["retypePassword"].value="";
				document.getElementById("errorPasswordMismatch").innerHTML = "The entered and re-entered passwords do not match";
		 	   	var3= false;
		 	}	
		}
	}
</script>

<%@ include file="../common/footer.jspf"%>