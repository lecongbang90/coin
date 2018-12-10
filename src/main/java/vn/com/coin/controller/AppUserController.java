package vn.com.coin.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.coin.dao.AppUserRepository;
import vn.com.coin.entity.AppUser;
import vn.com.coin.model.ResultError;
import vn.com.coin.model.ResultSuccess;

@RestController
public class AppUserController {

	@Autowired
	private AppUserRepository appUserRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping(path = "/all")
	public @ResponseBody ResponseEntity<?> getAllUsers() {
		// This returns a JSON or XML with the users
		try {
			List<AppUser> list = (List<AppUser>) appUserRepository.findAll();
			return new ResponseEntity<List<AppUser>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResultError>(new ResultError(e.getMessage()), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(path = "/add", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.POST })
	public @ResponseBody ResponseEntity<?> addUser(@RequestBody AppUser user) throws ConstraintViolationException {
		try {
			appUserRepository.save(user);
			return new ResponseEntity<ResultSuccess>(new ResultSuccess("add success", true), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResultSuccess>(new ResultSuccess(e.getMessage(), false),
					HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(path = "/one")
	public @ResponseBody List<AppUser> getUserbyNameAndId() {
		// This returns a JSON or XML with the users
		return appUserRepository.getUserbyNameAndId("a", 1);
	}
}
