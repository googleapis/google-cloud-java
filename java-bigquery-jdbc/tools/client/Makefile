# Makefile for Java JDBC Client

JC = javac
J = java --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -Xmx2g

default: classes

classes: JDBCClient.class

JDBCClient.class: JDBCClient.java
	$(JC) JDBCClient.java

clean:
	rm -f *.class


# Default configuration
VERSION = $(shell sed -n 's/.*<version>\([^<]*\)<\/version>.*/\1/p' ../../pom.xml | head -n 1)
DRIVER_JAR ?= ../../drivers/google-cloud-bigquery-jdbc-$(VERSION)-all.jar
DRIVER_CLASS = com.google.cloud.bigquery.jdbc.BigQueryDriver
URL ?= jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;
CREDENTIALS ?= $(GOOGLE_APPLICATION_CREDENTIALS)

# Default connection parameters
PARAMS = ProjectId=bigquery-devtools-drivers;OAuthType=0;OAuthServiceAcctEmail=;OAuthPvtKeyPath=$(CREDENTIALS);

# Additional connection parameters
EXTRA_PARAMS ?=

METHOD ?= getTables

ROWS ?= 10
COLS ?= 5

OUTPUT ?= false
QUERY ?= SELECT 1
QUERY_FILE ?=

ifneq ($(QUERY_FILE),)
  QUERY_FLAG = --query-file "$(QUERY_FILE)"
else
  QUERY_FLAG = --query "$(QUERY)"
endif

ifeq ($(OUTPUT),false)
  OUTPUT_FLAG = --no-output
else
  OUTPUT_FLAG =
endif

# JFR Configuration
JFR ?= false
ifeq ($(JFR),true)
  JFR_FLAGS = -XX:StartFlightRecording=settings=./config/sampler.jfc,filename=recording.jfr
else
  JFR_FLAGS =
endif

COMMON_FLAGS = --url "$(URL);$(DEFAULT_PARAMS);$(PARAMS);$(EXTRA_PARAMS)" \
               --driver-jar "$(DRIVER_JAR)" \
               --driver-class "$(DRIVER_CLASS)"

query: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action query $(COMMON_FLAGS) $(QUERY_FLAG) $(OUTPUT_FLAG) $(EXTRA_ARGS)

query-generated: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action query $(COMMON_FLAGS) $(OUTPUT_FLAG) --generate-rows $(ROWS) --generate-cols $(COLS) $(EXTRA_ARGS)

metadata: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action metadata --metadata-method $(METHOD) $(COMMON_FLAGS) $(EXTRA_ARGS)
