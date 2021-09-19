package com.lti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.layer2.entity.AddressDetail;
import com.lti.layer2.entity.BankDetail;
import com.lti.layer2.entity.BidderDetail;
import com.lti.layer2.entity.CropDetail;
import com.lti.layer2.entity.FarmerDetail;
import com.lti.layer2.entity.FarmerLandDetail;
import com.lti.layer2.entity.InsuranceDetail;
import com.lti.layer2.entity.LiveBid;
import com.lti.layer2.entity.SellRequest;
import com.lti.layer3.repository.AddressDetailRepository;
import com.lti.layer3.repository.BankDetailRepository;
import com.lti.layer3.repository.BidderDetailRepository;
import com.lti.layer3.repository.CropDetailRepository;
import com.lti.layer3.repository.FarmerDetailRepository;
import com.lti.layer3.repository.FarmerLandDetailRepository;
import com.lti.layer3.repository.InsuranceDetailRepository;
import com.lti.layer3.repository.LiveBidRepository;
import com.lti.layer3.repository.SellRequestRepository;

@SpringBootTest
class FarmEasy4ApplicationTests {
	
	@Autowired
    SellRequestRepository sellReqRepo;
	
	@Autowired
	LiveBidRepository liveBidRepo;
	
	@Autowired
    InsuranceDetailRepository insurDetailRepo;
    
	@Autowired
	CropDetailRepository cropDetailRepo;
	
	@Autowired
	FarmerDetailRepository farmerDetailRepo;
	
	@Autowired
	BidderDetailRepository bidderDetailRepo;
	
	@Autowired
	AddressDetailRepository addressDetailRepo;
	
	@Autowired
	BankDetailRepository bankDetailRepo;
	
	@Autowired
	FarmerLandDetailRepository farmerLandDetailRepo;
	
	//=============================Farmer Registration===========================

		@Test
		void addNewFarmerAlongWithAddressAndBankDetails(){
			
			FarmerDetail newFarmer= new FarmerDetail();
			newFarmer.setAadharNumber("654809w840293");
			newFarmer.setContactNum("9990561230");
			newFarmer.setFarmerEmail("ram@gmail.com");
			newFarmer.setFarmerName("ram");
			newFarmer.setPancardNumber("BNZP41852");
			newFarmer.setPassword("ram#123");
			newFarmer.setSoilPhCert("DM74185");
			
			AddressDetail newAddDetail = new AddressDetail();
			newAddDetail.setAddressLine("404, MyHome");
			newAddDetail.setCity("Jodhpur");
			newAddDetail.setPincode(700853);
			newAddDetail.setState("Rajasthan");
			
			BankDetail newBankDetail= new BankDetail();
			newBankDetail.setAccountNum("98230489032");
			newBankDetail.setIfscCode("SBI008941");
		
			FarmerLandDetail landDetail= new FarmerLandDetail();
			landDetail.setLandAddress("greenValley");
			landDetail.setLandArea(30);
			landDetail.setLandPincode(5009870);
			
			
			newFarmer.setBankDetail(newBankDetail);
			newFarmer.setAddressDetail(newAddDetail);
			landDetail.setFarmerDetail(newFarmer);
			farmerLandDetailRepo.addLandDetail(landDetail);
			farmerDetailRepo.addFarmerDetails(newFarmer);
			
		}
		
		//==========================FarmerLogin===============================
		@Test
		void findFarmerByEmailAndPass() {
			List<FarmerDetail> farmerInfo=farmerDetailRepo.farmerLogin("archit96@gmail.com", "abcd1996");
			for(FarmerDetail farmer:farmerInfo) {
				System.out.println("Farmer Details :");
				System.out.println(farmer.getAadharNumber());
				System.out.println(farmer.getContactNum());
				System.out.println(farmer.getFarmerName());
				System.out.println(farmer.getFarmerEmail());
				System.out.println(farmer.getPancardNumber());
				System.out.println(farmer.getSoilPhCert());
				System.out.println(farmer.getPassword());
				System.out.println(farmer.getBankDetail().getAccountId());
				System.out.println(farmer.getAddressDetail().getAddressId());
				
			}
			
		}
		
