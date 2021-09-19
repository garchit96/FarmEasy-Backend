package com.lti.layer5.dto;

import java.util.Date;

public class LiveBidDto {
	private int bidId;
	private Date bidReqDate;
	private double bidderAmt;
	private String bidderEmail;
	private int sellId;
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public Date getBidReqDate() {
		return bidReqDate;
	}
	public void setBidReqDate(Date bidReqDate) {
		this.bidReqDate = bidReqDate;
	}
	public double getBidderAmt() {
		return bidderAmt;
	}
	public void setBidderAmt(double bidderAmt) {
		this.bidderAmt = bidderAmt;
	}
	public String getBidderEmail() {
		return bidderEmail;
	}
	public void setBidderEmail(String bidderEmail) {
		this.bidderEmail = bidderEmail;
	}
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	
	
	
}
