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
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.Future;

@InternalApi
class BigQueryResultSetFinalizers {
  private static final BigQueryJdbcResultSetLogger LOG =
      BigQueryJdbcResultSetLogger.getLogger(BigQueryResultSetFinalizers.class);

  @InternalApi
  static class ArrowResultSetFinalizer extends PhantomReference<BigQueryArrowResultSet> {
    Future<?> ownedTask;

    public ArrowResultSetFinalizer(
        BigQueryArrowResultSet referent,
        ReferenceQueue<? super BigQueryArrowResultSet> q,
        Future<?> ownedTask) {
      super(referent, q);
      this.ownedTask = ownedTask;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finestTrace("finalizeResources");
      if (ownedTask != null && !ownedTask.isCancelled() && !ownedTask.isDone()) {
        ownedTask.cancel(true);
      }
    }
  }

  @InternalApi
  static class JsonResultSetFinalizer extends PhantomReference<BigQueryJsonResultSet> {
    Future<?>[] ownedTasks;

    public JsonResultSetFinalizer(
        BigQueryJsonResultSet referent,
        ReferenceQueue<? super BigQueryJsonResultSet> q,
        Future<?>[] ownedTasks) {
      super(referent, q);
      this.ownedTasks = ownedTasks;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finestTrace("finalizeResources");
      if (ownedTasks != null) {
        for (Future<?> ownedTask : ownedTasks) {
          if (ownedTask != null && !ownedTask.isCancelled() && !ownedTask.isDone()) {
            ownedTask.cancel(true);
          }
        }
      }
    }
  }
}
