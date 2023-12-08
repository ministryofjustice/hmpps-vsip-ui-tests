#!/bin/bash

mvn clean install -DskipTests
mvn test -Dbrowser=remote-chrome -Denvironment="STAGING" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunSuite