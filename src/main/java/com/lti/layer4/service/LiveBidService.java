package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.LiveBid;

public interface LiveBidService {
	List<LiveBid> getMaxBidForSellIdService(int sellId);
	
	List<LiveBid> getMaxBidService(int sellId);
	
	void addLiveBidService(LiveBid bid);
	
	List<LiveBid> getAllLiveBidsService();
	
	List<Object[]> liveBidsForBidderService();
	
	void updateBidService(int bidId, double newBidAmt);
	
	List<LiveBid> bidsForSellIdService(int sellId);
}
