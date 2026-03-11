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

import org.junit.Before;
import org.junit.Test;

public class BigQueryResultSetFinalizersTest {
  Thread arrowWorker;
  Thread[] jsonWorkers;

  @Before
  public void setUp() {
    // create and start the demon threads
    arrowWorker =
        new Thread(
            () -> {
              while (true) {
                if (Thread.currentThread().isInterrupted()) {
                  break;
                }
              }
            });
    arrowWorker.setDaemon(true);
    Thread jsonWorker =
        new Thread(
            () -> {
              while (true) {
                if (Thread.currentThread().isInterrupted()) {
                  break;
                }
              }
            });
    jsonWorker.setDaemon(true);
    jsonWorkers = new Thread[] {jsonWorker};
    arrowWorker.start();
    jsonWorker.start();
  }

  @Test
  public void testFinalizeResources() {
    BigQueryResultSetFinalizers.ArrowResultSetFinalizer arrowResultSetFinalizer =
        new BigQueryResultSetFinalizers.ArrowResultSetFinalizer(null, null, arrowWorker);
    arrowResultSetFinalizer.finalizeResources();
    assertThat(arrowWorker.isInterrupted()).isTrue();
    BigQueryResultSetFinalizers.JsonResultSetFinalizer jsonResultSetFinalizer =
        new BigQueryResultSetFinalizers.JsonResultSetFinalizer(null, null, jsonWorkers);
    jsonResultSetFinalizer.finalizeResources();
    assertThat(jsonWorkers[0].isInterrupted()).isTrue();
  }
}
