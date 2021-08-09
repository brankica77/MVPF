# MVPF
Automation test

## Task 
Write three automated browser-based tests for https://www.seleniumeasy.com/test/: 

One that checks one of the input forms 

One that verify one of the alerts and modals

One that tests one of the list boxes 

## Details 
• Selenium WebDriver 3.x: https://www.selenium.dev/

• Implemented the page objects pattern: http://code.google.com/p/selenium/wiki/PageObjects 

• Tests are written in Maven Java that WebDriver supports

• Intellij IDEA framework is used on Win 10

## Possible issues
• `BaseTest` class defines file path that should work on any OS, but sometimes may couse issues on non Win enviroments

## Project structure

• Package `data` represents any test related data that should be used as expected result or pre-defined test inputs. Relates to the `captions.json` from `resources`

• Package `pages` contains corresponding Page Classes: input form page, alert page and list box page.

• Package `utils` contains common utils for the Java tests

• Package `tests` contains tests for each page  
