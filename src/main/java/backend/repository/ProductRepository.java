package backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import backend.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, QueryByExampleExecutor<Product> {
	

}
