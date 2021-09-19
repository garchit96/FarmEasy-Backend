package com.lti.layer4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.SellRequest;
import com.lti.layer3.repository.SellRequestRepository;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	SellRequestRepository sellRequestRepo;

	@Transactional//meaning that any failure causes the entire operation to roll back to 
				  //its previous state and to re-throw the original exception.
	public List<SellRequest> getAllSellRequestsService() {
		List<SellRequest>requests=sellRequestRepo.getAllSellRequests();
		return requests;
	}

	@Transactional
	public void updateApprovalRequestService(int sellId, String sellReqStatus) {
		sellRequestRepo.updateApprovalRequest(sellId, sellReqStatus);
		
	}

	@Transactional
	public void deleteSellRequestService(int sellId) {
		sellRequestRepo.deleteSellRequest(sellId);
		
	}

	

}
