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
    Future<?> ownedFuture;

    public ArrowResultSetFinalizer(
        BigQueryArrowResultSet referent,
        ReferenceQueue<? super BigQueryArrowResultSet> q,
        Future<?> ownedFuture) {
      super(referent, q);
      this.ownedFuture = ownedFuture;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finestTrace("finalizeResources");
      if (ownedFuture != null) {
        ownedFuture.cancel(true);
      }
    }
  }

  @InternalApi
  static class JsonResultSetFinalizer extends PhantomReference<BigQueryJsonResultSet> {
    Future<?>[] ownedFutures;

    public JsonResultSetFinalizer(
        BigQueryJsonResultSet referent,
        ReferenceQueue<? super BigQueryJsonResultSet> q,
        Future<?>[] ownedFutures) {
      super(referent, q);
      this.ownedFutures = ownedFutures;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finestTrace("finalizeResources");
      if (ownedFutures != null) {
        for (Future<?> ownedFuture : ownedFutures) {
          if (ownedFuture != null) {
            ownedFuture.cancel(true);
          }
        }
      }
    }
  }
}
