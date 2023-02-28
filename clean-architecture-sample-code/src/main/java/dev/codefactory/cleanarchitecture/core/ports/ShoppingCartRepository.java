package dev.codefactory.cleanarchitecture.core.ports;

import dev.codefactory.cleanarchitecture.core.entities.ShoppingCart;

public interface ShoppingCartRepository {

    ShoppingCart create(ShoppingCart shoppingCart);
}
