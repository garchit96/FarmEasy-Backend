package com.lti.layer4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.SellRequest;
import com.lti.layer3.repository.SellRequestRepository;

@Service
public class SellRequestServiceImpl implements SellRequestService {
	@Autowired
	SellRequestRepository sellRequestRepo;
	
	@Override
	@Transactional  //controller s code ?
	public List<SellRequest> getAllCropsOfAFarmerService(String farmerEmail) {
		try {
			List<SellRequest> crops=sellRequestRepo.getAllCropsOfAFarmer(farmerEmail);
			return crops;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException ("crop not found");
		}
	}

	@Override
	@Transactional
	public List<SellRequest> getFarmersForACropService(String cropName) {
		try {
			List<SellRequest> farmers=sellRequestRepo.getFarmersForACrop(cropName);
			return farmers;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException ("farmer not found");
		}
	}

	@Transactional
	public void addSellRequestService(SellRequest sellReq) {
		sellRequestRepo.addSellRequest(sellReq);
		
	}

	@Transactional
	public List<Object[]> viewSoldHistoryService(String farmerEmail) {
		List<Object[]>list=sellRequestRepo.soldHistory(farmerEmail);
		return list;
	}

	@Transactional
	public List<SellRequest> getRequestDetailService(String farmerEmail) {
		List<SellRequest> details=sellRequestRepo.getRequest(farmerEmail);
		return details;
	}

}
