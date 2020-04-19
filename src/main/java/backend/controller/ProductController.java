package backend.controller;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.ProductDTO;
import backend.service.ProductService;
import backend.service.ProductServiceImpl;



@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	private Date Today;
	private Object YearMonth;

	@GetMapping("/products")
	List<ProductDTO> all() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName("Mala HotPot");
		productDTO.setDescription("best product in the world");
		productDTO.setCategory("good");
		
        productDTO.setPrice(102);	
        productDTO.setStatus("Available");
		productDTO.setExpiryDate(Today);
		productDTO.setCreatedDate(Today);
		productDTO.setCreatedBy("Suravi");
		productDTO.setLastUpdateBy("Suravi");
		productDTO.setLastUpdateDate(Today);

		//userService.create(userDTO);
		//System.out.print("erwin");
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		list.add(productDTO);
		return list;
	}
	

	
}
