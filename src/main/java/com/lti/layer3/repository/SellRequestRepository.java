package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.SellRequest;
@Repository
public interface SellRequestRepository {

	List<SellRequest> getAllSellRequests();
	
	SellRequest getSellRequest(int sellId);
	
	List <SellRequest>getFarmersForACrop(String cropName);
	
	List <SellRequest>getAllCropsOfAFarmer(String farmerEmail);
	
	void addSellRequest(SellRequest sellReq);
	
//	void updateSellRequest(SellRequest sellReq);
	
	void updateApprovalRequest(int sellId, String sellReqStatus);
	
	List<SellRequest> getRequest(String farmerEmail);
	
	void deleteSellRequest(int sellId);
	
	List<Object[]>soldHistory(String farmerEmail);
}
