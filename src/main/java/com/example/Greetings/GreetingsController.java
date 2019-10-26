package com.example.Greetings;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.Page;

@RestController
@RequestMapping
public class GreetingsController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/greeting")
	public String showGreetings() {
		return "Hello on the other side";
	}
		
	
	@GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}
