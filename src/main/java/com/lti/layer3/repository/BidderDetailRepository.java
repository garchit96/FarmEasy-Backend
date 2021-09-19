package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.FarmerDetail;

@Repository
public interface BidderDetailRepository {
	
	List<BidderDetail> getAllBidderDetails();
	
	BidderDetail getBidderDetail(String bidderEmail);
	
	List<BidderDetail> bidderLogin(String bidderEmail, String password);
	
	void addBidderDetails(BidderDetail bidDet);
//	void updateBidderDetails(BidderDetail bidDet);
	
    void updateBidderPassword(String bidderEmail, String newPass  );
	
	void updateBidderContactNum(String bidderEmail, String newContactNum  );
	
	boolean isPresent(String bidderEmail, String password);
//	void deleteBidderDetails(String bidderEmail);
//	

}
