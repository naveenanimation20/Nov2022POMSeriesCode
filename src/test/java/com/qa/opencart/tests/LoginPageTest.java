package com.qa.opencart.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("EPIC - 100: design login for open cart app")
@Story("US-Login: 101: design login page features for open cart")
public class LoginPageTest extends BaseTest {
	
    private final Logger logger = Logger.getLogger(LoginPageTest.class);


	@Severity(SeverityLevel.TRIVIAL)
	@Description("....checking the title of the page.... tester: Naveen")
	@Test(priority = 1)
	public void loginPageTitleTest() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from loginPageTitleTest");

		String actualTitle = loginPage.getLoginPageTitle();
		logger.info("actual login page title: " + actualTitle);
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("....checking the url of the page.... tester: Naveen")
	@Test(priority = 2)
	public void loginPageURLTest() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from loginPageURLTest");

		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("....checking forgot pwd link exist.... tester: Naveen")
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from forgotPwdLinkExistTest");

		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("....checking user is able to login to app with correct username and password....")
	@Test(priority = 4)
	public void loginTest() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from loginTest");

		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

}
