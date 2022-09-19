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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

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
import com.google.appengine.v1.CreateDomainMappingRequest;
import com.google.appengine.v1.DeleteDomainMappingRequest;
import com.google.appengine.v1.DomainMapping;
import com.google.appengine.v1.GetDomainMappingRequest;
import com.google.appengine.v1.ListDomainMappingsRequest;
import com.google.appengine.v1.ListDomainMappingsResponse;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.UpdateDomainMappingRequest;
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
 * Settings class to configure an instance of {@link DomainMappingsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDomainMapping to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DomainMappingsStubSettings.Builder domainMappingsSettingsBuilder =
 *     DomainMappingsStubSettings.newBuilder();
 * domainMappingsSettingsBuilder
 *     .getDomainMappingSettings()
 *     .setRetrySettings(
 *         domainMappingsSettingsBuilder.getDomainMappingSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DomainMappingsStubSettings domainMappingsSettings = domainMappingsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DomainMappingsStubSettings extends StubSettings<DomainMappingsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/appengine.admin")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
      listDomainMappingsSettings;
  private final UnaryCallSettings<GetDomainMappingRequest, DomainMapping> getDomainMappingSettings;
  private final UnaryCallSettings<CreateDomainMappingRequest, Operation>
      createDomainMappingSettings;
  private final OperationCallSettings<
          CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationSettings;
  private final UnaryCallSettings<UpdateDomainMappingRequest, Operation>
      updateDomainMappingSettings;
  private final OperationCallSettings<
          UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationSettings;
  private final UnaryCallSettings<DeleteDomainMappingRequest, Operation>
      deleteDomainMappingSettings;
  private final OperationCallSettings<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationSettings;

  private static final PagedListDescriptor<
          ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping>
      LIST_DOMAIN_MAPPINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDomainMappingsRequest injectToken(
                ListDomainMappingsRequest payload, String token) {
              return ListDomainMappingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDomainMappingsRequest injectPageSize(
                ListDomainMappingsRequest payload, int pageSize) {
              return ListDomainMappingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDomainMappingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDomainMappingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DomainMapping> extractResources(ListDomainMappingsResponse payload) {
              return payload.getDomainMappingsList() == null
                  ? ImmutableList.<DomainMapping>of()
                  : payload.getDomainMappingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
      LIST_DOMAIN_MAPPINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDomainMappingsRequest,
              ListDomainMappingsResponse,
              ListDomainMappingsPagedResponse>() {
            @Override
            public ApiFuture<ListDomainMappingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsResponse> callable,
                ListDomainMappingsRequest request,
                ApiCallContext context,
                ApiFuture<ListDomainMappingsResponse> futureResponse) {
              PageContext<ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DOMAIN_MAPPINGS_PAGE_STR_DESC, request, context);
              return ListDomainMappingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDomainMappings. */
  public PagedCallSettings<
          ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
      listDomainMappingsSettings() {
    return listDomainMappingsSettings;
  }

  /** Returns the object with the settings used for calls to getDomainMapping. */
  public UnaryCallSettings<GetDomainMappingRequest, DomainMapping> getDomainMappingSettings() {
    return getDomainMappingSettings;
  }

  /** Returns the object with the settings used for calls to createDomainMapping. */
  public UnaryCallSettings<CreateDomainMappingRequest, Operation> createDomainMappingSettings() {
    return createDomainMappingSettings;
  }

  /** Returns the object with the settings used for calls to createDomainMapping. */
  public OperationCallSettings<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationSettings() {
    return createDomainMappingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDomainMapping. */
  public UnaryCallSettings<UpdateDomainMappingRequest, Operation> updateDomainMappingSettings() {
    return updateDomainMappingSettings;
  }

  /** Returns the object with the settings used for calls to updateDomainMapping. */
  public OperationCallSettings<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationSettings() {
    return updateDomainMappingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDomainMapping. */
  public UnaryCallSettings<DeleteDomainMappingRequest, Operation> deleteDomainMappingSettings() {
    return deleteDomainMappingSettings;
  }

  /** Returns the object with the settings used for calls to deleteDomainMapping. */
  public OperationCallSettings<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationSettings() {
    return deleteDomainMappingOperationSettings;
  }

  public DomainMappingsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDomainMappingsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDomainMappingsStub.create(this);
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
    return "appengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "appengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DomainMappingsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DomainMappingsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DomainMappingsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DomainMappingsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDomainMappingsSettings = settingsBuilder.listDomainMappingsSettings().build();
    getDomainMappingSettings = settingsBuilder.getDomainMappingSettings().build();
    createDomainMappingSettings = settingsBuilder.createDomainMappingSettings().build();
    createDomainMappingOperationSettings =
        settingsBuilder.createDomainMappingOperationSettings().build();
    updateDomainMappingSettings = settingsBuilder.updateDomainMappingSettings().build();
    updateDomainMappingOperationSettings =
        settingsBuilder.updateDomainMappingOperationSettings().build();
    deleteDomainMappingSettings = settingsBuilder.deleteDomainMappingSettings().build();
    deleteDomainMappingOperationSettings =
        settingsBuilder.deleteDomainMappingOperationSettings().build();
  }

  /** Builder for DomainMappingsStubSettings. */
  public static class Builder extends StubSettings.Builder<DomainMappingsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
        listDomainMappingsSettings;
    private final UnaryCallSettings.Builder<GetDomainMappingRequest, DomainMapping>
        getDomainMappingSettings;
    private final UnaryCallSettings.Builder<CreateDomainMappingRequest, Operation>
        createDomainMappingSettings;
    private final OperationCallSettings.Builder<
            CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        createDomainMappingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDomainMappingRequest, Operation>
        updateDomainMappingSettings;
    private final OperationCallSettings.Builder<
            UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        updateDomainMappingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDomainMappingRequest, Operation>
        deleteDomainMappingSettings;
    private final OperationCallSettings.Builder<
            DeleteDomainMappingRequest, Empty, OperationMetadataV1>
        deleteDomainMappingOperationSettings;
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

      listDomainMappingsSettings = PagedCallSettings.newBuilder(LIST_DOMAIN_MAPPINGS_PAGE_STR_FACT);
      getDomainMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDomainMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDomainMappingOperationSettings = OperationCallSettings.newBuilder();
      updateDomainMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDomainMappingOperationSettings = OperationCallSettings.newBuilder();
      deleteDomainMappingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDomainMappingOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDomainMappingsSettings,
              getDomainMappingSettings,
              createDomainMappingSettings,
              updateDomainMappingSettings,
              deleteDomainMappingSettings);
      initDefaults(this);
    }

    protected Builder(DomainMappingsStubSettings settings) {
      super(settings);

      listDomainMappingsSettings = settings.listDomainMappingsSettings.toBuilder();
      getDomainMappingSettings = settings.getDomainMappingSettings.toBuilder();
      createDomainMappingSettings = settings.createDomainMappingSettings.toBuilder();
      createDomainMappingOperationSettings =
          settings.createDomainMappingOperationSettings.toBuilder();
      updateDomainMappingSettings = settings.updateDomainMappingSettings.toBuilder();
      updateDomainMappingOperationSettings =
          settings.updateDomainMappingOperationSettings.toBuilder();
      deleteDomainMappingSettings = settings.deleteDomainMappingSettings.toBuilder();
      deleteDomainMappingOperationSettings =
          settings.deleteDomainMappingOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDomainMappingsSettings,
              getDomainMappingSettings,
              createDomainMappingSettings,
              updateDomainMappingSettings,
              deleteDomainMappingSettings);
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
          .listDomainMappingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDomainMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDomainMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateDomainMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDomainMappingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDomainMappingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDomainMappingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DomainMapping.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .updateDomainMappingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDomainMappingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DomainMapping.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .deleteDomainMappingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDomainMappingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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

    /** Returns the builder for the settings used for calls to listDomainMappings. */
    public PagedCallSettings.Builder<
            ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
        listDomainMappingsSettings() {
      return listDomainMappingsSettings;
    }

    /** Returns the builder for the settings used for calls to getDomainMapping. */
    public UnaryCallSettings.Builder<GetDomainMappingRequest, DomainMapping>
        getDomainMappingSettings() {
      return getDomainMappingSettings;
    }

    /** Returns the builder for the settings used for calls to createDomainMapping. */
    public UnaryCallSettings.Builder<CreateDomainMappingRequest, Operation>
        createDomainMappingSettings() {
      return createDomainMappingSettings;
    }

    /** Returns the builder for the settings used for calls to createDomainMapping. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        createDomainMappingOperationSettings() {
      return createDomainMappingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDomainMapping. */
    public UnaryCallSettings.Builder<UpdateDomainMappingRequest, Operation>
        updateDomainMappingSettings() {
      return updateDomainMappingSettings;
    }

    /** Returns the builder for the settings used for calls to updateDomainMapping. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        updateDomainMappingOperationSettings() {
      return updateDomainMappingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDomainMapping. */
    public UnaryCallSettings.Builder<DeleteDomainMappingRequest, Operation>
        deleteDomainMappingSettings() {
      return deleteDomainMappingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDomainMapping. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
        deleteDomainMappingOperationSettings() {
      return deleteDomainMappingOperationSettings;
    }

    @Override
    public DomainMappingsStubSettings build() throws IOException {
      return new DomainMappingsStubSettings(this);
    }
  }
}
