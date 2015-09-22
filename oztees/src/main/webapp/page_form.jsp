<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="oz_header.jsp" %>
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