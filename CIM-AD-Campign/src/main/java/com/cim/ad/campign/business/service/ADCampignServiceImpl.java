package com.cim.ad.campign.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cim.ad.campign.bean.ADCampign;

/**
 * Service class perform all major operations of ADCampign Service
 * 
 *
 */
@Service
public class ADCampignServiceImpl implements IADCampignService {
	private Logger logger = Logger.getLogger(ADCampignServiceImpl.class);

	private static HashMap<String, ADCampign> partnerADMap = new HashMap<String, ADCampign>();

	public ADCampign getByPartnerId(String partnerId) {
		logger.info("Get AD for partner id "+partnerId);
		ADCampign adCampign = partnerADMap.get(partnerId);
		if(adCampign!=null)
			return checkIfCampignisActive(adCampign);
		
		logger.info("AD object "+adCampign+" for partner id "+partnerId);
		return adCampign;
	}

	private ADCampign checkIfCampignisActive(ADCampign adCampign) {
		logger.info("Checking is AD is active "+adCampign);
		Integer duration = adCampign.getDuration();
		Long currentTimeSec = System.currentTimeMillis()/1000;
		Long createdTimeSec = adCampign.getCreateDate()/1000;
		
		if((currentTimeSec-createdTimeSec)>duration) return null;
		
		return adCampign;
	}

	public void saveADCampign(ADCampign adCampign) {
		logger.info("Save AD Campign object "+adCampign);
		if(adCampign!=null){
			if(adCampign.getPartnerId()!=null && !adCampign.getPartnerId().isEmpty()){
				if(null==partnerADMap.get(adCampign.getPartnerId()) || null==checkIfCampignisActive(partnerADMap.get(adCampign.getPartnerId()))){
					adCampign.setCreateDate(System.currentTimeMillis());
					partnerADMap.put(adCampign.getPartnerId(), adCampign);
				}else
					throw new IllegalArgumentException("Partner Id already have active ad.");
			}else
				throw new IllegalArgumentException("Invalid or Empty Partner Id in input.");
		}else
			throw new IllegalArgumentException("Invalid or Null Input.");
		
		logger.info("AD Campign Object save successfully.");
	}


	public List<ADCampign> getAdCampaignList() {
		logger.info("Get campaing list");
		 List<ADCampign> listAdCampigns= new ArrayList<ADCampign>();
		for(String key:partnerADMap.keySet()){
			listAdCampigns.add(partnerADMap.get(key));
		}
		return listAdCampigns;
	}
	
	
}
