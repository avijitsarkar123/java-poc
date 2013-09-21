<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store - User Registration</title>
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
        function doSubmit() {
            document.userRegistrationForm.submit();
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
<div id="content">
<div id="col1">
</div>

<div id="col2">
		<div id="dhtmltooltip"></div>
		<script type="text/javascript">var tipobj=$("dhtmltooltip");</script>
        <div id="category">
            <FORM name="userRegistrationForm" method="post" action="/onlinestore/userManagement/register.do">
            
            <h2>User Account Information</h2>
			
			<div id="userRegistrationInformation">
				<h5>User Registration</h5>
				<p class="orange">* = Required Field</p>
				
				<table width="536" border="0" cellpadding="0" cellspacing="0">
				
					<c:if test="${empty userForm.openId}">
					
						<tr>
							<td class="blue">User Name <span class="orange">* </span></td>
							<td>
		                        <spring:bind path="userForm.userName">
		                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield1" value="<c:out value="${status.value}"/>"/>
		                        </spring:bind>
		                    </td>
						</tr>
						<tr>
							<td class="blue">Password <span class="orange">* </span></td>
							<td>
		                        <spring:bind path="userForm.password">
		                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield2" value="<c:out value="${status.value}"/>"/>
		                        </spring:bind>
		                    </td>
						</tr>
						<tr>
							<td class="blue">Confirm Password <span class="orange">* </span></td>
							<td>
		                        <spring:bind path="userForm.confirmPassword">
		                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield3" value="<c:out value="${status.value}"/>"/>
		                        </spring:bind>
		                    </td>
						</tr>
				</c:if>
				
					<tr>
						<td class="blue">First Name <span class="orange">* </span></td>
						<td>
	                        <spring:bind path="userForm.firstName">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield4" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Last Name <span class="orange">* </span></td>
						<td>
	                        <spring:bind path="userForm.lastName">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield5" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Email Address <span class="orange">* </span></td>
						<td>
	                        <spring:bind path="userForm.emailAddress">
	                            <input name="<c:out value="${status.expression}"/>" type="text" <c:choose><c:when test="${status.error}">class="inputError" onmouseover="showErrorMsg('<c:out value="${status.errorMessages[0]}" />')" onMouseout="hideTooltip()"</c:when><c:otherwise>class="input"</c:otherwise></c:choose> class="input" id="textfield6" value="<c:out value="${status.value}"/>"/>
	                        </spring:bind>
	                    </td>
					</tr>
					<tr>
						<td class="blue">Phone </td>
						<td>
							(<input name="phone1" type="text" class="inputsm" id="textfield7" maxlength="3" />)&nbsp;
							<input name="phone2" type="text" class="inputsm" id="textfield8" maxlength="3" /> -
							<input name="phone3" type="text" class="input-phone" id="textfield9" maxlength="4" />
	                    </td>
					</tr>
					<tr>
						<td class="no-bottom"><span style="padding-bottom:5px;">
							<input type="image" src="/onlinestore/resources/images/button-cancel.png" name="back" id="back" />
							</span></td>
						<td class="no-bottom"><div align="right"><span style="padding-bottom:5px;">&nbsp;
								<input type="image" src="/onlinestore/resources/images/button-submit.png" name="next" id="next" onclick="doSubmit();"/>
								&nbsp;</span></div></td>
					</tr>
				</table>
			</div>
		</FORM>
		</div>
	</div>

 <div id="col3">
 </div>
 <div class="clear"></div>
</div>

</body>
</html>




