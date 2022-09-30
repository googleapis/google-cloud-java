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
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworksStubSettings.Builder networksSettingsBuilder = NetworksStubSettings.newBuilder();
 * networksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networksSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworksStubSettings networksSettings = networksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworksStubSettings extends StubSettings<NetworksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddPeeringNetworkRequest, Operation> addPeeringSettings;
  private final OperationCallSettings<AddPeeringNetworkRequest, Operation, Operation>
      addPeeringOperationSettings;
  private final UnaryCallSettings<DeleteNetworkRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteNetworkRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getSettings;
  private final UnaryCallSettings<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings;
  private final UnaryCallSettings<InsertNetworkRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertNetworkRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListNetworksRequest, NetworkList, ListPagedResponse> listSettings;
  private final PagedCallSettings<
          ListPeeringRoutesNetworksRequest,
          ExchangedPeeringRoutesList,
          ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings;
  private final UnaryCallSettings<PatchNetworkRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchNetworkRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringSettings;
  private final OperationCallSettings<RemovePeeringNetworkRequest, Operation, Operation>
      removePeeringOperationSettings;
  private final UnaryCallSettings<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeSettings;
  private final OperationCallSettings<SwitchToCustomModeNetworkRequest, Operation, Operation>
      switchToCustomModeOperationSettings;
  private final UnaryCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringSettings;
  private final OperationCallSettings<UpdatePeeringNetworkRequest, Operation, Operation>
      updatePeeringOperationSettings;

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
              return payload.getItemsList() == null
                  ? ImmutableList.<Network>of()
                  : payload.getItemsList();
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
              return payload.getItemsList() == null
                  ? ImmutableList.<ExchangedPeeringRoute>of()
                  : payload.getItemsList();
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

  /** Returns the object with the settings used for calls to addPeering. */
  public UnaryCallSettings<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
    return addPeeringSettings;
  }

  /** Returns the object with the settings used for calls to addPeering. */
  public OperationCallSettings<AddPeeringNetworkRequest, Operation, Operation>
      addPeeringOperationSettings() {
    return addPeeringOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
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

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
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

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchNetworkRequest, Operation, Operation> patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to removePeering. */
  public UnaryCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringSettings() {
    return removePeeringSettings;
  }

  /** Returns the object with the settings used for calls to removePeering. */
  public OperationCallSettings<RemovePeeringNetworkRequest, Operation, Operation>
      removePeeringOperationSettings() {
    return removePeeringOperationSettings;
  }

  /** Returns the object with the settings used for calls to switchToCustomMode. */
  public UnaryCallSettings<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeSettings() {
    return switchToCustomModeSettings;
  }

  /** Returns the object with the settings used for calls to switchToCustomMode. */
  public OperationCallSettings<SwitchToCustomModeNetworkRequest, Operation, Operation>
      switchToCustomModeOperationSettings() {
    return switchToCustomModeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePeering. */
  public UnaryCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringSettings() {
    return updatePeeringSettings;
  }

  /** Returns the object with the settings used for calls to updatePeering. */
  public OperationCallSettings<UpdatePeeringNetworkRequest, Operation, Operation>
      updatePeeringOperationSettings() {
    return updatePeeringOperationSettings;
  }

  public NetworksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworksStub.create(this);
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
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
    addPeeringOperationSettings = settingsBuilder.addPeeringOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getEffectiveFirewallsSettings = settingsBuilder.getEffectiveFirewallsSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listPeeringRoutesSettings = settingsBuilder.listPeeringRoutesSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    removePeeringSettings = settingsBuilder.removePeeringSettings().build();
    removePeeringOperationSettings = settingsBuilder.removePeeringOperationSettings().build();
    switchToCustomModeSettings = settingsBuilder.switchToCustomModeSettings().build();
    switchToCustomModeOperationSettings =
        settingsBuilder.switchToCustomModeOperationSettings().build();
    updatePeeringSettings = settingsBuilder.updatePeeringSettings().build();
    updatePeeringOperationSettings = settingsBuilder.updatePeeringOperationSettings().build();
  }

  /** Builder for NetworksStubSettings. */
  public static class Builder extends StubSettings.Builder<NetworksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddPeeringNetworkRequest, Operation> addPeeringSettings;
    private final OperationCallSettings.Builder<AddPeeringNetworkRequest, Operation, Operation>
        addPeeringOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteNetworkRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings;
    private final UnaryCallSettings.Builder<InsertNetworkRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertNetworkRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListNetworksRequest, NetworkList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListPeeringRoutesNetworksRequest,
            ExchangedPeeringRoutesList,
            ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings;
    private final UnaryCallSettings.Builder<PatchNetworkRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchNetworkRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<RemovePeeringNetworkRequest, Operation>
        removePeeringSettings;
    private final OperationCallSettings.Builder<RemovePeeringNetworkRequest, Operation, Operation>
        removePeeringOperationSettings;
    private final UnaryCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeSettings;
    private final OperationCallSettings.Builder<
            SwitchToCustomModeNetworkRequest, Operation, Operation>
        switchToCustomModeOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePeeringNetworkRequest, Operation>
        updatePeeringSettings;
    private final OperationCallSettings.Builder<UpdatePeeringNetworkRequest, Operation, Operation>
        updatePeeringOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addPeeringOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEffectiveFirewallsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listPeeringRoutesSettings = PagedCallSettings.newBuilder(LIST_PEERING_ROUTES_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      removePeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removePeeringOperationSettings = OperationCallSettings.newBuilder();
      switchToCustomModeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      switchToCustomModeOperationSettings = OperationCallSettings.newBuilder();
      updatePeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePeeringOperationSettings = OperationCallSettings.newBuilder();

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

    protected Builder(NetworksStubSettings settings) {
      super(settings);

      addPeeringSettings = settings.addPeeringSettings.toBuilder();
      addPeeringOperationSettings = settings.addPeeringOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getEffectiveFirewallsSettings = settings.getEffectiveFirewallsSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listPeeringRoutesSettings = settings.listPeeringRoutesSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      removePeeringSettings = settings.removePeeringSettings.toBuilder();
      removePeeringOperationSettings = settings.removePeeringOperationSettings.toBuilder();
      switchToCustomModeSettings = settings.switchToCustomModeSettings.toBuilder();
      switchToCustomModeOperationSettings =
          settings.switchToCustomModeOperationSettings.toBuilder();
      updatePeeringSettings = settings.updatePeeringSettings.toBuilder();
      updatePeeringOperationSettings = settings.updatePeeringOperationSettings.toBuilder();

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
          .addPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectiveFirewallsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPeeringRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .removePeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .switchToCustomModeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addPeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddPeeringNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removePeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemovePeeringNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .switchToCustomModeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SwitchToCustomModeNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updatePeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePeeringNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to addPeering. */
    public UnaryCallSettings.Builder<AddPeeringNetworkRequest, Operation> addPeeringSettings() {
      return addPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to addPeering. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddPeeringNetworkRequest, Operation, Operation>
        addPeeringOperationSettings() {
      return addPeeringOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteNetworkRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
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

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertNetworkRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
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

    /** Returns the builder for the settings used for calls to patch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<PatchNetworkRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removePeering. */
    public UnaryCallSettings.Builder<RemovePeeringNetworkRequest, Operation>
        removePeeringSettings() {
      return removePeeringSettings;
    }

    /** Returns the builder for the settings used for calls to removePeering. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RemovePeeringNetworkRequest, Operation, Operation>
        removePeeringOperationSettings() {
      return removePeeringOperationSettings;
    }

    /** Returns the builder for the settings used for calls to switchToCustomMode. */
    public UnaryCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeSettings() {
      return switchToCustomModeSettings;
    }

    /** Returns the builder for the settings used for calls to switchToCustomMode. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SwitchToCustomModeNetworkRequest, Operation, Operation>
        switchToCustomModeOperationSettings() {
      return switchToCustomModeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePeering. */
    public UnaryCallSettings.Builder<UpdatePeeringNetworkRequest, Operation>
        updatePeeringSettings() {
      return updatePeeringSettings;
    }

    /** Returns the builder for the settings used for calls to updatePeering. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdatePeeringNetworkRequest, Operation, Operation>
        updatePeeringOperationSettings() {
      return updatePeeringOperationSettings;
    }

    @Override
    public NetworksStubSettings build() throws IOException {
      return new NetworksStubSettings(this);
    }
  }
}
