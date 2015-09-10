<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/csv"><b>Upload Csv</b></a>
<div class="row">
<c:forEach items="${categories}">
			
			<a href="/category/e/${category.slug}"> <strong
							style="text-transform: uppercase;">${category.name} </strong></a>
				
			
	</c:forEach>
	</div>
	<div class="row">
	<c:forEach items="${pages}" var="page">
			
			
						<a href="/page/e/${page.slug}"> <strong
							style="text-transform: uppercase;">${page.name} </strong></a>
					
		
	</c:forEach>
	</div>
</body>
</html>