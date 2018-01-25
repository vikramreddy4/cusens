package com.pce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pce.domain.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	
	List<AppUser> findByPartnerCode(String partnerCode);
	List<AppUser> findByEmailAndPartnerCode(String email, String partnerCode);

}