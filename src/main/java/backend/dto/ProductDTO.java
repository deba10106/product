package backend.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private long id;
	private String name;
	private Long userId;
	private String description;
	private BigDecimal price;
	private ZonedDateTime expiryAt;
}
