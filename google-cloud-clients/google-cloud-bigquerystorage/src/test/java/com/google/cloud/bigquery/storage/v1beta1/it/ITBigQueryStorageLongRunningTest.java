/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import com.google.protobuf.TextFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Integration tests for BigQuery Storage API which target long running sessions. These tests can be
 * enabled by setting the system property 'bigquery.storage.enable_long_running_tests' to true.
 */
public class ITBigQueryStorageLongRunningTest {

  private static final Logger LOG =
      Logger.getLogger(ITBigQueryStorageLongRunningTest.class.getName());

  private static final String LONG_TESTS_ENABLED_PROPERTY =
      "bigquery.storage.enable_long_running_tests";

  private static final String LONG_TESTS_DISABLED_MESSAGE =
      String.format(
          "BigQuery Storage long running tests are not enabled and will be skipped. "
              + "To enable them, set system property '%s' to true.",
          LONG_TESTS_ENABLED_PROPERTY);

  private static BigQueryStorageClient client;
  private static String parentProjectId;

  @BeforeClass
  public static void beforeClass() throws IOException {
    Assume.assumeTrue(LONG_TESTS_DISABLED_MESSAGE, Boolean.getBoolean(LONG_TESTS_ENABLED_PROPERTY));
    client = BigQueryStorageClient.create();
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageLongRunningTest.class.getSimpleName(), parentProjectId));
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
    }
  }

  @Test
  public void testLongRunningReadSession() throws InterruptedException, ExecutionException {
    // This test reads a larger table with the goal of doing a simple validation of timeout settings
    // for a longer running session.

    TableReference tableReference =
        TableReference.newBuilder()
            .setProjectId("bigquery-public-data")
            .setDatasetId("samples")
            .setTableId("wikipedia")
            .build();

    ReadSession session =
        client.createReadSession(
            /* tableReference = */ tableReference,
            /* parent = */ parentProjectId,
            /* requestedStreams = */ 5);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        5,
        session.getStreamsCount());

    List<Callable<Long>> tasks = new ArrayList<>(session.getStreamsCount());
    for (final Stream stream : session.getStreamsList()) {
      tasks.add(
          new Callable<Long>() {
            @Override
            public Long call() throws Exception {
              return readAllRowsFromStream(stream);
            }
          });
    }

    ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
    List<Future<Long>> results = executor.invokeAll(tasks);

    long avroRowCount = 0;
    for (Future<Long> result : results) {
      avroRowCount += result.get();
    }

    assertEquals(313_797_035, avroRowCount);
  }

  private long readAllRowsFromStream(Stream stream) {
    StreamPosition readPosition = StreamPosition.newBuilder().setStream(stream).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    long avroRowCount = 0;
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : serverStream) {
      assertTrue(
          String.format(
              "Response is missing 'avro_rows'. Read %d rows so far from stream '%s'. ReadRows response:%n%s",
              avroRowCount, stream.getName(), response.toString()),
          response.hasAvroRows());
      avroRowCount += response.getAvroRows().getRowCount();
    }

    LOG.info(
        String.format("Read total of %d rows from stream '%s'.", avroRowCount, stream.getName()));
    return avroRowCount;
  }
}
