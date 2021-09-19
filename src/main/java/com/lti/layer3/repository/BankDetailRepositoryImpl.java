package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.BankDetail;
@Repository
public class BankDetailRepositoryImpl implements BankDetailRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<BankDetail> getAllBankDetails() {
		List<BankDetail> bankDetail = entityManager.createQuery("from BankDetail").getResultList();
		return bankDetail;
	}

	@Transactional
	public BankDetail getBankDetail(int accountId) {
		BankDetail bankDetail=entityManager.find(BankDetail.class, accountId);
		return bankDetail;
	}

	@Transactional
	public void addBankDetail(BankDetail bankDet) {
		entityManager.persist(bankDet);

	}

//	@Transactional
//	public void updateBankDetail(BankDetail bankDet) {
//		entityManager.merge(bankDet);
//
//	}

//	@Transactional
//	public void deleteBankDetail(int accountId) {
//		BankDetail bankDetail=entityManager.find(BankDetail.class,accountId);
//		entityManager.remove(bankDetail);
//
//	}

}
