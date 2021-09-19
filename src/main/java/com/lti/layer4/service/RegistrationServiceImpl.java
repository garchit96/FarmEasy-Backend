package com.lti.layer4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer3.repository.BidderDetailRepository;
import com.lti.layer3.repository.FarmerDetailRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	FarmerDetailRepository farmerDetailRepo;
	
	@Autowired
	BidderDetailRepository bidderDetailRepo;

	@Transactional
	public void addFarmerDetailsService(FarmerDetail farDet) {
		farmerDetailRepo.addFarmerDetails(farDet);
		
		
	}

	@Transactional
	public void addBidderDetailsService(BidderDetail bidDet) {
		bidderDetailRepo.addBidderDetails(bidDet);
		
	}

}
