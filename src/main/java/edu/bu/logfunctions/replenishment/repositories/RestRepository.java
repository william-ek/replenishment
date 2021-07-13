package edu.bu.logfunctions.replenishment.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class RestRepository {
	
	private final Logger logger = LoggerFactory.getLogger(RestRepository.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${REST_VDS_URL}")
	String vdsUrl;
	
	@Value("${REST_BU_URL}")
	String BuUrl;
	
	public String getIsLeaderProperty() {
		
		String response = restTemplate.getForObject(vdsUrl, String.class);
		
		logger.debug("Response from VDS: " + response);
		
		return response;
		
	}
	
	public String replensihment() {
		
		String response = restTemplate.postForObject(BuUrl, "this stuff", String.class);
		
		logger.debug("Response from BU: " + response);
		
		return response;
		
	}

}
