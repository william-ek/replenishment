package edu.bu.logfunctions.replenishment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bu.logfunctions.replenishment.models.BuLogs;
import edu.bu.logfunctions.replenishment.repositories.LdapRepository;


@Service
public class LdapService {
	
	@Autowired
	LdapRepository repository;
	
	public List<BuLogs> findLogs(String searchTimestamp) {
		
		return repository.find(searchTimestamp);
		
	}
	
	public void deleteLogs(BuLogs logEntry) {
		repository.delete(logEntry);
	}

}
