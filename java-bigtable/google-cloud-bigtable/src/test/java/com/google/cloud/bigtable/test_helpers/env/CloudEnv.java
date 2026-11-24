/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.test_helpers.env;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StubSettings;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataClientTestHelpers;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.compat.Shim;
import com.google.cloud.bigtable.data.v2.internal.compat.ShimImpl;
import com.google.cloud.bigtable.data.v2.internal.util.SessionScope;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.stub.BigtableClientContext;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Test environment that uses an existing bigtable table. The table must have a pre-existing family
 * {@code cf}. The target table is configured via the system properties:
 *
 * <ul>
 *   <li>{@code bigtable.project}
 *   <li>{@code bigtable.instance}
 *   <li>{@code bigtable.table}
 * </ul>
 */
public class CloudEnv extends AbstractTestEnv {
  private static final Predicate<InetSocketAddress> DIRECT_PATH_IPV6_MATCHER =
      new Predicate<InetSocketAddress>() {
        @Override
        public boolean apply(InetSocketAddress input) {
          return input.toString().startsWith("2001:4860:8040");
        }
      };
  private static final Predicate<InetSocketAddress> DIRECT_PATH_IPV4_MATCHER =
      new Predicate<InetSocketAddress>() {
        @Override
        public boolean apply(InetSocketAddress input) {
          return input.toString().startsWith("34.126");
        }
      };

  private static final Set<String> SESSION_DIVERTED_CLASSIC_METHODS =
      ImmutableSet.of(
          BigtableGrpc.getMutateRowMethod().getFullMethodName(),
          BigtableGrpc.getCheckAndMutateRowMethod().getFullMethodName(),
          BigtableGrpc.getReadModifyWriteRowMethod().getFullMethodName());

  private static final String DATA_ENDPOINT_PROPERTY_NAME = "bigtable.data-endpoint";
  private static final String ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.admin-endpoint";
  private static final String DATA_JWT_OVERRIDE_PROPERTY_NAME = "bigtable.data-jwt-audience";

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String APP_PROFILE_PROPERTY_NAME = "bigtable.app_profile";
  private static final String TABLE_PROPERTY_NAME = "bigtable.table";
  private static final String CMEK_KMS_KEY_PROPERTY_NAME = "bigtable.kms_key_name";

  private static final String TRACING_COOKIE_PROPERTY_NAME = "bigtable.tracing_cookie";

  private final String projectId;
  private final String instanceId;
  private final TableId tableId;
  private final String kmsKeyName;

  private final BigtableDataSettings.Builder dataSettings;
  private final BigtableTableAdminSettings.Builder tableAdminSettings;
  private final BigtableInstanceAdminSettings.Builder instanceAdminSettings;
  @Nullable private final String appProfileId;

  private BigtableDataClient dataClient;
  @Nullable private Shim sessionShim;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableInstanceAdminClient instanceAdminClient;

  static CloudEnv fromSystemProperties() {
    return new CloudEnv(
        getOptionalProperty(DATA_ENDPOINT_PROPERTY_NAME, ""),
        getOptionalProperty(ADMIN_ENDPOINT_PROPERTY_NAME, ""),
        getOptionalProperty(DATA_JWT_OVERRIDE_PROPERTY_NAME, ""),
        getOptionalProperty(CMEK_KMS_KEY_PROPERTY_NAME, ""),
        getRequiredProperty(PROJECT_PROPERTY_NAME),
        getRequiredProperty(INSTANCE_PROPERTY_NAME),
        getOptionalProperty(APP_PROFILE_PROPERTY_NAME),
        TableId.of(getRequiredProperty(TABLE_PROPERTY_NAME)),
        getOptionalProperty(TRACING_COOKIE_PROPERTY_NAME));
  }

  private CloudEnv(
      @Nullable String dataEndpoint,
      @Nullable String adminEndpoint,
      @Nullable String jwtAudienceOverride,
      @Nullable String kmsKeyName,
      String projectId,
      String instanceId,
      @Nullable String appProfileId,
      TableId tableId,
      @Nullable String tracingCookie) {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.appProfileId = appProfileId;
    this.tableId = tableId;
    this.kmsKeyName = kmsKeyName;

    this.dataSettings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (!Strings.isNullOrEmpty(dataEndpoint)) {
      dataSettings.stubSettings().setEndpoint(dataEndpoint);
    }
    if (!Strings.isNullOrEmpty(appProfileId)) {
      dataSettings.setAppProfileId(appProfileId);
    }
    if (!Strings.isNullOrEmpty(jwtAudienceOverride)) {
      dataSettings.stubSettings().setJwtAudience(jwtAudienceOverride);
    }

    configureConnection(dataSettings.stubSettings());
    configureUserAgent(dataSettings.stubSettings());

    if (tracingCookie != null) {
      injectTracingCookie(tracingCookie, dataSettings.stubSettings());
    }

    this.tableAdminSettings =
        BigtableTableAdminSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      this.tableAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }

