<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>Online Store - Sign In</title>
<link href="/onlinestore/resources/css/login.css" rel="stylesheet" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>

<body>

<!-- Box Start-->
<div id="box_bg">

<div id="content">
	<h1>Online Store - Sign In</h1>
	
	<c:url var="openIDLoginUrl" value="/processOpenIDLogin" />
	<form action="${openIDLoginUrl}" method="post" name="googleForm">
		<input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>
	</form>
	
	<!-- Social Buttons -->
	<div class="social">
		Sign in using social network:<br>
		<div class="google"><a href="#" class="btn_1" onclick="document.googleForm.submit();"></a></div>
		<div class="fb"><a href="#" class="btn_2"></a></div>
	</div>
	
	<!-- Login Fields -->
	
	<form action="processLogin" method="POST" name="userForm">
		<div id="login">Sign in using your registered account:<br>
		
		<input type="text" id="loginName"	name="loginName" value="Username" onfocus="if(this.value==&#39;Username&#39;)this.value=&#39;&#39;;" onblur="if(this.value==&#39;&#39;)this.value=&#39;Username&#39;;"  class="login user">
		<input type="text" id="loginPassword" name="loginPassword" value="Password" onfocus="if(this.value==&#39;&#39; || this.value == &#39;Password&#39;) {this.value=&#39;&#39;;this.type=&#39;password&#39;}" onblur="if(this.value == &#39;&#39;) {this.type=&#39;text&#39;;this.value=this.defaultValue}" class="login password">
		</div>
		
		<!-- Green Button -->
		<div class="button green"><a href="#" onclick="document.userForm.submit();">Sign In</a></div>
		
		<!-- Checkbox -->
		<div class="checkbox">
		<li>
		<fieldset>
			<legend id="title2" class="desc"></legend>
			<span style="color:red; top: 40%; position: relative; height: 100px; margin-top: -50px;">${error}</span>
		</fieldset>
		</li>
		</div>
		
	</form>

</div>
</div>

<!-- Text Under Box -->
<div id="bottom_text">
	Don't have an account? <a href="/onlinestore/userManagement/register.do">Sign Up</a><br>
	Remind <a href="#">Password</a>
</div>



</body></html>
