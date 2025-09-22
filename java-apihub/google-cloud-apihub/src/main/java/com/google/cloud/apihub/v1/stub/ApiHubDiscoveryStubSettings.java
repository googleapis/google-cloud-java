/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiObservationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.apihub.v1.DiscoveredApiObservation;
import com.google.cloud.apihub.v1.DiscoveredApiOperation;
import com.google.cloud.apihub.v1.GetDiscoveredApiObservationRequest;
import com.google.cloud.apihub.v1.GetDiscoveredApiOperationRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsResponse;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubDiscoveryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDiscoveredApiObservation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubDiscoveryStubSettings.Builder apiHubDiscoverySettingsBuilder =
 *     ApiHubDiscoveryStubSettings.newBuilder();
 * apiHubDiscoverySettingsBuilder
 *     .getDiscoveredApiObservationSettings()
 *     .setRetrySettings(
 *         apiHubDiscoverySettingsBuilder
 *             .getDiscoveredApiObservationSettings()
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
 * ApiHubDiscoveryStubSettings apiHubDiscoverySettings = apiHubDiscoverySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ApiHubDiscoveryStubSettings extends StubSettings<ApiHubDiscoveryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsSettings;
  private final UnaryCallSettings<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationSettings;
  private final PagedCallSettings<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsSettings;
  private final UnaryCallSettings<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          DiscoveredApiObservation>
      LIST_DISCOVERED_API_OBSERVATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveredApiObservationsRequest,
              ListDiscoveredApiObservationsResponse,
              DiscoveredApiObservation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveredApiObservationsRequest injectToken(
                ListDiscoveredApiObservationsRequest payload, String token) {
              return ListDiscoveredApiObservationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDiscoveredApiObservationsRequest injectPageSize(
                ListDiscoveredApiObservationsRequest payload, int pageSize) {
              return ListDiscoveredApiObservationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveredApiObservationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveredApiObservationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveredApiObservation> extractResources(
                ListDiscoveredApiObservationsResponse payload) {
              return payload.getDiscoveredApiObservationsList();
            }
          };

  private static final PagedListDescriptor<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          DiscoveredApiOperation>
      LIST_DISCOVERED_API_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveredApiOperationsRequest,
              ListDiscoveredApiOperationsResponse,
              DiscoveredApiOperation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveredApiOperationsRequest injectToken(
                ListDiscoveredApiOperationsRequest payload, String token) {
              return ListDiscoveredApiOperationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDiscoveredApiOperationsRequest injectPageSize(
                ListDiscoveredApiOperationsRequest payload, int pageSize) {
              return ListDiscoveredApiOperationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveredApiOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveredApiOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveredApiOperation> extractResources(
                ListDiscoveredApiOperationsResponse payload) {
              return payload.getDiscoveredApiOperationsList();
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
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          ListDiscoveredApiObservationsPagedResponse>
      LIST_DISCOVERED_API_OBSERVATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveredApiObservationsRequest,
              ListDiscoveredApiObservationsResponse,
              ListDiscoveredApiObservationsPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveredApiObservationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
                    callable,
                ListDiscoveredApiObservationsRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveredApiObservationsResponse> futureResponse) {
              PageContext<
                      ListDiscoveredApiObservationsRequest,
                      ListDiscoveredApiObservationsResponse,
                      DiscoveredApiObservation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DISCOVERED_API_OBSERVATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListDiscoveredApiObservationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          ListDiscoveredApiOperationsPagedResponse>
      LIST_DISCOVERED_API_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveredApiOperationsRequest,
              ListDiscoveredApiOperationsResponse,
              ListDiscoveredApiOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveredApiOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
                    callable,
                ListDiscoveredApiOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveredApiOperationsResponse> futureResponse) {
              PageContext<
                      ListDiscoveredApiOperationsRequest,
                      ListDiscoveredApiOperationsResponse,
                      DiscoveredApiOperation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISCOVERED_API_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListDiscoveredApiOperationsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listDiscoveredApiObservations. */
  public PagedCallSettings<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsSettings() {
    return listDiscoveredApiObservationsSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveredApiObservation. */
  public UnaryCallSettings<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationSettings() {
    return getDiscoveredApiObservationSettings;
  }

  /** Returns the object with the settings used for calls to listDiscoveredApiOperations. */
  public PagedCallSettings<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsSettings() {
    return listDiscoveredApiOperationsSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveredApi. */
  public UnaryCallSettings<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationSettings() {
    return getDiscoveredApiOperationSettings;
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

  public ApiHubDiscoveryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiHubDiscoveryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "apihub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "apihub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apihub.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ApiHubDiscoveryStubSettings.class))
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

  protected ApiHubDiscoveryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDiscoveredApiObservationsSettings =
        settingsBuilder.listDiscoveredApiObservationsSettings().build();
    getDiscoveredApiObservationSettings =
        settingsBuilder.getDiscoveredApiObservationSettings().build();
    listDiscoveredApiOperationsSettings =
        settingsBuilder.listDiscoveredApiOperationsSettings().build();
    getDiscoveredApiOperationSettings = settingsBuilder.getDiscoveredApiOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ApiHubDiscoveryStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiHubDiscoveryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDiscoveredApiObservationsRequest,
            ListDiscoveredApiObservationsResponse,
            ListDiscoveredApiObservationsPagedResponse>
        listDiscoveredApiObservationsSettings;
    private final UnaryCallSettings.Builder<
            GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
        getDiscoveredApiObservationSettings;
    private final PagedCallSettings.Builder<
            ListDiscoveredApiOperationsRequest,
            ListDiscoveredApiOperationsResponse,
            ListDiscoveredApiOperationsPagedResponse>
        listDiscoveredApiOperationsSettings;
    private final UnaryCallSettings.Builder<
            GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
        getDiscoveredApiOperationSettings;
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

      listDiscoveredApiObservationsSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERED_API_OBSERVATIONS_PAGE_STR_FACT);
      getDiscoveredApiObservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDiscoveredApiOperationsSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERED_API_OPERATIONS_PAGE_STR_FACT);
      getDiscoveredApiOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDiscoveredApiObservationsSettings,
              getDiscoveredApiObservationSettings,
              listDiscoveredApiOperationsSettings,
              getDiscoveredApiOperationSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ApiHubDiscoveryStubSettings settings) {
      super(settings);

      listDiscoveredApiObservationsSettings =
          settings.listDiscoveredApiObservationsSettings.toBuilder();
      getDiscoveredApiObservationSettings =
          settings.getDiscoveredApiObservationSettings.toBuilder();
      listDiscoveredApiOperationsSettings =
          settings.listDiscoveredApiOperationsSettings.toBuilder();
      getDiscoveredApiOperationSettings = settings.getDiscoveredApiOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDiscoveredApiObservationsSettings,
              getDiscoveredApiObservationSettings,
              listDiscoveredApiOperationsSettings,
              getDiscoveredApiOperationSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listDiscoveredApiObservationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDiscoveredApiObservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDiscoveredApiOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDiscoveredApiOperationSettings()
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

    /** Returns the builder for the settings used for calls to listDiscoveredApiObservations. */
    public PagedCallSettings.Builder<
            ListDiscoveredApiObservationsRequest,
            ListDiscoveredApiObservationsResponse,
            ListDiscoveredApiObservationsPagedResponse>
        listDiscoveredApiObservationsSettings() {
      return listDiscoveredApiObservationsSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveredApiObservation. */
    public UnaryCallSettings.Builder<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
        getDiscoveredApiObservationSettings() {
      return getDiscoveredApiObservationSettings;
    }

    /** Returns the builder for the settings used for calls to listDiscoveredApiOperations. */
    public PagedCallSettings.Builder<
            ListDiscoveredApiOperationsRequest,
            ListDiscoveredApiOperationsResponse,
            ListDiscoveredApiOperationsPagedResponse>
        listDiscoveredApiOperationsSettings() {
      return listDiscoveredApiOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveredApi. */
    public UnaryCallSettings.Builder<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
        getDiscoveredApiOperationSettings() {
      return getDiscoveredApiOperationSettings;
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
    public ApiHubDiscoveryStubSettings build() throws IOException {
      return new ApiHubDiscoveryStubSettings(this);
    }
  }
}
