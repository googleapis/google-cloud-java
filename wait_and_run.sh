#!/bin/bash
while kill -0 $(ps aux | grep "[t]ask-448" | awk '{print $2}') 2>/dev/null; do
  echo "Waiting for task-448..."
  sleep 5
done
echo "task-448 finished!"
cd java-bigquery-jdbc
export SA_NO_READAPI=github-actions-no-readapi@bigquery-devtools-drivers.iam.gserviceaccount.com
export GOOGLE_APPLICATION_CREDENTIALS=/usr/local/google/home/kirl/.config/gcloud/application_default_credentials.json

PATH=/opt/maven/bin:$PATH make build-it-standalone
echo "Running standalone tests"
PATH=/opt/maven/bin:$PATH make run-it-standalone
