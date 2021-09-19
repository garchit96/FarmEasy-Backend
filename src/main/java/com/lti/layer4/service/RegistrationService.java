package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.FarmerDetail;

public interface RegistrationService {
	
	 void addFarmerDetailsService(FarmerDetail farDet);
	 void addBidderDetailsService(BidderDetail bidDet);
}
