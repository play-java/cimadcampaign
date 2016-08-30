package com.cim.ad.campign.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cim.ad.campign.bean.ADCampign;
import com.cim.ad.campign.bean.Message;
import com.cim.ad.campign.business.service.IADCampignService;

@RestController
@RequestMapping("/ad")
public class ADCampignRestController {
	private Logger logger = Logger.getLogger(ADCampignRestController.class);

	@Autowired
	private IADCampignService iadCampignService;

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Message> saveADCampignRestService(
			@RequestBody ADCampign adCampign) {
		logger.info("Save AD Campign service request intiatied......");
		try {
			iadCampignService.saveADCampign(adCampign);
			logger.info("Save AD Campign service request processed. Preparing Sucess output");
			Message msg = new Message("AD is succesfully created");
			return ResponseEntity.status(HttpStatus.OK).body(msg);
		} catch (IllegalArgumentException e) {
			logger.info("Save AD Campign service request processed. Preparing Error output");
			Message msg = new Message(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);

		} catch (Exception e) {
			logger.info("Save AD Campign service request processed. Preparing Error output");
			Message msg = new Message(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(msg);
		}
	}

	@RequestMapping(value = "/{partnerId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCampignByPartnerId(
			@PathVariable("partnerId") String partnerId) {
		logger.info("Fetching AD Campign service request intiatied......");
		try {
			ADCampign adCampign = iadCampignService.getByPartnerId(partnerId);
			if (adCampign != null) {
				return ResponseEntity.status(HttpStatus.OK).body(adCampign);
			} else {
				Message msg = new Message("No Active ad for partner id "
						+ partnerId);
				return ResponseEntity.status(HttpStatus.OK).body(msg);
			}
		} catch (Exception e) {
			logger.info("Save AD Campign service request processed. Preparing Error output");
			Message msg = new Message(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(msg);
		}
	}
	
	@RequestMapping(value = "/getallcampaign", method = RequestMethod.GET)
	public ResponseEntity<?> getallcampaign() {
		logger.info("Fetching all AD Campign service request intiatied......");
		try {
			List<ADCampign> listAadCampigns = iadCampignService.getAdCampaignList();
			if (listAadCampigns != null) {
				return ResponseEntity.status(HttpStatus.OK).body(listAadCampigns);
			} else {
				Message msg = new Message("No ad campaigns ");
				return ResponseEntity.status(HttpStatus.OK).body(msg);
			}
		} catch (Exception e) {
			logger.info("Getall ad Preparing Error output");
			Message msg = new Message(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(msg);
		}
	}
}