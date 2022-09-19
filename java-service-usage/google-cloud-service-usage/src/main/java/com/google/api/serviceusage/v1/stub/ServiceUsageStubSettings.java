/*
 * Copyright 2022 Google LLC
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

package com.google.api.serviceusage.v1.stub;

import static com.google.api.serviceusage.v1.ServiceUsageClient.ListServicesPagedResponse;

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
import com.google.api.serviceusage.v1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1.BatchEnableServicesResponse;
import com.google.api.serviceusage.v1.BatchGetServicesRequest;
import com.google.api.serviceusage.v1.BatchGetServicesResponse;
import com.google.api.serviceusage.v1.DisableServiceRequest;
import com.google.api.serviceusage.v1.DisableServiceResponse;
import com.google.api.serviceusage.v1.EnableServiceRequest;
import com.google.api.serviceusage.v1.EnableServiceResponse;
import com.google.api.serviceusage.v1.GetServiceRequest;
import com.google.api.serviceusage.v1.ListServicesRequest;
import com.google.api.serviceusage.v1.ListServicesResponse;
import com.google.api.serviceusage.v1.OperationMetadata;
import com.google.api.serviceusage.v1.Service;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceUsageStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (serviceusage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceUsageStubSettings.Builder serviceUsageSettingsBuilder =
 *     ServiceUsageStubSettings.newBuilder();
 * serviceUsageSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         serviceUsageSettingsBuilder.getServiceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceUsageStubSettings serviceUsageSettings = serviceUsageSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServiceUsageStubSettings extends StubSettings<ServiceUsageStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/service.management")
          .build();

  private final UnaryCallSettings<EnableServiceRequest, Operation> enableServiceSettings;
  private final OperationCallSettings<
          EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationSettings;
  private final UnaryCallSettings<DisableServiceRequest, Operation> disableServiceSettings;
  private final OperationCallSettings<
          DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<BatchEnableServicesRequest, Operation>
      batchEnableServicesSettings;
  private final OperationCallSettings<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationSettings;
  private final UnaryCallSettings<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesSettings;

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList() == null
                  ? ImmutableList.<Service>of()
                  : payload.getServicesList();
            }
          };

  private static final PagedListResponseFactory<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to enableService. */
  public UnaryCallSettings<EnableServiceRequest, Operation> enableServiceSettings() {
    return enableServiceSettings;
  }

  /** Returns the object with the settings used for calls to enableService. */
  public OperationCallSettings<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationSettings() {
    return enableServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableService. */
  public UnaryCallSettings<DisableServiceRequest, Operation> disableServiceSettings() {
    return disableServiceSettings;
  }

  /** Returns the object with the settings used for calls to disableService. */
  public OperationCallSettings<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationSettings() {
    return disableServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to batchEnableServices. */
  public UnaryCallSettings<BatchEnableServicesRequest, Operation> batchEnableServicesSettings() {
    return batchEnableServicesSettings;
  }

  /** Returns the object with the settings used for calls to batchEnableServices. */
  public OperationCallSettings<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationSettings() {
    return batchEnableServicesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchGetServices. */
  public UnaryCallSettings<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesSettings() {
    return batchGetServicesSettings;
  }

  public ServiceUsageStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcServiceUsageStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonServiceUsageStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "serviceusage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "serviceusage.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ServiceUsageStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ServiceUsageStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceUsageStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ServiceUsageStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    enableServiceSettings = settingsBuilder.enableServiceSettings().build();
    enableServiceOperationSettings = settingsBuilder.enableServiceOperationSettings().build();
    disableServiceSettings = settingsBuilder.disableServiceSettings().build();
    disableServiceOperationSettings = settingsBuilder.disableServiceOperationSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    listServicesSettings = settingsBuilder.listServicesSettings().build();
    batchEnableServicesSettings = settingsBuilder.batchEnableServicesSettings().build();
    batchEnableServicesOperationSettings =
        settingsBuilder.batchEnableServicesOperationSettings().build();
    batchGetServicesSettings = settingsBuilder.batchGetServicesSettings().build();
  }

  /** Builder for ServiceUsageStubSettings. */
  public static class Builder extends StubSettings.Builder<ServiceUsageStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<EnableServiceRequest, Operation> enableServiceSettings;
    private final OperationCallSettings.Builder<
            EnableServiceRequest, EnableServiceResponse, OperationMetadata>
        enableServiceOperationSettings;
    private final UnaryCallSettings.Builder<DisableServiceRequest, Operation>
        disableServiceSettings;
    private final OperationCallSettings.Builder<
            DisableServiceRequest, DisableServiceResponse, OperationMetadata>
        disableServiceOperationSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<BatchEnableServicesRequest, Operation>
        batchEnableServicesSettings;
    private final OperationCallSettings.Builder<
            BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
        batchEnableServicesOperationSettings;
    private final UnaryCallSettings.Builder<BatchGetServicesRequest, BatchGetServicesResponse>
        batchGetServicesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      enableServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableServiceOperationSettings = OperationCallSettings.newBuilder();
      disableServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableServiceOperationSettings = OperationCallSettings.newBuilder();
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      batchEnableServicesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchEnableServicesOperationSettings = OperationCallSettings.newBuilder();
      batchGetServicesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enableServiceSettings,
              disableServiceSettings,
              getServiceSettings,
              listServicesSettings,
              batchEnableServicesSettings,
              batchGetServicesSettings);
      initDefaults(this);
    }

    protected Builder(ServiceUsageStubSettings settings) {
      super(settings);

      enableServiceSettings = settings.enableServiceSettings.toBuilder();
      enableServiceOperationSettings = settings.enableServiceOperationSettings.toBuilder();
      disableServiceSettings = settings.disableServiceSettings.toBuilder();
      disableServiceOperationSettings = settings.disableServiceOperationSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      listServicesSettings = settings.listServicesSettings.toBuilder();
      batchEnableServicesSettings = settings.batchEnableServicesSettings.toBuilder();
      batchEnableServicesOperationSettings =
          settings.batchEnableServicesOperationSettings.toBuilder();
      batchGetServicesSettings = settings.batchGetServicesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enableServiceSettings,
              disableServiceSettings,
              getServiceSettings,
              listServicesSettings,
              batchEnableServicesSettings,
              batchGetServicesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .enableServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .disableServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchEnableServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchGetServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .enableServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EnableServiceResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .disableServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DisableServiceResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .batchEnableServicesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchEnableServicesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchEnableServicesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to enableService. */
    public UnaryCallSettings.Builder<EnableServiceRequest, Operation> enableServiceSettings() {
      return enableServiceSettings;
    }

    /** Returns the builder for the settings used for calls to enableService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            EnableServiceRequest, EnableServiceResponse, OperationMetadata>
        enableServiceOperationSettings() {
      return enableServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableService. */
    public UnaryCallSettings.Builder<DisableServiceRequest, Operation> disableServiceSettings() {
      return disableServiceSettings;
    }

    /** Returns the builder for the settings used for calls to disableService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DisableServiceRequest, DisableServiceResponse, OperationMetadata>
        disableServiceOperationSettings() {
      return disableServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to batchEnableServices. */
    public UnaryCallSettings.Builder<BatchEnableServicesRequest, Operation>
        batchEnableServicesSettings() {
      return batchEnableServicesSettings;
    }

    /** Returns the builder for the settings used for calls to batchEnableServices. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
        batchEnableServicesOperationSettings() {
      return batchEnableServicesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetServices. */
    public UnaryCallSettings.Builder<BatchGetServicesRequest, BatchGetServicesResponse>
        batchGetServicesSettings() {
      return batchGetServicesSettings;
    }

    @Override
    public ServiceUsageStubSettings build() throws IOException {
      return new ServiceUsageStubSettings(this);
    }
  }
}
