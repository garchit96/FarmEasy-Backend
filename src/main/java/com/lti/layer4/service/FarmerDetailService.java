package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.CropDetail;
import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
import com.lti.layer5.dto.MarketPlaceDto;


public interface FarmerDetailService {
   List<FarmerDetail> findAllFarmerService();
   FarmerDetail findAFarmerService(String farmerEmail);
   
  MarketPlaceDto MarketViewService(String cropName, int sellId, List<LiveBid> liveBid);
}
