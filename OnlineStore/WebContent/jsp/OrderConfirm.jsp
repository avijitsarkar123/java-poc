<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Store</title>
<link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/onlinestore/resources/js/tabber.js"></script>
<script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
<script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
<script type="text/javascript" src="/onlinestore/resources/js/prototype.js"></script>
<script type="text/javascript" src="/onlinestore/resources/js/scriptaculous.js?load=effects"></script>
<script type="text/javascript" src="/onlinestore/resources/js/lightbox.js"></script>
</head>
<body>
<div id="header">
	<div id="phone">Questions? Need Help? Call (800) 827-8297</div>
	<div id="topnav"><a href="#">Specials</a> <a href="#">Order Status</a> <a href="#">Invoices</a> <a href="#">FAQs</a> <a href="#">Contact</a></div>
	<div class="clear"></div>
</div>
<div id="content">
	<div id="col1">
		<div id="logo"><a href="index.html"><img src="/onlinestore/resources/images/logo.gif" alt="Online Store" width="175" height="68" border="0" /></a></div>
	</div>
	<div id="col2">
		<div id="product">
			<div id="breadcrumbs"><a href="#">Home</a> &raquo; <a href="#">Order Confirmation</a></div>
			<div class="clear"></div>
		</div>
		<div id="category">
			<div id="product2">
				<div class="clear"></div>
			</div>
			<h2>Thank you for your Order</h2>
			<h6>Your Order Number is: <strong><c:out value="${order.orderNumber}" /></strong></h6>
			<p>Your order will be processed shortly. In the meantime, if you have any questions, you can reach us by calling (888) 888-8888 or by filling our the form on our <a href="#">contact page</a>.</p>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="no-bottom">Once again, thank you for shopping with us!<br />
Online Store, Inc.</td>
					<td class="no-bottomtop"><div align="right"><img src="/onlinestore/resources/images/printer.gif" alt="print" width="16" height="16" border="0" /> <a href="#">Printer Friendly Version</a></div></td>
				</tr>
			</table>
			<h5>Order Details</h5>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>Item</th>
					<th><div align="center">Unit Price</div></th>
					<th><div align="center">Qty</div></th>
					<th><div align="center">Subtotal</div></th>
				</tr>
                <!-- Repeat the below TR for all the line items -->
                <c:forEach var="lineItem" items="${order.lineItems}">
                    <tr>
                        <td class="blue"><p><strong><a href="#"><c:out value="${lineItem.part.partName}" /></a></strong></p>
                            <p>Model #: <c:out value="${lineItem.part.modelNumber}"/></p>
                            <p> MFR Part #: <c:out value="${lineItem.part.manufacturerPartNumber}"/></p>
                        </td>
                        <td class="blue">
                            <div align="center" class="blue">
                                $<c:out value="${lineItem.unitPrice}" />
                            </div>
                        </td>
                        <td class="blue"><div align="center"><c:out value="${lineItem.qty}"/></div></td>
                        <td class="blue"><div align="center" class="blue-bold">$<c:out value="${lineItem.unitPrice}" /></div></td>
                    </tr>
                </c:forEach>

                <tr>
					<td class="no-bottom" colspan="3" style="border-top:2px solid #eee;">
						<div align="right" class="blue"><h4><strong>Subtotal:</strong></h4></div>
					</td>
					<td class="no-bottom" style="border-top:2px solid #eee;">
						<div align="center"><h4 class="blue-bold">$<c:out value="${order.orderBilling.lineItemTotal}" /></h4></div>
					</td>
				</tr>
			</table>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="no-bottom"><h5 style="margin-bottom:0px;">Billing Information</h5></td>
					<td class="no-bottomtop"><h5 style="margin-bottom:0px;">Shipping Information</h5></td>
				</tr>
				<tr>
				
					<c:if test="${order.orderBilling.paymentType == 'CC'}">
						<td width="265" class="no-bottomtop" style="padding-left:10px;"><p>Method of Payment: <c:out value="${order.orderBilling.orderPaymentInfo.cardType}" /><br />
							Credit Card Number: <c:out value="${order.orderBilling.orderPaymentInfo.partialCardNumber}" /><br />
							Expiration Date: <c:out value="${order.orderBilling.orderPaymentInfo.expirationDate}" /></p>
							<p>&nbsp;</p>
							<p>
								<c:out value="${order.orderBilling.billingAddress.name}" /><br />
								<c:out value="${order.orderBilling.billingAddress.addressLine1}" /><br />
								<c:out value="${order.orderBilling.billingAddress.addressLine2}" /><br />
								<c:out value="${order.orderBilling.billingAddress.city}" />, <c:out value="${order.orderBilling.billingAddress.state}" /> <c:out value="${order.orderBilling.billingAddress.zip}" /><br />
								<c:out value="${order.orderBilling.billingAddress.country}" /><br />
								Phone: <c:out value="${order.orderBilling.billingAddress.phoneNumber}" />
							</p>
							<p>&nbsp;</p>
                    	</td>
					</c:if>
					
					<c:if test="${orderForm.paymentType == 'ACH'}">
						Bank Name: <c:out value="${order.orderPaymentInfo.bankName}" /><br />
						Bank Account Number: <c:out value="${orderForm.orderPaymentInfo.accountNumber}" /><br />
						Bank Account ABA Number: <c:out value="${orderForm.orderPaymentInfo.bankAbaNumber}" /></p>
					</c:if>
					
					<td class="no-bottomtop" style="padding-left:10px;"><p>Carrier: <c:out value="${order.orderShipping.orderShippingMethod.carrier}" /></p>
						<p>Shipping Method: <c:out value="${order.orderShipping.orderShippingMethod.shippingMethodName}" /><br />
							Shipping Cost: $<c:out value="${order.orderShipping.shippingCost}" /></p>
						<p>&nbsp;</p>
						<p><c:out value="${order.orderShipping.shippingAddress.name}" /><br />
							<c:out value="${order.orderShipping.shippingAddress.addressLine1}" /><br />
							<c:out value="${order.orderShipping.shippingAddress.addressLine2}" /><br />
							<c:out value="${order.orderShipping.shippingAddress.city}" />, <c:out value="${order.orderShipping.shippingAddress.state}" /> <c:out value="${order.orderShipping.shippingAddress.zip}" /><br />
							<c:out value="${order.orderShipping.shippingAddress.country}" /><br />
							Phone: <c:out value="${order.orderShipping.shippingAddress.phoneNumber}" /></p>
						<p>&nbsp;</p>
                    </td>
				</tr>
			</table>
		</div>
	</div>
	<div id="col3">
		<c:import url="RightPane.jsp">
            <c:param name="requestType" value="5" />
        </c:import>
	</div>
	<div class="clear"></div>
</div>
<div id="footer" style="border-top:1px solid #ddd;">
	<div id="fleft">
		<p>Copyright &copy; 2007 Online Store, Inc. All Rights Reserved. <a href="#">Privacy Policy.</a></p>
		<p><a href="#">Home</a> <a href="#">Shopping Cart</a> <a href="#">Specials</a> <a href="#">Order Status</a> <a href="#">Invoices</a> <a href="#">FAQS</a> <a href="#">Log Out</a> <a href="#">Contact Us</a> <a href="#">Site Map</a> <a href="#">Terms and Conditions</a></p>
	</div>
	<div id="fright"><a href="http://www.onlinestore.com"><img src="/onlinestore/resources/images/logo-footer.gif" alt="Online Store" width="102" height="35" border="0" /></a></div>
	<div class="clear"></div>
</div>
</body>
</html>
