package backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import backend.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>, QueryByExampleExecutor<Cart> {
	

}
