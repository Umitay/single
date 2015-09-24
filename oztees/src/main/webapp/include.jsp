<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:choose>
	<c:when test="${!empty page}">
     ${page.description}
 </c:when>
	<c:otherwise>
		<div class="page-header">
			<div class="row">
				<div class="col-sm-6 col-md-6">
					<div>
						<b>Contact us for a quick Quote &amp; Mock-up</b>
					</div>
					<div>
						Phone <b style="color: #2a6496;">02 9590 8777</b>
					</div>
					<div>Email sales[at]oztees.com.au</div>
					<div>Mobile 0425 243 156</div>
				</div>
				<div class="col-sm-6 col-md-6">
					<a class="top_banner"
						href="https://oztees.com.au/page/v/printing-embroidery/"> 
						<img id="printing-embroidery-banner"
						data-src="holder.js/500x82"
						src="https://storage.googleapis.com/oztees-au.appspot.com/images/banner.jpg"
						alt="Printing &amp; Embroidery price list">
					</a>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>