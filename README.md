
## selenium-cucumber-ui-tests
Selenium-Cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate test cases with minimal coding.

## vsip-ui-tests
UI test suite for the `hmpps-vsip` service using Webdriver and `java/cucumber`

## Background info
Used the approach given in this critical to introduce spring to the testing project
https://www.swtestacademy.com/selenium-spring-boot-cucumber-junit5-project/


## Running the tests

Java 21 is required, would recommend using SDK man to install a newer version of JDK https://sdkman.io/usage
How to install: https://sdkman.io/install

To list sdk versions to install :

`sdk list java`

To install JDK 21 you could use the following :

`sdk install java 21.0.1-tem`


Prior to executing the tests ensure you have:
- Docker - to run a Chrome or Firefox browser inside a container
- Appropriate [drivers installed](#install-driver-binary) - to run tests against locally installed Browser

Run the following command to start services locally:

`mvn test -Dbrowser=chrome -Dspring.profiles.active="local" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunSuite`

Then execute the shell scrips `run_tests_local.sh, run-os-smoke-tests.sh, run-smoke-tests.sh` script:

The `run_tests_local.sh` script allows to choose an environment with the locally installed `chrome` driver binary.  
For a complete list of supported param values, e.g:

```bash
-Dspring.profiles.active="local"
-Dspring.profiles.active="dev"
-Dspring.profiles.active="staging"
```

These details are set in the corrisponding files

```bash
./resources/application-local.properties
./resources/application-dev.properties
./resources/application-staging.properties
```
## Setting CLIENT_SECRET and CLIENT_ID

Inorder for the Test helper service to work correctly you must set the environment variables for :

CLIENT_SECRET

CLIENT_ID

The easy way to do this is as follows on the mac

```bash
touch ~/.zprofile
open ~/.zprofile
```

Then in the text editor add :
```bash
export CLIENT_ID=hmpps-test-id
export CLIENT_SECRET='.01EAWS33333OGu=Q+%aA%tn1T-UB+xAewSf3*Qww,4S,Vk>s3372j)AaTtO2'
```
The client id and secret above are not a real ones, to get the id and secret you must run the following command.
Please make sure the CLIENT_SECRET value is wrapped by 'CLIENT_SECRET_VALUE' 
```bash
kubectl -n visit-someone-in-prison-backend-svc-staging  get secrets hmpps-prison-visits-testing-helper-api -o json | jq '.data | map_values(@base64d)'
```

## Running tests against a containerised browser - on your machine

The script `./run-tests-with-docker.sh` can be used to start a Chrome or Firefox container on your machine.

To run against a containerised Chrome browser:

```bash
./run-tests-with-docker.sh executes tests using remote-chrome 
./run-tests-local.sh requires to pass parameters
```

`./run-tests-with-docker.sh` is **NOT** required when running in a CI environment.

- *<operating-system>* supports **macos**
- *<driver-version>* Browser versions available here [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *Need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*
