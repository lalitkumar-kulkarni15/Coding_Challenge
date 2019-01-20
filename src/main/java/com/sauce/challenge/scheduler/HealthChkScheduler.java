package com.sauce.challenge.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sauce.challenge.business.IHealthChkSchedulerBuss;

@Component
public class HealthChkScheduler {
	
	@Autowired
	IHealthChkSchedulerBuss healthChkSchedlrBuss;
	
	@Scheduled(fixedRateString = "1000")
    public void scheduleHealthCheck() {
		healthChkSchedlrBuss.orchestrateSiteHealthChk();
    }

}
