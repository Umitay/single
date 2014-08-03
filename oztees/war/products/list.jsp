<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>${title} - OzTees</title>    
	   </head>     
    <style>body{font-size: 12px;}
    h5{  font-weight: bold; color: #043A47;}
    .item-border .thumbnail{margin-bottom: 0px;     padding-bottom: 0px;}
    .item-border {
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background-color: #fff;
    border:1px solid #ddd;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
    display: block;
    line-height: 1.42857;
    margin-bottom: 20px;
    padding-bottom: 4px;
    padding-left:40px;
    padding-right: 4px;
    padding-top: 4px;
    transition-delay: 0s;
    transition-duration: 0.2s;
    transition-property: all;
    transition-timing-function: ease-in-out;
	}
	#modal-area{
	display:none;
	}
    </style>
    
     <body>
  
        <div class="container">
        <h1> ${title} </h1>
        <div class="items">
        <c:forEach items="${products}" var="product">
       
        <div class="item-border">
		<div class="row">
		  <div class="col-sm-8">
		  <h5>${product.name}</h5>
		  </div>
		   <div class="col-sm-4">
		  <h5><b>${product.brand}</b> - ${product.category}</h5>
		  </div>
		</div>
		<div class="row">
		 <!-- Thumbnail contents -->
		  <div class="col-sm-2">
			<div class="thumbnail">
			  <img data-src="holder.js/300x300" alt="${product.name} picture" onclick= "more_info('${product.link}')"
			  src="http://storage.googleapis.com/oztees-au.appspot.com/${product.picture}">
			</div>
			<p><b>Code:</b> ${product.code}</p>
		  </div>
		   <!-- /Thumbnail contents -->
			<!-- Price contents -->
		  <div class="col-sm-2">
			 <p><b>Price:</b><br> ${product.approved_price}</p>
			 <p><a style="font-weight: bold;font-size:14px;" href="javascript:void();" onclick="more_info('${product.link}')">More Info/Photo</a></p>
		  <p><span class="btn btn-danger" style="cursor: pointer; color: #FFFFFF; font-weight: bold;" onclick="open_form('Cap CH01 heavy brushed cotton traditional Baseball cap','ch01')">Order</span>
				  </p>
		  </div>
		   <!-- /Price contents -->
			<!-- Description contents -->
		  <div class="col-sm-3">
			 <p><b>Description:</b><br> ${product.description}</p>
		  </div>
		   <!-- /Description contents -->
			 <!-- Colour contents -->
		  <div class="col-sm-3">
			 <p><b>Colour/s:</b><br> ${product.colour}</p>
		  </div>
		   <!-- /Colour contents -->
		  
		 
		   <!-- Size Range contents -->
		  <div class="col-sm-2">
			 <p><b>Size Range:</b><br> ${product.size}</p>
			  <p><b>Gender:</b><br> ${product.gender}</p>
		  </div>
		   <!-- /Size Range contents -->
		  
			<!-- Gender contents -->
		  <div class="col-sm-9">
			 <p class="alert alert-warning"><b >Price / Quantity:</b><br>${product.more_text}</p>
		  </div>
		   <!-- /Gender contents -->
			</div> <!-- /.row -->
			</div><!-- /.item-border -->
			</c:forEach>
		</div>
        </div>
        
       <!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title"></h4>
		      </div>
		      <div class="modal-body">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
      
        <script type="text/javascript">
          function more_info( link ){
        	  /* if (event.preventDefault) { 
					event.preventDefault();
		        } else {
		            event.returnValue = false;
		        }  */
        	 var options = {};
        	  var helperFrame = $('<iframe />').attr('name','helperFrame').attr('id','helperFrame').attr('src', link);
        	  $(".modal-body").html(helperFrame);
        	 // $('<iframe />').css({position : 'absolute', left : '-1000px', top : '-1000px', width : '1px', height : '1px'});
        	  $('#myModal').modal(options);
          }
        </script>
        </body>
        </html>