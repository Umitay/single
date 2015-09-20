<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <script src="//tinymce.cachefly.net/4.2/tinymce.min.js"></script>
		<script>tinymce.init({selector:'textarea'});</script>

    </head>
    <body>
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="/oz/" class="navbar-brand">OzTees & Accessories Store</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
          <ul class="nav navbar-nav">
				       <li><a href="/csv"><b>Upload Csv</b></a>  </li>
		 </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	<div class="container">
	<form action="/page/save" method="post">
		<p></p>
		<div class="form-group">
		<label>Slug*</label>
		<input type="text" value="${page.slug}" name="slug" class="form-control">
		</div>
		<div class="form-group">
		<label>Name*</label>
		<input type="text" value="${page.name}" name="name" class="form-control">
		</div>
		<div class="form-group">
		<label>Description*</label>
		<textarea name="description" class="form-control" type="text">${page.description}</textarea>
		</div>
		<div class="form-group">
		<label>Add to top menu</label>
		<select name="is_menu">
			<option value="true" ${page.is_menu ? 'selected' : ''} >Yes</option>
			<option value="false" ${!page.is_menu ? 'selected' : ''}>No</option>
		</select>
		</div>
		<div class="form-group">
		<label>Priority</label>
		<input type="text" value="${page.priority}" name="priority" class="form-control">
		</div>
		<input type="submit" class="btn btn-primary"> 
		</form>
	</div><!--/.container -->

</body>
</html>