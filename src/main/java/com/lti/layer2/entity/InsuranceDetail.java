package com.lti.layer2.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the INSURANCE_FORM database table.
 * 
 */
@Entity
@Table(name="INSURANCE_DETAILS")
public class InsuranceDetail  {

	@Id
	@GeneratedValue
	@Column(name="POLICY_NUM")
	private int policyNum;

//	@Column(name="CROP_NAME", length=15)
//	private String cropName;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="INSURANCE_COMP", length=15)
	private String insuranceComp;

	@Temporal(TemporalType.DATE)
	@Column(name="INSURANCE_DATE")
	private Date insuranceDate;

	@Column(name="INSUREE_NAME", length=15)
	private String insureeName;

	@Column(name="LOSS_CAUSE", length=20)
	private String lossCause;

	@Temporal(TemporalType.DATE)
	@Column(name="LOSS_DATE")
	private Date lossDate;

	@Column(name="PREMIUM_AMT")
	private double premiumAmt;

	@Column(name="SHARE_PREMIUM")
	private double sharePremium;

	@Column(name="TOT_SUM_INSURED")
	private double totSumInsured;

	//bi-directional many-to-one association to FarmerDetail
	@ManyToOne
	@JoinColumn(name="FARMER_EMAIL")
	private FarmerDetail farmerDetail;
	
	@ManyToOne
	@JoinColumn(name="CROP_NAME")
	private CropDetail cropDetail;

	public InsuranceDetail(int policyNum,  Date endDate, String insuranceComp, Date insuranceDate,
			String insureeName, String lossCause, Date lossDate, double premiumAmt, double sharePremium,
			double totSumInsured, FarmerDetail farmerDetail, CropDetail cropDetail) {
		super();
		this.policyNum = policyNum;
		
		this.endDate = endDate;
		this.insuranceComp = insuranceComp;
		this.insuranceDate = insuranceDate;
		this.insureeName = insureeName;
		this.lossCause = lossCause;
		this.lossDate = lossDate;
		this.premiumAmt = premiumAmt;
		this.sharePremium = sharePremium;
		this.totSumInsured = totSumInsured;
		this.farmerDetail = farmerDetail;
		this.cropDetail = cropDetail;
	}

	public InsuranceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(int policyNum) {
		this.policyNum = policyNum;
	}


	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInsuranceComp() {
		return insuranceComp;
	}

	public void setInsuranceComp(String insuranceComp) {
		this.insuranceComp = insuranceComp;
	}

	public Date getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public String getInsureeName() {
		return insureeName;
	}

	public void setInsureeName(String insureeName) {
		this.insureeName = insureeName;
	}

	public String getLossCause() {
		return lossCause;
	}

	public void setLossCause(String lossCause) {
		this.lossCause = lossCause;
	}

	public Date getLossDate() {
		return lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public double getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public double getSharePremium() {
		return sharePremium;
	}

	public void setSharePremium(double sharePremium) {
		this.sharePremium = sharePremium;
	}

	public double getTotSumInsured() {
		return totSumInsured;
	}

	public void setTotSumInsured(double totSumInsured) {
		this.totSumInsured = totSumInsured;
	}

	public FarmerDetail getFarmerDetail() {
		return farmerDetail;
	}

	public void setFarmerDetail(FarmerDetail farmerDetail) {
		this.farmerDetail = farmerDetail;
	}

	public CropDetail getCropDetail() {
		return cropDetail;
	}

	public void setCropDetail(CropDetail cropDetail) {
		this.cropDetail = cropDetail;
	}

	

	

}