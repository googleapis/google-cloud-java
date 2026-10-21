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

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * Polls a {@link ReferenceQueue} of result-set phantom references and releases the resources they
 * own. One instance (thread) is started per result-set type.
 */
@InternalApi
class BigQueryDaemonPollingTask extends Thread {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryDaemonPollingTask.class.getName());

  // Per-thread state. Each daemon owns exactly one queue and the list that keeps its
  // references strongly reachable until they have been processed.
  private final ReferenceQueue<?> referenceQueue;
  private final List<? extends Reference<?>> finalizers;

  // Singleton guard: the two daemons are started at most once per JVM.
  private static BigQueryDaemonPollingTask arrowDaemon;
  private static BigQueryDaemonPollingTask jsonDaemon;
  private static final Object LOCK = new Object();

  @VisibleForTesting
  BigQueryDaemonPollingTask(
      String threadName,
      ReferenceQueue<?> referenceQueue,
      List<? extends Reference<?>> finalizers) {
    super(threadName);
    this.referenceQueue = referenceQueue;
    this.finalizers = finalizers;
    setDaemon(true);
  }

  /**
   * Thread-safe. Starts one polling thread per result-set type. Subsequent calls are no-ops, even
   * if different queues are passed.
   *
   * @return true if the daemons were started by this call
   */
  public static boolean startGcDaemonTask(
      ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs,
      ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs,
      List<BigQueryResultSetFinalizers.ArrowResultSetFinalizer> arrowRsFinalizers,
      List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonRsFinalizers) {
    LOG.finest("++enter++");
    synchronized (LOCK) {
      if (arrowDaemon == null && jsonDaemon == null) {
        arrowDaemon =
            new BigQueryDaemonPollingTask(
                "BigQuery-GC-Daemon-Arrow", referenceQueueArrowRs, arrowRsFinalizers);
        arrowDaemon.start();

        jsonDaemon =
            new BigQueryDaemonPollingTask(
                "BigQuery-GC-Daemon-Json", referenceQueueJsonRs, jsonRsFinalizers);
        jsonDaemon.start();
        return true;
      }
    }
    return false;
  }

  @Override
  public void run() {
    LOG.finest("++enter++");
    try {
      while (true) {
        Reference<?> reference =
            referenceQueue.remove(); // InterruptedException escapes to outer catch
        try {
          LOG.fine("Clearing ResultSet reference " + reference);
          if (reference instanceof ResultSetFinalizer) {
            ((ResultSetFinalizer) reference).finalizeResources();
          } else {
            LOG.warning("Unexpected reference type in GC queue: " + reference.getClass());
          }
        } catch (RuntimeException ex) {
          LOG.warning(ex, "Failed to finalize ResultSet resources; continuing");
        } finally {
          reference.clear();
          finalizers.remove(reference);
        }
      }
    } catch (InterruptedException ex) {
      LOG.warning(ex, "Interrupted in GC daemon task");
    }
  }
}
