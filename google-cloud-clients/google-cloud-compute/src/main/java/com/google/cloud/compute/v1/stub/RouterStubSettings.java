/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RouterClient.AggregatedListRoutersPagedResponse;
import static com.google.cloud.compute.v1.RouterClient.ListRoutersPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRoutersHttpRequest;
import com.google.cloud.compute.v1.DeleteRouterHttpRequest;
import com.google.cloud.compute.v1.GetRouterHttpRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterHttpRequest;
import com.google.cloud.compute.v1.InsertRouterHttpRequest;
import com.google.cloud.compute.v1.ListRoutersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRouterHttpRequest;
import com.google.cloud.compute.v1.PreviewRouterHttpRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.RoutersScopedList;
import com.google.cloud.compute.v1.UpdateRouterHttpRequest;
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
 * Settings class to configure an instance of {@link RouterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteRouter to 30 seconds:
 *
 * <pre>
 * <code>
 * RouterStubSettings.Builder routerSettingsBuilder =
 *     RouterStubSettings.newBuilder();
 * routerSettingsBuilder.deleteRouterSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RouterStubSettings routerSettings = routerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RouterStubSettings extends StubSettings<RouterStubSettings> {
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
          AggregatedListRoutersHttpRequest,
          RouterAggregatedList,
          AggregatedListRoutersPagedResponse>
      aggregatedListRoutersSettings;
  private final UnaryCallSettings<DeleteRouterHttpRequest, Operation> deleteRouterSettings;
  private final UnaryCallSettings<GetRouterHttpRequest, Router> getRouterSettings;
  private final UnaryCallSettings<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterSettings;
  private final UnaryCallSettings<InsertRouterHttpRequest, Operation> insertRouterSettings;
  private final PagedCallSettings<ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
      listRoutersSettings;
  private final UnaryCallSettings<PatchRouterHttpRequest, Operation> patchRouterSettings;
  private final UnaryCallSettings<PreviewRouterHttpRequest, RoutersPreviewResponse>
      previewRouterSettings;
  private final UnaryCallSettings<UpdateRouterHttpRequest, Operation> updateRouterSettings;

  /** Returns the object with the settings used for calls to aggregatedListRouters. */
  public PagedCallSettings<
          AggregatedListRoutersHttpRequest,
          RouterAggregatedList,
          AggregatedListRoutersPagedResponse>
      aggregatedListRoutersSettings() {
    return aggregatedListRoutersSettings;
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public UnaryCallSettings<DeleteRouterHttpRequest, Operation> deleteRouterSettings() {
    return deleteRouterSettings;
  }

  /** Returns the object with the settings used for calls to getRouter. */
  public UnaryCallSettings<GetRouterHttpRequest, Router> getRouterSettings() {
    return getRouterSettings;
  }

  /** Returns the object with the settings used for calls to getRouterStatusRouter. */
  public UnaryCallSettings<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterSettings() {
    return getRouterStatusRouterSettings;
  }

  /** Returns the object with the settings used for calls to insertRouter. */
  public UnaryCallSettings<InsertRouterHttpRequest, Operation> insertRouterSettings() {
    return insertRouterSettings;
  }

  /** Returns the object with the settings used for calls to listRouters. */
  public PagedCallSettings<ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
      listRoutersSettings() {
    return listRoutersSettings;
  }

  /** Returns the object with the settings used for calls to patchRouter. */
  public UnaryCallSettings<PatchRouterHttpRequest, Operation> patchRouterSettings() {
    return patchRouterSettings;
  }

  /** Returns the object with the settings used for calls to previewRouter. */
  public UnaryCallSettings<PreviewRouterHttpRequest, RoutersPreviewResponse>
      previewRouterSettings() {
    return previewRouterSettings;
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public UnaryCallSettings<UpdateRouterHttpRequest, Operation> updateRouterSettings() {
    return updateRouterSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RouterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRouterStub.create(this);
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
    return "https://www.googleapis.com/compute/v1/projects/";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(RouterStubSettings.class))
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

  protected RouterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListRoutersSettings = settingsBuilder.aggregatedListRoutersSettings().build();
    deleteRouterSettings = settingsBuilder.deleteRouterSettings().build();
    getRouterSettings = settingsBuilder.getRouterSettings().build();
    getRouterStatusRouterSettings = settingsBuilder.getRouterStatusRouterSettings().build();
    insertRouterSettings = settingsBuilder.insertRouterSettings().build();
    listRoutersSettings = settingsBuilder.listRoutersSettings().build();
    patchRouterSettings = settingsBuilder.patchRouterSettings().build();
    previewRouterSettings = settingsBuilder.previewRouterSettings().build();
    updateRouterSettings = settingsBuilder.updateRouterSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListRoutersHttpRequest, RouterAggregatedList, RoutersScopedList>
      AGGREGATED_LIST_ROUTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListRoutersHttpRequest, RouterAggregatedList, RoutersScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListRoutersHttpRequest injectToken(
                AggregatedListRoutersHttpRequest payload, String token) {
              return AggregatedListRoutersHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListRoutersHttpRequest injectPageSize(
                AggregatedListRoutersHttpRequest payload, int pageSize) {
              return AggregatedListRoutersHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListRoutersHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RoutersScopedList> extractResources(RouterAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<RoutersScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListRoutersHttpRequest, RouterList, Router>
      LIST_ROUTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutersHttpRequest, RouterList, Router>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutersHttpRequest injectToken(
                ListRoutersHttpRequest payload, String token) {
              return ListRoutersHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoutersHttpRequest injectPageSize(
                ListRoutersHttpRequest payload, int pageSize) {
              return ListRoutersHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutersHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RouterList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Router> extractResources(RouterList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Router>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListRoutersHttpRequest,
          RouterAggregatedList,
          AggregatedListRoutersPagedResponse>
      AGGREGATED_LIST_ROUTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListRoutersHttpRequest,
              RouterAggregatedList,
              AggregatedListRoutersPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListRoutersPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListRoutersHttpRequest, RouterAggregatedList> callable,
                AggregatedListRoutersHttpRequest request,
                ApiCallContext context,
                ApiFuture<RouterAggregatedList> futureResponse) {
              PageContext<AggregatedListRoutersHttpRequest, RouterAggregatedList, RoutersScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_ROUTERS_PAGE_STR_DESC, request, context);
              return AggregatedListRoutersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
      LIST_ROUTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>() {
            @Override
            public ApiFuture<ListRoutersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutersHttpRequest, RouterList> callable,
                ListRoutersHttpRequest request,
                ApiCallContext context,
                ApiFuture<RouterList> futureResponse) {
              PageContext<ListRoutersHttpRequest, RouterList, Router> pageContext =
                  PageContext.create(callable, LIST_ROUTERS_PAGE_STR_DESC, request, context);
              return ListRoutersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RouterStubSettings. */
  public static class Builder extends StubSettings.Builder<RouterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListRoutersHttpRequest,
            RouterAggregatedList,
            AggregatedListRoutersPagedResponse>
        aggregatedListRoutersSettings;
    private final UnaryCallSettings.Builder<DeleteRouterHttpRequest, Operation>
        deleteRouterSettings;
    private final UnaryCallSettings.Builder<GetRouterHttpRequest, Router> getRouterSettings;
    private final UnaryCallSettings.Builder<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
        getRouterStatusRouterSettings;
    private final UnaryCallSettings.Builder<InsertRouterHttpRequest, Operation>
        insertRouterSettings;
    private final PagedCallSettings.Builder<
            ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
        listRoutersSettings;
    private final UnaryCallSettings.Builder<PatchRouterHttpRequest, Operation> patchRouterSettings;
    private final UnaryCallSettings.Builder<PreviewRouterHttpRequest, RoutersPreviewResponse>
        previewRouterSettings;
    private final UnaryCallSettings.Builder<UpdateRouterHttpRequest, Operation>
        updateRouterSettings;

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

      aggregatedListRoutersSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_ROUTERS_PAGE_STR_FACT);

      deleteRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRouterStatusRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRoutersSettings = PagedCallSettings.newBuilder(LIST_ROUTERS_PAGE_STR_FACT);

      patchRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      previewRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateRouterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListRoutersSettings,
              deleteRouterSettings,
              getRouterSettings,
              getRouterStatusRouterSettings,
              insertRouterSettings,
              listRoutersSettings,
              patchRouterSettings,
              previewRouterSettings,
              updateRouterSettings);

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
          .aggregatedListRoutersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRouterStatusRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRoutersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .previewRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateRouterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RouterStubSettings settings) {
      super(settings);

      aggregatedListRoutersSettings = settings.aggregatedListRoutersSettings.toBuilder();
      deleteRouterSettings = settings.deleteRouterSettings.toBuilder();
      getRouterSettings = settings.getRouterSettings.toBuilder();
      getRouterStatusRouterSettings = settings.getRouterStatusRouterSettings.toBuilder();
      insertRouterSettings = settings.insertRouterSettings.toBuilder();
      listRoutersSettings = settings.listRoutersSettings.toBuilder();
      patchRouterSettings = settings.patchRouterSettings.toBuilder();
      previewRouterSettings = settings.previewRouterSettings.toBuilder();
      updateRouterSettings = settings.updateRouterSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListRoutersSettings,
              deleteRouterSettings,
              getRouterSettings,
              getRouterStatusRouterSettings,
              insertRouterSettings,
              listRoutersSettings,
              patchRouterSettings,
              previewRouterSettings,
              updateRouterSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListRouters. */
    public PagedCallSettings.Builder<
            AggregatedListRoutersHttpRequest,
            RouterAggregatedList,
            AggregatedListRoutersPagedResponse>
        aggregatedListRoutersSettings() {
      return aggregatedListRoutersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public UnaryCallSettings.Builder<DeleteRouterHttpRequest, Operation> deleteRouterSettings() {
      return deleteRouterSettings;
    }

    /** Returns the builder for the settings used for calls to getRouter. */
    public UnaryCallSettings.Builder<GetRouterHttpRequest, Router> getRouterSettings() {
      return getRouterSettings;
    }

    /** Returns the builder for the settings used for calls to getRouterStatusRouter. */
    public UnaryCallSettings.Builder<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
        getRouterStatusRouterSettings() {
      return getRouterStatusRouterSettings;
    }

    /** Returns the builder for the settings used for calls to insertRouter. */
    public UnaryCallSettings.Builder<InsertRouterHttpRequest, Operation> insertRouterSettings() {
      return insertRouterSettings;
    }

    /** Returns the builder for the settings used for calls to listRouters. */
    public PagedCallSettings.Builder<ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
        listRoutersSettings() {
      return listRoutersSettings;
    }

    /** Returns the builder for the settings used for calls to patchRouter. */
    public UnaryCallSettings.Builder<PatchRouterHttpRequest, Operation> patchRouterSettings() {
      return patchRouterSettings;
    }

    /** Returns the builder for the settings used for calls to previewRouter. */
    public UnaryCallSettings.Builder<PreviewRouterHttpRequest, RoutersPreviewResponse>
        previewRouterSettings() {
      return previewRouterSettings;
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public UnaryCallSettings.Builder<UpdateRouterHttpRequest, Operation> updateRouterSettings() {
      return updateRouterSettings;
    }

    @Override
    public RouterStubSettings build() throws IOException {
      return new RouterStubSettings(this);
    }
  }
}
