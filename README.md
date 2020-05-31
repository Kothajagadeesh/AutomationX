# AutomationX

Tools used

TestNg -> Unit Testing Framework
Maven -> Build Tool
ReportNG -> For HTML Report Generations
Log4j -> logging for Java
Git -> Version control
Application -> Automation Practice
How to Execute

Download the Framework from GIT
Intellij -> View Tool Windows -> Maven -> Select Desired profile (prod-local-chrome)
prod -> Environment (stag, qa, prod)
local -> Execution type (local, grid, saucelabs, browser stack)
chrome -> Browser type
We can update the profile length with as many values as we can

Terminal

install mvn from Terminal
navigate to project path from Terminal
Type "mvn clean install -Denv=prod-chrome-local" (without quotes) and press enter
Reports

Reports will be generate under test-output folder after execution
Doc Can view the project doc under doc -> index.html

Tests Read TESTCASES.MD
