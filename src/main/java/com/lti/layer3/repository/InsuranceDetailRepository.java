package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.InsuranceDetail;
@Repository
public interface InsuranceDetailRepository {
	
	List<InsuranceDetail> getAllInsuranceDetails();
	
	InsuranceDetail getInsuranceDetail(int policyNumber);
	
	void addInsuranceDetail(InsuranceDetail insureDet);
	
	List<Object[]> getAllCropsInsuredByAFarmer(String farmerEmail);
	
	List<Object[]> getAllFarmersForCropInsured(String cropName);
	
//	void addInsuranceClaim(InsuranceDetail insureDet);
		
	

}
