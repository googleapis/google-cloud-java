# Getting Started with BigQuery and the Google Java API Client library

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/GoogleCloudPlatform/java-docs-samples&page=editor&open_in_editor=README.md&cloudshell_working_dir=bigquery/cloud-client/">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

[Google's BigQuery Service][BigQuery] features a REST-based API that allows
developers to create applications to run ad-hoc queries on massive datasets.
These sample Java applications demonstrate how to access the BigQuery API using
the [Google Cloud Client Library for Java][google-cloud-java].

[BigQuery]: https://cloud.google.com/bigquery/
[google-cloud-java]: https://github.com/GoogleCloudPlatform/google-cloud-java

## Quickstart

Install [Maven](http://maven.apache.org/).

[Authenticate using a service account](https://cloud.google.com/docs/authentication/getting-started).
Create a service account, download a JSON key file, and set the `GOOGLE_APPLICATION_CREDENTIALS` environment variable.

Build your project with:

	mvn clean package -DskipTests

You can then run a given `ClassName` via:

	mvn exec:java -Dexec.mainClass=com.example.bigquery.ClassName \
	    -DpropertyName=propertyValue \
		-Dexec.args="any arguments to the app"

### Creating a new dataset (using the quickstart sample)

    mvn exec:java -Dexec.mainClass=com.example.bigquery.QuickstartSample

### Running a query using standard SQL syntax

    mvn exec:java -Dexec.mainClass=com.example.bigquery.QuerySample \
        -Dexec.args=' \
            --query="SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;" \
            --runStandardSqlQuery'

### Running the simple app example

To run the example from the [simple app example
documentation](https://cloud.google.com/bigquery/create-simple-app-api):

    mvn exec:java -Dexec.mainClass=com.example.bigquery.SimpleApp

