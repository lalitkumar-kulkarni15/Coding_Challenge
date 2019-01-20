package com.sauce.challenge.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.sauce.challenge.CodingChallengeApplicationTests;
import com.sauce.challenge.business.HealthChkSchedulerBussImplUnitTest;
import com.sauce.challenge.business.HealthChkschedulerBussImplIntTest;
import com.sauce.challenge.services.SiteHealthChkSvcImplIntTest;

@RunWith(Suite.class)
@SuiteClasses({
		CodingChallengeApplicationTests.class,
		HealthChkschedulerBussImplIntTest.class,
		HealthChkSchedulerBussImplUnitTest.class,
		SiteHealthChkSvcImplIntTest.class
})
public class HealthChkTestSuite {

}
