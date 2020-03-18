package com.atmecs.automation.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.atmecs.automation.constants.FilePath;

public class Loggers {

	Logger logger;
	
	public Loggers() {
		logger = Logger.getLogger(Loggers.class.getName());
		configureLogger();
	}
	
	public void configureLogger() {
		PropertyConfigurator.configure(FilePath.LOG_FILE);
	}
	
	public void info(String info) {
		logger.info(info);
	}
}
