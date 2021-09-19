package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
@Repository
public class LiveBidRepositoryImpl implements LiveBidRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<LiveBid> getAllLiveBids() {
		List<LiveBid> liveBids = entityManager.createQuery("from LiveBid").getResultList();
		return liveBids;
	}

	@Transactional
	public LiveBid getLiveBid(int bidId) {
		LiveBid liveBid=entityManager.find(LiveBid.class, bidId);
		return liveBid;
	}

	@Transactional
	public void addLiveBid(LiveBid bid) {
		entityManager.merge(bid);

	}
	@Transactional
	public List<Object[]> getAllBidsForSellId(int sellId) {
//		List <LiveBid> liveBidList=entityManager.createQuery("from LiveBid where sellId="+sellId).getResultList();
//		return liveBidList;
//		List <LiveBid> liveBidList=entityManager.createNativeQuery("select * from live_bid where sell_id="+sellId+")", LiveBid.class).getResultList();
//		return liveBidList;
		Query query=entityManager.createNativeQuery("select * from live_bid where sell_id in (select sr.sell_id from sell_request sr, live_bid lb where sr.sell_id=lb.sell_id) and sell_id="+sellId);
		List<Object[]> liveBids=query.getResultList();
		return liveBids ;
		
	}
	@Transactional
	public List<LiveBid> bidsForSellId(int sellId) {
//		List <LiveBid> liveBidList=entityManager.createQuery("from LiveBid where sellId="+sellId).getResultList();
//		return liveBidList;
//		List <LiveBid> liveBidList=entityManager.createNativeQuery("select * from live_bid where sell_id="+sellId+")", LiveBid.class).getResultList();
//		return liveBidList;
		Query query=entityManager.createNativeQuery("select * from live_bid where sell_id="+sellId, LiveBid.class);
		List<LiveBid> liveBids=query.getResultList();
		return liveBids ;
		
	}
	
	
	
	@Transactional
	public List <LiveBid> getMaxBidForSellId(int sellId) {
		List <LiveBid> maxBid=entityManager.createNativeQuery("select * from live_bid where bidder_amt=(select max(bidder_amt) from live_bid where sell_id="+sellId+")", LiveBid.class).getResultList();
		                                                       //select * from live_bid where bidder_amt=(select max(bidder_amt) from live_bid where sell_id=101);
		return maxBid;                                       //select * from live_bid where bidder_amt=(select max(bidder_amt) from live_bid where sell_id="+sellId+")"
	}
	
	@Transactional
	public List<LiveBid> getMaxBid(int sellId) {
		List <LiveBid> maxBid=entityManager.createNativeQuery("select max(bidder_amt), sell_id from live_bid where sell_id="+sellId, LiveBid.class).getResultList();
		                                                       //(select max(bidder_amt) from live_bid where sell_id=101);
		return maxBid;
	}

	@Transactional
	public List<Object[]> liveBidsForBidder() {
		Query query=entityManager.createNativeQuery("select lb.bid_id, lb.sell_id, sr.crop_name, sr.base_price, max(lb.bidder_Amt) as current_bid from sell_request sr, live_bid lb where sr.sell_id=lb.sell_id  group by lb.bid_id, lb.sell_id, sr.crop_name, sr.base_price");
		List<Object[]> liveBids=query.getResultList();
		return liveBids ;
	}

	@Transactional
	public void updateLiveBid(int bidId, double newBidAmt) {
		LiveBid liveBid = entityManager.find(LiveBid.class, bidId);
		liveBid.setBidderAmt(newBidAmt);
		entityManager.merge(liveBid);
	
	}
	
	

//	@Transactional
//	public void updateLiveBid(LiveBid bid) {
//		entityManager.merge(bid);
//
//	}

//	@Transactional
//	public void deleteLiveBid(int bidId) {
//	
//     LiveBid liveBid=entityManager.find(LiveBid.class, bidId);
//     entityManager.remove(liveBid);
//
//	}


}