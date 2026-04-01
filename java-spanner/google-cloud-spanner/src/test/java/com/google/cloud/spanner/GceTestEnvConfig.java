/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.setExperimentalHostSpannerOptions;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.spi.v1.SpannerInterceptorProvider;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/** Configure TestEnv based on configuration provided. */
public class GceTestEnvConfig implements TestEnvConfig {
  public static final String GCE_PROJECT_ID = "spanner.gce.config.project_id";
  public static final String GCE_SERVER_URL = "spanner.gce.config.server_url";
  public static final String GCE_CREDENTIALS_FILE = "spanner.gce.config.credentials_file";
  public static final String GCE_STREAM_BROKEN_PROBABILITY =
      "spanner.gce.config.stream_broken_probability";
  public static final String ENABLE_DIRECT_ACCESS = "spanner.enable_direct_access";
  public static final String DIRECT_PATH_TEST_SCENARIO = "spanner.directpath_test_scenario";

  // IP address prefixes allocated for DirectPath backends.
  public static final String DP_IPV6_PREFIX = "2001:4860:8040";
  public static final String DP_IPV4_PREFIX = "34.126";

  private static final String DIRECT_PATH_ENDPOINT = "wrenchworks-nonprod.googleapis.com:443";

  private final SpannerOptions options;

  public GceTestEnvConfig() {
    String projectId = System.getProperty(GCE_PROJECT_ID, "");
    String serverUrl = System.getProperty(GCE_SERVER_URL, "");
    String credentialsFile = System.getProperty(GCE_CREDENTIALS_FILE, "");
    double errorProbability =
        Double.parseDouble(System.getProperty(GCE_STREAM_BROKEN_PROBABILITY, "0.0"));
    checkState(errorProbability <= 1.0);
    boolean enableDirectAccess = Boolean.getBoolean(ENABLE_DIRECT_ACCESS);
    String directPathTestScenario = System.getProperty(DIRECT_PATH_TEST_SCENARIO, "");
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setAutoThrottleAdministrativeRequests()
            .setTrackTransactionStarter();
    if (!projectId.isEmpty()) {
      builder.setProjectId(projectId);
    }
    if (!serverUrl.isEmpty()) {
      builder.setHost(serverUrl);
    }
    if (!credentialsFile.isEmpty()) {
      try {
        builder.setCredentials(
            ServiceAccountCredentials.fromStream(new FileInputStream(credentialsFile)));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    SpannerInterceptorProvider interceptorProvider =
        SpannerInterceptorProvider.createDefault().with(new GrpcErrorInjector(errorProbability));
    if (enableDirectAccess) {
      interceptorProvider =
          interceptorProvider.with(new DirectPathAddressCheckInterceptor(directPathTestScenario));
    }
    builder.setInterceptorProvider(interceptorProvider);
    // DirectPath tests need to set a custom endpoint to the ChannelProvider
    InstantiatingGrpcChannelProvider.Builder customChannelProviderBuilder =
        InstantiatingGrpcChannelProvider.newBuilder();
    if (enableDirectAccess) {
      customChannelProviderBuilder
          .setEndpoint(DIRECT_PATH_ENDPOINT)
          .setAttemptDirectPath(true)
          .setAttemptDirectPathXds()
          .setInterceptorProvider(interceptorProvider);
      builder.setChannelProvider(customChannelProviderBuilder.build());
    }

    if (isExperimentalHost()) {
      setExperimentalHostSpannerOptions(builder);
    }
    options = builder.build();
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

  /**
   * Captures the request attributes "Grpc.TRANSPORT_ATTR_REMOTE_ADDR" when connection is
   * established and verifies if the remote address is a DirectPath address. This is only used for
   * DirectPath testing. {@link ClientCall#getAttributes()}
   */
  private static class DirectPathAddressCheckInterceptor implements ClientInterceptor {
    private final String directPathTestScenario;

    DirectPathAddressCheckInterceptor(String directPathTestScenario) {
      this.directPathTestScenario = directPathTestScenario;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      final ClientCall<ReqT, RespT> clientCall = next.newCall(method, callOptions);
      return new SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new SimpleForwardingClientCallListener<RespT>(responseListener) {
                @Override
                public void onHeaders(Metadata headers) {
                  // Check peer IP after connection is established.
                  SocketAddress remoteAddr =
                      clientCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
                  if (!verifyRemoteAddress(remoteAddr)) {
                    throw new RuntimeException(
                        String.format(
                            "Synthetically aborting the current request because it did not adhere"
                                + " to the test environment's requirement for DirectPath."
                                + " Expected test for DirectPath %s scenario,"
                                + " but RPC was destined for %s",
                            directPathTestScenario, remoteAddr.toString()));
                  }
                  super.onHeaders(headers);
                }
              },
              headers);
        }
      };
    }

    private boolean verifyRemoteAddress(SocketAddress remoteAddr) {
      if (remoteAddr instanceof InetSocketAddress) {
        InetAddress inetAddress = ((InetSocketAddress) remoteAddr).getAddress();
        String addr = inetAddress.getHostAddress();
        if (directPathTestScenario.equals("ipv4")) {
          // For ipv4-only VM, client should connect to ipv4 DirectPath addresses.
          return addr.startsWith(DP_IPV4_PREFIX);
        } else if (directPathTestScenario.equals("ipv6")) {
          // For ipv6-enabled VM, client could connect to either ipv4 or ipv6 DirectPath addresses.
          return addr.startsWith(DP_IPV6_PREFIX) || addr.startsWith(DP_IPV4_PREFIX);
        }
      }
      // For all other scenarios(e.g. fallback), we should allow both DirectPath and CFE addresses.
      return true;
    }
  }
}
