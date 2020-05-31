# Team - AutomationX #

This repository has automated functional test for Hotels search on [Make My Trip](https://www.makemytrip.com/) as part of [HeadSpin Automation Hackathon](https://www.thetesttribe.com/headspin-automation-hackathon/).

### Tools Used ###

- Programming language: ```Java - 1.8```

- Automation Tool: ```Selenium WebDriver - 3.141.59```

- Unit testing framework: ```TestNG - 6.14.3```

- Build tool: ```Maven - 1.8```

- Reporting Tool: ```Extent Reports - 2.41.2```

- Version Controlling: ```Git```

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