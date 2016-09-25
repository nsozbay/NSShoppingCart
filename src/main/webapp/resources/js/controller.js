var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
    	var productQuantity = document.getElementById('quantity').value;
        $http.get('/NSShoppingCart/cart/add?productId=' + productId + '&productQuantity=' + productQuantity).success(function (){
            alert(productQuantity +' Product successfully added to the cart!');
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});