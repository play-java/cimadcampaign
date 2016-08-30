package com.cim.campign.test;

import com.cim.ad.campign.bean.ADCampign;
import com.google.gson.Gson;

public class CreateJson {
	public static void main(String[] args) {
		ADCampign adCampign = new ADCampign();
		adCampign.setPartnerId("1");
		adCampign.setDuration(2);
		adCampign.setAdContent("Demo 1 AD");
		
		Gson gson = new Gson();
		String json = gson.toJson(adCampign);
		System.out.println(json);
		
	}
}
