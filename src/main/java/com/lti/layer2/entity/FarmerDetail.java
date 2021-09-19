package com.lti.layer2.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the FARMER_DETAILS database table.
 * 
 */

@Entity
@Table(name="FARMER_DETAILS")
public class FarmerDetail  {
//"farmerEmail": "aamir18@gmail.com",
//    "aadharNumber": "458678950876",
//    "contactNum": "9067856450",
//    "farmerName": "Aamir",
//    "pancardNumber": "FXXP567801",
//    "password": "abc@123",
//    "soilPhCert": "PR69875"
//	export class Farmer {
//	    farmerEmail:String;
//	    aadharNumber:String;
//	    contactNum:String;
//	    pancardNumber=String;
//	    farmerName=String;
//	    password=String;
//	    soilPhCert=String;
//	}
//		Array[]:Farmer
//	}
	@Id
	
	@Column(name="FARMER_EMAIL", length=20)
	private String farmerEmail;

	@Column(name="AADHAR_NUMBER", length=15)
	private String aadharNumber;

	@Column(name="CONTACT_NUM", length=10)
	private String contactNum;

	@Column(name="FARMER_NAME", length=15)
	private String farmerName;

	@Column(name="PANCARD_NUMBER", length=15)
	private String pancardNumber;
    @Column(length=10)
    //@Transient
	private String password;

	@Column(name="SOIL_PH_CERT", length=15)
	private String soilPhCert;
	
    
	//bi-directional many-to-one association to FarmerLandDetail
	@OneToMany(mappedBy="farmerDetail")
	private Set<FarmerLandDetail> farmerLandDetails;


    
	//bi-directional many-to-one association to SellRequest
	@OneToMany(mappedBy="farmerDetail", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<SellRequest> sellRequests;
	 
	//bi-directional one-to-one association to AddressDetail
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ADDRESS_ID" )
	private AddressDetail addressDetail;
	 
	 
	//bi-directional one-to-one association to BankDetail
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_ID")
	private BankDetail bankDetail;
    
	public FarmerDetail(String farmerEmail, String aadharNumber, String contactNum, String farmerName,
			String pancardNumber, String password, String soilPhCert, Set<FarmerLandDetail> farmerLandDetails,
			 Set<SellRequest> sellRequests, AddressDetail addressDetail,
			BankDetail bankDetail) {
		super();
		this.farmerEmail = farmerEmail;
		this.aadharNumber = aadharNumber;
		this.contactNum = contactNum;
		this.farmerName = farmerName;
		this.pancardNumber = pancardNumber;
		this.password = password;
		this.soilPhCert = soilPhCert;
		this.farmerLandDetails = farmerLandDetails;
		this.sellRequests = sellRequests;
		this.addressDetail = addressDetail;
		this.bankDetail = bankDetail;
	}

	public FarmerDetail() {
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSoilPhCert() {
		return soilPhCert;
	}

	public void setSoilPhCert(String soilPhCert) {
		this.soilPhCert = soilPhCert;
	}
	//@JsonIgnore
	public Set<FarmerLandDetail> getFarmerLandDetails() {
		return farmerLandDetails;
	}

	public void setFarmerLandDetails(Set<FarmerLandDetail> farmerLandDetails) {
		this.farmerLandDetails = farmerLandDetails;
	}
	@JsonIgnore
	public Set<SellRequest> getSellRequests() {
		return sellRequests;
	}

	public void setSellRequests(Set<SellRequest> sellRequests) {
		this.sellRequests = sellRequests;
	}
	//@JsonIgnore
	public AddressDetail getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(AddressDetail addressDetail) {
		this.addressDetail = addressDetail;
	}
	//@JsonIgnore
	public BankDetail getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

	

	

}