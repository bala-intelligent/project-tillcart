
var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/foodcart/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       }).error(function(data,status){
    	   alert("dai");
       })
    };

    $scope.clearCart = function(){
    	alert("cleared");
        $httpdelete('/foodcart/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };
   
    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
    	alert('hi'); 
        $http.put('/foodcart/rest/cart/add/' + productId).success(function (){
            alert('Product successfully added to the cart!');
        }).error(function (data,status){
            alert('Product is not added to the cart!');
            console.log("bye")
        })
    };
 
    $scope.removeFromCart = function(productId){
    	alert("delete?");
        $http.put('/foodcart/rest/cart/remove/' + productId).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;
alert("came");
        for (var i = 0; i < $scope.cart.cartItems.length; i++)
        {
        	alert("needed");
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});