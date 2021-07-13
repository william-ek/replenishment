package edu.bu.logfunctions.replenishment.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = "edu.bu.logfunctions.replenishment")
@EnableScheduling
@SpringBootApplication
public class ReplenishmentApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplenishmentApplication.class);
	
	@Value("${LDAP_BIND_URL}")
	String ldapUrl;
	
	@Value("${LDAP_BIND_DN}")
	String ldapBindDn;
	
	@Value("${LDAP_BIND_PASSWORD}")
	String ldapBindPassword;

	public static void main(String[] args) {
		
		SpringApplication.run(ReplenishmentApplication.class, args);
		
	}
	
	    @Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
    
	   @Bean
	    public LdapContextSource contextSource() throws Exception {
	    	
	        LdapContextSource contextSource= new LdapContextSource();
	        contextSource.setUrl(ldapUrl);
	        contextSource.setUserDn(ldapBindDn);
	        contextSource.setPassword(ldapBindPassword);
	        return contextSource;
	    }

	    @Bean
	    public LdapTemplate ldapTemplate() throws Exception {
	        return new LdapTemplate(contextSource());        
	    }

}
