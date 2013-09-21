<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/onlinestore/resources/js/tabber.js"></script>
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/prototype.js"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/scriptaculous.js?load=effects"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/lightbox.js"></script>

    <script type="text/javascript">
        function gotoShoppingCartPage() {
            document.orderReviewForm.action='shoppingCart.do?operation=viewShoppingCart';
            document.orderReviewForm.submit();
        }
        function doSubmit(action) {
            if (action == 0) {
        		document.orderReviewForm.action = "/onlinestore/checkout/loadBillingPage.do";
        	} else {
        		document.orderReviewForm.action = "/onlinestore/checkout/loadShippingPage.do";
        	}
            document.orderReviewForm.submit();
        }
    </script>
</head>

<body>
<c:import url="Header.jsp"/>
<div id="content">
<div id="col1">
    <c:import url="TasqLogo.jsp"/>
</div>

<div id="col2">
        <c:import url="BreadCrumb.jsp"/>
        <c:set var="shoppingCart" value="${sessionScope.shoppingCart}"/>
        <div id="category">
            <FORM name="orderReviewForm" method="post">
            <input type="hidden" name="_page" value="2"/>
            <input type="hidden" name="targetPage" value=""/>
            <h2>Review Your Order</h2>
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. </p>
			<h5>Order Details</h5>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>Item</th>
					<th><div align="center">Unit Price</div></th>
					<th><div align="center">Qty</div></th>
					<th><div align="center">Subtotal</div></th>
				</tr>
                <!-- Repeat the below TR for all the line items -->
                <c:forEach var="cartItem" items="${shoppingCart.cartItems}">
                    <tr>
                        <td class="blue"><p><strong><a href="#"><c:out value="${cartItem.part.partName}" /></a></strong></p>
                            <p>Model #: <c:out value="${cartItem.part.modelNumber}"/></p>
                            <p>Online Store Part #: <c:out value="${cartItem.part.manufacturerPartNumber}"/></p>
                        </td>
                        <td class="blue">
                            <div align="center" class="blue">
                                $<c:out value="${cartItem.unitPrice}" />
                            </div>
                        </td>
                        <td class="blue"><div align="center"><c:out value="${cartItem.quantity}"/></div></td>
                        <td class="blue"><div align="center" class="blue-bold">$<c:out value="${cartItem.totalPrice}" /></div></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="2" class="no-bottom" style="border-top:2px solid #eee;">
						<p><img src="/onlinestore/resources/images/button-editorder.gif" alt="edit order details" width="118" height="31" onClick="gotoShoppingCartPage()"/></p>
					</td>
					<td class="no-bottom" style="border-top:2px solid #eee;">
						<div align="right" class="blue"><h4><strong>Subtotal:</strong></h4></div>
					</td>
					<td class="no-bottom" style="border-top:2px solid #eee;">
						<div align="center"><h4 class="blue-bold">$<c:out value="${shoppingCart.lineItemsTotal}" /></h4></div>
					</td>
				</tr>
			</table>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="no-bottom"><h5 style="margin-bottom:0px;">Billing Information</h5></td>
					<td class="no-bottomtop"><h5 style="margin-bottom:0px;">Shipping Information</h5></td>
				</tr>
				<tr>
					<td width="265" class="no-bottomtop" style="padding-left:10px;"><p>Method of Payment: <c:out value="${orderForm.paymentType}" /><br />
					
						<c:if test="${orderForm.paymentType == 'CC'}">
							Credit Card Number: <c:out value="${orderForm.paymentDataBean.partialCardNumber}" /><br />
							Expiration Date: <c:out value="${orderForm.paymentDataBean.expirationDate}" /></p>
							
							<p>&nbsp;</p>
							<p>
								<c:out value="${orderForm.billingName}" /><br />
								<c:out value="${orderForm.billingAddressLine1}" /><br />
								<c:out value="${orderForm.billingAddressLine2}" /><br />
								<c:out value="${orderForm.billingCity}" />, <c:out value="${orderForm.billingState}" /> <c:out value="${orderForm.billingZip}" /><br />
								<c:out value="${orderForm.billingCountry}" /><br />
								Phone: <c:out value="${orderForm.billingPhoneNumber}" />
							</p>
							<p>&nbsp;</p>
						</c:if>
						
						<c:if test="${orderForm.paymentType == 'ACH'}">
							Bank Name: <c:out value="${orderForm.paymentDataBean.bankTypeId}" /><br />
							Bank Account Number: <c:out value="${orderForm.paymentDataBean.accountNumber}" /><br />
							Bank Account ABA Number: <c:out value="${orderForm.paymentDataBean.bankAbaNumber}" /></p>
						</c:if>
							
						<p><img src="/onlinestore/resources/images/button-editcc.gif" alt="edit credit card" width="118" height="31" onclick="doSubmit('0');"/></p>
					</td>
						
					<td class="no-bottomtop" style="padding-left:10px;">
						<p>Carrier: <c:out value="${orderForm.shippingCarrier}" /></p>
						<p>
							Shipping Method: <c:out value="${orderForm.shippingMethodName}" /><br />
							Shipping Cost: $<c:out value="${orderForm.shippingRate}" />
						</p>
						<p>&nbsp;</p>
						<p>
							<c:out value="${orderForm.shippingName}" /><br />
							<c:out value="${orderForm.shippingAddressLine1}" /><br />
							<c:out value="${orderForm.shippingAddressLine2}" /><br />
							<c:out value="${orderForm.shippingCity}" />, <c:out value="${orderForm.shippingState}" /> <c:out value="${orderForm.shippingZip}" /><br />
							<c:out value="${orderForm.billingCountry}" /><br />
							Phone: <c:out value="${orderForm.shippingPhoneNumber}" />
						</p>
						<p>&nbsp;</p>
						<p><img src="/onlinestore/resources/images/button-editshipdetails.gif" alt="edit shipping details" width="118" height="31" onclick="doSubmit('1');"/></p></td>
				</tr>
			</table>
        </FORM>
        </div>

</div>

 <div id="col3">
    <c:import url="RightPane.jsp">
        <c:param name="requestType" value="4" />
    </c:import>
 </div>
 <div class="clear"></div>
</div>

<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>

</body>
</html>



