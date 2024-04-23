/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListReasoningEnginesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest;
import com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngine;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReasoningEngineServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getReasoningEngine to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReasoningEngineServiceStubSettings.Builder reasoningEngineServiceSettingsBuilder =
 *     ReasoningEngineServiceStubSettings.newBuilder();
 * reasoningEngineServiceSettingsBuilder
 *     .getReasoningEngineSettings()
 *     .setRetrySettings(
 *         reasoningEngineServiceSettingsBuilder
 *             .getReasoningEngineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ReasoningEngineServiceStubSettings reasoningEngineServiceSettings =
 *     reasoningEngineServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ReasoningEngineServiceStubSettings
    extends StubSettings<ReasoningEngineServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateReasoningEngineRequest, Operation>
      createReasoningEngineSettings;
  private final OperationCallSettings<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationSettings;
  private final UnaryCallSettings<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineSettings;
  private final PagedCallSettings<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ListReasoningEnginesPagedResponse>
      listReasoningEnginesSettings;
  private final UnaryCallSettings<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineSettings;
  private final OperationCallSettings<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
      LIST_REASONING_ENGINES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReasoningEnginesRequest injectToken(
                ListReasoningEnginesRequest payload, String token) {
              return ListReasoningEnginesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReasoningEnginesRequest injectPageSize(
                ListReasoningEnginesRequest payload, int pageSize) {
              return ListReasoningEnginesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReasoningEnginesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReasoningEnginesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReasoningEngine> extractResources(
                ListReasoningEnginesResponse payload) {
              return payload.getReasoningEnginesList() == null
                  ? ImmutableList.<ReasoningEngine>of()
                  : payload.getReasoningEnginesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ListReasoningEnginesPagedResponse>
      LIST_REASONING_ENGINES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReasoningEnginesRequest,
              ListReasoningEnginesResponse,
              ListReasoningEnginesPagedResponse>() {
            @Override
            public ApiFuture<ListReasoningEnginesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesResponse> callable,
                ListReasoningEnginesRequest request,
                ApiCallContext context,
                ApiFuture<ListReasoningEnginesResponse> futureResponse) {
              PageContext<
                      ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REASONING_ENGINES_PAGE_STR_DESC, request, context);
              return ListReasoningEnginesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createReasoningEngine. */
  public UnaryCallSettings<CreateReasoningEngineRequest, Operation>
      createReasoningEngineSettings() {
    return createReasoningEngineSettings;
  }

  /** Returns the object with the settings used for calls to createReasoningEngine. */
  public OperationCallSettings<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationSettings() {
    return createReasoningEngineOperationSettings;
  }

  /** Returns the object with the settings used for calls to getReasoningEngine. */
  public UnaryCallSettings<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineSettings() {
    return getReasoningEngineSettings;
  }

  /** Returns the object with the settings used for calls to listReasoningEngines. */
  public PagedCallSettings<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ListReasoningEnginesPagedResponse>
      listReasoningEnginesSettings() {
    return listReasoningEnginesSettings;
  }

  /** Returns the object with the settings used for calls to deleteReasoningEngine. */
  public UnaryCallSettings<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineSettings() {
    return deleteReasoningEngineSettings;
  }

  /** Returns the object with the settings used for calls to deleteReasoningEngine. */
  public OperationCallSettings<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationSettings() {
    return deleteReasoningEngineOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public ReasoningEngineServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcReasoningEngineServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ReasoningEngineServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ReasoningEngineServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createReasoningEngineSettings = settingsBuilder.createReasoningEngineSettings().build();
    createReasoningEngineOperationSettings =
        settingsBuilder.createReasoningEngineOperationSettings().build();
    getReasoningEngineSettings = settingsBuilder.getReasoningEngineSettings().build();
    listReasoningEnginesSettings = settingsBuilder.listReasoningEnginesSettings().build();
    deleteReasoningEngineSettings = settingsBuilder.deleteReasoningEngineSettings().build();
    deleteReasoningEngineOperationSettings =
        settingsBuilder.deleteReasoningEngineOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ReasoningEngineServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ReasoningEngineServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateReasoningEngineRequest, Operation>
        createReasoningEngineSettings;
    private final OperationCallSettings.Builder<
            CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
        createReasoningEngineOperationSettings;
    private final UnaryCallSettings.Builder<GetReasoningEngineRequest, ReasoningEngine>
        getReasoningEngineSettings;
    private final PagedCallSettings.Builder<
            ListReasoningEnginesRequest,
            ListReasoningEnginesResponse,
            ListReasoningEnginesPagedResponse>
        listReasoningEnginesSettings;
    private final UnaryCallSettings.Builder<DeleteReasoningEngineRequest, Operation>
        deleteReasoningEngineSettings;
    private final OperationCallSettings.Builder<
            DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
        deleteReasoningEngineOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
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

      createReasoningEngineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReasoningEngineOperationSettings = OperationCallSettings.newBuilder();
      getReasoningEngineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReasoningEnginesSettings =
          PagedCallSettings.newBuilder(LIST_REASONING_ENGINES_PAGE_STR_FACT);
      deleteReasoningEngineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReasoningEngineOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReasoningEngineSettings,
              getReasoningEngineSettings,
              listReasoningEnginesSettings,
              deleteReasoningEngineSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ReasoningEngineServiceStubSettings settings) {
      super(settings);

      createReasoningEngineSettings = settings.createReasoningEngineSettings.toBuilder();
      createReasoningEngineOperationSettings =
          settings.createReasoningEngineOperationSettings.toBuilder();
      getReasoningEngineSettings = settings.getReasoningEngineSettings.toBuilder();
      listReasoningEnginesSettings = settings.listReasoningEnginesSettings.toBuilder();
      deleteReasoningEngineSettings = settings.deleteReasoningEngineSettings.toBuilder();
      deleteReasoningEngineOperationSettings =
          settings.deleteReasoningEngineOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReasoningEngineSettings,
              getReasoningEngineSettings,
              listReasoningEnginesSettings,
              deleteReasoningEngineSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createReasoningEngineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getReasoningEngineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listReasoningEnginesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteReasoningEngineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createReasoningEngineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReasoningEngineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReasoningEngine.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateReasoningEngineOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteReasoningEngineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteReasoningEngineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createReasoningEngine. */
    public UnaryCallSettings.Builder<CreateReasoningEngineRequest, Operation>
        createReasoningEngineSettings() {
      return createReasoningEngineSettings;
    }

    /** Returns the builder for the settings used for calls to createReasoningEngine. */
    public OperationCallSettings.Builder<
            CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
        createReasoningEngineOperationSettings() {
      return createReasoningEngineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getReasoningEngine. */
    public UnaryCallSettings.Builder<GetReasoningEngineRequest, ReasoningEngine>
        getReasoningEngineSettings() {
      return getReasoningEngineSettings;
    }

    /** Returns the builder for the settings used for calls to listReasoningEngines. */
    public PagedCallSettings.Builder<
            ListReasoningEnginesRequest,
            ListReasoningEnginesResponse,
            ListReasoningEnginesPagedResponse>
        listReasoningEnginesSettings() {
      return listReasoningEnginesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReasoningEngine. */
    public UnaryCallSettings.Builder<DeleteReasoningEngineRequest, Operation>
        deleteReasoningEngineSettings() {
      return deleteReasoningEngineSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReasoningEngine. */
    public OperationCallSettings.Builder<
            DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
        deleteReasoningEngineOperationSettings() {
      return deleteReasoningEngineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ReasoningEngineServiceStubSettings build() throws IOException {
      return new ReasoningEngineServiceStubSettings(this);
    }
  }
}
