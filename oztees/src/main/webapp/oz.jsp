<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="oz_header.jsp" %>
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
			<c:forEach items="${categories}" var="category">
					<a class="list-group-item"  href="/category/e/${category.slug}"> <strong
									style="text-transform: uppercase;">${category.name} </strong></a>
			</c:forEach>
		 </div>
  	 </div>
	</div><!--/.row -->
	</div><!--/.container -->

</body>
</html>
