package com.lti.layer4.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.CropDetail;
import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
import com.lti.layer3.repository.CropDetailRepository;
import com.lti.layer3.repository.FarmerDetailRepository;
import com.lti.layer3.repository.LiveBidRepository;
import com.lti.layer3.repository.SellRequestRepository;
import com.lti.layer5.dto.MarketPlaceDto;


@Service
public class FarmerDetailServiceImpl implements FarmerDetailService {
	
	@Autowired
	FarmerDetailRepository farmerDetailRepo;
	
	@Autowired
	SellRequestRepository sellRequestRepo;
	
	@Autowired
	CropDetailRepository cropDetailRepo;
	
	@Autowired
	LiveBidRepository liveBidRepo;
	
	
	
	
	@Transactional
	public List<FarmerDetail> findAllFarmerService() {
		List<FarmerDetail> allFarmers=farmerDetailRepo.getAllFarmerDetails();
		
		return allFarmers;
	}

	@Transactional
	public FarmerDetail findAFarmerService(String farmerEmail) {
		FarmerDetail farmer=farmerDetailRepo.getFarmerDetail(farmerEmail);
		return farmer;
	}

	@Transactional
	public MarketPlaceDto MarketViewService(String cropName, int sellId, List<LiveBid> liveBid) {
		CropDetail crop=cropDetailRepo.getCropDetail(cropName);
		SellRequest price=sellRequestRepo.getSellRequest(sellId);
		List<LiveBid> bid=liveBidRepo.getMaxBidForSellId(sellId);
		List<Object[]> allbids=liveBidRepo.getAllBidsForSellId(sellId);
		MarketPlaceDto mp=new MarketPlaceDto();
		mp.setCropDetail(crop);
		mp.setAllbids(allbids);
		mp.setLiveBids(bid);
		mp.setSellRequest(price);
		System.out.println(mp);
		return mp;
	}

	

}
