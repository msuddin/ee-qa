# EE-QA Exercise

## Part 1

This is a timeboxed exercise (30 mins) to conduct Manual Testing for EE's hotel booking system. Have performed tests in the following areas:

- Functional
- Cross Browsers (desktop and mobile)
- Accessibility
- Security
- Localization

### High Level highlights:

- It is possible to create/delete records on many popular desktop browsers (including Chrome, Firefox, Explorer, Edge)
- It is possible to navigate saving a record using keyboard
- Internal Server error (500) is thrown when trying to save a record with invalid inputs (e.g. incorrect date format, empty fields) - there is no input validation
- Site is not secure, using HTTP instead of HTTPS - site is storing personal data
- Site stores personal data therefore must confirm with recent GDPR rules - no policies, no way to contact the site admin team etc

### Bugs
- It is possible to save duplicate records
- It is possible to set firstname, surname and price with long Strings
- UI is not responsive, conforms to a single row as soon as the page width goes below 990px - more notable on mobile devices, site is not responsive

### Suggested Change
- Introduce field error messages where possible to make the site a little more easier to use
- Site should be response based on the current height and width of the page

### Suggested Further Testing
Given that this was a timeboxed exercise I was not able to conduct further testing. In reality I could not define how long I would need as there is no defined exist criteria.
- The site is hosted on a micro AWS instance therefore Security and Performance testing may not be suggested in this instance
- However Security and Performance testing should be performed once the site had been moved to a more production like environment
- More security testing
- I do not have access to the underlying API - I would have directly his the endpoint to take the WEB UI out of the testing calculation
- More Accessibility testing - the most basic test, turn of your mouse and see if the site functions

## Part 2

To run the tests, from the root directory of this project run:

```
./gradlew clean test
```

- Tests written in Cucumber BDD - I have re-used some steps from the booking.feature file in deleting.feature file
- Code should detect which is your native OS in which case it will try to run the correct chromedriver (windows vs mac)
- Have abstracted out WebDriver and used Singleton Pattern to ensure the driver can not be instantiated more than once
- Have used the Page Object Pattern to isolate all page related methods
- Have added tags to the RunAllTests class
- Can look in the build/cucumber directory to see test reports

### If I had more time

- My focus here was to get a working solution up and running as opposed to focusing on any libraries which would help overtime e.g. Spring
- I would have added in configuration to run all the tests in headless mode
- I would have written a dockerfile that would help running the tests (may not need to worry too much about the underlying os)