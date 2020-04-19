package backend.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dto.ProductDTO;
import backend.exception.ProductNotFoundException;
import backend.model.Product;
import backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long create(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		product = productRepository.save(product);
		
		return product.getId();
	}

	@Override
	public void update(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		productRepository.save(product);
	}

	@Override
	public ProductDTO getById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new ProductNotFoundException("Product not found.");
		}
		
		Product product = optional.get();
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(product, productDTO);
		
		return productDTO;
	}

	@Override
	public List<ProductDTO> findAll() {
		Iterable<Product> iterable = productRepository.findAll();

		List<ProductDTO> result = StreamSupport.stream(iterable.spliterator(), false).map(new Function<Product, ProductDTO>() {
			@Override
			public ProductDTO apply(Product product) {
				ProductDTO productDTO = new ProductDTO();
				BeanUtils.copyProperties(product, productDTO);
				
				return productDTO;
			}
		}).collect(Collectors.toList());

		return result;
	}

	@Override
	public void deleteByUserIdAndId(Long userId, Long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			if(product.getUserId() == userId) {
				productRepository.deleteById(id);
			}
		}		
	}	
}
