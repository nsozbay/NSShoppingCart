<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-4">
                    <img src="<c:url value="/resources/images/${product.id}.png" />" alt="image" style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.price} TL</p>
                    
                    <br/>
                    
                    <p ng-controller="cartCtrl">
                    	<label for="quantity">Quantity: </label>
                    	<input type="number" id="quantity" name="quantity" class="form-control" min="1" max="100" step="1" value="1" style="width:50px; display: inline;">
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Basket</a>
                        <a href="<spring:url value="/cart/all" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>
                    
                    <br/>
                    
                    <p><strong>Product Details</strong>: ${product.detail}</p>
                    <p><strong>Size</strong>: ${product.size}</p>
                    <p><strong>Colour</strong>: ${product.colour}</p>
                    
                </div>
            </div>
        </div>
		<br/>
        <br/>
        <br/>
<!-- My -->
<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
