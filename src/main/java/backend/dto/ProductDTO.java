package backend.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private long id;
	private String name;
	private String description;
	private BigDecimal price;
}
