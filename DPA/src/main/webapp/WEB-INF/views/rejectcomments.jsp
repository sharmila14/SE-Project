<form name ="rejectCommentsForm" action="/dpa/degreePlanReject" class="form-horizontal" method = "POST">
<div class="form-group">
		<div align = "center">
			<font color="green">${success}</font>
		</div>
	<label class="control-label col-sm-4" style="font-size:18px" for="studentName">Student Name
	</label>
		<div class="col-sm-4">
			<input type="text" class="form-control field" id="studentName"
			name="studentName" value="${studentName}" required>
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-sm-4" style="font-size:18px" for="rejectComments">Comments
	</label>
		<div class="col-sm-4">
			<textarea name="comments" class="form-control field" id="comments" placeholder="Enter comments of rejection" cols="40" rows="10" required></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-4">
			<input type="submit" value="submit" class="btn btn-default" />
		</div>
	</div>
</form>

