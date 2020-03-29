package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.ProductDTO;
import backend.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDTO getById(@PathVariable Long id) {
		return productService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody ProductDTO productDTO) {
		return productService.create(productDTO);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody ProductDTO productDTO) {
		productService.update(productDTO);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
	

	
}
