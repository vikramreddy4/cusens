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

import com.pce.domain.PartnerAttributeConfig;
import com.pce.repository.PartnerAttributeConfigRepository;

@Controller
@RequestMapping(path = "/partnerAttrConfig")
public class PartnerAttributeConfigController {

	@Autowired
	private PartnerAttributeConfigRepository repository;

	private ResponseEntity<?> validate(PartnerAttributeConfig partnerAttributeConfig) {
		if(partnerAttributeConfig == null) {
			return new ResponseEntity<String>("Empty request", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(partnerAttributeConfig.getPartner())) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(partnerAttributeConfig.getAttributeName())) {
			return new ResponseEntity<String>("Invalid Attribute Name", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(partnerAttributeConfig.getAttributeType())) {
			return new ResponseEntity<String>("Invalid Attribute Type", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody PartnerAttributeConfig partnerAttributeConfig) {
		ResponseEntity<?> validateOuput = validate(partnerAttributeConfig);
		if(validateOuput == null) {
			repository.save(partnerAttributeConfig);
			return new ResponseEntity<String>(String.format("Attribute (%s) successfully added !!!", partnerAttributeConfig.getAttributeName()), HttpStatus.CREATED);
		}
		return validateOuput;
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> update(@RequestBody PartnerAttributeConfig partnerAttributeConfig) {
		ResponseEntity<?> validateOuput = validate(partnerAttributeConfig);
		if(validateOuput == null) {
			List<PartnerAttributeConfig> existingPartnerAttributeConfigs = repository.findByPartnerCodeAndAttributeName(partnerAttributeConfig.getPartner().getCode() ,partnerAttributeConfig.getAttributeName());
			if(existingPartnerAttributeConfigs == null || existingPartnerAttributeConfigs.isEmpty()) {
				return new ResponseEntity<String>(String.format("No Attribute found  : %s",partnerAttributeConfig.getAttributeName()), HttpStatus.BAD_REQUEST);
			}
			repository.save(partnerAttributeConfig);
			return new ResponseEntity<String>(String.format("Attribute (%s) successfully updated !!!", partnerAttributeConfig.getAttributeName()), HttpStatus.OK);
		}
		return validateOuput;
	}

	@GetMapping(path = "partner/{partner}/attribute/{attribute}/")
	public ResponseEntity<?> search(@PathVariable String partner, @PathVariable String attribute) {
		if(StringUtils.isEmpty(partner)) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(attribute)) {
			return new ResponseEntity<String>("Invalid Attribute", HttpStatus.BAD_REQUEST);
		}
		List<PartnerAttributeConfig> existingPartnerAttributeConfigs = repository.findByPartnerCodeAndAttributeName(partner, attribute);
		if(existingPartnerAttributeConfigs == null || existingPartnerAttributeConfigs.isEmpty()) {
			return new ResponseEntity<String>(String.format("No Attribute found with name : %s", attribute), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PartnerAttributeConfig>(existingPartnerAttributeConfigs.get(0), HttpStatus.OK);
	}

	@GetMapping(path = "partner/{partner}/all")
	public ResponseEntity<?> getAll(@PathVariable String partner) {
		if(StringUtils.isEmpty(partner)) {
			return new ResponseEntity<String>("Invalid Partner", HttpStatus.BAD_REQUEST);
		}
		Iterable<PartnerAttributeConfig> partnerAttributeConfigs = repository.findByPartnerCode(partner);
		if(partnerAttributeConfigs == null) {
			return new ResponseEntity<String>("No Attributes found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Iterable<PartnerAttributeConfig>>(partnerAttributeConfigs, HttpStatus.OK);
	}
}