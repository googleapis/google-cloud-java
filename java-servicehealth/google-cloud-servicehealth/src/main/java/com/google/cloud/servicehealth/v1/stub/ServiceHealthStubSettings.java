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

package com.google.cloud.servicehealth.v1.stub;

import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListLocationsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationImpactsPagedResponse;

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
import com.google.cloud.servicehealth.v1.Event;
import com.google.cloud.servicehealth.v1.GetEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest;
import com.google.cloud.servicehealth.v1.ListEventsRequest;
import com.google.cloud.servicehealth.v1.ListEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse;
import com.google.cloud.servicehealth.v1.OrganizationEvent;
import com.google.cloud.servicehealth.v1.OrganizationImpact;
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
 * Settings class to configure an instance of {@link ServiceHealthStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (servicehealth.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEvent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceHealthStubSettings.Builder serviceHealthSettingsBuilder =
 *     ServiceHealthStubSettings.newBuilder();
 * serviceHealthSettingsBuilder
 *     .getEventSettings()
 *     .setRetrySettings(
 *         serviceHealthSettingsBuilder
 *             .getEventSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceHealthStubSettings serviceHealthSettings = serviceHealthSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServiceHealthStubSettings extends StubSettings<ServiceHealthStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings;
  private final UnaryCallSettings<GetEventRequest, Event> getEventSettings;
  private final PagedCallSettings<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          ListOrganizationEventsPagedResponse>
      listOrganizationEventsSettings;
  private final UnaryCallSettings<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventSettings;
  private final PagedCallSettings<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsSettings;
  private final UnaryCallSettings<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>
      LIST_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEventsRequest injectToken(ListEventsRequest payload, String token) {
              return ListEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEventsRequest injectPageSize(ListEventsRequest payload, int pageSize) {
              return ListEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Event> extractResources(ListEventsResponse payload) {
              return payload.getEventsList() == null
                  ? ImmutableList.<Event>of()
                  : payload.getEventsList();
            }
          };

  private static final PagedListDescriptor<
          ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>
      LIST_ORGANIZATION_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrganizationEventsRequest injectToken(
                ListOrganizationEventsRequest payload, String token) {
              return ListOrganizationEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrganizationEventsRequest injectPageSize(
                ListOrganizationEventsRequest payload, int pageSize) {
              return ListOrganizationEventsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOrganizationEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrganizationEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OrganizationEvent> extractResources(
                ListOrganizationEventsResponse payload) {
              return payload.getOrganizationEventsList() == null
                  ? ImmutableList.<OrganizationEvent>of()
                  : payload.getOrganizationEventsList();
            }
          };

  private static final PagedListDescriptor<
          ListOrganizationImpactsRequest, ListOrganizationImpactsResponse, OrganizationImpact>
      LIST_ORGANIZATION_IMPACTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrganizationImpactsRequest,
              ListOrganizationImpactsResponse,
              OrganizationImpact>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrganizationImpactsRequest injectToken(
                ListOrganizationImpactsRequest payload, String token) {
              return ListOrganizationImpactsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrganizationImpactsRequest injectPageSize(
                ListOrganizationImpactsRequest payload, int pageSize) {
              return ListOrganizationImpactsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOrganizationImpactsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrganizationImpactsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OrganizationImpact> extractResources(
                ListOrganizationImpactsResponse payload) {
              return payload.getOrganizationImpactsList() == null
                  ? ImmutableList.<OrganizationImpact>of()
                  : payload.getOrganizationImpactsList();
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
          ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      LIST_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>() {
            @Override
            public ApiFuture<ListEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
                ListEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListEventsResponse> futureResponse) {
              PageContext<ListEventsRequest, ListEventsResponse, Event> pageContext =
                  PageContext.create(callable, LIST_EVENTS_PAGE_STR_DESC, request, context);
              return ListEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          ListOrganizationEventsPagedResponse>
      LIST_ORGANIZATION_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrganizationEventsRequest,
              ListOrganizationEventsResponse,
              ListOrganizationEventsPagedResponse>() {
            @Override
            public ApiFuture<ListOrganizationEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
                    callable,
                ListOrganizationEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListOrganizationEventsResponse> futureResponse) {
              PageContext<
                      ListOrganizationEventsRequest,
                      ListOrganizationEventsResponse,
                      OrganizationEvent>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORGANIZATION_EVENTS_PAGE_STR_DESC, request, context);
              return ListOrganizationEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          ListOrganizationImpactsPagedResponse>
      LIST_ORGANIZATION_IMPACTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrganizationImpactsRequest,
              ListOrganizationImpactsResponse,
              ListOrganizationImpactsPagedResponse>() {
            @Override
            public ApiFuture<ListOrganizationImpactsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
                    callable,
                ListOrganizationImpactsRequest request,
                ApiCallContext context,
                ApiFuture<ListOrganizationImpactsResponse> futureResponse) {
              PageContext<
                      ListOrganizationImpactsRequest,
                      ListOrganizationImpactsResponse,
                      OrganizationImpact>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORGANIZATION_IMPACTS_PAGE_STR_DESC, request, context);
              return ListOrganizationImpactsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return listEventsSettings;
  }

  /** Returns the object with the settings used for calls to getEvent. */
  public UnaryCallSettings<GetEventRequest, Event> getEventSettings() {
    return getEventSettings;
  }

  /** Returns the object with the settings used for calls to listOrganizationEvents. */
  public PagedCallSettings<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          ListOrganizationEventsPagedResponse>
      listOrganizationEventsSettings() {
    return listOrganizationEventsSettings;
  }

  /** Returns the object with the settings used for calls to getOrganizationEvent. */
  public UnaryCallSettings<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventSettings() {
    return getOrganizationEventSettings;
  }

  /** Returns the object with the settings used for calls to listOrganizationImpacts. */
  public PagedCallSettings<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsSettings() {
    return listOrganizationImpactsSettings;
  }

  /** Returns the object with the settings used for calls to getOrganizationImpact. */
  public UnaryCallSettings<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactSettings() {
    return getOrganizationImpactSettings;
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

  public ServiceHealthStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcServiceHealthStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonServiceHealthStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "servicehealth";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "servicehealth.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "servicehealth.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ServiceHealthStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ServiceHealthStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceHealthStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ServiceHealthStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEventsSettings = settingsBuilder.listEventsSettings().build();
    getEventSettings = settingsBuilder.getEventSettings().build();
    listOrganizationEventsSettings = settingsBuilder.listOrganizationEventsSettings().build();
    getOrganizationEventSettings = settingsBuilder.getOrganizationEventSettings().build();
    listOrganizationImpactsSettings = settingsBuilder.listOrganizationImpactsSettings().build();
    getOrganizationImpactSettings = settingsBuilder.getOrganizationImpactSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ServiceHealthStubSettings. */
  public static class Builder extends StubSettings.Builder<ServiceHealthStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings;
    private final UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings;
    private final PagedCallSettings.Builder<
            ListOrganizationEventsRequest,
            ListOrganizationEventsResponse,
            ListOrganizationEventsPagedResponse>
        listOrganizationEventsSettings;
    private final UnaryCallSettings.Builder<GetOrganizationEventRequest, OrganizationEvent>
        getOrganizationEventSettings;
    private final PagedCallSettings.Builder<
            ListOrganizationImpactsRequest,
            ListOrganizationImpactsResponse,
            ListOrganizationImpactsPagedResponse>
        listOrganizationImpactsSettings;
    private final UnaryCallSettings.Builder<GetOrganizationImpactRequest, OrganizationImpact>
        getOrganizationImpactSettings;
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
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
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

      listEventsSettings = PagedCallSettings.newBuilder(LIST_EVENTS_PAGE_STR_FACT);
      getEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOrganizationEventsSettings =
          PagedCallSettings.newBuilder(LIST_ORGANIZATION_EVENTS_PAGE_STR_FACT);
      getOrganizationEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOrganizationImpactsSettings =
          PagedCallSettings.newBuilder(LIST_ORGANIZATION_IMPACTS_PAGE_STR_FACT);
      getOrganizationImpactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEventsSettings,
              getEventSettings,
              listOrganizationEventsSettings,
              getOrganizationEventSettings,
              listOrganizationImpactsSettings,
              getOrganizationImpactSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ServiceHealthStubSettings settings) {
      super(settings);

      listEventsSettings = settings.listEventsSettings.toBuilder();
      getEventSettings = settings.getEventSettings.toBuilder();
      listOrganizationEventsSettings = settings.listOrganizationEventsSettings.toBuilder();
      getOrganizationEventSettings = settings.getOrganizationEventSettings.toBuilder();
      listOrganizationImpactsSettings = settings.listOrganizationImpactsSettings.toBuilder();
      getOrganizationImpactSettings = settings.getOrganizationImpactSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEventsSettings,
              getEventSettings,
              listOrganizationEventsSettings,
              getOrganizationEventSettings,
              listOrganizationImpactsSettings,
              getOrganizationImpactSettings,
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
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOrganizationEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getOrganizationEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOrganizationImpactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getOrganizationImpactSettings()
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

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return listEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getEvent. */
    public UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings() {
      return getEventSettings;
    }

    /** Returns the builder for the settings used for calls to listOrganizationEvents. */
    public PagedCallSettings.Builder<
            ListOrganizationEventsRequest,
            ListOrganizationEventsResponse,
            ListOrganizationEventsPagedResponse>
        listOrganizationEventsSettings() {
      return listOrganizationEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getOrganizationEvent. */
    public UnaryCallSettings.Builder<GetOrganizationEventRequest, OrganizationEvent>
        getOrganizationEventSettings() {
      return getOrganizationEventSettings;
    }

    /** Returns the builder for the settings used for calls to listOrganizationImpacts. */
    public PagedCallSettings.Builder<
            ListOrganizationImpactsRequest,
            ListOrganizationImpactsResponse,
            ListOrganizationImpactsPagedResponse>
        listOrganizationImpactsSettings() {
      return listOrganizationImpactsSettings;
    }

    /** Returns the builder for the settings used for calls to getOrganizationImpact. */
    public UnaryCallSettings.Builder<GetOrganizationImpactRequest, OrganizationImpact>
        getOrganizationImpactSettings() {
      return getOrganizationImpactSettings;
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
    public ServiceHealthStubSettings build() throws IOException {
      return new ServiceHealthStubSettings(this);
    }
  }
}