		@Test
		void isFarmerPresent() {
			boolean checkUser=farmerDetailRepo.isPresent("archit96@gmail.com", "abcd96");
			System.out.println(checkUser);
		}
		
		
		
		//=============================Bidder Registration===========================

				@Test
				void addNewBidderAlongWithAddressAndBankDetails(){
					
					BidderDetail newBidder= new BidderDetail();
					newBidder.setAadharNumber("HN29632587");
					newBidder.setContactNum("780001230");
					newBidder.setBidderEmail("rohit@gmail.com");
					newBidder.setBidderName("Rohit");
					newBidder.setPancardNumber("BNOP41852");
					newBidder.setPassword("roh#123");
					newBidder.setTraderLicense("DM00185");
					
					AddressDetail newAddDetail = new AddressDetail();
					newAddDetail.setAddressLine("404, MyBungalow");
					newAddDetail.setCity("Jaipur");
					newAddDetail.setPincode(700987);
					newAddDetail.setState("Rajasthan");
					
					BankDetail newBankDetail= new BankDetail();
					newBankDetail.setAccountNum("9999000000");
					newBankDetail.setIfscCode("PUN000981");
					
					newBidder.setBankDetail(newBankDetail);
					newBidder.setAddressDetail(newAddDetail);
					
					bidderDetailRepo.addBidderDetails(newBidder);
					
				}
				//============================Bidder Login==========================
				@Test
				void isBidderPresent() {
					boolean checkUser=bidderDetailRepo.isPresent("karan@gmail.com", "abcd96");
					System.out.println(checkUser);
				}
				
				
				@Test
				void findBidderByEmailAndPass() {
					List<BidderDetail> bidderInfo=bidderDetailRepo.bidderLogin("karan@gmail.com", "happy@123");
					for(BidderDetail bidder:bidderInfo) {
						System.out.println("Bidder Details :");
						System.out.println(bidder.getAadharNumber());
						System.out.println(bidder.getContactNum());
						System.out.println(bidder.getBidderName());
						System.out.println(bidder.getBidderEmail());
						System.out.println(bidder.getPancardNumber());
						System.out.println(bidder.getTraderLicense());
						System.out.println(bidder.getPassword());
						System.out.println(bidder.getBankDetail().getAccountId());
						System.out.println(bidder.getAddressDetail().getAddressId());
						
					}
					
				}
				
//				-----------------------SellRequestTable------------------------------------------
				
				@Test
				void testGetAllSellRequest() {
					List<SellRequest> sellRequest= sellReqRepo.getAllSellRequests();
					for(SellRequest sellRequestList: sellRequest) {
						System.out.println("sell Request Details"+sellRequestList);}
					}
				
				@Test
				void testGetSellRequest() {
					
					SellRequest sellRequest=sellReqRepo.getSellRequest(101);
					System.out.println("Sell Request is: "+sellRequest.getCropDetail().getCropName()+" "+sellRequest.getFertilizer()+ " "+sellRequest.getSellReqStatus());
					
				}
				
