package com.lti.layer5.dto;

import java.util.Date;

import com.lti.layer2.entity.CropDetail;
import com.lti.layer2.entity.FarmerDetail;

public class SellRequestDto {
	public int sellId;
	private double basePrice;
	private String fertilizer;
	private double quantityKg;
	private Date sellReqDate;
	private String sellReqStatus;
	private Date soldDate;
	private double soldPrice;
	private double totalPrice;
	private String cropName;
	private String farmerEmail;
	
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public String getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}
	public double getQuantityKg() {
		return quantityKg;
	}
	public void setQuantityKg(double quantityKg) {
		this.quantityKg = quantityKg;
	}
	public Date getSellReqDate() {
		return sellReqDate;
	}
	public void setSellReqDate(Date sellReqDate) {
		this.sellReqDate = sellReqDate;
	}
	public String getSellReqStatus() {
		return sellReqStatus;
	}
	public void setSellReqStatus(String sellReqStatus) {
		this.sellReqStatus = sellReqStatus;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public double getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	
	
	
	
	
	
	
}
