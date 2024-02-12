#!/bin/bash

mvn test -Dbrowser=chrome -Dspring.profiles.active="staging" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunSuite