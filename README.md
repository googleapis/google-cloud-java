# Google Cloud BigQuery Client for Java

Java idiomatic client for [Cloud BigQuery][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<!--  Using libraries-bom to manage versions.
See https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>5.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigquery</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquery</artifactId>
  <version>1.111.1</version>
</dependency>

```

[//]: # ({x-version-update-start:google-cloud-bigquery:released})

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigquery:1.111.1'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquery" % "1.111.1"
```
[//]: # ({x-version-update-end})

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud BigQuery [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud BigQuery.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-bigquery` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquery` as a dependency in your code.

## About Cloud BigQuery


[Cloud BigQuery][product-docs] is a fully managed, NoOps, low cost data analytics service.
Data can be streamed into BigQuery at millions of rows per second to enable real-time analysis.
With BigQuery you can easily deploy Petabyte-scale Databases.

See the [Cloud BigQuery client library docs][javadocs] to learn how to
use this Cloud BigQuery Client Library.


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
external tables backed by data stored on [Google Cloud Storage](https://cloud.google.com/storage/) and view tables that
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
Field stringField = Field.of("StringField", LegacySQLTypeName.STRING);
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
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;
```
Then add the following code to run the query and wait for the result:

```java
// Create a query request
QueryJobConfiguration queryConfig =
    QueryJobConfiguration.newBuilder("SELECT my_column FROM my_dataset_id.my_table_id").build();
// Read rows
System.out.println("Table rows:");
for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
  System.out.println(row);
}
```
#### Complete source code

In
[InsertDataAndQueryTable.java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/bigquery/snippets/InsertDataAndQueryTable.java)
we put together all the code shown above into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.



## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-bigquery/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Add Column Load Append | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/AddColumnLoadAppend.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/AddColumnLoadAppend.java) |
| Add Empty Column | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/AddEmptyColumn.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/AddEmptyColumn.java) |
| Auth Drive Scope | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/AuthDriveScope.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/AuthDriveScope.java) |
| Auth Snippets | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/AuthSnippets.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/AuthSnippets.java) |
| Copy Multiple Tables | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/CopyMultipleTables.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/CopyMultipleTables.java) |
| Create Clustered Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/CreateClusteredTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/CreateClusteredTable.java) |
| Create Dataset | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/CreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/CreateDataset.java) |
| Create Partitioned Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/CreatePartitionedTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/CreatePartitionedTable.java) |
| Create Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/CreateTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/CreateTable.java) |
| Delete Dataset | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/DeleteDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/DeleteDataset.java) |
| Delete Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/DeleteTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/DeleteTable.java) |
| Extract Table To Json | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/ExtractTableToJson.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/ExtractTableToJson.java) |
| Get Dataset Info | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/GetDatasetInfo.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/GetDatasetInfo.java) |
| Get Model | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/GetModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/GetModel.java) |
| Get Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/GetTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/GetTable.java) |
| List Datasets | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/ListDatasets.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/ListDatasets.java) |
| List Models | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/ListModels.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/ListModels.java) |
| List Tables | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/ListTables.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/ListTables.java) |
| Load Local File | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/LoadLocalFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/LoadLocalFile.java) |
| Load Parquet | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/LoadParquet.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/LoadParquet.java) |
| Load Parquet Replace Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/LoadParquetReplaceTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/LoadParquetReplaceTable.java) |
| Load Partitioned Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/LoadPartitionedTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/LoadPartitionedTable.java) |
| Load Table Clustered | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/LoadTableClustered.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/LoadTableClustered.java) |
| Nested Repeated Schema | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/NestedRepeatedSchema.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/NestedRepeatedSchema.java) |
| Query Clustered Table | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/QueryClusteredTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/QueryClusteredTable.java) |
| Query With Named Parameters | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/QueryWithNamedParameters.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/QueryWithNamedParameters.java) |
| Query With Positional Parameters | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/QueryWithPositionalParameters.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/QueryWithPositionalParameters.java) |
| Query With Structs Parameters | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/QueryWithStructsParameters.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/QueryWithStructsParameters.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/QuickstartSample.java) |
| Relax Column Mode | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/RelaxColumnMode.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/RelaxColumnMode.java) |
| Relax Table Query | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/RelaxTableQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/RelaxTableQuery.java) |
| Run Legacy Query | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/RunLegacyQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/RunLegacyQuery.java) |
| Simple App | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/SimpleApp.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/SimpleApp.java) |
| Table Insert Rows | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/TableInsertRows.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/TableInsertRows.java) |
| Update Dataset Access | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetAccess.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetAccess.java) |
| Update Dataset Description | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetDescription.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetDescription.java) |
| Update Dataset Expiration | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetExpiration.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/UpdateDatasetExpiration.java) |
| Update Table Expiration | [source code](https://github.com/googleapis/java-bigquery/blob/master/samples/snippets/src/main/java/com/example/bigquery/UpdateTableExpiration.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquery&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquery/UpdateTableExpiration.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[product-docs]: https://cloud.google.com/bigquery
[javadocs]: https://googleapis.dev/java/google-cloud-bigquery/latest
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquery/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquery.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-bigquery&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-bigquery/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-bigquery/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-bigquery/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=bigquery.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
