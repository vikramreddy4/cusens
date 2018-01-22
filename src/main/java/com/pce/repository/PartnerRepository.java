package com.pce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pce.domain.Partner;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, String> {
	List<Partner> findByHashCode(String hashCode);

//	@Query("SELECT sr FROM SitterRank sr where sr.rank <= :rankTerm")
//	List<User> searchSitters(@Param("rankTerm") String rankTerm);

//	List<SitterRank> findByOrderByRankDesc();

}