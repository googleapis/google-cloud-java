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

@InternalApi
class BigQueryResultSetFinalizers {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryResultSetFinalizers.class.getName());

  @InternalApi
  static class ArrowResultSetFinalizer extends PhantomReference<BigQueryArrowResultSet> {
    Thread ownedThread;

    public ArrowResultSetFinalizer(
        BigQueryArrowResultSet referent,
        ReferenceQueue<? super BigQueryArrowResultSet> q,
        Thread ownedThread) {
      super(referent, q);
      this.ownedThread = ownedThread;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finest("++enter++");
      if (ownedThread != null && !ownedThread.isInterrupted()) {
        ownedThread.interrupt();
      }
    }
  }

  @InternalApi
  static class JsonResultSetFinalizer extends PhantomReference<BigQueryJsonResultSet> {
    Thread[] ownedThreads;

    public JsonResultSetFinalizer(
        BigQueryJsonResultSet referent,
        ReferenceQueue<? super BigQueryJsonResultSet> q,
        Thread[] ownedThreads) {
      super(referent, q);
      this.ownedThreads = ownedThreads;
    }

    // Free resources. Remove all the hard refs
    public void finalizeResources() {
      LOG.finest("++enter++");
      if (ownedThreads != null) {
        for (Thread ownedThread : ownedThreads) {
          if (!ownedThread.isInterrupted()) {
            ownedThread.interrupt();
          }
        }
      }
    }
  }
}
