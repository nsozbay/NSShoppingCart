<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Shopping Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">

            <div align="center">
                <br/>
                <table>
	                <c:forEach items="${cartItems}" var="cartItem" varStatus="loop">
                    <tr>
                    	<td align="center" style="text-align: center; padding-top: 20px">
                    		<img src="<c:url value="/resources/images/${cartItem.product.id}.png" />" alt="image" style="width:40%"/>
                    	</td>
                        <td width="150">
                        	<table>
                        		<tr>
                        			<td>${cartItem.product.name}</td>
                        		</tr>
                        		<tr>
                        			<td>${cartItem.product.price} TL</td>
                        		</tr>
                        	</table>
                        </td>
                        <td width="100">Qty: ${cartItem.quantity}</td>
                        <td width="100">Total: ${cartItem.totalPrice} TL</td>
                    </tr>
	                </c:forEach>
                    <tr>
                        <th style="text-align: center; padding-top: 20px; padding-bottom: 10px" >${itemsOnBasket} items on your basket</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <th style="text-align: center">
                        	 <a href="<spring:url value="/category/viewCategory/all" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>Continue Shopping</a>
						</th>
                        <th></th>
                        <th>
                        	Total ${grandTotal} TL
                        </th>
                        <th>
                        	<a class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>    	
                        </th>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>
                        	Tax(%18) ${taxTotal} TL
                        </th>
                        <th></th>
                    </tr>
                </table>
                
                
                
                <br/><br/><br/><br/><br/><br/>
            </div>
        </section>

<!-- My -->
<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>