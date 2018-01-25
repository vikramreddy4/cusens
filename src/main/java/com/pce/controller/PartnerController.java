package com.pce.controller;

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

import com.pce.domain.Partner;
import com.pce.repository.PartnerRepository;

@Controller
@RequestMapping(path = "/partner")
public class PartnerController {

	@Autowired
	private PartnerRepository repository;

	private ResponseEntity<?> validate(Partner partner) {
		if(partner == null) {
			return new ResponseEntity<String>("Empty request", HttpStatus.BAD_REQUEST);
		}
		if(partner.getCode() == null) {
			return new ResponseEntity<String>("No Partner code in request", HttpStatus.BAD_REQUEST);
		}
		if(partner.getHashCode() == null) {
			return new ResponseEntity<String>("No Hash code in request", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody Partner partner) {
		ResponseEntity<?> validateOuput = validate(partner);
		if(validateOuput == null) {
			repository.save(partner);
			return new ResponseEntity<String>(String.format("Partner (%s) successfully created !!!", partner.getCode()), HttpStatus.CREATED);
		}
		return validateOuput;
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> update(@RequestBody Partner partner) {
		ResponseEntity<?> validateOuput = validate(partner);
		if(validateOuput == null) {
			Partner existingPartner = repository.findOne(partner.getCode());
			if(existingPartner == null) {
				return new ResponseEntity<String>(String.format("No Partner found with code : %s",partner.getCode()), HttpStatus.BAD_REQUEST);
			}
			repository.save(partner);
			return new ResponseEntity<String>(String.format("Partner (%s) successfully updated !!!", partner.getCode()), HttpStatus.OK);
		}
		return validateOuput;
	}

	@GetMapping(path = "/{code}")
	public ResponseEntity<?> search(@PathVariable String code) {
		if(StringUtils.isEmpty(code)) {
			return new ResponseEntity<String>("Invalid Partner code", HttpStatus.BAD_REQUEST);
		}
		Partner existingPartner = repository.findOne(code);
		if(existingPartner == null) {
			return new ResponseEntity<String>(String.format("No Partner found with code : %s",code), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Partner>(existingPartner, HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll() {
		Iterable<Partner> partners = repository.findAll();
		if(partners == null) {
			return new ResponseEntity<String>("No Partners found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Iterable<Partner>>(partners, HttpStatus.OK);
	}
}