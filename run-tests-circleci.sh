#!/bin/bash

mvn clean install -DskipTests
mvn test -Dbrowser=remote-chrome -Dspring.profiles.active="staging" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunSuite