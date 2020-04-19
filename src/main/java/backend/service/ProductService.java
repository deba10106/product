package backend.service;

import java.util.List;

import backend.dto.ProductDTO;


public interface ProductService {

	public Long create(ProductDTO productDTO);

	public void update(ProductDTO productDTO);

	public ProductDTO getById(Long userId);

	public List<ProductDTO> findAll();

	public void deleteByUserIdAndId(Long userId, Long id);
	
	public List<ProductDTO> getProductByUserID(Long userId);
}
