package com.lti.layer4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.LiveBid;
import com.lti.layer3.repository.LiveBidRepository;


@Service
public class LiveBidServiceImpl implements LiveBidService {
	@Autowired
	LiveBidRepository liveBidRepository;

	@Transactional
	public List<LiveBid> getMaxBidForSellIdService(int sellId) {
		List<LiveBid> bids= liveBidRepository.getMaxBidForSellId(sellId);
		return bids;
	}

	@Transactional
	public void addLiveBidService(LiveBid bid) {
		liveBidRepository.addLiveBid(bid);
		
	}

	@Transactional
	public List<LiveBid> getAllLiveBidsService() {
		List<LiveBid> bids=liveBidRepository.getAllLiveBids();
		return bids;
	}

	@Transactional
	public List<Object[]> liveBidsForBidderService() {
		List<Object[]> bids=liveBidRepository.liveBidsForBidder();
		return bids;
	}
	@Transactional
	public List<LiveBid> getMaxBidService(int sellId){
		List<LiveBid> bids=liveBidRepository.getMaxBid(sellId);
		return bids;
		
	}

	@Transactional
	public void updateBidService(int bidId, double newBidAmt) {
		liveBidRepository.updateLiveBid(bidId, newBidAmt);
		
	}
	

	@Transactional
	public List<LiveBid> bidsForSellIdService(int sellId){
		List<LiveBid> bids=liveBidRepository.bidsForSellId(sellId);
		return bids;
	}

}
