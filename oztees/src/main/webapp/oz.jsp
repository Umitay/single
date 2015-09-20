<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"	href="/styles.css">
<link rel="icon" href="/logo_footer.png" type="image/x-icon" />
<link rel="shortcut icon" href="/logo_footer.png" type="image/x-icon" />
<!-- Latest compiled and minified JavaScript -->
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<title>${title}-OzTees</title>
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
	<div class="row">
	 <div class="col-md-6">
	 	<div class="list-group">
		  <a href="#" class="list-group-item active"><b>Pages</b> </a>
		   <c:forEach items="${pages}" var="page">
						<a class="list-group-item" href="/page/e/${page.slug}"> <strong
							style="text-transform: uppercase;">${page.name} </strong></a>
			</c:forEach>
		 </div>
	 </div>
  	 <div class="col-md-6">
  	 	<div class="list-group">
		  <a href="#" class="list-group-item active"><b>Categories</b> </a>
			<c:forEach items="${categories}">
					<a class="list-group-item"  href="/category/e/${category.slug}"> <strong
									style="text-transform: uppercase;">${category.name} </strong></a>
			</c:forEach>
		 </div>
  	 </div>
	</div><!--/.row -->
	</div><!--/.container -->

</body>
</html>
