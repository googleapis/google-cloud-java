/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.v1.stub;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
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
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SpannerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (spanner.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSession:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpannerStubSettings.Builder spannerSettingsBuilder = SpannerStubSettings.newBuilder();
 * spannerSettingsBuilder
 *     .createSessionSettings()
 *     .setRetrySettings(
 *         spannerSettingsBuilder
 *             .createSessionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * SpannerStubSettings spannerSettings = spannerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class SpannerStubSettings extends StubSettings<SpannerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/spanner.data")
          .build();

  private final UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings;
  private final UnaryCallSettings<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsSettings;
  private final UnaryCallSettings<GetSessionRequest, Session> getSessionSettings;
  private final PagedCallSettings<
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings;
  private final UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings;
  private final UnaryCallSettings<ExecuteSqlRequest, ResultSet> executeSqlSettings;
  private final ServerStreamingCallSettings<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlSettings;
  private final UnaryCallSettings<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlSettings;
  private final UnaryCallSettings<ReadRequest, ResultSet> readSettings;
  private final ServerStreamingCallSettings<ReadRequest, PartialResultSet> streamingReadSettings;
  private final UnaryCallSettings<BeginTransactionRequest, Transaction> beginTransactionSettings;
  private final UnaryCallSettings<CommitRequest, CommitResponse> commitSettings;
  private final UnaryCallSettings<RollbackRequest, Empty> rollbackSettings;
  private final UnaryCallSettings<PartitionQueryRequest, PartitionResponse> partitionQuerySettings;
  private final UnaryCallSettings<PartitionReadRequest, PartitionResponse> partitionReadSettings;
  private final ServerStreamingCallSettings<BatchWriteRequest, BatchWriteResponse>
      batchWriteSettings;

  private static final PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>
      LIST_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSessionsRequest injectToken(ListSessionsRequest payload, String token) {
              return ListSessionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSessionsRequest injectPageSize(ListSessionsRequest payload, int pageSize) {
              return ListSessionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Session> extractResources(ListSessionsResponse payload) {
              return payload.getSessionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      LIST_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>() {
            @Override
            public ApiFuture<ListSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSessionsRequest, ListSessionsResponse> callable,
                ListSessionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSessionsResponse> futureResponse) {
              PageContext<ListSessionsRequest, ListSessionsResponse, Session> pageContext =
                  PageContext.create(callable, LIST_SESSIONS_PAGE_STR_DESC, request, context);
              return ListSessionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSession. */
  public UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings() {
    return createSessionSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateSessions. */
  public UnaryCallSettings<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsSettings() {
    return batchCreateSessionsSettings;
  }

  /** Returns the object with the settings used for calls to getSession. */
  public UnaryCallSettings<GetSessionRequest, Session> getSessionSettings() {
    return getSessionSettings;
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return listSessionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings() {
    return deleteSessionSettings;
  }

  /** Returns the object with the settings used for calls to executeSql. */
  public UnaryCallSettings<ExecuteSqlRequest, ResultSet> executeSqlSettings() {
    return executeSqlSettings;
  }

  /** Returns the object with the settings used for calls to executeStreamingSql. */
  public ServerStreamingCallSettings<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlSettings() {
    return executeStreamingSqlSettings;
  }

  /** Returns the object with the settings used for calls to executeBatchDml. */
  public UnaryCallSettings<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlSettings() {
    return executeBatchDmlSettings;
  }

  /** Returns the object with the settings used for calls to read. */
  public UnaryCallSettings<ReadRequest, ResultSet> readSettings() {
    return readSettings;
  }

  /** Returns the object with the settings used for calls to streamingRead. */
  public ServerStreamingCallSettings<ReadRequest, PartialResultSet> streamingReadSettings() {
    return streamingReadSettings;
  }

  /** Returns the object with the settings used for calls to beginTransaction. */
  public UnaryCallSettings<BeginTransactionRequest, Transaction> beginTransactionSettings() {
    return beginTransactionSettings;
  }

  /** Returns the object with the settings used for calls to commit. */
  public UnaryCallSettings<CommitRequest, CommitResponse> commitSettings() {
    return commitSettings;
  }

  /** Returns the object with the settings used for calls to rollback. */
  public UnaryCallSettings<RollbackRequest, Empty> rollbackSettings() {
    return rollbackSettings;
  }

  /** Returns the object with the settings used for calls to partitionQuery. */
  public UnaryCallSettings<PartitionQueryRequest, PartitionResponse> partitionQuerySettings() {
    return partitionQuerySettings;
  }

  /** Returns the object with the settings used for calls to partitionRead. */
  public UnaryCallSettings<PartitionReadRequest, PartitionResponse> partitionReadSettings() {
    return partitionReadSettings;
  }

  /** Returns the object with the settings used for calls to batchWrite. */
  public ServerStreamingCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteSettings() {
    return batchWriteSettings;
  }

  public SpannerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSpannerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSpannerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "spanner";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "spanner.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "spanner.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SpannerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SpannerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpannerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected SpannerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSessionSettings = settingsBuilder.createSessionSettings().build();
    batchCreateSessionsSettings = settingsBuilder.batchCreateSessionsSettings().build();
    getSessionSettings = settingsBuilder.getSessionSettings().build();
    listSessionsSettings = settingsBuilder.listSessionsSettings().build();
    deleteSessionSettings = settingsBuilder.deleteSessionSettings().build();
    executeSqlSettings = settingsBuilder.executeSqlSettings().build();
    executeStreamingSqlSettings = settingsBuilder.executeStreamingSqlSettings().build();
    executeBatchDmlSettings = settingsBuilder.executeBatchDmlSettings().build();
    readSettings = settingsBuilder.readSettings().build();
    streamingReadSettings = settingsBuilder.streamingReadSettings().build();
    beginTransactionSettings = settingsBuilder.beginTransactionSettings().build();
    commitSettings = settingsBuilder.commitSettings().build();
    rollbackSettings = settingsBuilder.rollbackSettings().build();
    partitionQuerySettings = settingsBuilder.partitionQuerySettings().build();
    partitionReadSettings = settingsBuilder.partitionReadSettings().build();
    batchWriteSettings = settingsBuilder.batchWriteSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-spanner")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for SpannerStubSettings. */
  public static class Builder extends StubSettings.Builder<SpannerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings;
    private final UnaryCallSettings.Builder<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
        batchCreateSessionsSettings;
    private final UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings;
    private final PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings;
    private final UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings;
    private final UnaryCallSettings.Builder<ExecuteSqlRequest, ResultSet> executeSqlSettings;
    private final ServerStreamingCallSettings.Builder<ExecuteSqlRequest, PartialResultSet>
        executeStreamingSqlSettings;
    private final UnaryCallSettings.Builder<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
        executeBatchDmlSettings;
    private final UnaryCallSettings.Builder<ReadRequest, ResultSet> readSettings;
    private final ServerStreamingCallSettings.Builder<ReadRequest, PartialResultSet>
        streamingReadSettings;
    private final UnaryCallSettings.Builder<BeginTransactionRequest, Transaction>
        beginTransactionSettings;
    private final UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings;
    private final UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings;
    private final UnaryCallSettings.Builder<PartitionQueryRequest, PartitionResponse>
        partitionQuerySettings;
    private final UnaryCallSettings.Builder<PartitionReadRequest, PartitionResponse>
        partitionReadSettings;
    private final ServerStreamingCallSettings.Builder<BatchWriteRequest, BatchWriteResponse>
        batchWriteSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(250L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(250L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(250L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateSessionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSessionsSettings = PagedCallSettings.newBuilder(LIST_SESSIONS_PAGE_STR_FACT);
      deleteSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      executeSqlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      executeStreamingSqlSettings = ServerStreamingCallSettings.newBuilder();
      executeBatchDmlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamingReadSettings = ServerStreamingCallSettings.newBuilder();
      beginTransactionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rollbackSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      partitionQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      partitionReadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchWriteSettings = ServerStreamingCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSessionSettings,
              batchCreateSessionsSettings,
              getSessionSettings,
              listSessionsSettings,
              deleteSessionSettings,
              executeSqlSettings,
              executeBatchDmlSettings,
              readSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              partitionQuerySettings,
              partitionReadSettings);
      initDefaults(this);
    }

    protected Builder(SpannerStubSettings settings) {
      super(settings);

      createSessionSettings = settings.createSessionSettings.toBuilder();
      batchCreateSessionsSettings = settings.batchCreateSessionsSettings.toBuilder();
      getSessionSettings = settings.getSessionSettings.toBuilder();
      listSessionsSettings = settings.listSessionsSettings.toBuilder();
      deleteSessionSettings = settings.deleteSessionSettings.toBuilder();
      executeSqlSettings = settings.executeSqlSettings.toBuilder();
      executeStreamingSqlSettings = settings.executeStreamingSqlSettings.toBuilder();
      executeBatchDmlSettings = settings.executeBatchDmlSettings.toBuilder();
      readSettings = settings.readSettings.toBuilder();
      streamingReadSettings = settings.streamingReadSettings.toBuilder();
      beginTransactionSettings = settings.beginTransactionSettings.toBuilder();
      commitSettings = settings.commitSettings.toBuilder();
      rollbackSettings = settings.rollbackSettings.toBuilder();
      partitionQuerySettings = settings.partitionQuerySettings.toBuilder();
      partitionReadSettings = settings.partitionReadSettings.toBuilder();
      batchWriteSettings = settings.batchWriteSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSessionSettings,
              batchCreateSessionsSettings,
              getSessionSettings,
              listSessionsSettings,
              deleteSessionSettings,
              executeSqlSettings,
              executeBatchDmlSettings,
              readSettings,
              beginTransactionSettings,
              commitSettings,
              rollbackSettings,
              partitionQuerySettings,
              partitionReadSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .batchCreateSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .getSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .executeSqlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .executeStreamingSqlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .executeBatchDmlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .readSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .streamingReadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .beginTransactionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .commitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .rollbackSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .partitionQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .partitionReadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .batchWriteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createSession. */
    public UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings() {
      return createSessionSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateSessions. */
    public UnaryCallSettings.Builder<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
        batchCreateSessionsSettings() {
      return batchCreateSessionsSettings;
    }

    /** Returns the builder for the settings used for calls to getSession. */
    public UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings() {
      return getSessionSettings;
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return listSessionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings() {
      return deleteSessionSettings;
    }

    /** Returns the builder for the settings used for calls to executeSql. */
    public UnaryCallSettings.Builder<ExecuteSqlRequest, ResultSet> executeSqlSettings() {
      return executeSqlSettings;
    }

    /** Returns the builder for the settings used for calls to executeStreamingSql. */
    public ServerStreamingCallSettings.Builder<ExecuteSqlRequest, PartialResultSet>
        executeStreamingSqlSettings() {
      return executeStreamingSqlSettings;
    }

    /** Returns the builder for the settings used for calls to executeBatchDml. */
    public UnaryCallSettings.Builder<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
        executeBatchDmlSettings() {
      return executeBatchDmlSettings;
    }

    /** Returns the builder for the settings used for calls to read. */
    public UnaryCallSettings.Builder<ReadRequest, ResultSet> readSettings() {
      return readSettings;
    }

    /** Returns the builder for the settings used for calls to streamingRead. */
    public ServerStreamingCallSettings.Builder<ReadRequest, PartialResultSet>
        streamingReadSettings() {
      return streamingReadSettings;
    }

    /** Returns the builder for the settings used for calls to beginTransaction. */
    public UnaryCallSettings.Builder<BeginTransactionRequest, Transaction>
        beginTransactionSettings() {
      return beginTransactionSettings;
    }

    /** Returns the builder for the settings used for calls to commit. */
    public UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings() {
      return commitSettings;
    }

    /** Returns the builder for the settings used for calls to rollback. */
    public UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings() {
      return rollbackSettings;
    }

    /** Returns the builder for the settings used for calls to partitionQuery. */
    public UnaryCallSettings.Builder<PartitionQueryRequest, PartitionResponse>
        partitionQuerySettings() {
      return partitionQuerySettings;
    }

    /** Returns the builder for the settings used for calls to partitionRead. */
    public UnaryCallSettings.Builder<PartitionReadRequest, PartitionResponse>
        partitionReadSettings() {
      return partitionReadSettings;
    }

    /** Returns the builder for the settings used for calls to batchWrite. */
    public ServerStreamingCallSettings.Builder<BatchWriteRequest, BatchWriteResponse>
        batchWriteSettings() {
      return batchWriteSettings;
    }

    @Override
    public SpannerStubSettings build() throws IOException {
      return new SpannerStubSettings(this);
    }
  }
}
