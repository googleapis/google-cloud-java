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
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.ChannelPrimer;
import com.google.auth.Credentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.InstanceName;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.bigtable.v2.PingAndWarmResponse;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
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

  static final Metadata.Key<String> REQUEST_PARAMS =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private final PingAndWarmRequest request;
  private final CallCredentials callCredentials;
  private final Map<String, String> headers;

  static BigtableChannelPrimer create(
      String projectId,
      String instanceId,
      String appProfileId,
      Credentials credentials,
      Map<String, String> headers) {
    return new BigtableChannelPrimer(projectId, instanceId, appProfileId, credentials, headers);
  }

  BigtableChannelPrimer(
      String projectId,
      String instanceId,
      String appProfileId,
      Credentials credentials,
      Map<String, String> headers) {
    if (credentials != null) {
      callCredentials = MoreCallCredentials.from(credentials);
    } else {
      callCredentials = null;
    }

    request =
        PingAndWarmRequest.newBuilder()
            .setName(InstanceName.format(projectId, instanceId))
            .setAppProfileId(appProfileId)
            .build();

    this.headers = headers;
  }

  @Override
  public void primeChannel(ManagedChannel managedChannel) {
    try {
      primeChannelUnsafe(managedChannel);
    } catch (IOException | RuntimeException e) {
      LOG.log(Level.WARNING, "Unexpected error while trying to prime a channel", e);
    }
  }

  private void primeChannelUnsafe(ManagedChannel managedChannel) throws IOException {
    sendPrimeRequests(managedChannel);
  }

  private void sendPrimeRequests(ManagedChannel managedChannel) {
    try {
      ClientCall<PingAndWarmRequest, PingAndWarmResponse> clientCall =
          managedChannel.newCall(
              BigtableGrpc.getPingAndWarmMethod(),
              CallOptions.DEFAULT
                  .withCallCredentials(callCredentials)
                  .withDeadline(Deadline.after(1, TimeUnit.MINUTES)));

      SettableApiFuture<PingAndWarmResponse> future = SettableApiFuture.create();
      clientCall.start(
          new ClientCall.Listener<PingAndWarmResponse>() {
            PingAndWarmResponse response;

            @Override
            public void onMessage(PingAndWarmResponse message) {
              response = message;
            }

            @Override
            public void onClose(Status status, Metadata trailers) {
              if (status.isOk()) {
                future.set(response);
              } else {
                future.setException(status.asException());
              }
            }
          },
          createMetadata(headers, request));
      clientCall.sendMessage(request);
      clientCall.halfClose();
      clientCall.request(Integer.MAX_VALUE);

      future.get(1, TimeUnit.MINUTES);
    } catch (Throwable e) {
      // TODO: Not sure if we should swallow the error here. We are pre-emptively swapping
      // channels if the new
      // channel is bad.
      LOG.log(Level.WARNING, "Failed to prime channel", e);
    }
  }

  private static Metadata createMetadata(Map<String, String> headers, PingAndWarmRequest request) {
    Metadata metadata = new Metadata();

    headers.forEach(
        (k, v) -> metadata.put(Metadata.Key.of(k, Metadata.ASCII_STRING_MARSHALLER), v));
    try {
      metadata.put(
          REQUEST_PARAMS,
          String.format(
              "name=%s&app_profile_id=%s",
              URLEncoder.encode(request.getName(), "UTF-8"),
              URLEncoder.encode(request.getAppProfileId(), "UTF-8")));
    } catch (UnsupportedEncodingException e) {
      LOG.log(Level.WARNING, "Failed to encode request params", e);
    }

    return metadata;
  }
}
