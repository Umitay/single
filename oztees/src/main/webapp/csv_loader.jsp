<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script	src="http://underscorejs.org/underscore-min.js"></script>
        <script	src="http://backbonejs.org/backbone-min.js"></script>
        	<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet"	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<!-- Latest compiled and minified JavaScript -->
		<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <title></title>    
	
    </head>
     <body>
  
        <div class="container">
        <h1>CSV loader</h1>
		<form role="form" method="post" action="/csv/upload">
		  <div class="form-group">
		    <label for="filename">File Name</label>
		    <input type="text" class="form-control" name="filename" id="filename" placeholder="Enter ile Name">
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
		
        </div>
        </body>
        </html>