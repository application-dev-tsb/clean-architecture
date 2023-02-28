package dev.codefactory.cleanarchitecture.adapters.postgres;

import dev.codefactory.cleanarchitecture.core.entities.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = "spring.profiles.active=test")
class PostgresShoppingCartRepositoryTest {

    @Autowired
    private PostgresShoppingCartRepository postgresShoppingCartRepository;

    @Test
    void shouldWireRepository() {
        assertNotNull(postgresShoppingCartRepository);
    }

    @Test
    void shouldPersistEntity() {
        ShoppingCart newShoppingCart = new ShoppingCart(null, "Test");

        ShoppingCart savedShoppingCart = postgresShoppingCartRepository.create(newShoppingCart);

        assertNotNull(savedShoppingCart);
        assertNotNull(savedShoppingCart.id());
        assertNotNull(savedShoppingCart.name());
    }
}