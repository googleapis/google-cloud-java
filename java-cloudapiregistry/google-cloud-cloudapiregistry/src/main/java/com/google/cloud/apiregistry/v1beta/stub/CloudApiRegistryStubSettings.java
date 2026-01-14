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

package com.google.cloud.apiregistry.v1beta.stub;

import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpToolsPagedResponse;

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
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apiregistry.v1beta.GetMcpServerRequest;
import com.google.cloud.apiregistry.v1beta.GetMcpToolRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpServersRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpServersResponse;
import com.google.cloud.apiregistry.v1beta.ListMcpToolsRequest;
import com.google.cloud.apiregistry.v1beta.ListMcpToolsResponse;
import com.google.cloud.apiregistry.v1beta.McpServer;
import com.google.cloud.apiregistry.v1beta.McpTool;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudApiRegistryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudapiregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMcpServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudApiRegistryStubSettings.Builder cloudApiRegistrySettingsBuilder =
 *     CloudApiRegistryStubSettings.newBuilder();
 * cloudApiRegistrySettingsBuilder
 *     .getMcpServerSettings()
 *     .setRetrySettings(
 *         cloudApiRegistrySettingsBuilder
 *             .getMcpServerSettings()
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
 * CloudApiRegistryStubSettings cloudApiRegistrySettings = cloudApiRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudApiRegistryStubSettings extends StubSettings<CloudApiRegistryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings;
  private final PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings;
  private final UnaryCallSettings<GetMcpToolRequest, McpTool> getMcpToolSettings;
  private final PagedCallSettings<
          ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
      listMcpToolsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListMcpServersRequest, ListMcpServersResponse, McpServer>
      LIST_MCP_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMcpServersRequest, ListMcpServersResponse, McpServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMcpServersRequest injectToken(ListMcpServersRequest payload, String token) {
              return ListMcpServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMcpServersRequest injectPageSize(
                ListMcpServersRequest payload, int pageSize) {
              return ListMcpServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMcpServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMcpServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<McpServer> extractResources(ListMcpServersResponse payload) {
              return payload.getMcpServersList();
            }
          };

  private static final PagedListDescriptor<ListMcpToolsRequest, ListMcpToolsResponse, McpTool>
      LIST_MCP_TOOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMcpToolsRequest, ListMcpToolsResponse, McpTool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMcpToolsRequest injectToken(ListMcpToolsRequest payload, String token) {
              return ListMcpToolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMcpToolsRequest injectPageSize(ListMcpToolsRequest payload, int pageSize) {
              return ListMcpToolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMcpToolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMcpToolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<McpTool> extractResources(ListMcpToolsResponse payload) {
              return payload.getMcpToolsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      LIST_MCP_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>() {
            @Override
            public ApiFuture<ListMcpServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMcpServersRequest, ListMcpServersResponse> callable,
                ListMcpServersRequest request,
                ApiCallContext context,
                ApiFuture<ListMcpServersResponse> futureResponse) {
              PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> pageContext =
                  PageContext.create(callable, LIST_MCP_SERVERS_PAGE_STR_DESC, request, context);
              return ListMcpServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
      LIST_MCP_TOOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>() {
            @Override
            public ApiFuture<ListMcpToolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMcpToolsRequest, ListMcpToolsResponse> callable,
                ListMcpToolsRequest request,
                ApiCallContext context,
                ApiFuture<ListMcpToolsResponse> futureResponse) {
              PageContext<ListMcpToolsRequest, ListMcpToolsResponse, McpTool> pageContext =
                  PageContext.create(callable, LIST_MCP_TOOLS_PAGE_STR_DESC, request, context);
              return ListMcpToolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getMcpServer. */
  public UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings() {
    return getMcpServerSettings;
  }

  /** Returns the object with the settings used for calls to listMcpServers. */
  public PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings() {
    return listMcpServersSettings;
  }

  /** Returns the object with the settings used for calls to getMcpTool. */
  public UnaryCallSettings<GetMcpToolRequest, McpTool> getMcpToolSettings() {
    return getMcpToolSettings;
  }

  /** Returns the object with the settings used for calls to listMcpTools. */
  public PagedCallSettings<ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
      listMcpToolsSettings() {
    return listMcpToolsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public CloudApiRegistryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudApiRegistryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudApiRegistryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudapiregistry";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudapiregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudapiregistry.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CloudApiRegistryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudApiRegistryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CloudApiRegistryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getMcpServerSettings = settingsBuilder.getMcpServerSettings().build();
    listMcpServersSettings = settingsBuilder.listMcpServersSettings().build();
    getMcpToolSettings = settingsBuilder.getMcpToolSettings().build();
    listMcpToolsSettings = settingsBuilder.listMcpToolsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for CloudApiRegistryStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudApiRegistryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings;
    private final PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings;
    private final UnaryCallSettings.Builder<GetMcpToolRequest, McpTool> getMcpToolSettings;
    private final PagedCallSettings.Builder<
            ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
        listMcpToolsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getMcpServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMcpServersSettings = PagedCallSettings.newBuilder(LIST_MCP_SERVERS_PAGE_STR_FACT);
      getMcpToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMcpToolsSettings = PagedCallSettings.newBuilder(LIST_MCP_TOOLS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMcpServerSettings,
              listMcpServersSettings,
              getMcpToolSettings,
              listMcpToolsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(CloudApiRegistryStubSettings settings) {
      super(settings);

      getMcpServerSettings = settings.getMcpServerSettings.toBuilder();
      listMcpServersSettings = settings.listMcpServersSettings.toBuilder();
      getMcpToolSettings = settings.getMcpToolSettings.toBuilder();
      listMcpToolsSettings = settings.listMcpToolsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMcpServerSettings,
              listMcpServersSettings,
              getMcpToolSettings,
              listMcpToolsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .getMcpServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMcpServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMcpToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMcpToolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to getMcpServer. */
    public UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings() {
      return getMcpServerSettings;
    }

    /** Returns the builder for the settings used for calls to listMcpServers. */
    public PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings() {
      return listMcpServersSettings;
    }

    /** Returns the builder for the settings used for calls to getMcpTool. */
    public UnaryCallSettings.Builder<GetMcpToolRequest, McpTool> getMcpToolSettings() {
      return getMcpToolSettings;
    }

    /** Returns the builder for the settings used for calls to listMcpTools. */
    public PagedCallSettings.Builder<
            ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
        listMcpToolsSettings() {
      return listMcpToolsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public CloudApiRegistryStubSettings build() throws IOException {
      return new CloudApiRegistryStubSettings(this);
    }
  }
}
