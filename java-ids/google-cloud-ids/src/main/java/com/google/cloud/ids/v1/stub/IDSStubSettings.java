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

package com.google.cloud.ids.v1.stub;

import static com.google.cloud.ids.v1.IDSClient.ListEndpointsPagedResponse;

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
import com.google.cloud.ids.v1.CreateEndpointRequest;
import com.google.cloud.ids.v1.DeleteEndpointRequest;
import com.google.cloud.ids.v1.Endpoint;
import com.google.cloud.ids.v1.GetEndpointRequest;
import com.google.cloud.ids.v1.ListEndpointsRequest;
import com.google.cloud.ids.v1.ListEndpointsResponse;
import com.google.cloud.ids.v1.OperationMetadata;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IDSStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ids.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEndpoint to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IDSStubSettings.Builder iDSSettingsBuilder = IDSStubSettings.newBuilder();
 * iDSSettingsBuilder
 *     .getEndpointSettings()
 *     .setRetrySettings(
 *         iDSSettingsBuilder
 *             .getEndpointSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IDSStubSettings iDSSettings = iDSSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IDSStubSettings extends StubSettings<IDSStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings;
  private final UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings;
  private final UnaryCallSettings<CreateEndpointRequest, Operation> createEndpointSettings;
  private final OperationCallSettings<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationSettings;
  private final UnaryCallSettings<DeleteEndpointRequest, Operation> deleteEndpointSettings;
  private final OperationCallSettings<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationSettings;

  private static final PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>
      LIST_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEndpointsRequest injectToken(ListEndpointsRequest payload, String token) {
              return ListEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEndpointsRequest injectPageSize(ListEndpointsRequest payload, int pageSize) {
              return ListEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Endpoint> extractResources(ListEndpointsResponse payload) {
              return payload.getEndpointsList() == null
                  ? ImmutableList.<Endpoint>of()
                  : payload.getEndpointsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      LIST_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> callable,
                ListEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListEndpointsResponse> futureResponse) {
              PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> pageContext =
                  PageContext.create(callable, LIST_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListEndpointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return listEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return getEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public UnaryCallSettings<CreateEndpointRequest, Operation> createEndpointSettings() {
    return createEndpointSettings;
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public OperationCallSettings<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationSettings() {
    return createEndpointOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public UnaryCallSettings<DeleteEndpointRequest, Operation> deleteEndpointSettings() {
    return deleteEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public OperationCallSettings<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationSettings() {
    return deleteEndpointOperationSettings;
  }

  public IDSStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIDSStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIDSStub.create(this);
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
    return "ids.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "ids.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(IDSStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(IDSStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IDSStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected IDSStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEndpointsSettings = settingsBuilder.listEndpointsSettings().build();
    getEndpointSettings = settingsBuilder.getEndpointSettings().build();
    createEndpointSettings = settingsBuilder.createEndpointSettings().build();
    createEndpointOperationSettings = settingsBuilder.createEndpointOperationSettings().build();
    deleteEndpointSettings = settingsBuilder.deleteEndpointSettings().build();
    deleteEndpointOperationSettings = settingsBuilder.deleteEndpointOperationSettings().build();
  }

  /** Builder for IDSStubSettings. */
  public static class Builder extends StubSettings.Builder<IDSStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings;
    private final UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings;
    private final UnaryCallSettings.Builder<CreateEndpointRequest, Operation>
        createEndpointSettings;
    private final OperationCallSettings.Builder<CreateEndpointRequest, Endpoint, OperationMetadata>
        createEndpointOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEndpointRequest, Operation>
        deleteEndpointSettings;
    private final OperationCallSettings.Builder<DeleteEndpointRequest, Empty, OperationMetadata>
        deleteEndpointOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(250L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(32000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(3600000L))
              .setTotalTimeout(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(3600000L))
              .setTotalTimeout(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listEndpointsSettings = PagedCallSettings.newBuilder(LIST_ENDPOINTS_PAGE_STR_FACT);
      getEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointOperationSettings = OperationCallSettings.newBuilder();
      deleteEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEndpointOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointsSettings,
              getEndpointSettings,
              createEndpointSettings,
              deleteEndpointSettings);
      initDefaults(this);
    }

    protected Builder(IDSStubSettings settings) {
      super(settings);

      listEndpointsSettings = settings.listEndpointsSettings.toBuilder();
      getEndpointSettings = settings.getEndpointSettings.toBuilder();
      createEndpointSettings = settings.createEndpointSettings.toBuilder();
      createEndpointOperationSettings = settings.createEndpointOperationSettings.toBuilder();
      deleteEndpointSettings = settings.deleteEndpointSettings.toBuilder();
      deleteEndpointOperationSettings = settings.deleteEndpointOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointsSettings,
              getEndpointSettings,
              createEndpointSettings,
              deleteEndpointSettings);
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
          .listEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Endpoint.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(3600000L))
                      .build()));

      builder
          .deleteEndpointOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEndpointRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(3600000L))
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

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return listEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    public UnaryCallSettings.Builder<CreateEndpointRequest, Operation> createEndpointSettings() {
      return createEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateEndpointRequest, Endpoint, OperationMetadata>
        createEndpointOperationSettings() {
      return createEndpointOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    public UnaryCallSettings.Builder<DeleteEndpointRequest, Operation> deleteEndpointSettings() {
      return deleteEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteEndpointRequest, Empty, OperationMetadata>
        deleteEndpointOperationSettings() {
      return deleteEndpointOperationSettings;
    }

    @Override
    public IDSStubSettings build() throws IOException {
      return new IDSStubSettings(this);
    }
  }
}
