#!/bin/bash

./gradlew ktlintFormat && ./gradlew ktlintCheck && ./gradlew detekt && ./gradlew spotlessApply && ./gradlew build