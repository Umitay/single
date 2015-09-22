<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="header.jsp" %>
<div class="container">
	<h1> ${page.name}</h1>
	${page.description}
	${msg}
	<form role="form" method="post" action="/page/contact" style="width: 760px;">
		  <div class="form-group">
		    <label>Name<em style="color:red;">*</em></label>
		    <input type="text" class="form-control"  id="name" name="name" >
		  </div>
			<div class="form-group">
		    <label >Phone</label>
		    <input type="text" class="form-control"  id="phone" name="phone" >
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Email <em style="color:red;">*</em></label>
		    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter email" required>
		  </div>
		  <div class="form-group">
		    <label for="description">Description</label><br>
		    <textarea  name="description" class="form-control" id="description"> </textarea>
		 </div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	
</div>	
<%@include file="bottom.jsp" %>