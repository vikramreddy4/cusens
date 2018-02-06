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

import com.pce.domain.User;
import com.pce.repository.PartnerUserRepository;

@Controller
@RequestMapping(path = "/partnerUser/v1")
public class UserController {

	@Autowired
	private PartnerUserRepository repository;

	private ResponseEntity<?> validate(User partnerUser) {
		if(partnerUser == null) {
			return new ResponseEntity<String>("Empty request", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(partnerUser.getPartner())) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(partnerUser.getEmail())) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody User partnerUser) {
		ResponseEntity<?> validateOuput = validate(partnerUser);
		if(validateOuput == null) {
			repository.save(partnerUser);
			return new ResponseEntity<String>(String.format("AppUser (%s) successfully created !!!", partnerUser.getEmail()), HttpStatus.CREATED);
		}
		return validateOuput;
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> update(@RequestBody User partnerUser) {
		ResponseEntity<?> validateOuput = validate(partnerUser);
		if(validateOuput == null) {
			List<User> existingPartnerUsers = repository.findByEmailAndPartnerCode(partnerUser.getEmail(), partnerUser.getPartner().getCode());
			if(existingPartnerUsers == null || existingPartnerUsers.isEmpty()) {
				return new ResponseEntity<String>(String.format("No AppUser found email : %s",partnerUser.getEmail()), HttpStatus.BAD_REQUEST);
			}
			repository.save(partnerUser);
			return new ResponseEntity<String>(String.format("AppUser (%s) successfully updated !!!", partnerUser.getEmail()), HttpStatus.OK);
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
		List<User> existingPartnerUsers = repository.findByEmailAndPartnerCode(email, partner);
		if(existingPartnerUsers == null || existingPartnerUsers.isEmpty()) {
			return new ResponseEntity<String>(String.format("No AppUser found with email : %s",email), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(existingPartnerUsers.get(0), HttpStatus.OK);
	}

	@GetMapping(path = "partner/{partner}/all")
	public ResponseEntity<?> getAll(@PathVariable String partner) {
		if(StringUtils.isEmpty(partner)) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		Iterable<User> partnerUsers = repository.findByPartnerCode(partner);
		if(partnerUsers == null) {
			return new ResponseEntity<String>("No Users found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Iterable<User>>(partnerUsers, HttpStatus.OK);
	}
}