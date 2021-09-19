package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.BidderDetail;


public interface BidderDetailService {
	List<BidderDetail> findAllBidderService();
	   BidderDetail findABidderService(String bidderEmail);
}
