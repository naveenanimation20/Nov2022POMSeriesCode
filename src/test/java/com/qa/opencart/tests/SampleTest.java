package com.qa.opencart.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.annotations.Test;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class SampleTest {

    private final Logger logger = Logger.getLogger(SampleTest.class);

    @Test
    public void testMethod1() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from testMethod1");
    }

    @Test
    public void testMethod2() {
        MDC.put("testClassName", this.getClass().getSimpleName());
        logger.info("This is a log message from testMethod2");
    }
}

