package com.pce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pce.domain.PartnerAttributeConfig;

@Repository
public interface PartnerAttributeConfigRepository extends CrudRepository<PartnerAttributeConfig, Long> {

	List<PartnerAttributeConfig> findByPartnerCode(String partnerCode);
	List<PartnerAttributeConfig> findByPartnerCodeAndAttributeName(String partnerCode, String attributeName);

}