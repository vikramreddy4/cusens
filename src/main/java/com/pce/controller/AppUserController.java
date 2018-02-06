package com.pce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pce.domain.AppUser;
import com.pce.repository.AppUserRepository;

@Controller
@RequestMapping(path = "/appUser")
public class AppUserController {

	@Autowired
	private AppUserRepository repository;

	private ResponseEntity<?> validate(AppUser appUser) {
		if(appUser == null) {
			return new ResponseEntity<String>("Empty request", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(appUser.getPartner())) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(appUser.getEmail())) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody AppUser appUser) {
		ResponseEntity<?> validateOuput = validate(appUser);
		if(validateOuput == null) {
			repository.save(appUser);
			return new ResponseEntity<String>(String.format("AppUser (%s) successfully created !!!", appUser.getEmail()), HttpStatus.CREATED);
		}
		return validateOuput;
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> update(@RequestBody AppUser appUser) {
		ResponseEntity<?> validateOuput = validate(appUser);
		if(validateOuput == null) {
			List<AppUser> existingAppUsers = repository.findByEmailAndPartnerCode(appUser.getEmail(), appUser.getPartner().getCode());
			if(existingAppUsers == null || existingAppUsers.isEmpty()) {
				return new ResponseEntity<String>(String.format("No AppUser found email : %s",appUser.getEmail()), HttpStatus.BAD_REQUEST);
			}
			repository.save(appUser);
			return new ResponseEntity<String>(String.format("AppUser (%s) successfully updated !!!", appUser.getEmail()), HttpStatus.OK);
		}
		return validateOuput;
	}

	@GetMapping(path = "partner/{partner}/email/{email}/")
	public ResponseEntity<?> search(@PathVariable String partner, @PathVariable String email) {
		if(StringUtils.isEmpty(partner)) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(email)) {
			return new ResponseEntity<String>("Invalid AppUser email", HttpStatus.BAD_REQUEST);
		}
		List<AppUser> existingAppUsers = repository.findByEmailAndPartnerCode(email, partner);
		if(existingAppUsers == null || existingAppUsers.isEmpty()) {
			return new ResponseEntity<String>(String.format("No AppUser found with email : %s",email), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AppUser>(existingAppUsers.get(0), HttpStatus.OK);
	}

	@GetMapping(path = "partner/{partner}/all")
	public ResponseEntity<?> getAll(@PathVariable String partner) {
		if(StringUtils.isEmpty(partner)) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		Iterable<AppUser> appUsers = repository.findByPartnerCode(partner);
		if(appUsers == null) {
			return new ResponseEntity<String>("No Users found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Iterable<AppUser>>(appUsers, HttpStatus.OK);
	}
}