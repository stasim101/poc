package com.vb.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vb.poc.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/add")
	public ResponseEntity<Object> createNewUser(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") int age) {
		return new ResponseEntity<>(userService.saveUser(firstname, lastname, age), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getAllUser() {
		return ResponseEntity.ok(userService.retrieveUserList());
	}
}
