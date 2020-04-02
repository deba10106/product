package backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import backend.dto.CartResponseDTO;
import backend.exception.ProductNotFoundException;
import backend.model.Cart;
import backend.model.Product;
import backend.repository.CartRepository;
import backend.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public void addProduct(long userId, long productId) {

		Optional<Product> productOpt = productRepository.findById(productId);
		if (!productOpt.isPresent()) {
			throw new ProductNotFoundException();
		}

		Optional<Cart> cartOpt = getCartByUserId(userId);
		Cart cart = new Cart();
		cart.setUserId(userId);

		if (cartOpt.isPresent()) {
			cart = cartOpt.get();

		}
		Product product = productOpt.get();
		product.getCarts().add(cart);
		cart.getProducts().add(product);

		cartRepository.save(cart);

	}

	@Override
	public void removeProduct(long userId, long productId) {

		Optional<Product> productOpt = productRepository.findById(productId);
		if (!productOpt.isPresent()) {
			return;
		}

		Optional<Cart> cartOpt = getCartByUserId(userId);

		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			Product product = productOpt.get();
			cart.removeProduct(product);
			cartRepository.save(cart);
		}
	}

	@Override
	public CartResponseDTO getUserCart(long userId) {
		Optional<Cart> cartOpt = getCartByUserId(userId);
		CartResponseDTO resp = new CartResponseDTO();

		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			BigDecimal total = new BigDecimal(0);
			for (Product product : cart.getProducts()) {
				if(product.isDeleted()) {
					continue;
				}
				CartResponseDTO.ProductDTO productDTO = new CartResponseDTO.ProductDTO();
				productDTO.setName(product.getName());
				productDTO.setPrice(product.getPrice());
				resp.getProducts().add(productDTO);
				total = total.add(product.getPrice());
			}
			resp.setTotalPrice(total);
		}

		return resp;
	}

	@Override
	public void cartClosedForOrder(long userId, long cartId) {
		Optional<Cart> cartOpt = cartRepository.findById(cartId);
		if(cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			if(cart.getUserId() != userId) {
				return;
			}
			Set<Product> products = cart.getProducts();
			for (Product product: products) {
				product.setDeleted(true);
			}
			cart.setDeleted(true);
			cart.setProducts(products);
			cartRepository.save(cart);
		}
	}
	
	private Optional<Cart> getCartByUserId(long userId) {
		Cart criteria = new Cart();
		criteria.setUserId(userId);

		Example<Cart> exCart = Example.of(criteria);
		return cartRepository.findOne(exCart);
	}
}
