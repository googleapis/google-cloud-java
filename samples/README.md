# Getting Started with BigQuery Samples

## Running a sample using Cloud Shell

The Google Cloud Shell has application default credentials from its compute instance which will allow you to run an integration test without having to obtain `GOOGLE_APPLICATION_CREDENTIANS`.

However, certain samples require environment variables to be set. For instance, in `CreateDatasetIT.java`:

`private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");` - this sample integration test requires you to specific the [Google Cloud Project](https://cloud.google.com/resource-manager/docs/creating-managing-projects) you would like to run the test in.

Make sure to set environment variables, if necessary, before running the sample, or else you will get an error asking you to set it.

To run a samples integration tests in the cloud shell, simply run the following commands:

`cd samples/snippets` - all samples are located in `java-bigquery/samples/snippets` directory.

`mvn -Dtest=GetTableIT test` - this runs the integration test of `GetTable.java` sample.