package com.lti.layer5.dto;

import java.util.List;

import com.lti.layer2.entity.CropDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;

public class MarketPlaceDto {
	//cropname, LiveBid, and sid
	
	private CropDetail cropDetail;  // cropname here
	private SellRequest sellRequest; //u can push sid here
	private List<LiveBid> liveBids;
//	private int max//livebid here
	
	private List<Object[]> allbids;
	
	public CropDetail getCropDetail() {
		return cropDetail;
	}
	public void setCropDetail(CropDetail cropDetail) {
		this.cropDetail = cropDetail;
	}
	public SellRequest getSellRequest() {
		return sellRequest;
	}
	public void setSellRequest(SellRequest sellRequest) {
		this.sellRequest = sellRequest;
	}
	public List<LiveBid> getLiveBids() {
		return liveBids;
	}
	public void setLiveBids(List<LiveBid> liveBids) {
		this.liveBids = liveBids;
	}
	public List<Object[]> getAllbids() {
		return allbids;
	}
	public void setAllbids(List<Object[]> allbids) {
		this.allbids = allbids;
	}
	
	
}
