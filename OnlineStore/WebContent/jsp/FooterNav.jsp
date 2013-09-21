<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <div id="footnav">
        <p>
            <span class="blue">Product Type Catalog:&nbsp;</span>
            <c:set var="partTypeList" value="${sessionScope.partTypeList}"/>
            <c:forEach var="partType" items="${partTypeList}">
                <a href="<c:url value="/searchParts.do"/>?operation=searchParts&searchBy=partType&partId=<c:out value="${partType.id}"/>">
                    <c:out value="${partType.partTypeName}"/>
                </a>&nbsp;
            </c:forEach>
        </p>
        <p>&nbsp;</p>
        <p>
            <span class="blue">Manufacturer Catalog:&nbsp;</span>
            <c:set var="manufacturerList" value="${sessionScope.manufacturerList}"/>
            <c:forEach var="manufacturer" items="${manufacturerList}">
                <a href="parts.do?operation=searchParts&searchBy=manufacturer&manufacturerId=<c:out value="${manufacturer.id}" />"><c:out value="${manufacturer.manufacturerName}" /></a> &nbsp;
            </c:forEach>
        </p>
    </div>

