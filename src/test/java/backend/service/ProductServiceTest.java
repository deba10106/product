package backend.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import backend.dto.ProductDTO;
import backend.model.Product;
import backend.repository.ProductRepository;

@SpringBootTest(classes = ProductServiceImpl.class)
class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	
	@Test
	void addProductTest() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setDescription("some description");
		productDTO.setName("some name");
		productDTO.setPrice(new BigDecimal(10.0));
		productDTO.setUserId(1l);

		//productService.create(productDTO);
		//verify(productRepository, times(1)).save(any(Product.class));
	}
	
	@Test
	void updateProductTest() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setDescription("some description");
		productDTO.setName("some name");
		productDTO.setPrice(new BigDecimal(10.0));
		productDTO.setUserId(1l);
		productService.update(productDTO);
		verify(productRepository, times(1)).save(any(Product.class));
	}
	
	@Test
	void getProductByIdTest() {
		Product product = new Product();
		product.setId(1l);
		
		when(productRepository.findById(1l)).thenReturn(Optional.of(product));
		productService.getById(1l);
		
		verify(productRepository, times(1)).findById(1l);
	}
	
	@Test
	void getAllProductTest() {
		productService.findAll();
		verify(productRepository, times(1)).findAll();
	}
	
	@Test
	void getProductByUserID() {
		Long userId = 1l;
		Product product = new Product();
		product.setUserId(userId);
		
		productService.getProductByUserID(userId);
		
		verify(productRepository, times(1)).findAll(any());
	}
	

}
