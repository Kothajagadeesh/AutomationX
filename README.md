**Tools Used**

Java 1.8 > Programming language

TestNG > Unit testing framework

Maven > Build tool for Java

Extent Reports > For Reports

Git > Version Control

**Git Url**

https://github.com/Kothajagadeesh/AutomationX.git

**Running Scripts from IDE**

Select desired profiles from maven profile and run runner.xml

**Running Scripts from Terminal**

Make sure you have maven installed 

open terminal/cmd, go to project folder and run below command 

`mvn clean install -Dprofile=local-chrome`

by default runner.xml will execute, if you want run other xml file from maven, use below command

`mvn clean install -Dprofile=local-chrome -DsuiteXmlFile=<xmlfileName>`

**Reports**

Reports will be generate under reports folder with current