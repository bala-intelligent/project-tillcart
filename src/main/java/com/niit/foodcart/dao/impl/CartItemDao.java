package com.niit.foodcart.dao.impl;


import com.niit.foodcart.model.Cart;
import com.niit.foodcart.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
