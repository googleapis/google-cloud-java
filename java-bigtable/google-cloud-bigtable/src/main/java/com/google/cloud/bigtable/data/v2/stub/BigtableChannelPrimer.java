/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.ChannelPrimer;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.auth.Credentials;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * A channel warmer that ensures that a Bigtable channel is ready to be used before being added to
 * the active {@link com.google.api.gax.grpc.ChannelPool}.
 *
 * <p>This implementation is subject to change in the future, but currently it will prime the
 * channel by sending a ReadRow request for a hardcoded, non-existent row key.
 */
@BetaApi("Channel priming is not currently stable and might change in the future")
class BigtableChannelPrimer implements ChannelPrimer {
  private static Logger LOG = Logger.getLogger(BigtableChannelPrimer.class.toString());

  static ByteString PRIMING_ROW_KEY = ByteString.copyFromUtf8("nonexistent-priming-row");
  private static Duration PRIME_REQUEST_TIMEOUT = Duration.ofSeconds(30);

  private final EnhancedBigtableStubSettings settingsTemplate;
  private final List<String> tableIds;

  static BigtableChannelPrimer create(
      Credentials credentials,
      String projectId,
      String instanceId,
      String appProfileId,
      List<String> tableIds) {
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .setAppProfileId(appProfileId)
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .setExecutorProvider(
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build());

    // Disable retries for priming request
    builder
        .readRowSettings()
        .setRetrySettings(
            builder
                .readRowSettings()
                .getRetrySettings()
                .toBuilder()
                .setMaxAttempts(1)
                .setJittered(false)
                .setInitialRpcTimeout(PRIME_REQUEST_TIMEOUT)
                .setMaxRpcTimeout(PRIME_REQUEST_TIMEOUT)
                .setTotalTimeout(PRIME_REQUEST_TIMEOUT)
                .build());
    return new BigtableChannelPrimer(builder.build(), tableIds);
  }

  private BigtableChannelPrimer(
      EnhancedBigtableStubSettings settingsTemplate, List<String> tableIds) {
    Preconditions.checkNotNull(settingsTemplate, "settingsTemplate can't be null");
    this.settingsTemplate = settingsTemplate;
    this.tableIds = ImmutableList.copyOf(tableIds);
  }

  @Override
  public void primeChannel(ManagedChannel managedChannel) {
    try {
      primeChannelUnsafe(managedChannel);
    } catch (IOException | RuntimeException e) {
      LOG.warning(
          String.format("Unexpected error while trying to prime a channel: %s", e.getMessage()));
    }
  }

  private void primeChannelUnsafe(ManagedChannel managedChannel) throws IOException {
    if (tableIds.isEmpty()) {
      waitForChannelReady(managedChannel);
    } else {
      sendPrimeRequests(managedChannel);
    }
  }

  private void waitForChannelReady(ManagedChannel managedChannel) {
    for (int i = 0; i < 30; i++) {
      ConnectivityState connectivityState = managedChannel.getState(true);
      if (connectivityState == ConnectivityState.READY) {
        break;
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        break;
      }
    }
  }

  private void sendPrimeRequests(ManagedChannel managedChannel) throws IOException {
    // Wrap the channel in a temporary stub
    EnhancedBigtableStubSettings primingSettings =
        settingsTemplate
            .toBuilder()
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(GrpcTransportChannel.create(managedChannel)))
            .build();

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(primingSettings)) {
      Map<String, ApiFuture<?>> primeFutures = new HashMap<>();

      // Prime all of the table ids in parallel
      for (String tableId : tableIds) {
        ApiFuture<Row> f =
            stub.readRowCallable()
                .futureCall(Query.create(tableId).rowKey(PRIMING_ROW_KEY).filter(FILTERS.block()));

        primeFutures.put(tableId, f);
      }

      // Wait for all of the prime requests to complete.
      for (Map.Entry<String, ApiFuture<?>> entry : primeFutures.entrySet()) {
        try {
          entry.getValue().get();
        } catch (Throwable e) {
          if (e instanceof ExecutionException) {
            e = e.getCause();
          }
          LOG.warning(
              String.format(
                  "Failed to prime channel for table: %s: %s", entry.getKey(), e.getMessage()));
        }
      }
    }
  }
}
