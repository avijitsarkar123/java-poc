<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="main.css" rel="stylesheet" type="text/css" />
<script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
<script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>


    <div id="product">
        <%--<c:forEach var="breadCrumb" items="${breadCrumbList}">
            &nbsp;<a href="<c:url value="${breadCrumb.linkUrl}" />"><c:out value="${breadCrumb.label}"/></a>&gt;
            &raquo;
        </c:forEach>--%>
        <div id="breadcrumbs">
        <c:forEach var="breadCrumb" items="${breadCrumbList}">
            <c:choose>
                <c:when test="${breadCrumb.labelUrl == true}">
                     <a href="<c:url value="${breadCrumb.linkUrl}"/>"<%--onclick ="<c:out value="${breadCrumb.linkUrl}"/>"--%>> <c:out value="${breadCrumb.label}"/></a> &raquo;
                </c:when>
                <c:otherwise>
                    <c:out value="${breadCrumb.label}"/>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </div>
        <%--<div id="breadcrumbs"><a href="#">Home</a> &raquo; <a href="#">Search</a>&gt;</div>--%>
        <%--<div id="breadcrumbs"><a href="#">Home</a> &raquo; <a href="#">Product Types</a> &raquo; <a href="#">Terminals</a> &raquo; <a href="#">First Data&trade; FD100 Terminal</a></div>--%>
        <div class="clear"></div>
    </div>

