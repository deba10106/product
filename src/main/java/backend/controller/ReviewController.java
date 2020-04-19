package backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.ReviewDTO;
import backend.model.Review;
import backend.service.ReviewService;
import backend.service.ReviewServiceImpl;



@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	private Date Today;
	private Object YearMonth;

	@GetMapping("/reviews")
	List<ReviewDTO> all() {

		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUser_id(12345);
		reviewDTO.setStar_rating(4);
		reviewDTO.setRemarks("userRemarksInput");
		reviewDTO.setCreatedDate(Today);
		reviewDTO.setCreatedBy("reviewmaker");
		reviewDTO.setLastUpdateBy("reviewcheker");
		reviewDTO.setLastUpdateDate(Today);


		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		list.add(reviewDTO);
		return list;
	}
	
//	@PutMapping("/users")
//	List<String> put() {
//		UserDTO userDTO = new UserDTO();
//		userDTO.setEmail("erwin@erwin.com");
//		userDTO.setName("erwin");	
//		userService.create(userDTO);
//		System.out.print("erwin");
//		return new ArrayList<>();
//	}
	
}
