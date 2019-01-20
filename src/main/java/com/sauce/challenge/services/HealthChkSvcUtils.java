package com.sauce.challenge.services;

import java.time.LocalDateTime;

public class HealthChkSvcUtils {

	public static void recordHealthChkResults(final LocalDateTime dateTime,boolean siteStatus) {
		
		if(siteStatus) {
			System.out.println("*** Site was healthy at "+dateTime +"***");
		} else {
			System.out.println("*** Site was unhealthy and did not respond at "+dateTime +"***");
		}
		
	}
	
}
