#Project Name
Implementation of challenge test case for site http://www.ss.lv 

#Requirements
Please, make sure you have Java and Maven installed.

#Installation
1. Clone repository https://github.com/zhabenya/SS.LV_4_evo.git
2. Run test in IDE or in terminal `mvn test`

**Note**
- Currently tests run in Firefox WebDriver.
In /src/main/resources/application.properties file you can change it to another browser or uncomment line
`browser.name=${browser.name}` to enable Maven profiles.
To run tests in Chrome and IE add paths to Chromedriver and IEdriver to environment variables.
- In case tests fail because of misinterpreting of cyrrilic letters, change encoding of /src/main/resources/UIMapping.properties file to **ISO-8859-1** with the option native-to-ascii conversion
