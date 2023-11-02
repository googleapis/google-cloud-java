/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1.stub;

import static google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import google.maps.fleetengine.v1.CreateTripRequest;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.ReportBillableTripRequest;
import google.maps.fleetengine.v1.SearchTripsRequest;
import google.maps.fleetengine.v1.SearchTripsResponse;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.UpdateTripRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TripServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (fleetengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTrip to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TripServiceStubSettings.Builder tripServiceSettingsBuilder =
 *     TripServiceStubSettings.newBuilder();
 * tripServiceSettingsBuilder
 *     .createTripSettings()
 *     .setRetrySettings(
 *         tripServiceSettingsBuilder
 *             .createTripSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TripServiceStubSettings tripServiceSettings = tripServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TripServiceStubSettings extends StubSettings<TripServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateTripRequest, Trip> createTripSettings;
  private final UnaryCallSettings<GetTripRequest, Trip> getTripSettings;
  private final UnaryCallSettings<ReportBillableTripRequest, Empty> reportBillableTripSettings;
  private final PagedCallSettings<SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
      searchTripsSettings;
  private final UnaryCallSettings<UpdateTripRequest, Trip> updateTripSettings;

  private static final PagedListDescriptor<SearchTripsRequest, SearchTripsResponse, Trip>
      SEARCH_TRIPS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchTripsRequest, SearchTripsResponse, Trip>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchTripsRequest injectToken(SearchTripsRequest payload, String token) {
              return SearchTripsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchTripsRequest injectPageSize(SearchTripsRequest payload, int pageSize) {
              return SearchTripsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchTripsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchTripsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Trip> extractResources(SearchTripsResponse payload) {
              return payload.getTripsList() == null
                  ? ImmutableList.<Trip>of()
                  : payload.getTripsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
      SEARCH_TRIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>() {
            @Override
            public ApiFuture<SearchTripsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchTripsRequest, SearchTripsResponse> callable,
                SearchTripsRequest request,
                ApiCallContext context,
                ApiFuture<SearchTripsResponse> futureResponse) {
              PageContext<SearchTripsRequest, SearchTripsResponse, Trip> pageContext =
                  PageContext.create(callable, SEARCH_TRIPS_PAGE_STR_DESC, request, context);
              return SearchTripsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createTrip. */
  public UnaryCallSettings<CreateTripRequest, Trip> createTripSettings() {
    return createTripSettings;
  }

  /** Returns the object with the settings used for calls to getTrip. */
  public UnaryCallSettings<GetTripRequest, Trip> getTripSettings() {
    return getTripSettings;
  }

  /** Returns the object with the settings used for calls to reportBillableTrip. */
  public UnaryCallSettings<ReportBillableTripRequest, Empty> reportBillableTripSettings() {
    return reportBillableTripSettings;
  }

  /** Returns the object with the settings used for calls to searchTrips. */
  public PagedCallSettings<SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
      searchTripsSettings() {
    return searchTripsSettings;
  }

  /** Returns the object with the settings used for calls to updateTrip. */
  public UnaryCallSettings<UpdateTripRequest, Trip> updateTripSettings() {
    return updateTripSettings;
  }

  public TripServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTripServiceStub.create(this);
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
    return "fleetengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "fleetengine.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TripServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected TripServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTripSettings = settingsBuilder.createTripSettings().build();
    getTripSettings = settingsBuilder.getTripSettings().build();
    reportBillableTripSettings = settingsBuilder.reportBillableTripSettings().build();
    searchTripsSettings = settingsBuilder.searchTripsSettings().build();
    updateTripSettings = settingsBuilder.updateTripSettings().build();
  }

  /** Builder for TripServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TripServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateTripRequest, Trip> createTripSettings;
    private final UnaryCallSettings.Builder<GetTripRequest, Trip> getTripSettings;
    private final UnaryCallSettings.Builder<ReportBillableTripRequest, Empty>
        reportBillableTripSettings;
    private final PagedCallSettings.Builder<
            SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
        searchTripsSettings;
    private final UnaryCallSettings.Builder<UpdateTripRequest, Trip> updateTripSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(15000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(15000L))
              .setTotalTimeout(Duration.ofMillis(15000L))
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

      createTripSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTripSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportBillableTripSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchTripsSettings = PagedCallSettings.newBuilder(SEARCH_TRIPS_PAGE_STR_FACT);
      updateTripSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTripSettings,
              getTripSettings,
              reportBillableTripSettings,
              searchTripsSettings,
              updateTripSettings);
      initDefaults(this);
    }

    protected Builder(TripServiceStubSettings settings) {
      super(settings);

      createTripSettings = settings.createTripSettings.toBuilder();
      getTripSettings = settings.getTripSettings.toBuilder();
      reportBillableTripSettings = settings.reportBillableTripSettings.toBuilder();
      searchTripsSettings = settings.searchTripsSettings.toBuilder();
      updateTripSettings = settings.updateTripSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTripSettings,
              getTripSettings,
              reportBillableTripSettings,
              searchTripsSettings,
              updateTripSettings);
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
          .createTripSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTripSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reportBillableTripSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchTripsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTripSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createTrip. */
    public UnaryCallSettings.Builder<CreateTripRequest, Trip> createTripSettings() {
      return createTripSettings;
    }

    /** Returns the builder for the settings used for calls to getTrip. */
    public UnaryCallSettings.Builder<GetTripRequest, Trip> getTripSettings() {
      return getTripSettings;
    }

    /** Returns the builder for the settings used for calls to reportBillableTrip. */
    public UnaryCallSettings.Builder<ReportBillableTripRequest, Empty>
        reportBillableTripSettings() {
      return reportBillableTripSettings;
    }

    /** Returns the builder for the settings used for calls to searchTrips. */
    public PagedCallSettings.Builder<
            SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
        searchTripsSettings() {
      return searchTripsSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrip. */
    public UnaryCallSettings.Builder<UpdateTripRequest, Trip> updateTripSettings() {
      return updateTripSettings;
    }

    @Override
    public TripServiceStubSettings build() throws IOException {
      return new TripServiceStubSettings(this);
    }
  }
}
