package com.lti.layer2.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the ADDRESS_DETAILS database table.
 * 
 */
@Entity
@Table(name="ADDRESS_DETAILS")
public class AddressDetail  {
	

	@Id
	@GeneratedValue
	@Column(name="ADDRESS_ID")
	private int addressId;

	@Column(name="ADDRESS_LINE", length=20)
	private String addressLine;
    @Column(length=15)
	private String city;

	private int pincode;

	@Column(name="STATE", length=15)
	private String state;

	//bi-directional one-to-one association to FarmerDetail
	@OneToOne(mappedBy="addressDetail")
	private FarmerDetail farmerDetail;

	//bi-directional one-to-one association to BidderDetail
	@OneToOne(mappedBy="addressDetail")
	private BidderDetail bidderDetail;

	public AddressDetail(int addressId, String addressLine, String city, int pincode, String state,
			FarmerDetail farmerDetail, BidderDetail bidderDetail) {
		super();
		this.addressId = addressId;
		this.addressLine = addressLine;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.farmerDetail = farmerDetail;
		this.bidderDetail = bidderDetail;
	}

	public AddressDetail() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine() {
		return this.addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@JsonIgnore
	public FarmerDetail getFarmerDetail() {
		return this.farmerDetail;
	}

	public void setFarmerDetail(FarmerDetail farmerDetail) {
		this.farmerDetail = farmerDetail;
	}

	public BidderDetail getBidderDetail() {
		return this.bidderDetail;
	}

	public void setBidderDetail(BidderDetail bidderDetail) {
		this.bidderDetail = bidderDetail;
	}

	

}