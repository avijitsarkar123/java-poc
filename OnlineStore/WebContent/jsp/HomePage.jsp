<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/header.css" rel="stylesheet" type="text/css" />
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css" />
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
</head>
<body>
<c:import url="Header.jsp"/>
<div id="content">
    <div id="col1">
        <c:import url="LeftPane.jsp"/>
    </div>
	<div id="col3">
		<c:import url="RightPane.jsp">
            <c:param name="requestType" value="1" />
        </c:import>
		<div id="specials">
			<p><img src="/onlinestore/resources/images/free-shipping.jpg" alt="Free Shipping" width="135" height="73" /></p>
			<h3>Free Shipping!</h3>
			<p>When you place an order <br />
				of $100 or more, the shipping is on us<br />
				<a href="#" class="info1">Learn More<span>This is where we are going to put the information when you hover over this link</span></a>
		</div>
    </div>
	<div class="clear"></div>
</div>
<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>
</body>
</html>