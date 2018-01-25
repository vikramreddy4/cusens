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
import com.pce.domain.PartnerUser;
import com.pce.repository.PartnerUserRepository;

@Controller
@RequestMapping(path = "/partnerUser")
public class PartnerUserController {
//
//	@Autowired
//	private PartnerUserRepository repository;
//
//	private ResponseEntity<?> validate(PartnerUser partner) {
//		if(partner == null) {
//			return new ResponseEntity<String>("Empty request", HttpStatus.BAD_REQUEST);
//		}
//		if(partner.getCode() == null) {
//			return new ResponseEntity<String>("No PartnerUser code in request", HttpStatus.BAD_REQUEST);
//		}
//		if(partner.getHashCode() == null) {
//			return new ResponseEntity<String>("No Hash code in request", HttpStatus.BAD_REQUEST);
//		}
//		return null;
//	}
//	
//	@PostMapping(path = "/create")
//	public ResponseEntity<?> create(@RequestBody PartnerUser partner) {
//		ResponseEntity<?> validateOuput = validate(partner);
//		if(validateOuput == null) {
//			repository.save(partner);
//			return new ResponseEntity<String>(String.format("PartnerUser (%s) successfully created !!!", partner.getCode()), HttpStatus.CREATED);
//		}
//		return validateOuput;
//	}
//	
//	@PutMapping(path = "/update")
//	public ResponseEntity<?> update(@RequestBody PartnerUser partner) {
//		ResponseEntity<?> validateOuput = validate(partner);
//		if(validateOuput == null) {
//			PartnerUser existingPartnerUser = repository.findOne(partner.getCode());
//			if(existingPartnerUser == null) {
//				return new ResponseEntity<String>(String.format("No PartnerUser found with code : %s",partner.getCode()), HttpStatus.BAD_REQUEST);
//			}
//			repository.save(partner);
//			return new ResponseEntity<String>(String.format("PartnerUser (%s) successfully updated !!!", partner.getCode()), HttpStatus.OK);
//		}
//		return validateOuput;
//	}
//
//	@GetMapping(path = "/{code}")
//	public ResponseEntity<?> search(@PathVariable String code) {
//		if(StringUtils.isEmpty(code)) {
//			return new ResponseEntity<String>("Invalid PartnerUser code", HttpStatus.BAD_REQUEST);
//		}
//		PartnerUser existingPartnerUser = repository.findOne(code);
//		if(existingPartnerUser == null) {
//			return new ResponseEntity<String>(String.format("No PartnerUser found with code : %s",code), HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<Partner>(existingPartner, HttpStatus.OK);
//	}
//
//	@GetMapping(path = "/all")
//	public ResponseEntity<?> getAll() {
//		Iterable<Partner> partners = repository.findAll();
//		if(partners == null) {
//			return new ResponseEntity<String>("No Partners found", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<Iterable<Partner>>(partners, HttpStatus.OK);
//	}
}