				@Test
			    void newSellRequestWithCrop() {
			    	
			    	FarmerDetail farmer= farmerDetailRepo.getFarmerDetail("archit96@gmail.com");
			    	
			    	CropDetail newCrop= new CropDetail();
			    	newCrop.setCropName("Moong");
			    	newCrop.setCropType("Kharif");
			    	newCrop.setMsp(35);
			    
			    	
			    	Date date = new Date();
			    	
			    	SellRequest newSellRequest= new SellRequest();
			    	newSellRequest.setBasePrice(40);
			    	newSellRequest.setFertilizer("Sulphur");
			    	newSellRequest.setQuantityKg(150);
			    	newSellRequest.setSellReqDate(date);
			    	newSellRequest.setSellReqStatus("Pending");
			    	newSellRequest.setSoldDate(date);
			    	newSellRequest.setSoldPrice(50);
			    	newSellRequest.setTotalPrice(7500);
			    	newSellRequest.setFarmerDetail(farmer);
			    	newSellRequest.setCropDetail(newCrop);
			    	
			    	Set <SellRequest> sellReqList = new HashSet<SellRequest>();
			    	sellReqList.add(newSellRequest);
			    	farmer.setSellRequests(sellReqList);
			    	farmerDetailRepo.addFarmerDetails(farmer);
			    	//sellReqRepo.addSellRequest(newSellRequest);
			    }
				
				
//				Issue- It was overriding the farmer_details
//				@Test
//				void testAddSellRequest() {
////					String reqDate="09/02/2012";
////					String soldDate="24/12/2012";
////					
////					Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(soldDate);
////					Date date2= new SimpleDateFormat("dd/MM/yyyy").parse(reqDate);
//					Date date= new Date();
//					SellRequest sellReq = new SellRequest();
//					FarmerDetail farmer = new FarmerDetail();
//					CropDetail crop= new CropDetail();
//					sellReq.setBasePrice(35);
//					sellReq.setFertilizer("Potash");
//					sellReq.setQuantityKg(50);
//					sellReq.setSellReqDate(date);
//					sellReq.setSoldDate(date);
//					sellReq.setSellReqStatus("Approved");
//					sellReq.setTotalPrice(1750);
//					sellReq.setSoldPrice(60);
//					crop.setCropName("Pulses");
//					crop.setCropType("Kharif");
//					crop.setMsp(30);
//					farmer.setFarmerEmail("aamir18@gmail.com");
//					sellReq.setCropDetail(crop);
//					sellReq.setFarmerDetail(farmer);
//					
//					sellReqRepo.addSellRequest(sellReq);
//					
//					
//				}
				
				@Test
				void testGetAllFarmersForACrop() {
				   
					List<SellRequest> allFarmers= sellReqRepo.getFarmersForACrop("Rice");
					for(SellRequest farmerList: allFarmers) {
						System.out.println("sell_Request details");
						System.out.println(farmerList.getSellId());
						System.out.println(farmerList.getCropDetail().getCropName());
						System.out.println(farmerList.getBasePrice());
						System.out.println(farmerList.getFertilizer());
						System.out.println(farmerList.getQuantityKg());
						System.out.println(farmerList.getSellReqStatus());
						System.out.println(farmerList.getSellReqDate());
						System.out.println(farmerList.getSoldPrice());
						System.out.println(farmerList.getTotalPrice());
						System.out.println(farmerList.getSoldDate());
						System.out.println(farmerList.getFarmerDetail().getFarmerEmail());
					}
						//System.out.println(Arrays.toString(cropList));}
					//System.out.println(Arrays.toString(farmerList));}
						
				}
				
				@Test
				void testGetAllCropsForAFarmer() {
				   
					List<SellRequest> allCrops= sellReqRepo.getAllCropsOfAFarmer("archit96@gmail.com");
					for(SellRequest cropList: allCrops) {
						//System.out.println(Arrays.toString(cropList));}
					System.out.println("sell_Request details");
					System.out.println(cropList.getSellId());
					System.out.println(cropList.getCropDetail().getCropName());
					System.out.println(cropList.getBasePrice());
					System.out.println(cropList.getFertilizer());
					System.out.println(cropList.getQuantityKg());
					System.out.println(cropList.getSellReqStatus());
					System.out.println(cropList.getSellReqDate());
					System.out.println(cropList.getSoldPrice());
					System.out.println(cropList.getTotalPrice());
					System.out.println(cropList.getSoldDate());
					System.out.println(cropList.getFarmerDetail().getFarmerEmail());
					
					
					
					
					}
						
				}
				
				
				

				@Test
				void testUpdateSellRequest() {
					sellReqRepo.updateApprovalRequest(101, "Pending");	
				
				}
				
//				@Test
//				void testViewSoldHistory() {
//				   
//					List<Object[]> soldcrops= sellReqRepo.soldHistory();
//					for(Object[] list: soldcrops) {
//						System.out.println(Arrays.toString(list));}
//						
//				}
				
			
	
	
	//============Crop_Details table==============
	
