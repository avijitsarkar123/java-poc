<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="specials">
             <c:out value="${param.mimeType}"/>
             <c:out value="${param.imageId}"/>
             <p><c:import url="Images.jsp">
                    <c:param name="mimeType" value="${param.mimeType}"></c:param>
                    <c:param name="src">getImage.do?action=displaySpecialsImage&usageType=15&imageId=<c:out value="${param.imageId}"/></c:param>
                    <c:param name="width">135</c:param><c:param name="height">73</c:param><c:param name="border"> </c:param><c:param name="alt">Free Shipping</c:param>
                </c:import>
                </p>
			    <h3>Free Shipping!</h3><p>When you place an order <br />
				of $100 or more, the shipping is on us<br />
				<a href="#" class="info1">Learn More<span>This is where we are going to put the information when you hover over this link</span></a>
</div>
