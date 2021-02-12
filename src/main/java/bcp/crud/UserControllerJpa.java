package bcp.crud;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/jpa")
public class UserControllerJpa {

	private Logger log = LoggerFactory.getLogger(UserControllerJpa.class);

	@Autowired
	private UserRepositoryJpa userRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/until")
	public List<User> retrieveUsersBeforeDate(
			@RequestParam(name = "dhDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dhDate,
			@RequestParam(name = "dhTimestamp", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dhTimestamp,
			@RequestParam(name = "dtNotimeDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtNotimeDate,
			@RequestParam(name = "dtNotimeTimestamp", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtNotimeTimestamp) {
		
		if (dhDate != null) {		
			log.info("Find User dhDate before: {}", dhDate);
			return userRepository.findByDhDateLessThanEqual(dhDate);
		} else if (dhTimestamp != null) {		
			log.info("Find User dhTimestamp before: {}", dhTimestamp);
			return userRepository.findByDhTimestampLessThanEqual(dhTimestamp);
		} else if (dtNotimeDate != null) {		
			log.info("Find User dtNotimeDate before: {}", dtNotimeDate);
			return userRepository.findByDtNotimeDateLessThanEqual(dtNotimeDate);
		} else if (dtNotimeTimestamp != null) {		
			log.info("Find User dtNotimeTimestamp before: {}", dtNotimeTimestamp);
			return userRepository.findByDtNotimeTimestampLessThanEqual(dtNotimeTimestamp);
		}
		throw new UserNotFoundException("Missing data RequestParam");
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		log.info("Retrieve user: {}", user.get());
		return user.get();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		log.info("Create user: {}", user);
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}

}