/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.VpnTunnelClient.AggregatedListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelClient.ListVpnTunnelsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.GetVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.InsertVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.ListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelAggregatedList;
import com.google.cloud.compute.v1.VpnTunnelList;
import com.google.cloud.compute.v1.VpnTunnelsScopedList;
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
 * Settings class to configure an instance of {@link VpnTunnelStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteVpnTunnel to 30 seconds:
 *
 * <pre>
 * <code>
 * VpnTunnelStubSettings.Builder vpnTunnelSettingsBuilder =
 *     VpnTunnelStubSettings.newBuilder();
 * vpnTunnelSettingsBuilder.deleteVpnTunnelSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * VpnTunnelStubSettings vpnTunnelSettings = vpnTunnelSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class VpnTunnelStubSettings extends StubSettings<VpnTunnelStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final PagedCallSettings<
          AggregatedListVpnTunnelsHttpRequest,
          VpnTunnelAggregatedList,
          AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsSettings;
  private final UnaryCallSettings<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelSettings;
  private final UnaryCallSettings<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelSettings;
  private final UnaryCallSettings<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelSettings;
  private final PagedCallSettings<
          ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
      listVpnTunnelsSettings;

  /** Returns the object with the settings used for calls to aggregatedListVpnTunnels. */
  public PagedCallSettings<
          AggregatedListVpnTunnelsHttpRequest,
          VpnTunnelAggregatedList,
          AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsSettings() {
    return aggregatedListVpnTunnelsSettings;
  }

  /** Returns the object with the settings used for calls to deleteVpnTunnel. */
  public UnaryCallSettings<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelSettings() {
    return deleteVpnTunnelSettings;
  }

  /** Returns the object with the settings used for calls to getVpnTunnel. */
  public UnaryCallSettings<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelSettings() {
    return getVpnTunnelSettings;
  }

  /** Returns the object with the settings used for calls to insertVpnTunnel. */
  public UnaryCallSettings<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelSettings() {
    return insertVpnTunnelSettings;
  }

  /** Returns the object with the settings used for calls to listVpnTunnels. */
  public PagedCallSettings<ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
      listVpnTunnelsSettings() {
    return listVpnTunnelsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public VpnTunnelStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVpnTunnelStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(VpnTunnelStubSettings.class))
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

  protected VpnTunnelStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListVpnTunnelsSettings = settingsBuilder.aggregatedListVpnTunnelsSettings().build();
    deleteVpnTunnelSettings = settingsBuilder.deleteVpnTunnelSettings().build();
    getVpnTunnelSettings = settingsBuilder.getVpnTunnelSettings().build();
    insertVpnTunnelSettings = settingsBuilder.insertVpnTunnelSettings().build();
    listVpnTunnelsSettings = settingsBuilder.listVpnTunnelsSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList, VpnTunnelsScopedList>
      AGGREGATED_LIST_VPN_TUNNELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListVpnTunnelsHttpRequest,
              VpnTunnelAggregatedList,
              VpnTunnelsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListVpnTunnelsHttpRequest injectToken(
                AggregatedListVpnTunnelsHttpRequest payload, String token) {
              return AggregatedListVpnTunnelsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListVpnTunnelsHttpRequest injectPageSize(
                AggregatedListVpnTunnelsHttpRequest payload, int pageSize) {
              return AggregatedListVpnTunnelsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListVpnTunnelsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnTunnelAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnTunnelsScopedList> extractResources(
                VpnTunnelAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<VpnTunnelsScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel>
      LIST_VPN_TUNNELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVpnTunnelsHttpRequest injectToken(
                ListVpnTunnelsHttpRequest payload, String token) {
              return ListVpnTunnelsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVpnTunnelsHttpRequest injectPageSize(
                ListVpnTunnelsHttpRequest payload, int pageSize) {
              return ListVpnTunnelsHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVpnTunnelsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VpnTunnelList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VpnTunnel> extractResources(VpnTunnelList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<VpnTunnel>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListVpnTunnelsHttpRequest,
          VpnTunnelAggregatedList,
          AggregatedListVpnTunnelsPagedResponse>
      AGGREGATED_LIST_VPN_TUNNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListVpnTunnelsHttpRequest,
              VpnTunnelAggregatedList,
              AggregatedListVpnTunnelsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListVpnTunnelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
                    callable,
                AggregatedListVpnTunnelsHttpRequest request,
                ApiCallContext context,
                ApiFuture<VpnTunnelAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListVpnTunnelsHttpRequest,
                      VpnTunnelAggregatedList,
                      VpnTunnelsScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_VPN_TUNNELS_PAGE_STR_DESC, request, context);
              return AggregatedListVpnTunnelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
      LIST_VPN_TUNNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>() {
            @Override
            public ApiFuture<ListVpnTunnelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVpnTunnelsHttpRequest, VpnTunnelList> callable,
                ListVpnTunnelsHttpRequest request,
                ApiCallContext context,
                ApiFuture<VpnTunnelList> futureResponse) {
              PageContext<ListVpnTunnelsHttpRequest, VpnTunnelList, VpnTunnel> pageContext =
                  PageContext.create(callable, LIST_VPN_TUNNELS_PAGE_STR_DESC, request, context);
              return ListVpnTunnelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for VpnTunnelStubSettings. */
  public static class Builder extends StubSettings.Builder<VpnTunnelStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListVpnTunnelsHttpRequest,
            VpnTunnelAggregatedList,
            AggregatedListVpnTunnelsPagedResponse>
        aggregatedListVpnTunnelsSettings;
    private final UnaryCallSettings.Builder<DeleteVpnTunnelHttpRequest, Operation>
        deleteVpnTunnelSettings;
    private final UnaryCallSettings.Builder<GetVpnTunnelHttpRequest, VpnTunnel>
        getVpnTunnelSettings;
    private final UnaryCallSettings.Builder<InsertVpnTunnelHttpRequest, Operation>
        insertVpnTunnelSettings;
    private final PagedCallSettings.Builder<
            ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
        listVpnTunnelsSettings;

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

      aggregatedListVpnTunnelsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_VPN_TUNNELS_PAGE_STR_FACT);

      deleteVpnTunnelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getVpnTunnelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertVpnTunnelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listVpnTunnelsSettings = PagedCallSettings.newBuilder(LIST_VPN_TUNNELS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListVpnTunnelsSettings,
              deleteVpnTunnelSettings,
              getVpnTunnelSettings,
              insertVpnTunnelSettings,
              listVpnTunnelsSettings);

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
          .aggregatedListVpnTunnelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteVpnTunnelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getVpnTunnelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertVpnTunnelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listVpnTunnelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(VpnTunnelStubSettings settings) {
      super(settings);

      aggregatedListVpnTunnelsSettings = settings.aggregatedListVpnTunnelsSettings.toBuilder();
      deleteVpnTunnelSettings = settings.deleteVpnTunnelSettings.toBuilder();
      getVpnTunnelSettings = settings.getVpnTunnelSettings.toBuilder();
      insertVpnTunnelSettings = settings.insertVpnTunnelSettings.toBuilder();
      listVpnTunnelsSettings = settings.listVpnTunnelsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListVpnTunnelsSettings,
              deleteVpnTunnelSettings,
              getVpnTunnelSettings,
              insertVpnTunnelSettings,
              listVpnTunnelsSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListVpnTunnels. */
    public PagedCallSettings.Builder<
            AggregatedListVpnTunnelsHttpRequest,
            VpnTunnelAggregatedList,
            AggregatedListVpnTunnelsPagedResponse>
        aggregatedListVpnTunnelsSettings() {
      return aggregatedListVpnTunnelsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVpnTunnel. */
    public UnaryCallSettings.Builder<DeleteVpnTunnelHttpRequest, Operation>
        deleteVpnTunnelSettings() {
      return deleteVpnTunnelSettings;
    }

    /** Returns the builder for the settings used for calls to getVpnTunnel. */
    public UnaryCallSettings.Builder<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelSettings() {
      return getVpnTunnelSettings;
    }

    /** Returns the builder for the settings used for calls to insertVpnTunnel. */
    public UnaryCallSettings.Builder<InsertVpnTunnelHttpRequest, Operation>
        insertVpnTunnelSettings() {
      return insertVpnTunnelSettings;
    }

    /** Returns the builder for the settings used for calls to listVpnTunnels. */
    public PagedCallSettings.Builder<
            ListVpnTunnelsHttpRequest, VpnTunnelList, ListVpnTunnelsPagedResponse>
        listVpnTunnelsSettings() {
      return listVpnTunnelsSettings;
    }

    @Override
    public VpnTunnelStubSettings build() throws IOException {
      return new VpnTunnelStubSettings(this);
    }
  }
}