	@Test
	void testAddCrop() {
		CropDetail newCrop = new CropDetail();
		newCrop.setCropName("Barley");
		newCrop.setCropType("Kharif");
		newCrop.setMsp(40);
		cropDetailRepo.addCropDetail(newCrop);
	}
	
	@Test
	void testGetAllCrops() {
		List<CropDetail> cropDetail = cropDetailRepo.getAllCropDetails();
		for(CropDetail cropList: cropDetail) {
			System.out.println("CropDetail :");
			System.out.println(cropList.getCropName());
			System.out.println(cropList.getCropType());
			System.out.println(cropList.getMsp());
			
		}
		
	}

	@Test
	void testGetCrop() {
		
		CropDetail crop=cropDetailRepo.getCropDetail("Barley");
		System.out.println( crop.getCropName()+ " "+crop.getCropType()+ " "+crop.getMsp());
		
	}
	
	 // ==============Live Bid Table Tests=========================
		@Test
		void testAllLiveBids() {
			List<LiveBid> liveBids = liveBidRepo.getAllLiveBids();
			for(LiveBid liveBidList: liveBids) {
				System.out.println("LiveBids :");
				System.out.println(liveBidList.getBidId());
				System.out.println(liveBidList.getBidderAmt());
				System.out.println(liveBidList.getBidReqDate());
				System.out.println(liveBidList.getSellRequest().getSellId());
				System.out.println(liveBidList.getBidderDetail().getBidderEmail());
				
			}
		}
		
		@Test
		void testGetBid() {
			
			LiveBid bid=liveBidRepo.getLiveBid(201);
			System.out.println("Bid details: "+bid.getBidderAmt()+" "+bid.getSellRequest().getSellId()+" "+bid.getBidderDetail().getBidderEmail()+" "+bid.getBidReqDate());
			
			
		}
	
	
		@Test
		void testGetmaxBid() {
			List<LiveBid> bids=liveBidRepo.getMaxBid(101);
			
			for(LiveBid maxbid: bids) {
				System.out.println(maxbid);
			}
		}
			
//			@Test
//			void testGetTestBid() {
//				List<LiveBid>bid=liveBidRepo.getMaxBidForSellId(101);
//				bid.
//				}
			
			
			
		//}
	@Test
		void testGetAllBidAmounts() {
		   
			List<Object[]> allBidAmts= liveBidRepo.getAllBidsForSellId(102);
			for(Object[] bidAmt: allBidAmts) {
				System.out.println(Arrays.toString(bidAmt));}
				//+" "+bidAmt.getBidId()+" "+bidAmt.getSellRequest().getSellId());}
		}
		
		@Test
		void getMaxBid() {
			
			List<LiveBid> maxLiveBid= liveBidRepo.getMaxBidForSellId(102);
			
			for(LiveBid maxBid: maxLiveBid) {
				System.out.println("Max bid details: "+maxBid.getBidderAmt());
			}
			}
		
	
	    
		
		@Test
		void testAddLiveBid() {
			
			Date todaysDate=new Date();
			SellRequest sellReq=sellReqRepo.getSellRequest(102);
			
			BidderDetail bidder=new BidderDetail();
			bidder.setBidderEmail("karan@gmail.com");
			
			LiveBid bid=new LiveBid();
			bid.setBidderAmt(60);
			bid.setBidReqDate(todaysDate);
			//bid.setSellId(104);
			bid.setBidderDetail(bidder);
		    bid.setSellRequest(sellReq);
			liveBidRepo.addLiveBid(bid);
		}
		
		

	
	//====================FarmerDetail====================================
	
