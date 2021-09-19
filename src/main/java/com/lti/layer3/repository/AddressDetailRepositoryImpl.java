package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.AddressDetail;

@Repository
public class AddressDetailRepositoryImpl implements AddressDetailRepository {
	@PersistenceContext //The persistence context is the first-level cache where all the  
						//entities are fetched from the database or saved to the database. 
						//It sits between our application and persistent storage.
	private EntityManager entityManager; //The EntityManager is the interface that lets us interact with the persistence context.
	
	@Transactional
	public List<AddressDetail> getAllAddressDetails() {
		List<AddressDetail> addressDetail = entityManager.createQuery("from AddressDetail").getResultList();
		return addressDetail;
	}

	@Transactional
	public AddressDetail getAddressDetail(int addressId) {
		AddressDetail addressDetail=entityManager.find(AddressDetail.class, addressId);
		return addressDetail;
	}

	@Transactional
	public void addAddressDetail(AddressDetail addrDet) {
		entityManager.persist(addrDet);

	}

	@Transactional
	public void updateAddressDetail(AddressDetail addrDet) {
		entityManager.merge(addrDet);

	}

//	@Transactional
//	public void deleteAddressDetail(int addressId) {
//		AddressDetail addressDetail=entityManager.find(AddressDetail.class,addressId);
//		entityManager.remove(addressDetail);
//
//	}

}