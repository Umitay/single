<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="header.jsp" %>
        <div class="container">
        <%@include file="include.jsp" %>
        <h1> ${category_name}
		<small class="text-muted" style="font-size: 42%; line-height: 26px; margin: 23px 0px 0px;">
				Sort By: 
				<a href="/category/v/${category_slug}?sort_by=${sort_by=='code'? '-code':'code'}">Code</a>,
				<a href="/category/v/${category_slug}?sort_by=${sort_by=='name'? '-name':'name'}">Name</a>, 
				<a href="/category/v/${category_slug}?sort_by=${sort_by=='brand'? '-brand':'brand'}">Brand</a>,
				<a href="/category/v/${category_slug}?sort_by=${sort_by=='approved_price'? '-approved_price':'approved_price'}">Price</a>, 
				<a href="/category/v/${category_slug}?sort_by=${sort_by=='gender'?'-gender':'gender'}">Gender</a>
			</small></h1>
        <div class="items">
        <c:forEach items="${products}" var="product">
       
        <div class="item-border">
		<div class="row">
		  <div class="col-sm-8">
		  <h5 id="${product.code}">${product.name}</h5>
		  </div>
		   <div class="col-sm-4">
		  <h5><b>${product.brand}</b> 
		  <c:if test="${!empty product.category_name}">- ${product.category_name}</c:if> </h5>
		  </div>
		</div>
		<div class="row">
		
		 <!-- Thumbnail contents -->
		  <div class="col-sm-2">
			<div class="thumbnail">
			<a class="more_info" href="${product.link}"  target="_blank">
			  <img data-src="holder.js/300x300" alt="${product.name} picture"
			  src="${product.picture}">
			  </a>
			</div>
			<p><b>Code:</b> ${product.code}</p>
		  </div>
		   <!-- /Thumbnail contents -->
			<!-- Price contents -->
		  <div class="col-sm-2">
			 <p><b>Price:</b><br> ${product.approved_price}<br> ${product.tier_price} ${product.tier_text}</p>
			 <p><a style="font-weight: bold;font-size:14px;" class="more_info" href="${product.link}"  target="_blank">More Info/Photo</a></p>
		  <p><span class="btn btn-danger" style="cursor: pointer; color: #FFFFFF; font-weight: bold;" onclick="order('${product.code}')">ORDER</span>
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
		 <c:if test="${!empty product.more_text}"> <p class="alert alert-warning"  ><b >Price / Quantity:</b><br>${product.more_text}</p></c:if>
			 
		  </div>
		   <!-- /Gender contents -->
			</div> <!-- /.row -->
			</div><!-- /.item-border -->
			</c:forEach>
		</div>
        </div>
       <!-- Modal -->
		<div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title">Order Form </h4>
		        <div class="alert alert-info msg" role="alert"></div>
		      </div>
		      <div class="modal-body">
		      <form role="form" id="orderForm">
		      	<div class="form-group">
				    <label >Item name</label>
				    <input type="hidden" id="h_item_name" name="item_name" >
				    <input type="text" class="form-control" id="item_name" disabled="disabled">
				  </div>
				  <div class="form-group">
				    <label >Item code</label>
				    <input type="hidden" id="h_item_code"  name="item_code">
				    <input type="text" class="form-control" id="item_code"  disabled="disabled">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email address <em style="color:red;">*</em></label>
				    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter email" required>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputFile">Description<em style="color:red;">*</em></label>
				    <textarea style="width: 560px; height: 172px;" name="description" id="description" required> </textarea>
				  </div>
				   <div class="checkbox">
					    <label>
					      <input id="printing-embroidery" name="printing-embroidery" value="" type="checkbox"> Would you like a Printing, Embroidery or Engraving quote ?
					    </label>
					</div>
			  </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" id="send" data-complete-text="Thank you for your order." >ORDER</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
      
      <script type="text/javascript">
       
        $(document).ready(function(event)
        		{
        	$(".alert").hide();
        	 $("#orderForm").validate();
	        	 /* $("body").on("click",".more_info", function(event) {
	        		 if (event.preventDefault) { 
	 					event.preventDefault();
	 		        } else {
	 		            event.returnValue = false;
	 		        }  
	        		 $('#continue').attr('href',$(this).attr('href'));
	        		 $('#myModal').modal();
	              }); */
	        	 $("body").on("click","#send", function(event) {
	        		 if(event.keyCode != 13)
	        		   {
	        		     
			        		 var btn = $(this);
			        		    btn.button('loading');
			        		
			        		 if($( "#orderForm" ).valid()){
			        			 if($("#printing-embroidery").prop( "checked" )){ $("#printing-embroidery").val(1);}
			        			 
				        		 $.post( "/order", $( "#orderForm" ).serialize(), function( msg ) {
				        			 $( ".msg" ).html( "Thank you for your order.  We will contact you as soon as possible.");
				        			 $('.alert').show();
				        			 $('.btn').button('complete');
				        		 }).fail(function() {
				        			 $( ".msg" ).html( "Oh, Something went wrong, please try later again." );
				        			 $(".alert").show();
				        			 btn.button('reset');
				        		 }).always(function () {
				        		      setTimeout(function(){
				        		    	  $('.alert').hide();
				        		    	  btn.button('reset');
				        		    	  $('#orderModal').modal('hide');
				        		    	}, 5000);
				        		    });
			        		 }
	        		   }
	              });
        		});
        function order(code){
        	var name=$('#'+code).html();
        	
        	$('#h_item_name').val(name);
        	$('#h_item_code').val(code);
        	$('#item_name').val(name);
        	$('#item_code').val(code);
        	 $('#orderModal').modal();
        }
       
        </script>
        <script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
      <%@include file="bottom.jsp" %>
