package com.sauce.challenge.services;

import java.time.LocalDateTime;

public interface IRcrdHealthChkSvc {
	
	public void recordHealthChkResults(final LocalDateTime dateTime,boolean siteStatus);

}
