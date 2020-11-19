# automation-framework

This a sample project to show how to create a framework for Web UI and API testing. It's build using Java and Maven as base, JUnit for test declaration, Selenium for interaction with web pages and Allure for result reporting.

The page we use for the tests is https://automation-practice.web.app, a web page with different levels for UI and API testing.
## Running with maven

- Run tests: mvn tests
- Generate report: mvn allure:report

## Configuration
All configuration is made using the properties files in test/resources

### Running in parallel
To be able to run tests in parallel, set the property junit.jupiter.execution.parallel.config.fixed.parallelism to something bigger than one

### Rerun failed tests
If we have a flaky test, we can try to rerun them to see if we get a "green" out of them. It is not a recommended aproach, but it can be done by setting when running the tests in maven -Dtests.rerun={number of retries we want to make}.