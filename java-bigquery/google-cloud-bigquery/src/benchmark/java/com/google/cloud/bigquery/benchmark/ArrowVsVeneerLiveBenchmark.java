/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.benchmark;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryResultsFormat;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import java.io.IOException;
import java.nio.channels.Channels;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;

/**
 * End-to-end live performance benchmark comparing:
 * 1. Veneer Client with default JSON (REST jobs.query)
 * 2. Veneer Client with Arrow (fast-path REST + gRPC stream pagination into FieldValueList)
 * 3. Raw Storage Read API (BigQueryReadClient consuming raw VectorSchemaRoot with zero copy)
 */
public class ArrowVsVeneerLiveBenchmark {

  private static final String PROJECT_ID = "gcloud-devel";
  private static final int DEFAULT_ROWS = 200_000;
  private static final int ITERATIONS = 3;

  public static void main(String[] args) throws Exception {
    int totalRows = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_ROWS;
    System.out.println("================================================================================");
    System.out.println("  BIGQUERY ARROW VS VENEER LIVE BENCHMARK");
    System.out.println("  Project ID : " + PROJECT_ID);
    System.out.println("  Dataset    : " + totalRows + " rows (synthetic numeric + string columns)");
    System.out.println("  Iterations : " + ITERATIONS + " (1 warmup + " + (ITERATIONS - 1) + " measurement)");
    System.out.println("================================================================================");

    String endpoint = System.getenv("BIGQUERY_ENDPOINT");
    if (endpoint == null) {
      endpoint = "https://us-east7-bigquery.googleapis.com";
    }
    System.out.println("  Endpoint   : " + endpoint);

    BigQueryOptions.Builder bqBuilder =
        BigQueryOptions.newBuilder().setProjectId(PROJECT_ID).setHost(endpoint);
    BigQuery bigquery = bqBuilder.build().getService();

    String storageHost = endpoint;
    if (storageHost.contains("://")) {
      storageHost = java.net.URI.create(storageHost).getAuthority();
    }
    storageHost = storageHost.replace("bigquery.googleapis.com", "bigquerystorage.googleapis.com");
    BigQueryReadSettings readSettings =
        BigQueryReadSettings.newBuilder().setEndpoint(storageHost + ":443").build();
    BigQueryReadClient readClient = BigQueryReadClient.create(readSettings);

    String query =
        String.format(
            "SELECT x, CONCAT('sample_string_value_', CAST(x AS STRING)) AS str_col, x * 1.5 AS float_col "
                + "FROM UNNEST(GENERATE_ARRAY(1, %d)) AS x",
            totalRows);

    // Warmup
    System.out.println("\n--- [WARMUP PASS (50,000 rows)] ---");
    String warmupQuery = "SELECT x, CONCAT('str_', CAST(x AS STRING)) AS str_col, x * 1.5 AS float_col FROM UNNEST(GENERATE_ARRAY(1, 50000)) AS x";
    runVeneerQuery(bigquery, warmupQuery, QueryResultsFormat.STRUCT_ENCODING, true);
    runVeneerQuery(bigquery, warmupQuery, QueryResultsFormat.ARROW, true);

    // Measurement Runs
    List<Long> jsonTimes = new ArrayList<>();
    List<Long> arrowVeneerTimes = new ArrayList<>();
    List<Long> rawArrowTimes = new ArrayList<>();

    // Execute query to get a persistent destination table for the Raw Read API comparison
    System.out.println("\nPreparing query destination table for Raw Read API...");
    QueryJobConfiguration prepConfig =
        QueryJobConfiguration.newBuilder(query).setUseLegacySql(false).build();
    Job prepJob = bigquery.create(com.google.cloud.bigquery.JobInfo.of(prepConfig));
    prepJob = prepJob.waitFor();
    TableId destTable = ((QueryJobConfiguration) prepJob.getConfiguration()).getDestinationTable();
    System.out.println("Destination table ready: " + destTable);

    for (int i = 1; i <= ITERATIONS; i++) {
      System.out.println(String.format("\n--- [ITERATION %d of %d] ---", i, ITERATIONS));

      // 1. Veneer JSON
      long tJson = runVeneerQuery(bigquery, query, QueryResultsFormat.STRUCT_ENCODING, false);
      if (i > 1) jsonTimes.add(tJson);

      // 2. Veneer Arrow
      long tArrowVeneer = runVeneerQuery(bigquery, query, QueryResultsFormat.ARROW, false);
      if (i > 1) arrowVeneerTimes.add(tArrowVeneer);

      // 3. Raw Arrow Read API
      long tRawArrow = runRawReadApi(readClient, PROJECT_ID, destTable, totalRows);
      if (i > 1) rawArrowTimes.add(tRawArrow);
    }

    readClient.close();

    // Summary Calculations
    double avgJson = jsonTimes.stream().mapToLong(Long::longValue).average().orElse(0);
    double avgArrowVeneer = arrowVeneerTimes.stream().mapToLong(Long::longValue).average().orElse(0);
    double avgRawArrow = rawArrowTimes.stream().mapToLong(Long::longValue).average().orElse(0);

    double jsonThroughput = (totalRows / (avgJson / 1000.0));
    double arrowVeneerThroughput = (totalRows / (avgArrowVeneer / 1000.0));
    double rawArrowThroughput = (totalRows / (avgRawArrow / 1000.0));

    double speedupOverJson = avgJson / avgArrowVeneer;
    double pctOfRawSpeed = (avgRawArrow / avgArrowVeneer) * 100.0;
    double overheadOfVeneer = avgArrowVeneer - avgRawArrow;

    System.out.println("\n================================================================================");
    System.out.println("  BENCHMARK RESULTS SUMMARY (" + totalRows + " rows)");
    System.out.println("================================================================================");
    System.out.println(String.format("%-32s | %-12s | %-16s | %-14s", "Implementation", "Avg Time", "Throughput", "Speedup vs JSON"));
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println(String.format("%-32s | %9.1f ms | %10.0f rows/s | %13.2fx", "1. Veneer Client (JSON)", avgJson, jsonThroughput, 1.00));
    System.out.println(String.format("%-32s | %9.1f ms | %10.0f rows/s | %13.2fx", "2. Veneer Client (Arrow)", avgArrowVeneer, arrowVeneerThroughput, speedupOverJson));
    System.out.println(String.format("%-32s | %9.1f ms | %10.0f rows/s | %13.2fx", "3. Raw Arrow (Storage Read API)", avgRawArrow, rawArrowThroughput, avgJson / avgRawArrow));
    System.out.println("================================================================================");
    System.out.println(String.format("Key Insight 1: Veneer Arrow is %.2fx faster than Veneer JSON.", speedupOverJson));
    System.out.println(String.format("Key Insight 2: Veneer Arrow achieves %.1f%% of raw zero-copy Arrow throughput.", pctOfRawSpeed));
    System.out.println(String.format("Key Insight 3: FieldValueList heap copying adds %.1f ms overhead over raw Arrow.", overheadOfVeneer));
    System.out.println("================================================================================\n");
  }

