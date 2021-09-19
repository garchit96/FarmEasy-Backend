package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
@Repository
public class SellRequestRepositoryImpl implements SellRequestRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<SellRequest> getAllSellRequests() {
		List<SellRequest> sellRequest = entityManager.createQuery("from SellRequest").getResultList();
		return sellRequest;
		
	}
	
	@Transactional
	public SellRequest getSellRequest(int sellId) {
		SellRequest sellRequest=entityManager.find(SellRequest.class, sellId);
		return sellRequest;
	}

	@Transactional
	public void addSellRequest(SellRequest sellReq) {
		entityManager.merge(sellReq);

	}

//	@Transactional
//	public void updateSellRequest(SellRequest sellReq) {
//		entityManager.merge(sellReq);
//
//	}
	
	@Transactional
	public void updateApprovalRequest(int sellId, String sellReqStatus) {
		SellRequest sellRequest=entityManager.find(SellRequest.class, sellId);
		sellRequest.setSellReqStatus(sellReqStatus);
		entityManager.merge(sellRequest);

	}


	@Transactional
	public void deleteSellRequest(int sellId) {
		SellRequest sellRequest=entityManager.find(SellRequest.class, sellId);
		entityManager.remove(sellRequest);
	}

//	@Transactional
//	public List<Object[]> getFarmersForACrop(String cropName) {
//		//Query query=entityManager.createNativeQuery("select * from sell_request where crop_name in (select cd.crop_name from sell_request sr, crop_details cd where sr.crop_name=cd.crop_name) and crop_name="+cropName);
//		Query query=entityManager.createNativeQuery("select * from sell_request where crop_name in (select cd.crop_name from sell_request sr, crop_details cd where sr.crop_name=cd.crop_name) and crop_name="+"'"+cropName+"'");
//		List<Object[]> farmers=query.getResultList();
//		return farmers ;
//		
//	}
	
	
	@Transactional
	public List <SellRequest> getFarmersForACrop(String cropName) {
		List <SellRequest> farmers=entityManager.createNativeQuery("select * from sell_request where crop_name="+"'"+cropName+"'"+" order by sell_Id", SellRequest.class).getResultList();
		                                                       //select * from live_bid where bidder_amt=(select max(bidder_amt) from live_bid where sell_id=101);
		return farmers;
	}
	
//	@Transactional
//	public List<Object[]> getAllCropsOfAFarmer(String farmerEmail) {
//		
//		Query query=entityManager.createNativeQuery("select * from sell_request where farmer_email in (select fd.farmer_email from sell_request sr, farmer_details fd where sr.farmer_email=fd.farmer_email) and farmer_email="+"'"+farmerEmail+"'");
//		List<Object[]> crops=query.getResultList();
//		return crops ;
//		
//	}
	@Transactional
	public List <SellRequest> getAllCropsOfAFarmer(String farmerEmail) {
		List <SellRequest> crops=entityManager.createNativeQuery("select * from sell_request where farmer_email="+"'"+farmerEmail+"'"+" order by sell_Id", SellRequest.class).getResultList();
		                                                       //select * from live_bid where bidder_amt=(select max(bidder_amt) from live_bid where sell_id=101);
		return crops;
	}

	@Transactional
    public List<Object[]> soldHistory(String farmerEmail) 
	{
	Query query=entityManager.createNativeQuery("select sr.sellReq_date, cd.crop_name, sr.quantity_kg, cd.msp, sr.sold_price, sr.total_price from crop_details cd, sell_request sr where cd.crop_name=sr.crop_name and sr.farmer_email="+"'"+farmerEmail+"'");
	List<Object[]> soldCrops=query.getResultList();
	return soldCrops;
    }

	@Transactional
	public List<SellRequest> getRequest(String farmerEmail) {
		List<SellRequest> request = entityManager.createNativeQuery("select * from sell_request where farmer_email="+"'"+farmerEmail+"'" , SellRequest.class).getResultList();
		return request;
		
		
	}
	}


