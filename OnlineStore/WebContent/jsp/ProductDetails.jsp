<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Online Store</title>
    <link href="/onlinestore/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <script src="/onlinestore/resources/js/jump.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/tabber.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/prototype.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/lightbox.js" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/scriptaculous.js?load=effects" type="text/javascript"></script>
    <script src="/onlinestore/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
</head>

<body>
<c:import url="Header.jsp"/>
<div id="content">
    <div id="col1">
        <%-- <c:import url="Search.jsp"/> --%>
        <c:import url="LeftPane.jsp"/>
    </div>

    <DIV id="col2">
        <DIV id="product-image">
            <P>
                <img src="<c:out value="${part.primaryPicture}" />" alt="<c:out value="${part.partName}" />" />
            </P>

            <P>
                <A href="#"  rel="lightbox">
                    <IMG class="img"  src="<c:out value="${part.primaryPicture}" />" alt="<c:out value="${part.partName}" />" height="39" width="39"/>
                </A>
                <A href="#"  rel="lightbox">
                    <IMG class="img"  src="<c:out value="${part.primaryPicture}" />" alt="<c:out value="${part.partName}" />" height="39" width="39"/>
                </A>
			</P>
        </DIV>

        <DIV id="product-text"><H1><c:out value="${part.partName}" /></H1>

            <P>
                <img src="<c:out value="${part.manufacturer.manufacturerLogo}" />" alt="<c:out value="${part.manufacturer.manufacturerName}" />" height="28" width="75"/>
            </P>

            <P class="blue">
                <SPAN class="blue-lg">
                    Model Number: <c:out value="${part.modelNumber}" /><BR/>
                </SPAN>
            </P>
            <p>
            	<a href="/onlinestore/shoppingCart/addCartItem.do?partId=<c:out value="${part.id}" />"><img src="/onlinestore/resources/images/addtocart.png" alt="Add to Cart" border="0" /></a>
            </p>

            <DIV class="tabber" style="MARGIN-BOTTOM: 25px">
                <DIV class="tabbertab">
                	<H2>Description</H2>
                    <P><c:out value="${part.partDescription}" /></P>
                </DIV>

                <DIV class="tabbertab">
                	<H2>Tech Specs</H2>
                	<UL>
                		<LI>Intuitive touch screen display for ease of use </LI>
                		<LI>Fast terminal downloads using IP or dial-up over a standard 56K modem </LI>
                		<LI>Easily supports both IP and dial-up with Secure Sockets Layer (SSL) encryption </LI>
                    	<LI>True 32-bit processing (ARM 920T 32-bit CPU core) </LI>
                    	<LI>Drop-in paper-loading system is quick and hassle-free </LI>
                    	<LI>Fast printer capable of 15 lines per second </LI>
                    	<LI>IP capability with dial-up as connectivity backup </LI>
                    	<LI>Compact design </LI>
                    	<LI>Durable keys </LI>
                    	<LI>Touch screen capability with 128 x 64 graphic LCD display </LI>
                    	<LI>Merchant-friendly one-touch feature for daily functions </LI>
                    	<LI>Three-track magnetic stripe reader </LI>
                    	<LI>Contactless support </LI>
                    	<LI>64 MB RAM standard memory </LI>
                    	<LI>Five USB ports </LI>
                    	<LI>Address verification service </LI>
                    	<LI>Batch history</LI>
                    	<LI>Simplified support and installation </LI>
                    	<LI>Integrated 3" wide thermal roll printer </LI>
                    </UL>
                 </DIV>
			</DIV>
		</DIV>

        <DIV class="clear"></DIV></DIV>

    <!-- ------------------------------------------------------ This is where the ShoppingCart is coming ---------------------------------------- -->
    <div id="col3">
        <c:import url="RightPane.jsp"/>
        
        <div id="specials">
        	<p><img src="/onlinestore/resources/images/free-shipping.jpg" alt="Free Shipping" width="135" height="73"/></p>
        	<h3>Free Shipping!</h3>
        	<p>When you place an order <br/>
            of $100 or more, the shipping is on us<br/>
            <a href="#" class="info1">Learn More<span>This is where we are going to put the information when you hover over this link</span></a>
    	</div>
        
    </div>

    <div class="clear"></div>
</div>
<br/><br/>

<c:import url="FooterNav.jsp"/>
<c:import url="Footer.jsp"/>
</body>
</html>