  private static long runVeneerQuery(
      BigQuery bigquery, String query, QueryResultsFormat format, boolean silent) throws Exception {
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setUseLegacySql(false)
            .setQueryResultsFormat(format)
            .build();

    Instant start = Instant.now();
    TableResult result = bigquery.query(config);

    long count = 0;
    long dummySum = 0;
    for (FieldValueList row : result.iterateAll()) {
      count++;
      // Touch field values to simulate actual application processing
      dummySum += row.get("x").getLongValue();
      String s = row.get("str_col").getStringValue();
      dummySum += s.length();
      double d = row.get("float_col").getDoubleValue();
      dummySum += (long) d;
    }

    long elapsed = Duration.between(start, Instant.now()).toMillis();
    if (!silent) {
      System.out.println(
          String.format("  [Veneer %-5s] Read %d rows in %4d ms (dummy checksum: %d)", format, count, elapsed, dummySum));
    }
    return elapsed;
  }

  private static long runRawReadApi(
      BigQueryReadClient readClient, String projectId, TableId tableId, int expectedRows)
      throws IOException {
    String tableModifier =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            tableId.getProject(), tableId.getDataset(), tableId.getTable());

    Instant start = Instant.now();
    ReadSession readSession =
        ReadSession.newBuilder()
            .setTable(tableModifier)
            .setDataFormat(DataFormat.ARROW)
            .build();

    CreateReadSessionRequest sessionRequest =
        CreateReadSessionRequest.newBuilder()
            .setParent("projects/" + projectId)
            .setReadSession(readSession)
            .setMaxStreamCount(1)
            .build();

    ReadSession session = readClient.createReadSession(sessionRequest);
    String streamName = session.getStreams(0).getName();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(streamName).build();

    ServerStream<ReadRowsResponse> stream = readClient.readRowsCallable().call(readRowsRequest);

    long count = 0;
    long dummySum = 0;

    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      org.apache.arrow.vector.types.pojo.Schema arrowSchema =
          MessageSerializer.deserializeSchema(
              new ReadChannel(
                  Channels.newChannel(session.getArrowSchema().getSerializedSchema().newInput())));

      try (VectorSchemaRoot root = VectorSchemaRoot.create(arrowSchema, allocator)) {
        VectorLoader loader = new VectorLoader(root);
        for (ReadRowsResponse response : stream) {
          if (response.hasArrowRecordBatch()) {
            try (ArrowRecordBatch batch =
                MessageSerializer.deserializeRecordBatch(
                    new ReadChannel(
                        Channels.newChannel(
                            response.getArrowRecordBatch().getSerializedRecordBatch().newInput())),
                    allocator)) {
              loader.load(batch);
              int rowCount = root.getRowCount();
              BigIntVector xVec = (BigIntVector) root.getVector("x");
              VarCharVector strVec = (VarCharVector) root.getVector("str_col");
              Float8Vector floatVec = (Float8Vector) root.getVector("float_col");

              for (int i = 0; i < rowCount; i++) {
                count++;
                dummySum += xVec.get(i);
                byte[] s = strVec.get(i);
                dummySum += s.length;
                dummySum += (long) floatVec.get(i);
              }
            }
          }
        }
      }
    }

    long elapsed = Duration.between(start, Instant.now()).toMillis();
    System.out.println(
        String.format("  [Raw Arrow  ] Read %d rows in %4d ms (dummy checksum: %d)", count, elapsed, dummySum));
    return elapsed;
  }
}
