/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import com.google.cloud.bigquery.jdbc.BigQueryResultSetFinalizers.ArrowResultSetFinalizer;
import com.google.cloud.bigquery.jdbc.BigQueryResultSetFinalizers.JsonResultSetFinalizer;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryDaemonPollingTaskTest {

  static ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs;
  static ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs;
  static List<ArrowResultSetFinalizer> arrowResultSetFinalizers;
  static List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonResultSetFinalizers;

  @BeforeEach
  public void setUp() {
    referenceQueueArrowRs = new ReferenceQueue<>();
    referenceQueueJsonRs = new ReferenceQueue<>();
    arrowResultSetFinalizers = Collections.synchronizedList(new ArrayList<>());
    jsonResultSetFinalizers = Collections.synchronizedList(new ArrayList<>());
  }

  @Test
  public void testStartGcDaemonTask() {

    // start the Daemon first and then make sure it doesn't get started again
    BigQueryDaemonPollingTask.startGcDaemonTask(
        referenceQueueArrowRs,
        referenceQueueJsonRs,
        arrowResultSetFinalizers,
        jsonResultSetFinalizers); // Daemon thread might have already started by the Junit at
    // BigQueryStatementTest, hence we ignore the response here and
    // check it on the line below

    assertThat(
            BigQueryDaemonPollingTask.startGcDaemonTask(
                referenceQueueArrowRs,
                referenceQueueJsonRs,
                arrowResultSetFinalizers,
                jsonResultSetFinalizers))
        .isFalse();
  }

  @Test
  public void testJsonDaemonFinalizesAndReleasesReference() throws Exception {
    Future<?> worker1 = mock(Future.class);
    Future<?> worker2 = mock(Future.class);
    JsonResultSetFinalizer finalizer =
        new JsonResultSetFinalizer(null, referenceQueueJsonRs, new Future<?>[] {worker1, worker2});
    jsonResultSetFinalizers.add(finalizer);
    BigQueryDaemonPollingTask daemon =
        new BigQueryDaemonPollingTask(
            "test-json-daemon", referenceQueueJsonRs, jsonResultSetFinalizers);
    daemon.start();
    try {
      finalizer.enqueue(); // simulate the GC enqueuing the phantom reference
      verify(worker1, timeout(5000)).cancel(true);
      verify(worker2, timeout(5000)).cancel(true);
      awaitEmpty(jsonResultSetFinalizers);
    } finally {
      daemon.interrupt();
    }
  }

  @Test
  public void testArrowDaemonFinalizesAndReleasesReference() throws Exception {
    Future<?> worker = mock(Future.class);
    ArrowResultSetFinalizer finalizer =
        new ArrowResultSetFinalizer(null, referenceQueueArrowRs, worker);
    arrowResultSetFinalizers.add(finalizer);
    BigQueryDaemonPollingTask daemon =
        new BigQueryDaemonPollingTask(
            "test-arrow-daemon", referenceQueueArrowRs, arrowResultSetFinalizers);
    daemon.start();
    try {
      finalizer.enqueue();
      verify(worker, timeout(5000)).cancel(true);
      awaitEmpty(arrowResultSetFinalizers);
    } finally {
      daemon.interrupt();
    }
  }

  @Test
  public void testEachDaemonPollsOnlyItsOwnQueue() throws Exception {
    Future<?> jsonWorker = mock(Future.class);
    Future<?> arrowWorker = mock(Future.class);
    JsonResultSetFinalizer jsonFinalizer =
        new JsonResultSetFinalizer(null, referenceQueueJsonRs, new Future<?>[] {jsonWorker});
    ArrowResultSetFinalizer arrowFinalizer =
        new ArrowResultSetFinalizer(null, referenceQueueArrowRs, arrowWorker);
    jsonResultSetFinalizers.add(jsonFinalizer);
    arrowResultSetFinalizers.add(arrowFinalizer);
    BigQueryDaemonPollingTask jsonDaemon =
        new BigQueryDaemonPollingTask("test-json", referenceQueueJsonRs, jsonResultSetFinalizers);
    BigQueryDaemonPollingTask arrowDaemon =
        new BigQueryDaemonPollingTask(
            "test-arrow", referenceQueueArrowRs, arrowResultSetFinalizers);
    jsonDaemon.start();
    arrowDaemon.start();
    try {
      jsonFinalizer.enqueue();
      arrowFinalizer.enqueue();
      verify(jsonWorker, timeout(5000)).cancel(true);
      verify(arrowWorker, timeout(5000)).cancel(true);
      awaitEmpty(jsonResultSetFinalizers);
      awaitEmpty(arrowResultSetFinalizers);
    } finally {
      jsonDaemon.interrupt();
      arrowDaemon.interrupt();
    }
  }

  /** Small poll loop; the list is drained by the daemon thread shortly after cancel() runs. */
  private static void awaitEmpty(List<?> list) throws InterruptedException {
    long deadline = System.currentTimeMillis() + 5000;
    while (!list.isEmpty() && System.currentTimeMillis() < deadline) {
      Thread.sleep(20);
    }
    assertThat(list).isEmpty();
  }
}
