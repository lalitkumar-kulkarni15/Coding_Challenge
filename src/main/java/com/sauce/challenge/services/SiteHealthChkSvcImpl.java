package com.sauce.challenge.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sauce.challenge.exception.HealthCheckException;

@Service
public class SiteHealthChkSvcImpl implements ISiteHealthChkSvc {
	
	public boolean checkSiteHealth( String url, int timeout) throws HealthCheckException {
		
		Optional<String> urlStr = Optional.ofNullable(url);
		
		if(urlStr.isPresent()) {
			
			return invokeSite(url,timeout);
			
		} else {
			throw new HealthCheckException("Url passed is null");
		}
	    
	}
	
	private boolean invokeSite(String url,int timeout) {
		
		url = url.replaceFirst("https", "http"); 

	    try {
	    	
	        final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setConnectTimeout(timeout);
	        connection.setReadTimeout(timeout);
	        connection.setRequestMethod("HEAD");
	        
	        int responseCode = connection.getResponseCode();
	        
	        if (responseCode != 200) {
	            return false;
	        }
	        
	    } catch (Exception exception) {
	        return false;
	    }
	    
	    return true;
	}

}
