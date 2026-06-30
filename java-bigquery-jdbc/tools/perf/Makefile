# Makefile for running performance tests

# Defaults
ITERATIONS ?= 5
QUERY ?=
QUERY_FILE ?=
ROWS ?= 1000
COLS ?= 5
VERSION ?= $(shell sed -n 's/.*<version>\([^<]*\)<\/version>.*/\1/p' ../../pom.xml | head -n 1)
JAR1 ?= ../../drivers/google-cloud-bigquery-jdbc-$(VERSION)-all.jar
CLASS1 ?= com.google.cloud.bigquery.jdbc.BigQueryDriver
# JAR2 and CLASS2 are optional
JAR2 ?=
CLASS2 ?= com.google.cloud.bigquery.jdbc.BigQueryDriver

# Base URL and common options
PROJECT_ID ?= bigquery-devtools-drivers
CREDENTIALS ?= $(GOOGLE_APPLICATION_CREDENTIALS)

# We assume OAuthType=3 (Service Account) as in the original specs
BASE_URL = jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=$(PROJECT_ID);OAuthType=3;OAuthPvtKeyPath=$(CREDENTIALS);Timeout=3600;

REST_OPTS = EnableHighThroughputAPI=0;
HTAPI_OPTS = EnableHighThroughputAPI=1;HighThroughputActivationRatio=0;HighThroughputMinTableSize=0;

# Python script
RUN_PERF = python3 run_perf.py

# Common flags for run_perf.py
COMMON_FLAGS = -n $(ITERATIONS) --jar1 $(JAR1) --class1 $(CLASS1)

ifeq ($(QUERY)$(QUERY_FILE),)
  COMMON_FLAGS += --generate-rows $(ROWS) --generate-cols $(COLS)
else
  ifneq ($(QUERY),)
    COMMON_FLAGS += --query "$(QUERY)"
  endif
  ifneq ($(QUERY_FILE),)
    COMMON_FLAGS += --query-file "$(QUERY_FILE)"
  endif
endif

ifneq ($(JAR2),)
  COMMON_FLAGS += --jar2 $(JAR2) --class2 $(CLASS2)
endif


.PHONY: run-rest run-htapi compile-client

compile-client:
	$(MAKE) -C ../client classes

run-rest: compile-client
	$(RUN_PERF) --url "$(BASE_URL)$(REST_OPTS)" $(COMMON_FLAGS)

run-htapi: compile-client
	$(RUN_PERF) --url "$(BASE_URL)$(HTAPI_OPTS)" $(COMMON_FLAGS)
