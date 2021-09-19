package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.CropDetail;
@Repository
public interface CropDetailRepository {
	
	List <CropDetail> getAllCropDetails();
	
	CropDetail getCropDetail(String cropName);
	
	void addCropDetail(CropDetail cropDet);
	
//	void updateCropDetail(CropDetail cropDet);
	

}
