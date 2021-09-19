package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.FarmerLandDetail;
@Repository
public interface FarmerLandDetailRepository {
	
    List <FarmerLandDetail> getAllLandDetails();
	
    FarmerLandDetail getLandDetail(String landAddress);
	
	void addLandDetail(FarmerLandDetail landDet);
//	void updateLandDetail(String farmerEmail, String landAddress, int pincode, double landArea);
//	void deleteLandDetail(String landAddress);

}
