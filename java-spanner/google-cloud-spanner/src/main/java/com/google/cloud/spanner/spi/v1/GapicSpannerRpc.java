/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.SpannerExceptionFactory.asSpannerException;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.cloud.spanner.ThreadFactoryUtil.tryCreateVirtualThreadPerTaskExecutor;
import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.NanoClock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.InstantiatingWatchdogProvider;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.api.pathtemplate.PathTemplate;
import com.google.auth.Credentials;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.grpc.GcpManagedChannelBuilder;
import com.google.cloud.grpc.GcpManagedChannelOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.fallback.GcpFallbackChannel;
import com.google.cloud.grpc.fallback.GcpFallbackChannelOptions;
import com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry;
import com.google.cloud.spanner.AdminRequestsPerMinuteExceededException;
import com.google.cloud.spanner.BackupId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Restore;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.SpannerOptions.CallCredentialsProvider;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.XGoogSpannerRequestId.RequestIdCreator;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.database.v1.stub.GrpcDatabaseAdminCallableFactory;
import com.google.cloud.spanner.admin.database.v1.stub.GrpcDatabaseAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.GrpcInstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.encryption.EncryptionConfigProtoMapper;
import com.google.cloud.spanner.v1.stub.SpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Resources;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc;
import com.google.spanner.admin.database.v1.DatabaseRole;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.admin.database.v1.ListDatabaseRolesResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceAdminGrpc;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.Transaction;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.ForwardingChannelBuilder2;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

/** Implementation of Cloud Spanner remote calls using Gapic libraries. */
@InternalApi
public class GapicSpannerRpc implements SpannerRpc {
  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  public static final String EXPERIMENTAL_LOCATION_API_ENV_VAR =
      "GOOGLE_SPANNER_EXPERIMENTAL_LOCATION_API";
  private static final PathTemplate OPERATION_NAME_TEMPLATE =
      PathTemplate.create("{database=projects/*/instances/*/databases/*}/operations/{operation}");
  private static final int MAX_MESSAGE_SIZE = 256 * 1024 * 1024;
  private static final int MAX_METADATA_SIZE = 32 * 1024; // bytes
  private static final String PROPERTY_TIMEOUT_SECONDS =
      "com.google.cloud.spanner.watchdogTimeoutSeconds";
  private static final String PROPERTY_PERIOD_SECONDS =
      "com.google.cloud.spanner.watchdogPeriodSeconds";
  private static final int DEFAULT_TIMEOUT_SECONDS = 30 * 60;
  private static final int DEFAULT_PERIOD_SECONDS = 10;
  private static final int GRPC_KEEPALIVE_SECONDS = 2 * 60;
  private static final String USER_AGENT_KEY = "user-agent";
  private static final String CLIENT_LIBRARY_LANGUAGE = "spanner-java";
  public static final String DEFAULT_USER_AGENT =
      CLIENT_LIBRARY_LANGUAGE + "/" + GaxProperties.getLibraryVersion(GapicSpannerRpc.class);
  public static boolean DIRECTPATH_CHANNEL_CREATED = false;
  private static final String API_FILE = "grpc-gcp-apiconfig.json";

  private final RequestIdCreator requestIdCreator = new RequestIdCreatorImpl();
  private boolean rpcIsClosed;
  private final SpannerStub spannerStub;
  private final RetrySettings executeQueryRetrySettings;
  private final Set<Code> executeQueryRetryableCodes;
  private final RetrySettings readRetrySettings;
  private final Set<Code> readRetryableCodes;
  private final RetrySettings commitRetrySettings;
  private final SpannerStub partitionedDmlStub;
  private final RetrySettings partitionedDmlRetrySettings;
  private final InstanceAdminStubSettings instanceAdminStubSettings;
  private final InstanceAdminStub instanceAdminStub;
  private final DatabaseAdminStubSettings databaseAdminStubSettings;
  private final DatabaseAdminStub databaseAdminStub;
  private final String projectId;
  private final String projectName;
  private final SpannerMetadataProvider metadataProvider;
  private final CallCredentialsProvider callCredentialsProvider;
  private final String compressorName;
  private final Duration waitTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration idleTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration checkInterval =
      systemProperty(PROPERTY_PERIOD_SECONDS, DEFAULT_PERIOD_SECONDS);

  private final ScheduledExecutorService spannerWatchdog;

  private final ConcurrentLinkedDeque<SpannerResponseObserver> responseObservers =
      new ConcurrentLinkedDeque<>();

  private final boolean throttleAdministrativeRequests;
  private final RetrySettings retryAdministrativeRequestsSettings;
  private static final double ADMINISTRATIVE_REQUESTS_RATE_LIMIT = 1.0D;
  private static final ConcurrentMap<String, RateLimiter> ADMINISTRATIVE_REQUESTS_RATE_LIMITERS =
      new ConcurrentHashMap<>();
  private final boolean leaderAwareRoutingEnabled;
  private final boolean endToEndTracingEnabled;
  private final int numChannels;
  private final boolean isGrpcGcpExtensionEnabled;
  private final boolean isDynamicChannelPoolEnabled;
  @Nullable private final KeyAwareChannel keyAwareChannel;

  private final GrpcCallContext baseGrpcCallContext;

  public static GapicSpannerRpc create(SpannerOptions options) {
    return new GapicSpannerRpc(options);
  }

  public GapicSpannerRpc(final SpannerOptions options) {
    this(options, true);
  }

