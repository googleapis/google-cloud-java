/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListToolsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CreateToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportToolsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetToolRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListToolsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListToolsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Tool;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateToolRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link ToolsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ToolsStubSettings.Builder toolsSettingsBuilder = ToolsStubSettings.newBuilder();
 * toolsSettingsBuilder
 *     .createToolSettings()
 *     .setRetrySettings(
 *         toolsSettingsBuilder
 *             .createToolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ToolsStubSettings toolsSettings = toolsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ToolsStubSettings extends StubSettings<ToolsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateToolRequest, Tool> createToolSettings;
  private final PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings;
  private final UnaryCallSettings<ExportToolsRequest, Operation> exportToolsSettings;
  private final OperationCallSettings<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationSettings;
  private final UnaryCallSettings<GetToolRequest, Tool> getToolSettings;
  private final UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings;
  private final UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListToolsRequest, ListToolsResponse, Tool>
      LIST_TOOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListToolsRequest, ListToolsResponse, Tool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListToolsRequest injectToken(ListToolsRequest payload, String token) {
              return ListToolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListToolsRequest injectPageSize(ListToolsRequest payload, int pageSize) {
              return ListToolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListToolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListToolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Tool> extractResources(ListToolsResponse payload) {
              return payload.getToolsList() == null
                  ? ImmutableList.<Tool>of()
                  : payload.getToolsList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      LIST_TOOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>() {
            @Override
            public ApiFuture<ListToolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListToolsRequest, ListToolsResponse> callable,
                ListToolsRequest request,
                ApiCallContext context,
                ApiFuture<ListToolsResponse> futureResponse) {
              PageContext<ListToolsRequest, ListToolsResponse, Tool> pageContext =
                  PageContext.create(callable, LIST_TOOLS_PAGE_STR_DESC, request, context);
              return ListToolsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createTool. */
  public UnaryCallSettings<CreateToolRequest, Tool> createToolSettings() {
    return createToolSettings;
  }

  /** Returns the object with the settings used for calls to listTools. */
  public PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings() {
    return listToolsSettings;
  }

  /** Returns the object with the settings used for calls to exportTools. */
  public UnaryCallSettings<ExportToolsRequest, Operation> exportToolsSettings() {
    return exportToolsSettings;
  }

  /** Returns the object with the settings used for calls to exportTools. */
  public OperationCallSettings<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationSettings() {
    return exportToolsOperationSettings;
  }

  /** Returns the object with the settings used for calls to getTool. */
  public UnaryCallSettings<GetToolRequest, Tool> getToolSettings() {
    return getToolSettings;
  }

  /** Returns the object with the settings used for calls to updateTool. */
  public UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings() {
    return updateToolSettings;
  }

  /** Returns the object with the settings used for calls to deleteTool. */
  public UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings() {
    return deleteToolSettings;
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

  public ToolsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcToolsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonToolsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dialogflow";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ToolsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ToolsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ToolsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ToolsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createToolSettings = settingsBuilder.createToolSettings().build();
    listToolsSettings = settingsBuilder.listToolsSettings().build();
    exportToolsSettings = settingsBuilder.exportToolsSettings().build();
    exportToolsOperationSettings = settingsBuilder.exportToolsOperationSettings().build();
    getToolSettings = settingsBuilder.getToolSettings().build();
    updateToolSettings = settingsBuilder.updateToolSettings().build();
    deleteToolSettings = settingsBuilder.deleteToolSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ToolsStubSettings. */
  public static class Builder extends StubSettings.Builder<ToolsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings;
    private final PagedCallSettings.Builder<
            ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings;
    private final UnaryCallSettings.Builder<ExportToolsRequest, Operation> exportToolsSettings;
    private final OperationCallSettings.Builder<
            ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
        exportToolsOperationSettings;
    private final UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings;
    private final UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings;
    private final UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      createToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listToolsSettings = PagedCallSettings.newBuilder(LIST_TOOLS_PAGE_STR_FACT);
      exportToolsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportToolsOperationSettings = OperationCallSettings.newBuilder();
      getToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteToolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createToolSettings,
              listToolsSettings,
              exportToolsSettings,
              getToolSettings,
              updateToolSettings,
              deleteToolSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ToolsStubSettings settings) {
      super(settings);

      createToolSettings = settings.createToolSettings.toBuilder();
      listToolsSettings = settings.listToolsSettings.toBuilder();
      exportToolsSettings = settings.exportToolsSettings.toBuilder();
      exportToolsOperationSettings = settings.exportToolsOperationSettings.toBuilder();
      getToolSettings = settings.getToolSettings.toBuilder();
      updateToolSettings = settings.updateToolSettings.toBuilder();
      deleteToolSettings = settings.deleteToolSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createToolSettings,
              listToolsSettings,
              exportToolsSettings,
              getToolSettings,
              updateToolSettings,
              deleteToolSettings,
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
          .createToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listToolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportToolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteToolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportToolsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportToolsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportToolsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ExportToolsMetadata.class))
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

    /** Returns the builder for the settings used for calls to createTool. */
    public UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings() {
      return createToolSettings;
    }

    /** Returns the builder for the settings used for calls to listTools. */
    public PagedCallSettings.Builder<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings() {
      return listToolsSettings;
    }

    /** Returns the builder for the settings used for calls to exportTools. */
    public UnaryCallSettings.Builder<ExportToolsRequest, Operation> exportToolsSettings() {
      return exportToolsSettings;
    }

    /** Returns the builder for the settings used for calls to exportTools. */
    public OperationCallSettings.Builder<
            ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
        exportToolsOperationSettings() {
      return exportToolsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getTool. */
    public UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings() {
      return getToolSettings;
    }

    /** Returns the builder for the settings used for calls to updateTool. */
    public UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings() {
      return updateToolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTool. */
    public UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings() {
      return deleteToolSettings;
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
    public ToolsStubSettings build() throws IOException {
      return new ToolsStubSettings(this);
    }
  }
}
