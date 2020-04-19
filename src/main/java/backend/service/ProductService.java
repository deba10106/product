package backend.service;

import org.springframework.stereotype.Service;

import backend.dto.ProductDTO;


public interface ProductService {

	public Long create(ProductDTO productDTO);

	public void update(ProductDTO productDTO);

	public ProductDTO getById(Long userId);

	public List<ProductDTO> findAll();

	public void deleteByUserIdAndId(Long userId, Long id);

}
