package backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dto.ProductDTO;
import backend.model.Product;
import backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public void create(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		productRepository.save(product);
	}
}
