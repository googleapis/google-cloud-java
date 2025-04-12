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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.EncryptionConfig;
import com.google.cloud.dataplex.v1.GetEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CmekServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getEncryptionConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekServiceStubSettings.Builder cmekServiceSettingsBuilder =
 *     CmekServiceStubSettings.newBuilder();
 * cmekServiceSettingsBuilder
 *     .getEncryptionConfigSettings()
 *     .setRetrySettings(
 *         cmekServiceSettingsBuilder
 *             .getEncryptionConfigSettings()
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
 * CmekServiceStubSettings cmekServiceSettings = cmekServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEncryptionConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekServiceStubSettings.Builder cmekServiceSettingsBuilder =
 *     CmekServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cmekServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CmekServiceStubSettings extends StubSettings<CmekServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigSettings;
  private final OperationCallSettings<
          CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationSettings;
  private final UnaryCallSettings<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigSettings;
  private final OperationCallSettings<
          UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationSettings;
  private final UnaryCallSettings<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigSettings;
  private final OperationCallSettings<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationSettings;
  private final PagedCallSettings<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsSettings;
  private final UnaryCallSettings<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
      LIST_ENCRYPTION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEncryptionConfigsRequest injectToken(
                ListEncryptionConfigsRequest payload, String token) {
              return ListEncryptionConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEncryptionConfigsRequest injectPageSize(
                ListEncryptionConfigsRequest payload, int pageSize) {
              return ListEncryptionConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEncryptionConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEncryptionConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EncryptionConfig> extractResources(
                ListEncryptionConfigsResponse payload) {
              return payload.getEncryptionConfigsList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          ListEncryptionConfigsPagedResponse>
      LIST_ENCRYPTION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEncryptionConfigsRequest,
              ListEncryptionConfigsResponse,
              ListEncryptionConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListEncryptionConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse> callable,
                ListEncryptionConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListEncryptionConfigsResponse> futureResponse) {
              PageContext<
                      ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENCRYPTION_CONFIGS_PAGE_STR_DESC, request, context);
              return ListEncryptionConfigsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createEncryptionConfig. */
  public UnaryCallSettings<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigSettings() {
    return createEncryptionConfigSettings;
  }

  /** Returns the object with the settings used for calls to createEncryptionConfig. */
  public OperationCallSettings<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationSettings() {
    return createEncryptionConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEncryptionConfig. */
  public UnaryCallSettings<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigSettings() {
    return updateEncryptionConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateEncryptionConfig. */
  public OperationCallSettings<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationSettings() {
    return updateEncryptionConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEncryptionConfig. */
  public UnaryCallSettings<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigSettings() {
    return deleteEncryptionConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteEncryptionConfig. */
  public OperationCallSettings<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationSettings() {
    return deleteEncryptionConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEncryptionConfigs. */
  public PagedCallSettings<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsSettings() {
    return listEncryptionConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getEncryptionConfig. */
  public UnaryCallSettings<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigSettings() {
    return getEncryptionConfigSettings;
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

  public CmekServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCmekServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCmekServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dataplex";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CmekServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CmekServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CmekServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CmekServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createEncryptionConfigSettings = settingsBuilder.createEncryptionConfigSettings().build();
    createEncryptionConfigOperationSettings =
        settingsBuilder.createEncryptionConfigOperationSettings().build();
    updateEncryptionConfigSettings = settingsBuilder.updateEncryptionConfigSettings().build();
    updateEncryptionConfigOperationSettings =
        settingsBuilder.updateEncryptionConfigOperationSettings().build();
    deleteEncryptionConfigSettings = settingsBuilder.deleteEncryptionConfigSettings().build();
    deleteEncryptionConfigOperationSettings =
        settingsBuilder.deleteEncryptionConfigOperationSettings().build();
    listEncryptionConfigsSettings = settingsBuilder.listEncryptionConfigsSettings().build();
    getEncryptionConfigSettings = settingsBuilder.getEncryptionConfigSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for CmekServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CmekServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateEncryptionConfigRequest, Operation>
        createEncryptionConfigSettings;
    private final OperationCallSettings.Builder<
            CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        createEncryptionConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEncryptionConfigRequest, Operation>
        updateEncryptionConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        updateEncryptionConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEncryptionConfigRequest, Operation>
        deleteEncryptionConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteEncryptionConfigRequest, Empty, OperationMetadata>
        deleteEncryptionConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListEncryptionConfigsRequest,
            ListEncryptionConfigsResponse,
            ListEncryptionConfigsPagedResponse>
        listEncryptionConfigsSettings;
    private final UnaryCallSettings.Builder<GetEncryptionConfigRequest, EncryptionConfig>
        getEncryptionConfigSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      createEncryptionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEncryptionConfigOperationSettings = OperationCallSettings.newBuilder();
      updateEncryptionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEncryptionConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteEncryptionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEncryptionConfigOperationSettings = OperationCallSettings.newBuilder();
      listEncryptionConfigsSettings =
          PagedCallSettings.newBuilder(LIST_ENCRYPTION_CONFIGS_PAGE_STR_FACT);
      getEncryptionConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEncryptionConfigSettings,
              updateEncryptionConfigSettings,
              deleteEncryptionConfigSettings,
              listEncryptionConfigsSettings,
              getEncryptionConfigSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(CmekServiceStubSettings settings) {
      super(settings);

      createEncryptionConfigSettings = settings.createEncryptionConfigSettings.toBuilder();
      createEncryptionConfigOperationSettings =
          settings.createEncryptionConfigOperationSettings.toBuilder();
      updateEncryptionConfigSettings = settings.updateEncryptionConfigSettings.toBuilder();
      updateEncryptionConfigOperationSettings =
          settings.updateEncryptionConfigOperationSettings.toBuilder();
      deleteEncryptionConfigSettings = settings.deleteEncryptionConfigSettings.toBuilder();
      deleteEncryptionConfigOperationSettings =
          settings.deleteEncryptionConfigOperationSettings.toBuilder();
      listEncryptionConfigsSettings = settings.listEncryptionConfigsSettings.toBuilder();
      getEncryptionConfigSettings = settings.getEncryptionConfigSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEncryptionConfigSettings,
              updateEncryptionConfigSettings,
              deleteEncryptionConfigSettings,
              listEncryptionConfigsSettings,
              getEncryptionConfigSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createEncryptionConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEncryptionConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEncryptionConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEncryptionConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEncryptionConfigSettings()
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
          .createEncryptionConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEncryptionConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EncryptionConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateEncryptionConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEncryptionConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EncryptionConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteEncryptionConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEncryptionConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createEncryptionConfig. */
    public UnaryCallSettings.Builder<CreateEncryptionConfigRequest, Operation>
        createEncryptionConfigSettings() {
      return createEncryptionConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createEncryptionConfig. */
    public OperationCallSettings.Builder<
            CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        createEncryptionConfigOperationSettings() {
      return createEncryptionConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEncryptionConfig. */
    public UnaryCallSettings.Builder<UpdateEncryptionConfigRequest, Operation>
        updateEncryptionConfigSettings() {
      return updateEncryptionConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateEncryptionConfig. */
    public OperationCallSettings.Builder<
            UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        updateEncryptionConfigOperationSettings() {
      return updateEncryptionConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEncryptionConfig. */
    public UnaryCallSettings.Builder<DeleteEncryptionConfigRequest, Operation>
        deleteEncryptionConfigSettings() {
      return deleteEncryptionConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEncryptionConfig. */
    public OperationCallSettings.Builder<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
        deleteEncryptionConfigOperationSettings() {
      return deleteEncryptionConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEncryptionConfigs. */
    public PagedCallSettings.Builder<
            ListEncryptionConfigsRequest,
            ListEncryptionConfigsResponse,
            ListEncryptionConfigsPagedResponse>
        listEncryptionConfigsSettings() {
      return listEncryptionConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getEncryptionConfig. */
    public UnaryCallSettings.Builder<GetEncryptionConfigRequest, EncryptionConfig>
        getEncryptionConfigSettings() {
      return getEncryptionConfigSettings;
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

    @Override
    public CmekServiceStubSettings build() throws IOException {
      return new CmekServiceStubSettings(this);
    }
  }
}
