package com.buildown.microservice.buildowncompanyservice.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.buildown.microservice.buildowncompanyservice.domain.Company;

@Repository
public interface CompanyRepository
		extends PagingAndSortingRepository<Company, Integer>, JpaSpecificationExecutor<Company> {
	
	Company findByCompanyCode(String companyCode);
	
	@Query("SELECT o.companyID FROM Company o WHERE o.companyCode = ?1")
	Integer findCompanyIDByCompanyCode(String companyCode);
}
