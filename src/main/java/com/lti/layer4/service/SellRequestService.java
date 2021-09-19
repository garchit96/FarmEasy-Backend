package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.SellRequest;

public interface SellRequestService {
	List <SellRequest>getAllCropsOfAFarmerService(String farmerEmail);
	
	List <SellRequest>getFarmersForACropService(String cropName);
	void addSellRequestService(SellRequest sellReq);
	
	List<Object[]>viewSoldHistoryService(String farmerEmail);
	
	List<SellRequest> getRequestDetailService(String farmerEmail);
}
