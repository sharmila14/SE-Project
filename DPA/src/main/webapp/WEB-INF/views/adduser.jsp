<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminheader.jspf"%>

<div class="container">
		<form name="registerForm"  action="/dpa/adduser" class="form-horizontal" method="POST">
			<div align="center"><font color="red">${error}</font></div>
			<div align="center"><font color="green">${success}</font></div>
			<div class="form-group">
				<h4 style="text-align:center;">
					<strong>${user}</strong>
				</h4>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="Name">Name
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="name"
						name="name" placeholder="Enter Name" required>
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
					  <option value="chair">Chair</option>
					  <option value="associatechair">AssociateeChair</option>
					  <option value="adminspecialist">AdminSpecialist</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="UserName">UserName
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control field" id="UserName"
						name="userName" placeholder="Enter UserName" required>
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
				<div class="col-sm-offset-4 col-sm-4">
					<input type="submit" value="adduser" class="btn btn-default"/>
				</div>
			</div>
			
		</form>
</div>

<%@ include file="../common/footer.jspf"%>