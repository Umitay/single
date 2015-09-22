<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="oz_header.jsp" %>
	<div class="container">
	<form action="/category/save" method="post">
		<div class="form-group">
		<label>Slug*</label>
		<input type="text" value="${category.slug}" name="slug" class="form-control">
		</div>
		<div class="form-group">
		<label>Name*</label>
		<input type="text" value="${category.name}" name="name" class="form-control">
		</div>
		<div class="form-group">
		<label>Image url*</label>
		<input type="text" value="${category.image_url}" name="image_url" class="form-control">
		</div>
		<div class="form-group">
		<label>Description*</label>
		<textarea name="description" class="form-control" type="text">${category.description}</textarea>
		</div>
		<div class="form-group">
			<label>Included page</label>
			<select name="included_page">
				<option value="">None</option>
			    <c:forEach items="${pages}" var="page">
					<option value="${page.slug}" ${page.slug==category.included_page ? 'selected' : ''} >${page.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
		<label>Priority</label>
			<input type="text" value="${category.priority}" name="priority" class="form-control">
		</div>
		<input type="submit" class="btn btn-primary"> 
		</form>
	</div><!--/.container -->

</body>
</html>