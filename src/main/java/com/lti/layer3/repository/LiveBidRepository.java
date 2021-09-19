package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
@Repository
public interface LiveBidRepository {
	
	List<LiveBid> getAllLiveBids();
	
	List<Object[]> getAllBidsForSellId(int sellId);
	
	List<LiveBid> getMaxBidForSellId(int sellId);
	List<LiveBid> getMaxBid(int sellId);
	
	LiveBid getLiveBid(int bidId);
	
	void addLiveBid(LiveBid bid);
	
	List<Object[]> liveBidsForBidder();
	
	void updateLiveBid(int bidId, double newBidAmt);
	
	List<LiveBid> bidsForSellId(int sellId);
	
//	void deleteLiveBid(int bidId);
	
//	void updateLiveBid(LiveBid bid);
}
