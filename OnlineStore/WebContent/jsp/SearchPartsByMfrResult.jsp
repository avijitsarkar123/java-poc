<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
</head>
<body>
<c:import url="Header.jsp"/>
<div id="content">
    <div id="col1">
        <c:import url="LeftPane.jsp"/>
    </div>
<!--<div id="category">
<h2>Manufacturer: First Data</h2> -->
    <DIV id="col2">
        <%--<c:import url="BreadCrumb.jsp"/>--%>
        <DIV class="clear">
        </DIV>
        <DIV id="category"><H2>Manufacturer: <c:out value="${manufacturer.manufacturerName}"/></H2>
            <P><c:out value="${manufacturer.manufacturerDesc}"/></P>
            <c:choose>
            <c:when test="${sessionScope.searchResultList.pageList != null}" >
            <DIV id="catgroup">
                    <c:set var="partList" value="${sessionScope.searchResultList.pageList}"/>
                    <c:forEach var="part" items="${partList}">
                        <div class="cats">
                        <p>
                            <img src="<c:out value="${part.primaryPicture}" />" alt="<c:out value="${part.partName}" />" height="100" width="75" />
                        </p>
                        <p>
                            <img src="<c:out value="${manufacturer.manufacturerLogo}" />" alt="<c:out value="${manufacturer.manufacturerName}" />" />
                        </p>

                            <p>
                                <a href="/onlinestore/parts/details.do?partId=<c:out value='${part.id}' />"><br/>
                                Model: <c:out value="${part.modelNumber}"/></a><br/>
                                Price: <c:out value="${part.unitPrice}"/>

                            </p>
                        </div>
                    </c:forEach>
                <DIV class="clear"></DIV>
              </DIV>

            <DIV class="clear"></DIV>
           <%--<div class="more">
                    <c:if test="${sessionScope.partSummaries.page != sessionScope.partSummaries.firstLinkedPage}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=first">First  </a> |
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=prev">Prev  </a> |
                    </c:if>
                    <c:if test="${(sessionScope.partSummaries.page == sessionScope.partSummaries.lastLinkedPage) and (sessionScope.partSummaries.page - 2 >= sessionScope.partSummaries.pageCount)}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=pageClicked&pageNum=<c:out value="${sessionScope.partSummaries.page - 2}"/>"><c:out value="${sessionScope.partSummaries.page - 1}"/>  </a> |
                    </c:if>

                    <c:if test="${sessionScope.partSummaries.page > 0}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=pageClicked&pageNum=<c:out value="${sessionScope.partSummaries.page - 1}"/>"><c:out value="${sessionScope.partSummaries.page}"/>  </a> |
                    </c:if>

                    <c:out value="${sessionScope.partSummaries.page + 1}"/> |

                    <c:if test="${sessionScope.partSummaries.page + 1 <= sessionScope.partSummaries.lastLinkedPage}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=pageClicked&pageNum=<c:out value="${sessionScope.partSummaries.page + 1}"/>"><c:out value="${sessionScope.partSummaries.page + 2}"/>  </a> |
                    </c:if>

                    <c:if test="${(sessionScope.partSummaries.page == sessionScope.partSummaries.firstLinkedPage) and (sessionScope.partSummaries.page + 3 <= sessionScope.partSummaries.pageCount)}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=pageClicked&pageNum=<c:out value="${sessionScope.partSummaries.page + 2}"/>"><c:out value="${sessionScope.partSummaries.page + 3}"/>  </a> |
                    </c:if>

                    <c:if test="${sessionScope.partSummaries.page != sessionScope.partSummaries.lastLinkedPage}">
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=next">  Next</a> |
                        <a href="<c:url value="/searchParts.do"/>?action=searchParts&searchBy=<c:out value="${searchBy}" />&mfrId=<c:out value="${mfrCode}"/>&page=last">  Last</a>
                    </c:if>
                </div>--%>
            </c:when>
                    <c:otherwise>
                        <p><strong>Sorry,No Result Found</strong></p>
                    </c:otherwise>
            </c:choose>
       </DIV>
</div>
<!-- ------------------------------------------------------ This is where the ShoppingCart is coming ---------------------------------------- -->
<div id="col3">
    <c:import url="RightPane.jsp">
        <c:param name="requestType" value="1" />
    </c:import>
    <c:set var="specialContentBean" value="${specialPageContentBean}" />
    <%--<div id="specials">
        <p>
        <img src ="getImage.do?action=displayImageFromPageContent&usageType=12&imageId=<c:out value="${specialContentBean.imageId}"/>" usemap ="#MapSpecialAdsTop" border="0"/>
        <map id ="MapSpecialAdsTop"
        name="MapSpecialAdsTop">
            <area shape ="rect" coords ="<c:out value="${specialContentBean.learnMoreMapCoord}"/>" onMouseOver=""/>
            <area shape ="rect" coords ="<c:out value="${specialContentBean.specialsMapCoord}"/>" href ="http://www.google.com" />
        </map>
        </p>
        </div>--%>
    <%--<div id="incentive">
        <p><img src="/onlinestore/resources/images/free-shipping.jpg" alt="Free Shipping" width="135" height="73" /></p>

        <h3>Free Shipping!</h3>

        <p>When you place an order <br />
            of $100 or more, the shipping is on us<br />
            <a href="#" class="info1">Learn More<span>This is where we are going to put the information when you hover over this link</span></a>
    </div>--%>
</div>

<!-- ------------------------------------------------------ This is where the Special is coming --------------------------------------------- -->


<div class="clear"></div>
</div>

<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>
</body>
</html>