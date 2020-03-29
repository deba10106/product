package backend.dto;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private String category;
	private Integer price;
	private String status;
	private ZonedDateTime expiryDateTime;
	private String createdBy;
	private ZonedDateTime createdDate;
	private String lastUpdatedBy;
	private ZonedDateTime lastUpdatedDate;

}