    this.instanceAdminSettings = BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      this.instanceAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }
  }

  private static void injectTracingCookie(
      String tracingCookie, EnhancedBigtableStubSettings.Builder settings) {
    HeaderProvider oldHeaderProvider = settings.getHeaderProvider();
    settings.setHeaderProvider(
        () ->
            Optional.ofNullable(oldHeaderProvider)
                .map(p -> ImmutableMap.<String, String>builder().putAll(p.getHeaders()))
                .orElse(ImmutableMap.builder())
                .put("cookie", tracingCookie)
                .build());
  }

  private void configureConnection(StubSettings.Builder<?, ?> stubSettings) {
    final List<ClientInterceptor> interceptors = new ArrayList<>();

    switch (getConnectionMode()) {
      case DEFAULT:
        break;
      case REQUIRE_DIRECT_PATH:
        interceptors.add(
            buildRemoteAddrInterceptor(
                "DirectPath IPv4 or IPv6",
                Predicates.or(DIRECT_PATH_IPV4_MATCHER, DIRECT_PATH_IPV6_MATCHER),
                /* skipGetClientConfiguration= */ true));
        break;
      case REQUIRE_DIRECT_PATH_IPV4:
        interceptors.add(
            buildRemoteAddrInterceptor(
                "DirectPath IPv4",
                Predicates.or(DIRECT_PATH_IPV4_MATCHER),
                /* skipGetClientConfiguration= */ true));
        break;
      case REQUIRE_CFE:
        interceptors.add(
            buildRemoteAddrInterceptor(
                "a CFE ip",
                Predicates.not(Predicates.or(DIRECT_PATH_IPV4_MATCHER, DIRECT_PATH_IPV6_MATCHER)),
                /* skipGetClientConfiguration= */ false));
        break;
      default:
        throw new IllegalStateException("Unexpected ConnectionMode: " + getConnectionMode());
    }

    ExpectedProtocol expectedProtocol = getExpectedProtocol();
    if (expectedProtocol != ExpectedProtocol.ANY) {
      interceptors.add(buildProtocolEnforcementInterceptor(expectedProtocol));
    }

    if (appProfileId != null) {
      interceptors.add(new AppProfileInterceptor());
    }

    if (interceptors.isEmpty()) {
      return;
    }

    // Inject the interceptors into the channel provider, taking care to preserve existing channel
    // configurator
    InstantiatingGrpcChannelProvider.Builder channelProvider =
        ((InstantiatingGrpcChannelProvider) stubSettings.getTransportChannelProvider()).toBuilder();

    @SuppressWarnings("rawtypes")
    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        channelProvider.getChannelConfigurator();

    @SuppressWarnings("rawtypes")
    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> newConfigurator =
        new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
          @Override
          @SuppressWarnings("rawtypes")
          public ManagedChannelBuilder apply(ManagedChannelBuilder builder) {
            if (oldConfigurator != null) {
              builder = oldConfigurator.apply(builder);
            }
            for (ClientInterceptor interceptor : interceptors) {
              builder = builder.intercept(interceptor);
            }
            return builder;
          }
        };
    channelProvider.setChannelConfigurator(newConfigurator);
    stubSettings.setTransportChannelProvider(channelProvider.build());
  }

  static ClientInterceptor buildRemoteAddrInterceptor(
      final String msg,
      final Predicate<InetSocketAddress> predicate,
      final boolean skipGetClientConfiguration) {
    return new ClientInterceptor() {
      @Override
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
          MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        if (skipGetClientConfiguration
            && BigtableGrpc.getGetClientConfigurationMethod()
                .getFullMethodName()
                .equals(method.getFullMethodName())) {
          // Regardless of data transport, GetClientConfiguration always goes over CloudPath
          // (ClientConfigurationManager polls over a CFE channel even when data traffic uses
          // DirectPath), so skip the DirectPath IP check for it. Under REQUIRE_CFE we keep
          // checking it so ShimImpl's DirectAccess probe over DirectPath is rejected and forces
          // CFE.
          return next.newCall(method, callOptions);
        }
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

                    if (!predicate.apply((InetSocketAddress) remoteAddr)) {
                      throw new RuntimeException(
                          String.format(
                              "Synthetically aborting the current request because it did not adhere"
                                  + " to the test environment's requirement ."
                                  + " Expected %s, but ip was: %s",
                              msg, remoteAddr));
                    }
                    super.onHeaders(headers);
                  }
                },
                headers);
          }
        };
      }
    };
  }

  static ClientInterceptor buildProtocolEnforcementInterceptor(
      final ExpectedProtocol expectedProtocol) {
    return new ClientInterceptor() {
      @Override
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
          MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        if (expectedProtocol == ExpectedProtocol.CLASSIC) {
          if (isSessionOpenMethod(method)) {
            return new FailingClientCall<>(
                Status.FAILED_PRECONDITION.withDescription(
                    "Expected protocol CLASSIC (-Dbigtable.expected-protocol=CLASSIC), "
                        + "but attempted session RPC: "
                        + method.getFullMethodName()));
          }
          return next.newCall(method, callOptions);
        }

        if (expectedProtocol == ExpectedProtocol.SESSION) {
          String fullMethodName = method.getFullMethodName();
          if (SESSION_DIVERTED_CLASSIC_METHODS.contains(fullMethodName)) {
            return new FailingClientCall<>(
                Status.FAILED_PRECONDITION.withDescription(
                    "Expected protocol SESSION (-Dbigtable.expected-protocol=SESSION), "
                        + "but attempted classic RPC: "
                        + fullMethodName));
          }
          if (BigtableGrpc.getReadRowsMethod().getFullMethodName().equals(fullMethodName)) {
            return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
              @Override
              public void sendMessage(ReqT message) {
                if (message instanceof ReadRowsRequest
                    && isSinglePointReadRows((ReadRowsRequest) message)) {
                  StatusRuntimeException error =
                      Status.FAILED_PRECONDITION
                          .withDescription(
                              "Expected protocol SESSION (-Dbigtable.expected-protocol=SESSION), "
                                  + "but attempted single-point classic ReadRows RPC")
                          .asRuntimeException();
                  cancel(error.getMessage(), error);
                  throw error;
                }
                super.sendMessage(message);
              }
            };
          }
        }

        return next.newCall(method, callOptions);
      }
    };
  }

  private static boolean isSessionOpenMethod(MethodDescriptor<?, ?> method) {
    String bareMethodName = method.getBareMethodName();
    return BigtableGrpc.SERVICE_NAME.equals(method.getServiceName())
        && bareMethodName != null
        && bareMethodName.startsWith("Open");
  }

  static boolean isSinglePointReadRows(ReadRowsRequest req) {
    if (req.getRowsLimit() != 1) {
      return false;
    }
    RowSet rows = req.getRows();
    int keyCount = rows.getRowKeysCount();
    int rangeCount = rows.getRowRangesCount();
    if (keyCount == 1 && rangeCount == 0) {
      return true;
    }
    if (keyCount == 0 && rangeCount == 1) {
      RowRange range = rows.getRowRanges(0);
      return range.hasStartKeyClosed()
          && range.hasEndKeyClosed()
          && range.getStartKeyClosed().equals(range.getEndKeyClosed());
    }
    return false;
  }

  private static final class FailingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private final Status status;

    FailingClientCall(Status status) {
      this.status = status;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      responseListener.onClose(status, new Metadata());
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {}

    @Override
    public void halfClose() {}

    @Override
    public void sendMessage(ReqT message) {}
  }

  private class AppProfileInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
      return new SimpleForwardingClientCall<ReqT, RespT>(
          channel.newCall(methodDescriptor, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          String reqParams =
              headers.get(
                  Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER));
          if (reqParams == null || !reqParams.contains("app_profile_id=" + appProfileId)) {
            responseListener.onClose(
                Status.FAILED_PRECONDITION.withDescription(
                    "Integration test was configured to run with app profile: "
                        + appProfileId
                        + ", but found a different app profile in the headers: "
                        + reqParams),
                new Metadata());
            return;
          }
          super.start(responseListener, headers);
        }
      };
    }
  }

  private void configureUserAgent(EnhancedBigtableStubSettings.Builder stubSettings) {
    String newUserAgent = "java-bigtable-int-test";

    // Use the existing user-agent to use as a prefix
    Map<String, String> existingHeaders =
        MoreObjects.firstNonNull(stubSettings.getHeaderProvider(), FixedHeaderProvider.create())
            .getHeaders();
    String existingUserAgent = existingHeaders.get("user-agent");
    if (existingUserAgent != null) {
      newUserAgent = existingUserAgent + " " + newUserAgent;
    }

    Map<String, String> newHeaders = new HashMap<>(existingHeaders);
    newHeaders.put("user-agent", newUserAgent);

    stubSettings.setHeaderProvider(FixedHeaderProvider.create(newHeaders));
  }

  @Override
  void start() throws IOException {
    BigtableDataSettings builtDataSettings = dataSettings.build();
    BigtableClientContext clientContext =
        BigtableClientContext.create(builtDataSettings.getStubSettings());
    try {
      EnhancedBigtableStub stub =
          new EnhancedBigtableStub(
              builtDataSettings.getStubSettings().getPerOpSettings(), clientContext);
      dataClient = BigtableDataClientTestHelpers.createWithStub(stub);
    } catch (RuntimeException e) {
      try {
        clientContext.close();
      } catch (Exception closeError) {
        e.addSuppressed(closeError);
      }
      throw e;
    }
    sessionShim = clientContext.getSessionShim();
    try {
      verifyExpectedProtocol(getExpectedProtocol(), sessionShim);
    } catch (RuntimeException e) {
      sessionShim = null;
      dataClient.close();
      dataClient = null;
      throw e;
    }
    tableAdminClient = BigtableTableAdminClient.create(tableAdminSettings.build());
    instanceAdminClient = BigtableInstanceAdminClient.create(instanceAdminSettings.build());
  }

  static void verifyExpectedProtocol(ExpectedProtocol expectedProtocol, Shim shim) {
    switch (expectedProtocol) {
      case ANY:
        return;
      case CLASSIC:
        Preconditions.checkState(
            !isSessionsEnabled(shim),
            "Expected protocol CLASSIC (-Dbigtable.expected-protocol=CLASSIC), "
                + "but sessions are enabled in the resolved ClientConfiguration");
        return;
      case SESSION:
        Preconditions.checkState(
            isSessionsEnabled(shim),
            "Expected protocol SESSION (-Dbigtable.expected-protocol=SESSION), "
                + "but sessions are disabled in the resolved ClientConfiguration");
        return;
      default:
        throw new IllegalStateException("Unexpected ExpectedProtocol: " + expectedProtocol);
    }
  }

  @Override
  void stop() {
    sessionShim = null;
    dataClient.close();
    tableAdminClient.close();
    instanceAdminClient.close();
  }

  @Override
  public boolean isSessionsEnabled() {
    Preconditions.checkState(
        sessionShim != null, "CloudEnv must be started before calling isSessionsEnabled()");
    return isSessionsEnabled(sessionShim);
  }

  static boolean isSessionsEnabled(Shim shim) {
    if (!(shim instanceof ShimImpl)) {
      return false;
    }
    ClientConfiguration config = ((ShimImpl) shim).getConfigManager().getClientConfiguration();
    return SessionScope.divertsAnyTraffic(config.getSessionConfiguration());
  }

  @Override
  public BigtableDataClient getDataClient() {
    return dataClient;
  }

  @Override
  public BigtableTableAdminClient getTableAdminClient() {
    return tableAdminClient;
  }

  @Override
  public BigtableTableAdminClient getTableAdminClientForInstance(String instanceId)
      throws IOException {
    BigtableTableAdminSettings.Builder settings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(tableAdminSettings.getProjectId())
            .setInstanceId(instanceId);
    settings.stubSettings().setEndpoint(tableAdminSettings.stubSettings().getEndpoint());
    return BigtableTableAdminClient.create(settings.build());
  }

  @Override
  public BigtableInstanceAdminClient getInstanceAdminClient() {
    return instanceAdminClient;
  }

  @Override
  public BigtableDataSettings getDataClientSettings() {
    return dataSettings.build();
  }

  @Override
  public BigtableInstanceAdminSettings getInstanceAdminClientSettings() {
    try {
      return instanceAdminSettings.build();
    } catch (IOException e) {
      throw new IllegalStateException(
          "Caught unexpected error building instance admin settings", e);
    }
  }

  @Override
  public BigtableTableAdminSettings getTableAdminSettings() {
    try {
      return tableAdminSettings.build();
    } catch (IOException e) {
      throw new IllegalStateException("Caught unexpected error building table admin settings", e);
    }
  }

  @Override
  public String getProjectId() {
    return projectId;
  }

  @Override
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public TableId getTableId() {
    return tableId;
  }

  @Override
  public String getKmsKeyName() {
    return kmsKeyName;
  }

  @Nullable
  private static String getOptionalProperty(String prop) {
    return System.getProperty(prop);
  }

  private static String getOptionalProperty(String prop, String defaultValue) {
    return MoreObjects.firstNonNull(System.getProperty(prop), defaultValue);
  }

  private static String getRequiredProperty(String prop) {
    String value = System.getProperty(prop);
    if (value == null || value.isEmpty()) {
      throw new RuntimeException("Missing system property: " + prop);
    }
    return value;
  }
}
