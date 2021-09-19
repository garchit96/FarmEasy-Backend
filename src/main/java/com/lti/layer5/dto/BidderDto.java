package com.lti.layer5.dto;

public class BidderDto {
	
	    public String bidderEmail;
	    public String aadharNumber;
	    private String pancardNumber;
	    private String password;
	    private String traderLicense;
	    private String contactNum;
	    private String bidderName;
	    private int accountId;
	    private int addressId;
	    
		public String getBidderEmail() {
			return bidderEmail;
		}
		public void setBidderEmail(String bidderEmail) {
			this.bidderEmail = bidderEmail;
		}
		public String getAadharNumber() {
			return aadharNumber;
		}
		public void setAadharNumber(String aadharNumber) {
			this.aadharNumber = aadharNumber;
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
		public String getTraderLicense() {
			return traderLicense;
		}
		public void setTraderLicense(String traderLicense) {
			this.traderLicense = traderLicense;
		}
		public String getContactNum() {
			return contactNum;
		}
		public void setContactNum(String contactNum) {
			this.contactNum = contactNum;
		}
		public String getBidderName() {
			return bidderName;
		}
		public void setBidderName(String bidderName) {
			this.bidderName = bidderName;
		}
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
	    
	    
}
