#Project Name
Implementation of challenge test case for site http://www.ss.lv 

#Requirements
Please, make sure you have Java and Maven installed.

#Installation
1. Clone repository https://github.com/zhabenya/SS.LV_4_evo.git
2. Run test in IDE or in terminal `mvn test`

**Note**
Currently tests run in Firefox WebDriver.
In /src/main/resources/application.properties file you can change it to another browser or uncomment line
`browser.name=${browser.name}` to enable Maven profiles.

