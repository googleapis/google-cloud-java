# Migrating BigQuery Storage API from v1beta1 to v1: Java

This guide shows how to migrate Java code using the BigQuery Storage API from
version `v1beta1` to `v1`.

## Key Changes

*   **Service Client**: `BigQueryStorageClient` is replaced by
    `BigQueryReadClient`.
*   **Table Reference**: `TableReference` proto message is replaced by a simple
    string representation of the table path in `ReadSession`.
*   **Session Configuration**: Several fields from `CreateReadSessionRequest`
    have moved into `ReadSession` (which is now passed as a field in the
    request).
*   **Parallelism**: `requested_streams` is replaced by `max_stream_count`.
*   **Sharding Strategy**: `sharding_strategy` is removed. The server now
    automatically balances the streams.
*   **Read Rows Request**: `StreamPosition` is flattened. You now pass the
    stream name directly as `read_stream` and the `offset` as a top-level field
    in `ReadRowsRequest`.

## Code Comparison

### 1. Client Initialization

**v1beta1:**

```java
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;

try (BigQueryStorageClient client = BigQueryStorageClient.create()) {
  // use client
}
```

**v1:**

```java
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;

try (BigQueryReadClient client = BigQueryReadClient.create()) {
  // use client
}
```

### 2. Creating a Read Session

**v1beta1:**

```java
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.DataFormat;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ShardingStrategy;
import com.google.cloud.bigquery.storage.v1beta1.ReadOptions.TableReadOptions;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;

// ...

TableReference tableReference = TableReference.newBuilder()
    .setProjectId("bigquery-public-data")
    .setDatasetId("usa_names")
    .setTableId("usa_1910_current")
    .build();

TableReadOptions options = TableReadOptions.newBuilder()
    .addSelectedFields("name")
    .setRowRestriction("state = \"WA\"")
    .build();

CreateReadSessionRequest request = CreateReadSessionRequest.newBuilder()
    .setParent("projects/read-session-project")
    .setTableReference(tableReference)
    .setReadOptions(options)
    .setRequestedStreams(1)
    .setFormat(DataFormat.AVRO)
    .setShardingStrategy(ShardingStrategy.LIQUID)
    .build();

ReadSession session = client.createReadSession(request);
```

**v1:**

```java
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.ReadSession.TableReadOptions;

// ...

// Table path is now a string: projects/{project}/datasets/{dataset}/tables/{table}
String tablePath = "projects/bigquery-public-data/datasets/usa_names/tables/usa_1910_current";

TableReadOptions options = TableReadOptions.newBuilder()
    .addSelectedFields("name")
    .setRowRestriction("state = \"WA\"")
    .build();

// ReadSession holds the session configuration (table, options, format)
ReadSession readSession = ReadSession.newBuilder()
    .setTable(tablePath)
    .setDataFormat(DataFormat.AVRO) // format renamed to data_format
    .setReadOptions(options)
    .build();

CreateReadSessionRequest request = CreateReadSessionRequest.newBuilder()
    .setParent("projects/read-session-project")
    .setReadSession(readSession)
    .setMaxStreamCount(1) // requested_streams renamed to max_stream_count
    .build();

ReadSession session = client.createReadSession(request);
```

### 3. Reading Rows

**v1beta1:**

```java
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;

// ...
StreamPosition readPosition = StreamPosition.newBuilder()
    .setStream(session.getStreams(0)) // Stream object
    .setOffset(0)
    .build();

ReadRowsRequest readRowsRequest = ReadRowsRequest.newBuilder()
    .setReadPosition(readPosition)
    .build();

ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
for (ReadRowsResponse response : stream) {
  // Process response.getAvroRows()
}
```

**v1:**

```java
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;

// ...
// ReadRowsRequest is flattened. We pass the stream name (string) and offset directly.
ReadRowsRequest readRowsRequest = ReadRowsRequest.newBuilder()
    .setReadStream(session.getStreams(0).getName()) // Stream name string
    .setOffset(0)
    .build();

ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
for (ReadRowsResponse response : stream) {
  // Process response.getAvroRows()
}
```
