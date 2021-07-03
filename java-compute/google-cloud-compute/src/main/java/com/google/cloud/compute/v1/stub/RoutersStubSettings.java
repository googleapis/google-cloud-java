/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRoutersRequest;
import com.google.cloud.compute.v1.DeleteRouterRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersRequest;
import com.google.cloud.compute.v1.GetRouterRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterRequest;
import com.google.cloud.compute.v1.InsertRouterRequest;
import com.google.cloud.compute.v1.ListRoutersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRouterRequest;
import com.google.cloud.compute.v1.PreviewRouterRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.RoutersScopedList;
import com.google.cloud.compute.v1.UpdateRouterRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappings;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RoutersStub}.
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
 * <p>For example, to set the total timeout of delete to 30 seconds:
 *
 * <pre>{@code
 * RoutersStubSettings.Builder routersSettingsBuilder = RoutersStubSettings.newBuilder();
 * routersSettingsBuilder
 *     .deleteSettings()
 *     .setRetrySettings(
 *         routersSettingsBuilder
 *             .deleteSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RoutersStubSettings routersSettings = routersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RoutersStubSettings extends StubSettings<RoutersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<DeleteRouterRequest, Operation> deleteSettings;
  private final UnaryCallSettings<GetRouterRequest, Router> getSettings;
  private final PagedCallSettings<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      getNatMappingInfoSettings;
  private final UnaryCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusSettings;
  private final UnaryCallSettings<InsertRouterRequest, Operation> insertSettings;
  private final PagedCallSettings<ListRoutersRequest, RouterList, ListPagedResponse> listSettings;
  private final UnaryCallSettings<PatchRouterRequest, Operation> patchSettings;
  private final UnaryCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewSettings;
  private final UnaryCallSettings<UpdateRouterRequest, Operation> updateSettings;

  private static final PagedListDescriptor<
          AggregatedListRoutersRequest, RouterAggregatedList, Map.Entry<String, RoutersScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListRoutersRequest,
              RouterAggregatedList,
              Map.Entry<String, RoutersScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListRoutersRequest injectToken(
                AggregatedListRoutersRequest payload, String token) {
              return AggregatedListRoutersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListRoutersRequest injectPageSize(
                AggregatedListRoutersRequest payload, int pageSize) {
              return AggregatedListRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, RoutersScopedList>> extractResources(
                RouterAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, RoutersScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<
          GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>
      GET_NAT_MAPPING_INFO_PAGE_STR_DESC =
          new PagedListDescriptor<
              GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList, VmEndpointNatMappings>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GetNatMappingInfoRoutersRequest injectToken(
                GetNatMappingInfoRoutersRequest payload, String token) {
              return GetNatMappingInfoRoutersRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public GetNatMappingInfoRoutersRequest injectPageSize(
                GetNatMappingInfoRoutersRequest payload, int pageSize) {
              return GetNatMappingInfoRoutersRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GetNatMappingInfoRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(VmEndpointNatMappingsList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VmEndpointNatMappings> extractResources(
                VmEndpointNatMappingsList payload) {
              return payload.getResultList() == null
                  ? ImmutableList.<VmEndpointNatMappings>of()
                  : payload.getResultList();
            }
          };

  private static final PagedListDescriptor<ListRoutersRequest, RouterList, Router>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutersRequest, RouterList, Router>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutersRequest injectToken(ListRoutersRequest payload, String token) {
              return ListRoutersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoutersRequest injectPageSize(ListRoutersRequest payload, int pageSize) {
              return ListRoutersRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutersRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Router> extractResources(RouterList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<Router>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList> callable,
                AggregatedListRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RouterAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListRoutersRequest,
                      RouterAggregatedList,
                      Map.Entry<String, RoutersScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      GET_NAT_MAPPING_INFO_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GetNatMappingInfoRoutersRequest,
              VmEndpointNatMappingsList,
              GetNatMappingInfoPagedResponse>() {
            @Override
            public ApiFuture<GetNatMappingInfoPagedResponse> getFuturePagedResponse(
                UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList> callable,
                GetNatMappingInfoRoutersRequest request,
                ApiCallContext context,
                ApiFuture<VmEndpointNatMappingsList> futureResponse) {
              PageContext<
                      GetNatMappingInfoRoutersRequest,
                      VmEndpointNatMappingsList,
                      VmEndpointNatMappings>
                  pageContext =
                      PageContext.create(
                          callable, GET_NAT_MAPPING_INFO_PAGE_STR_DESC, request, context);
              return GetNatMappingInfoPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<ListRoutersRequest, RouterList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListRoutersRequest, RouterList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutersRequest, RouterList> callable,
                ListRoutersRequest request,
                ApiCallContext context,
                ApiFuture<RouterList> futureResponse) {
              PageContext<ListRoutersRequest, RouterList, Router> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRouterRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRouterRequest, Router> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getNatMappingInfo. */
  public PagedCallSettings<
          GetNatMappingInfoRoutersRequest,
          VmEndpointNatMappingsList,
          GetNatMappingInfoPagedResponse>
      getNatMappingInfoSettings() {
    return getNatMappingInfoSettings;
  }

  /** Returns the object with the settings used for calls to getRouterStatus. */
  public UnaryCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusSettings() {
    return getRouterStatusSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRouterRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRoutersRequest, RouterList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRouterRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to preview. */
  public UnaryCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewSettings() {
    return previewSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateRouterRequest, Operation> updateSettings() {
    return updateSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RoutersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRoutersStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(RoutersStubSettings.class))
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

  protected RoutersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getNatMappingInfoSettings = settingsBuilder.getNatMappingInfoSettings().build();
    getRouterStatusSettings = settingsBuilder.getRouterStatusSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    previewSettings = settingsBuilder.previewSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
  }

  /** Builder for RoutersStubSettings. */
  public static class Builder extends StubSettings.Builder<RoutersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<GetRouterRequest, Router> getSettings;
    private final PagedCallSettings.Builder<
            GetNatMappingInfoRoutersRequest,
            VmEndpointNatMappingsList,
            GetNatMappingInfoPagedResponse>
        getNatMappingInfoSettings;
    private final UnaryCallSettings.Builder<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusSettings;
    private final UnaryCallSettings.Builder<InsertRouterRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<ListRoutersRequest, RouterList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchRouterRequest, Operation> patchSettings;
    private final UnaryCallSettings.Builder<PreviewRouterRequest, RoutersPreviewResponse>
        previewSettings;
    private final UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNatMappingInfoSettings = PagedCallSettings.newBuilder(GET_NAT_MAPPING_INFO_PAGE_STR_FACT);
      getRouterStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      previewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getNatMappingInfoSettings,
              getRouterStatusSettings,
              insertSettings,
              listSettings,
              patchSettings,
              previewSettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(RoutersStubSettings settings) {
      super(settings);

      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getNatMappingInfoSettings = settings.getNatMappingInfoSettings.toBuilder();
      getRouterStatusSettings = settings.getRouterStatusSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      previewSettings = settings.previewSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListSettings,
              deleteSettings,
              getSettings,
              getNatMappingInfoSettings,
              getRouterStatusSettings,
              insertSettings,
              listSettings,
              patchSettings,
              previewSettings,
              updateSettings);
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
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNatMappingInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRouterStatusSettings()
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
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .previewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListRoutersRequest, RouterAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRouterRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRouterRequest, Router> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getNatMappingInfo. */
    public PagedCallSettings.Builder<
            GetNatMappingInfoRoutersRequest,
            VmEndpointNatMappingsList,
            GetNatMappingInfoPagedResponse>
        getNatMappingInfoSettings() {
      return getNatMappingInfoSettings;
    }

    /** Returns the builder for the settings used for calls to getRouterStatus. */
    public UnaryCallSettings.Builder<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusSettings() {
      return getRouterStatusSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRouterRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRoutersRequest, RouterList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRouterRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to preview. */
    public UnaryCallSettings.Builder<PreviewRouterRequest, RoutersPreviewResponse>
        previewSettings() {
      return previewSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateRouterRequest, Operation> updateSettings() {
      return updateSettings;
    }

    @Override
    public RoutersStubSettings build() throws IOException {
      return new RoutersStubSettings(this);
    }
  }
}
