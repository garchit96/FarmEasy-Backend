package com.lti.layer4.service;




public interface LoginService {
	boolean isFarmerPresentService(String farmerEmail, String password);
	
	void updateFarmerPasswordService(String farmerEmail, String newPass  );
	
	boolean isBidderPresentService(String bidderEmail, String password);
	
	void updateBidderPasswordService(String bidderEmail, String newPass  );
}
