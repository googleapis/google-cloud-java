/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.NetworksClient.ListPeeringRoutesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddPeeringNetworkRequest;
import com.google.cloud.compute.v1.DeleteNetworkRequest;
import com.google.cloud.compute.v1.ExchangedPeeringRoute;
import com.google.cloud.compute.v1.ExchangedPeeringRoutesList;
import com.google.cloud.compute.v1.GetEffectiveFirewallsNetworkRequest;
import com.google.cloud.compute.v1.GetNetworkRequest;
import com.google.cloud.compute.v1.InsertNetworkRequest;
import com.google.cloud.compute.v1.ListNetworksRequest;
import com.google.cloud.compute.v1.ListPeeringRoutesNetworksRequest;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkList;
import com.google.cloud.compute.v1.NetworksGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkRequest;
import com.google.cloud.compute.v1.RemovePeeringNetworkRequest;
import com.google.cloud.compute.v1.SwitchToCustomModeNetworkRequest;
import com.google.cloud.compute.v1.UpdatePeeringNetworkRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NetworksStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addPeering to 30 seconds:
 *
 * <pre>
 * <code>
 * NetworksStubSettings.Builder networksSettingsBuilder =
 *     NetworksStubSettings.newBuilder();
 * networksSettingsBuilder
 *     .addPeeringSettings()
 *     .setRetrySettings(
 *         networksSettingsBuilder.addPeeringSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworksStubSettings networksSettings = networksSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NetworksStubSettings extends StubSettings<NetworksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .build();

  private final UnaryCallSettings<AddPeeringNetworkRequest, Operation> addPeeringSettings;
  private final UnaryCallSettings<DeleteNetworkRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getSettings;
  private final UnaryCallSettings<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings;
  private final UnaryCallSettings<InsertNetworkRequest, Operation> insertSettings;
  private final PagedCallSettings<ListNetworksRequest, NetworkList, ListPagedResponse> listSettings;
  private final PagedCallSettings<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings;
  private final UnaryCallSettings<PatchNetworkRequest, Operation> patchSettings;
  private final UnaryCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringSettings;
  private final UnaryCallSettings<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeSettings;
  private final UnaryCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringSettings;

  /** Returns the object with the settings used for calls to addPeering. */
  public UnaryCallSettings<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
    return addPeeringSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkRequest, Network> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getEffectiveFirewalls. */
  public UnaryCallSettings<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings() {
    return getEffectiveFirewallsSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListNetworksRequest, NetworkList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listPeeringRoutes. */
  public PagedCallSettings<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings() {
    return listPeeringRoutesSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNetworkRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to removePeering. */
  public UnaryCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringSettings() {
    return removePeeringSettings;
  }

  /** Returns the object with the settings used for calls to switchToCustomMode. */
  public UnaryCallSettings<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeSettings() {
    return switchToCustomModeSettings;
  }

  /** Returns the object with the settings used for calls to updatePeering. */
  public UnaryCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringSettings() {
    return updatePeeringSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NetworksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworksStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NetworksStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected NetworksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addPeeringSettings = settingsBuilder.addPeeringSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getEffectiveFirewallsSettings = settingsBuilder.getEffectiveFirewallsSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listPeeringRoutesSettings = settingsBuilder.listPeeringRoutesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    removePeeringSettings = settingsBuilder.removePeeringSettings().build();
    switchToCustomModeSettings = settingsBuilder.switchToCustomModeSettings().build();
    updatePeeringSettings = settingsBuilder.updatePeeringSettings().build();
  }

  private static final PagedListDescriptor<ListNetworksRequest, NetworkList, Network>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListNetworksRequest, NetworkList, Network>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworksRequest injectToken(ListNetworksRequest payload, String token) {
              return ListNetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworksRequest injectPageSize(ListNetworksRequest payload, int pageSize) {
              return ListNetworksRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(NetworkList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Network> extractResources(NetworkList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Network>of();
            }
          };

  private static final PagedListDescriptor<
          ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList, ExchangedPeeringRoute>
      LIST_PEERING_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPeeringRoutesNetworksRequest,
              ExchangedPeeringRoutesList,
              ExchangedPeeringRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPeeringRoutesNetworksRequest injectToken(
                ListPeeringRoutesNetworksRequest payload, String token) {
              return ListPeeringRoutesNetworksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPeeringRoutesNetworksRequest injectPageSize(
                ListPeeringRoutesNetworksRequest payload, int pageSize) {
              return ListPeeringRoutesNetworksRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPeeringRoutesNetworksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ExchangedPeeringRoutesList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExchangedPeeringRoute> extractResources(
                ExchangedPeeringRoutesList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<ExchangedPeeringRoute>of();
            }
          };

  private static final PagedListResponseFactory<ListNetworksRequest, NetworkList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListNetworksRequest, NetworkList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworksRequest, NetworkList> callable,
                ListNetworksRequest request,
                ApiCallContext context,
                ApiFuture<NetworkList> futureResponse) {
              PageContext<ListNetworksRequest, NetworkList, Network> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ListPeeringRoutesPagedResponse>
      LIST_PEERING_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPeeringRoutesNetworksRequest,
              ExchangedPeeringRoutesList,
              ListPeeringRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListPeeringRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
                    callable,
                ListPeeringRoutesNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ExchangedPeeringRoutesList> futureResponse) {
              PageContext<
                      ListPeeringRoutesNetworksRequest,
                      ExchangedPeeringRoutesList,
                      ExchangedPeeringRoute>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PEERING_ROUTES_PAGE_STR_DESC, request, context);
              return ListPeeringRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for NetworksStubSettings. */
  public static class Builder extends StubSettings.Builder<NetworksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddPeeringNetworkRequest, Operation> addPeeringSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings;
    private final UnaryCallSettings.Builder<InsertNetworkRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<ListNetworksRequest, NetworkList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListPeeringRoutesNetworksRequest,
            ExchangedPeeringRoutesList,
            ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings;
    private final UnaryCallSettings.Builder<PatchNetworkRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<RemovePeeringNetworkRequest, Operation>
        removePeeringSettings;
    private final UnaryCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeSettings;
    private final UnaryCallSettings.Builder<UpdatePeeringNetworkRequest, Operation>
        updatePeeringSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getEffectiveFirewallsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);

      listPeeringRoutesSettings = PagedCallSettings.newBuilder(LIST_PEERING_ROUTES_PAGE_STR_FACT);

      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      removePeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      switchToCustomModeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updatePeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addPeeringSettings,
              deleteSettings,
              getSettings,
              getEffectiveFirewallsSettings,
              insertSettings,
              listSettings,
              listPeeringRoutesSettings,
              patchSettings,
              removePeeringSettings,
              switchToCustomModeSettings,
              updatePeeringSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .addPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getEffectiveFirewallsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listPeeringRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .removePeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .switchToCustomModeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updatePeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NetworksStubSettings settings) {
      super(settings);

      addPeeringSettings = settings.addPeeringSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getEffectiveFirewallsSettings = settings.getEffectiveFirewallsSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listPeeringRoutesSettings = settings.listPeeringRoutesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      removePeeringSettings = settings.removePeeringSettings.toBuilder();
      switchToCustomModeSettings = settings.switchToCustomModeSettings.toBuilder();
      updatePeeringSettings = settings.updatePeeringSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addPeeringSettings,
              deleteSettings,
              getSettings,
              getEffectiveFirewallsSettings,
              insertSettings,
              listSettings,
              listPeeringRoutesSettings,
              patchSettings,
              removePeeringSettings,
              switchToCustomModeSettings,
              updatePeeringSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to addPeering. */
    public UnaryCallSettings.Builder<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
      return addPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getEffectiveFirewalls. */
    public UnaryCallSettings.Builder<
            GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings() {
      return getEffectiveFirewallsSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListNetworksRequest, NetworkList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listPeeringRoutes. */
    public PagedCallSettings.Builder<
            ListPeeringRoutesNetworksRequest,
            ExchangedPeeringRoutesList,
            ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings() {
      return listPeeringRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNetworkRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to removePeering. */
    public UnaryCallSettings.Builder<RemovePeeringNetworkRequest, Operation>
        removePeeringSettings() {
      return removePeeringSettings;
    }

    /** Returns the builder for the settings used for calls to switchToCustomMode. */
    public UnaryCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeSettings() {
      return switchToCustomModeSettings;
    }

    /** Returns the builder for the settings used for calls to updatePeering. */
    public UnaryCallSettings.Builder<UpdatePeeringNetworkRequest, Operation>
        updatePeeringSettings() {
      return updatePeeringSettings;
    }

    @Override
    public NetworksStubSettings build() throws IOException {
      return new NetworksStubSettings(this);
    }
  }
}
