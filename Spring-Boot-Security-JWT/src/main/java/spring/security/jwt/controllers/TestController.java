package spring.security.jwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin (origins = "*")
@RestController
@RequestMapping ("/api/test")
public class TestController {

	@GetMapping ("/all")
public String allAccess() {
	return "Hello World ! ";
}
@GetMapping ( "/admin")
@PreAuthorize("hasRole('ADMIN')")
public String adminAccess() {
	return "Hello Admin ! ";
	}
@GetMapping("/user")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public String userAccess() {
	return "Hello User ! ";
}
@GetMapping ("/mod")
@PreAuthorize("hasRole('MODERATOR')")
public String modAccess() {
	return "Hello Mod ! ";
}

}