	@Test
	void testAddFarmer() {
		FarmerDetail newFarmer = new FarmerDetail();
		BankDetail bankDetail=new BankDetail();
		AddressDetail addressDetail= new AddressDetail();
		newFarmer.setFarmerEmail("ayush@gmail");
		newFarmer.setFarmerName("Ayush");
		newFarmer.setPassword("dklsfdm");
		newFarmer.setContactNum("9887473789");
		newFarmer.setSoilPhCert("0093384748");
		newFarmer.setAadharNumber("BGT4803498");
		newFarmer.setPancardNumber("HJK03498");
		
		bankDetail.setAccountId(1009);
		newFarmer.setBankDetail(bankDetail);
		
		addressDetail.setAddressId(2009);
		newFarmer.setAddressDetail(addressDetail);
		
		farmerDetailRepo.addFarmerDetails(newFarmer);
	}
	
	@Test
	void testGetAllFarmers() {
		List<FarmerDetail> farmerDetails = farmerDetailRepo.getAllFarmerDetails();
		
		for(FarmerDetail farmerList: farmerDetails) {
			System.out.println("FarmerEmail: "+farmerList.getFarmerEmail());
			System.out.println("Name: "+farmerList.getFarmerName());
			System.out.println("Password: "+farmerList.getPassword());
			System.out.println("Contact Number: "+farmerList.getContactNum());
			System.out.println("Soil pH certi: "+farmerList.getSoilPhCert());
			System.out.println("Aaadhar number: "+farmerList.getAadharNumber());
			System.out.println("PAN number: "+farmerList.getPancardNumber());
			System.out.println("AccountId: "+farmerList.getBankDetail().getAccountId());
			System.out.println("AddressId: "+farmerList.getAddressDetail().getAddressId());
			
		}
		
	}

	@Test
	void testGetFarmer() {
		
		FarmerDetail farmer=farmerDetailRepo.getFarmerDetail("archit96@gmail.com");
		System.out.println("FarmerEmail: "+farmer.getFarmerEmail());
		System.out.println("Name: "+farmer.getFarmerName());
		System.out.println("Password: "+farmer.getPassword());
		System.out.println("Contact Number: "+farmer.getContactNum());
		System.out.println("Soil pH certi: "+farmer.getSoilPhCert());
		System.out.println("Aaadhar number: "+farmer.getAadharNumber());
		System.out.println("PAN number: "+farmer.getPancardNumber());
		System.out.println("AccountId: "+farmer.getBankDetail().getAccountId());
		System.out.println("AddressId: "+farmer.getAddressDetail().getAddressId());
		
	}
	
	@Test
	void testFarUpdatePass() {
		farmerDetailRepo.updateFarmerPassword("archit96@gmail.com", "12345");
	}
	
	@Test
	void testFarUpdateContactNum() {
		farmerDetailRepo.updateFarmerContactNum("archit96@gmail.com", "9000000690");
	}
	
	//================Bidder details=================
	
	@Test
	void testAddBidder() {//Initial Test
		BidderDetail newBidder = new BidderDetail();
		BankDetail bankDetail=new BankDetail();
		AddressDetail addressDetail= new AddressDetail();
		newBidder.setBidderEmail("aman@gmail");
		newBidder.setBidderName("Aman");
		newBidder.setPassword("dQjkcddm");
		newBidder.setContactNum("9000067889");
		newBidder.setTraderLicense("TL89084748");
		newBidder.setAadharNumber("BRDP4803498");
		newBidder.setPancardNumber("HML03498");
		
		bankDetail.setAccountId(1008);
		newBidder.setBankDetail(bankDetail);
		
		addressDetail.setAddressId(2008);
		newBidder.setAddressDetail(addressDetail);
		bidderDetailRepo.addBidderDetails(newBidder);
	}
	
	@Test
	void testGetAllBidders() {
		List<BidderDetail> bidderDetails = bidderDetailRepo.getAllBidderDetails();
		for(BidderDetail bidderList: bidderDetails) {
			System.out.println("BidderEmail: "+bidderList.getBidderEmail());
			System.out.println("Name: "+bidderList.getBidderName());
			System.out.println("Password: "+bidderList.getPassword());
			System.out.println("Contact Number: "+bidderList.getContactNum());
			System.out.println("Trader License no.: "+bidderList.getTraderLicense());
			System.out.println("Aadhar number: "+bidderList.getAadharNumber());
			System.out.println("PAN number: "+bidderList.getPancardNumber());
			System.out.println("AccountId: "+bidderList.getBankDetail().getAccountId());
			System.out.println("AddressId: "+bidderList.getAddressDetail().getAddressId());
			
		}
		
	}
	
