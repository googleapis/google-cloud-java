# Getting Started with BigQuery Samples

## Running a sample using Cloud Shell

The Google Cloud Shell has application default credentials from its compute instance which will allow you to run an integration test without having to obtain `GOOGLE_APPLICATION_CREDENTIALS`. Go to [BigQuery Client Readme](https://github.com/googleapis/java-bigquery#samples) to run each sample in the Cloud Shell.

## Running a sample using command line

First set up `GOOGLE_APPLICATION_CREDENTIALS` and `GOOGLE_CLOUD_PROJECT` environment variables before running any samples.

To run a sample:
1. `cd samples/snippets` - all samples are located in `java-bigquery/samples/snippets` directory.
2. `mvn compile exec:java -Dexec.mainClass=com.example.bigquery.SimpleQuery` - this runs the [SimpleQuery sample](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/SimpleQuery.java) which runs the BigQuery query method. You can update the developer's `TODO` section in the snippet if you wish to run a different query.

## Running a sample integration test using command line

Note that some samples require environment variables to be set. For instance, in `CreateDatasetIT.java`:

`private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");` - this sample integration test requires you to specific the [Google Cloud Project](https://cloud.google.com/resource-manager/docs/creating-managing-projects) you would like to run the test in.

Make sure to set environment variables, if necessary, before running the sample, or else you will get an error asking you to set it.

To run a samples integration tests:

1. `cd samples/snippets` - all samples are located in `java-bigquery/samples/snippets` directory.
2. `mvn -Dtest=GetTableIT test` - this runs the integration test of `GetTable.java` sample.