  GapicSpannerRpc(final SpannerOptions options, boolean initializeStubs) {
    this.projectId = options.getProjectId();
    String projectNameStr = PROJECT_NAME_TEMPLATE.instantiate("project", this.projectId);
    try {
      // Fix use cases where projectName contains special characters.
      // This would happen when projects are under an organization.
      projectNameStr = URLDecoder.decode(projectNameStr, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException e) { // Ignored.
    }
    this.projectName = projectNameStr;
    this.throttleAdministrativeRequests = options.isAutoThrottleAdministrativeRequests();
    if (throttleAdministrativeRequests) {
      ADMINISTRATIVE_REQUESTS_RATE_LIMITERS.putIfAbsent(
          projectNameStr, RateLimiter.create(ADMINISTRATIVE_REQUESTS_RATE_LIMIT));
    }
    this.retryAdministrativeRequestsSettings = options.getRetryAdministrativeRequestsSettings();

    // create a metadataProvider which combines both internal headers and
    // per-method-call extra headers for channelProvider to inject the headers
    // for rpc calls
    ApiClientHeaderProvider.Builder internalHeaderProviderBuilder =
        ApiClientHeaderProvider.newBuilder();
    ApiClientHeaderProvider internalHeaderProvider =
        internalHeaderProviderBuilder
            .setClientLibToken(
                options.getClientLibToken(), GaxProperties.getLibraryVersion(options.getClass()))
            .setTransportToken(
                GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion())
            .build();

    final HeaderProvider mergedHeaderProvider =
        options.getMergedHeaderProvider(internalHeaderProvider);
    final HeaderProvider headerProviderWithUserAgent =
        headerProviderWithUserAgentFrom(mergedHeaderProvider);

    this.metadataProvider =
        SpannerMetadataProvider.create(
            headerProviderWithUserAgent.getHeaders(),
            internalHeaderProviderBuilder.getResourceHeaderKey());
    this.callCredentialsProvider = options.getCallCredentialsProvider();
    this.compressorName = options.getCompressorName();
    this.leaderAwareRoutingEnabled = options.isLeaderAwareRoutingEnabled();
    this.endToEndTracingEnabled = options.isEndToEndTracingEnabled();
    this.numChannels = options.getNumChannels();
    this.isGrpcGcpExtensionEnabled = options.isGrpcGcpExtensionEnabled();
    this.isDynamicChannelPoolEnabled = options.isDynamicChannelPoolEnabled();
    this.baseGrpcCallContext = createBaseCallContext();

    boolean isEnableDirectAccess = options.isEnableDirectAccess();

    if (initializeStubs) {
      CredentialsProvider credentialsProvider =
          GrpcTransportOptions.setUpCredentialsProvider(options);

      InstantiatingGrpcChannelProvider.Builder defaultChannelProviderBuilder =
          createChannelProviderBuilder(options, headerProviderWithUserAgent, isEnableDirectAccess);

      if (options.getChannelProvider() == null
          && isEnableDirectAccess
          && options.isEnableGcpFallback()) {
        setupGcpFallback(
            defaultChannelProviderBuilder,
            options,
            headerProviderWithUserAgent,
            credentialsProvider);
      }

      boolean enableLocationApi = options.isEnableLocationApi();
      // First check if SpannerOptions provides a TransportChannelProvider. Create one
      // with information gathered from SpannerOptions if none is provided
      TransportChannelProvider baseChannelProvider =
          MoreObjects.firstNonNull(
              options.getChannelProvider(), defaultChannelProviderBuilder.build());
      TransportChannelProvider channelProvider =
          enableLocationApi && baseChannelProvider instanceof InstantiatingGrpcChannelProvider
              ? new KeyAwareTransportChannelProvider(
                  (InstantiatingGrpcChannelProvider) baseChannelProvider,
                  options.getChannelEndpointCacheFactory())
              : baseChannelProvider;

      spannerWatchdog =
          Executors.newSingleThreadScheduledExecutor(
              new ThreadFactoryBuilder()
                  .setDaemon(true)
                  .setNameFormat("Cloud-Spanner-WatchdogProvider-%d")
                  .build());
      WatchdogProvider watchdogProvider =
          InstantiatingWatchdogProvider.create()
              .withExecutor(spannerWatchdog)
              .withCheckIntervalDuration(checkInterval)
              .withClock(NanoClock.getDefaultClock());

      final String emulatorHost = System.getenv("SPANNER_EMULATOR_HOST");

      try {
        // TODO: make our retry settings to inject and increment
        // XGoogSpannerRequestId whenever a retry occurs.
        SpannerStubSettings spannerStubSettings =
            options.getSpannerStubSettings().toBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .setStreamWatchdogProvider(watchdogProvider)
                .setTracerFactory(
                    options.getApiTracerFactory(
                        /* isAdminClient= */ false, isEmulatorEnabled(options, emulatorHost)))
                .build();
        ClientContext clientContext = ClientContext.create(spannerStubSettings);
        this.keyAwareChannel = extractKeyAwareChannel(clientContext.getTransportChannel());
        this.spannerStub =
            GrpcSpannerStubWithStubSettingsAndClientContext.create(
                spannerStubSettings, clientContext);
        DIRECTPATH_CHANNEL_CREATED =
            ((GrpcTransportChannel) clientContext.getTransportChannel()).isDirectPath()
                && isEnableDirectAccess;
        this.readRetrySettings =
            options.getSpannerStubSettings().streamingReadSettings().getRetrySettings();
        this.readRetryableCodes =
            options.getSpannerStubSettings().streamingReadSettings().getRetryableCodes();
        this.executeQueryRetrySettings =
            options.getSpannerStubSettings().executeStreamingSqlSettings().getRetrySettings();
        this.executeQueryRetryableCodes =
            options.getSpannerStubSettings().executeStreamingSqlSettings().getRetryableCodes();
        this.commitRetrySettings =
            options.getSpannerStubSettings().commitSettings().getRetrySettings();
        partitionedDmlRetrySettings =
            options.getSpannerStubSettings().executeSqlSettings().getRetrySettings().toBuilder()
                .setInitialRpcTimeout(options.getPartitionedDmlTimeout())
                .setMaxRpcTimeout(options.getPartitionedDmlTimeout())
                .setTotalTimeout(options.getPartitionedDmlTimeout())
                .setRpcTimeoutMultiplier(1.0)
                .build();
        SpannerStubSettings.Builder pdmlSettings = options.getSpannerStubSettings().toBuilder();
        pdmlSettings
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(credentialsProvider)
            .setStreamWatchdogProvider(watchdogProvider)
            .setTracerFactory(
                options.getApiTracerFactory(
                    /* isAdminClient= */ false, isEmulatorEnabled(options, emulatorHost)))
            .executeSqlSettings()
            .setRetrySettings(partitionedDmlRetrySettings);
        pdmlSettings.executeStreamingSqlSettings().setRetrySettings(partitionedDmlRetrySettings);
        // The stream watchdog will by default only check for a timeout every 10 seconds, so if the
        // timeout is less than 10 seconds, it would be ignored for the first 10 seconds unless we
        // also change the StreamWatchdogCheckInterval.
        if (options
                .getPartitionedDmlTimeout()
                .dividedBy(10L)
                .compareTo(pdmlSettings.getStreamWatchdogCheckInterval())
            < 0) {
          pdmlSettings.setStreamWatchdogCheckInterval(
              options.getPartitionedDmlTimeout().dividedBy(10));
          pdmlSettings.setStreamWatchdogProvider(
              pdmlSettings
                  .getStreamWatchdogProvider()
                  .withCheckInterval(pdmlSettings.getStreamWatchdogCheckInterval()));
        }
        this.partitionedDmlStub =
            GrpcSpannerStubWithStubSettingsAndClientContext.create(
                pdmlSettings.build(), clientContext);
        this.instanceAdminStubSettings =
            options.getInstanceAdminStubSettings().toBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .setStreamWatchdogProvider(watchdogProvider)
                .setTracerFactory(
                    options.getApiTracerFactory(
                        /* isAdminClient= */ true, isEmulatorEnabled(options, emulatorHost)))
                .build();
        this.instanceAdminStub = GrpcInstanceAdminStub.create(instanceAdminStubSettings);

        this.databaseAdminStubSettings =
            options.getDatabaseAdminStubSettings().toBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .setStreamWatchdogProvider(watchdogProvider)
                .setTracerFactory(
                    options.getApiTracerFactory(
                        /* isAdminClient= */ true, isEmulatorEnabled(options, emulatorHost)))
                .build();

        // Automatically retry RESOURCE_EXHAUSTED for GetOperation if auto-throttling of
        // administrative requests has been set. The GetOperation RPC is called repeatedly by gax
        // while polling long-running operations for their progress and can also cause these errors.
        // The default behavior is not to retry these errors, and this option should normally only
        // be enabled for (integration) testing.
        if (options.isAutoThrottleAdministrativeRequests()) {
          GrpcStubCallableFactory factory =
              new GrpcDatabaseAdminCallableFactory() {
                @Override
                public <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
                    GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
                    UnaryCallSettings<RequestT, ResponseT> callSettings,
                    ClientContext clientContext) {
                  // Make GetOperation retry on RESOURCE_EXHAUSTED to prevent polling operations
                  // from failing with an Administrative requests limit exceeded error.
                  if (grpcCallSettings
                      .getMethodDescriptor()
                      .getFullMethodName()
                      .equals("google.longrunning.Operations/GetOperation")) {
                    Set<StatusCode.Code> codes =
                        ImmutableSet.<StatusCode.Code>builderWithExpectedSize(
                                callSettings.getRetryableCodes().size() + 1)
                            .addAll(callSettings.getRetryableCodes())
                            .add(StatusCode.Code.RESOURCE_EXHAUSTED)
                            .build();
                    callSettings = callSettings.toBuilder().setRetryableCodes(codes).build();
                  }
                  return super.createUnaryCallable(grpcCallSettings, callSettings, clientContext);
                }
              };
          this.databaseAdminStub =
              new GrpcDatabaseAdminStubWithCustomCallableFactory(
                  databaseAdminStubSettings,
                  ClientContext.create(databaseAdminStubSettings),
                  factory);
        } else {
          this.databaseAdminStub = GrpcDatabaseAdminStub.create(databaseAdminStubSettings);
        }

        // Check whether the SPANNER_EMULATOR_HOST env var has been set, and if so, if the emulator
        // is actually running.
        checkEmulatorConnection(options, channelProvider, credentialsProvider, emulatorHost);
      } catch (Exception e) {
        throw asSpannerException(e);
      }
    } else {
      this.keyAwareChannel = null;
      this.databaseAdminStub = null;
      this.instanceAdminStub = null;
      this.spannerStub = null;
      this.readRetrySettings = null;
      this.readRetryableCodes = null;
      this.executeQueryRetrySettings = null;
      this.executeQueryRetryableCodes = null;
      this.commitRetrySettings =
          SpannerStubSettings.newBuilder().commitSettings().getRetrySettings();
      this.partitionedDmlStub = null;
      this.databaseAdminStubSettings = null;
      this.instanceAdminStubSettings = null;
      this.spannerWatchdog = null;
      this.partitionedDmlRetrySettings = null;
    }
  }

  @VisibleForTesting
  GcpFallbackChannelOptions createFallbackChannelOptions(
      GcpFallbackOpenTelemetry fallbackTelemetry, int minFailedCalls) {
    return GcpFallbackChannelOptions.newBuilder()
        .setPrimaryChannelName("directpath")
        .setFallbackChannelName("cloudpath")
        .setMinFailedCalls(minFailedCalls)
        .setGcpFallbackOpenTelemetry(fallbackTelemetry)
        .build();
  }

  private static KeyAwareChannel extractKeyAwareChannel(TransportChannel transportChannel) {
    if (transportChannel instanceof GrpcTransportChannel) {
      Channel channel = ((GrpcTransportChannel) transportChannel).getChannel();
      if (channel instanceof KeyAwareChannel) {
        return (KeyAwareChannel) channel;
      }
    }
    return null;
  }

  @Override
  public void clearTransactionAffinity(ByteString transactionId) {
    if (keyAwareChannel != null) {
      keyAwareChannel.clearTransactionAffinity(transactionId);
    }
  }

  private static String parseGrpcGcpApiConfig() {
    try {
      return Resources.toString(
          GapicSpannerRpc.class.getResource(API_FILE), Charset.forName("UTF8"));
    } catch (IOException e) {
      throw newSpannerException(e);
    }
  }

  private void setupGcpFallback(
      InstantiatingGrpcChannelProvider.Builder defaultChannelProviderBuilder,
      final SpannerOptions options,
      final HeaderProvider headerProviderWithUserAgent,
      final CredentialsProvider credentialsProvider) {
    InstantiatingGrpcChannelProvider.Builder cloudPathProviderBuilder =
        createChannelProviderBuilder(
            options, headerProviderWithUserAgent, /* isEnableDirectAccess= */ false);

    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> existingCloudPathConfigurator =
        cloudPathProviderBuilder.getChannelConfigurator();
    final AtomicReference<ManagedChannelBuilder> cloudPathBuilderRef = new AtomicReference<>();
    cloudPathProviderBuilder.setChannelConfigurator(
        builder -> {
          ManagedChannelBuilder effectiveBuilder = builder;
          if (existingCloudPathConfigurator != null) {
            effectiveBuilder = existingCloudPathConfigurator.apply(effectiveBuilder);
          }
          cloudPathBuilderRef.set(effectiveBuilder);
          return effectiveBuilder;
        });

    // Build the cloudPathProvider to extract the builder which will be provided to
    // FallbackChannelBuilder.
    try (TransportChannel ignored = cloudPathProviderBuilder.build().getTransportChannel()) {
    } catch (Exception e) {
      throw asSpannerException(e);
    }

    ManagedChannelBuilder cloudPathBuilder = cloudPathBuilderRef.get();
    if (cloudPathBuilder == null) {
      throw new IllegalStateException("CloudPath builder was not captured.");
    }

    try {
      Credentials credentials = credentialsProvider.getCredentials();
      if (credentials != null) {
        cloudPathBuilder.intercept(
            new ClientInterceptor() {
              @Override
              public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                  MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
                return next.newCall(
                    method, callOptions.withCallCredentials(MoreCallCredentials.from(credentials)));
              }
            });
      }
    } catch (Exception e) {
      throw asSpannerException(e);
    }

