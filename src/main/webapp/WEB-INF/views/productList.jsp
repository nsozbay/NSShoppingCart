<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products By Categories</h1>
		</div>

		<table>
			<tr>
				<td valign="top" width="200" >
					<h4>Top Categories</h4>
				    <c:forEach items="${categories}" var="category" varStatus="loop">
					<ul>
							<c:if test="${category.id == selectedCategory.id}">
						        <li style="display: inherit;">
						        	<input type="radio" value="${category.id}" name="options" onclick="document.location='${category.id}';" checked="checked">
						        	<a href="<spring:url value="/category/viewCategory/${category.id}" />">${category.name}</a>
								</li>
						    </c:if>
							<c:if test="${category.id != selectedCategory.id}">
						        <li style="display: inherit;">
						        	<input type="radio" value="${category.id}" name="options" onclick="document.location='${category.id}';" >
						        	<a href="<spring:url value="/category/viewCategory/${category.id}" />">${category.name}</a>
						        </li>
						    </c:if>
					</ul>
					</c:forEach>
				</td>
				
				<td>
					<c:forEach items="${selectedCategory.products}" var="product">
						<div
							style="padding: 5px; width: 250px; margin: 10px; display: inline-block; text-align: left;">
							<ul>
								<li style="text-align: center; display: inherit;"><img
									src="<c:url value="/resources/images/${product.id}.png" />"
									alt="image" style="width: 50%"> <img /></li>
								<li style="text-align: center; display: inherit;"><a
									href="<spring:url value="/product/viewProduct/${product.id}" />">${product.name}</a>
								</li>
							</ul>
						</div>
					</c:forEach>
				</td>
			</tr>
		</table>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>