package backend.controller;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.ProductDTO;
import backend.service.ProductService;
import backend.service.ProductServiceImpl;



@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	private Date Today;
	private Object YearMonth;

	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> findAll() {
		return productService.findAll();
	}

	@GetMapping("/products/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDTO getById(@PathVariable Long id) {
		return productService.getById(id);
	}

	@PostMapping("/users/{userId}/products")
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@PathVariable Long userId, @RequestBody ProductDTO productDTO) {
		productDTO.setUserId(userId);
		return productService.create(productDTO);
	}

	@PutMapping("/users/{userId}/products/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long userId, @RequestBody ProductDTO productDTO) {
		productDTO.setUserId(userId);
		productService.update(productDTO);
	}

	@DeleteMapping(value = "/users/{userId}/products/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long userId, @PathVariable("id") Long id) {
		productService.deleteByUserIdAndId(userId, id);
	}
	

	
}
