#!/bin/bash
while kill -0 $(ps aux | grep "[t]ask-511" | awk '{print $2}') 2>/dev/null; do
  echo "Waiting for task-511..."
  sleep 4
done
echo "task-511 finished!"

cd java-bigquery-jdbc
export SA_NO_READAPI=github-actions-no-readapi@bigquery-devtools-drivers.iam.gserviceaccount.com
export GOOGLE_APPLICATION_CREDENTIALS=/usr/local/google/home/kirl/.config/gcloud/application_default_credentials.json

echo "Building standalone it tests payload (pom-it.xml)..."
PATH=/opt/maven/bin:$PATH make build-it-standalone

echo "Running target test method!"
java -cp "tools/client/drivers/simba/GoogleBigQueryJDBC42.jar:target-it/*" \
  org.junit.platform.console.ConsoleLauncher \
  --select-method com.google.cloud.bigquery.jdbc.it.ITStatementTest#testHighThroughputApiFallbackNoReadApi

