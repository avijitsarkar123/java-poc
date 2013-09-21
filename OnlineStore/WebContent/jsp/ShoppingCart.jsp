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
        function doSubmit(actionName){
            document.frmShoppingCart.operation.value = actionName;
            document.frmShoppingCart.submit();
        }
    </script>
</head>

<body>
<c:import url="Header.jsp"/>
<div id="content">
<div id="col1">
    <c:import url="LeftPane.jsp"/>
</div>

<div id="col2">

        <c:import url="BreadCrumb.jsp"/>
		<div id="category">
			<h2>Your Shopping Cart</h2>
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. </p>
         <form name="frmShoppingCart" action="/onlinestore/shoppingCart/updateCart.do" method="post">
            <input type = "hidden" name="operation" value="" />
            <table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>Item</th>
					<th><div align="center">Unit Price</div></th>
					<th><div align="center">Qty</div></th>
					<th><div align="center"></div></th>
					<th><div align="center">Subtotal</div></th>
				</tr>
                <c:set var="shoppingCart" value="${sessionScope.shoppingCart}" />
                <!-- Repeat the below TR for all the line items -->
                <c:forEach var="cartItem" items="${shoppingCart.cartItems}">
                    <input type = "hidden" name="partId" value="<c:out value="${cartItem.part.id}"/>" />
                    <tr>
                        <td class="blue"><p><strong><a href="#"><c:out value="${cartItem.part.partName}" /></a></strong></p>
                            <p>Model #: <c:out value="${cartItem.part.modelNumber}"/></p>
                            <p>MFR Part #: <c:out value="${cartItem.part.manufacturerPartNumber}"/></p>
                        </td>
                        <td class="blue">
                            <div align="center" class="blue">
                              $<c:out value="${cartItem.unitPrice}" />
                            </div>
                        </td>
                        <td class="blue"><div align="center"><input name="qty" type="text" class="inputsm" value="<c:out value="${cartItem.quantity}"/>" /></div></td>
                        <td class="blue"><div align="center"><a href="/onlinestore/shoppingCart/removeCartItem.do?partId=<c:out value="${cartItem.part.id}" />">Remove</a></div></td>
                        <td class="blue"><div align="center" class="blue-bold">$<c:out value="${cartItem.totalPrice}" /></div></td>
                    </tr>
                </c:forEach>

                <tr>
					<td class="no-bottom" style="border-top:3px solid #eee;">&nbsp;</td>
					<td class="no-bottom" style="border-top:3px solid #eee;">&nbsp;</td>
					<td class="no-bottom" style="border-top:3px solid #eee;">&nbsp;</td>
					<td class="no-bottom" style="border-top:3px solid #eee;"><h4 align="center"><span class="blue"><strong>SUBTOTAL:</strong></span></h4></td>
					<td class="no-bottom" style="border-top:3px solid #eee;"><h4 align="center"><span class="blue"><strong>$<c:out value="${shoppingCart.lineItemsTotal}" /></strong></span></h4></td>
				</tr>
				<tr>
					<td colspan="6" class="no-bottom"><div align="right"><span class="blue">(Note: The Subtotal amount does not include Shipping and Tax charges which may be applied to this order)</span></div></td>
				</tr>
			</table>
                <table width="536" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="no-bottom">
                            <input type="image" src="/onlinestore/resources/images/button-continueshop.gif" name="button"  id="button" value="Continue Shopping" onclick="doSubmit('viewHomePage')"/>
                             &nbsp;&nbsp;
                            <c:if test="${not empty shoppingCart.cartItems}">
	                            <input type="image" src="/onlinestore/resources/images/button-updatecart.gif" name="button4"  id="button4" value="Continue Shopping" onclick="doSubmit('updateShoppingCart')"/>
	                        </c:if>
                        </td>
                        <td class="no-bottom">
                        	<div align="right">
                        		<c:if test="${not empty shoppingCart.cartItems}">
                            		<a href="/onlinestore/checkout/loadBillingPage.do"><img src="/onlinestore/resources/images/button-checkout.gif" alt="Checkout" border="0" /></a>
                            	</c:if>
                        	</div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
	</div>

 <div id="col3">
    <c:import url="RightPane.jsp">
        <c:param name="requestType" value="1" />
    </c:import>
 </div>
 <div class="clear"></div>
</div>

<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>

</body>
</html>