    final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> existingConfigurator =
        defaultChannelProviderBuilder.getChannelConfigurator();
    defaultChannelProviderBuilder.setChannelConfigurator(
        directPathBuilder -> {
          ManagedChannelBuilder builder = directPathBuilder;
          if (existingConfigurator != null) {
            builder = existingConfigurator.apply(builder);
          }

          String jsonApiConfig = parseGrpcGcpApiConfig();
          GcpManagedChannelOptions gcpOptions = grpcGcpOptionsWithMetricsAndDcp(options);
          if (gcpOptions == null) {
            gcpOptions = GcpManagedChannelOptions.newBuilder().build();
          }

          GcpManagedChannelBuilder primaryGcpBuilder =
              GcpManagedChannelBuilder.forDelegateBuilder(builder)
                  .withApiConfigJsonString(jsonApiConfig)
                  .withOptions(gcpOptions);

          GcpManagedChannelBuilder fallbackGcpBuilder =
              GcpManagedChannelBuilder.forDelegateBuilder(cloudPathBuilder)
                  .withApiConfigJsonString(jsonApiConfig)
                  .withOptions(gcpOptions);

          GcpFallbackOpenTelemetry fallbackTelemetry =
              GcpFallbackOpenTelemetry.newBuilder()
                  .withSdk(options.getOpenTelemetry())
                  .disableAllMetrics()
                  .enableMetrics(Arrays.asList("fallback_count", "call_status"))
                  .build();

          return new FallbackChannelBuilder(
              primaryGcpBuilder,
              fallbackGcpBuilder,
              createFallbackChannelOptions(fallbackTelemetry, 1));
        });
  }

  private InstantiatingGrpcChannelProvider.Builder createChannelProviderBuilder(
      final SpannerOptions options,
      final HeaderProvider headerProviderWithUserAgent,
      boolean isEnableDirectAccess) {
    InstantiatingGrpcChannelProvider.Builder defaultChannelProviderBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setChannelConfigurator(options.getChannelConfigurator())
            .setEndpoint(options.getEndpoint())
            .setMaxInboundMessageSize(MAX_MESSAGE_SIZE)
            .setMaxInboundMetadataSize(MAX_METADATA_SIZE)
            .setPoolSize(options.getNumChannels())

            // Set a keepalive time of 120 seconds to help long running
            // commit GRPC calls succeed
            .setKeepAliveTimeDuration(Duration.ofSeconds(GRPC_KEEPALIVE_SECONDS))

            // Then check if SpannerOptions provides an InterceptorProvider. Create a default
            // SpannerInterceptorProvider if none is provided
            .setInterceptorProvider(
                SpannerInterceptorProvider.create(
                        MoreObjects.firstNonNull(
                            options.getInterceptorProvider(),
                            SpannerInterceptorProvider.createDefault(options.getOpenTelemetry())))
                    // This sets the trace context headers.
                    .withTraceContext(endToEndTracingEnabled, options.getOpenTelemetry())
                    // This sets the response compressor (Server -> Client).
                    .withEncoding(compressorName))
            .setHeaderProvider(headerProviderWithUserAgent)
            .setAllowNonDefaultServiceAccount(true);
    if (isEnableDirectAccess) {
      defaultChannelProviderBuilder.setAttemptDirectPath(true);
      if (isEnableDirectPathBoundToken()) {
        // This will let the credentials try to fetch a hard-bound access token if the runtime
        // environment supports it.
        defaultChannelProviderBuilder.setAllowHardBoundTokenTypes(
            Collections.singletonList(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS));
      }
      defaultChannelProviderBuilder.setAttemptDirectPathXds();
    }

    options.enablegRPCMetrics(defaultChannelProviderBuilder);

    if (options.isUseVirtualThreads()) {
      ExecutorService executor =
          tryCreateVirtualThreadPerTaskExecutor("spanner-virtual-grpc-executor");
      if (executor != null) {
        defaultChannelProviderBuilder.setExecutor(executor);
      }
    }
    // If it is enabled in options uses the channel pool provided by the gRPC-GCP extension.
    maybeEnableGrpcGcpExtension(defaultChannelProviderBuilder, options);
    return defaultChannelProviderBuilder;
  }

  // Enhance gRPC-GCP options with metrics and dynamic channel pool configuration.
  private static GcpManagedChannelOptions grpcGcpOptionsWithMetricsAndDcp(SpannerOptions options) {
    GcpManagedChannelOptions grpcGcpOptions =
        MoreObjects.firstNonNull(options.getGrpcGcpOptions(), new GcpManagedChannelOptions());
    GcpManagedChannelOptions.Builder optionsBuilder =
        GcpManagedChannelOptions.newBuilder(grpcGcpOptions);

    // Configure metrics options with OpenTelemetry meter
    GcpMetricsOptions metricsOptions =
        MoreObjects.firstNonNull(
            grpcGcpOptions.getMetricsOptions(), GcpMetricsOptions.newBuilder().build());
    GcpMetricsOptions.Builder metricsOptionsBuilder = GcpMetricsOptions.newBuilder(metricsOptions);
    // TODO: Add default labels with values: client_id, database, instance_id.
    if (metricsOptions.getNamePrefix().equals("")) {
      metricsOptionsBuilder.withNamePrefix("cloud.google.com/java/spanner/gcp-channel-pool/");
    }
    // Pass OpenTelemetry meter to grpc-gcp for channel pool metrics
    if (metricsOptions.getOpenTelemetryMeter() == null && options.isGrpcGcpOtelMetricsEnabled()) {
      metricsOptionsBuilder.withOpenTelemetryMeter(
          options.getOpenTelemetry().getMeter("com.google.cloud.spanner"));
    }
    optionsBuilder.withMetricsOptions(metricsOptionsBuilder.build());

    // Configure dynamic channel pool options if enabled.
    // Uses the GcpChannelPoolOptions from SpannerOptions, which contains Spanner-specific defaults
    // or user-provided configuration.
    if (options.isDynamicChannelPoolEnabled()) {
      optionsBuilder.withChannelPoolOptions(options.getGcpChannelPoolOptions());
    }

    return optionsBuilder.build();
  }

  @SuppressWarnings("rawtypes")
  private static void maybeEnableGrpcGcpExtension(
      InstantiatingGrpcChannelProvider.Builder defaultChannelProviderBuilder,
      final SpannerOptions options) {
    if (!options.isGrpcGcpExtensionEnabled()) {
      return;
    }

    final String jsonApiConfig = parseGrpcGcpApiConfig();
    final GcpManagedChannelOptions grpcGcpOptions = grpcGcpOptionsWithMetricsAndDcp(options);

    // When dynamic channel pool is enabled, use the DCP initial size as the pool size.
    // When disabled, use the explicitly configured numChannels.
    final int poolSize = options.isDynamicChannelPoolEnabled() ? 0 : options.getNumChannels();

    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> baseConfigurator =
        defaultChannelProviderBuilder.getChannelConfigurator();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> apiFunction =
        channelBuilder -> {
          if (baseConfigurator != null) {
            channelBuilder = baseConfigurator.apply(channelBuilder);
          }
          return GcpManagedChannelBuilder.forDelegateBuilder(channelBuilder)
              .withApiConfigJsonString(jsonApiConfig)
              .withOptions(grpcGcpOptions)
              .setPoolSize(poolSize);
        };

    // Disable the GAX channel pooling functionality by setting the GAX channel pool size to 1.
    // Enable gRPC-GCP channel pool via the channel configurator.
    defaultChannelProviderBuilder.setPoolSize(1).setChannelConfigurator(apiFunction);
  }

  private static HeaderProvider headerProviderWithUserAgentFrom(HeaderProvider headerProvider) {
    final Optional<Entry<String, String>> existingUserAgentEntry =
        headerProvider.getHeaders().entrySet().stream()
            .filter(entry -> entry.getKey().equalsIgnoreCase(USER_AGENT_KEY))
            .findFirst();
    final String existingUserAgentValue = existingUserAgentEntry.map(Entry::getValue).orElse(null);
    final String userAgent =
        Stream.of(existingUserAgentValue, DEFAULT_USER_AGENT)
            .filter(Objects::nonNull)
            .collect(Collectors.joining(" "));

    final Map<String, String> headersWithUserAgent = new HashMap<>(headerProvider.getHeaders());
    existingUserAgentEntry.ifPresent(entry -> headersWithUserAgent.remove(entry.getKey()));
    headersWithUserAgent.put(USER_AGENT_KEY, userAgent);

    return FixedHeaderProvider.create(headersWithUserAgent);
  }

  private static void checkEmulatorConnection(
      SpannerOptions options,
      TransportChannelProvider channelProvider,
      CredentialsProvider credentialsProvider,
      String emulatorHost)
      throws IOException {
    // Only do the check if the emulator environment variable has been set to localhost.
    if (isEmulatorEnabled(options, emulatorHost)) {
      // Do a quick check to see if the emulator is actually running.
      try {
        InstanceAdminStubSettings.Builder testEmulatorSettings =
            options.getInstanceAdminStubSettings().toBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider);
        testEmulatorSettings
            .listInstanceConfigsSettings()
            .setSimpleTimeoutNoRetriesDuration(Duration.ofSeconds(10L));
        try (GrpcInstanceAdminStub stub =
            GrpcInstanceAdminStub.create(testEmulatorSettings.build())) {
          stub.listInstanceConfigsCallable()
              .call(
                  ListInstanceConfigsRequest.newBuilder()
                      .setParent(String.format("projects/%s", options.getProjectId()))
                      .build());
        }
      } catch (UnavailableException e) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.UNAVAILABLE,
            String.format(
                "The environment variable SPANNER_EMULATOR_HOST has been set to %s, but no running"
                    + " emulator could be found at that address.\n"
                    + "Did you forget to start the emulator, or to unset the environment"
                    + " variable?",
                emulatorHost));
      }
    }
  }

  private static boolean isEmulatorEnabled(SpannerOptions options, String emulatorHost) {
    // Only do the check if the emulator environment variable has been set to localhost.
    return options.getChannelProvider() == null
        && emulatorHost != null
        && options.getHost() != null
        && options.getHost().startsWith("http://localhost")
        && options.getHost().endsWith(emulatorHost);
  }

  public static boolean isEnableAFEServerTiming() {
    // Enable AFE metrics as default unless explicitly
    // disabled via env.
    return !Boolean.parseBoolean(System.getenv("SPANNER_DISABLE_AFE_SERVER_TIMING"));
  }

  public static boolean isEnableDirectPathXdsEnv() {
    return Boolean.parseBoolean(System.getenv("GOOGLE_SPANNER_ENABLE_DIRECT_ACCESS"));
  }

  public static boolean isEnableDirectPathBoundToken() {
    return !Boolean.parseBoolean(System.getenv("GOOGLE_SPANNER_DISABLE_DIRECT_ACCESS_BOUND_TOKEN"));
  }

  private static final RetrySettings ADMIN_REQUESTS_LIMIT_EXCEEDED_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofSeconds(5L))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelayDuration(Duration.ofSeconds(60L))
          .setMaxAttempts(10)
          .build();

  @VisibleForTesting
  static final class AdminRequestsLimitExceededRetryAlgorithm<T>
      implements ResultRetryAlgorithm<T> {
    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable, T prevResponse, TimedAttemptSettings prevSettings) {
      // Use default retry settings.
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, T prevResponse)
        throws CancellationException {
      return prevThrowable instanceof AdminRequestsPerMinuteExceededException;
    }
  }

  private <T> T runWithRetryOnAdministrativeRequestsExceeded(Callable<T> callable) {
    try {
      return RetryHelper.runWithRetries(
          callable,
          retryAdministrativeRequestsSettings,
          new AdminRequestsLimitExceededRetryAlgorithm<>(),
          NanoClock.getDefaultClock());
    } catch (RetryHelperException e) {
      throw asSpannerException(e.getCause());
    }
  }

  private static final class OperationFutureRetryAlgorithm<ResultT, MetadataT>
      implements ResultRetryAlgorithm<OperationFuture<ResultT, MetadataT>> {

    private static final ImmutableList<StatusCode.Code> RETRYABLE_CODES =
        ImmutableList.of(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE);

    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable,
        OperationFuture<ResultT, MetadataT> prevResponse,
        TimedAttemptSettings prevSettings) {
      // Use default retry settings.
      return null;
    }

    @Override
    public boolean shouldRetry(
        Throwable prevThrowable, OperationFuture<ResultT, MetadataT> prevResponse)
        throws CancellationException {
      if (prevThrowable instanceof ApiException) {
        ApiException e = (ApiException) prevThrowable;
        return RETRYABLE_CODES.contains(e.getStatusCode().getCode());
      }
      if (prevResponse != null) {
        try {
          prevResponse.getInitialFuture().get();
        } catch (ExecutionException ee) {
          Throwable cause = ee.getCause();
          if (cause instanceof ApiException) {
            ApiException e = (ApiException) cause;
            return RETRYABLE_CODES.contains(e.getStatusCode().getCode());
          }
        } catch (InterruptedException e) {
          return false;
        }
      }
      return false;
    }
  }

  private final class OperationFutureCallable<RequestT, ResponseT, MetadataT extends Message>
      implements Callable<OperationFuture<ResponseT, MetadataT>> {

    final OperationCallable<RequestT, ResponseT, MetadataT> operationCallable;
    final RequestT initialRequest;
    final MethodDescriptor<RequestT, Operation> method;
    final String instanceName;
    final OperationsLister lister;
    final Function<Operation, Timestamp> getStartTimeFunction;
    Timestamp initialCallTime;
    boolean isRetry = false;

    OperationFutureCallable(
        OperationCallable<RequestT, ResponseT, MetadataT> operationCallable,
        RequestT initialRequest,
        MethodDescriptor<RequestT, Operation> method,
        String instanceName,
        OperationsLister lister,
        Function<Operation, Timestamp> getStartTimeFunction) {
      this.operationCallable = operationCallable;
      this.initialRequest = initialRequest;
      this.method = method;
      this.instanceName = instanceName;
      this.lister = lister;
      this.getStartTimeFunction = getStartTimeFunction;
    }

    @Override
    public OperationFuture<ResponseT, MetadataT> call() {
      acquireAdministrativeRequestsRateLimiter();

      return runWithRetryOnAdministrativeRequestsExceeded(
          () -> {
            String operationName = null;
            if (isRetry) {
              // Query the backend to see if the operation was actually created, and that the
              // problem was caused by a network problem or other transient problem client side.
              Operation operation =
                  mostRecentOperation(lister, getStartTimeFunction, initialCallTime);
              if (operation != null) {
                // Operation found, resume tracking that operation.
                operationName = operation.getName();
              }
            } else {
              initialCallTime =
                  Timestamp.newBuilder()
                      .setSeconds(
                          TimeUnit.SECONDS.convert(
                              System.currentTimeMillis(), TimeUnit.MILLISECONDS))
                      .build();
            }
            isRetry = true;

            if (operationName == null) {
              GrpcCallContext context = newAdminCallContext(instanceName, initialRequest, method);
              return operationCallable.futureCall(initialRequest, context);
            } else {
              return operationCallable.resumeFutureCall(operationName);
            }
          });
    }
  }

  private interface OperationsLister {

    Paginated<Operation> listOperations(String nextPageToken);
  }

  private Operation mostRecentOperation(
      OperationsLister lister,
      Function<Operation, Timestamp> getStartTimeFunction,
      Timestamp initialCallTime) {
    Operation res = null;
    Timestamp currMaxStartTime = null;
    String nextPageToken = null;
    Paginated<Operation> operations;
    do {
      operations = lister.listOperations(nextPageToken);
      nextPageToken = operations.getNextPageToken();
      for (Operation op : operations.getResults()) {
        Timestamp startTime = getStartTimeFunction.apply(op);
        if (res == null
            || (TimestampComparator.INSTANCE.compare(startTime, currMaxStartTime) > 0
                && TimestampComparator.INSTANCE.compare(startTime, initialCallTime) >= 0)) {
          currMaxStartTime = startTime;
          res = op;
        }
        // If the operation does not report any start time, then the operation that is not yet done
        // is the one that is the most recent.
        if (startTime == null && currMaxStartTime == null && !op.getDone()) {
          res = op;
          break;
        }
      }
    } while (nextPageToken != null);
    return res;
  }

  private static final class TimestampComparator implements Comparator<Timestamp> {

    private static final TimestampComparator INSTANCE = new TimestampComparator();

    @Override
    public int compare(Timestamp t1, Timestamp t2) {
      if (t1 == null && t2 == null) {
        return 0;
      }
      if (t1 != null && t2 == null) {
        return 1;
      }
      if (t1 == null && t2 != null) {
        return -1;
      }
      if (t1.getSeconds() > t2.getSeconds()
          || (t1.getSeconds() == t2.getSeconds() && t1.getNanos() > t2.getNanos())) {
        return 1;
      }
      if (t1.getSeconds() < t2.getSeconds()
          || (t1.getSeconds() == t2.getSeconds() && t1.getNanos() < t2.getNanos())) {
        return -1;
      }
      return 0;
    }
  }

  private void acquireAdministrativeRequestsRateLimiter() {
    if (throttleAdministrativeRequests) {
      RateLimiter limiter = ADMINISTRATIVE_REQUESTS_RATE_LIMITERS.get(this.projectName);
      if (limiter != null) {
        limiter.acquire();
      }
    }
  }

  @Override
  public Paginated<InstanceConfig> listInstanceConfigs(int pageSize, @Nullable String pageToken)
      throws SpannerException {
    ListInstanceConfigsRequest.Builder requestBuilder =
        ListInstanceConfigsRequest.newBuilder().setParent(projectName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    ListInstanceConfigsRequest request = requestBuilder.build();

    GrpcCallContext context =
        newAdminCallContext(projectName, request, InstanceAdminGrpc.getListInstanceConfigsMethod());
    ListInstanceConfigsResponse response =
        get(instanceAdminStub.listInstanceConfigsCallable().futureCall(request, context));
    return new Paginated<>(response.getInstanceConfigsList(), response.getNextPageToken());
  }

  @Override
  public OperationFuture<InstanceConfig, CreateInstanceConfigMetadata> createInstanceConfig(
      String parent,
      String instanceConfigId,
      InstanceConfig instanceConfig,
      @Nullable Boolean validateOnly)
      throws SpannerException {
    CreateInstanceConfigRequest.Builder builder =
        CreateInstanceConfigRequest.newBuilder()
            .setParent(parent)
            .setInstanceConfigId(instanceConfigId)
            .setInstanceConfig(instanceConfig);
    if (validateOnly != null) {
      builder.setValidateOnly(validateOnly);
    }
    CreateInstanceConfigRequest request = builder.build();
    GrpcCallContext context =
        newAdminCallContext(parent, request, InstanceAdminGrpc.getCreateInstanceConfigMethod());
    return instanceAdminStub.createInstanceConfigOperationCallable().futureCall(request, context);
  }

  @Override
  public OperationFuture<InstanceConfig, UpdateInstanceConfigMetadata> updateInstanceConfig(
      InstanceConfig instanceConfig, @Nullable Boolean validateOnly, FieldMask fieldMask)
      throws SpannerException {
    UpdateInstanceConfigRequest.Builder builder =
        UpdateInstanceConfigRequest.newBuilder()
            .setInstanceConfig(instanceConfig)
            .setUpdateMask(fieldMask);
    if (validateOnly != null) {
      builder.setValidateOnly(validateOnly);
    }
    UpdateInstanceConfigRequest request = builder.build();
    GrpcCallContext context =
        newAdminCallContext(
            instanceConfig.getName(), request, InstanceAdminGrpc.getUpdateInstanceConfigMethod());
    return instanceAdminStub.updateInstanceConfigOperationCallable().futureCall(request, context);
  }

  @Override
  public InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException {
    GetInstanceConfigRequest request =
        GetInstanceConfigRequest.newBuilder().setName(instanceConfigName).build();

    GrpcCallContext context =
        newAdminCallContext(projectName, request, InstanceAdminGrpc.getGetInstanceConfigMethod());
    return get(instanceAdminStub.getInstanceConfigCallable().futureCall(request, context));
  }

  @Override
  public void deleteInstanceConfig(
      String instanceConfigName, @Nullable String etag, @Nullable Boolean validateOnly)
      throws SpannerException {
    DeleteInstanceConfigRequest.Builder requestBuilder =
        DeleteInstanceConfigRequest.newBuilder().setName(instanceConfigName);

    if (etag != null) {
      requestBuilder.setEtag(etag);
    }
    if (validateOnly != null) {
      requestBuilder.setValidateOnly(validateOnly);
    }
    DeleteInstanceConfigRequest request = requestBuilder.build();
    GrpcCallContext context =
        newAdminCallContext(
            instanceConfigName, request, InstanceAdminGrpc.getDeleteInstanceConfigMethod());
    get(instanceAdminStub.deleteInstanceConfigCallable().futureCall(request, context));
  }

  @Override
  public Paginated<Operation> listInstanceConfigOperations(
      int pageSize, @Nullable String filter, @Nullable String pageToken) {
    acquireAdministrativeRequestsRateLimiter();
    ListInstanceConfigOperationsRequest.Builder requestBuilder =
        ListInstanceConfigOperationsRequest.newBuilder()
            .setParent(projectName)
            .setPageSize(pageSize);
    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListInstanceConfigOperationsRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(
            projectName, request, InstanceAdminGrpc.getListInstanceConfigOperationsMethod());
    ListInstanceConfigOperationsResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () ->
                get(
                    instanceAdminStub
                        .listInstanceConfigOperationsCallable()
                        .futureCall(request, context)));
    return new Paginated<>(response.getOperationsList(), response.getNextPageToken());
  }

  @Override
  public Paginated<Instance> listInstances(
      int pageSize, @Nullable String pageToken, @Nullable String filter) throws SpannerException {
    ListInstancesRequest.Builder requestBuilder =
        ListInstancesRequest.newBuilder().setParent(projectName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    ListInstancesRequest request = requestBuilder.build();

    GrpcCallContext context =
        newAdminCallContext(projectName, request, InstanceAdminGrpc.getListInstancesMethod());
    ListInstancesResponse response =
        get(instanceAdminStub.listInstancesCallable().futureCall(request, context));
    return new Paginated<>(response.getInstancesList(), response.getNextPageToken());
  }

  @Override
  public OperationFuture<Instance, CreateInstanceMetadata> createInstance(
      String parent, String instanceId, Instance instance) throws SpannerException {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    GrpcCallContext context =
        newAdminCallContext(parent, request, InstanceAdminGrpc.getCreateInstanceMethod());
    return instanceAdminStub.createInstanceOperationCallable().futureCall(request, context);
  }

  @Override
  public OperationFuture<Instance, UpdateInstanceMetadata> updateInstance(
      Instance instance, FieldMask fieldMask) throws SpannerException {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setFieldMask(fieldMask).build();
    GrpcCallContext context =
        newAdminCallContext(
            instance.getName(), request, InstanceAdminGrpc.getUpdateInstanceMethod());
    return instanceAdminStub.updateInstanceOperationCallable().futureCall(request, context);
  }

  @Override
  public Instance getInstance(String instanceName) throws SpannerException {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(instanceName).build();

    GrpcCallContext context =
        newAdminCallContext(instanceName, request, InstanceAdminGrpc.getGetInstanceMethod());
    return get(instanceAdminStub.getInstanceCallable().futureCall(request, context));
  }

  @Override
  public void deleteInstance(String instanceName) throws SpannerException {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(instanceName).build();

    GrpcCallContext context =
        newAdminCallContext(instanceName, request, InstanceAdminGrpc.getDeleteInstanceMethod());
    get(instanceAdminStub.deleteInstanceCallable().futureCall(request, context));
  }

  @Override
  public Paginated<Operation> listBackupOperations(
      String instanceName, int pageSize, @Nullable String filter, @Nullable String pageToken) {
    acquireAdministrativeRequestsRateLimiter();
    ListBackupOperationsRequest.Builder requestBuilder =
        ListBackupOperationsRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);
    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListBackupOperationsRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(
            instanceName, request, DatabaseAdminGrpc.getListBackupOperationsMethod());
    ListBackupOperationsResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () ->
                get(databaseAdminStub.listBackupOperationsCallable().futureCall(request, context)));
    return new Paginated<>(response.getOperationsList(), response.getNextPageToken());
  }

  @Override
  public Paginated<Operation> listDatabaseOperations(
      String instanceName, int pageSize, @Nullable String filter, @Nullable String pageToken) {
    acquireAdministrativeRequestsRateLimiter();
    ListDatabaseOperationsRequest.Builder requestBuilder =
        ListDatabaseOperationsRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);

    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListDatabaseOperationsRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(
            instanceName, request, DatabaseAdminGrpc.getListDatabaseOperationsMethod());
    ListDatabaseOperationsResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () ->
                get(
                    databaseAdminStub
                        .listDatabaseOperationsCallable()
                        .futureCall(request, context)));

    return new Paginated<>(response.getOperationsList(), response.getNextPageToken());
  }

  @Override
  public Paginated<DatabaseRole> listDatabaseRoles(
      String databaseName, int pageSize, @Nullable String pageToken) {
    acquireAdministrativeRequestsRateLimiter();
    ListDatabaseRolesRequest.Builder requestBuilder =
        ListDatabaseRolesRequest.newBuilder().setParent(databaseName).setPageSize(pageSize);

    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListDatabaseRolesRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(databaseName, request, DatabaseAdminGrpc.getListDatabaseRolesMethod());
    ListDatabaseRolesResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () -> get(databaseAdminStub.listDatabaseRolesCallable().futureCall(request, context)));

    return new Paginated<>(response.getDatabaseRolesList(), response.getNextPageToken());
  }

  @Override
  public Paginated<Backup> listBackups(
      String instanceName, int pageSize, @Nullable String filter, @Nullable String pageToken)
      throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    ListBackupsRequest.Builder requestBuilder =
        ListBackupsRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);
    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListBackupsRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(instanceName, request, DatabaseAdminGrpc.getListBackupsMethod());
    ListBackupsResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () -> get(databaseAdminStub.listBackupsCallable().futureCall(request, context)));

    return new Paginated<>(response.getBackupsList(), response.getNextPageToken());
  }

  @Override
  public Paginated<Database> listDatabases(
      String instanceName, int pageSize, @Nullable String pageToken) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    ListDatabasesRequest.Builder requestBuilder =
        ListDatabasesRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    final ListDatabasesRequest request = requestBuilder.build();

    final GrpcCallContext context =
        newAdminCallContext(instanceName, request, DatabaseAdminGrpc.getListDatabasesMethod());
    ListDatabasesResponse response =
        runWithRetryOnAdministrativeRequestsExceeded(
            () -> get(databaseAdminStub.listDatabasesCallable().futureCall(request, context)));

    return new Paginated<>(response.getDatabasesList(), response.getNextPageToken());
  }

  @Override
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      final String instanceName,
      String createDatabaseStatement,
      Iterable<String> additionalStatements,
      com.google.cloud.spanner.Database databaseInfo)
      throws SpannerException {
    final String databaseId = databaseInfo.getId().getDatabase();
    CreateDatabaseRequest.Builder requestBuilder =
        CreateDatabaseRequest.newBuilder()
            .setParent(instanceName)
            .setCreateStatement(createDatabaseStatement)
            .addAllExtraStatements(additionalStatements);
    if (databaseInfo.getEncryptionConfig() != null) {
      requestBuilder.setEncryptionConfig(
          EncryptionConfigProtoMapper.encryptionConfig(databaseInfo.getEncryptionConfig()));
    }
    if (databaseInfo.getDialect() != null) {
      requestBuilder.setDatabaseDialect(databaseInfo.getDialect().toProto());
    }
    if (databaseInfo.getProtoDescriptors() != null) {
      requestBuilder.setProtoDescriptors(databaseInfo.getProtoDescriptors());
    }
    final CreateDatabaseRequest request = requestBuilder.build();
    OperationFutureCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata> callable =
        new OperationFutureCallable<>(
            databaseAdminStub.createDatabaseOperationCallable(),
            request,
            DatabaseAdminGrpc.getCreateDatabaseMethod(),
            instanceName,
            nextPageToken ->
                listDatabaseOperations(
                    instanceName,
                    0,
                    String.format(
                        "(metadata.@type:type.googleapis.com/%s) AND (name:%s/operations/)",
                        CreateDatabaseMetadata.getDescriptor().getFullName(),
                        String.format("%s/databases/%s", instanceName, databaseId)),
                    nextPageToken),
            input -> {
              if (input.getDone() && input.hasResponse()) {
                try {
                  Timestamp createTime = input.getResponse().unpack(Database.class).getCreateTime();
                  if (Timestamp.getDefaultInstance().equals(createTime)) {
                    // Create time was not returned by the server (proto objects never return
                    // null, instead they return the default instance). Return null from this
                    // method to indicate that there is no known create time.
                    return null;
                  }
                } catch (InvalidProtocolBufferException e) {
                  return null;
                }
              }
              return null;
            });
    return RetryHelper.runWithRetries(
        callable,
        databaseAdminStubSettings
            .createDatabaseOperationSettings()
            .getInitialCallSettings()
            .getRetrySettings(),
        new OperationFutureRetryAlgorithm<>(),
        NanoClock.getDefaultClock());
  }

  /**
   * If the update database ddl operation returns an ALREADY_EXISTS error, meaning the operation id
   * used is already in flight, this method will simply resume the original operation. The returned
   * future will be completed when the original operation finishes.
   *
   * <p>This mechanism is necessary, because the update database ddl can be retried. If a retryable
   * failure occurs, the backend has already started processing the update database ddl operation
   * with the given id and the library issues a retry, an ALREADY_EXISTS error will be returned. If
   * we were to bubble this error up, it would be confusing for the caller, who used originally
   * called the method with a new operation id.
   */
  @Override
  public OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      com.google.cloud.spanner.Database databaseInfo,
      final Iterable<String> updateDatabaseStatements,
      @Nullable final String updateId)
      throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    Preconditions.checkNotNull(databaseInfo.getId());
    UpdateDatabaseDdlRequest.Builder requestBuilder =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(databaseInfo.getId().getName())
            .addAllStatements(updateDatabaseStatements)
            .setOperationId(MoreObjects.firstNonNull(updateId, ""));
    if (databaseInfo.getProtoDescriptors() != null) {
      requestBuilder.setProtoDescriptors(databaseInfo.getProtoDescriptors());
    }
    final UpdateDatabaseDdlRequest request = requestBuilder.build();
    final GrpcCallContext context =
        newAdminCallContext(
            databaseInfo.getId().getName(),
            request,
            DatabaseAdminGrpc.getUpdateDatabaseDdlMethod());
    final OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata> callable =
        databaseAdminStub.updateDatabaseDdlOperationCallable();

    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> {
          OperationFuture<Empty, UpdateDatabaseDdlMetadata> operationFuture =
              callable.futureCall(request, context);
          try {
            operationFuture.getInitialFuture().get();
          } catch (InterruptedException e) {
            throw newSpannerException(e);
          } catch (ExecutionException e) {
            Throwable t = e.getCause();
            SpannerException se = asSpannerException(t);
            if (se instanceof AdminRequestsPerMinuteExceededException) {
              // Propagate this to trigger a retry.
              throw se;
            }
            if (t instanceof AlreadyExistsException) {
              String operationName =
                  OPERATION_NAME_TEMPLATE.instantiate(
                      "database", databaseInfo.getId().getName(), "operation", updateId);
              return callable.resumeFutureCall(operationName, context);
            }
          }
          return operationFuture;
        });
  }

  @Override
  public void dropDatabase(String databaseName) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final DropDatabaseRequest request =
        DropDatabaseRequest.newBuilder().setDatabase(databaseName).build();

    final GrpcCallContext context =
        newAdminCallContext(databaseName, request, DatabaseAdminGrpc.getDropDatabaseMethod());
    runWithRetryOnAdministrativeRequestsExceeded(
        () -> {
          get(databaseAdminStub.dropDatabaseCallable().futureCall(request, context));
          return null;
        });
  }

  @Override
  public Database getDatabase(String databaseName) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(databaseName).build();

    final GrpcCallContext context =
        newAdminCallContext(databaseName, request, DatabaseAdminGrpc.getGetDatabaseMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.getDatabaseCallable().futureCall(request, context)));
  }

  @Override
  public OperationFuture<Database, UpdateDatabaseMetadata> updateDatabase(
      Database database, FieldMask updateMask) throws SpannerException {
    UpdateDatabaseRequest request =
        UpdateDatabaseRequest.newBuilder().setDatabase(database).setUpdateMask(updateMask).build();
    GrpcCallContext context =
        newAdminCallContext(
            database.getName(), request, DatabaseAdminGrpc.getUpdateDatabaseMethod());
    return databaseAdminStub.updateDatabaseOperationCallable().futureCall(request, context);
  }

  @Override
  public GetDatabaseDdlResponse getDatabaseDdl(String databaseName) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder().setDatabase(databaseName).build();

    final GrpcCallContext context =
        newAdminCallContext(databaseName, request, DatabaseAdminGrpc.getGetDatabaseDdlMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.getDatabaseDdlCallable().futureCall(request, context)));
  }

  @Override
  public OperationFuture<Backup, CreateBackupMetadata> createBackup(
      final com.google.cloud.spanner.Backup backupInfo) throws SpannerException {
    final String instanceName = backupInfo.getInstanceId().getName();
    final String databaseName = backupInfo.getDatabase().getName();
    final String backupId = backupInfo.getId().getBackup();
    final Backup.Builder backupBuilder =
        com.google.spanner.admin.database.v1.Backup.newBuilder()
            .setDatabase(databaseName)
            .setExpireTime(backupInfo.getExpireTime().toProto());
    if (backupInfo.getVersionTime() != null) {
      backupBuilder.setVersionTime(backupInfo.getVersionTime().toProto());
    }
    final Backup backup = backupBuilder.build();

    final CreateBackupRequest.Builder requestBuilder =
        CreateBackupRequest.newBuilder()
            .setParent(instanceName)
            .setBackupId(backupId)
            .setBackup(backup);
    if (backupInfo.getEncryptionConfig() != null) {
      requestBuilder.setEncryptionConfig(
          EncryptionConfigProtoMapper.createBackupEncryptionConfig(
              backupInfo.getEncryptionConfig()));
    }
    final CreateBackupRequest request = requestBuilder.build();
    final OperationFutureCallable<CreateBackupRequest, Backup, CreateBackupMetadata> callable =
        new OperationFutureCallable<>(
            databaseAdminStub.createBackupOperationCallable(),
            request,
            DatabaseAdminGrpc.getCreateBackupMethod(),
            instanceName,
            nextPageToken ->
                listBackupOperations(
                    instanceName,
                    0,
                    String.format(
                        "(metadata.@type:type.googleapis.com/%s) AND (metadata.name:%s)",
                        CreateBackupMetadata.getDescriptor().getFullName(),
                        String.format("%s/backups/%s", instanceName, backupId)),
                    nextPageToken),
            input -> {
              try {
                return input
                    .getMetadata()
                    .unpack(CreateBackupMetadata.class)
                    .getProgress()
                    .getStartTime();
              } catch (InvalidProtocolBufferException e) {
                return null;
              }
            });
    return RetryHelper.runWithRetries(
        callable,
        databaseAdminStubSettings
            .createBackupOperationSettings()
            .getInitialCallSettings()
            .getRetrySettings(),
        new OperationFutureRetryAlgorithm<>(),
        NanoClock.getDefaultClock());
  }

  @Override
  public OperationFuture<Backup, CopyBackupMetadata> copyBackup(
      BackupId sourceBackupId, final com.google.cloud.spanner.Backup destinationBackup)
      throws SpannerException {
    Preconditions.checkNotNull(sourceBackupId);
    Preconditions.checkNotNull(destinationBackup);
    final String instanceName = destinationBackup.getInstanceId().getName();
    final String backupId = destinationBackup.getId().getBackup();

    final CopyBackupRequest.Builder requestBuilder =
        CopyBackupRequest.newBuilder()
            .setParent(instanceName)
            .setBackupId(backupId)
            .setSourceBackup(sourceBackupId.getName())
            .setExpireTime(destinationBackup.getExpireTime().toProto());

    if (destinationBackup.getEncryptionConfig() != null) {
      requestBuilder.setEncryptionConfig(
          EncryptionConfigProtoMapper.copyBackupEncryptionConfig(
              destinationBackup.getEncryptionConfig()));
    }
    final CopyBackupRequest request = requestBuilder.build();
    final OperationFutureCallable<CopyBackupRequest, Backup, CopyBackupMetadata> callable =
        new OperationFutureCallable<>(
            databaseAdminStub.copyBackupOperationCallable(),
            request,
            // calling copy backup method of dbClientImpl
            DatabaseAdminGrpc.getCopyBackupMethod(),
            instanceName,
            nextPageToken ->
                listBackupOperations(
                    instanceName,
                    0,
                    String.format(
                        "(metadata.@type:type.googleapis.com/%s) AND (metadata.name:%s)",
                        CopyBackupMetadata.getDescriptor().getFullName(),
                        String.format("%s/backups/%s", instanceName, backupId)),
                    nextPageToken),
            input -> {
              try {
                return input
                    .getMetadata()
                    .unpack(CopyBackupMetadata.class)
                    .getProgress()
                    .getStartTime();
              } catch (InvalidProtocolBufferException e) {
                return null;
              }
            });
    return RetryHelper.runWithRetries(
        callable,
        databaseAdminStubSettings
            .copyBackupOperationSettings()
            .getInitialCallSettings()
            .getRetrySettings(),
        new OperationFutureRetryAlgorithm<>(),
        NanoClock.getDefaultClock());
  }

  @Override
  public OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabase(final Restore restore) {
    final String databaseInstanceName = restore.getDestination().getInstanceId().getName();
    final String databaseId = restore.getDestination().getDatabase();
    final RestoreDatabaseRequest.Builder requestBuilder =
        RestoreDatabaseRequest.newBuilder()
            .setParent(databaseInstanceName)
            .setDatabaseId(databaseId)
            .setBackup(restore.getSource().getName());
    if (restore.getEncryptionConfig() != null) {
      requestBuilder.setEncryptionConfig(
          EncryptionConfigProtoMapper.restoreDatabaseEncryptionConfig(
              restore.getEncryptionConfig()));
    }

    final OperationFutureCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
        callable =
            new OperationFutureCallable<>(
                databaseAdminStub.restoreDatabaseOperationCallable(),
                requestBuilder.build(),
                DatabaseAdminGrpc.getRestoreDatabaseMethod(),
                databaseInstanceName,
                nextPageToken ->
                    listDatabaseOperations(
                        databaseInstanceName,
                        0,
                        String.format(
                            "(metadata.@type:type.googleapis.com/%s) AND (metadata.name:%s)",
                            RestoreDatabaseMetadata.getDescriptor().getFullName(),
                            String.format("%s/databases/%s", databaseInstanceName, databaseId)),
                        nextPageToken),
                input -> {
                  try {
                    return input
                        .getMetadata()
                        .unpack(RestoreDatabaseMetadata.class)
                        .getProgress()
                        .getStartTime();
                  } catch (InvalidProtocolBufferException e) {
                    return null;
                  }
                });
    return RetryHelper.runWithRetries(
        callable,
        databaseAdminStubSettings
            .restoreDatabaseOperationSettings()
            .getInitialCallSettings()
            .getRetrySettings(),
        new OperationFutureRetryAlgorithm<>(),
        NanoClock.getDefaultClock());
  }

  @Override
  public Backup updateBackup(Backup backup, FieldMask updateMask) {
    acquireAdministrativeRequestsRateLimiter();
    final UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    final GrpcCallContext context =
        newAdminCallContext(backup.getName(), request, DatabaseAdminGrpc.getUpdateBackupMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> databaseAdminStub.updateBackupCallable().call(request, context));
  }

  @Override
  public void deleteBackup(String backupName) {
    acquireAdministrativeRequestsRateLimiter();
    final DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(backupName).build();
    final GrpcCallContext context =
        newAdminCallContext(backupName, request, DatabaseAdminGrpc.getDeleteBackupMethod());
    runWithRetryOnAdministrativeRequestsExceeded(
        () -> {
          databaseAdminStub.deleteBackupCallable().call(request, context);
          return null;
        });
  }

  @Override
  public Backup getBackup(String backupName) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final GetBackupRequest request = GetBackupRequest.newBuilder().setName(backupName).build();
    final GrpcCallContext context =
        newAdminCallContext(backupName, request, DatabaseAdminGrpc.getGetBackupMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.getBackupCallable().futureCall(request, context)));
  }

  @Override
  public Operation getOperation(String name) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    final GrpcCallContext context =
        newAdminCallContext(name, request, OperationsGrpc.getGetOperationMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () ->
            get(
                databaseAdminStub
                    .getOperationsStub()
                    .getOperationCallable()
                    .futureCall(request, context)));
  }

  @Override
  public void cancelOperation(String name) throws SpannerException {
    acquireAdministrativeRequestsRateLimiter();
    final CancelOperationRequest request =
        CancelOperationRequest.newBuilder().setName(name).build();
    final GrpcCallContext context =
        newAdminCallContext(name, request, OperationsGrpc.getCancelOperationMethod());
    runWithRetryOnAdministrativeRequestsExceeded(
        () -> {
          get(
              databaseAdminStub
                  .getOperationsStub()
                  .cancelOperationCallable()
                  .futureCall(request, context));
          return null;
        });
  }

  @Override
  public List<Session> batchCreateSessions(
      String databaseName,
      int sessionCount,
      @Nullable String databaseRole,
      @Nullable Map<String, String> labels,
      @Nullable Map<Option, ?> options)
      throws SpannerException {
    BatchCreateSessionsRequest.Builder requestBuilder =
        BatchCreateSessionsRequest.newBuilder()
            .setDatabase(databaseName)
            .setSessionCount(sessionCount);
    Session.Builder sessionBuilder = Session.newBuilder();
    if (labels != null && !labels.isEmpty()) {
      sessionBuilder.putAllLabels(labels);
    }
    if (databaseRole != null && !databaseRole.isEmpty()) {
      sessionBuilder.setCreatorRole(databaseRole);
    }
    requestBuilder.setSessionTemplate(sessionBuilder);
    BatchCreateSessionsRequest request = requestBuilder.build();
    GrpcCallContext context =
        newCallContext(
            options, databaseName, request, SpannerGrpc.getBatchCreateSessionsMethod(), true);
    return get(spannerStub.batchCreateSessionsCallable().futureCall(request, context))
        .getSessionList();
  }

  @Override
  public Session createSession(
      String databaseName,
      @Nullable String databaseRole,
      @Nullable Map<String, String> labels,
      @Nullable Map<Option, ?> options)
      throws SpannerException {
    // By default, sessions are not multiplexed
    return createSession(databaseName, databaseRole, labels, options, false);
  }

  @Override
  public Session createSession(
      String databaseName,
      @Nullable String databaseRole,
      @Nullable Map<String, String> labels,
      @Nullable Map<Option, ?> options,
      boolean isMultiplexed)
      throws SpannerException {
    CreateSessionRequest.Builder requestBuilder =
        CreateSessionRequest.newBuilder().setDatabase(databaseName);
    Session.Builder sessionBuilder = Session.newBuilder();
    if (labels != null && !labels.isEmpty()) {
      sessionBuilder.putAllLabels(labels);
    }
    if (databaseRole != null && !databaseRole.isEmpty()) {
      sessionBuilder.setCreatorRole(databaseRole);
    }
    sessionBuilder.setMultiplexed(isMultiplexed);
    requestBuilder.setSession(sessionBuilder);
    CreateSessionRequest request = requestBuilder.build();
    GrpcCallContext context =
        newCallContext(options, databaseName, request, SpannerGrpc.getCreateSessionMethod(), true);
    return get(spannerStub.createSessionCallable().futureCall(request, context));
  }

  @Override
  public void deleteSession(String sessionName, @Nullable Map<Option, ?> options)
      throws SpannerException {
    get(asyncDeleteSession(sessionName, options));
  }

  @Override
  public ApiFuture<Empty> asyncDeleteSession(String sessionName, @Nullable Map<Option, ?> options) {
    DeleteSessionRequest request = DeleteSessionRequest.newBuilder().setName(sessionName).build();
    GrpcCallContext context =
        newCallContext(options, sessionName, request, SpannerGrpc.getDeleteSessionMethod());
    return spannerStub.deleteSessionCallable().futureCall(request, context);
  }

  @Override
  public RetrySettings getReadRetrySettings() {
    return readRetrySettings;
  }

  @Override
  public Set<Code> getReadRetryableCodes() {
    return readRetryableCodes;
  }

  @Override
  public StreamingCall read(
      ReadRequest request,
      ResultStreamConsumer consumer,
      @Nullable Map<Option, ?> options,
      XGoogSpannerRequestId requestId,
      boolean routeToLeader) {
    GrpcCallContext context =
        newCallContext(
            options,
            requestId,
            request.getSession(),
            request,
            SpannerGrpc.getReadMethod(),
            routeToLeader);
    SpannerResponseObserver responseObserver = new SpannerResponseObserver(consumer);
    spannerStub.streamingReadCallable().call(request, responseObserver, context);
    return new GrpcStreamingCall(context, responseObserver.getController());
  }

  @Override
  public RetrySettings getExecuteQueryRetrySettings() {
    return executeQueryRetrySettings;
  }

  @Override
  public Set<Code> getExecuteQueryRetryableCodes() {
    return executeQueryRetryableCodes;
  }

  @Override
  public ResultSet executeQuery(
      ExecuteSqlRequest request, @Nullable Map<Option, ?> options, boolean routeToLeader) {
    return get(executeQueryAsync(request, options, routeToLeader));
  }

  @Override
  public ApiFuture<ResultSet> executeQueryAsync(
      ExecuteSqlRequest request, @Nullable Map<Option, ?> options, boolean routeToLeader) {
    GrpcCallContext context =
        newCallContext(
            options,
            request.getSession(),
            request,
            SpannerGrpc.getExecuteSqlMethod(),
            routeToLeader);
    return spannerStub.executeSqlCallable().futureCall(request, context);
  }

  @Override
  public ResultSet executePartitionedDml(
      ExecuteSqlRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context =
        newCallContext(
            options, request.getSession(), request, SpannerGrpc.getExecuteSqlMethod(), true);
    return get(partitionedDmlStub.executeSqlCallable().futureCall(request, context));
  }

  @Override
  public RetrySettings getPartitionedDmlRetrySettings() {
    return partitionedDmlRetrySettings;
  }

  @Override
  public ServerStream<PartialResultSet> executeStreamingPartitionedDml(
      ExecuteSqlRequest request,
      Map<Option, ?> options,
      XGoogSpannerRequestId requestId,
      Duration timeout) {
    GrpcCallContext context =
        newCallContext(
            options,
            requestId,
            request.getSession(),
            request,
            SpannerGrpc.getExecuteStreamingSqlMethod(),
            true);
    // Override any timeout settings that might have been set on the call context.
    context = context.withTimeoutDuration(timeout).withStreamWaitTimeoutDuration(timeout);
    return partitionedDmlStub.executeStreamingSqlCallable().call(request, context);
  }

  @Override
  public ServerStream<BatchWriteResponse> batchWriteAtLeastOnce(
      BatchWriteRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context =
        newCallContext(options, request.getSession(), request, SpannerGrpc.getBatchWriteMethod());
    return spannerStub.batchWriteCallable().call(request, context);
  }

  @Override
  public StreamingCall executeQuery(
      ExecuteSqlRequest request,
      ResultStreamConsumer consumer,
      @Nullable Map<Option, ?> options,
      XGoogSpannerRequestId requestId,
      boolean routeToLeader) {
    GrpcCallContext context =
        newCallContext(
            options,
            requestId,
            request.getSession(),
            request,
            SpannerGrpc.getExecuteStreamingSqlMethod(),
            routeToLeader);

    SpannerResponseObserver responseObserver = new SpannerResponseObserver(consumer);
    spannerStub.executeStreamingSqlCallable().call(request, responseObserver, context);
    return new GrpcStreamingCall(context, responseObserver.getController());
  }

  @Override
  public ExecuteBatchDmlResponse executeBatchDml(
      ExecuteBatchDmlRequest request, @Nullable Map<Option, ?> options) {
    return get(executeBatchDmlAsync(request, options));
  }

  @Override
  public ApiFuture<ExecuteBatchDmlResponse> executeBatchDmlAsync(
      ExecuteBatchDmlRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context =
        newCallContext(
            options, request.getSession(), request, SpannerGrpc.getExecuteBatchDmlMethod(), true);
    return spannerStub.executeBatchDmlCallable().futureCall(request, context);
  }

  @Override
  public ApiFuture<Transaction> beginTransactionAsync(
      BeginTransactionRequest request, @Nullable Map<Option, ?> options, boolean routeToLeader) {
    GrpcCallContext context =
        newCallContext(
            options,
            request.getSession(),
            request,
            SpannerGrpc.getBeginTransactionMethod(),
            routeToLeader);
    return spannerStub.beginTransactionCallable().futureCall(request, context);
  }

  @Override
  public Transaction beginTransaction(
      BeginTransactionRequest request, @Nullable Map<Option, ?> options, boolean routeToLeader)
      throws SpannerException {
    return get(beginTransactionAsync(request, options, routeToLeader));
  }

  @Override
  public ApiFuture<CommitResponse> commitAsync(
      CommitRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context =
        newCallContext(options, request.getSession(), request, SpannerGrpc.getCommitMethod(), true);
    return spannerStub.commitCallable().futureCall(request, context);
  }

  @Override
  public CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options)
      throws SpannerException {
    return get(commitAsync(commitRequest, options));
  }

  @Override
  public RetrySettings getCommitRetrySettings() {
    return commitRetrySettings;
  }

  @Override
  public ApiFuture<Empty> rollbackAsync(RollbackRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context =
        newCallContext(
            options, request.getSession(), request, SpannerGrpc.getRollbackMethod(), true);
    return spannerStub.rollbackCallable().futureCall(request, context);
  }

  @Override
  public void rollback(RollbackRequest request, @Nullable Map<Option, ?> options)
      throws SpannerException {
    get(rollbackAsync(request, options));
  }

  @Override
  public PartitionResponse partitionQuery(
      PartitionQueryRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    GrpcCallContext context =
        newCallContext(
            options, request.getSession(), request, SpannerGrpc.getPartitionQueryMethod(), true);
    return get(spannerStub.partitionQueryCallable().futureCall(request, context));
  }

  @Override
  public PartitionResponse partitionRead(
      PartitionReadRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    GrpcCallContext context =
        newCallContext(
            options, request.getSession(), request, SpannerGrpc.getPartitionReadMethod(), true);
    return get(spannerStub.partitionReadCallable().futureCall(request, context));
  }

  @Override
  public Policy getDatabaseAdminIAMPolicy(String resource, @Nullable GetPolicyOptions options) {
    acquireAdministrativeRequestsRateLimiter();
    GetIamPolicyRequest.Builder builder = GetIamPolicyRequest.newBuilder().setResource(resource);
    if (options != null) {
      builder.setOptions(options);
    }
    final GetIamPolicyRequest request = builder.build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, DatabaseAdminGrpc.getGetIamPolicyMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.getIamPolicyCallable().futureCall(request, context)));
  }

  @Override
  public Policy setDatabaseAdminIAMPolicy(String resource, Policy policy) {
    acquireAdministrativeRequestsRateLimiter();
    final SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, DatabaseAdminGrpc.getSetIamPolicyMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.setIamPolicyCallable().futureCall(request, context)));
  }

  @Override
  public TestIamPermissionsResponse testDatabaseAdminIAMPermissions(
      String resource, Iterable<String> permissions) {
    acquireAdministrativeRequestsRateLimiter();
    final TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, DatabaseAdminGrpc.getTestIamPermissionsMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(databaseAdminStub.testIamPermissionsCallable().futureCall(request, context)));
  }

  @Override
  public Policy getInstanceAdminIAMPolicy(String resource) {
    acquireAdministrativeRequestsRateLimiter();
    final GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder().setResource(resource).build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, InstanceAdminGrpc.getGetIamPolicyMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(instanceAdminStub.getIamPolicyCallable().futureCall(request, context)));
  }

  @Override
  public Policy setInstanceAdminIAMPolicy(String resource, Policy policy) {
    acquireAdministrativeRequestsRateLimiter();
    final SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, InstanceAdminGrpc.getSetIamPolicyMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(instanceAdminStub.setIamPolicyCallable().futureCall(request, context)));
  }

  @Override
  public TestIamPermissionsResponse testInstanceAdminIAMPermissions(
      String resource, Iterable<String> permissions) {
    acquireAdministrativeRequestsRateLimiter();
    final TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    final GrpcCallContext context =
        newCallContext(null, resource, request, InstanceAdminGrpc.getTestIamPermissionsMethod());
    return runWithRetryOnAdministrativeRequestsExceeded(
        () -> get(instanceAdminStub.testIamPermissionsCallable().futureCall(request, context)));
  }

  /** Gets the result of an async RPC call, handling any exceptions encountered. */
  private static <T> T get(final Future<T> future) throws SpannerException {
    final Context context = Context.current();
    try {
      return future.get();
    } catch (InterruptedException e) {
      // We are the sole consumer of the future, so cancel it.
      future.cancel(true);
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } catch (ExecutionException e) {
      throw asSpannerException(e.getCause());
    } catch (CancellationException e) {
      throw newSpannerException(context, e);
    } catch (Exception exception) {
      throw asSpannerException(exception);
    }
  }

  private GrpcCallContext createBaseCallContext() {
    GrpcCallContext context = GrpcCallContext.createDefault();
    if (compressorName != null) {
      // This sets the compressor for Client -> Server.
      context = context.withCallOptions(context.getCallOptions().withCompression(compressorName));
    }
    if (endToEndTracingEnabled) {
      context = context.withExtraHeaders(metadataProvider.newEndToEndTracingHeader());
    }
    if (isEnableAFEServerTiming()) {
      context = context.withExtraHeaders(metadataProvider.newAfeServerTimingHeader());
    }
    return context
        .withStreamWaitTimeoutDuration(waitTimeout)
        .withStreamIdleTimeoutDuration(idleTimeout);
  }

  // Before removing this method, please verify with a code owner that it is not used
  // in any internal testing infrastructure.
  @VisibleForTesting
  @Deprecated
  GrpcCallContext newCallContext(@Nullable Map<Option, ?> options, String resource) {
    return newCallContext(options, resource, null, null);
  }

  private <ReqT, RespT> GrpcCallContext newAdminCallContext(
      String resource, ReqT request, MethodDescriptor<ReqT, RespT> method) {
    return newCallContext(null, resource, request, method, false);
  }

  @VisibleForTesting
  <ReqT, RespT> GrpcCallContext newCallContext(
      @Nullable Map<Option, ?> options,
      String resource,
      ReqT request,
      MethodDescriptor<ReqT, RespT> method) {
    return newCallContext(options, resource, request, method, false);
  }

  @VisibleForTesting
  <ReqT, RespT> GrpcCallContext newCallContext(
      @Nullable Map<Option, ?> options,
      String resource,
      ReqT request,
      MethodDescriptor<ReqT, RespT> method,
      boolean routeToLeader) {
    return newCallContext(options, /* requestId= */ null, resource, request, method, routeToLeader);
  }

  @VisibleForTesting
  <ReqT, RespT> GrpcCallContext newCallContext(
      @Nullable Map<Option, ?> options,
      @Nullable XGoogSpannerRequestId requestId,
      String resource,
      ReqT request,
      MethodDescriptor<ReqT, RespT> method,
      boolean routeToLeader) {
    GrpcCallContext context = this.baseGrpcCallContext;
    Long affinity = options == null ? null : Option.CHANNEL_HINT.getLong(options);
    if (affinity != null) {
      if (this.isGrpcGcpExtensionEnabled) {
        // Set channel affinity in gRPC-GCP.
        String affinityKey;
        if (this.isDynamicChannelPoolEnabled) {
          // When dynamic channel pooling is enabled, we use the raw affinity value as the key.
          // This allows grpc-gcp to use round-robin for new keys, enabling new channels
          // (created during scale-up) to receive requests. The affinity key lifetime setting
          // ensures the affinity map doesn't grow unbounded.
          affinityKey = String.valueOf(affinity);
        } else {
          // When DCP is disabled, compute bounded channel hint to prevent
          // gRPC-GCP affinity map from getting unbounded.
          int boundedChannelHint = affinity.intValue() % this.numChannels;
          affinityKey = String.valueOf(boundedChannelHint);
        }
        context =
            context.withCallOptions(
                context.getCallOptions().withOption(GcpManagedChannel.AFFINITY_KEY, affinityKey));
      } else {
        // Set channel affinity in GAX.
        context = context.withChannelAffinity(affinity.intValue());
      }
    }
    // When grpc-gcp extension with dynamic channel pooling is enabled, the actual channel ID
    // will be set by RequestIdInterceptor after grpc-gcp selects the channel.
    // Set to 0 (unknown) here as a placeholder.
    int requestIdChannel =
        (this.isGrpcGcpExtensionEnabled && this.isDynamicChannelPoolEnabled)
            ? 0
            : convertToRequestIdChannelNumber(affinity);
    if (requestId == null) {
      requestId = requestIdCreator.nextRequestId(requestIdChannel);
    } else {
      requestId.setChannelId(requestIdChannel);
    }
    context =
        context.withCallOptions(
            context.getCallOptions().withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId));
    context = context.withExtraHeaders(metadataProvider.newExtraHeaders(resource, projectName));
    if (routeToLeader && leaderAwareRoutingEnabled) {
      context = context.withExtraHeaders(metadataProvider.newRouteToLeaderHeader());
    }
    if (callCredentialsProvider != null) {
      CallCredentials callCredentials = callCredentialsProvider.getCallCredentials();
      if (callCredentials != null) {
        context =
            context.withCallOptions(context.getCallOptions().withCallCredentials(callCredentials));
      }
    }
    CallContextConfigurator configurator = SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY.get();
    ApiCallContext apiCallContextFromContext = null;
    if (configurator != null) {
      apiCallContextFromContext = configurator.configure(context, request, method);
    }
    return (GrpcCallContext) context.merge(apiCallContextFromContext);
  }

  @Override
  public RequestIdCreator getRequestIdCreator() {
    return this.requestIdCreator;
  }

  private int convertToRequestIdChannelNumber(@Nullable Long affinity) {
    if (affinity == null) {
      return 0;
    }
    int requestIdChannel = affinity.intValue();
    requestIdChannel = requestIdChannel == Integer.MAX_VALUE ? 0 : Math.abs(requestIdChannel);
    // Start counting at 1, to distinguish between '0 == Unknown and >0 == known'.
    return requestIdChannel % this.numChannels + 1;
  }

  void registerResponseObserver(SpannerResponseObserver responseObserver) {
    responseObservers.add(responseObserver);
  }

  void unregisterResponseObserver(SpannerResponseObserver responseObserver) {
    responseObservers.remove(responseObserver);
  }

  void closeResponseObservers() {
    responseObservers.forEach(SpannerResponseObserver::close);
    responseObservers.clear();
  }

  @InternalApi
  @VisibleForTesting
  public int getNumActiveResponseObservers() {
    return responseObservers.size();
  }

  @Override
  public void shutdown() {
    this.rpcIsClosed = true;
    closeResponseObservers();
    if (this.spannerStub != null) {
      this.spannerStub.close();
      this.partitionedDmlStub.close();
      this.instanceAdminStub.close();
      this.databaseAdminStub.close();
      this.spannerWatchdog.shutdown();

      try {
        this.spannerStub.awaitTermination(10L, TimeUnit.SECONDS);
        this.partitionedDmlStub.awaitTermination(10L, TimeUnit.SECONDS);
        this.instanceAdminStub.awaitTermination(10L, TimeUnit.SECONDS);
        this.databaseAdminStub.awaitTermination(10L, TimeUnit.SECONDS);
        this.spannerWatchdog.awaitTermination(10L, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw SpannerExceptionFactory.propagateInterrupt(e);
      }
    }
  }

  public void shutdownNow() {
    this.rpcIsClosed = true;
    closeResponseObservers();
    this.spannerStub.close();
    this.partitionedDmlStub.close();
    this.instanceAdminStub.close();
    this.databaseAdminStub.close();
    this.spannerWatchdog.shutdown();

    this.spannerStub.shutdownNow();
    this.partitionedDmlStub.shutdownNow();
    this.instanceAdminStub.shutdownNow();
    this.databaseAdminStub.shutdownNow();
    this.spannerWatchdog.shutdownNow();
  }

  @Override
  public boolean isClosed() {
    return rpcIsClosed;
  }

  @Override
  public DatabaseAdminStubSettings getDatabaseAdminStubSettings() {
    return databaseAdminStubSettings;
  }

  @Override
  public InstanceAdminStubSettings getInstanceAdminStubSettings() {
    return instanceAdminStubSettings;
  }

  private static final class GrpcStreamingCall implements StreamingCall {
    private final ApiCallContext callContext;
    private final StreamController controller;

    GrpcStreamingCall(ApiCallContext callContext, StreamController controller) {
      this.callContext = callContext;
      this.controller = controller;
    }

    @Override
    public ApiCallContext getCallContext() {
      return callContext;
    }

    @Override
    public void request(int numMessages) {
      controller.request(numMessages);
    }

    @Override
    public void cancel(@Nullable String message) {
      controller.cancel();
    }
  }

  /**
   * A {@code ResponseObserver} that exposes the {@code StreamController} and delegates callbacks to
   * the {@link ResultStreamConsumer}.
   */
  private class SpannerResponseObserver implements ResponseObserver<PartialResultSet> {

    private StreamController controller;
    private final ResultStreamConsumer consumer;

    public SpannerResponseObserver(ResultStreamConsumer consumer) {
      this.consumer = consumer;
    }

    void close() {
      if (this.controller != null) {
        this.controller.cancel();
      }
    }

    @Override
    public void onStart(StreamController controller) {
      // Disable the auto flow control to allow client library
      // set the number of messages it prefers to request
      controller.disableAutoInboundFlowControl();
      this.controller = controller;
      if (this.consumer.cancelQueryWhenClientIsClosed()) {
        registerResponseObserver(this);
      }
    }

    @Override
    public void onResponse(PartialResultSet response) {
      consumer.onPartialResultSet(response);
    }

    @Override
    public void onError(Throwable t) {
      // Unregister the response observer when the query has completed with an error.
      if (this.consumer.cancelQueryWhenClientIsClosed()) {
        unregisterResponseObserver(this);
      }
      consumer.onError(asSpannerException(t));
    }

    @Override
    public void onComplete() {
      // Unregister the response observer when the query has completed normally.
      if (this.consumer.cancelQueryWhenClientIsClosed()) {
        unregisterResponseObserver(this);
      }
      consumer.onCompleted();
    }

    StreamController getController() {
      return Preconditions.checkNotNull(this.controller);
    }
  }

  private static Duration systemProperty(String name, int defaultValue) {
    String stringValue = System.getProperty(name, "");
    return Duration.ofSeconds(stringValue.isEmpty() ? defaultValue : Integer.parseInt(stringValue));
  }

  // Wrapper class to build the GcpFallbackChannel using GAX's configuration
  private static class FallbackChannelBuilder
      extends ForwardingChannelBuilder2<FallbackChannelBuilder> {
    private final GcpFallbackChannelOptions options;

    private final GcpManagedChannelBuilder primaryGcpBuilder;
    private final GcpManagedChannelBuilder fallbackGcpBuilder;

    private FallbackChannelBuilder(
        GcpManagedChannelBuilder primary,
        GcpManagedChannelBuilder fallback,
        GcpFallbackChannelOptions options) {
      this.primaryGcpBuilder = primary;
      this.fallbackGcpBuilder = fallback;
      this.options = options;
    }

    /**
     * Delegates all configuration calls (e.g., interceptors, userAgent) to the primary builder.
     * This ensures the primary channel receives all of GAX's standard configuration.
     */
    @Override
    protected ManagedChannelBuilder<?> delegate() {
      return primaryGcpBuilder;
    }

    /**
     * Overrides the build method to return our custom GcpFallbackChannel instead of a standard gRPC
     * channel.
     */
    @Override
    public ManagedChannel build() {
      return new GcpFallbackChannel(options, primaryGcpBuilder, fallbackGcpBuilder);
    }
  }
}
