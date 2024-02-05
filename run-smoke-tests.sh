#!/bin/bash

mvn test -Dbrowser=chrome -Dspring.profiles.active="dev" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunVSSmokeTest