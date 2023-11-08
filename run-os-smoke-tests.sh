#!/bin/bash

mvn test -Dbrowser=chrome -Denvironment="STAGING" -Dtest=suites.RunOSSmokeTest