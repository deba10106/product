package backend.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDTO {

	private BigDecimal totalPrice = new BigDecimal (0);
	
	List<ProductDTO> products = new ArrayList<>();
	
	@Getter
	@Setter
	public static class ProductDTO {
		private String name;
		private BigDecimal price;
	}
}
