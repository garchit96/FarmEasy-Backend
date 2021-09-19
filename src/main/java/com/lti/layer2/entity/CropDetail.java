package com.lti.layer2.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the CROP_DETAILS database table.
 * 
 */
@Entity
@Table(name="CROP_DETAILS")
public class CropDetail  {

	@Id
	@Column(name="CROP_NAME", length=15)
	private String cropName;

	@Column(name="CROP_TYPE", length=15)
	private String cropType;

	private double msp;

	@OneToMany(mappedBy="cropDetail", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<InsuranceDetail> insuranceDetails;

	public void setInsuranceDetails(Set<InsuranceDetail> insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	public CropDetail(String cropName, String cropType, double msp) {
		super();
		this.cropName = cropName;
		this.cropType = cropType;
		this.msp = msp;
		
	}

	public CropDetail() {
	}

	public String getCropName() {
		return this.cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return this.cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public double getMsp() {
		return this.msp;
	}

	public void setMsp(double msp) {
		this.msp = msp;
	}


	

}