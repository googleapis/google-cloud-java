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
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * This class is used to add polling threads required for polling the reference queues associated
 * with the two ResultSets
 */
@InternalApi
class BigQueryDaemonPollingTask extends Thread {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryDaemonPollingTask.class.getName());

  static ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs;
  static ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs;
  static List<BigQueryResultSetFinalizers.ArrowResultSetFinalizer> arrowRsFinalizers;
  static List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonRsFinalizers;

  private static BigQueryDaemonPollingTask arrowDaemon;
  private static BigQueryDaemonPollingTask jsonDaemon;

  private static final Object LOCK = new Object();

  private BigQueryDaemonPollingTask(
      List<BigQueryResultSetFinalizers.ArrowResultSetFinalizer> arrowRsFinalizers,
      ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs) {
    BigQueryDaemonPollingTask.referenceQueueArrowRs = referenceQueueArrowRs;
    BigQueryDaemonPollingTask.arrowRsFinalizers = arrowRsFinalizers;
    setDaemon(true);
  }

  private BigQueryDaemonPollingTask(
      ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs,
      List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonRsFinalizers) {
    BigQueryDaemonPollingTask.referenceQueueJsonRs = referenceQueueJsonRs;
    BigQueryDaemonPollingTask.jsonRsFinalizers = jsonRsFinalizers;
    setDaemon(true);
  }

  /**
   * ThreadSafe method which creates two instances of polling task, one each for each type of
   * ResultSet
   *
   * @param referenceQueueArrowRs ReferenceQueue for ArrowResultSet
   * @param referenceQueueJsonRs ReferenceQueue for JsonResultSet
   * @param arrowRsFinalizers Finalizer for ArrowResultSet
   * @param jsonRsFinalizers Finalizer for JsonResultSet
   * @return true if the tasks were created
   */
  public static boolean startGcDaemonTask(
      ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs,
      ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs,
      List<BigQueryResultSetFinalizers.ArrowResultSetFinalizer> arrowRsFinalizers,
      List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonRsFinalizers) {
    LOG.finest("++enter++");
    synchronized (LOCK) {
      // 2 Background threads will be required to monitor the respective queues
      if (arrowDaemon == null && jsonDaemon == null) {
        arrowDaemon = new BigQueryDaemonPollingTask(arrowRsFinalizers, referenceQueueArrowRs);
        arrowDaemon.start();

        jsonDaemon = new BigQueryDaemonPollingTask(referenceQueueJsonRs, jsonRsFinalizers);
        jsonDaemon.start();

        return true;
      }
    }
    // Task(s) are already initialised
    return false;
  }

  @Override
  public void run() {

    Reference<?> reference;
    try {
      LOG.finest("++enter++");
      // poll for Arrow ResultSets
      if (referenceQueueArrowRs != null) {

        while ((reference = referenceQueueArrowRs.remove()) != null) {
          LOG.fine("Clearing Arrow ResultSet reference " + referenceQueueArrowRs);
          ((BigQueryResultSetFinalizers.ArrowResultSetFinalizer) reference).finalizeResources();
          reference.clear();
        }
      }
      // poll for JSON ResultSets
      else if (referenceQueueJsonRs != null) {
        while ((reference = referenceQueueJsonRs.remove()) != null) {
          LOG.fine("Clearing Json ResultSet reference " + referenceQueueJsonRs);
          ((BigQueryResultSetFinalizers.JsonResultSetFinalizer) reference).finalizeResources();
          reference.clear();
        }
      } else {
        throw new BigQueryJdbcRuntimeException("Null Reference Queue");
      }
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
  }
}
