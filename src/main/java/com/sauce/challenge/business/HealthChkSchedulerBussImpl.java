package com.sauce.challenge.business;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sauce.challenge.services.HealthChkSvcUtils;
import com.sauce.challenge.services.ISiteHealthChkSvc;

/**
 * <p>This class has the responsibility to orchestrate the health check monitoring flow </p>
 * <p>It first invokes the siteHealthChkSvc service {@code SiteHealthChkSvcImpl} to get
 * the status of the health, then it invokes the {@code HealthChkSvcUtils} to log the status
 * of the health check</p> 
 * 
 * @author owner
 * @since 20-01-2019
 * @version 1.0
 *
 */
@Component
public class HealthChkSchedulerBussImpl implements IHealthChkSchedulerBuss {

	@Autowired
	ISiteHealthChkSvc siteHealthChkSvc;
	
	/**This is the url of the site/application whoose health needs to be monitored.
	   The value of siteUrl comes from the application.properties file. */
	
	@Value("${siteUrl}")
	private String siteUrl;
	
	/**This is the timeout for the site/application whoose health needs to be monitored.
	   The value of timeout comes from the application.properties file. */
	
	@Value("${timeout}")
	private int timeout;
	
	@Override
	public void orchestrateSiteHealthChk() {
		
		try {
			// Check the health of the given site by invoking the same and collect the response code.
			boolean siteHealthSts = siteHealthChkSvc.checkSiteHealth(siteUrl,timeout);
			// Log the received health check status.
			HealthChkSvcUtils.recordHealthChkResults(LocalDateTime.now(), siteHealthSts);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
