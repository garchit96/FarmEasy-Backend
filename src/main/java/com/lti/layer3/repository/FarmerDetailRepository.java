package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.FarmerDetail;
@Repository
public interface FarmerDetailRepository {
	
	List<FarmerDetail> getAllFarmerDetails();
	
	FarmerDetail getFarmerDetail(String farmerEmail);
	
	void addFarmerDetails(FarmerDetail farDet);
	
	List<FarmerDetail> farmerLogin(String farmerEmail, String password);
	
//	void updateFarmerDetails(FarmerDetail farDet);
	
	void updateFarmerPassword(String farmerEmail, String newPass  );
	
	void updateFarmerContactNum(String farmerEmail, String newContactNum  );
	
	boolean isPresent(String farmerEmail, String password);
	
//	void deleteFarmerDetails(String farmerEmail);
	

}
