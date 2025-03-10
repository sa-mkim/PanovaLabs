package com.PanovaLabs.shop_platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PanovaLabs.shop_platform.entity.User;
import com.PanovaLabs.shop_platform.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User updateUser(Long id, User newUser) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setUsername(null);
			user.setEmail(newUser.getEmail());
			return userRepository.save(user);
		}
		return null;
	}
	
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;  // 해당 ID가 없으면 삭제 실패
    }
}
