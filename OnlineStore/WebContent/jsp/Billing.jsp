<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="/onlinestore/resources/css/tooltip.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/onlinestore/resources/js/tabber.js"></script>
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript" />
    <script type="text/javascript" src='/onlinestore/resources/js/prototype.js' />
    <script type="text/javascript" src='/onlinestore/resources/js/scriptaculous.js?load=effects'></script>
    <script type="text/javascript" src='/onlinestore/resources/js/lightbox.js'></script>
    <script type="text/javascript" src='/onlinestore/resources/js/tooltip.js'></script>
    <script type='text/javascript' src='/onlinestore/dwr/interface/onlineStoreAjaxService.js'></script>
  	<script type='text/javascript' src='/onlinestore/dwr/engine.js'></script>
  	<script type='text/javascript' src='/onlinestore/dwr/util.js'></script>
    
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

        function init() {
            countryObj = $('country');
            if(countryObj.selectedIndex > 0) {
                getStatesByCountry();
            }
            creditCardTypeObj = $('creditCardType');
            if (creditCardTypeObj.selectedIndex > 0) {
                setCreditCardName(creditCardTypeObj.options[selectedIndex].text, creditCardTypeObj.options[selectedIndex].id);
            }
            populatePhoneNumber();
        }

        function displayPaymentMethod(flag) {
            if (flag == 1) {
                $('creditCardSection').style.display = 'inline';
                $('bankAchSection').style.display = 'none';
            } else {
                $('bankAchSection').style.display = 'inline';
                $('creditCardSection').style.display = 'none';
            }
            $('billingAddressInformation').style.display = 'inline';
        }
        
        function doSubmit() {
	        document.billingForm.action = "/onlinestore/checkout/submitBillingPage.do";
            document.billingForm.submit();
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
     <c:import url="TasqLogo.jsp"/>
</div>

<div id="col2">
        <c:import url="BreadCrumb.jsp"/>
        <div id="dhtmltooltip"></div>
        <script type="text/javascript">var tipobj=$("dhtmltooltip");</script>
        <div id="category">
            <FORM name="billingForm" method="post">
            
            <c:set var="shoppingCart" value="${sessionScope.shoppingCart}"/>
            <h2>Billing Information</h2>
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. </p>
			<h5>Select Payment Method</h5>
			<table width="500" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="10" class="no-bottom">
						<form:radiobutton path="orderForm.paymentType" value="CC" id="creditCardRadio" onclick="displayPaymentMethod(1)"/>
					</td>
					<td width="70" class="no-bottom">
						<label for="orderForm.paymentType"> Credit Card</label>&nbsp;
					</td>
					<td class="no-bottom"><img src="/onlinestore/resources/images/credit-cards.gif" alt="credit cards accepted" width="133" height="20" /></td>
				</tr>
				<tr>
					<td class="no-bottom">
						<form:radiobutton path="orderForm.paymentType" value="ACH" id="achRadio" onclick="displayPaymentMethod(0)"/>
					</td>
					<td colspan="2" class="no-bottom"><label for="orderForm.paymentType">Bank ACH</label> &nbsp; </td>
				</tr>
			</table>
			
			<div id="bankAchSection" style="display: none;">
				<h5>Bank ACH Information</h5>
				<table width="536" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="180" class="blue">Bank Name</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.bankTypeId">
		                        <select name="<c:out value="${status.expression}"/>" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="creditCardType" >
									<option selected="selected">Please select...</option>
		                            <c:forEach var="bank" items="${orderForm.bankList}">
							            <option id="<c:out value="${bank.bankCd}" />" value="<c:out value="${bank.id}" />" <c:if test="${status.value == bank.id}">selected="selected"</c:if>><c:out value="${bank.bankName}" /></option>
		                            </c:forEach>
								</select>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Account Number</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.accountNumber">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> id="textfield6" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">ABA/Routing Number</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.bankAbaNumber">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="inputsm" id="textfield12" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
						</td>
					</tr>
				</table>
			</div>
			<div id="creditCardSection" style="display: none;">
	            <h5>Credit Card Information</h5>
				<table width="536" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="180" class="blue">Credit Card Type</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.creditCardTypeId">
		                        <select name="<c:out value="${status.expression}"/>" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="creditCardType" >
									<option selected="selected">Select...</option>
		                            <c:forEach var="creditCardType" items="${orderForm.creditCardTypes}">
							            <option id="<c:out value="${creditCardType.creditCardCd}" />" value="<c:out value="${creditCardType.id}" />" <c:if test="${status.value == creditCardType.id}">selected="selected"</c:if>><c:out value="${creditCardType.creditCardName}" /></option>
		                            </c:forEach>
								</select>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Credit Card Number</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.partialCardNumber">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> id="textfield6" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Expiration Date</td>
						<td>
	                        <select name="expMonth" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="select4">
								<option>01</option>
								<option>02</option>
								<option>02</option>
								<option>03</option>
								<option>04</option>
								<option>05</option>
								<option>06</option>
								<option>07</option>
								<option>08</option>
								<option>09</option>
								<option>10</option>
								<option>11</option>
								<option>12</option>
							</select>
							/
							<select name="expYear" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="select5">
								<option>2007</option>
								<option>2008</option>
								<option>2009</option>
								<option>2010</option>
								<option>2011</option>
								<option>2012</option>
							</select></td>
					</tr>
					<tr>
						<td class="blue">Credit Card Validation (CCV)</td>
						<td>
	                        <spring:bind path="orderForm.paymentDataBean.ccv">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="inputsm" id="textfield12" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                        <a href="#">(What is this?)</a></td>
					</tr>
				</table>
			</div>
			<div id="billingAddressInformation" style="display: none;">
				<h5>Billing Address Information</h5>
				<p> Please enter the billing address that is used for the credit card/bank account referenced above.</p>
				<p class="orange">* = Required Field</p>
				<table width="536" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="blue">Name <span class="orange">* </span></td>
						<td>
	                        <spring:bind path="orderForm.billingName">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield7" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Address 1 <span class="orange">* </span></td>
						<td>
	                        <spring:bind path="orderForm.billingAddressLine1">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield10" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue"> Address 2</td>
						<td>
	                        <spring:bind path="orderForm.billingAddressLine2">
	                            <input name="<c:out value="${status.expression}"/>" type="text" class="input" id="textfield11" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">City<span class="orange"> * </span></td>
						<td>
	                        <spring:bind path="orderForm.billingCity">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield2" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Country <span class="orange">* </span></td>
						<td><label>
	                        <spring:bind path="orderForm.billingCountry">
	                            <select name="<c:out value="${status.expression}"/>" onchange="getStatesByCountry()" <c:choose><c:when test="${status.error}">class="inputrdmError"onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="country">
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
	                        <spring:bind path="orderForm.billingState">
	                            <select name="<c:out value="${status.expression}"/>" <c:choose><c:when test="${status.error}">class="inputrdmError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="inputrdm"</c:otherwise></c:choose> id="state">
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
	                        <spring:bind path="orderForm.billingZip">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="inputmed" id="textfield3" value="<c:out value="${status.value}"/>"/>
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
	                        <c:if test="${orderForm.billingPhoneNumber != ''}" >
	                            <script>populatePhoneNumber('<c:out value="${orderForm.billingPhoneNumber}" />');</script>
	                        </c:if>
	                    </td>
					</tr>
					<tr>
						<td class="no-bottom"><span style="padding-bottom:5px;">
							<input type="image" src="/onlinestore/resources/images/button-back.gif" name="back" id="back" />
							</span></td>
						<td class="no-bottom"><div align="right"><span style="padding-bottom:5px;">&nbsp;
								<input type="image" src="/onlinestore/resources/images/button-next.gif" name="next" id="next" onclick="doSubmit();"/>
								&nbsp;</span></div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

 <div id="col3">
            <%-- <c:import url="RightPane.jsp">
                <c:param name="requestType" value="2" />
            </c:import> --%>
            <%--<div id="specials">
                <p><img src="/onlinestore/resources/images/free-shipping.jpg" alt="Free Shipping" width="135" height="73" /></p>
                <h3>Free Shipping!</h3>
                    <p>When you place an order <br />
                        of $100 or more, the shipping is on us<br />
                         <a href="#" class="info1">Learn More<span>This is where we are going to put the information when you hover over this link</span></a>
            </div>--%>
 </div>
 <div class="clear"></div>
</div>

<c:if test="${sessionScope.orderForm.paymentType == 'CC'}">
	<script>displayPaymentMethod(1);</script>
</c:if>
<c:if test="${sessionScope.orderForm.paymentType == 'ACH'}">
	<script>displayPaymentMethod(0);</script>
</c:if>

<!-- <script type="text/javascript">init()</script>  -->
<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>

</body>
</html>