	@Test
	void testGetBidder() {
		
		BidderDetail bidder=bidderDetailRepo.getBidderDetail("karan@gmail.com");
		System.out.println("BidderEmail: "+bidder.getBidderEmail());
		System.out.println("Name: "+bidder.getBidderName());
		System.out.println("Password: "+bidder.getPassword());
		System.out.println("Contact Number: "+bidder.getContactNum());
		System.out.println("Trader License no.: "+bidder.getTraderLicense());
		System.out.println("Aadhar number: "+bidder.getAadharNumber());
		System.out.println("PAN number: "+bidder.getPancardNumber());
		System.out.println("AccountId: "+bidder.getBankDetail().getAccountId());
		System.out.println("AddressId: "+bidder.getAddressDetail().getAddressId());
		
	}
	
	@Test
	void testBidUpdatePass() {
		bidderDetailRepo.updateBidderPassword("karan@gmail.com", "12345");
	}
	
	@Test
	void testBidUpdateContactNum() {
		bidderDetailRepo.updateBidderContactNum("karan@gmail.com", "9990000990");
	}


	

	//----------------------------------------------------InsuranceTable-------------------------------------------------
	
	@Test
	void testGetAllInsurances() {
		List<InsuranceDetail> insuranceDetail= insurDetailRepo.getAllInsuranceDetails();
		for(InsuranceDetail insuranceList: insuranceDetail) {
			System.out.println("insurance Details"+insuranceList);
		}
	}
	
	@Test
	void testGetInsurance(){
		
		InsuranceDetail insuranceDetail=insurDetailRepo.getInsuranceDetail(10198760);
	System.out.println("Insurance is: "+insuranceDetail.getFarmerDetail().getFarmerEmail()+ " "+insuranceDetail.getInsureeName()+ " "+insuranceDetail.getInsuranceComp());
	
	}
	
	@Test
	void testAddInsurance() {
		Date date= new Date();
		
		
		FarmerDetail farmer = farmerDetailRepo.getFarmerDetail("aamir18@gmail.com");
		CropDetail crop=cropDetailRepo.getCropDetail("Rice");
		InsuranceDetail newInsurance = new InsuranceDetail();
		newInsurance.setInsuranceComp("IFFCO");
		newInsurance.setInsureeName("aamir");
		newInsurance.setCropDetail(crop);
		newInsurance.setFarmerDetail(farmer);
		newInsurance.setLossDate(date);
		newInsurance.setEndDate(date);
		newInsurance.setSharePremium(500);
		newInsurance.setPremiumAmt(1100);
		newInsurance.setTotSumInsured(30000);
		newInsurance.setLossCause("Landslide");
		
		Set<InsuranceDetail> insuranceSet= new HashSet<InsuranceDetail>();
		insuranceSet.add(newInsurance);
		crop.setInsuranceDetails(insuranceSet);
		
		cropDetailRepo.addCropDetail(crop);
		
		
	}
	
	@Test
	void testGetAllInsuredFarmers() {
	   
		List<Object[]> allFarmers= insurDetailRepo.getAllFarmersForCropInsured("Barley");
		for(Object[] farmer: allFarmers) {
			System.out.println(Arrays.toString(farmer));}
			//+" "+bidAmt.getBidId()+" "+bidAmt.getSellRequest().getSellId());}
	}
	
	@Test
	void testGetAllInsuredCrops() {
	   
		List<Object[]> allCrops= insurDetailRepo.getAllCropsInsuredByAFarmer("aamir18@gmail.com");
		for(Object[] crops: allCrops) {
			System.out.println(Arrays.toString(crops));}
			//+" "+bidAmt.getBidId()+" "+bidAmt.getSellRequest().getSellId());}
	}
	
