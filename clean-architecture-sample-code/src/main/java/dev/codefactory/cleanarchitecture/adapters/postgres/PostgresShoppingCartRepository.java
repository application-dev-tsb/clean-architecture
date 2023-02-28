package dev.codefactory.cleanarchitecture.adapters.postgres;

import dev.codefactory.cleanarchitecture.core.ports.ShoppingCartRepository;
import dev.codefactory.cleanarchitecture.core.entities.ShoppingCart;
import dev.codefactory.cleanarchitecture.adapters.postgres.dto.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class PostgresShoppingCartRepository implements ShoppingCartRepository {

    private final ShoppingCartEntityRepository repository;

    public PostgresShoppingCartRepository(ShoppingCartEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        var newEntity = ShoppingCartEntity.fromModel(shoppingCart);
        return repository.save(newEntity).toModel();
    }
}

@Repository
interface ShoppingCartEntityRepository extends CrudRepository<ShoppingCartEntity, String> {}
