# NCI Test API

This project contains the web services of the NCI Test project.

## Install

### Java JDK
Download [JDK 8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br/>
Add the path to JAVA JDK bin to Path environment variable<br/>
Add JAVA_HOME environment variable that points to the JAVA JDK directory<br/>

### Maven
Download [Maven] (https://maven.apache.org/download.cgi)<br/>
Extract in a directory<br/>
Add the path to Maven bin to Path environment variable<br/>

### Eclipse (Optional)
Download Eclipse Neon (Optional)<br/>

## Build

Run 
<code>mvn install</code>

## Running
Run
<code>java -jar target\api-0.0.1-SNAPSHOT.jar</code>

Or using maven

<code>mvn spring-boot:run</code>

## Use the services
http://localhost:8080/swagger-ui.html
