<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>My Web Page</title>
</head>
<body>
	 <div class="container">
		<form action="/20190128maven/page5" method="POST">
		    <div class="form-group">
		      <label for="usr">Name:</label>
		      <input type="text" class="form-control" id="usr" name="usr">
		    </div>
		    <div class="form-group">
		      <label for="pwd">Password:</label>
		      <input type="password" class="form-control" id="pwd" name="pwd">
		    </div>
		    <div class="form-group">
		      <input type="submit" class="form-control" value="로그인">
		    </div>
		</form>
	</div>
 </body>
</html>