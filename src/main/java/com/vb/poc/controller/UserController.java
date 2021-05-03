package com.vb.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vb.poc.model.User;
import com.vb.poc.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/add")
	public ResponseEntity<Object> createNewUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<User> getAllUser() {
		return userService.retrieveUserList();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") long id) {
		return ResponseEntity.ok(userService.retrieveUser(id));
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> removeUser(@PathVariable("id") long id) {
		return ResponseEntity.ok(userService.deleteUser(id));
	}
}
