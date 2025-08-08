/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

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
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.CreateWorkerPoolRequest;
import com.google.cloud.run.v2.DeleteWorkerPoolRequest;
import com.google.cloud.run.v2.GetWorkerPoolRequest;
import com.google.cloud.run.v2.ListWorkerPoolsRequest;
import com.google.cloud.run.v2.ListWorkerPoolsResponse;
import com.google.cloud.run.v2.UpdateWorkerPoolRequest;
import com.google.cloud.run.v2.WorkerPool;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkerPoolsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (run.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getWorkerPool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkerPoolsStubSettings.Builder workerPoolsSettingsBuilder =
 *     WorkerPoolsStubSettings.newBuilder();
 * workerPoolsSettingsBuilder
 *     .getWorkerPoolSettings()
 *     .setRetrySettings(
 *         workerPoolsSettingsBuilder
 *             .getWorkerPoolSettings()
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
 * WorkerPoolsStubSettings workerPoolsSettings = workerPoolsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createWorkerPool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkerPoolsStubSettings.Builder workerPoolsSettingsBuilder =
 *     WorkerPoolsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * workerPoolsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkerPoolsStubSettings extends StubSettings<WorkerPoolsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings;
  private final OperationCallSettings<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationSettings;
  private final UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
  private final PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings;
  private final UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings;
  private final OperationCallSettings<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationSettings;
  private final UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings;
  private final OperationCallSettings<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool>
      LIST_WORKER_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkerPoolsRequest injectToken(
                ListWorkerPoolsRequest payload, String token) {
              return ListWorkerPoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkerPoolsRequest injectPageSize(
                ListWorkerPoolsRequest payload, int pageSize) {
              return ListWorkerPoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkerPoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkerPoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkerPool> extractResources(ListWorkerPoolsResponse payload) {
              return payload.getWorkerPoolsList();
            }
          };

  private static final PagedListResponseFactory<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      LIST_WORKER_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkerPoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> callable,
                ListWorkerPoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkerPoolsResponse> futureResponse) {
              PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> pageContext =
                  PageContext.create(callable, LIST_WORKER_POOLS_PAGE_STR_DESC, request, context);
              return ListWorkerPoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings() {
    return createWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public OperationCallSettings<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationSettings() {
    return createWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getWorkerPool. */
  public UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
    return getWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to listWorkerPools. */
  public PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings() {
    return listWorkerPoolsSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings() {
    return updateWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public OperationCallSettings<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationSettings() {
    return updateWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings() {
    return deleteWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public OperationCallSettings<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationSettings() {
    return deleteWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public WorkerPoolsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcWorkerPoolsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonWorkerPoolsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "run";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "run.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "run.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(WorkerPoolsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(WorkerPoolsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkerPoolsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected WorkerPoolsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createWorkerPoolSettings = settingsBuilder.createWorkerPoolSettings().build();
    createWorkerPoolOperationSettings = settingsBuilder.createWorkerPoolOperationSettings().build();
    getWorkerPoolSettings = settingsBuilder.getWorkerPoolSettings().build();
    listWorkerPoolsSettings = settingsBuilder.listWorkerPoolsSettings().build();
    updateWorkerPoolSettings = settingsBuilder.updateWorkerPoolSettings().build();
    updateWorkerPoolOperationSettings = settingsBuilder.updateWorkerPoolOperationSettings().build();
    deleteWorkerPoolSettings = settingsBuilder.deleteWorkerPoolSettings().build();
    deleteWorkerPoolOperationSettings = settingsBuilder.deleteWorkerPoolOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for WorkerPoolsStubSettings. */
  public static class Builder extends StubSettings.Builder<WorkerPoolsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings;
    private final OperationCallSettings.Builder<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
        createWorkerPoolOperationSettings;
    private final UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
    private final PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings;
    private final UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings;
    private final OperationCallSettings.Builder<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
        updateWorkerPoolOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings;
    private final OperationCallSettings.Builder<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
        deleteWorkerPoolOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      getWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkerPoolsSettings = PagedCallSettings.newBuilder(LIST_WORKER_POOLS_PAGE_STR_FACT);
      updateWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              listWorkerPoolsSettings,
              updateWorkerPoolSettings,
              deleteWorkerPoolSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(WorkerPoolsStubSettings settings) {
      super(settings);

      createWorkerPoolSettings = settings.createWorkerPoolSettings.toBuilder();
      createWorkerPoolOperationSettings = settings.createWorkerPoolOperationSettings.toBuilder();
      getWorkerPoolSettings = settings.getWorkerPoolSettings.toBuilder();
      listWorkerPoolsSettings = settings.listWorkerPoolsSettings.toBuilder();
      updateWorkerPoolSettings = settings.updateWorkerPoolSettings.toBuilder();
      updateWorkerPoolOperationSettings = settings.updateWorkerPoolOperationSettings.toBuilder();
      deleteWorkerPoolSettings = settings.deleteWorkerPoolSettings.toBuilder();
      deleteWorkerPoolOperationSettings = settings.deleteWorkerPoolOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              listWorkerPoolsSettings,
              updateWorkerPoolSettings,
              deleteWorkerPoolSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
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
          .createWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkerPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkerPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(WorkerPool.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkerPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(WorkerPool.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkerPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(WorkerPool.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings() {
      return createWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public OperationCallSettings.Builder<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
        createWorkerPoolOperationSettings() {
      return createWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkerPool. */
    public UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
      return getWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkerPools. */
    public PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings() {
      return listWorkerPoolsSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings() {
      return updateWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public OperationCallSettings.Builder<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
        updateWorkerPoolOperationSettings() {
      return updateWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings() {
      return deleteWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public OperationCallSettings.Builder<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
        deleteWorkerPoolOperationSettings() {
      return deleteWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public WorkerPoolsStubSettings build() throws IOException {
      return new WorkerPoolsStubSettings(this);
    }
  }
}
