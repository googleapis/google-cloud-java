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

import com.google.api.core.BetaApi;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.Schema;

/**
 * <b>[Beta]</b> A query result container providing zero-copy access to Apache Arrow {@link
 * VectorSchemaRoot} batches.
 *
 * <p>Implementations manage direct off-heap native memory buffers. Callers must invoke {@link
 * #close()} (idiomatically via a {@code try-with-resources} block) to ensure native allocations and
 * underlying gRPC streaming channels are deterministically released.
 */
@BetaApi
public interface ArrowQueryResult extends AutoCloseable, Iterable<VectorSchemaRoot> {

  /** Returns the Apache Arrow schema of the result vectors. */
  Schema getArrowSchema();

  /**
   * Returns the job ID associated with the query execution, or {@code null} if no job was created
   * (e.g. when optional job creation was used).
   */
  JobId getJobId();

  /** Returns the query ID associated with the query execution, or {@code null} if unavailable. */
  String getQueryId();

  /**
   * Returns the reason a job was created when optional job creation was requested, or {@code null}
   * if no job was created or if the query ran via the fallback path.
   */
  JobCreationReason getJobCreationReason();

  /** Returns the total number of rows across all batches if known, or {@code -1} if unknown. */
  long getTotalRows();

  /**
   * Releases underlying direct off-heap memory allocations and closes any active stream channels.
   */
  @Override
  void close();
}
