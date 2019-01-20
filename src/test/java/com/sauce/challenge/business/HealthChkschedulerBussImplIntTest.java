package com.sauce.challenge.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sauce.challenge.CodingChallengeApplication;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes= {CodingChallengeApplication.class})
public class HealthChkschedulerBussImplIntTest {
	
	@Autowired
	IHealthChkSchedulerBuss healthChkSchedulerBuss;
	
	@Test
	public void orchestrateHealthChkTest() {
		healthChkSchedulerBuss.orchestrateSiteHealthChk();
	}

}
