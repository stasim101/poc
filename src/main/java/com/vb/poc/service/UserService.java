package com.vb.poc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vb.poc.model.User;
import com.vb.poc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(String firstname, String lastname, int age) {
		return userRepository.save(new User(firstname, lastname, age));
	}

	public List<User> retrieveUserList() {
		return (List<User>) userRepository.findAll();
	}

}
