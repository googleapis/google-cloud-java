Google Cloud Java Client for BigQuery
====================================

Java idiomatic client for [Google Cloud BigQuery] (https://cloud.google.com/bigquery).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquery.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquery.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation] (https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/bigquery/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquery</artifactId>
  <version>0.9.2-beta</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigquery:0.9.2-beta'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquery" % "0.9.2-beta"
```

Example Application
-------------------
- [`BigQueryExample`](../google-cloud-examples/src/main/java/com/google/cloud/examples/bigquery/BigQueryExample.java) - A simple command line interface providing some of Cloud BigQuery's functionality.
Read more about using this application on the [`BigQueryExample` docs page](https://googlecloudplatform.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/bigquery/BigQueryExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud BigQuery
--------------------------

[Google Cloud BigQuery][cloud-bigquery] is a fully managed, NoOps, low cost data analytics service.
Data can be streamed into BigQuery at millions of rows per second to enable real-time analysis.
With BigQuery you can easily deploy Petabyte-scale Databases.

Be sure to activate the Google Cloud BigQuery API on the Developer's Console to use BigQuery from
your project.

See the ``google-cloud`` API [bigquery documentation][bigquery-api] to learn how to interact
with Google Cloud BigQuery using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a
[Google Developers Console](https://console.developers.google.com/) project with the BigQuery API
enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to
use Google Cloud BigQuery.
[Follow these instructions](https://cloud.google.com/docs/authentication#preparation) to get your
project set up. You will also need to set up the local development environment by [installing the
Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-bigquery` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquery` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud BigQuery, you must create a service object with
credentials. You can then make API calls by calling methods on the BigQuery service object. The
simplest way to authenticate is to use
[Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;

BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
```

For other authentication options, see the
[Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) page.

#### Creating a dataset
With BigQuery you can create datasets. A dataset is a grouping mechanism that holds zero or more
tables. Add the following import at the top of your file:

```java
import com.google.cloud.bigquery.DatasetInfo;
```
Then, to create the dataset, use the following code:

```java
// Create a dataset
String datasetId = "my_dataset_id";
bigquery.create(DatasetInfo.newBuilder(datasetId).build());
```

#### Creating a table
With BigQuery you can create different types of tables: normal tables with an associated schema,
external tables backed by data stored on [Google Cloud Storage][cloud-storage] and view tables that
are created from a BigQuery SQL query. In this code snippet we show how to create a normal table
with only one string field. Add the following imports at the top of your file:

```java
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
```
Then add the following code to create the table:

```java
TableId tableId = TableId.of(datasetId, "my_table_id");
// Table field definition
Field stringField = Field.of("StringField", Field.Type.string());
// Table schema definition
Schema schema = Schema.of(stringField);
// Create a table
StandardTableDefinition tableDefinition = StandardTableDefinition.of(schema);
Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
```

#### Loading data into a table
BigQuery provides several ways to load data into a table: streaming rows or loading data from a
Google Cloud Storage file. In this code snippet we show how to stream rows into a table.
Add the following imports at the top of your file:

```java
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;

import java.util.HashMap;
import java.util.Map;
```
Then add the following code to insert data:

```java
Map<String, Object> firstRow = new HashMap<>();
Map<String, Object> secondRow = new HashMap<>();
firstRow.put("StringField", "value1");
secondRow.put("StringField", "value2");
// Create an insert request
InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId)
    .addRow(firstRow)
    .addRow(secondRow)
    .build();
// Insert rows
InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);
// Check if errors occurred
if (insertResponse.hasErrors()) {
  System.out.println("Errors occurred while inserting rows");
}
```

#### Querying data
BigQuery enables querying data by running queries and waiting for the result. Queries can be run
directly or through a Query Job. In this code snippet we show how to run a query directly and wait
for the result. Add the following imports at the top of your file:

```java
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.QueryRequest;
import com.google.cloud.bigquery.QueryResponse;

import java.util.Iterator;
import java.util.List;
```
Then add the following code to run the query and wait for the result:

```java
// Create a query request
QueryRequest queryRequest =
    QueryRequest.newBuilder("SELECT * FROM my_dataset_id.my_table_id")
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .build();
// Request query to be executed and wait for results
QueryResponse queryResponse = bigquery.query(queryRequest);
while (!queryResponse.jobCompleted()) {
  Thread.sleep(1000L);
  queryResponse = bigquery.getQueryResults(queryResponse.getJobId());
}
// Read rows
Iterator<List<FieldValue>> rowIterator = queryResponse.getResult().iterateAll();
System.out.println("Table rows:");
while (rowIterator.hasNext()) {
  System.out.println(rowIterator.next());
}
```
#### Complete source code

In
[InsertDataAndQueryTable.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/bigquery/snippets/InsertDataAndQueryTable.java)
we put together all the code shown above into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud BigQuery.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-bigquery
[cloud-platform]: https://cloud.google.com/

[cloud-bigquery]: https://cloud.google.com/bigquery/
[cloud-storage]: https://cloud.google.com/storage/
[bigquery-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/bigquery/package-summary.html
