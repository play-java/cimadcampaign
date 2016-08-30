package com.cim.ad.campign.bean;

import java.io.Serializable;

public class ADCampign implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2953626234205490809L;
	private String partnerId;
	private Integer duration;
	private String adContent;
	
	private Long createDate;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ADCampign [partnerId=" + partnerId + ", duration=" + getDuration()
				+ ", adContent=" + adContent + ", createDate=" + createDate
				+ "]";
	}

	/**
	 * @return the partnerId
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId the partnerId to set
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @return the adContent
	 */
	public String getAdContent() {
		return adContent;
	}

	/**
	 * @param adContent the adContent to set
	 */
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}	
	
}