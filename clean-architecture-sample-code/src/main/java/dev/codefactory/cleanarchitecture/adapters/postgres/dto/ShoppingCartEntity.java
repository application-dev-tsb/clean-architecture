package dev.codefactory.cleanarchitecture.adapters.postgres.dto;

import dev.codefactory.cleanarchitecture.core.entities.ShoppingCart;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

public class ShoppingCartEntity {

    @Id
    UUID id;

    @Column("cart_name")
    String name;

    public ShoppingCartEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public ShoppingCart toModel() {
        return new ShoppingCart(id.toString(), name);
    }
    public static ShoppingCartEntity fromModel(ShoppingCart shoppingCart) {
        return new ShoppingCartEntity(shoppingCart.id()==null ? null : UUID.fromString(shoppingCart.id()), shoppingCart.name());
    }
}
