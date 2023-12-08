#!/bin/bash

mvn test -Dbrowser=chrome -Denvironment="STAGING" -Dtest=uk.gov.justice.digital.hmpps.vsip.suites.RunOSSmokeTest