package com.qa.opencart.factory;

import java.io.File;

import org.apache.log4j.FileAppender;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class CustomFileAppender extends FileAppender {

	@Override
	public void append(LoggingEvent event) {
		String testClassName = event.getMDC("testClassName").toString();
		String logsFolderPath = "logs";
		File logsFolder = new File(logsFolderPath);

		// Create the logs folder if it doesn't exist
		if (!logsFolder.exists()) {
			logsFolder.mkdirs();
		}

		setFile(logsFolderPath + "/" + testClassName + ".log");
		activateOptions();
		super.append(event);

	}
}
