package com.sauce.challenge.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sauce.challenge.business.IHealthChkSchedulerBuss;

/**
 * <p>This class has the responsibility of scheduling the invocation of the
 *  health check module periodically after certain interval which is configured
 *  using the annotation {@link @Scheduled}</p>
 *    
 * @author owner
 * @since 20-01-2019
 * @version 1.0
 */
@Component
public class HealthChkScheduler {
	
	@Autowired
	// Instance of the health check business class.
	IHealthChkSchedulerBuss healthChkSchedlrBuss;
	
	/**Below annotation is used to schedule the invocation of the 
	   health check after every sec */
	
	@Scheduled(fixedRateString = "1000")
    public void scheduleHealthCheck() {
		
		// Invoking the business layer
		healthChkSchedlrBuss.orchestrateSiteHealthChk();
    }

}
