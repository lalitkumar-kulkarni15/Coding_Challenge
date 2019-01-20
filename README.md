# Coding_Challenge

## 1) What is the intent of this project module ? 
 
* Suppose If we have an application running on localhost with the url ```http://localhost:12345```. or any application site for that matter ex : ```https://www.google.in```
* And if the objective of the user is to monitor the health of this site and log the statistics periodically after certain time interval. In such scenario this is a perfect app that could be of great use.
* This application is a constantly running service which constantly monitors the health of the desired website / application which is accessible over the http/https protocol.
* It then logs the health status of the same appropriately along with the timestamp.
* This statistical data which is logged is then fed to the analyser for analysis.
 
## Examples :- 

* If the site/application is not responding or is not in a healthy state then the message 
```*** Site was unhealthy and did not respond at 2019-01-20T14:33:16.581***" is logged in the logs.```


* If the site/application is in a healthy state then the message ```*** Site was healthy at  2019-01-20T14:33:16.581***" is logged in the logs.```

* The site url is configurable and can be configured at the application.properties file. ```siteUrl=http://localhost:12345```

## 2) How to build and run the project?

* Firstly please download the source code to your local IDE ( eclipse or intellij or any ide of your choise ) .
* In order to build the project please run the maven 'clean install' which will compile the source code and also run the test cases. It will also take care of the dependencies.

* The application is build using spring boot , thus please open the 'CodingChallengeApplication.java' class and run the same. 

* This will start the service and it will continously monitor the desired site/application and keep on printing the status in the logs.

## 3) How to configure the site/application that needs to be monitored?

* As mentioned above the site that needs to be monitored is configurable in the application.properties file which is available at src/main/resources/application.properties.

* Ex : siteUrl=http://localhost:12345

* The property name 'siteUrl' holds the site url whoose health needs to be monitored.

* It also contains some properties like timeout=5000 which holds the value of site timeout after which the application can mark the health check failed.

* Please feel free to update / modify these properties according to your requirements.

##  4) Technical Implementation details 

* The application is developed using the Spring boot framework.
* Whenever the application is booted up , the spring scheduler starts invoking the health check mechanism at certain periodic intervals which is configured in the scheduler.
* This scheduler runs continuously until it is stopped by bringing the server down.
* The health check module invokes the site/application which is accessible over http/https by hitting the url for a finite amount of time i.e. timeout which is configured inside the application.properties. 
* It gets the status code as a part of response . i.e. It receives the status code 200 if the site is active or it may receive an exception or any other error code other than 200 in case the site is down or not available. 
* This result is logged in the logger( currently console ) with the current timestamp for the record.
* For more details , please refer to the javadocs mentioned in the source code.
* The code contains sufficient test cases which is required to test the source code.

 

