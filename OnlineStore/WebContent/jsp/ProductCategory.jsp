<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

   <div id="equipment">
			<div class="hptitle">PRODUCT TYPE</div>
			<ul>
                <c:set var="partTypeList" value="${sessionScope.partTypeList}"/>
                <c:forEach var="partType" items="${partTypeList}">
                            <li><a href="/onlinestore/parts/search.do?searchBy=partType&partTypeId=<c:out value="${partType.id}"/>"><c:out value="${partType.partTypeName}"/></a></li>
                </c:forEach>
            </ul>
	</div>
