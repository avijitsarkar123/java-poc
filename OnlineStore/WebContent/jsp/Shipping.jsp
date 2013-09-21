<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="/onlinestore/resources/css/tooltip.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/onlinestore/resources/js/tabber.js"></script>
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/prototype.js"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/scriptaculous.js?load=effects"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/lightbox.js"></script>
    <script type="text/javascript" src="/onlinestore/resources/js/tooltip.js"></script>
    <script type='text/javascript' src='/onlinestore/dwr/engine.js'></script>
    <script type='text/javascript' src='/onlinestore/dwr/util.js'></script>
	<script type='text/javascript' src='/onlinestore/dwr/interface/onlineStoreAjaxService.js'></script>

    <script type="text/javascript">
        // Swallow errors and warnings from DWR; handle appropriately in your app
	     dwr.engine.setErrorHandler(null);
	     dwr.engine.setWarningHandler(null);

         function getStatesByCountry() {
            countryObj = $('country');
            countryCd = countryObj.options[countryObj.selectedIndex].value;
            onlineStoreAjaxService.getStatesByCountry(countryCd, {
                   callback:function(dataFromServer) {
                       dwr.util.removeAllOptions('state');
                       dwr.util.addOptions('state', dataFromServer, 'stateCd', 'stateName');
                   }
            });
        }
        function getShippingRateByShippingMethod(shippingMethodCd) {
        	onlineStoreAjaxService.getShippingRateByShippingMethod(shippingMethodCd, {
                   callback:function(dataFromServer) {
                       $('shippingRateField').innerHTML=dataFromServer;
                       $('shippingRate').value=dataFromServer;
                   }
            });
        }
        function loadShippingAddressFromBillingAddress() {
        	onlineStoreAjaxService.getShippingAddressSameAsBillingAddress({
                   callback:function(dataFromServer) {
                           fillShipAddress(dataFromServer);
                   }
            });
        }

	     function fillShipAddress(anAddress) {
			dwr.util.setValues(anAddress);
            countryObj = $('country');
            if(countryObj.selectedIndex > 0) {
                getStatesByCountry();
            }
        }
        function init() {
            countryObj = $('country');
            if(countryObj.selectedIndex > 0) {
                getStatesByCountry();
            }
            shippingMethodTypeObj = $('shippingMethodType');
            if (shippingMethodTypeObj.selectedIndex > 0) {
                setShippingCarier(shippingMethodTypeObj.options[selectedIndex].id, shippingMethodTypeObj.options[selectedIndex].text);
                getShippingRateByShippingMethod(shippingMethodTypeObj.options[selectedIndex].value);
            }
        }
        function doSubmit(action) {
        	
        	if (action == 0) {
        		document.shippingForm.action = "/onlinestore/checkout/loadBillingPage.do";
        	} else {
        		document.shippingForm.action = "/onlinestore/checkout/submitShippingPage.do";
        	}
            document.shippingForm.submit();
        }
        function setShippingCarier(shippingCarrier, shippingMethodName) {
            $('shippingCarrier').value=shippingCarrier;
            $('shippingMethodName').value=shippingMethodName;
        }
        function showErrorMsg(errorMsg) {
            showTooltip(errorMsg);
        }
        function populatePhoneNumber(phoneNumber) {
            phoneNumbers = phoneNumber.split('-');
            if (phoneNumbers.length > 1) {
                $('phone1').value = phoneNumbers[0];
                $('phone2').value = phoneNumbers[1];
                $('phone3').value = phoneNumbers[2];
            }
        }
    </script>
</head>

<body>
<c:import url="Header.jsp"/>
<div id="content">
<div id="col1">
    <c:import url="TasqLogo.jsp"></c:import>
</div>

