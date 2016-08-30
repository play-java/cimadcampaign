package com.cim.campign.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cim.ad.campign.bean.ADCampign;
import com.cim.ad.campign.business.service.ADCampignServiceImpl;
import com.cim.ad.campign.business.service.IADCampignService;

public class ADCampignServiceTest {

	protected IADCampignService iadCampignService;
	
	@Before
	public void setUp() {
		iadCampignService = new ADCampignServiceImpl();
	}

	@Test
	public void getAdCampignByPartnerIdTest() {
		//TODO
	}

	@Test
	public void saveAdCampignTest() {
		Boolean flag=false;
		ADCampign adCampign = new ADCampign();
		adCampign.setAdContent("Demo COntent 1");
		adCampign.setDuration(2000);
		adCampign.setPartnerId("1");
		try{
			iadCampignService.saveADCampign(adCampign);
			flag=true;
		}catch (Exception e) {
			flag=false;
		}
		Assert.assertTrue(flag);
	}
}
