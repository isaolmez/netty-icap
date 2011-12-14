/*******************************************************************************
 * Copyright 2011 - 2012 Michael Mimo Moratti
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ch.mimo.netty.handler.codec.icap;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JDKLoggerConfiguration {

	private LogManager logManager;
	private Logger rootLogger;
	private final Handler defaultHandler = new ConsoleHandler();
	private final Formatter defaultFormatter = new SimpleFormatter();
	
	public JDKLoggerConfiguration() {
	    this.logManager = LogManager.getLogManager();
	    this.rootLogger = Logger.getLogger("");

	    configure();
	}

	private final void configure() {
		defaultHandler.setFormatter(defaultFormatter);
		if(Boolean.valueOf(System.getProperty(AbstractIcapTest.TEST_OUTPUT))) {
			defaultHandler.setLevel(Level.ALL);
			rootLogger.setLevel(Level.ALL);
		} else {
			defaultHandler.setLevel(Level.WARNING);
			rootLogger.setLevel(Level.WARNING);
		}
		rootLogger.addHandler(defaultHandler);
		logManager.addLogger(rootLogger);
	}
}
