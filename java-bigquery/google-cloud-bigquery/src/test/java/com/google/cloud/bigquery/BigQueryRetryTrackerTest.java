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
package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class BigQueryRetryTrackerTest {

  @Test
  public void testCreateAndClose() {
    assertNull(BigQueryRetryTracker.get(), "Tracker should be null before create");

    try (BigQueryRetryTracker tracker = new BigQueryRetryTracker()) {
      AtomicInteger counter = BigQueryRetryTracker.get();
      assertNotNull(counter);
      assertEquals(0, counter.get());
    }

    assertNull(BigQueryRetryTracker.get(), "Tracker should be cleaned up after close");
  }

  @Test
  public void testThreadIsolation() throws ExecutionException, InterruptedException {
    CompletableFuture<Void> future1 =
        CompletableFuture.runAsync(
            () -> {
              try (BigQueryRetryTracker tracker = new BigQueryRetryTracker()) {
                BigQueryRetryTracker.get().set(10);
                try {
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
                assertEquals(10, BigQueryRetryTracker.get().get());
              }
            });

    CompletableFuture<Void> future2 =
        CompletableFuture.runAsync(
            () -> {
              try (BigQueryRetryTracker tracker = new BigQueryRetryTracker()) {
                BigQueryRetryTracker.get().set(20);
                assertEquals(20, BigQueryRetryTracker.get().get());
              }
            });

    future1.get();
    future2.get();
  }
}
