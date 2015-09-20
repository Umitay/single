<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="header.jsp" %>
<div class="container">
	<h1> ${page.name}</h1>
	${page.description}
</div>	
<%@include file="bottom.jsp" %>