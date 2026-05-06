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

ROWS ?= 10
COLS ?= 5
METHOD ?= getTables

OUTPUT ?= false
QUERY ?= SELECT 1

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

COMMON_FLAGS = --url "$(URL)" \
               --driver-jar "$(DRIVER_JAR)" \
               --driver-class "$(DRIVER_CLASS)" \
               --ProjectId "bigquery-devtools-drivers" \
               --OAuthType=0 \
               --OAuthServiceAcctEmail="" \
               --OAuthPvtKeyPath="$(CREDENTIALS)" \
               --EnableHighThroughputAPI=1 \
               --HighThroughputActivationRatio=0 \
               --HighThroughputMinTableSize=0 \
               --MaxResults=20000 \
               --EnableSession=1

query: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action query $(COMMON_FLAGS) --query "$(QUERY)" $(OUTPUT_FLAG) $(EXTRA_ARGS)

query-generated: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action query $(COMMON_FLAGS) $(OUTPUT_FLAG) --generate-rows $(ROWS) --generate-cols $(COLS) $(EXTRA_ARGS)

metadata: classes
	$(J) $(JFR_FLAGS) -cp .:$(DRIVER_JAR) JDBCClient --action metadata --metadata-method $(METHOD) $(COMMON_FLAGS) $(EXTRA_ARGS)