	// ================Farmer Land Detail Table Tests==============
	
		@Test
		void testGetAllLandDetails() { 
			
	        List <FarmerLandDetail> farmerLandDetails = farmerLandDetailRepo.getAllLandDetails();
			
			for(FarmerLandDetail farmerLand: farmerLandDetails) {
				System.out.println("Farmer Land details "+farmerLand.getFarmerDetail().getFarmerEmail()+" "+ farmerLand.getLandAddress()+" "+ farmerLand.getLandPincode()+" "+farmerLand.getLandArea());}
		}
		
		@Test
		void testGetLandDetail() {
			
			FarmerLandDetail landDetail=farmerLandDetailRepo.getLandDetail("Kota");
			System.out.println("Land Detail is: "+landDetail.getFarmerDetail().getFarmerEmail()+" "+landDetail.getLandArea()+" "+landDetail.getLandPincode()+" "+landDetail.getLandArea());
			
		}
		
		@Test
		void testAddLandDetail() {
			
			FarmerDetail farmer=new FarmerDetail();
			farmer.setFarmerEmail("prateek@gmail.com");
			
			FarmerLandDetail newLandDetail= new FarmerLandDetail();
			
			newLandDetail.setLandAddress("Dehradun");
			newLandDetail.setLandArea(80);
			newLandDetail.setLandPincode(248007);
			newLandDetail.setFarmerDetail(farmer);
			farmerLandDetailRepo.addLandDetail(newLandDetail);
		}
		
		//===============BankDetails================
		
		
		
		@Test
		void getAllBankDetails() {
			List<BankDetail> bankDetail=bankDetailRepo.getAllBankDetails();
			for(BankDetail bankList:bankDetail) {
				System.out.println("Bank Details "+bankList.getAccountId()+" "+bankList.getAccountNum()+" "+bankList.getIfscCode());
			}
			
		}
		
		@Test
		void getBankDetail() {
			BankDetail bankDetail=bankDetailRepo.getBankDetail(1002);
			System.out.println("Bank Details ");
			System.out.println(bankDetail.getAccountNum());
			System.out.println(bankDetail.getIfscCode());
		}
		
		@Test
		void addBankDetail() {
			
			BankDetail bankDetail=new BankDetail();
			//bankDetail.setAccountId(1005);
			bankDetail.setAccountNum("887557543");
			bankDetail.setIfscCode("SBI784828");
			bankDetailRepo.addBankDetail(bankDetail);
			
		}
		
		
		
		//===============AddressDetails================
		
		@Test
		void getAllAddressDetails() {
			List<AddressDetail> addressDetail=addressDetailRepo.getAllAddressDetails();
			for(AddressDetail addList:addressDetail) {
				System.out.println("Address Details "+addList.getAddressId()+" "+addList.getAddressLine()+" "+addList.getCity()+" "+addList.getPincode()+" "+addList.getState());
			}
			
			
		}
		
		
		@Test
		void getAddressDetail() {
			AddressDetail addressDetail=addressDetailRepo.getAddressDetail(2002);
			System.out.println("Address Details "+addressDetail.getAddressLine()+" "+addressDetail.getCity()+" "+addressDetail.getPincode()+" "+addressDetail.getState());
		}
		
		@Test
		void addAddressDetail() {
			
			AddressDetail addressDetail=new AddressDetail();
			
			addressDetail.setAddressLine("905-casa rio");
			addressDetail.setCity("Dehradun");
			addressDetail.setPincode(421204);
			addressDetail.setState("Uttrakhand");
			addressDetailRepo.addAddressDetail(addressDetail);
			
		}
		
		@Test
		void updateAddressDetail() {
			AddressDetail addressDetail=new AddressDetail();
			addressDetail.setAddressId(14);
			addressDetail.setAddressLine("905-casa");
			addressDetail.setCity("Navi Mumbai");
			addressDetail.setPincode(421204);
			addressDetail.setState("Maharashtra");
			addressDetailRepo.updateAddressDetail(addressDetail);
		}

		

}


