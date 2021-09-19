package com.lti.layer3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.layer2.entity.AddressDetail;


@Repository//annotations indicates that the class defines a data repository. It is meant to interact with the datasource.
			//provides crud operations on database tables
public interface AddressDetailRepository {

    List <AddressDetail> getAllAddressDetails();
	
    AddressDetail getAddressDetail(int addressId);
	
	void addAddressDetail(AddressDetail addrDet);
	void updateAddressDetail(AddressDetail addrDet);
//	void deleteAddressDetail(int addressId);
}
