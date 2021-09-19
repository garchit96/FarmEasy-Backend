package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.FarmerDetail;
@Repository
public class FarmerDetailRepositoryImpl implements FarmerDetailRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<FarmerDetail> getAllFarmerDetails() {
		List<FarmerDetail> farmerDetail = entityManager.createQuery("from FarmerDetail").getResultList();
		return farmerDetail;
	}

	@Transactional
	public FarmerDetail getFarmerDetail(String farmerEmail) {
		FarmerDetail farmerDetail=entityManager.find(FarmerDetail.class, farmerEmail);
		return farmerDetail;
	}

	@Transactional
	public void addFarmerDetails(FarmerDetail farDet) {
		entityManager.merge(farDet);

	}

//	@Transactional
//	public void updateFarmerDetails(FarmerDetail farDet) {
//		entityManager.merge(farDet);
//
//	}
	
	@Transactional
	public void updateFarmerPassword(String farmerEmail, String newPass) {
		FarmerDetail farmerDetail = entityManager.find(FarmerDetail.class, farmerEmail);
		farmerDetail.setPassword(newPass);
		entityManager.merge(farmerDetail);

	}
	
	@Transactional
	public void updateFarmerContactNum(String farmerEmail, String newContactNum) {
		FarmerDetail farmerDetail = entityManager.find(FarmerDetail.class, farmerEmail);
		farmerDetail.setContactNum(newContactNum);
		entityManager.merge(farmerDetail);

	}

	@Transactional
	public List<FarmerDetail> farmerLogin(String farmerEmail, String password) {
		List<FarmerDetail> farmerInfo=entityManager.createNativeQuery("select * from farmer_details where farmer_email="+"'"+farmerEmail+"'"+"and password="+"'"+password+"'", FarmerDetail.class).getResultList();
		return farmerInfo;
	}

	@Transactional
	public boolean isPresent(String farmerEmail, String password) {
		try {
		FarmerDetail ref=entityManager.find(FarmerDetail.class, farmerEmail);
		String id=ref.getFarmerEmail();
		String pass=ref.getPassword();
		if (farmerEmail==id & pass.equals(password)) {
			System.out.println("Login SuccessFul");
			return true;
		}else {
			System.out.println("Credentials incorrect");
			return false;
		}
		}
		catch(Exception ex) {
			System.out.println("user does not exist");
			return false;
			}
		
		
	
	
	
	
//		return (Long)
//				entityManager.createQuery("select count(f.fEmail) from farmer_details f where f.fEmail = :em ")
//				.setParameter("em", farmerEmail)
//				.getSingleResult() == 1 ? true : false;
//		int count=entityManager.createNativeQuery("select count(farmer_email) from farmer_details where farmer_email="+"'"+farmerEmail+"'", FarmerDetail.class).getSingleResult();			
	}

//	@Transactional
//	public void deleteFarmerDetails(String farmerEmail) {
//		FarmerDetail farmerDetail=entityManager.find(FarmerDetail.class, farmerEmail);
//		entityManager.remove(farmerDetail);
//
//	}

}