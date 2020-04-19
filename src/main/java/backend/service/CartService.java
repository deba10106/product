package backend.service;

import backend.dto.CartResponseDTO;

public interface CartService {

	public void addProduct(long userId, long productId);
	
	public void removeProduct(long userId, long productId);
	
	public CartResponseDTO getUserCart(long userId);
	
	public void cartClosedForOrder(long userId);
	
}
