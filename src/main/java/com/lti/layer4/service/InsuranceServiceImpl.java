package com.lti.layer4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.InsuranceDetail;
import com.lti.layer3.repository.InsuranceDetailRepository;


@Service
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	InsuranceDetailRepository insuranceDetailRepo;

	@Transactional
	public void addInsuranceService(InsuranceDetail insureDet) {
		
		insuranceDetailRepo.addInsuranceDetail(insureDet);
	}

}
