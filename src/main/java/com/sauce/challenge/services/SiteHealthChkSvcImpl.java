package com.sauce.challenge.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sauce.challenge.exception.HealthCheckException;

/**
 * 
 * <p>This class has the responsibility of invoking the actual site with the url and
 * get its response code and return back. If the site is healthy then the response code
 * is 200 else it may get an exception of other response code otherwise.</p>
 *  
 * @author owner
 * @since 20-01-2019
 * @version 1.0
 *
 */
@Service
public class SiteHealthChkSvcImpl implements ISiteHealthChkSvc {
	
	public boolean checkSiteHealth( String url, int timeout) throws HealthCheckException {
		
		Optional<String> urlStr = Optional.ofNullable(url);
		
		// Basic sanity checks.
		if(urlStr.isPresent()) {
			
			return invokeSite(url,timeout);
			
		} else {
			throw new HealthCheckException("Url passed is null");
		}
	    
	}
	
	/**
	 * <p>This method actually invokes the site by using its url and fetches the 
	 * response code</p>
	 * 
	 * @param  url
	 * @param  timeout
	 * @return boolean flag . Returns true if the site is available and 
	 *         accesssible. Returns false otherwise.
	 */
	private boolean invokeSite(String url,int timeout) {
		
		// URL of the site.
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
