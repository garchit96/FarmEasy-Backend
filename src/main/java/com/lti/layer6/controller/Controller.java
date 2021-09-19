package com.lti.layer6.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer2.entity.InsuranceDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
import com.lti.layer4.service.AdminService;
import com.lti.layer4.service.BidderDetailService;
import com.lti.layer4.service.FarmerDetailService;
import com.lti.layer4.service.InsuranceService;
import com.lti.layer4.service.LiveBidService;
import com.lti.layer4.service.LoginService;
import com.lti.layer4.service.RegistrationService;
import com.lti.layer4.service.SellRequestService;
import com.lti.layer5.dto.BidderDto;
import com.lti.layer5.dto.FarmerDto;
import com.lti.layer5.dto.LiveBidDto;
import com.lti.layer5.dto.MarketPlaceDto;
import com.lti.layer5.dto.SellRequestDto;

@RestController//annotation tells the Spring Boot Application that HTTP requests are handled by this class.
			  //The job of the controller is to handle the HTTP requests and invoke the Service class methods.
@CrossOrigin
public class Controller {
	
	@Autowired
	FarmerDetailService farmerDetailService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegistrationService registerService;
	
	@Autowired
	SellRequestService sellRequestService;
	
	@Autowired
	BidderDetailService bidderDetailService;
	
	@Autowired
	LiveBidService liveBidService;
	
	@Autowired
	InsuranceService insuranceService;
	
	@Autowired
	AdminService adminService;
	
	
	
	@GetMapping(path="/getFarmer")
	 
	public FarmerDetail getFarmer(@RequestBody FarmerDto farmerDto) 
	{
		FarmerDetail farmer = farmerDetailService.findAFarmerService(farmerDto.getFarmerEmail());
		return farmer;
	}
	
	@GetMapping(path="/getFarmers")
	 
