package backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dto.UserDTO;
import backend.model.User;
import backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public void create(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepository.save(user);
	}
}
