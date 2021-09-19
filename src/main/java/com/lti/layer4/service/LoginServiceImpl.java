package com.lti.layer4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer3.repository.BidderDetailRepository;
import com.lti.layer3.repository.FarmerDetailRepository;
import com.lti.layer5.dto.BidderDto;
import com.lti.layer5.dto.FarmerDto;


@Service
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	FarmerDetailRepository farmerDetailRepo;
	
	@Autowired
	BidderDetailRepository bidderDetailRepo;
	
	@Transactional
	public boolean isFarmerPresentService(String farmerEmail, String password) {
		
		boolean res=farmerDetailRepo.isPresent(farmerEmail, password);
		
		return res;	
		
	}

	

	@Transactional
	public boolean isBidderPresentService(String bidderEmail, String password) {
    boolean res=bidderDetailRepo.isPresent(bidderEmail, password);
		
		return res;	
	}

	

	@Transactional
	public void updateFarmerPasswordService(String farmerEmail, String newPass) {
		try {
			farmerDetailRepo.updateFarmerPassword(farmerEmail, newPass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		
	}

	@Transactional
	public void updateBidderPasswordService(String bidderEmail, String newPass) {
		try {
			bidderDetailRepo.updateBidderPassword(bidderEmail, newPass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		
	}



}
