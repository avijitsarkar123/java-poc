<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript" >
    function doSearch(selObj) {
        if (selObj.selectedIndex > 0) {
            document.manuForm.submit();
        }
    }
</script>
    <div id="manufacturers">
			<div class="hptitle">Manufacturer</div>
			<form name="form" id="manuForm" action="/onlinestore/parts/search.do" method="post">
                <input type="hidden" name="searchBy" value='manufacturer' />

                <c:set var="manufacturerList" value="${sessionScope.manufacturerList}"/>
                <select name="manufacturerId" class="searchmanu" id="manufacturerListId" onchange="doSearch(this)">
					<option selected="selected">Select...</option>
                    <c:forEach var="manufacturer" items="${manufacturerList}">
					    <option value="<c:out value="${manufacturer.id}" />"><c:out value="${manufacturer.manufacturerName}" /></option>
                    </c:forEach>
                </select>
			</form>
	</div>