<div id="col2">
        <c:import url="BreadCrumb.jsp"/>
		<div id="category">
            <div id="dhtmltooltip"></div>
            <script type="text/javascript">var tipobj=$("dhtmltooltip");</script>
            <FORM name="shippingForm" method="post">

            <c:set var="orderForm" value="${sessionScope.orderForm}"/>
            <h2>Shipping Information</h2>
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. </p>
			<h5>Shipping Address Information</h5>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="no-bottom"><span class="blue"><span class="orange">* = Required Field</span></span></td>
						<td class="no-bottom">
							<div align="right">
								<input type="radio" name="radio" id="radio6" value="radio" onclick="loadShippingAddressFromBillingAddress()"/>
							</div>
						</td>
						<td width="150" class="no-bottom">Same as Billing Address</td>
				</tr>
			</table>
			<table width="536" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="blue">Full Name <span class="orange">* </span></td>
					<td>
                        <spring:bind path="orderForm.shippingName">
                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError"  onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="name" value="<c:out value="${status.value}"/>"/>
                        </spring:bind>
                    </td>
				</tr>
                <tr>
					<td class="blue">Company Name</td>
					<td>
                        <input name="textfield5" type="text" class="input" id="textfield17" />
                    </td>
				</tr>
                <tr>
					<td class="blue">Address 1 <span class="orange">* </span></td>
					<td>
                        <spring:bind path="orderForm.shippingAddressLine1">
                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError"  onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="addressLine1" value="<c:out value="${status.value}"/>"/>
                        </spring:bind>
                    </td>
				</tr>
				<tr>
					<td class="blue"> Address 2</td>
					<td>
                        <spring:bind path="orderForm.shippingAddressLine2">
                            <input name="<c:out value="${status.expression}"/>" type="text" class="input" id="addressLine2" value="<c:out value="${status.value}"/>"/>
                        </spring:bind>
                    </td>
				</tr>
				<tr>
					<td class="blue">City<span class="orange"> * </span></td>
					<td>
                        <spring:bind path="orderForm.shippingCity">
                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError"  onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> id="city" value="<c:out value="${status.value}"/>"/>
                        </spring:bind>
                    </td>
				</tr>
				<tr>
					<td class="blue">Country <span class="orange">* </span></td>
					<td><label>
                        <spring:bind path="orderForm.shippingCountry">
                            <select name="<c:out value="${status.expression}"/>" onchange="getStatesByCountry()" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="country">
                                <option value="" selected="selected">Please select ...</option>
                                <c:forEach var="country" items="${orderForm.countryList}">
					                <option value="<c:out value="${country.countryCd}" />" <c:if test="${status.value == country.countryCd}">selected="selected"</c:if>><c:out value="${country.countryName}" /></option>
                                </c:forEach>
                            </select>
                        </spring:bind>
						</label></td>
				</tr>
				<tr>
					<td class="blue">State <span class="orange">* </span></td>
					<td>
                        <spring:bind path="orderForm.shippingState">
                            <select name="<c:out value="${status.expression}"/>" <c:choose><c:when test="${status.error}">class="inputrdmError"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="state">
                                <option value="" selected="selected">Please select ...</option>
                                <%--<c:forEach var="state" items="${states}">
					                <option value="<c:out value="${state.state}" />" <c:if test="${status.value == state.state}">selected="selected"</c:if>><c:out value="${state.name}" /></option>
                                </c:forEach>--%>
                            </select>
                        </spring:bind>
                    </td>
				</tr>
				<tr>
					<td class="blue">Zip <span class="orange">* </span></td>
					<td>
                        <spring:bind path="orderForm.shippingZip">
                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError"  onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="inputmed" id="zip" value="<c:out value="${status.value}"/>"/>
                        </spring:bind>
                    </td>
				</tr>
				<tr>
					<td class="blue">Phone <span class="orange">* </span></td>
					<td>(
						<input name="phone1" type="text" class="inputsm" id="textfield4" maxlength="3" />
						)&nbsp;
						<input name="phone2" type="text" class="inputsm" id="textfield8" maxlength="3" />
						-
						<input name="phone3" type="text" class="input-phone" id="textfield15" maxlength="4" />
                        <c:if test="${orderForm.shippingPhoneNumber != ''}" >
                            <script>populatePhoneNumber('<c:out value="${orderForm.shippingPhoneNumber}" />');</script>
                        </c:if>
                    </td>
				</tr>
            </table>
            <h5>Shipping Method</h5>
			<table width="536" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="no-bottom">
                        <spring:bind path="orderForm.shippingCarrier">
                            <input type="hidden" name="<c:out value="${status.expression}"/>" id="shippingCarrier" value=""/>
                        </spring:bind>
                        <spring:bind path="orderForm.shippingMethodName">
                            <input type="hidden" name="<c:out value="${status.expression}"/>" id="shippingMethodName" value=""/>
                        </spring:bind>
                        <spring:bind path="orderForm.shippingMethodCode">
                            <select name="<c:out value="${status.expression}"/>" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> onchange="setShippingCarier(this[selectedIndex].id, this[selectedIndex].text);getShippingRateByShippingMethod(this[selectedIndex].value)" id="shippingMethodType">
                                <option>Select Your Carrier and Option</option>
                                <c:forEach var="shipMethod" items="${orderForm.shippingMethods}">
					                <option id="<c:out value="${shipMethod.carrier}" />" value="<c:out value="${shipMethod.shippingMethodCd}" />" <c:if test="${status.value == shipMethod.shippingMethodCd}">selected="selected"</c:if>><c:out value="${shipMethod.shippingMethodName}" /></option>
                                </c:forEach>
                            </select>
                        </spring:bind>
                    </td>
					<td class="no-bottom"><div align="right" class="blue-bold">
                        <spring:bind path="orderForm.shippingRate">
                            <input type="hidden" name="<c:out value="${status.expression}"/>" id="shippingRate" value=""/>
                        </spring:bind>
                        <h4 class="dkorange"><strong>Shipping: $<span id="shippingRateField"></span></strong></h4>
					</div></td>
				</tr>
			</table>
            <table width="536" border="0" cellspacing="0" cellpadding="0">
                <tr>
					<td class="no-bottom"><span style="padding-bottom:5px;">
						<input type="image" src="/onlinestore/resources/images/button-back.gif" name="back" id="back" onclick="doSubmit('0');"/>
						</span></td>
					<td class="no-bottom"><div align="right"><span style="padding-bottom:5px;">&nbsp;
							<input type="image" src="/onlinestore/resources/images/button-next.gif" name="next" id="next" onclick="doSubmit('2');"/>
							&nbsp;</span></div></td>
				</tr>
			</table>

        </FORM>
        </div>
	</div>

 <div id="col3">
      <c:import url="RightPane.jsp">
          <c:param name="requestType" value="3" />
      </c:import>
 </div>
 <div class="clear"></div>
</div>
<script type="text/javascript">init()</script>
<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>

</body>
</html>