	public List<FarmerDetail> returnFarmers( )
	{
		List<FarmerDetail >farmers=null;
		try {
			 farmers = farmerDetailService.findAllFarmerService();
			//return farmers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return farmers;
		
		
	}
	
	@PostMapping(path="/isFarmerPresent")
	 
	public boolean isFarmerPresent(@RequestBody FarmerDto farmerDto)
	{
		boolean farmers = loginService.isFarmerPresentService(farmerDto.getFarmerEmail(), farmerDto.getPassword());
		return farmers;
	}
	

	@PostMapping(path="/addFarmer")
	 
	public String addFarmer(@RequestBody FarmerDetail farmerDetail)
	{
		
		try {
			registerService.addFarmerDetailsService(farmerDetail);
			return "Farmer added Successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	
	
	
	@PostMapping(path="/addBidder")
	 
	public String addBidder(@RequestBody BidderDetail bidderDetail)
	{
		
		try {
			registerService.addBidderDetailsService(bidderDetail);
			return "Bidder added Successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@GetMapping(path="/getBidder")
	 
	public BidderDetail getBidder(@RequestBody BidderDto bidderDto) 
	{
		BidderDetail bidder = bidderDetailService.findABidderService(bidderDto.getBidderEmail());
		return bidder;
	}
	
	@GetMapping(path="/getBidders")
	 
	public List<BidderDetail> getBidders() 
	{
		List<BidderDetail >bidders=null;
		try {
			 bidders = bidderDetailService.findAllBidderService();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return bidders;

    }
	
	@PostMapping(path="/isBidderPresent")
	 
	public boolean isBidderPresent(@RequestBody BidderDto bidderDto)
	{
		boolean bidders = loginService.isBidderPresentService(bidderDto.getBidderEmail(), bidderDto.getPassword());
		return bidders;
	}
	
	@PutMapping(path="/setNewFarmerPassword")
	
	public String setNewFarmerPassword(@RequestBody FarmerDto farmerDto)
	{
		try {
			loginService.updateFarmerPasswordService(farmerDto.getFarmerEmail(), farmerDto.getPassword());
			return "Password Successfully Updated...";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@PutMapping(path="/setNewBidderPassword")
	
	public String setNewBidderPassword(@RequestBody BidderDto bidderDto) 
	{
		try {
			loginService.updateBidderPasswordService(bidderDto.getBidderEmail(), bidderDto.getPassword());
			return "Password Successfully Updated...";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@GetMapping(path="/viewSoldHistory/{farmerEmail}")
	 
	public List<Object[]> viewSoldHistory(@PathVariable ("farmerEmail") String farmerEmail)
	{
	List<Object[] >list=null;
		try {
		 list = sellRequestService.viewSoldHistoryService(farmerEmail);
		//return farmers;
	    	} 
		catch (Exception e) 
		{
		// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return list;
	
	}
	
	@GetMapping(path="/getMaxBid")
	 
	public List<LiveBid> getMaxBid(@RequestBody LiveBidDto liveBidDto)
	{
		List<LiveBid >maxBid=null;
		try {
			maxBid = liveBidService.getMaxBidService(liveBidDto.getSellId());
			//return farmers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return maxBid;
		
	}
	@PostMapping(path="/getMaxLiveBid")
	 
	public List<LiveBid> getMaxLiveBid(@RequestBody LiveBidDto liveBidDto)
	{
		List<LiveBid >maxBid=null;
		try {
			maxBid = liveBidService.getMaxBidForSellIdService(liveBidDto.getSellId());
			//return farmers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return maxBid;
		
	}
	
	@GetMapping(path="/sellRequestDetails/{farmerEmail}")
	 
	public List<SellRequest> sellRequestDetails(@PathVariable ("farmerEmail") String farmerEmail)
	{
		List<SellRequest> det = sellRequestService.getRequestDetailService(farmerEmail);
		return det;
	}
		
	
		@GetMapping(path="/findCropsByFarmer")
		 
		public List<SellRequest> findCropsByFarmer(@RequestBody SellRequestDto sellRequestDto)
		{
			List<SellRequest> crops = sellRequestService.getAllCropsOfAFarmerService(sellRequestDto.getFarmerEmail());
			return crops;
		}

		@GetMapping(path="/findFarmersBycrop")
		 
		public List<SellRequest> findFarmersBycrop(@RequestBody SellRequestDto sellRequestDto)
		{
			List<SellRequest> farmers = sellRequestService.getFarmersForACropService(sellRequestDto.getCropName());
			return farmers;
		}
	
	
		@PostMapping(path="/addInsurance")
		 
		public String addInsurance(@RequestBody InsuranceDetail insuranceDetail)
		{
		
			try 
			{
			insuranceService.addInsuranceService(insuranceDetail);
			return "Insurance added Successfully";
			} 
			catch (Exception e) 
			{
			
			return e.getMessage();
			}
		
		}
	
		@PostMapping(path="/addSellRequest")
		 
		public String addSellRequest(@RequestBody SellRequest sr)
		{
		
			try
			{
			sellRequestService.addSellRequestService(sr);
			return "Request Placed Successfully";
			} catch (Exception e)
			{
			// TODO Auto-generated catch block
			return e.getMessage();
			}
		
	 }
	
	@PostMapping(path="/addNewBid")
	 
	public String addNewBid(@RequestBody LiveBid liveBid)
	{
		
		try {
			liveBidService.addLiveBidService(liveBid);
			return "New Bid Added Successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	 }
	
		@GetMapping(path="/getsellRequests")
		 
		public List<SellRequest> getsellRequests() 
		{
		List<SellRequest >requests=null;
			try {
			requests = adminService.getAllSellRequestsService();
				}
			catch (Exception e) 
			{
			e.printStackTrace();
			
			}
				return requests;

		}
	
		@PutMapping(path="/updateRequestStatus")
		public String updateRequestStatus(@RequestBody SellRequestDto sellRequestDto) 
		{
			try 
			{
				adminService.updateApprovalRequestService(sellRequestDto.getSellId(), sellRequestDto.getSellReqStatus());
				return "Sell Request Status Updated...";
			} catch (Exception e) {
			
			return e.getMessage();
			}
		}
	
		@DeleteMapping(path="/deleteRequest")
		public String deleteRequest(@RequestBody SellRequestDto sellRequestDto) 
		{
			
			try {
				adminService.deleteSellRequestService(sellRequestDto.getSellId());
				return "Request deleted succesfully";
				} catch (Exception e) {
					
					return e.getMessage();
				}
		}

		@GetMapping(path="/getBids")
		
		public List<LiveBid> getBids()
		{
			List<LiveBid>bids=null;
			try {
				bids = liveBidService.getAllLiveBidsService();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			return bids;

		}
		@GetMapping(path="/bidsAvailableForBidder")
		
		public List<Object[]> bidsAvailableForBidder()
		{
			List<Object[]> bids = liveBidService.liveBidsForBidderService();
			return bids;
		}
		
		@PutMapping(path="/updateBid")
		public String updateBid(@RequestBody LiveBidDto liveBidDto) 
		{
			try 
			{
				liveBidService.updateBidService(liveBidDto.getBidId(),liveBidDto.getBidderAmt());
				return "Bid Updated...";
			} catch (Exception e) {
			
			return e.getMessage();
			}
		}
		@PostMapping(path="/bidsForSellId")
		 
		public List<LiveBid> bidsForSellId(@RequestBody LiveBidDto liveBidDto)
		{
			List<LiveBid> farmers = liveBidService.bidsForSellIdService(liveBidDto.getSellId());
			return farmers;
		}
		
	}

