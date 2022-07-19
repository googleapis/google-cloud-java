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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.ChannelPrimer;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.auth.Credentials;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.common.base.Preconditions;
import io.grpc.ManagedChannel;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

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

  private final EnhancedBigtableStubSettings settingsTemplate;

  static BigtableChannelPrimer create(
      Credentials credentials, String projectId, String instanceId, String appProfileId) {
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .setAppProfileId(appProfileId)
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .setExecutorProvider(
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build());

    return new BigtableChannelPrimer(builder.build());
  }

  private BigtableChannelPrimer(EnhancedBigtableStubSettings settingsTemplate) {
    Preconditions.checkNotNull(settingsTemplate, "settingsTemplate can't be null");
    this.settingsTemplate = settingsTemplate;
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
    sendPrimeRequests(managedChannel);
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
      PingAndWarmRequest request =
          PingAndWarmRequest.newBuilder()
              .setName(
                  NameUtil.formatInstanceName(
                      primingSettings.getProjectId(), primingSettings.getInstanceId()))
              .setAppProfileId(primingSettings.getAppProfileId())
              .build();

      try {
        stub.pingAndWarmCallable().call(request);
      } catch (Throwable e) {
        // TODO: Not sure if we should swallow the error here. We are pre-emptively swapping
        // channels if the new
        // channel is bad.
        if (e instanceof ExecutionException) {
          e = e.getCause();
        }
        LOG.warning(String.format("Failed to prime channel: %s", e));
      }
    }
  }
}
