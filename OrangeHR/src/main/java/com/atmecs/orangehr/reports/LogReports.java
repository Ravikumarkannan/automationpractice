package com.atmecs.orangehr.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.orangehr.constants.FilePaths;

public class LogReports {

	Logger log = null;

	public LogReports() {
		configureProperty();
		log = Logger.getLogger(LogReports.class.getName());
	}

	public void configureProperty() {
		PropertyConfigurator.configure(FilePaths.LOG4J_FILE);
	}

	public void info(String message) {
		log.info(message);
	}
}
