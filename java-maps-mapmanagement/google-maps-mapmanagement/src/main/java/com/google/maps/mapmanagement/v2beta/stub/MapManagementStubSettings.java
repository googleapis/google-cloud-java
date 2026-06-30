/*
 * Copyright 2026 Google LLC
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

package com.google.maps.mapmanagement.v2beta.stub;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse;
import com.google.maps.mapmanagement.v2beta.MapConfig;
import com.google.maps.mapmanagement.v2beta.MapContextConfig;
import com.google.maps.mapmanagement.v2beta.StyleConfig;
import com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MapManagementStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (mapmanagement.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createMapConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MapManagementStubSettings.Builder mapManagementSettingsBuilder =
 *     MapManagementStubSettings.newBuilder();
 * mapManagementSettingsBuilder
 *     .createMapConfigSettings()
 *     .setRetrySettings(
 *         mapManagementSettingsBuilder
 *             .createMapConfigSettings()
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
 * MapManagementStubSettings mapManagementSettings = mapManagementSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class MapManagementStubSettings extends StubSettings<MapManagementStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateMapConfigRequest, MapConfig> createMapConfigSettings;
  private final UnaryCallSettings<GetMapConfigRequest, MapConfig> getMapConfigSettings;
  private final PagedCallSettings<
          ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
      listMapConfigsSettings;
  private final UnaryCallSettings<UpdateMapConfigRequest, MapConfig> updateMapConfigSettings;
  private final UnaryCallSettings<DeleteMapConfigRequest, Empty> deleteMapConfigSettings;
  private final UnaryCallSettings<CreateStyleConfigRequest, StyleConfig> createStyleConfigSettings;
  private final UnaryCallSettings<GetStyleConfigRequest, StyleConfig> getStyleConfigSettings;
  private final PagedCallSettings<
          ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
      listStyleConfigsSettings;
  private final UnaryCallSettings<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigSettings;
  private final UnaryCallSettings<DeleteStyleConfigRequest, Empty> deleteStyleConfigSettings;
  private final UnaryCallSettings<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigSettings;
  private final UnaryCallSettings<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigSettings;
  private final PagedCallSettings<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          ListMapContextConfigsPagedResponse>
      listMapContextConfigsSettings;
  private final UnaryCallSettings<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigSettings;
  private final UnaryCallSettings<DeleteMapContextConfigRequest, Empty>
      deleteMapContextConfigSettings;

  private static final PagedListDescriptor<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig>
      LIST_MAP_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMapConfigsRequest injectToken(ListMapConfigsRequest payload, String token) {
              return ListMapConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMapConfigsRequest injectPageSize(
                ListMapConfigsRequest payload, int pageSize) {
              return ListMapConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMapConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMapConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MapConfig> extractResources(ListMapConfigsResponse payload) {
              return payload.getMapConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig>
      LIST_STYLE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStyleConfigsRequest injectToken(
                ListStyleConfigsRequest payload, String token) {
              return ListStyleConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStyleConfigsRequest injectPageSize(
                ListStyleConfigsRequest payload, int pageSize) {
              return ListStyleConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStyleConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStyleConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StyleConfig> extractResources(ListStyleConfigsResponse payload) {
              return payload.getStyleConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
      LIST_MAP_CONTEXT_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMapContextConfigsRequest injectToken(
                ListMapContextConfigsRequest payload, String token) {
              return ListMapContextConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMapContextConfigsRequest injectPageSize(
                ListMapContextConfigsRequest payload, int pageSize) {
              return ListMapContextConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMapContextConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMapContextConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MapContextConfig> extractResources(
                ListMapContextConfigsResponse payload) {
              return payload.getMapContextConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
      LIST_MAP_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListMapConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> callable,
                ListMapConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListMapConfigsResponse> futureResponse) {
              PageContext<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig> pageContext =
                  PageContext.create(callable, LIST_MAP_CONFIGS_PAGE_STR_DESC, request, context);
              return ListMapConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
      LIST_STYLE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListStyleConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse> callable,
                ListStyleConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListStyleConfigsResponse> futureResponse) {
              PageContext<ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_STYLE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListStyleConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          ListMapContextConfigsPagedResponse>
      LIST_MAP_CONTEXT_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMapContextConfigsRequest,
              ListMapContextConfigsResponse,
              ListMapContextConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListMapContextConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse> callable,
                ListMapContextConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListMapContextConfigsResponse> futureResponse) {
              PageContext<
                      ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MAP_CONTEXT_CONFIGS_PAGE_STR_DESC, request, context);
              return ListMapContextConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createMapConfig. */
  public UnaryCallSettings<CreateMapConfigRequest, MapConfig> createMapConfigSettings() {
    return createMapConfigSettings;
  }

  /** Returns the object with the settings used for calls to getMapConfig. */
  public UnaryCallSettings<GetMapConfigRequest, MapConfig> getMapConfigSettings() {
    return getMapConfigSettings;
  }

  /** Returns the object with the settings used for calls to listMapConfigs. */
  public PagedCallSettings<
          ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
      listMapConfigsSettings() {
    return listMapConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateMapConfig. */
  public UnaryCallSettings<UpdateMapConfigRequest, MapConfig> updateMapConfigSettings() {
    return updateMapConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteMapConfig. */
  public UnaryCallSettings<DeleteMapConfigRequest, Empty> deleteMapConfigSettings() {
    return deleteMapConfigSettings;
  }

  /** Returns the object with the settings used for calls to createStyleConfig. */
  public UnaryCallSettings<CreateStyleConfigRequest, StyleConfig> createStyleConfigSettings() {
    return createStyleConfigSettings;
  }

  /** Returns the object with the settings used for calls to getStyleConfig. */
  public UnaryCallSettings<GetStyleConfigRequest, StyleConfig> getStyleConfigSettings() {
    return getStyleConfigSettings;
  }

  /** Returns the object with the settings used for calls to listStyleConfigs. */
  public PagedCallSettings<
          ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
      listStyleConfigsSettings() {
    return listStyleConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateStyleConfig. */
  public UnaryCallSettings<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigSettings() {
    return updateStyleConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteStyleConfig. */
  public UnaryCallSettings<DeleteStyleConfigRequest, Empty> deleteStyleConfigSettings() {
    return deleteStyleConfigSettings;
  }

  /** Returns the object with the settings used for calls to createMapContextConfig. */
  public UnaryCallSettings<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigSettings() {
    return createMapContextConfigSettings;
  }

  /** Returns the object with the settings used for calls to getMapContextConfig. */
  public UnaryCallSettings<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigSettings() {
    return getMapContextConfigSettings;
  }

  /** Returns the object with the settings used for calls to listMapContextConfigs. */
  public PagedCallSettings<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          ListMapContextConfigsPagedResponse>
      listMapContextConfigsSettings() {
    return listMapContextConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateMapContextConfig. */
  public UnaryCallSettings<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigSettings() {
    return updateMapContextConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteMapContextConfig. */
  public UnaryCallSettings<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigSettings() {
    return deleteMapContextConfigSettings;
  }

  public MapManagementStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMapManagementStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMapManagementStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "mapmanagement";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "mapmanagement.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "mapmanagement.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(MapManagementStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MapManagementStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MapManagementStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MapManagementStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMapConfigSettings = settingsBuilder.createMapConfigSettings().build();
    getMapConfigSettings = settingsBuilder.getMapConfigSettings().build();
    listMapConfigsSettings = settingsBuilder.listMapConfigsSettings().build();
    updateMapConfigSettings = settingsBuilder.updateMapConfigSettings().build();
    deleteMapConfigSettings = settingsBuilder.deleteMapConfigSettings().build();
    createStyleConfigSettings = settingsBuilder.createStyleConfigSettings().build();
    getStyleConfigSettings = settingsBuilder.getStyleConfigSettings().build();
    listStyleConfigsSettings = settingsBuilder.listStyleConfigsSettings().build();
    updateStyleConfigSettings = settingsBuilder.updateStyleConfigSettings().build();
    deleteStyleConfigSettings = settingsBuilder.deleteStyleConfigSettings().build();
    createMapContextConfigSettings = settingsBuilder.createMapContextConfigSettings().build();
    getMapContextConfigSettings = settingsBuilder.getMapContextConfigSettings().build();
    listMapContextConfigsSettings = settingsBuilder.listMapContextConfigsSettings().build();
    updateMapContextConfigSettings = settingsBuilder.updateMapContextConfigSettings().build();
    deleteMapContextConfigSettings = settingsBuilder.deleteMapContextConfigSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.maps:google-maps-mapmanagement")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for MapManagementStubSettings. */
  public static class Builder extends StubSettings.Builder<MapManagementStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMapConfigRequest, MapConfig>
        createMapConfigSettings;
    private final UnaryCallSettings.Builder<GetMapConfigRequest, MapConfig> getMapConfigSettings;
    private final PagedCallSettings.Builder<
            ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
        listMapConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateMapConfigRequest, MapConfig>
        updateMapConfigSettings;
    private final UnaryCallSettings.Builder<DeleteMapConfigRequest, Empty> deleteMapConfigSettings;
    private final UnaryCallSettings.Builder<CreateStyleConfigRequest, StyleConfig>
        createStyleConfigSettings;
    private final UnaryCallSettings.Builder<GetStyleConfigRequest, StyleConfig>
        getStyleConfigSettings;
    private final PagedCallSettings.Builder<
            ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
        listStyleConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateStyleConfigRequest, StyleConfig>
        updateStyleConfigSettings;
    private final UnaryCallSettings.Builder<DeleteStyleConfigRequest, Empty>
        deleteStyleConfigSettings;
    private final UnaryCallSettings.Builder<CreateMapContextConfigRequest, MapContextConfig>
        createMapContextConfigSettings;
    private final UnaryCallSettings.Builder<GetMapContextConfigRequest, MapContextConfig>
        getMapContextConfigSettings;
    private final PagedCallSettings.Builder<
            ListMapContextConfigsRequest,
            ListMapContextConfigsResponse,
            ListMapContextConfigsPagedResponse>
        listMapContextConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateMapContextConfigRequest, MapContextConfig>
        updateMapContextConfigSettings;
    private final UnaryCallSettings.Builder<DeleteMapContextConfigRequest, Empty>
        deleteMapContextConfigSettings;
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

      createMapConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMapConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMapConfigsSettings = PagedCallSettings.newBuilder(LIST_MAP_CONFIGS_PAGE_STR_FACT);
      updateMapConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMapConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStyleConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getStyleConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStyleConfigsSettings = PagedCallSettings.newBuilder(LIST_STYLE_CONFIGS_PAGE_STR_FACT);
      updateStyleConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteStyleConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMapContextConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMapContextConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMapContextConfigsSettings =
          PagedCallSettings.newBuilder(LIST_MAP_CONTEXT_CONFIGS_PAGE_STR_FACT);
      updateMapContextConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMapContextConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMapConfigSettings,
              getMapConfigSettings,
              listMapConfigsSettings,
              updateMapConfigSettings,
              deleteMapConfigSettings,
              createStyleConfigSettings,
              getStyleConfigSettings,
              listStyleConfigsSettings,
              updateStyleConfigSettings,
              deleteStyleConfigSettings,
              createMapContextConfigSettings,
              getMapContextConfigSettings,
              listMapContextConfigsSettings,
              updateMapContextConfigSettings,
              deleteMapContextConfigSettings);
      initDefaults(this);
    }

    protected Builder(MapManagementStubSettings settings) {
      super(settings);

      createMapConfigSettings = settings.createMapConfigSettings.toBuilder();
      getMapConfigSettings = settings.getMapConfigSettings.toBuilder();
      listMapConfigsSettings = settings.listMapConfigsSettings.toBuilder();
      updateMapConfigSettings = settings.updateMapConfigSettings.toBuilder();
      deleteMapConfigSettings = settings.deleteMapConfigSettings.toBuilder();
      createStyleConfigSettings = settings.createStyleConfigSettings.toBuilder();
      getStyleConfigSettings = settings.getStyleConfigSettings.toBuilder();
      listStyleConfigsSettings = settings.listStyleConfigsSettings.toBuilder();
      updateStyleConfigSettings = settings.updateStyleConfigSettings.toBuilder();
      deleteStyleConfigSettings = settings.deleteStyleConfigSettings.toBuilder();
      createMapContextConfigSettings = settings.createMapContextConfigSettings.toBuilder();
      getMapContextConfigSettings = settings.getMapContextConfigSettings.toBuilder();
      listMapContextConfigsSettings = settings.listMapContextConfigsSettings.toBuilder();
      updateMapContextConfigSettings = settings.updateMapContextConfigSettings.toBuilder();
      deleteMapContextConfigSettings = settings.deleteMapContextConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMapConfigSettings,
              getMapConfigSettings,
              listMapConfigsSettings,
              updateMapConfigSettings,
              deleteMapConfigSettings,
              createStyleConfigSettings,
              getStyleConfigSettings,
              listStyleConfigsSettings,
              updateStyleConfigSettings,
              deleteStyleConfigSettings,
              createMapContextConfigSettings,
              getMapContextConfigSettings,
              listMapContextConfigsSettings,
              updateMapContextConfigSettings,
              deleteMapContextConfigSettings);
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
          .createMapConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMapConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMapConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMapConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMapConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createStyleConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getStyleConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listStyleConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateStyleConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteStyleConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMapContextConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMapContextConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMapContextConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMapContextConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMapContextConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createMapConfig. */
    public UnaryCallSettings.Builder<CreateMapConfigRequest, MapConfig> createMapConfigSettings() {
      return createMapConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getMapConfig. */
    public UnaryCallSettings.Builder<GetMapConfigRequest, MapConfig> getMapConfigSettings() {
      return getMapConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listMapConfigs. */
    public PagedCallSettings.Builder<
            ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
        listMapConfigsSettings() {
      return listMapConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateMapConfig. */
    public UnaryCallSettings.Builder<UpdateMapConfigRequest, MapConfig> updateMapConfigSettings() {
      return updateMapConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMapConfig. */
    public UnaryCallSettings.Builder<DeleteMapConfigRequest, Empty> deleteMapConfigSettings() {
      return deleteMapConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createStyleConfig. */
    public UnaryCallSettings.Builder<CreateStyleConfigRequest, StyleConfig>
        createStyleConfigSettings() {
      return createStyleConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getStyleConfig. */
    public UnaryCallSettings.Builder<GetStyleConfigRequest, StyleConfig> getStyleConfigSettings() {
      return getStyleConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listStyleConfigs. */
    public PagedCallSettings.Builder<
            ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
        listStyleConfigsSettings() {
      return listStyleConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateStyleConfig. */
    public UnaryCallSettings.Builder<UpdateStyleConfigRequest, StyleConfig>
        updateStyleConfigSettings() {
      return updateStyleConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStyleConfig. */
    public UnaryCallSettings.Builder<DeleteStyleConfigRequest, Empty> deleteStyleConfigSettings() {
      return deleteStyleConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createMapContextConfig. */
    public UnaryCallSettings.Builder<CreateMapContextConfigRequest, MapContextConfig>
        createMapContextConfigSettings() {
      return createMapContextConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getMapContextConfig. */
    public UnaryCallSettings.Builder<GetMapContextConfigRequest, MapContextConfig>
        getMapContextConfigSettings() {
      return getMapContextConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listMapContextConfigs. */
    public PagedCallSettings.Builder<
            ListMapContextConfigsRequest,
            ListMapContextConfigsResponse,
            ListMapContextConfigsPagedResponse>
        listMapContextConfigsSettings() {
      return listMapContextConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateMapContextConfig. */
    public UnaryCallSettings.Builder<UpdateMapContextConfigRequest, MapContextConfig>
        updateMapContextConfigSettings() {
      return updateMapContextConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMapContextConfig. */
    public UnaryCallSettings.Builder<DeleteMapContextConfigRequest, Empty>
        deleteMapContextConfigSettings() {
      return deleteMapContextConfigSettings;
    }

    @Override
    public MapManagementStubSettings build() throws IOException {
      return new MapManagementStubSettings(this);
    }
  }
}
