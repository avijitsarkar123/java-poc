<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <div id="header">
	<div id="phone">Questions? Need Help? Call (800) 827-8297</div>
	<div id="topnav">
		<sec:authorize access="hasRole('ADMIN')">
			<a href="#">Specials</a>
			<a href="#">Order Status</a> 
			<a href="#">Invoices</a> 
		</sec:authorize>

		<a href="#">FAQs</a> 
		<a href="#">Contact</a></div>
	<div class="clear"></div>
    </div>

