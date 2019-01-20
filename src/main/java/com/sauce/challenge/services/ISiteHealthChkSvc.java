package com.sauce.challenge.services;

import com.sauce.challenge.exception.HealthCheckException;

public interface ISiteHealthChkSvc {
	
	public boolean checkSiteHealth(String url, int timeout) throws HealthCheckException; 

}
