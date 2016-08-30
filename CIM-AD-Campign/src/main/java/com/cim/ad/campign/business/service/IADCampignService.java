package com.cim.ad.campign.business.service;

import java.util.List;

import com.cim.ad.campign.bean.ADCampign;

public interface IADCampignService {
	public void saveADCampign(ADCampign adCampign);
	public ADCampign getByPartnerId(String partnerId);
	public List<ADCampign> getAdCampaignList();
}
