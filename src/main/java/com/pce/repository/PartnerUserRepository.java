package com.pce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pce.domain.Partner;
import com.pce.domain.PartnerUser;

@Repository
public interface PartnerUserRepository extends CrudRepository<PartnerUser, String> {
	
	List<PartnerUser> findByPartnerCode(String partnerCode);
	List<PartnerUser> findByEmailAndPartnerCode(String email, String partnerCode);

}