package backend.service;

import org.springframework.stereotype.Service;

import backend.dto.UserDTO;


public interface UserService {

	public void create(UserDTO userDTO);
}
