package com.lti.layer2.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LIVE_BID database table.
 * 
 */
@Entity
@Table(name="LIVE_BID")
public class LiveBid  {

	@Id
	@GeneratedValue
	@Column(name="BID_ID")
	private int bidId;

	@Temporal(TemporalType.DATE)
	@Column(name="BID_REQ_DATE")
	private Date bidReqDate;

	@Column(name="BIDDER_AMT")
	private double bidderAmt;


	//bi-directional many-to-one association to BidderDetail
	@ManyToOne
	@JoinColumn(name="BIDDER_EMAIL")
	private BidderDetail bidderDetail;

	@ManyToOne
	@JoinColumn(name="SELL_ID")
	private SellRequest sellRequest;

	public LiveBid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LiveBid(int bidId, Date bidReqDate, double bidderAmt, BidderDetail bidderDetail, SellRequest sellRequest) {
		super();
		this.bidId = bidId;
		this.bidReqDate = bidReqDate;
		this.bidderAmt = bidderAmt;
		this.bidderDetail = bidderDetail;
		this.sellRequest = sellRequest;
	}

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

	public BidderDetail getBidderDetail() {
		return bidderDetail;
	}

	public void setBidderDetail(BidderDetail bidderDetail) {
		this.bidderDetail = bidderDetail;
	}

	public SellRequest getSellRequest() {
		return sellRequest;
	}

	public void setSellRequest(SellRequest sellRequest) {
		this.sellRequest = sellRequest;
	}
	
	

}