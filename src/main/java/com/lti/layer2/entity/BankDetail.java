package com.lti.layer2.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the BANK_DETAILS database table.
 * 
 */
@Entity
@Table(name="BANK_DETAILS")
public class BankDetail  {
	

	@Id
	@GeneratedValue
	@Column(name="ACCOUNT_ID")
	private int accountId;

	@Column(name="ACCOUNT_NUM", length=15)
	private String accountNum;

	@Column(name="IFSC_CODE", length=15)
	private String ifscCode;

	//bi-directional one-to-one association to BidderDetail
	@OneToOne(mappedBy="bankDetail")
	private BidderDetail bidderDetail;

	//bi-directional one-to-one association to FarmerDetail
	@OneToOne(mappedBy="bankDetail")
	private FarmerDetail farmerDetail;

	public BankDetail(int accountId, String accountNum, String ifscCode, BidderDetail bidderDetail,
			FarmerDetail farmerDetail) {
		super();
		this.accountId = accountId;
		this.accountNum = accountNum;
		this.ifscCode = ifscCode;
		this.bidderDetail = bidderDetail;
		this.farmerDetail = farmerDetail;
	}

	public BankDetail() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public BidderDetail getBidderDetail() {
		return this.bidderDetail;
	}

	public void setBidderDetail(BidderDetail bidderDetail) {
		this.bidderDetail = bidderDetail;
	}
	@JsonIgnore
	public FarmerDetail getFarmerDetail() {
		return this.farmerDetail;
	}

	public void setFarmerDetail(FarmerDetail farmerDetail) {
		this.farmerDetail = farmerDetail;
	}

	

}