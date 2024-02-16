/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.stats.StatsRecorderWrapperForConnection;
import com.google.cloud.bigtable.stats.StatsWrapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import io.grpc.ClientInterceptor;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Background task that goes through all connections and updates the errors_per_connection metric. */
@InternalApi("For internal use only")
public class ErrorCountPerConnectionMetricTracker implements Runnable {
  private static final Integer PER_CONNECTION_ERROR_COUNT_PERIOD_SECONDS = 60;
  private final Set<ConnectionErrorCountInterceptor> connectionErrorCountInterceptors;
  private final Object interceptorsLock = new Object();
  // This is not final so that it can be updated and mocked during testing.
  private StatsRecorderWrapperForConnection statsRecorderWrapperForConnection;

  @VisibleForTesting
  void setStatsRecorderWrapperForConnection(
      StatsRecorderWrapperForConnection statsRecorderWrapperForConnection) {
    this.statsRecorderWrapperForConnection = statsRecorderWrapperForConnection;
  }

  public ErrorCountPerConnectionMetricTracker(ImmutableMap<String, String> builtinAttributes) {
    connectionErrorCountInterceptors =
        Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));

    this.statsRecorderWrapperForConnection =
        StatsWrapper.createRecorderForConnection(builtinAttributes);
  }

  public void startConnectionErrorCountTracker(ScheduledExecutorService scheduler) {
    scheduler.scheduleAtFixedRate(
        this, 0, PER_CONNECTION_ERROR_COUNT_PERIOD_SECONDS, TimeUnit.SECONDS);
  }

  public ClientInterceptor getInterceptor() {
    ConnectionErrorCountInterceptor connectionErrorCountInterceptor =
        new ConnectionErrorCountInterceptor();
    synchronized (interceptorsLock) {
      connectionErrorCountInterceptors.add(connectionErrorCountInterceptor);
    }
    return connectionErrorCountInterceptor;
  }

  @Override
  public void run() {
    synchronized (interceptorsLock) {
      for (ConnectionErrorCountInterceptor interceptor : connectionErrorCountInterceptors) {
        long errors = interceptor.getAndResetNumOfErrors();
        long successes = interceptor.getAndResetNumOfSuccesses();
        // We avoid keeping track of inactive connections (i.e., without any failed or successful
        // requests).
        if (errors > 0 || successes > 0) {
          // TODO: add a metric to also keep track of the number of successful requests per each
          // connection.
          statsRecorderWrapperForConnection.putAndRecordPerConnectionErrorCount(errors);
        }
      }
    }
  }
}
