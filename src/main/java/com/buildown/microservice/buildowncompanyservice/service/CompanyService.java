package com.buildown.microservice.buildowncompanyservice.service;

import com.buildown.microservice.buildowncompanyservice.model.CompanyModel;
import com.buildown.microservice.buildowncompanyservice.model.CreateResponse;

public interface CompanyService {
	
	CreateResponse createCompany(CompanyModel companyModel);

	CreateResponse getCompanyData(String companyCode);
}
