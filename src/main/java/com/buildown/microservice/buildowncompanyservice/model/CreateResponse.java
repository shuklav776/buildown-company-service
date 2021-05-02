package com.buildown.microservice.buildowncompanyservice.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateResponse {

	@JsonProperty("Status")
	private Integer status;

	@JsonProperty("SuccessDescription")
	private String successDescription;

	@JsonProperty("UnsuccessDescription")
	private String unsuccessDescription;

	@JsonProperty("OperationInfo")
	private String operationInfo;

	@JsonProperty("CompanyData")
	private CompanyModel companyData;

	private HttpStatus httpStatus;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSuccessDescription() {
		return successDescription;
	}

	public void setSuccessDescription(String successDescription) {
		this.successDescription = successDescription;
	}

	public String getUnsuccessDescription() {
		return unsuccessDescription;
	}

	public void setUnsuccessDescription(String unsuccessDescription) {
		this.unsuccessDescription = unsuccessDescription;
	}

	public CompanyModel getCompanyData() {
		return companyData;
	}

	public void setCompanyData(CompanyModel companyData) {
		this.companyData = companyData;
	}

	public String getOperationInfo() {
		return operationInfo;
	}

	public void setOperationInfo(String operationInfo) {
		this.operationInfo = operationInfo;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
