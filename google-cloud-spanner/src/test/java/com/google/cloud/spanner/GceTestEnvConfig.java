/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkState;

import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/** Configure TestEnv based on configuration provided. */
public class GceTestEnvConfig implements TestEnvConfig {
  public static final String GCE_PROJECT_ID = "spanner.gce.config.project_id";
  public static final String GCE_SERVER_URL = "spanner.gce.config.server_url";
  public static final String GCE_STREAM_BROKEN_PROBABILITY =
      "spanner.gce.config.stream_broken_probability";

  private final SpannerOptions options;

  public GceTestEnvConfig() {
    String projectId = System.getProperty(GCE_PROJECT_ID, "");
    String serverUrl = System.getProperty(GCE_SERVER_URL, "");
    double errorProbability =
        Double.parseDouble(System.getProperty(GCE_STREAM_BROKEN_PROBABILITY, "0.0"));
    checkState(errorProbability <= 1.0);
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();
    if (!projectId.isEmpty()) {
      builder.setProjectId(projectId);
    }
    if (!serverUrl.isEmpty()) {
      builder.setHost(serverUrl);
    }
    options =
        builder
            .setRpcChannelFactory(
                new SpannerOptions.NettyRpcChannelFactory(
                    "",
                    ImmutableList.<ClientInterceptor>of(new GrpcErrorInjector(errorProbability))))
            .build();
  }

  @Override
  public SpannerOptions spannerOptions() {
    return options;
  }

  @Override
  public void setUp() {}

  @Override
  public void tearDown() {}

  /** Injects errors in streaming calls to simulate call restarts */
  private static class GrpcErrorInjector implements ClientInterceptor {
    private final double errorProbability;
    private final Random random = new Random();

    GrpcErrorInjector(double errorProbability) {
      this.errorProbability = errorProbability;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        final MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      // Only inject errors in the Cloud Spanner data API.
      if (!method.getFullMethodName().startsWith("google.spanner.v1.Spanner")) {
        return next.newCall(method, callOptions);
      }

      final AtomicBoolean errorInjected = new AtomicBoolean();
      final ClientCall<ReqT, RespT> clientCall = next.newCall(method, callOptions);

      return new SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new SimpleForwardingClientCallListener<RespT>(responseListener) {
                @Override
                public void onMessage(RespT message) {
                  super.onMessage(message);
                  if (mayInjectError()) {
                    // Cancel the call after at least one response has been received.
                    // This will cause the call to terminate, then we can set UNAVAILABLE
                    // in the onClose() handler to cause a retry.
                    errorInjected.set(true);
                    clientCall.cancel("Cancelling call for injected error", null);
                  }
                }

                @Override
                public void onClose(Status status, Metadata metadata) {
                  if (errorInjected.get()) {
                    // UNAVAILABLE error will cause the call to retry.
                    status = Status.UNAVAILABLE.augmentDescription("INJECTED BY TEST");
                  }
                  super.onClose(status, metadata);
                }
              },
              headers);
        }
      };
    }

    private boolean mayInjectError() {
      return random.nextDouble() < errorProbability;
    }
  }
}
