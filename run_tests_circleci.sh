#!/bin/bash

mvn clean install -DskipTests
mvn test -Dbrowser=remote-chrome -Denvironment="STAGING"