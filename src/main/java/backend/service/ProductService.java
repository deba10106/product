package backend.service;

import org.springframework.stereotype.Service;

import backend.dto.ProductDTO;


public interface ProductService {

	public void create(ProductDTO productDTO);
}
