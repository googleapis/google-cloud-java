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

package com.google.cloud.datastore.telemetry;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CompositeDatastoreMetricsRecorderTest {

  @Test
  public void testCloseLIFOAndExceptionSafe() {
    List<Integer> closeOrder = new ArrayList<>();
    DatastoreMetricsRecorder recorder1 = new MockRecorder(1, closeOrder, false);
    DatastoreMetricsRecorder recorder2 = new MockRecorder(2, closeOrder, true); // will throw
    DatastoreMetricsRecorder recorder3 = new MockRecorder(3, closeOrder, false);

    CompositeDatastoreMetricsRecorder composite =
        new CompositeDatastoreMetricsRecorder(Arrays.asList(recorder1, recorder2, recorder3));

    composite.close();

    // LIFO order means 3, then 2, then 1.
    // Even though 2 throws, 1 should still be closed.
    assertThat(closeOrder).containsExactly(3, 2, 1).inOrder();
  }

  private static class MockRecorder implements DatastoreMetricsRecorder {
    private final int id;
    private final List<Integer> closeOrder;
    private final boolean throwOnClose;

    MockRecorder(int id, List<Integer> closeOrder, boolean throwOnClose) {
      this.id = id;
      this.closeOrder = closeOrder;
      this.throwOnClose = throwOnClose;
    }

    @Override
    public void close() {
      closeOrder.add(id);
      if (throwOnClose) {
        throw new RuntimeException("Mock exception on close");
      }
    }

    @Override
    public void recordTransactionLatency(
        double latencyMs, java.util.Map<String, String> attributes) {}

    @Override
    public void recordTransactionAttemptCount(
        long count, java.util.Map<String, String> attributes) {}

    @Override
    public void recordAttemptLatency(double latencyMs, java.util.Map<String, String> attributes) {}

    @Override
    public void recordAttemptCount(long count, java.util.Map<String, String> attributes) {}

    @Override
    public void recordOperationLatency(
        double latencyMs, java.util.Map<String, String> attributes) {}

    @Override
    public void recordOperationCount(long count, java.util.Map<String, String> attributes) {}
  }
}
