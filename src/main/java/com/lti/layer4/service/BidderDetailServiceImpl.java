package com.lti.layer4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.BidderDetail;

import com.lti.layer3.repository.BidderDetailRepository;
@Service
public class BidderDetailServiceImpl implements BidderDetailService {
	
	@Autowired
	BidderDetailRepository bidderDetailRepo;
	

	@Transactional
	public List<BidderDetail> findAllBidderService() {
     List<BidderDetail> allBidders=bidderDetailRepo.getAllBidderDetails();
		
		return allBidders;
	}

	@Transactional
	public BidderDetail findABidderService(String bidderEmail) {
		BidderDetail bidder=bidderDetailRepo.getBidderDetail(bidderEmail);
		return bidder;
	}

}
