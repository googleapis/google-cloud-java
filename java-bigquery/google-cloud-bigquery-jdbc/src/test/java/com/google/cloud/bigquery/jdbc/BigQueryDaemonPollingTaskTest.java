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

import com.google.cloud.bigquery.jdbc.BigQueryResultSetFinalizers.ArrowResultSetFinalizer;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BigQueryDaemonPollingTaskTest {

  static ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs;
  static ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs;
  static List<ArrowResultSetFinalizer> arrowResultSetFinalizers;
  static List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonResultSetFinalizers;

  @Before
  public void setUp() {
    referenceQueueArrowRs = new ReferenceQueue<>();
    referenceQueueJsonRs = new ReferenceQueue<>();
    arrowResultSetFinalizers = new ArrayList<>();
    jsonResultSetFinalizers = new ArrayList<>();
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
}
