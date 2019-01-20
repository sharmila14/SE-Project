<div class="container register">
		<form name="registerForm"  action="/dpa/updateaccount" class="form-horizontal" onsubmit="return validate()" method="POST">
			<div align="center"><font color="red">${error}</font></div>
			<div class="form-group">
				<h4 style="text-align:center;">
					<strong>Account Details</strong>
				</h4>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="Name">Name
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="name"
						name="name" value="${accountDetails.name}" onblur="validateName()">
						<span id="errorNameSize" style="color:red"></span>
						<span id="errorNameContent" style="color:red"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="Email">Email
				</label>
				<div class="col-sm-4">
					<input type="email" class="form-control field" id="Email"
						name="email" value="${accountDetails.email}">
				</div>
			</div>
			<div class="form-group">
			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="role">Role
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="role"
						name="role" value="${accountDetails.role}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" style="font-size:18px" for="UserName">UserName
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="UserName"
						name="userName" value="${accountDetails.userName}" onblur="validateUserName()" readonly>
						<span id="errorUserNameSize" style="color:red"></span>
						<span id="errorUserNameContent" style="color:red"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<input type="submit" value="Update Account Details" class="btn btn-primary"/>
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
		if(usename.length > 20 || usename.length <5 ){  
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
		if(name.length > 25 || name.length <5 ){  
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
	
</script>
