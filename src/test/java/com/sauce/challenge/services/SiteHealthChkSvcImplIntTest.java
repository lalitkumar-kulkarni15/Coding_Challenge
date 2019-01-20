package com.sauce.challenge.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sauce.challenge.CodingChallengeApplication;
import com.sauce.challenge.exception.HealthCheckException;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes= {CodingChallengeApplication.class})
public class SiteHealthChkSvcImplIntTest {
	
	@Autowired
	ISiteHealthChkSvc siteHealthSvc;
	
	@Test
	public void checkSiteHealth_Returns200StatusCode() throws HealthCheckException {
		
		boolean siteHealth = siteHealthSvc.checkSiteHealth("https://www.google.com", 5000);
		assertTrue(siteHealth);
	}
	
	@Test
	public void checkSiteHealth_ReturnsFalseWhenSiteIsDown() throws HealthCheckException {
		
		boolean siteHealth = siteHealthSvc.checkSiteHealth("https://www.zinghjhsd.com", 5000);
		assertFalse(siteHealth);
	}
	
	@Test(expected=HealthCheckException.class)
	public void checkSiteHealth_ReturnsFalseWhenNullSiteIsPassed() throws HealthCheckException {
		
		siteHealthSvc.checkSiteHealth(null, 5000);
	}

}
