<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/" title="OzTees & Accessories Store">
        <img height="50px" width="220px" alt="OzTees & Accessories Store" src="/logo.png">
      </a>
    </div>
     <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <li>
      	<a class="capitalize" href="/"><b>Home</b></a>
		</li>
      <li>
      	<a class="capitalize" href="/page/v/printing-and-embroidery-price"><b>Printing &amp; Embroidery</b></a>
		</li>
         <c:if test="${!empty categories}">
		    <c:forEach items="${categories}" var="category">
		       <li><a class="capitalize"  
		       href="/category/v/${category.slug}"><b>${category.name}</b></a>
		       </li>
		    </c:forEach>
		    </c:if>

      </ul>
     </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>