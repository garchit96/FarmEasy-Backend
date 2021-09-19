package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.CropDetail;
@Repository
public class CropDetailsRepositoryImpl implements CropDetailRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<CropDetail> getAllCropDetails() {
    List<CropDetail> cropDetails = entityManager.createQuery("from CropDetail").getResultList();
		
		return cropDetails;
	}

	@Transactional
	public CropDetail getCropDetail(String cropName) {
			CropDetail cropDetail=entityManager.find(CropDetail.class, cropName);
			return cropDetail;
	}

	@Transactional
	public void addCropDetail(CropDetail cropDet) {
		entityManager.merge(cropDet);

	}

//	@Transactional
//	public void updateCropDetail(CropDetail cropDet) {
//		entityManager.merge(cropDet);
//
//	}

}
