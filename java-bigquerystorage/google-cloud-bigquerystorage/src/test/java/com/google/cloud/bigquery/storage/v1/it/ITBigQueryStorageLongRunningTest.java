/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1.it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.ReadStream;
import com.google.cloud.bigquery.storage.v1.it.util.BigQueryResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Integration tests for BigQuery Storage API which target long running sessions. These tests can be
 * enabled by setting the system property 'bigquery.storage.enable_long_running_tests' to true.
 */
class ITBigQueryStorageLongRunningTest {

  private static final Logger LOG =
      Logger.getLogger(ITBigQueryStorageLongRunningTest.class.getName());

  private static final String LONG_TESTS_ENABLED_PROPERTY =
      "bigquery.storage.enable_long_running_tests";

  private static final String LONG_TESTS_DISABLED_MESSAGE =
      String.format(
          "BigQuery Storage long running tests are not enabled and will be skipped. "
              + "To enable them, set system property '%s' to true.",
          LONG_TESTS_ENABLED_PROPERTY);

  private static BigQueryReadClient client;
  private static String parentProjectId;

  @BeforeAll
  static void beforeAll() throws IOException {
    Assumptions.assumeTrue(
        Boolean.getBoolean(LONG_TESTS_ENABLED_PROPERTY), LONG_TESTS_DISABLED_MESSAGE);
    client = BigQueryReadClient.create();
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageLongRunningTest.class.getSimpleName(), parentProjectId));
  }

  @AfterAll
  static void afterAll() throws InterruptedException {
    if (client != null) {
      client.close();
      client.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  @Test
  void testLongRunningReadSession() throws InterruptedException, ExecutionException {
    // This test reads a larger table with the goal of doing a simple validation of timeout settings
    // for a longer running session.

    String table =
        BigQueryResource.formatTableResource(
            /* projectId= */ "bigquery-public-data",
            /* datasetId= */ "samples",
            /* tableId= */ "wikipedia");

    ReadSession session =
        client.createReadSession(
            /* parent= */ parentProjectId,
            /* readSession= */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount= */ 5);

    assertEquals(
        5,
        session.getStreamsCount(),
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession"
                + " response:%n%s",
            table, session.toString()));

    List<Callable<Long>> tasks = new ArrayList<>(session.getStreamsCount());
    for (final ReadStream stream : session.getStreamsList()) {
      tasks.add(() -> readAllRowsFromStream(stream));
    }

    ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
    List<Future<Long>> results = executor.invokeAll(tasks);
    executor.shutdown();

    long rowCount = 0;
    for (Future<Long> result : results) {
      rowCount += result.get();
    }

    assertEquals(313_797_035, rowCount);
  }

  private long readAllRowsFromStream(ReadStream readStream) {

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(readStream.getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : serverStream) {
      rowCount += response.getRowCount();
    }

    LOG.info(
        String.format("Read total of %d rows from stream '%s'.", rowCount, readStream.getName()));
    return rowCount;
  }
}
