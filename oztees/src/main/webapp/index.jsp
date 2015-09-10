<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="header.jsp" %>
<div class="container">
	<%@include file="include.jsp" %>
	<c:if test="${!empty categories}">
	<div class="row">
	 <c:forEach items="${categories}" var="category" begin="0" end="3">
		
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail" style="border-color: #ffffff">
					<a href="/category/v/${category.slug}"> <img width="150"
						alt="${category.name} category"
						src="${category.image_url}">
					</a>
					<div class="caption" style="text-align: center;">
						<a href="/category/v/${category.slug}"> <strong
							style="text-transform: uppercase;">${category.name} </strong></a>
					</div>
				</div>
			</div>
		
	</c:forEach>
	</div>
	<div class="row">
	<c:forEach items="${categories}" var="category" begin="4" end="7">
		
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail" style="border-color: #ffffff">
					<a href="/category/v/${category.slug}"> <img width="150"
						alt="${category.name} category"
						src="${category.image_url}">
					</a>
					<div class="caption" style="text-align: center;">
						<a href="/category/v/${category.slug}"> <strong
							style="text-transform: uppercase;">${category.name} </strong></a>
					</div>
				</div>
			</div>
		
	</c:forEach>
	</div>
	<div class="row">
	<c:forEach items="${categories}" var="category" begin="8" end="11">
			
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail" style="border-color: #ffffff">
					<a href="/category/v/${category.slug}"> <img width="150"
						alt="${category.name} category"
						src="${category.image_url}">
					</a>
					<div class="caption" style="text-align: center;">
						<a href="/category/v/${category.slug}"> <strong
							style="text-transform: uppercase;">${category.name} </strong></a>
					</div>
				</div>
			</div>
		
	</c:forEach>
	</div>
		<div class="row">
		<c:forEach items="${categories}" var="category" begin="12" end="15">
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail" style="border-color: #ffffff">
					<a href="/category/v/${category.slug}"> <img width="150"
						alt="${category.name} category"
						src="${category.image_url}">
					</a>
					<div class="caption" style="text-align: center;">
						<a href="/category/v/${category.slug}"> <strong
							style="text-transform: uppercase;">${category.name} </strong></a>
					</div>
				</div>
			</div>
	</c:forEach>
	</div>
	</c:if>
</div>	
<%@include file="bottom.jsp" %>