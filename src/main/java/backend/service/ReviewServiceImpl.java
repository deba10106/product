package backend.service;

import backend.dto.ReviewDTO;
import backend.model.Review;
import backend.repository.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	public void create(ReviewDTO reviewDTO) {
		Review review = new Review();
		BeanUtils.copyProperties(reviewDTO, review);
		reviewRepository.save(review);
	}
}
