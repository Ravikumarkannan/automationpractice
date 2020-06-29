package com.atmecs.telluride.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.telluride.constants.FilePath;

public class LogReport {

	Logger logger;

	public LogReport() {
		getLogger();
		logger = Logger.getLogger(LogReport.class.getName());

	}

	public void getLogger() {

		PropertyConfigurator.configure(FilePath.LOG4J_FILE);
	}

	public void info(String message) {
		logger.info(message);
	}
}
