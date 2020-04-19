package backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.UserDTO;
import backend.service.UserService;
import backend.service.UserServiceImpl;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	List<UserDTO> all() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("erwin@erwin.com");
		userDTO.setUsername("erwin");
		userDTO.setName("erwin");	
		
		userDTO.setPassword("password");	
		//userService.create(userDTO);
		System.out.print("erwin");
		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(userDTO);
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
