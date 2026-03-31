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

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tracks retry attempts for a client request using a ThreadLocal for telemetry data.
 *
 * <p>It implements {@link AutoCloseable} to ensure that the ThreadLocal is safely restored to its
 * previous state (or removed) when the try-with-resources block exits, preventing memory leaks and
 * state bleeding in thread-pooling environments.
 */
public class BigQueryRetryTracker implements AutoCloseable {

  private static final ThreadLocal<AtomicInteger> HOLDER = new ThreadLocal<>();
  private final AtomicInteger previous;

  public BigQueryRetryTracker() {
    this.previous = HOLDER.get();
    HOLDER.set(new AtomicInteger(0));
  }

  public static AtomicInteger get() {
    return HOLDER.get();
  }

  @Override
  public void close() {
    if (previous == null) {
      HOLDER.remove();
    } else {
      HOLDER.set(previous);
    }
  }
}
