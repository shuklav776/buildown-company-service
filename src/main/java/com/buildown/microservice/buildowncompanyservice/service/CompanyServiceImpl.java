package com.buildown.microservice.buildowncompanyservice.service;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.buildown.microservice.buildowncompanyservice.domain.Company;
import com.buildown.microservice.buildowncompanyservice.model.CompanyModel;
import com.buildown.microservice.buildowncompanyservice.model.CreateResponse;
import com.buildown.microservice.buildowncompanyservice.repository.CompanyRepository;
import com.mysql.jdbc.StringUtils;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static Log logger = LogFactory.getLog(CompanyServiceImpl.class);

	@Autowired
	CompanyRepository companyRepository;

	@Transactional
	@Override
	public CreateResponse createCompany(CompanyModel companyModel) {
		logger.info("+++++ Entered into CompanyServiceImpl.createCompany method +++++");
		CreateResponse response = new CreateResponse();
		try {
			Company company = new Company();
			company.setCompanyName(companyModel.getCompanyName());
			company.setCompanyCode(companyModel.getCompanyCode());
			company.setAddress(companyModel.getAddress());
			company.setAddress2(companyModel.getAddress2());
			company.setCity(companyModel.getCity());
			company.setState(companyModel.getState());
			company.setCountry(companyModel.getCountry());
			company.setZip(companyModel.getZip());
			company.setAbout(companyModel.getAbout());
			company.setCreatedDTTM(new Date());
			company.setActive(Boolean.TRUE);
			
			if(!StringUtils.isNullOrEmpty(companyModel.getParentCompanyCode())) {
				Integer parentCompanyID = companyRepository.findCompanyIDByCompanyCode(companyModel.getParentCompanyCode());
				if(parentCompanyID != null) {
					company.setParentCompanyID(parentCompanyID);
				}
			}
			
			companyRepository.save(company);
			response.setStatus(HttpStatus.OK.value());
			response.setSuccessDescription(HttpStatus.OK.toString());
			response.setOperationInfo("SUCCESS");
			response.setHttpStatus(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("--- Exception encountered into CompanyServiceImpl.createCompany method: " + e);
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setOperationInfo("FAIL");
			response.setUnsuccessDescription(e.getMessage());
		}
		return response;
	}

	@Override
	public CreateResponse getCompanyData(String companyCode) {
		logger.info("+++++ Entered into CompanyServiceImpl.getCompanyData method +++++");
		CreateResponse createResponse = new CreateResponse();
		try {
			Optional<Company> company = Optional.ofNullable(companyRepository.findByCompanyCode(companyCode));
			if (!company.isPresent()) {
				logger.info("+++++ Company is not present in DB for companyCode: " + companyCode + " +++++");
				createResponse.setStatus(HttpStatus.NO_CONTENT.value());
				createResponse.setUnsuccessDescription(HttpStatus.NO_CONTENT.toString());
				createResponse.setOperationInfo("Company Not Found For Provided Company Code: " + companyCode);
				createResponse.setHttpStatus(HttpStatus.NO_CONTENT);
				return createResponse;
			}
			CompanyModel companyModel = new CompanyModel();
			companyModel.setCompanyName(company.get().getCompanyName());
			companyModel.setCompanyCode(company.get().getCompanyCode());
			companyModel.setAddress(company.get().getAddress());
			companyModel.setAddress2(company.get().getAddress2());
			companyModel.setCity(company.get().getCity());
			companyModel.setState(company.get().getState());
			companyModel.setZip(company.get().getZip());
			companyModel.setCountry(company.get().getCountry());
			companyModel.setAbout(company.get().getAbout());
			createResponse.setCompanyData(companyModel);
			createResponse.setStatus(HttpStatus.OK.value());
			createResponse.setSuccessDescription(HttpStatus.OK.toString());
			createResponse.setOperationInfo("SUCCESS");
			createResponse.setHttpStatus(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("----- Exception encountered into CompanyServiceImpl.getCompanyData method: " + e);
			createResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			createResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			createResponse.setOperationInfo("FAIL");
			createResponse.setUnsuccessDescription(e.getMessage());
		}
		return createResponse;
	}

}
