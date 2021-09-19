package com.lti.layer4.service;

import java.util.List;

import com.lti.layer2.entity.SellRequest;

public interface AdminService {
	List<SellRequest> getAllSellRequestsService();
	void updateApprovalRequestService(int sellId, String sellReqStatus);
	void deleteSellRequestService(int sellId);
}
