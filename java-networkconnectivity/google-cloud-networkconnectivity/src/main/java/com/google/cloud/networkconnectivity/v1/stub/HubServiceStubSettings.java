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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListSpokesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.CreateHubRequest;
import com.google.cloud.networkconnectivity.v1.CreateSpokeRequest;
import com.google.cloud.networkconnectivity.v1.DeleteHubRequest;
import com.google.cloud.networkconnectivity.v1.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1.GetHubRequest;
import com.google.cloud.networkconnectivity.v1.GetSpokeRequest;
import com.google.cloud.networkconnectivity.v1.Hub;
import com.google.cloud.networkconnectivity.v1.ListHubsRequest;
import com.google.cloud.networkconnectivity.v1.ListHubsResponse;
import com.google.cloud.networkconnectivity.v1.ListSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListSpokesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.Spoke;
import com.google.cloud.networkconnectivity.v1.UpdateHubRequest;
import com.google.cloud.networkconnectivity.v1.UpdateSpokeRequest;
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
 * Settings class to configure an instance of {@link HubServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getHub to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceStubSettings.Builder hubServiceSettingsBuilder = HubServiceStubSettings.newBuilder();
 * hubServiceSettingsBuilder
 *     .getHubSettings()
 *     .setRetrySettings(
 *         hubServiceSettingsBuilder
 *             .getHubSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * HubServiceStubSettings hubServiceSettings = hubServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class HubServiceStubSettings extends StubSettings<HubServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      listHubsSettings;
  private final UnaryCallSettings<GetHubRequest, Hub> getHubSettings;
  private final UnaryCallSettings<CreateHubRequest, Operation> createHubSettings;
  private final OperationCallSettings<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationSettings;
  private final UnaryCallSettings<UpdateHubRequest, Operation> updateHubSettings;
  private final OperationCallSettings<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationSettings;
  private final UnaryCallSettings<DeleteHubRequest, Operation> deleteHubSettings;
  private final OperationCallSettings<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationSettings;
  private final PagedCallSettings<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      listSpokesSettings;
  private final UnaryCallSettings<GetSpokeRequest, Spoke> getSpokeSettings;
  private final UnaryCallSettings<CreateSpokeRequest, Operation> createSpokeSettings;
  private final OperationCallSettings<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationSettings;
  private final UnaryCallSettings<UpdateSpokeRequest, Operation> updateSpokeSettings;
  private final OperationCallSettings<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationSettings;
  private final UnaryCallSettings<DeleteSpokeRequest, Operation> deleteSpokeSettings;
  private final OperationCallSettings<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationSettings;

  private static final PagedListDescriptor<ListHubsRequest, ListHubsResponse, Hub>
      LIST_HUBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListHubsRequest, ListHubsResponse, Hub>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHubsRequest injectToken(ListHubsRequest payload, String token) {
              return ListHubsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHubsRequest injectPageSize(ListHubsRequest payload, int pageSize) {
              return ListHubsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHubsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHubsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Hub> extractResources(ListHubsResponse payload) {
              return payload.getHubsList() == null
                  ? ImmutableList.<Hub>of()
                  : payload.getHubsList();
            }
          };

  private static final PagedListDescriptor<ListSpokesRequest, ListSpokesResponse, Spoke>
      LIST_SPOKES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSpokesRequest, ListSpokesResponse, Spoke>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSpokesRequest injectToken(ListSpokesRequest payload, String token) {
              return ListSpokesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSpokesRequest injectPageSize(ListSpokesRequest payload, int pageSize) {
              return ListSpokesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSpokesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSpokesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Spoke> extractResources(ListSpokesResponse payload) {
              return payload.getSpokesList() == null
                  ? ImmutableList.<Spoke>of()
                  : payload.getSpokesList();
            }
          };

  private static final PagedListResponseFactory<
          ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      LIST_HUBS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>() {
            @Override
            public ApiFuture<ListHubsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHubsRequest, ListHubsResponse> callable,
                ListHubsRequest request,
                ApiCallContext context,
                ApiFuture<ListHubsResponse> futureResponse) {
              PageContext<ListHubsRequest, ListHubsResponse, Hub> pageContext =
                  PageContext.create(callable, LIST_HUBS_PAGE_STR_DESC, request, context);
              return ListHubsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      LIST_SPOKES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>() {
            @Override
            public ApiFuture<ListSpokesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSpokesRequest, ListSpokesResponse> callable,
                ListSpokesRequest request,
                ApiCallContext context,
                ApiFuture<ListSpokesResponse> futureResponse) {
              PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> pageContext =
                  PageContext.create(callable, LIST_SPOKES_PAGE_STR_DESC, request, context);
              return ListSpokesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listHubs. */
  public PagedCallSettings<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
      listHubsSettings() {
    return listHubsSettings;
  }

  /** Returns the object with the settings used for calls to getHub. */
  public UnaryCallSettings<GetHubRequest, Hub> getHubSettings() {
    return getHubSettings;
  }

  /** Returns the object with the settings used for calls to createHub. */
  public UnaryCallSettings<CreateHubRequest, Operation> createHubSettings() {
    return createHubSettings;
  }

  /** Returns the object with the settings used for calls to createHub. */
  public OperationCallSettings<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationSettings() {
    return createHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public UnaryCallSettings<UpdateHubRequest, Operation> updateHubSettings() {
    return updateHubSettings;
  }

  /** Returns the object with the settings used for calls to updateHub. */
  public OperationCallSettings<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationSettings() {
    return updateHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public UnaryCallSettings<DeleteHubRequest, Operation> deleteHubSettings() {
    return deleteHubSettings;
  }

  /** Returns the object with the settings used for calls to deleteHub. */
  public OperationCallSettings<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationSettings() {
    return deleteHubOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSpokes. */
  public PagedCallSettings<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
      listSpokesSettings() {
    return listSpokesSettings;
  }

  /** Returns the object with the settings used for calls to getSpoke. */
  public UnaryCallSettings<GetSpokeRequest, Spoke> getSpokeSettings() {
    return getSpokeSettings;
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public UnaryCallSettings<CreateSpokeRequest, Operation> createSpokeSettings() {
    return createSpokeSettings;
  }

  /** Returns the object with the settings used for calls to createSpoke. */
  public OperationCallSettings<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationSettings() {
    return createSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public UnaryCallSettings<UpdateSpokeRequest, Operation> updateSpokeSettings() {
    return updateSpokeSettings;
  }

  /** Returns the object with the settings used for calls to updateSpoke. */
  public OperationCallSettings<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationSettings() {
    return updateSpokeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public UnaryCallSettings<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
    return deleteSpokeSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpoke. */
  public OperationCallSettings<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationSettings() {
    return deleteSpokeOperationSettings;
  }

  public HubServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcHubServiceStub.create(this);
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
    return "networkconnectivity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkconnectivity.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(HubServiceStubSettings.class))
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

  protected HubServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listHubsSettings = settingsBuilder.listHubsSettings().build();
    getHubSettings = settingsBuilder.getHubSettings().build();
    createHubSettings = settingsBuilder.createHubSettings().build();
    createHubOperationSettings = settingsBuilder.createHubOperationSettings().build();
    updateHubSettings = settingsBuilder.updateHubSettings().build();
    updateHubOperationSettings = settingsBuilder.updateHubOperationSettings().build();
    deleteHubSettings = settingsBuilder.deleteHubSettings().build();
    deleteHubOperationSettings = settingsBuilder.deleteHubOperationSettings().build();
    listSpokesSettings = settingsBuilder.listSpokesSettings().build();
    getSpokeSettings = settingsBuilder.getSpokeSettings().build();
    createSpokeSettings = settingsBuilder.createSpokeSettings().build();
    createSpokeOperationSettings = settingsBuilder.createSpokeOperationSettings().build();
    updateSpokeSettings = settingsBuilder.updateSpokeSettings().build();
    updateSpokeOperationSettings = settingsBuilder.updateSpokeOperationSettings().build();
    deleteSpokeSettings = settingsBuilder.deleteSpokeSettings().build();
    deleteSpokeOperationSettings = settingsBuilder.deleteSpokeOperationSettings().build();
  }

  /** Builder for HubServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<HubServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
        listHubsSettings;
    private final UnaryCallSettings.Builder<GetHubRequest, Hub> getHubSettings;
    private final UnaryCallSettings.Builder<CreateHubRequest, Operation> createHubSettings;
    private final OperationCallSettings.Builder<CreateHubRequest, Hub, OperationMetadata>
        createHubOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHubRequest, Operation> updateHubSettings;
    private final OperationCallSettings.Builder<UpdateHubRequest, Hub, OperationMetadata>
        updateHubOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHubRequest, Operation> deleteHubSettings;
    private final OperationCallSettings.Builder<DeleteHubRequest, Empty, OperationMetadata>
        deleteHubOperationSettings;
    private final PagedCallSettings.Builder<
            ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
        listSpokesSettings;
    private final UnaryCallSettings.Builder<GetSpokeRequest, Spoke> getSpokeSettings;
    private final UnaryCallSettings.Builder<CreateSpokeRequest, Operation> createSpokeSettings;
    private final OperationCallSettings.Builder<CreateSpokeRequest, Spoke, OperationMetadata>
        createSpokeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSpokeRequest, Operation> updateSpokeSettings;
    private final OperationCallSettings.Builder<UpdateSpokeRequest, Spoke, OperationMetadata>
        updateSpokeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSpokeRequest, Operation> deleteSpokeSettings;
    private final OperationCallSettings.Builder<DeleteSpokeRequest, Empty, OperationMetadata>
        deleteSpokeOperationSettings;
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
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listHubsSettings = PagedCallSettings.newBuilder(LIST_HUBS_PAGE_STR_FACT);
      getHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHubOperationSettings = OperationCallSettings.newBuilder();
      updateHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHubOperationSettings = OperationCallSettings.newBuilder();
      deleteHubSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHubOperationSettings = OperationCallSettings.newBuilder();
      listSpokesSettings = PagedCallSettings.newBuilder(LIST_SPOKES_PAGE_STR_FACT);
      getSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSpokeOperationSettings = OperationCallSettings.newBuilder();
      updateSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpokeOperationSettings = OperationCallSettings.newBuilder();
      deleteSpokeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSpokeOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listHubsSettings,
              getHubSettings,
              createHubSettings,
              updateHubSettings,
              deleteHubSettings,
              listSpokesSettings,
              getSpokeSettings,
              createSpokeSettings,
              updateSpokeSettings,
              deleteSpokeSettings);
      initDefaults(this);
    }

    protected Builder(HubServiceStubSettings settings) {
      super(settings);

      listHubsSettings = settings.listHubsSettings.toBuilder();
      getHubSettings = settings.getHubSettings.toBuilder();
      createHubSettings = settings.createHubSettings.toBuilder();
      createHubOperationSettings = settings.createHubOperationSettings.toBuilder();
      updateHubSettings = settings.updateHubSettings.toBuilder();
      updateHubOperationSettings = settings.updateHubOperationSettings.toBuilder();
      deleteHubSettings = settings.deleteHubSettings.toBuilder();
      deleteHubOperationSettings = settings.deleteHubOperationSettings.toBuilder();
      listSpokesSettings = settings.listSpokesSettings.toBuilder();
      getSpokeSettings = settings.getSpokeSettings.toBuilder();
      createSpokeSettings = settings.createSpokeSettings.toBuilder();
      createSpokeOperationSettings = settings.createSpokeOperationSettings.toBuilder();
      updateSpokeSettings = settings.updateSpokeSettings.toBuilder();
      updateSpokeOperationSettings = settings.updateSpokeOperationSettings.toBuilder();
      deleteSpokeSettings = settings.deleteSpokeSettings.toBuilder();
      deleteSpokeOperationSettings = settings.deleteSpokeOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listHubsSettings,
              getHubSettings,
              createHubSettings,
              updateHubSettings,
              deleteHubSettings,
              listSpokesSettings,
              getSpokeSettings,
              createSpokeSettings,
              updateSpokeSettings,
              deleteSpokeSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listHubsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteHubSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSpokesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSpokeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hub.class))
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
          .updateHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Hub.class))
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
          .deleteHubOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteHubRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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
          .createSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Spoke.class))
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
          .updateSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Spoke.class))
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
          .deleteSpokeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteSpokeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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

    /** Returns the builder for the settings used for calls to listHubs. */
    public PagedCallSettings.Builder<ListHubsRequest, ListHubsResponse, ListHubsPagedResponse>
        listHubsSettings() {
      return listHubsSettings;
    }

    /** Returns the builder for the settings used for calls to getHub. */
    public UnaryCallSettings.Builder<GetHubRequest, Hub> getHubSettings() {
      return getHubSettings;
    }

    /** Returns the builder for the settings used for calls to createHub. */
    public UnaryCallSettings.Builder<CreateHubRequest, Operation> createHubSettings() {
      return createHubSettings;
    }

    /** Returns the builder for the settings used for calls to createHub. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateHubRequest, Hub, OperationMetadata>
        createHubOperationSettings() {
      return createHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    public UnaryCallSettings.Builder<UpdateHubRequest, Operation> updateHubSettings() {
      return updateHubSettings;
    }

    /** Returns the builder for the settings used for calls to updateHub. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateHubRequest, Hub, OperationMetadata>
        updateHubOperationSettings() {
      return updateHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    public UnaryCallSettings.Builder<DeleteHubRequest, Operation> deleteHubSettings() {
      return deleteHubSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHub. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteHubRequest, Empty, OperationMetadata>
        deleteHubOperationSettings() {
      return deleteHubOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSpokes. */
    public PagedCallSettings.Builder<ListSpokesRequest, ListSpokesResponse, ListSpokesPagedResponse>
        listSpokesSettings() {
      return listSpokesSettings;
    }

    /** Returns the builder for the settings used for calls to getSpoke. */
    public UnaryCallSettings.Builder<GetSpokeRequest, Spoke> getSpokeSettings() {
      return getSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    public UnaryCallSettings.Builder<CreateSpokeRequest, Operation> createSpokeSettings() {
      return createSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to createSpoke. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateSpokeRequest, Spoke, OperationMetadata>
        createSpokeOperationSettings() {
      return createSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    public UnaryCallSettings.Builder<UpdateSpokeRequest, Operation> updateSpokeSettings() {
      return updateSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpoke. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateSpokeRequest, Spoke, OperationMetadata>
        updateSpokeOperationSettings() {
      return updateSpokeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    public UnaryCallSettings.Builder<DeleteSpokeRequest, Operation> deleteSpokeSettings() {
      return deleteSpokeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpoke. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteSpokeRequest, Empty, OperationMetadata>
        deleteSpokeOperationSettings() {
      return deleteSpokeOperationSettings;
    }

    @Override
    public HubServiceStubSettings build() throws IOException {
      return new HubServiceStubSettings(this);
    }
  }
}
