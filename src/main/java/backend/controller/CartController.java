package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.CartResponseDTO;
import backend.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@PutMapping("/users/{userId}/carts/products/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public void addToCart(@PathVariable long userId, @PathVariable long productId) {
		cartService.addProduct(userId, productId);
	}
	
	@DeleteMapping("/users/{userId}/carts/products/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public void removeFromCart(@PathVariable long userId, @PathVariable long productId) {
		cartService.removeProduct(userId, productId);
	}
	
	@GetMapping("/users/{userId}/carts")
	@ResponseStatus(HttpStatus.OK)
	public CartResponseDTO getUserCart(@PathVariable long userId) {
		return cartService.getUserCart(userId);
	}
	
	@DeleteMapping("/users/{userId}/carts/{cartId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCartForOrder(@PathVariable long userId, @PathVariable long cartId) {
		cartService.cartClosedForOrder(userId, cartId);
	}
}
