package com.fullstackproject.SignUpBackEnd.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackproject.SignUpBackEnd.Model.User;
import com.fullstackproject.SignUpBackEnd.Repository.UserRepository;
import com.fullstackproject.SignUpBackEnd.Service.SequenceGeneratorService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private SequenceGeneratorService sequencegeneratorservice;
	
	//get all users rest api
	@GetMapping("/users")
	public List<User> getAllUers(){
		
		return userrepository.findAll();
	}
	
	// create user rest api(adding user)
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		user.setId(sequencegeneratorservice.generateSequence(User.SEQUENCE_NAME));
		return userrepository.save(user);
	}
	
	
}
 
