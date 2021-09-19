package com.lti.layer3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.FarmerDetail;
@Repository
public class BidderDetailRepositoryImpl implements BidderDetailRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<BidderDetail> getAllBidderDetails() {
		List<BidderDetail> bidderDetail = entityManager.createQuery("from BidderDetail").getResultList();
		return bidderDetail;
	}

	@Transactional
	public BidderDetail getBidderDetail(String bidderEmail) {
		BidderDetail bidderDetail=entityManager.find(BidderDetail.class, bidderEmail);
		return bidderDetail;
	}

	@Transactional
	public void addBidderDetails(BidderDetail bidDet) {
		entityManager.merge(bidDet);

	}

//	@Transactional
//	public void updateBidderDetails(BidderDetail bidDet) {
//		entityManager.merge(bidDet);
//	}
	
	@Transactional
	public void updateBidderPassword(String bidderEmail, String newPass) {
		BidderDetail bidderDetail = entityManager.find(BidderDetail.class, bidderEmail);
		bidderDetail.setPassword(newPass);
		entityManager.merge(bidderDetail);

	}
	
	@Transactional
	public void updateBidderContactNum(String bidderEmail, String newContactNum) {
		BidderDetail bidderDetail = entityManager.find(BidderDetail.class, bidderEmail);
		bidderDetail.setContactNum(newContactNum);
		entityManager.merge(bidderDetail);

	}
		
		@Transactional
		public List<BidderDetail> bidderLogin(String bidderEmail, String password) {
			List<BidderDetail> bidderInfo=entityManager.createNativeQuery("select * from bidder_details where bidder_email="+"'"+bidderEmail+"'"+"and password="+"'"+password+"'", BidderDetail.class).getResultList();
			return bidderInfo;
		
	}

		@Transactional
		public boolean isPresent(String bidderEmail, String password) {
			try {
				BidderDetail ref=entityManager.find(BidderDetail.class, bidderEmail);
				String id=ref.getBidderEmail();
				String pass=ref.getPassword();
				if (bidderEmail==id & pass.equals(password)) {
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
		}

//	@Transactional
//	public void deleteBidderDetails(String bidderEmail) {
//		BidderDetail bidderDetail=entityManager.find(BidderDetail.class,bidderEmail);
//		entityManager.remove(bidderDetail);
//
//	}

}