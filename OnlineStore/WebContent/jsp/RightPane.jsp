<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type='text/javascript' src='/onlinestore/dwr/engine.js'></script>
<script type="text/javascript" src='/onlinestore/resources/js/prototype.js' />
<script type='text/javascript' src='/onlinestore/dwr/util.js'></script>
<script type='text/javascript' src='/onlinestore/dwr/interface/onlineStoreAjaxService.js'></script>

<script type="text/javascript">
    // Swallow errors and warnings from DWR; handle appropriately in your app
     
     dwr.engine.setWarningHandler(null);

    function getLineItemsCountAndTotal() {
    	onlineStoreAjaxService.getLineItemsCountAndTotal({
               callback:function(dataFromServer) {
                   data = dataFromServer.split("~");
                   document.getElementById('lineItemsCount').innerHTML = data[0];
                   document.getElementById('lineItemsTotal').innerHTML = data[1];
                   if (parseInt(data[0]) > 0) {
                   		$('checkoutButton').style.display = 'inline';
               	   }
               }
        });
    }
</script>

    <div id="account">
			<p>Welcome <sec:authentication property="principal.firstName" />, <br />
				<a href="/onlinestore/logout.do">Log Out</a></p>
			<p><a href="#"><img src="/onlinestore/resources/images/checkout1.gif" alt="cart" width="32" height="32" border="0" /></a></p>

    <c:choose>
        <%-- For Home, Search & ShoppingCart pages --%>
        <c:when test="${param.requestType == 1}">
            <p>
                <a href="/onlinestore/shoppingCart/viewCart.do">View Your Cart</a><br />
                    <script>getLineItemsCountAndTotal();</script>
                    <span id="lineItemsCount"></span>&nbsp;Items | $<span id="lineItemsTotal"></span>
            </p>
            <p>
            	<div id="checkoutButton" style="display: none;">
            		<a href="/onlinestore/checkout/loadBillingPage.do"><img src="/onlinestore/resources/images/checkout.gif" alt="Checkout" width="118" height="31" border="0" /></a>
            	</div>
            </p>
        </c:when>

        <%-- For ReviewOrder Page --%>
        <c:when test="${param.requestType == 4}">
            <h4 class="black" style="padding:5px 0 5px 0;"><strong>SUBTOTAL: $<c:out value="${orderForm.lineItemsTotal}" /></strong></h4>
			<h4 class="black" style="padding-bottom:5px;"><strong>SHIPPING: $<c:out value="${orderForm.shippingRate}" /></strong></h4>
			<h4 class="blue" style="padding-bottom:10px;"><span class="black" style="font-weight: bold">TAX: $<c:out value="${orderForm.tax}" /></span><br />
				<span class="xsmall">(<a href="#">Why are there taxes?</a>)</span></h4>
			<h4 class="black" style="padding-bottom:10px;"><strong>&nbsp;TOTAL: $<c:out value="${orderForm.orderTotal}" /></strong></h4>
			<p class="blue" style="padding-bottom:10px;">&nbsp;</p>
            <p class="blue" style="padding-bottom:10px;">
                <a href="/onlinestore/checkout/placeOrder.do"><img src="/onlinestore/resources/images/button-placeorder.gif" alt="Place Order" width="118" height="31" border="0" /></a>
            </p>
            <p class="blue" style="padding-bottom:10px;">
                <a href="/onlinestore/checkout/cancelOrder.do"><img src="/onlinestore/resources/images/button-cancelorder.gif" alt="Cancel Order" width="118" height="31" border="0" /></a>

            </p>
        </c:when>
        
        <c:when test="${param.requestType == 5}">
            <h4 class="black" style="padding:5px 0 5px 0;"><strong>SUBTOTAL: $<c:out value="${order.orderBilling.lineItemTotal}" /></strong></h4>
			<h4 class="black" style="padding-bottom:5px;"><strong>SHIPPING: $<c:out value="${order.orderBilling.shippingPrice}" /></strong></h4>
			<h4 class="blue" style="padding-bottom:10px;"><span class="black" style="font-weight: bold">TAX: $<c:out value="${order.orderBilling.tax.taxAmt}" /></span><br />
				<span class="xsmall">(<a href="#">Why are there taxes?</a>)</span></h4>
			<h4 class="black" style="padding-bottom:10px;"><strong>&nbsp;TOTAL: $<c:out value="${order.orderBilling.orderTotal}" /></strong></h4>
			<p class="blue" style="padding-bottom:10px;">&nbsp;</p>
        </c:when>

    </c:choose>

	</div>
