package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.BankDetail;
@Repository
public interface BankDetailRepository {
	
	List <BankDetail> getAllBankDetails();
	
	BankDetail getBankDetail(int accountId);
	
	void addBankDetail(BankDetail bankDet);
//	void updateBankDetail(BankDetail bankDet);
//	void deleteBankDetail(int accountId);
	

}
