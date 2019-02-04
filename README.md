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
*Please note that the values of timeout and frequency of hitting the website are configured arbitrarily as of now. However this needs to be configured as per the requirements.The intent is to just portray the approach to solve the problem.

## 4) Design approach 

 * In order to constantly check the helth of the given application which is accessible over the http/https protocol, we need a task scheduler which can continously trigger a mechanism at configured period of interval.
 * This scheduler needs to trigger a module which will actually hit the url and check the response received. Whatever is the response received then it should log it down using logger or on the console ( for current case study purpose ) .
 * There are thus various schedulers available to use provided by various frameworks. We have chosen spring scheduler to do the job.

## 5) Technical Implementation details 

* The application is developed using JDK 8 and the Spring boot framework.
* The design and code of the application is kept very easy, so that any developer can understand very quickly.
* Helpfull java docs is present in the code base  to guide the user about the approach and the code written.
* So to start with ,whenever the application is booted up , the spring scheduler starts invoking the health check mechanism at certain periodic intervals which is configured in the scheduler.
* This scheduler runs continuously until it is stopped by bringing the server down.
* The health check module invokes the site/application which is accessible over http/https by hitting the url for a finite amount of time i.e. timeout which is configured inside the application.properties. 
* It gets the status code as a part of response . i.e. It receives the status code 200 if the site is active or it may receive an exception or any other error code other than 200 in case the site is down or not available. 
* This result is logged in the logger( currently console ) with the current timestamp for the record.
* For more details , please refer to the javadocs mentioned in the source code.
* The code contains sufficient test cases which is required to test the source code.

## Logs monitoring logic ( Extension to this code ) 

 * Due to shortage of time , couldn't manage to add certain parts in the given application code regarding the smart logging of the 
 monitoring app. Thus I am mentioning the high level logic here which could be implemented in the same.
 * As the intent of this app is to constantly monitor the website / application on the http and generate report, various monitoring tools like splunk could be used to create the dashboards which will help to show the visual representation of the health status. 
 Ex : A dashboard which shows the time interval and the percentage of failure and success during tat time interval.So the logic is 
 to hit the website finite number of times during 1 sec and then the result could be stored in a collection. After the finite number of hit requests we can calculate the percentage failure and success for that particular time range and then log this. The splunk query can then pick up this data using the keywords and generate the dashboards. ( visual representation for the support team to analyse ) .
 * Also alerts can be generated in splunk using the data which is logged for ex : If the site is continously failing for continued timeframes like say if it fails continously for 5 consecutive time frames then an alert could be generated to notify the team.
 
 * Please get in touch with me in case any of the mentioned part is unclear or you would want to know more about it.
 
 Thank you ..
 
 Lalit
 

