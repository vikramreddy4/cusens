package com.pce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pce.domain.User;

@Repository
public interface PartnerUserRepository extends CrudRepository<User, String> {
	
	List<User> findByPartnerCode(String partnerCode);
	List<User> findByEmailAndPartnerCode(String email, String partnerCode);

}