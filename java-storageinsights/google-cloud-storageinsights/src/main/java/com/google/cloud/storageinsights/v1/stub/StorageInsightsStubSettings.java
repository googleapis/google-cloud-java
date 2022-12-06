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

package com.google.cloud.storageinsights.v1.stub;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StorageInsightsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (storageinsights.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getReportConfig to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageInsightsStubSettings.Builder storageInsightsSettingsBuilder =
 *     StorageInsightsStubSettings.newBuilder();
 * storageInsightsSettingsBuilder
 *     .getReportConfigSettings()
 *     .setRetrySettings(
 *         storageInsightsSettingsBuilder.getReportConfigSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StorageInsightsStubSettings storageInsightsSettings = storageInsightsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StorageInsightsStubSettings extends StubSettings<StorageInsightsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings;
  private final UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings;
  private final UnaryCallSettings<CreateReportConfigRequest, ReportConfig>
      createReportConfigSettings;
  private final UnaryCallSettings<UpdateReportConfigRequest, ReportConfig>
      updateReportConfigSettings;
  private final UnaryCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigSettings;
  private final PagedCallSettings<
          ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
      listReportDetailsSettings;
  private final UnaryCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>
      LIST_REPORT_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReportConfigsRequest injectToken(
                ListReportConfigsRequest payload, String token) {
              return ListReportConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReportConfigsRequest injectPageSize(
                ListReportConfigsRequest payload, int pageSize) {
              return ListReportConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReportConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReportConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReportConfig> extractResources(ListReportConfigsResponse payload) {
              return payload.getReportConfigsList() == null
                  ? ImmutableList.<ReportConfig>of()
                  : payload.getReportConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail>
      LIST_REPORT_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReportDetailsRequest injectToken(
                ListReportDetailsRequest payload, String token) {
              return ListReportDetailsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReportDetailsRequest injectPageSize(
                ListReportDetailsRequest payload, int pageSize) {
              return ListReportDetailsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReportDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReportDetailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReportDetail> extractResources(ListReportDetailsResponse payload) {
              return payload.getReportDetailsList() == null
                  ? ImmutableList.<ReportDetail>of()
                  : payload.getReportDetailsList();
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
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      LIST_REPORT_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReportConfigsRequest,
              ListReportConfigsResponse,
              ListReportConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListReportConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse> callable,
                ListReportConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListReportConfigsResponse> futureResponse) {
              PageContext<ListReportConfigsRequest, ListReportConfigsResponse, ReportConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPORT_CONFIGS_PAGE_STR_DESC, request, context);
              return ListReportConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
      LIST_REPORT_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReportDetailsRequest,
              ListReportDetailsResponse,
              ListReportDetailsPagedResponse>() {
            @Override
            public ApiFuture<ListReportDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse> callable,
                ListReportDetailsRequest request,
                ApiCallContext context,
                ApiFuture<ListReportDetailsResponse> futureResponse) {
              PageContext<ListReportDetailsRequest, ListReportDetailsResponse, ReportDetail>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPORT_DETAILS_PAGE_STR_DESC, request, context);
              return ListReportDetailsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listReportConfigs. */
  public PagedCallSettings<
          ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
      listReportConfigsSettings() {
    return listReportConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getReportConfig. */
  public UnaryCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigSettings() {
    return getReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to createReportConfig. */
  public UnaryCallSettings<CreateReportConfigRequest, ReportConfig> createReportConfigSettings() {
    return createReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateReportConfig. */
  public UnaryCallSettings<UpdateReportConfigRequest, ReportConfig> updateReportConfigSettings() {
    return updateReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteReportConfig. */
  public UnaryCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigSettings() {
    return deleteReportConfigSettings;
  }

  /** Returns the object with the settings used for calls to listReportDetails. */
  public PagedCallSettings<
          ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
      listReportDetailsSettings() {
    return listReportDetailsSettings;
  }

  /** Returns the object with the settings used for calls to getReportDetail. */
  public UnaryCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailSettings() {
    return getReportDetailSettings;
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

  public StorageInsightsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcStorageInsightsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStorageInsightsStub.create(this);
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
    return "storageinsights.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "storageinsights.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(StorageInsightsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StorageInsightsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StorageInsightsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected StorageInsightsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listReportConfigsSettings = settingsBuilder.listReportConfigsSettings().build();
    getReportConfigSettings = settingsBuilder.getReportConfigSettings().build();
    createReportConfigSettings = settingsBuilder.createReportConfigSettings().build();
    updateReportConfigSettings = settingsBuilder.updateReportConfigSettings().build();
    deleteReportConfigSettings = settingsBuilder.deleteReportConfigSettings().build();
    listReportDetailsSettings = settingsBuilder.listReportDetailsSettings().build();
    getReportDetailSettings = settingsBuilder.getReportDetailSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for StorageInsightsStubSettings. */
  public static class Builder extends StubSettings.Builder<StorageInsightsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings;
    private final UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings;
    private final UnaryCallSettings.Builder<CreateReportConfigRequest, ReportConfig>
        createReportConfigSettings;
    private final UnaryCallSettings.Builder<UpdateReportConfigRequest, ReportConfig>
        updateReportConfigSettings;
    private final UnaryCallSettings.Builder<DeleteReportConfigRequest, Empty>
        deleteReportConfigSettings;
    private final PagedCallSettings.Builder<
            ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
        listReportDetailsSettings;
    private final UnaryCallSettings.Builder<GetReportDetailRequest, ReportDetail>
        getReportDetailSettings;
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

      listReportConfigsSettings = PagedCallSettings.newBuilder(LIST_REPORT_CONFIGS_PAGE_STR_FACT);
      getReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReportConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReportDetailsSettings = PagedCallSettings.newBuilder(LIST_REPORT_DETAILS_PAGE_STR_FACT);
      getReportDetailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listReportConfigsSettings,
              getReportConfigSettings,
              createReportConfigSettings,
              updateReportConfigSettings,
              deleteReportConfigSettings,
              listReportDetailsSettings,
              getReportDetailSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(StorageInsightsStubSettings settings) {
      super(settings);

      listReportConfigsSettings = settings.listReportConfigsSettings.toBuilder();
      getReportConfigSettings = settings.getReportConfigSettings.toBuilder();
      createReportConfigSettings = settings.createReportConfigSettings.toBuilder();
      updateReportConfigSettings = settings.updateReportConfigSettings.toBuilder();
      deleteReportConfigSettings = settings.deleteReportConfigSettings.toBuilder();
      listReportDetailsSettings = settings.listReportDetailsSettings.toBuilder();
      getReportDetailSettings = settings.getReportDetailSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listReportConfigsSettings,
              getReportConfigSettings,
              createReportConfigSettings,
              updateReportConfigSettings,
              deleteReportConfigSettings,
              listReportDetailsSettings,
              getReportDetailSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listReportConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteReportConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listReportDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getReportDetailSettings()
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

    /** Returns the builder for the settings used for calls to listReportConfigs. */
    public PagedCallSettings.Builder<
            ListReportConfigsRequest, ListReportConfigsResponse, ListReportConfigsPagedResponse>
        listReportConfigsSettings() {
      return listReportConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getReportConfig. */
    public UnaryCallSettings.Builder<GetReportConfigRequest, ReportConfig>
        getReportConfigSettings() {
      return getReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createReportConfig. */
    public UnaryCallSettings.Builder<CreateReportConfigRequest, ReportConfig>
        createReportConfigSettings() {
      return createReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateReportConfig. */
    public UnaryCallSettings.Builder<UpdateReportConfigRequest, ReportConfig>
        updateReportConfigSettings() {
      return updateReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReportConfig. */
    public UnaryCallSettings.Builder<DeleteReportConfigRequest, Empty>
        deleteReportConfigSettings() {
      return deleteReportConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listReportDetails. */
    public PagedCallSettings.Builder<
            ListReportDetailsRequest, ListReportDetailsResponse, ListReportDetailsPagedResponse>
        listReportDetailsSettings() {
      return listReportDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to getReportDetail. */
    public UnaryCallSettings.Builder<GetReportDetailRequest, ReportDetail>
        getReportDetailSettings() {
      return getReportDetailSettings;
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
    public StorageInsightsStubSettings build() throws IOException {
      return new StorageInsightsStubSettings(this);
    }
  }
}
