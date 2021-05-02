package com.buildown.microservice.buildowncompanyservice.api;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buildown.microservice.buildowncompanyservice.model.CompanyModel;
import com.buildown.microservice.buildowncompanyservice.model.CreateResponse;
import com.buildown.microservice.buildowncompanyservice.service.CompanyService;
import com.buildown.microservice.buildowncompanyservice.service.CompanyServiceImpl;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping("/api/v1")
public class CompanyAPI {

	private static Log logger = LogFactory.getLog(CompanyServiceImpl.class);
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/ping")
	public String ping() {
		return "Gathri is a inteligent";
	}

	@PostMapping("/addCompany")
	public ResponseEntity<Object> createCompany(@RequestBody CompanyModel companyModel) {
		logger.info("+++ Entered into CompanyAPI.createCompany api +++");
		try {
			Optional<CreateResponse> response = Optional.ofNullable(companyService.createCompany(companyModel));
			return new ResponseEntity<Object>(response.get(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("--- Exception encountered into CompanyAPI.createCompany api: " + e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/company/{companyCode}")
	public ResponseEntity<Object> getCompanyData(@PathVariable("companyCode") String companyCode) {
		logger.info("+++ Entered into CompanyAPI.getCompanyData api +++");
		if (StringUtils.isNullOrEmpty(companyCode)) {
			logger.info("+++ companyCode is null in CompanyAPI.getCompanyData api +++");
			CreateResponse response = new CreateResponse();
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setUnsuccessDescription(HttpStatus.BAD_REQUEST.toString());
			response.setOperationInfo("CompanyCode Value in request body is null");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			Optional<CreateResponse> response = Optional.ofNullable(companyService.getCompanyData(companyCode));
			return new ResponseEntity<Object>(response.get(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("--- Exception encountered into CompanyAPI.getCompanyData api: " + e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
