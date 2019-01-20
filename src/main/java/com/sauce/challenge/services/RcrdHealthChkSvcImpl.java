package com.sauce.challenge.services;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class RcrdHealthChkSvcImpl implements IRcrdHealthChkSvc {

	public void recordHealthChkResults(final LocalDateTime dateTime,boolean siteStatus) {
		
		if(siteStatus) {
			System.out.println("*** Site was healthy at "+dateTime +"***");
		} else {
			System.out.println("*** Site was unhealthy and did not respond at "+dateTime +"***");
		}
		
	}
	
}
