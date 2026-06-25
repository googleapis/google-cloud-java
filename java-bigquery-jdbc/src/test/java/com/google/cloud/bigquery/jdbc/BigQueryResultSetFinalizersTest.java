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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Future;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryResultSetFinalizersTest {
  Future<?>[] jsonWorkers;

  @BeforeEach
  public void setUp() {
    Future<?> mockFuture = mock(Future.class);
    jsonWorkers = new Future<?>[] {mockFuture};
  }

  @Test
  public void testFinalizeResources() {
    Future<?> mockFuture = mock(Future.class);
    BigQueryResultSetFinalizers.ArrowResultSetFinalizer arrowResultSetFinalizer =
        new BigQueryResultSetFinalizers.ArrowResultSetFinalizer(null, null, mockFuture);
    arrowResultSetFinalizer.finalizeResources();
    verify(mockFuture).cancel(true);

    BigQueryResultSetFinalizers.JsonResultSetFinalizer jsonResultSetFinalizer =
        new BigQueryResultSetFinalizers.JsonResultSetFinalizer(null, null, jsonWorkers);
    jsonResultSetFinalizer.finalizeResources();
    verify(jsonWorkers[0]).cancel(true);
  }
}
