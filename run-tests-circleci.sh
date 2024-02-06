#!/bin/bash

mvn clean install -DskipTests
mvn test -Dbrowser=remote-chrome -Dspring.profiles.active="dev" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunSuite