package com.sauce.challenge.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.sauce.challenge.exception.HealthCheckException;
import com.sauce.challenge.services.IRcrdHealthChkSvc;
import com.sauce.challenge.services.ISiteHealthChkSvc;

@RunWith(MockitoJUnitRunner.class)
public class HealthChkSchedulerBussImplUnitTest {
	
	@Mock
	ISiteHealthChkSvc siteHealthChkSvc;
	
	@Mock
	IRcrdHealthChkSvc rcrdHealthChkSvc;
	
	@InjectMocks
	private HealthChkSchedulerBussImpl healthChkBuss;
	
	@Test()
	public void orchestrateSiteHealthChk_verifiesIfRcrdHealthChkIsCalled() throws HealthCheckException {

		Mockito.when(siteHealthChkSvc.checkSiteHealth(Mockito.any(), 
				Mockito.anyInt())).thenReturn(true);
		
		Mockito.doNothing().when(rcrdHealthChkSvc).recordHealthChkResults(Mockito.any(),
				Mockito.anyBoolean());
		
		healthChkBuss.orchestrateSiteHealthChk();
		
		Mockito.verify(rcrdHealthChkSvc).recordHealthChkResults(Mockito.any(), Mockito.anyBoolean());
		
	}
	
	@Test()
	public void orchestrateSiteHealthChk_verifiesIfcheckSiteHealthChkIsCalled() throws HealthCheckException {

		Mockito.when(siteHealthChkSvc.checkSiteHealth(Mockito.any(), 
				Mockito.anyInt())).thenReturn(true);
		
		Mockito.doNothing().when(rcrdHealthChkSvc).recordHealthChkResults(Mockito.any(),
				Mockito.anyBoolean());
		
		healthChkBuss.orchestrateSiteHealthChk();
		
		Mockito.verify(siteHealthChkSvc).checkSiteHealth(Mockito.any(), 
				Mockito.anyInt());
		
	}

}
