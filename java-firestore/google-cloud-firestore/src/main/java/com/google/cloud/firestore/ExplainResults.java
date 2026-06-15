/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.firestore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** ExplainResults contains information about planning, execution, and results of a query. */
public final class ExplainResults<T> {
  @Nonnull private final ExplainMetrics metrics;
  @Nullable private final T snapshot;

  ExplainResults(@Nonnull ExplainMetrics metrics, @Nullable T snapshot) {
    this.metrics = metrics;
    this.snapshot = snapshot;
  }

  /** Returns the information about planning and execution (if any) of the query. */
  @Nonnull
  public ExplainMetrics getMetrics() {
    return metrics;
  }

  /**
   * Returns the snapshot that contains the results of executing the query, or null if the query was
   * not executed.
   */
  @Nullable
  public T getSnapshot() {
    return snapshot;
  }
}
