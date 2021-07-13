package edu.bu.logfunctions.replenishment.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.bu.logfunctions.replenishment.services.RestService;

@Component
public class ReplenishmentProcess {
	
	private final Logger logger = LoggerFactory.getLogger(ReplenishmentProcess.class);
	
	@Autowired
	RestService service;

	@Scheduled(fixedRateString = "${CONNECTION_INTERVAL_MILLISECONDS}")
    public void run() {
		logger.debug("this runs every so many seconds..");
		
		if (!service.isVDSLeader()) {
			logger.debug("I am not the leader . . .");
			return;
		} 
		
		logger.debug("I am the leader . . .");
		
    }
    
	public void doProcess() {
		
		

	}

}
