package com.example.Greetings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<User> getQuestions(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @PostMapping("/users")
    public User createQuestion(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}
