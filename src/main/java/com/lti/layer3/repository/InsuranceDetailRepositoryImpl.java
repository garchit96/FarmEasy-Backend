package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.AddressDetail;
import com.lti.layer2.entity.InsuranceDetail;
@Repository
public class InsuranceDetailRepositoryImpl implements InsuranceDetailRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public List<InsuranceDetail> getAllInsuranceDetails() {
		List<InsuranceDetail> insuranceDetail = entityManager.createQuery("from InsuranceDetail").getResultList();
		return insuranceDetail;
	}

	@Transactional
	public InsuranceDetail getInsuranceDetail(int policyNumber) {
		InsuranceDetail insuranceDetail=entityManager.find(InsuranceDetail.class, policyNumber);
		return insuranceDetail;
	}

	@Transactional
	public void addInsuranceDetail(InsuranceDetail insureDet) {
		entityManager.merge(insureDet);

	}

	@Transactional
	   public List<Object[]> getAllCropsInsuredByAFarmer(String farmerEmail) {
		Query query=entityManager.createNativeQuery("select * from insurance_details where farmer_email in (select fd.farmer_email from farmer_details fd, insurance_details id where fd.farmer_email=id.farmer_email) and farmer_email="+"'"+farmerEmail+"'");
		List<Object[]> crops=query.getResultList();
		return crops ;
		
	}

	   @Transactional
	  public List<Object[]> getAllFarmersForCropInsured(String cropName) {
		  Query query=entityManager.createNativeQuery("select * from insurance_details where crop_name in (select cd.crop_name from crop_details cd, insurance_details id where cd.crop_name=id.crop_name) and crop_name="+"'"+cropName+"'");
			List<Object[]> farmers=query.getResultList();
			return farmers ;
			
	}

}
