package com.sauce.challenge.business;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sauce.challenge.services.IRcrdHealthChkSvc;
import com.sauce.challenge.services.ISiteHealthChkSvc;

@Component
public class HealthChkSchedulerBussImpl implements IHealthChkSchedulerBuss {

	@Autowired
	ISiteHealthChkSvc siteHealthChkSvc;
	
	@Autowired
	IRcrdHealthChkSvc rcrdHealthChkSvc;
	
	@Value("${siteUrl}")
	private String siteUrl;
	
	@Value("${timeout}")
	private int timeout;
	
	public void orchestrateSiteHealthChk() {
		
		boolean siteHEalthSts = siteHealthChkSvc.checkSiteHealth(siteUrl,timeout);
		rcrdHealthChkSvc.recordHealthChkResults(LocalDateTime.now(), siteHEalthSts);
	}
}
