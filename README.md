# Team - AutomationX #

This repository has automated functional test for Hotels search on [Make My Trip](https://www.makemytrip.com/) as part of [HeadSpin Automation Hackathon](https://www.thetesttribe.com/headspin-automation-hackathon/).

### Tools Used ###

- Programming language: ```Java - 1.8```

- Automation Tool: ```Selenium WebDriver - 3.141.59```

- Unit testing framework: ```TestNG - 6.14.3```

- Build tool: ```Maven - 1.8```

- Reporting Tool: ```Extent Reports - 2.41.2```

- Version Controlling: ```Git```

### Automation Approach ###

    This AutomationX project is developed using Page Object model with TestNG framework along with Maven as build tool. Here everything is set up and tests can be executed directly using different ways like using IDE, terminal/cmd,maven. We've used extent reports for reporting purpose to get the perfect reports.
	This project will execute on the default browser available in the target system, that means when the test execution started one of the method will get the Operating system details and the browser version which is already installed in it. Based on the target system browser version it will download respective browser drivers and executes the tests. 

### Challenged Faced ###

* Continue Button in Login Window was not clickable

* While running test with Login, encountered OTP occasionally

* Setting minimum price range using slider

* View Map overlay in Search results page was blocking

* For Selecting room types, got two tables of selection with combo and individual rooms

### Running Scripts from IDE ###

* Select desired profiles from maven profile and run `runner.xml`

### Running Scripts from Terminal ###

* Make sure you have maven installed

* open terminal/cmd, go to project folder and run below command

    * `mvn clean install -Dprofile=local-chrome`

* by default runner.xml will execute, if you want run other xml file from maven, use below command

    * `mvn clean install -Dprofile=local-chrome -DsuiteXmlFile=<xmlfileName>`

### Reports ###

Reports will be generate under reports folder with current

### Contributors ###

* Jagadeesh Kotha
* Shyam Sunder
* Suresh Thammishetty
* Goutham Kumar Duduka