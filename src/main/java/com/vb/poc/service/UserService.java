package com.vb.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.poc.model.User;
import com.vb.poc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> retrieveUserList() {
		return (List<User>) userRepository.findAll();
	}

	public User retrieveUser(long id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (userOptional.isPresent())
			return userOptional.get();

		return null;
	}

	public User updateUser(long id, User user) {

		User retrievedUser = retrieveUser(id);

		if (retrievedUser == null)
			return retrievedUser;

		if (!user.getFirstname().isEmpty())
			retrievedUser.setFirstname(user.getFirstname());

		if (!user.getLastname().isEmpty())
			retrievedUser.setLastname(user.getLastname());

		if (user.getAge() > 0)
			retrievedUser.setAge(user.getAge());

		return userRepository.save(retrievedUser);
	}

	public String deleteUser(long id) {
		userRepository.deleteById(id);
		return "User "+id+" deleted successfully";
	}
}
