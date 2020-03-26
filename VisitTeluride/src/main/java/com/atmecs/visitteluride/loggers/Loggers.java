package com.atmecs.visitteluride.loggers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.visitteluride.constants.FilePath;

public class Loggers {

	Logger log;
	
	public Loggers() {
		log = Logger.getLogger(Loggers.class.getName());
		configProperty();
	}
	
	public void configProperty() {
		PropertyConfigurator.configure(FilePath.LOG4J_FILE);
	}
	
	public void info(String message) {
		log.info(message);
	}
}
