package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.FarmerLandDetail;
import com.lti.layer2.entity.SellRequest;
@Repository
public class FarmerLandDetailsRepositoryImpl implements FarmerLandDetailRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<FarmerLandDetail> getAllLandDetails() {
		List<FarmerLandDetail> farmerLandDetail = entityManager.createQuery("from FarmerLandDetail").getResultList();
		return farmerLandDetail;
	}

	@Transactional
	public FarmerLandDetail getLandDetail(String landAddress) {
		FarmerLandDetail farmerLandDetail=entityManager.find(FarmerLandDetail.class, landAddress);
		return farmerLandDetail;
	}

	@Transactional
	public void addLandDetail(FarmerLandDetail landDet) {
		entityManager.persist(landDet);

	}

	

//	@Transactional
//	public void deleteLandDetail(String landAddress) {
//		FarmerLandDetail farmerLandDetail=entityManager.find(FarmerLandDetail.class,landAddress);
//		entityManager.remove(farmerLandDetail);
//
//	}

}
